package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.RealNameBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class RealNameActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.et_real_surnames)
    EditText tv_surnames;
    @Bind(R.id.et_real_name)
    EditText tv_name;
    @Bind(R.id.et_real_card)
    EditText tv_card;
    @Bind(R.id.title_title)
    TextView title_title;

    LoadingDialog loadingDialog;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_real_name;
    }

    @Override
    protected void initData() {
        super.initData();

        title_title.setText("实名认证");
        loadingDialog = new LoadingDialog(this);
    }

    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String,String> parames=new HashMap<>();
        parames.put("lastName",tv_surnames.getText().toString());
        parames.put("firstName",tv_name.getText().toString());
        parames.put("idCard",tv_card.getText().toString());
        parames.put("userId", SP.get(this, SpContent.UserId,"")+"");
        parames.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.REALNAME,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @OnClick({R.id.title_back,R.id.tv_real_ok})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_real_ok:
                if(TextUtils.isEmpty(tv_surnames.getText())||TextUtils.isEmpty(tv_name.getText())||TextUtils.isEmpty(tv_card.getText())){
                    T.show("请您将个人信息补充完整");
                }else {
                    inithttp();
                }

                break;

        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.REALNAME:
                loadingDialog.cancel();
             RealNameBean realNameBean=GsonUtil.toObj(res, RealNameBean.class);
                if(realNameBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    if (realNameBean.isSuccess()) {

                    } else {
                        T.show(realNameBean.getMsg());
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
