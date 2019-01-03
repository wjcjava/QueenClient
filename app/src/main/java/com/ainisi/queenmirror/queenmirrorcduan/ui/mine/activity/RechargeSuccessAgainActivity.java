package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class RechargeSuccessAgainActivity extends BaseNewActivity {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_recharge_success_paystyle)
    TextView tv_recharge_success_paystyle;
    @Bind(R.id.tv_recharge_success_money)
    TextView tv_recharge_success_money;
    String payStyle,payMoney;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge_success_again;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("充值详情");

        Intent intent = this.getIntent();
        payStyle = intent.getStringExtra("payStyle");
        payMoney = intent.getStringExtra("payMoney");
        if(payStyle.equals("1")){
            tv_recharge_success_paystyle.setText("支付宝");
        }else{
            tv_recharge_success_paystyle.setText("微信");
        }
        tv_recharge_success_money.setText(payMoney);
    }

    @OnClick({R.id.title_back,R.id.tv_charge_success_submit})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_charge_success_submit:
                finish();
                break;
        }
    }
}
