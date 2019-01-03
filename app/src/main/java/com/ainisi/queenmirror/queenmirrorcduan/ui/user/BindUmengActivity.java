package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.google.zxing.WriterException;
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
 * 作者：linxi on 2018/10/30 14:32
 * 邮箱：707078566@qq.com
 * 用途：绑定手机号
 */
public class BindUmengActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.tv_phonenumber)
    EditText mTvPhonenumber;
    @Bind(R.id.et_validation)
    EditText mEtValidation;
    @Bind(R.id.tv_validation)
    TextView mTvValidation;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private boolean addvalidatecode = false;
    private String tvValidation;
    private MyCountDownTimer myCountDownTimer;
    private Dialog mDialog;
    private String nickName, headPic, openId, loginToken, loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bindumeng;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        Intent intent = this.getIntent();
        nickName = intent.getStringExtra("nickName");
        headPic = intent.getStringExtra("headPic");
        openId = intent.getStringExtra("openId");
        loginToken = intent.getStringExtra("loginToken");
        loginFlag = intent.getStringExtra("loginFlag");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.tv_validation, R.id.bt_user_confirmregistration})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(mTvPhonenumber.getText().toString())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                }
                break;
            case R.id.bt_user_confirmregistration:
                if (TextUtils.isEmpty(mTvPhonenumber.getText().toString())) {
                    T.show("手机号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(mEtValidation.getText().toString())) {
                    T.show("请输入验证码");
                    return;
                }
                //传参数
                HashMap<String, String> params = new HashMap<>();
                params.put("loginFlag", loginFlag);
                params.put("openId", openId);
                params.put("loginToken", loginToken);
                params.put("cellPhone", mTvPhonenumber.getText().toString());
                params.put("nickName", nickName);
                params.put("headPic", headPic);
                params.put("contractConfirm", "1");
                params.put("verifyCode", mEtValidation.getText().toString());
                //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
                HttpUtils.doPost(ACTION.SNSUSERLOGORREG, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
                break;
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
        sb.append("2").append(uuid).append(mTvPhonenumber.getText().toString()).append(dataTime);
        initValidation();
    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", mTvPhonenumber.getText().toString().trim());
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

    //获取图形验证码
    private void initgetShape() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("telNo", mTvPhonenumber.getText().toString().trim());
        HttpUtils.doPost(ACTION.GETSHAPE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            //验证码获取
            case ACTION.VERIFY:
                LoginCeshiBean ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if (ceshiBean.isSuccess()) {
//                    re_graphics_validation.setVisibility(View.GONE);
                    myCountDownTimer.start();
                } else {
                    if (ceshiBean.getErrorCode().equals("3")) {
//                        re_graphics_validation.setVisibility(View.VISIBLE);
                        initgetShape();
                    } else {
                        T.show(ceshiBean.getMsg());
                    }
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
            case ACTION.SNSUSERLOGORREG:
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
                initKey();
                mDialog.dismiss();
            }
        });
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

    private void Login(LoginBean loginBean) {
        MobclickAgent.onProfileSignIn(loginBean.getBody().getToken());
        SP.put(BindUmengActivity.this, SpContent.UserId, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
        SP.put(BindUmengActivity.this, SpContent.UserCall, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
        SP.put(BindUmengActivity.this, SpContent.UserName, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserName());
        SP.put(BindUmengActivity.this, SpContent.userHeadPic, loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getHeadPic());
        SP.put(BindUmengActivity.this, SpContent.isLogin, "1");
        if (TextUtils.isEmpty(loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getUserPass())) {
            SP.put(BindUmengActivity.this, SpContent.isPassword, false);
        } else {
            SP.put(BindUmengActivity.this, SpContent.isPassword, true);
        }
        SP.put(BindUmengActivity.this, SpContent.UserToken, loginBean.getBody().getToken());
        SP.put(this, SpContent.Lickname, "");
        SP.put(this, SpContent.LickPhone, "");
        SP.put(this, SpContent.LickSex, "");
        SP.put(this, SpContent.Current, "0");
        setResult(RESULT_OK);
        finish();
    }
}
