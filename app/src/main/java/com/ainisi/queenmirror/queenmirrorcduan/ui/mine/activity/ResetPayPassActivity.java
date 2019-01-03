package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.TextUtils;
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
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.SetPayPessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.LoginCeshiBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
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
 * 重置密码
 */
public class ResetPayPassActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView resetTitle;
    @Bind(R.id.et_rest_phone)
    EditText resetPhone;
    @Bind(R.id.et_rest_loginpass)
    EditText resetLoginpass;
    @Bind(R.id.et_rest_verification)
    EditText resetVerification;
    @Bind(R.id.et_rest_cureenpass)
    EditText rextOldpass;
    @Bind(R.id.et_rest_new_password)
    EditText rextNewpass;
    @Bind(R.id.tv_validation)
    TextView validation;
    @Bind(R.id.et_graphics_validation)
    EditText evValidateCode;
    @Bind(R.id.re_graphics_validation)
    RelativeLayout reValidation;
    @Bind(R.id.iv_graphics_validation)
    ImageView ivValidation;
    private LoginCeshiBean ceshiBean;
    private String uuid;
    private String dataTime;
    private StringBuilder sb;
    private MyCountDownTimer myCountDownTimer;
    private boolean addvalidatecode = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_pay_pass;
    }

    @Override
    protected void initView() {
        super.initView();
        resetTitle.setText(getIntent().getStringExtra("paymodify"));
    }

    @Override
    protected void initData() {
        super.initData();
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
    }

    @OnClick({R.id.title_back, R.id.tv_ok_submit, R.id.tv_validation})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_ok_submit:
                if (TextUtils.isEmpty(resetLoginpass.getText())) {
                    T.show("登陆密码不能为空");
                } else if (TextUtils.isEmpty(resetVerification.getText())) {
                    T.show("手机验证码不能为空");
                } else if (TextUtils.isEmpty(rextOldpass.getText())) {
                    T.show("请您输入旧密码");
                } else if (TextUtils.isEmpty(rextNewpass.getText())) {
                    T.show("请你输入新的支付密码");
                } else {
                    inithttp();
                }

                break;
            case R.id.tv_validation:
                if (TextUtils.isEmpty(resetPhone.getText())) {
                    T.show("手机号不能为空");
                } else {
                    initKey();
                    initValidation();
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
        sb.append(2).append(uuid).append(resetPhone.getText().toString()).append(dataTime);
    }

    //获取验证码
    private void initValidation() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", resetPhone.getText().toString().trim());
        params.put("salt", uuid);
        params.put("signature", MD5.md5(sb.toString()));
        params.put("sysflag", "2");
        params.put("frontType", "C");
        params.put("token", SP.get(this, SpContent.UserToken,"")+"");
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
        parames.put("telNo", resetPhone.getText().toString().trim());
        parames.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETSHAPE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("cellPhone", resetPhone.getText().toString());
        parames.put("loginPass", MD5.md5(resetLoginpass.getText().toString() + "MYN888"));
        parames.put("verifyCodeCust", resetVerification.getText().toString());
        parames.put("oldPayPass", MD5.md5(rextOldpass.getText().toString() + "MYN888"));
        parames.put("payPass", MD5.md5(rextNewpass.getText().toString() + "MYN888"));
        parames.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.AMENTPAY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.AMENTPAY:
                SetPayPessBean payPessBean = GsonUtil.toObj(res, SetPayPessBean.class);
                if(payPessBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (payPessBean.isSuccess()) {
                        T.show(payPessBean.getMsg());
                        Intent intent = new Intent(ResetPayPassActivity.this, LoginActivity.class);
                        intent.putExtra("activite","no");
                        startActivity(intent);
                    } else {
                        T.show(payPessBean.getMsg());
                    }
                }
                break;
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
                        String vConfig = ceshiBean.getBody().getVerifyCode();
                    } else {
                        if (ceshiBean.getErrorCode().equals("3")) {
                            reValidation.setVisibility(View.VISIBLE);
                            initgetShape();
                        }
                    }
                }
                break;
            //获取图形验证码
            case ACTION.GETSHAPE:
                GetShareBean getShareBean = GsonUtil.toObj(res, GetShareBean.class);
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
            //initValidation();
            validation.setClickable(true);
        }
    }
}
