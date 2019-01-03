package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 到店付款
 */
public class PayInShopActivity extends BaseNewActivity implements HttpCallBack, View.OnClickListener {

    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_pay_arrow)
    TextView payArrow;
    private View popview;
    private PopupWindow popWindow;
    private CheckBox wechatPay;
    private CheckBox aliPay;
    private CheckBox queenPay;
    private CheckBox balancePay;
    private TextView tvBalance;
    private TextView tvQueen;
    private TextView tvAliPay;
    private TextView tvWechat;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_in_shop;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("这里是店铺名字");
    }

    @Override
    protected void initData() {
        super.initData();

    }

    private void initpop(View popview) {
        wechatPay = popview.findViewById(R.id.check_wechat);
        aliPay = popview.findViewById(R.id.check_alipay);
        queenPay = popview.findViewById(R.id.check_queen);
        balancePay = popview.findViewById(R.id.check_balance);
        tvWechat = popview.findViewById(R.id.tv_wechat);
        tvAliPay = popview.findViewById(R.id.tv_alipay);
        tvQueen = popview.findViewById(R.id.tv_queen);
        tvBalance = popview.findViewById(R.id.tv_balance);
        wechatPay.setOnClickListener(this);
        aliPay.setOnClickListener(this);
        queenPay.setOnClickListener(this);
        balancePay.setOnClickListener(this);
        popview.findViewById(R.id.li_confirm_pay).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_wechat:
                if (wechatPay.isChecked()) {
                    aliPay.setChecked(false);
                    queenPay.setChecked(false);
                    balancePay.setChecked(false);
                }
                break;
            case R.id.check_alipay:
                if (aliPay.isChecked()) {
                    wechatPay.setChecked(false);
                    queenPay.setChecked(false);
                    balancePay.setChecked(false);
                }
                break;
            case R.id.check_queen:
                if (queenPay.isChecked()) {
                    aliPay.setChecked(false);
                    wechatPay.setChecked(false);
                    balancePay.setChecked(false);
                }
                break;
            case R.id.check_balance:
                if (balancePay.isChecked()) {
                    aliPay.setChecked(false);
                    queenPay.setChecked(false);
                    wechatPay.setChecked(false);
                }
                break;
            case R.id.li_confirm_pay:
                popWindow.dismiss();
                lighton();
                if (wechatPay.isChecked()) {
                    payArrow.setText(tvWechat.getText());
                } else if (aliPay.isChecked()) {
                    payArrow.setText(tvAliPay.getText());
                } else if (queenPay.isChecked()) {
                    payArrow.setText(tvQueen.getText());
                } else if (balancePay.isChecked()) {
                    payArrow.setText(tvBalance.getText());
                }
                break;

        }
    }

    @OnClick({R.id.title_back, R.id.re_pay_way, R.id.tv_amountpay})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();

                break;
            case R.id.re_pay_way:
                lightoff();
                initshowpop();
                break;
            case R.id.tv_amountpay:
                if (payArrow.getText()!=null) {
                    T.show(payArrow.getText());
                } else {
                    if (payArrow.getText() == tvWechat.getText()) {
                        T.show("你选择了" + tvWechat.getText());

                    } else if (payArrow.getText() == tvAliPay.getText()) {
                        T.show("你选择了" + tvAliPay.getText());

                    } else if (payArrow.getText() == tvQueen.getText()) {
                        T.show("你选择了" + tvQueen.getText());

                    } else if (payArrow.getText() == tvBalance.getText()) {
                        T.show("你选择了" + tvBalance.getText());

                    }
                }
                break;
        }
    }

    /**
     * 设置手机屏幕亮度变暗
     */
    private void lightoff() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().setAttributes(lp);
    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }

    private void initshowpop() {
        if (popWindow == null) {
            popview = View.inflate(this, R.layout.pop_payinshop, null);
            initpop(popview);
            popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
            popWindow.setContentView(popview);
            popWindow.setOutsideTouchable(true);
            popWindow.setFocusable(true);
            popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);

            popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    lighton();
                }
            });
            popWindow.showAtLocation(PayInShopActivity.this.findViewById(R.id.layout_pay_inshop), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        } else {
            //如果popupWindow正在显示，接下来隐藏
            if (popWindow.isShowing()) {
                popWindow.dismiss();
            } else {
                //产生背景变暗效果
                lightoff();
                popWindow.showAtLocation(PayInShopActivity.this.findViewById(R.id.layout_pay_inshop), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
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