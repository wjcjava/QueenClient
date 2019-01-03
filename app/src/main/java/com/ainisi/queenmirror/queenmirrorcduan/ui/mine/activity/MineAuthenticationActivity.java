package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我要认证页面
 */

public class MineAuthenticationActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineAuthenticationActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_authentication;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_common_title.setText("我要认证");
    }


    @OnClick({R.id.iv_common_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_common_back:
                finish();
                break;
        }
    }


    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
