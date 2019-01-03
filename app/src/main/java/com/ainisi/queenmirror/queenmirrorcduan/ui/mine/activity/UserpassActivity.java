package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class UserpassActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView passtitle;
    @Bind(R.id.et_userpass_phone)
    EditText et_userpass_phone;
    @Bind(R.id.et_userpass_verification)
    EditText et_userpass_verification;
    @Bind(R.id.et_userpass_pass)
    EditText et_userpass_pass;
    @Bind(R.id.tv_userpass_submit)
    TextView tv_userpass_submit;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,UserpassActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_userpass;
    }

    @Override
    public void initView() {
        passtitle.setText("重设密码");
    }
    @OnClick({R.id.title_back,R.id.tv_userpass_getcode,R.id.tv_userpass_submit})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_userpass_submit:
                if(et_userpass_phone.getText().toString().length() <11 ||et_userpass_pass.getText().toString().equals("0") || et_userpass_verification.getText().toString().equals("0")){
                    T.show("请完善相关信息");
                }else{
                    changeData();
                }
                break;
        }
    }
    /**
     * 修改密码
     */
    private void changeData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cellPhone", et_userpass_phone.getText().toString().trim());
        params.put("userPass", MD5.md5(et_userpass_pass.getText().toString()+"MYN888"));
        params.put("oldUserPass",MD5.md5(et_userpass_verification.getText().toString()+"MYN888"));
        params.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.CHANGEPASSWORD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.CHANGEPASSWORD:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.isSuccess()) {
                        T.show(successBean.getMsg());
                        finish();
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
