package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayInBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayPassCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayRefreshBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayWechatBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.QueenPayBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.ModifyPayActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.BaseDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DownTimerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OnCountDownTimerListener;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.wxapi.WXPayEntryActivity;
import com.alipay.sdk.app.PayTask;
import com.lzy.okgo.cache.CacheMode;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 支付订单
 */
public class SubmitActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.tv_submit_price)
    TextView tv_submit_price;
    @Bind(R.id.tv_submit_bottom_price)
    TextView tv_submit_bottom_price;
    @Bind(R.id.check_wechat)
    CheckBox check_wechat;
    @Bind(R.id.check_alipay)
    CheckBox check_alipay;
    @Bind(R.id.check_queen)
    CheckBox check_queen;
    @Bind(R.id.check_balance)
    CheckBox check_balance;
    @Bind(R.id.dt_submit_downtime)
    DownTimerView dt_submit_downtime;//倒计时
    @Bind(R.id.re_queen)
    RelativeLayout re_queen;

    public String businessIds = "";
    String transId = "", input_pass = "", outTradeNo = "";
    public String amount = "0", aliPayResult = "", type = "0";
    String nonce_str, appid, sign, mch_id;
    private static final int SDK_PAY_FLAG = 1;

    private IWXAPI api;
    String we_prepayId;
    String submitId;
    LoadingDialog loadingDialog;
    private boolean isseckill;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
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
                        AfterPayData();
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
    private Thread payThread;
    private BaseDialog dialog;

    public static SubmitActivity instance = null;

    @Override
    public int getLayoutId() {
        instance = this;
        return R.layout.activity_submit;
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        businessIds = intent.getStringExtra("businessIds");
        amount = intent.getStringExtra("amount");
        submitId = intent.getStringExtra("submitId");
        isseckill = intent.getBooleanExtra("isseckill", false);

        if (amount.substring(0, 1).equals("¥")) {
            tv_submit_price.setText(amount);
            tv_submit_bottom_price.setText(amount);
        } else {
            tv_submit_price.setText("¥" + amount);
            tv_submit_bottom_price.setText("¥" + amount);
        }
        //秒杀 true 非秒杀 false
        if (isseckill == true) {
            dt_submit_downtime.setDownTime(300000);
        } else {
            dt_submit_downtime.setDownTime(900000);
        }
        startDownTimer();

        initEvent();
    }

    private void initEvent() {
        dt_submit_downtime.setDownTimerListener(new OnCountDownTimerListener() {

            @Override
            public void onFinish() {
                Toast.makeText(SubmitActivity.this, "当前订单已失效，请重新下单", Toast.LENGTH_SHORT)
                        .show();
//                if (isseckill == true) {
//                    CancelOrderData();
//                } else {
                    finish();
//                }
            }
        });
    }

    private void startDownTimer() {
        dt_submit_downtime.startDownTimer();
    }

    @Override
    public void onStop() {
        super.onStop();
        dt_submit_downtime.cancelDownTimer();
    }

    @OnClick({R.id.title_back, R.id.check_wechat, R.id.check_alipay, R.id.check_queen, R.id.check_balance, R.id.payV2})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
//                if (isseckill == true) {
//                    CancelOrderData();
//                } else {
                    finish();
//                }
                break;
            case R.id.check_wechat:
                if (check_wechat.isChecked()) {
                    check_alipay.setChecked(false);
                    check_queen.setChecked(false);
                    check_balance.setChecked(false);
                }
                break;
            case R.id.check_alipay:
                if (check_alipay.isChecked()) {
                    check_wechat.setChecked(false);
                    check_queen.setChecked(false);
                    check_balance.setChecked(false);
                }
                break;
            case R.id.check_queen:
                if (check_queen.isChecked()) {
                    check_alipay.setChecked(false);
                    check_wechat.setChecked(false);
                    check_balance.setChecked(false);
                }
                break;
            case R.id.check_balance:
                if (check_balance.isChecked()) {
                    check_alipay.setChecked(false);
                    check_queen.setChecked(false);
                    check_wechat.setChecked(false);
                }
                break;
            case R.id.payV2:
                if (check_wechat.isChecked()) {
                    type = "0";
                    PayByWechatData();
                } else if (check_alipay.isChecked()) {
                    type = "1";
                    if (aliPayResult.equals("")) {
                        getData();
                    } else {
                        startPay();
                    }
                } else if (check_queen.isChecked()) {
                    type = "2";
                    CheckPayPass();
                } else if (check_balance.isChecked()) {
                    type = "3";
                    CheckPayPass();
                } else {
                    T.show("请选择支付方式");
                }
                break;
        }
    }


    private void showDialogs(int grary, int animationStyle) {
        final BaseDialog.Builder builder = new BaseDialog.Builder(SubmitActivity.this);
        final BaseDialog dialog = builder.setViewId(R.layout.pay_password_dialog)
                .setPaddingdp(10, 0, 10, 0)
                .setGravity(grary)
                .setAnimation(animationStyle)
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .isOnTouchCanceled(true)
                .builder();
        dialog.show();
        TextView tv_setting_pay_sub = dialog.getView(R.id.tv_setting_pay_sub);
        final EditText pass_edit = dialog.getView(R.id.et_pay_password_sub);
        tv_setting_pay_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass_edit.getText().toString().equals("")) {
                    T.show("请输入支付密码");
                } else {
                    input_pass = pass_edit.getText().toString();

                    if (type.equals("2")) {
                        PayInNvwangData();
                    } else if (type.equals("3")) {
                        PayInYueData();
                    }
                }
            }
        });
        ImageView dialogfinsh = dialog.getView(R.id.iv_dialog_finsh);
        final BaseDialog finalDialog = dialog;
        dialogfinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDialog.close();
            }
        });
    }

    /**
     * 微信支付获取
     */
    private void PayByWechatData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(SubmitActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        params.put("platformType", "3");
        if (amount.substring(0, 1).equals("¥")) {
            params.put("payAmount", amount.substring(1, amount.length()));
        } else {
            params.put("payAmount", amount);
        }
        params.put("submitId", submitId);
        params.put("businessIds", businessIds);
        params.put("spbillCreateIp", getIP(SubmitActivity.this));
        HttpUtils.doPost(ACTION.ORDERPAYBYWECHAT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    public static String getIP(Context context) {

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 余额支付
     */
    private void PayInYueData() {
        HashMap<String, String> params = new HashMap<>();
//        params.put("custId", SP.get(SubmitActivity.this, SpContent.UserId, "0") + "");
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        params.put("platformType", "3");
        if (amount.substring(0, 1).equals("¥")) {
            params.put("payAmount", amount.substring(1, amount.length()));
        } else {
            params.put("payAmount", amount);
        }
        params.put("submitId", submitId);
        params.put("businessIds", businessIds);
        params.put("payPass", MD5.md5(input_pass + "MYN888"));
        HttpUtils.doPost(ACTION.PAYINYUEDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 女王卡支付
     */
    private void PayInNvwangData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(SubmitActivity.this, SpContent.UserId, "0") + "");
        params.put("platformType", "3");
        if (amount.substring(0, 1).equals("¥")) {
            params.put("payAmount", amount.substring(1, amount.length()));
        } else {
            params.put("payAmount", amount);
        }
        params.put("businessIds", businessIds);
        params.put("payPass", MD5.md5(input_pass + "MYN888"));
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PAYUSENVWANGCARD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 女王卡支付成功后调用
     */
    private void PayInNvwangAfterData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("outTradeNo", outTradeNo);
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PAYAFTERREFRESH, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 判断支付密码是否存在
     */
    private void CheckPayPass() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(this, SpContent.UserId, "0") + "");
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PAYPASSWORDCHECK, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.paypass_dialog)
                .setPaddingdp(10, 0, 10, 0)
                .setGravity(grary)
                .setAnimation(animationStyle)
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .isOnTouchCanceled(true)
                .addViewOnClickListener(R.id.tv_setting_pay, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SubmitActivity.this, ModifyPayActivity.class);
                        startActivity(intent);
                    }
                })
                .builder();
        dialog.show();
        ImageView dialogfinsh = dialog.getView(R.id.iv_dialog_finsh);
        dialogfinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.close();
            }
        });
    }

    private void startPay() {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(SubmitActivity.this);
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

    /**
     * 支付前调用
     */
    private void getData() {

        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(SubmitActivity.this, SpContent.UserId, "0") + "");
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        params.put("platformType", "3");
        if (amount.substring(0, 1).equals("¥")) {
            params.put("payAmount", amount.substring(1, amount.length()));
        } else {
            params.put("payAmount", amount);
        }
        params.put("submitId", submitId);
        params.put("businessIds", businessIds);
        HttpUtils.doPost(ACTION.PayBefore, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 支付宝付款成功后调用
     */
    private void AfterPayData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("outTradeNo", transId);
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.AliPayAfterRefresh, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消订单
     */
    private void CancelOrderData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", businessIds);
        params.put("submitId", submitId);
        params.put("token", SP.get(SubmitActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CANCLEORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

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

        SP.put(SubmitActivity.this, SpContent.PayWhere, "1");//代表订单支付

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
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ORDERPAYBYWECHAT:
                /**
                 * 微信支付
                 */
                PayWechatBean payInBean = GsonUtil.toObj(res, PayWechatBean.class);
                if (payInBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    aliPayResult = payInBean.getBody().getOutTradeNo();
                    we_prepayId = payInBean.getBody().getMap().getPrepay_id();
                    nonce_str = payInBean.getBody().getMap().getNonce_str();
                    appid = payInBean.getBody().getMap().getAppid();
                    sign = payInBean.getBody().getMap().getSign();
                    mch_id = payInBean.getBody().getMap().getMch_id();

                    sendPayRequest();
                }

                break;
            /**
             * 余额支付
             */
            case ACTION.PAYINYUEDATA:
                QueenPayBean queenPayBeans = GsonUtil.toObj(res, QueenPayBean.class);
                if (queenPayBeans.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (queenPayBeans.isSuccess()) {
                        outTradeNo = queenPayBeans.getBody().getOutTradeNo();
                        Intent intent = new Intent(SubmitActivity.this, DealSuccessActivity.class);
                        intent.putExtra("payType", type);
                        intent.putExtra("payMonet", amount);
                        intent.putExtra("payId", businessIds);
                        startActivity(intent);

                        finish();

                    } else {
                        T.show(queenPayBeans.getMsg());
                    }
                }
                break;
            /**
             * 判断支付密码是否存在
             */
            case ACTION.PAYPASSWORDCHECK:
                PayPassCheckBean payPassCheckBean = GsonUtil.toObj(res, PayPassCheckBean.class);
                if (payPassCheckBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (payPassCheckBean.isSuccess() && payPassCheckBean.getErrorCode().equals("0")) {
                        if (payPassCheckBean.getBody().getIsExists() == 0) {
                            showDialog(Gravity.CENTER, R.style.Scale_aniamtion);
                        } else {
                            showDialogs(Gravity.CENTER, R.style.Scale_aniamtion);
                        }
                    } else {
                        T.show(payPassCheckBean.getMsg());
                    }
                }
                break;
            /**
             * 女王卡支付成功后刷新
             */
            case ACTION.PAYAFTERREFRESH:
                PayRefreshBean payRefreshBean = GsonUtil.toObj(res, PayRefreshBean.class);
                if (payRefreshBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (payRefreshBean.isSuccess()) {
                        if (payRefreshBean.getBody().getAnsChargeTrans().getTransStatus().equals("1")) {
                            finish();
                        } else {
                            T.show("支付出错，请联系客服人员");
                        }
                    } else {
                        T.show(payRefreshBean.getMsg());
                    }
                }
                break;
            /**
             * 女王卡支付
             */

            case ACTION.PAYUSENVWANGCARD:
                QueenPayBean queenPayBean = GsonUtil.toObj(res, QueenPayBean.class);
                if (queenPayBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (queenPayBean.isSuccess()) {
                        outTradeNo = queenPayBean.getBody().getOutTradeNo();
                        Intent intent = new Intent(SubmitActivity.this, DealSuccessActivity.class);
                        intent.putExtra("payType", type);
                        intent.putExtra("payMonet", amount);
                        intent.putExtra("payId", businessIds);
                        startActivity(intent);

                        finish();

                        //PayInNvwangAfterData();
                    } else {
                        T.show(queenPayBean.getMsg());
                    }
                }
                break;
            /**
             * 调用支付宝之后调用
             */
            case ACTION.AliPayAfterRefresh:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
                        Intent intent = new Intent(SubmitActivity.this, DealSuccessActivity.class);
                        intent.putExtra("payType", type);
                        intent.putExtra("payMonet", amount);
                        intent.putExtra("payId", businessIds);
                        startActivity(intent);

                        finish();
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            case ACTION.PayBefore:
                PayInBean payInBeans = GsonUtil.toObj(res, PayInBean.class);
                if (payInBeans.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    aliPayResult = payInBeans.getBody().getAliPayResult();
                    transId = payInBeans.getBody().getTransId();
                    startPay();
                }
                break;
            case ACTION.CANCLEORDER:
                finish();
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (isseckill == true) {
//                CancelOrderData();
//            } else {
//                finish();
//            }
//            return true;//不执行父类点击事件
//        }
//        return super.onKeyDown(keyCode, event);//继续执行父类其他点击事件
//    }
}
