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
 * 钱包
 */
public class MineBalanceActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView balanceTitle;
    @Bind(R.id.title_right)
    TextView titleRight;


    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_balance;
    }


    @Override
    public void initView() {
        initText();

    }

    private void initText() {
        balanceTitle.setText(getIntent().getStringExtra("name"));
        balanceTitle.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
        titleRight.setText(R.string.fine_balance);
        titleRight.setTextSize(14);
        titleRight.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @OnClick({R.id.title_back, R.id.bt_recharge, R.id.bt_withdrawals, R.id.tv_problem, R.id.title_right
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            /**
             * 余额明细
             */
            case R.id.title_right:
                Intent intent = new Intent(this, MineDetailedActivity.class);
                intent.putExtra("name", titleRight.getText().toString().trim());
                startActivity(intent);
                break;
            /**
             * 常见问题
             */
            case R.id.tv_problem:
                startActivity(new Intent(this, MineCommonProblemActivity.class));
                break;
            default:
                break;

        }


    }
}
