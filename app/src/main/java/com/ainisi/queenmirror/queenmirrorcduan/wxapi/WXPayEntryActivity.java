package com.ainisi.queenmirror.queenmirrorcduan.wxapi;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.DealSuccessActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MinePinTuanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitPinTuanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MajorClassDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineQueenCardPayActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.RechargeActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.RechargeSuccessAgainActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 测试
 *
 * @author jiangchao
 * created at 2018/7/5 下午8:18
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;
    public static final String APP_ID = "wxc3a8d687d3fd120d";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);

        api = WXAPIFactory.createWXAPI(this, APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onResp(BaseResp resp) {

        L.e("***********************                  " + resp.errCode);

        switch (resp.errCode) {
            case 0:
                //成功

                if (SP.get(WXPayEntryActivity.this, SpContent.PayWhere, "").equals("1")) {
                    Intent intent = new Intent(WXPayEntryActivity.this, DealSuccessActivity.class);
                    intent.putExtra("payType", SubmitActivity.instance.type);
                    intent.putExtra("payMonet", SubmitActivity.instance.amount);
                    intent.putExtra("payId", SubmitActivity.instance.businessIds);
                    startActivity(intent);
                    SubmitActivity.instance.finish();
                } else if (SP.get(WXPayEntryActivity.this, SpContent.PayWhere, "").equals("2")) {
                    /**
                     * 充值
                     */
                    Intent intent = new Intent(WXPayEntryActivity.this, RechargeSuccessAgainActivity.class);
                    intent.putExtra("payStyle", RechargeActivity.instance.pay_type);
                    intent.putExtra("payMoney", RechargeActivity.instance.et_recharge_money.getText().toString());
                    startActivity(intent);
                } else if (SP.get(WXPayEntryActivity.this, SpContent.PayWhere, "").equals("3")) {
                  /*  Intent intent = new Intent(WXPayEntryActivity.this, RechargeSuccessAgainActivity.class);
                    intent.putExtra("payStyle", RechargeActivity.instance.pay_type);
                    intent.putExtra("payMoney", RechargeActivity.instance.et_recharge_money.getText().toString());
                    startActivity(intent);*/
                    /**
                     * 女王会员充值
                     */
                    MineQueenCardPayActivity.instance.finish();
                } else if (SP.get(WXPayEntryActivity.this, SpContent.PayWhere, "").equals("4")) {
                    Intent intent = new Intent(this, MinePinTuanActivity.class);
                    intent.putExtra("groupId", SubmitPinTuanActivity.instance.groupIds);
                    intent.putExtra("orderNo", SubmitPinTuanActivity.instance.businessIds);
                    intent.putExtra("payType", "1");
                    startActivity(intent);
                } else if (SP.get(WXPayEntryActivity.this, SpContent.PayWhere, "").equals("5")) {
//                    Intent intent = new Intent(WXPayEntryActivity.this, RechargeSuccessAgainActivity.class);
//                    intent.putExtra("payStyle", RechargeActivity.instance.pay_type);
//                    intent.putExtra("payMoney", RechargeActivity.instance.et_recharge_money.getText().toString());
//                    startActivity(intent);
                    T.show("支付成功");
//                        AfterPayData();
                    Intent intent = new Intent(WXPayEntryActivity.this, MajorClassDetailActivity.class);
                    startActivity(intent);
                }
                finish();
                break;
            case -1:
                //失败
                T.show("支付遇到问题，请联系客服人员");
                finish();
                SubmitActivity.instance.finish();
                break;
            case -2:
                //用户取消
                T.show("您取消了此次支付");
                finish();
                break;
        }

		/*if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.app_tip);
			builder.setMessage(getString(R.string.pay_result_callback_msg, String.valueOf(resp.errCode)));
			builder.show();
		}*/
    }
}