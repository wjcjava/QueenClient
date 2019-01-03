package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.ForgetCipherBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import cz.msebera.android.httpclient.extras.Base64;

/**
 * 忘记密码
 */
public class ForgetcipherActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView loginTitle;
    @Bind(R.id.et_phonenumber)
    EditText phoneNumber;
    @Bind(R.id.et_validation)
    EditText etvalidation;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.iv_login_see)
    ImageView loginSee;
    @Bind(R.id.tv_validation)
    TextView validation;
    @Bind(R.id.et_graphics_validation)
    EditText evValidateCode;
    @Bind(R.id.re_graphics_validation)
    RelativeLayout reValidation;
    @Bind(R.id.iv_graphics_validation)
    ImageView ivValidation;
    private boolean click;
    private MyCountDownTimer myCountDownTimer;
    private LoginCeshiBean ceshiBean;
    private String vConfig;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private boolean addvalidatecode = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetcipher;
    }

    @Override
    protected void initView() {
        super.initView();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        initText();

        loginSee.setImageResource(R.drawable.icon_login_nosee);
        passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    private void initText() {
        loginTitle.setText(R.string.forgetcipher);
    }

    @OnClick({R.id.title_back, R.id.iv_remove_text, R.id.iv_login_see, R.id.tv_validation, R.id.bt_user_forgotpassword,R.id.iv_graphics_validation})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_remove_text:
                phoneNumber.setText("");
                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                    initValidation();
                }

                break;
            //密码是否可见
            case R.id.iv_login_see:
                if (click) {
                    loginSee.setImageResource(R.drawable.icon_login_nosee);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    click = false;
                } else {
                    //如果选中，显示密码
                    loginSee.setImageResource(R.drawable.icon_login_see);
                    passWord.setSelection(passWord.getText().length());
                    passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    click = true;
                }
                break;
            case R.id.bt_user_forgotpassword:

                if (TextUtils.isEmpty(validation.getText().toString()) ) {
                    T.show("请输入手机验证码");
                } else if(TextUtils.isEmpty(passWord.getText().toString())){
                    T.show("請输入新密码");
                }else {
                    HashMap<String, String> parames = new HashMap<>();
                    parames.put("cellPhone", phoneNumber.getText().toString().trim());
                    parames.put("verifyCodeCust", etvalidation.getText().toString().trim());
                    parames.put("userPass", MD5.md5(passWord.getText().toString() + "MYN888"));
                    HttpUtils.doPost(ACTION.FORGOTPASSWORD, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
                }

                break;
            case R.id.iv_graphics_validation:
                initgetShape();
                break;
        }


    }

    private void initKey() {
        //随机生成的UUID
        uuid = java.util.UUID.randomUUID().toString();
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

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", phoneNumber.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        if (addvalidatecode) {
            String tvValidation = evValidateCode.getText().toString();
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

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            //验证码获取
            case ACTION.VERIFY:
                ceshiBean = GsonUtil.toObj(res, LoginCeshiBean.class);
                if(ceshiBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (ceshiBean.isSuccess()) {
                        reValidation.setVisibility(View.GONE);
                        myCountDownTimer.start();
                        vConfig = ceshiBean.getBody().getVerifyCode();
                    } else {
                        if (ceshiBean.getErrorCode().equals("3")) {
                            reValidation.setVisibility(View.VISIBLE);
                            initgetShape();
                        }
                    }
                }
                break;
            /**
             * 获取图形验证码
             */
            case ACTION.GETSHAPE:
                GetShareBean getShareBean=GsonUtil.toObj(res,GetShareBean.class);
                if(getShareBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (getShareBean.isSuccess()) {
                        String imagestr = getShareBean.getBody().getImageStr();
                        if (!TextUtils.isEmpty(imagestr)) {
                            Bitmap image = stringtoBitmap(imagestr);
                            ivValidation.setImageBitmap(image);
                            addvalidatecode = true;
                        }
                    } else {
                        T.show(getShareBean.getMsg());
                    }
                }
                break;
            case ACTION.FORGOTPASSWORD:
                ForgetCipherBean cipherBean = GsonUtil.toObj(res, ForgetCipherBean.class);
                if(cipherBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (cipherBean.isSuccess()) {
                        T.show(cipherBean.getMsg());
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite","no");
                        startActivity(intent);
                    } else {
                        T.show(cipherBean.getMsg());
                    }
                }
                break;
        }
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
            validation.setClickable(false);
            validation.setText((l / 1000) + "s后重新获取");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给textview设置文字
            validation.setText("重新获取验证码");
            //设置可点击
            validation.setClickable(true);
        }
    }

}
