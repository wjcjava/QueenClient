package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

public class AmentPayActivity extends BaseNewActivity implements HttpCallBack {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ament_pay;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        inithttpAment();
    }

    private void inithttpAment() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId", SP.get(AmentPayActivity.this, SpContent.UserToken,"")+"");//用户ID
        parames.put("verifyCodeCust", "");//用户获取到的验证码
        parames.put("payPass", "");//新支付密码
        parames.put("oldPayPass", "");
        HttpUtils.doPost(ACTION.AMENTPAY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.AMENTPAY:
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
