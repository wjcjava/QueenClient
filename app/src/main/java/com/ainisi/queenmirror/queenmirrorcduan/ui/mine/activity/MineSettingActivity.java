package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的钱包-支付设置-支付密码
 */
public class MineSettingActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView setText;
    @Bind(R.id.tv_pay_modify)
    TextView payModify;
    @Bind(R.id.tv_pay_back)
    TextView payBack;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineSettingActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_setting;
    }

    @Override
    public void initView() {
        initText();

    }

    private void initText() {
        setText.setText(R.string.payment_setting);
        setText.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
    }

    @OnClick({R.id.title_back, R.id.layout_pay_modify, R.id.layout_pay_back})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //修改支付密码
            case R.id.layout_pay_modify:
                Intent intent=new Intent(this,ResetPayPassActivity.class);
                intent.putExtra("paymodify",payModify.getText().toString());
                startActivity(intent);
                break;
            //找回支付密码
            case R.id.layout_pay_back:
                Intent intent1=new Intent(this,BackPayActivity.class);
                intent1.putExtra("payback",payBack.getText().toString().trim());
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
