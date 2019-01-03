package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.google.zxing.WriterException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author jiangchao
 *         created at 2018/9/14 下午3:25
 */
public class WatchCourseTipActivity extends BaseNewActivity implements HttpCallBack {


    @Bind(R.id.btn_buy_course)
    Button btnBuyCourse;
    @Bind(R.id.iv_cancel_buy)
    ImageView ivCancelBuy;
    private String videoId;
    private double chargeAmount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_watch_course_tip;
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        chargeAmount = intent.getDoubleExtra("chargeAmount", 0);
        btnBuyCourse.setText(chargeAmount + "元购买");
        videoId = intent.getStringExtra("videoId");
    }

    @OnClick({R.id.btn_buy_course, R.id.iv_cancel_buy
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_buy_course:
//                Toast.makeText(this, "调支付", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WatchCourseTipActivity.this, BuyClassVideoActivity.class);
                intent.putExtra("videoId", videoId);
                intent.putExtra("chargeAmount", chargeAmount);
                startActivity(intent);
                break;
            case R.id.iv_cancel_buy:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
