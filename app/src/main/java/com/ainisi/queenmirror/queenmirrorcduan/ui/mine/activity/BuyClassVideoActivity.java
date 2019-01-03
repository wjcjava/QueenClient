package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.BuyClassByAlipayBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.BuyClassByWechatBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CountdownView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GsonUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.SystemUtil;
import com.ainisi.queenmirror.queenmirrorcduan.wxapi.WXPayEntryActivity;
import com.alipay.sdk.app.PayTask;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购买课程
 *
 * @author jiangchao
 *         created at 2018/9/12 上午10:52
 */
public class BuyClassVideoActivity extends BaseNewActivity implements HttpCallBack, CountdownView.OnCountdownEndListener {

    private static final String TAG = "BuyClassVideoActivity";
    @Bind(R.id.title_title)
    TextView commentTitle;
    @Bind(R.id.cb_alipay)
    CheckBox cbAlipay;
    @Bind(R.id.cb_wechat)
    CheckBox cbWechat;
    @Bind(R.id.btn_pay)
    Button btnPay;
    @Bind(R.id.tv_order_amount)
    TextView tvOrderAmount;
    private String chargeAmount;
    private String videoId;
    private String aliPayResult;
    private String aliPayTransId;
    private String wechatPayTransId;
    private String wechatPayOutTradeNo;
    private String mch_id;
    private String we_prepayId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_class_video;
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.ANS_SCHOOL_VIDEO_ALIPAY:
                BuyClassByAlipayBean buyClassByAlipayBean = GsonUtils.jsonToBean(res, BuyClassByAlipayBean.class);
                if (buyClassByAlipayBean.isSuccess()) {
                    if (buyClassByAlipayBean.getErrorCode().equals("6")) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        aliPayResult = buyClassByAlipayBean.getBody().getAliPayResult();
                        aliPayTransId = buyClassByAlipayBean.getBody().getTransId();
                        startPay();
                    }
                }
                Log.i(TAG, res);
                break;

            case ACTION.ANS_SCHOOL_VIDEO_WECHAT_PAY:
                BuyClassByWechatBean buyClassByWechatBean = GsonUtils.jsonToBean(res, BuyClassByWechatBean.class);
                if (buyClassByWechatBean.isSuccess()) {
                    if ("6".equals(buyClassByWechatBean.getErrorCode())) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        wechatPayOutTradeNo = buyClassByWechatBean.getBody().getOutTradeNo();
                        buyClassByWechatBean.getBody().getMap().getAppid();
                        mch_id = buyClassByWechatBean.getBody().getMap().getMch_id();
                        buyClassByWechatBean.getBody().getMap().getNonce_str();
                        buyClassByWechatBean.getBody().getMap().getSign();
                        we_prepayId = buyClassByWechatBean.getBody().getMap().getPrepay_id();
                        buyClassByWechatBean.getBody().getMap().getTrade_type();
                        sendPayRequest();
                    }

                }


                Log.i(TAG, res);
                break;
//            /**
//             * 调用支付宝之后调用
//             */
//            case ACTION.AliPayAfterRefresh:
//                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
//                if (successBean.getErrorCode().equals("6")) {
//                    T.show("您的账号已过期，请重新登录");
//                    Intent intent = new Intent(this, LoginActivity.class);
//                    intent.putExtra("activite", "no");
//                    startActivity(intent);
//                } else {
//                    if (successBean.isSuccess()) {
//                        Intent intent = new Intent(BuyClassVideoActivity.this, DealSuccessActivity.class);
//                        intent.putExtra("payType", "");
//                        intent.putExtra("payMonet", "");
//                        intent.putExtra("payId", "");
//                        startActivity(intent);
//
//                        finish();
//                    } else {
//                        T.show(successBean.getMsg());
//                    }
//                }
//                break;

            default:
                break;
        }
    }

    private static final int SDK_PAY_FLAG = 1;


    private void startPay() {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(BuyClassVideoActivity.this);
                Map<String, String> result = alipay.payV2(aliPayResult, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        payThread = new Thread(payRunnable);
        payThread.start();
    }

    private Thread payThread;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        T.show("支付成功");
//                        AfterPayData();
                        Intent intent = new Intent(BuyClassVideoActivity.this, MajorClassDetailActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        T.show("支付失败");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * 支付宝付款成功后调用
     */
    private void AfterPayData() {
//        HashMap<String, String> params = new HashMap<>();
//        params.put("outTradeNo", aliPayTransId);
//        params.put("token", SP.get(BuyClassVideoActivity.this, SpContent.UserToken, "") + "");
//        HttpUtils.doPost(ACTION.AliPayAfterRefresh, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);


    }

    private IWXAPI api;

    /**
     * 微信支付
     */
    private void sendPayRequest() {
        api = WXAPIFactory.createWXAPI(this, null);
        api.registerApp(WXPayEntryActivity.APP_ID);

        PayReq req = new PayReq();
        req.appId = WXPayEntryActivity.APP_ID;
        req.partnerId = mch_id;
        //预支付订单
        req.prepayId = we_prepayId;
        String non_str = genNonceStr();
        req.nonceStr = non_str;
        String time_stamp = genTimeStamp() + "";
        req.timeStamp = time_stamp;
        req.packageValue = "Sign=WXPay";

        req.sign = signNum(mch_id, we_prepayId, "Sign=WXPay", non_str, time_stamp, "Nnvwangmojingcduanweixinzhifu888");
        //3.调用微信支付sdk支付方法

        SP.put(BuyClassVideoActivity.this, SpContent.PayWhere, "5");//代表订单支付

        api.sendReq(req);
    }


    private String signNum(String partnerId, String prepayId, String packageValue, String nonceStr, String timeStamp, String key) {

        String stringA =
                "appid=" + WXPayEntryActivity.APP_ID
                        + "&noncestr=" + nonceStr
                        + "&package=" + packageValue
                        + "&partnerid=" + partnerId
                        + "&prepayid=" + prepayId
                        + "&timestamp=" + timeStamp;


        String stringSignTemp = stringA + "&key=" + key;
        String sign = MD5.md5(stringSignTemp).toUpperCase();
        return sign;
    }

    private String genNonceStr() {
        Random random = new Random();
        return MD5.md5(String.valueOf(random.nextInt(10000)));
    }

    /**
     * 生成时间戳
     *
     * @return
     */
    private String genTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override
    protected void initData() {
        super.initData();
        commentTitle.setText("支付订单");

        cbAlipay.setOnCheckedChangeListener(cbAlipayOnCheckedChangeListener);
        cbWechat.setOnCheckedChangeListener(cbWechatOnCheckedChangeListener);
        Intent intent = getIntent();
        chargeAmount = String.valueOf(intent.getDoubleExtra("chargeAmount", 0));
        videoId = intent.getStringExtra("videoId");
        tvOrderAmount.setText("¥" + chargeAmount);
        btnPay.setText("确认支付 ¥" + chargeAmount);
        CountdownView mCvCountdownViewTest2 = (CountdownView) findViewById(R.id.cv_countdownViewTest2);
        mCvCountdownViewTest2.setTag("test2");
        long time2 = (long) 15 * 60 * 1000;
        mCvCountdownViewTest2.start(time2);
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    CompoundButton.OnCheckedChangeListener cbAlipayOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                cbAlipay.setChecked(true);
                cbWechat.setChecked(false);
            } else {
                cbAlipay.setChecked(false);
                cbWechat.setChecked(true);
            }
        }
    };

    CompoundButton.OnCheckedChangeListener cbWechatOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                cbAlipay.setChecked(false);
                cbWechat.setChecked(true);
            } else {
                cbAlipay.setChecked(true);
                cbWechat.setChecked(false);
            }
        }
    };
//    @Override
//    public void onEnd(CountdownView cv) {
    // 倒计时结束时调用该方法
//        Object tag = cv.getTag();

//        Log.i(TAG,cv.getDay()+cv.getHour()+cv.getMinute()+cv.getSecond()+"");

//        if (null != tag) {
//            Log.i(TAG, "tag = " + tag.toString());
//        }else {
//            Log.i(TAG, "tag = " + tag.toString());
//        }
//        Toast.makeText(this, "订单超时了", Toast.LENGTH_SHORT).show();
//    }

    @OnClick({R.id.title_back, R.id.btn_pay
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.btn_pay:
//                chargeAmount = tvOrderAmount.getText().toString().replace("¥", "");
                if (cbAlipay.isChecked()) {
                    buyClassByAlipay(videoId, chargeAmount);
//                    Toast.makeText(this, "支付宝支付", Toast.LENGTH_SHORT).show();
                } else {
                    buyClassByWechatPay(videoId, chargeAmount);
//                    Toast.makeText(this, "微信支付", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void buyClassByWechatPay(String videoId, String chargeAmount) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoId", videoId);
        map.put("token", SP.get(this, SpContent.UserToken, "") + "");
        map.put("chargeAmount", chargeAmount);
        map.put("platformType", "3");
        map.put("spbillCreateIp", SystemUtil.getHostIP());//IP地址
        HttpUtils.doPost(ACTION.ANS_SCHOOL_VIDEO_WECHAT_PAY, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    private void buyClassByAlipay(String videoId, String chargeAmount) {
        HashMap<String, String> map = new HashMap<>();
        map.put("videoId", videoId);
        map.put("token", SP.get(this, SpContent.UserToken, "") + "");
        map.put("chargeAmount", chargeAmount);
        map.put("platformType", "3");
        HttpUtils.doPost(ACTION.ANS_SCHOOL_VIDEO_ALIPAY, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onEnd(CountdownView cv) {

        // 倒计时结束时调用该方法
        Object tag = cv.getTag();
        if (null != tag) {
            Log.i("wg", "tag = " + tag.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
