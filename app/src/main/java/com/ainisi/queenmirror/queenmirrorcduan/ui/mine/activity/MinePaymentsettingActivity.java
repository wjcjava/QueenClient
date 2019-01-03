package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;


import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的钱包—支付设置
 */

public class MinePaymentsettingActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView settingTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_paymentsetting;
    }

    @Override
    public void initView() {
        settingTitle.setText(R.string.payment_setting);
        settingTitle.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
    }

    @OnClick({R.id.title_back, R.id.layout_setting})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //设置支付密码
            case R.id.layout_setting:
                Intent intent=new Intent(this, ModifyPayActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}