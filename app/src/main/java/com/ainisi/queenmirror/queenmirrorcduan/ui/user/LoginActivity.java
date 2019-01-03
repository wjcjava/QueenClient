package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginThridOpenidBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.extras.Base64;

public class LoginActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.et_login_pghone)
    public EditText et_login_pghone;
    @Bind(R.id.bt_login_submit)
    Button bt_login_submit;
    @Bind(R.id.et_login_pass)
    EditText et_login_pass;
    @Bind(R.id.user_reg_qq_login_view)
    ImageView user_reg_qq_login_view;
    @Bind(R.id.user_reg_wechat_login_view)
    ImageView user_reg_wechat_login_view;
    @Bind(R.id.check_choice)
    CheckBox choice;
    @Bind(R.id.re_graphics_validation)
    LinearLayout re_graphics_validation;
    @Bind(R.id.iv_graphics_validation)
    ImageView iv_graphics_validation;
    @Bind(R.id.et_graphics_validation)
    EditText et_graphics_validation;
    @Bind(R.id.tv_register)
    TextView tv_register;
    String nickName, headPic, openId, loginToken, loginFlag;
    @Bind(R.id.login_phone)
    TextView mLoginPhone;
    @Bind(R.id.login_psd)
    TextView mLoginPsd;
    @Bind(R.id.login_psd_ll)
    LinearLayout mLoginPsdLl;
    @Bind(R.id.et_validation)
    EditText mEtValidation;
    @Bind(R.id.tv_validation)
    TextView mTvValidation;
    @Bind(R.id.login_phone_ll)
    LinearLayout mLoginPhoneLl;
    private boolean addvalidatecode = false;
    private String tvValidation;
    SHARE_MEDIA platform;
    LoadingDialog loadingDialog;
    String activite;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private MyCountDownTimer myCountDownTimer;
    private String vConfig = "";
    private boolean isLogin = false;//手机验证true,密码false
    private Dialog mDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = this.getIntent();
        activite = intent.getStringExtra("activite");
        loadingDialog = new LoadingDialog(this);
        initTitle();
    }

    private void initTitle() {
        loginTitle.setText(R.string.login);
        title_back.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.login_cancel));
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        SpannableStringBuilder style = new SpannableStringBuilder();
        style.append("没有账号？点击去注册>>");
        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.putExtra("where", "login");
                startActivityForResult(intent, 1);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        style.setSpan(clickableSpan, 8, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(LoginActivity.this, R.color.color_FF0000));
        style.setSpan(foregroundColorSpan, 8, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //配置给TextView
        tv_register.setText(style);
        tv_register.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick({R.id.title_back, R.id.tv_forgetcipher, R.id.bt_login_submit, R.id.user_reg_qq_login_view, R.id.user_reg_weibo_login_view,
            R.id.user_reg_wechat_login_view, R.id.iv_graphics_validation, R.id.login_phone, R.id.login_psd, R.id.tv_validation})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_graphics_validation:
                initgetShape();
                break;
            case R.id.title_back:
                finish();
                break;
            //忘记密码
            case R.id.tv_forgetcipher:
                startActivity(new Intent(this, ForgetcipherActivity.class));
                break;
            /**
             * 登录按钮
             */
            case R.id.bt_login_submit:
                if (choice.isChecked()) {
                    SP.remove(this, SpContent.Remember);
                    LoginData();
                } else {
                    SP.put(this, SpContent.Remember, "0");
                    LoginData();
                }
                break;
            //qq
            case R.id.user_reg_qq_login_view:
                platform = SHARE_MEDIA.QQ;
                UMShareAPI.get(this).doOauthVerify(this, platform, authListener);
                loginFlag = "2";
                break;
            //微信
            case R.id.user_reg_wechat_login_view:
                platform = SHARE_MEDIA.WEIXIN;
                UMShareAPI.get(this).doOauthVerify(this, platform, authListener);
                loginFlag = "1";
                break;
            //微博
            case R.id.user_reg_weibo_login_view:
                platform = SHARE_MEDIA.SINA;
                UMShareAPI.get(this).doOauthVerify(this, platform, authListener);
                loginFlag = "3";
                break;
            //手机登录
            case R.id.login_phone:
                setLoginType(true);
                break;
            //密码登录
            case R.id.login_psd:
                setLoginType(false);
                break;
            //获取验证码
            case R.id.tv_validation:
                if (TextUtils.isEmpty(et_login_pghone.getText().toString())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 登录数据
     */
    private void LoginData() {
        if (TextUtils.isEmpty(et_login_pghone.getText().toString())) {
            T.show("请输入手机号");
            return;
        }
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", et_login_pghone.getText().toString());
        params.put("loginClient", "1");
        //手机登录
        if (isLogin) {
            params.put("uMengDeviceToken", SP.get(this, SpContent.UmengToken, "") + "");
            if (TextUtils.isEmpty(mEtValidation.getText().toString())) {
                T.show("请输入验证码");
                return;
            }
            params.put("verifyCode", mEtValidation.getText().toString());
//            params.put("loginIP", SystemUtil.getHostIP());
            HttpUtils.doPost(ACTION.USERLOGINBYVERIFYCODE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        } else {
            if (TextUtils.isEmpty(et_login_pass.getText().toString())) {
                T.show("请输入密码");
                return;
            }
            //密码登录
            params.put("userPass", MD5.md5(et_login_pass.getText().toString() + "MYN888"));
            if (addvalidatecode) {
//                tvValidation = et_graphics_validation.getText().toString();
                if (!TextUtils.isEmpty(tvValidation)) {
                    params.put("imgValidateCode", tvValidation);
                } else {
                    T.show("请您输入图形验证码");
                }
            }
            //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
            HttpUtils.doPost(ACTION.LOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        }
        loadingDialog.loadShow();
    }

    //获取图形验证码
    private void initgetShape() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("telNo", et_login_pghone.getText().toString().trim());
        HttpUtils.doPost(ACTION.GETSHAPE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            //登录
            case ACTION.LOGIN:
                loadingDialog.cancel();
                LoginBean loginBean = GsonUtil.toObj(res, LoginBean.class);
                if (loginBean.isSuccess()) {
                    Login(loginBean);
                } else {
                    T.show(loginBean.getMsg());
                    if (loginBean.getErrorCode().equals("3")) {
//                        re_graphics_validation.setVisibility(View.VISIBLE);
                        initgetShape();
                    } else {
//                        re_graphics_validation.setVisibility(View.GONE);
                    }
                }
                break;
            //第三方直接登录
            case ACTION.THIRDLOGINONE:
                loadingDialog.cancel();
                LoginBean loginBean1 = GsonUtil.toObj(res, LoginBean.class);
                if (loginBean1.isSuccess()) {
                    Login(loginBean1);
                } else {
                    T.show(loginBean1.getMsg());
                }
                break;
            case ACTION.CHECKOPENID:
                loadingDialog.cancel();
                LoginThridOpenidBean loginThridOpenidBean = GsonUtil.toObj(res, LoginThridOpenidBean.class);
                if (loginThridOpenidBean.isSuccess()) {
                    String isExists = loginThridOpenidBean.getBody().getExists();
                    if ("0".equals(isExists)) {
                        //不存在
//                        Intent intent = new Intent(LoginActivity.this, LoginThirdActivity.class);
                        Intent intent = new Intent(LoginActivity.this, BindUmengActivity.class);
                        intent.putExtra("nickName", nickName);
                        intent.putExtra("headPic", headPic);
                        intent.putExtra("openId", openId);
                        intent.putExtra("loginToken", loginToken);
                        intent.putExtra("loginFlag", loginFlag);
                        startActivityForResult(intent, 1);
                    } else {
                        //存在
                        ThirdLoginData();
                    }
                } else {
                    T.show(loginThridOpenidBean.getMsg());
                }
                break;
            case ACTION.GETSHAPE:
                GetShareBean getShareBean = GsonUtil.toObj(res, GetShareBean.class);
                if (getShareBean.isSuccess()) {
                    String imagestr = getShareBean.getBody().getImageStr();
                    if (!TextUtils.isEmpty(imagestr)) {
                        Bitmap image = stringtoBitmap(imagestr);
                        setDialog(image, getShareBean.getBody().getValidateCode());
//                        iv_graphics_validation.setImageBitmap(image);
//                        addvalidatecode = true;
                    }
                } else {
                    T.show(getShareBean.getMsg());
                }
                break;
            //验证码获取
            case ACTION.VERIFY:
                LoginCeshiBean ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
//                    re_graphics_validation.setVisibility(View.GONE);
                    myCountDownTimer.start();
                    vConfig = ceshiBean.getBody().getVerifyCode();
                } else {
                    if (ceshiBean.getErrorCode().equals("3")) {
//                        re_graphics_validation.setVisibility(View.VISIBLE);
                        initgetShape();
                    } else {
                        T.show(ceshiBean.getMsg());
                    }
                }
                break;
            //短信登录
            case ACTION.USERLOGINBYVERIFYCODE:
                loadingDialog.cancel();
                LoginBean loginBean2 = GsonUtil.toObj(res, LoginBean.class);
                if (loginBean2.isSuccess()) {
                    Login(loginBean2);
                } else {
                    T.show(loginBean2.getMsg());
                    if (loginBean2.getErrorCode().equals("3")) {
//                        re_graphics_validation.setVisibility(View.VISIBLE);
                        initgetShape();
                    } else {
//                        re_graphics_validation.setVisibility(View.GONE);
                    }
                }
                break;
            default:
                break;
        }
    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", et_login_pghone.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        if (addvalidatecode) {
//            tvValidation = et_graphics_validation.getText().toString();
            if (!TextUtils.isEmpty(tvValidation)) {
                params.put("imgValidateCode", tvValidation);
            } else {
                T.show("请您输入图形验证码");
            }
        }
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void Login(LoginBean loginBean) {
        MobclickAgent.onProfileSignIn(loginBean.getBody().getToken());
        SP.put(LoginActivity.this, SpContent.UserId, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
        SP.put(LoginActivity.this, SpContent.UserCall, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
        SP.put(LoginActivity.this, SpContent.UserName, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
        SP.put(LoginActivity.this, SpContent.userHeadPic, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getHeadPic());
        SP.put(LoginActivity.this, SpContent.isLogin, "1");
        if (TextUtils.isEmpty(loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserPass())) {
            SP.put(LoginActivity.this, SpContent.isPassword, false);
        } else {
            SP.put(LoginActivity.this, SpContent.isPassword, true);
        }
        SP.put(LoginActivity.this, SpContent.UserToken, loginBean.getBody().getToken());
        SP.put(this, SpContent.Lickname, "");
        SP.put(this, SpContent.LickPhone, "");
        SP.put(this, SpContent.LickSex, "");
        SP.put(this, SpContent.Current, "0");
        if (activite.equals("yes")) {
            Intent intent = new Intent(LoginActivity.this, HomeAdvertisingActivity.class);
            startActivity(intent);
        }
        finish();
    }

    private void initKey() {
        //随机生成的UUID
        uuid = UUID.randomUUID().toString();
        // HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        dataTime = simpleDateFormat.format(date);
        initPinjie();
    }

    private void initPinjie() {
        sb = new StringBuilder();
        sb.append("2").append(uuid).append(et_login_pghone.getText().toString()).append(dataTime);
        initValidation();
    }

    public static Bitmap stringtoBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 第三方直接登录
     */
    private void ThirdLoginData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("openId", openId);
        params.put("loginToken", loginToken);
        //   params.put("deviceToken", SP.get(this, SpContent.UmengToken, "") + "");
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.THIRDLOGINONE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, platform, new UMAuthListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {
                }

                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> data) {
                    nickName = data.get("name");
                    headPic = data.get("iconurl");
                    openId = data.get("uid");
                    loginToken = data.get("access_token");
                    CheckOpenIdData();
                }

                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {
                }
            });
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            T.show("失败" + t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            T.show("取消了");
        }
    };

    /**
     * 第三方登录OpenId检验
     */
    private void CheckOpenIdData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("openId", openId);
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.CHECKOPENID, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void setLoginType(boolean type) {
        isLogin = type;
        if (type) {
            mLoginPsdLl.setVisibility(View.GONE);
            mLoginPhoneLl.setVisibility(View.VISIBLE);
            mLoginPhone.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.grey_color1));
            mLoginPsd.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.order_number));
        } else {
            mLoginPsdLl.setVisibility(View.VISIBLE);
            mLoginPhoneLl.setVisibility(View.GONE);
            mLoginPhone.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.order_number));
            mLoginPsd.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.grey_color1));
        }
    }

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            mTvValidation.setClickable(false);
            mTvValidation.setText((l / 1000) + "s后重新获取");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            mTvValidation.setText("重新获取验证码");
            //设置可点击
            //initValidation();
            mTvValidation.setClickable(true);
        }
    }

    private void setDialog(Bitmap bitmap, final String validateCode) {
        if (mDialog == null) {
            mDialog = new Dialog(this, R.style.dialog);
        }
        View mView = LayoutInflater.from(this).inflate(R.layout.dialog_login, null);
        ImageView dialog_login_img = mView.findViewById(R.id.dialog_login_img);
        final EditText dialog_login_edt = mView.findViewById(R.id.dialog_login_edt);
        Button dialog_login_btn = mView.findViewById(R.id.dialog_login_btn);
        mDialog.setContentView(mView);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.show();
        // 将对话框的大小按屏幕大小的百分比设置
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth() * 0.7); //设置宽度
        mDialog.getWindow().setAttributes(lp);
        dialog_login_img.setImageBitmap(bitmap);
        ViewGroup.LayoutParams layoutParams = dialog_login_img.getLayoutParams();
        layoutParams.height = (int) (display.getWidth() * 0.2);
        dialog_login_img.setLayoutParams(layoutParams);
        dialog_login_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initgetShape();
            }
        });
        dialog_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = dialog_login_edt.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    T.show("请输入验证码");
                    return;
                }
                if (!s.equals(validateCode)) {
                    T.show("验证码输入不正确");
                    return;
                }
                addvalidatecode = true;
                tvValidation = s;
                if (isLogin) {
                    initKey();
                } else {
                    LoginData();
                }
                mDialog.dismiss();
            }
        });
    }
}
