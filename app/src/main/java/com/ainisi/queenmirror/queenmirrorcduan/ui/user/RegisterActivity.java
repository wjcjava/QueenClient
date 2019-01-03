package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
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
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.PhoneCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.analytics.MobclickAgent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.extras.Base64;

/**
 * 注册
 */
public class RegisterActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView registerTitle;
    @Bind(R.id.tv_phonenumber)
    EditText phoneNumber;
    @Bind(R.id.tv_validation)
    TextView validation;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.et_validation)
    EditText etValidation;
    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.iv_remove_text)
    ImageView removeText;
    @Bind(R.id.tv_regist_agreement)
    TextView tv_regist_agreement;
    @Bind(R.id.et_password_two)
    EditText mEtPasswordTwo;
    @Bind(R.id.et_graphics_validation)
    EditText evValidateCode;
    @Bind(R.id.re_graphics_validation)
    LinearLayout reValidation;
    @Bind(R.id.iv_graphics_validation)
    ImageView ivValidation;
    private MyCountDownTimer myCountDownTimer;
    private boolean click;
    private LoginCeshiBean ceshiBean;
    String vConfig = "";
    String nickName, headPic, openId, loginToken, where, loginFlag;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private String validationtext;
    private boolean addvalidatecode = false;
    private String tvValidation;
    private Dialog mDialog;
    private Dialog mLoginDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        registerTitle.setText(R.string.register);

        Intent intent = this.getIntent();
        where = intent.getStringExtra("where");

        if (where.equals("third")) {
            nickName = intent.getStringExtra("nickName");
            headPic = intent.getStringExtra("headPic");
            openId = intent.getStringExtra("openId");
            loginToken = intent.getStringExtra("loginToken");
            loginFlag = intent.getStringExtra("loginFlag");
        }
    }

    private void initKey() {
        //随机生成的UUID
        uuid = UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        dataTime = simpleDateFormat.format(date);

        initPinjie();
    }

    private void initPinjie() {
        sb = new StringBuilder();
        sb.append("2").append(uuid).append(phoneNumber.getText().toString()).append(dataTime);
    }

    @Override
    protected void initData() {
        super.initData();
        initRemoveText();

        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @OnClick({R.id.title_back, R.id.tv_validation, R.id.iv_remove_text, R.id.iv_login_see,
            R.id.bt_user_confirmregistration, R.id.tv_regist_agreement, R.id.iv_graphics_validation})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_regist_agreement:
                Intent intent = new Intent(this, RegistAgreementActivity.class);
                intent.putExtra("queryTitle", "用户协议");
                intent.putExtra("code", "2");
                startActivity(intent);
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(phoneNumber.getText())) {
                    T.show("手机号不能为空");
                } else {
                    initcheck();
                }
                break;
            case R.id.iv_remove_text:
                initRemoveText();
                break;
            case R.id.iv_login_see:
                initSee();
                break;
            case R.id.bt_user_confirmregistration:
                initregister();
                break;
            case R.id.iv_graphics_validation:
                initgetShape();
                break;
            default:
                break;
        }
    }

    private void initcheck() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", phoneNumber.getText().toString());
        HttpUtils.doPost(ACTION.PHONECHECK, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initregister() {
        if (TextUtils.isEmpty(phoneNumber.getText().toString())) {
            T.show("请输入手机号");
        } else if (etValidation.getText().toString().trim().equals("")) {
            T.show("请输入手机验证码");
        } else if (passWord.getText().toString().trim().equals("")) {
            T.show("请输入6-16位数字和字母组合");
        } else if (TextUtils.isEmpty(mEtPasswordTwo.getText().toString())) {
            T.show("请重复密码");
        } else if (!passWord.getText().toString().equals(mEtPasswordTwo.getText().toString())) {
            T.show("两次输入密码不一致");
        } else {
            HashMap<String, String> paramsRegister = new HashMap<>();
            paramsRegister.put("cellPhone", phoneNumber.getText().toString().trim());
            paramsRegister.put("userPass", MD5.md5(passWord.getText().toString() + "MYN888"));
            paramsRegister.put("contractConfirm", "1");
            paramsRegister.put("ifFirst", "0");
            paramsRegister.put("verifyCode", vConfig);
            validationtext = etValidation.getText().toString().trim();
            paramsRegister.put("verifyCodeCust", validationtext);
            paramsRegister.put("plamFrom", "3");
            HttpUtils.doPost(ACTION.REGIST, paramsRegister, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        }
    }

    private void login() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", phoneNumber.getText().toString().trim());
        params.put("loginClient", "1");
        params.put("userPass", MD5.md5(passWord.getText().toString() + "MYN888"));
        HttpUtils.doPost(ACTION.LOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initSee() {
        //判断第一次选中和第二次选中状态
        if (click) {
            loginSee.setImageResource(R.drawable.icon_login_nosee);
            passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
            click = false;
        } else {
            loginSee.setImageResource(R.drawable.icon_login_see);
            //如果选中，显示密码
            passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            click = true;
        }
    }

    private void initRemoveText() {
        phoneNumber.setText("");
        //手机号为空时隐藏
        if (!TextUtils.isEmpty(phoneNumber.getText())) {
            removeText.setVisibility(View.VISIBLE);
        }
        //手机号为空时
        else {
            removeText.setVisibility(View.GONE);
        }

    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        if (addvalidatecode) {
//            tvValidation = evValidateCode.getText().toString();
            if (!TextUtils.isEmpty(tvValidation)) {
                params.put("imgValidateCode", tvValidation);
            } else {
                T.show("请您输入图形验证码");
            }
        }
        HttpUtils.doPost(ACTION.VERIFY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    //获取图形验证码
    private void initgetShape() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("telNo", phoneNumber.getText().toString().trim());
        HttpUtils.doPost(ACTION.GETSHAPE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            //验证码获取
            case ACTION.VERIFY:
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
//                    reValidation.setVisibility(View.GONE);
                    myCountDownTimer.start();
                    vConfig = ceshiBean.getBody().getVerifyCode();
                } else {
                    if (ceshiBean.getErrorCode().equals("3")) {
//                        reValidation.setVisibility(View.VISIBLE);
                        initgetShape();
                    } else {
                        T.show(ceshiBean.getMsg());
                    }
                }
                break;
            case ACTION.REGIST://注册
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    if (where.equals("third")) {
                        Intent intent = new Intent(RegisterActivity.this, GuanLianActivity.class);
                        intent.putExtra("nickName", nickName);
                        intent.putExtra("headPic", headPic);
                        intent.putExtra("openId", openId);
                        intent.putExtra("loginToken", loginToken);
                        intent.putExtra("loginFlag", loginFlag);
                        startActivity(intent);
                    } else {
                        T.show("注册成功");
                        login();
                    }
                } else {
//                    reValidation.setVisibility(View.GONE);
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.PHONECHECK:
                PhoneCheckBean checkBean = GsonUtil.toObj(res, PhoneCheckBean.class);
                if (checkBean.isSuccess()) {
                    boolean exists = checkBean.getBody().isExists();
                    if (exists == true) {
                        setLoginDialog();
                    } else {
                        initKey();
                        initValidation();
                    }
                } else {
                    T.show(checkBean.getMsg());
                }
                break;
            case ACTION.GETSHAPE:
                GetShareBean getShareBean = GsonUtil.toObj(res, GetShareBean.class);
                if (getShareBean.isSuccess()) {
                    String imagestr = getShareBean.getBody().getImageStr();
                    if (!TextUtils.isEmpty(imagestr)) {
                        Bitmap image = stringtoBitmap(imagestr);
                        setDialog(image, getShareBean.getBody().getValidateCode());
//                        ivValidation.setImageBitmap(image);
//                        addvalidatecode=true;
                    }
                } else {
                    T.show(getShareBean.getMsg());
                }
                break;
            //登录
            case ACTION.LOGIN:
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
            default:
                break;
        }
    }

    @Override
    public void showLoadingDialog() {
    }

    @Override
    public void showErrorMessage(String s) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
            validation.setClickable(false);
            validation.setText((l / 1000) + "s后重新获取");
        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            validation.setText("重新获取验证码");
            //设置可点击
            //initValidation();
            validation.setClickable(true);
        }
    }

    private void Login(LoginBean loginBean) {
        MobclickAgent.onProfileSignIn(loginBean.getBody().getToken());
        SP.put(RegisterActivity.this, SpContent.UserId, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
        SP.put(RegisterActivity.this, SpContent.UserCall, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
        SP.put(RegisterActivity.this, SpContent.UserName, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
        SP.put(RegisterActivity.this, SpContent.userHeadPic, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getHeadPic());
        SP.put(RegisterActivity.this, SpContent.isLogin, "1");
        SP.put(RegisterActivity.this, SpContent.UserToken, loginBean.getBody().getToken());
        if (TextUtils.isEmpty(loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserPass())) {
            SP.put(RegisterActivity.this, SpContent.isPassword, false);
        } else {
            SP.put(RegisterActivity.this, SpContent.isPassword, true);
        }
        SP.put(this, SpContent.Lickname, "");
        SP.put(this, SpContent.LickPhone, "");
        SP.put(this, SpContent.LickSex, "");
        SP.put(this, SpContent.Current, "0");
        setResult(RESULT_OK);
        finish();
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
                initKey();
                mDialog.dismiss();
            }
        });
    }

    private void setLoginDialog() {
        if (mLoginDialog == null)
            mLoginDialog = new Dialog(this, R.style.dialog);
        View mView = LayoutInflater.from(this).inflate(R.layout.dialog_register, null);
        TextView dialog_register_login = mView.findViewById(R.id.dialog_register_login);
        mLoginDialog.setContentView(mView);
        mLoginDialog.setCanceledOnTouchOutside(true);
        mLoginDialog.show();
        // 将对话框的大小按屏幕大小的百分比设置
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = mLoginDialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth() * 0.7); //设置宽度
        mLoginDialog.getWindow().setAttributes(lp);
        dialog_register_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginDialog.dismiss();
                finish();
            }
        });
    }
}