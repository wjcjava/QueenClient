package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.alipay.PayResult;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueeenCardPayStyle;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayInBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayWechatBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.wxapi.WXPayEntryActivity;
import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
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
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 女王会员充值
 */
public class MineQueenCardPayActivity extends BaseActivity implements HttpCallBack{

    @Bind(R.id.check_mine_queen_alipay)
    CheckBox check_mine_queen_alipay;
    @Bind(R.id.li_mine_queen_card_one)
    LinearLayout li_mine_queen_card_one;
    @Bind(R.id.li_mine_queen_card_two)
    LinearLayout li_mine_queen_card_two;
    @Bind(R.id.tv_queen_card_money)
    TextView tv_queen_card_money;
    @Bind(R.id.tv_mine_queen_card_buy)
    TextView tv_mine_queen_card_buy;
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_mine_queen_card_first_number)
    TextView tv_mine_queen_card_first_number;
    @Bind(R.id.tv_mine_queen_card_first_yuefen)
    TextView tv_mine_queen_card_first_yuefen;
    @Bind(R.id.tv_mine_queen_card_first_money)
    TextView tv_mine_queen_card_first_money;
    @Bind(R.id.tv_mine_queen_card_second_number)
    TextView tv_mine_queen_card_second_number;
    @Bind(R.id.tv_mine_queen_card_second_money)
    TextView tv_mine_queen_card_second_money;
    @Bind(R.id.tv_mine_queen_card_second_yuefen)
    TextView tv_mine_queen_card_second_yuefen;

    @Bind(R.id.iv_mine_queencard_title)
    CircleImageView iv_mine_queencard_title;
    @Bind(R.id.tv_user_name)
    TextView tv_user_name;
    @Bind(R.id.tv_queen_card_buy_pay_submit)
    TextView tv_queen_card_buy_pay_submit;
    @Bind(R.id.check_mine_queen_wechat)
    CheckBox check_mine_queen_wechat;
    String memberTypeId1="",memberTypeId2="",memberTypeId="";
    String payMoney1="",payMoney2="",payMoney="";

    private IWXAPI api;
    String nonce_str,appid,sign,mch_id,transId;
    String we_prepayId;
    String aliPayResult="";

    public static MineQueenCardPayActivity instance = null;

    @Override
    public int getLayoutId() {
        instance = this;
        return R.layout.activity_mine_queen_card_pay;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        title_title.setText("女王会员");

        String headPic = SP.get(this,SpContent.userHeadPic,"")+"";
        Glide.with(this).load(headPic).dontAnimate().into(iv_mine_queencard_title);
        tv_user_name.setText(SP.get(this,SpContent.UserName,"")+"");

        getPayNumberData();
    }

    /**
     * 获取开通月份数据
     */
    private void getPayNumberData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",SP.get(MineQueenCardPayActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETQUEENCARDPAYSTYLE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.check_mine_queen_wechat,R.id.check_mine_queen_alipay,R.id.li_mine_queen_card_two,R.id.li_mine_queen_card_one,
            R.id.tv_mine_queen_card_buy,R.id.title_back,R.id.tv_queen_card_buy_pay_submit})
    public void onClick(View view){
        switch (view.getId()){
            /**
             * 提交
             */
            case R.id.tv_queen_card_buy_pay_submit:
                if(check_mine_queen_wechat.isChecked()){
                    PayByWheat();
                }else if(check_mine_queen_alipay.isChecked()){
                    if(aliPayResult.equals("")) {
                        LoadData();
                    }else{
                        startPay();
                    }
                }
                break;
            case R.id.title_back:
                finish();
                break;
            /**
             * 购买记录
             */
            case R.id.tv_mine_queen_card_buy:
                Intent intent = new Intent(this,MineQueenCardBuyRecordActivity.class);
                startActivity(intent);
                break;
            /**
             * 1个月
             */
            case R.id.li_mine_queen_card_one:
                li_mine_queen_card_one.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.mine_queen_card_select));
                li_mine_queen_card_two.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.mine_queen_card_select_not));
                tv_queen_card_money.setText("¥"+payMoney1);
                memberTypeId = memberTypeId1;
                payMoney = payMoney1;
                break;
            /**
             * 3个月
             */
            case R.id.li_mine_queen_card_two:
                li_mine_queen_card_one.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.mine_queen_card_select_not));
                li_mine_queen_card_two.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.mine_queen_card_select));
                tv_queen_card_money.setText("¥"+payMoney2);
                memberTypeId = memberTypeId2;
                payMoney = payMoney2;
                break;
            case R.id.check_mine_queen_wechat:
                aliPayResult = "";
                check_mine_queen_wechat.setChecked(true);
                check_mine_queen_alipay.setChecked(false);
                break;
            case R.id.check_mine_queen_alipay:
                aliPayResult = "";
                check_mine_queen_wechat.setChecked(false);
                check_mine_queen_alipay.setChecked(true);
                break;
        }
    }

    /**
     * 微信支付
     */
    private void PayByWheat() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("custId", SP.get(MineQueenCardPayActivity.this, SpContent.UserId,"0")+"");
        parames.put("token", SP.get(this, SpContent.UserToken,"")+"");
        parames.put("platformType","3");
        parames.put("chargeAmount",payMoney);
        parames.put("spbillCreateIp",getIP(MineQueenCardPayActivity.this));
        parames.put("memberTypeId",memberTypeId);
        HttpUtils.doPost(ACTION.MINEQUEENCARDBUY,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }


    /**
     * 支付宝支付
     */
    private void LoadData() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("custId", SP.get(MineQueenCardPayActivity.this, SpContent.UserId,"0")+"");
        parames.put("platformType","3");
        parames.put("chargeAmount",payMoney);
        parames.put("token", SP.get(this, SpContent.UserToken,"")+"");
        parames.put("memberTypeId",memberTypeId);
        HttpUtils.doPost(ACTION.MINEQUEENCARDALIPY,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 购买支付宝支付
             */
            case ACTION.MINEQUEENCARDALIPY:
                PayInBean payInBeans = GsonUtil.toObj(res,PayInBean.class);
                if(payInBeans.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    aliPayResult = payInBeans.getBody().getAliPayResult();
                    transId = payInBeans.getBody().getTransId();
                    startPay();
                }
                break;
            /**
             * 购买微信支付
             */
            case ACTION.MINEQUEENCARDBUY:
                PayWechatBean payInBean = GsonUtil.toObj(res, PayWechatBean.class);
                if(payInBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    aliPayResult = payInBean.getBody().getOutTradeNo();
                    we_prepayId = payInBean.getBody().getMap().getPrepay_id();
                    nonce_str = payInBean.getBody().getMap().getNonce_str();
                    appid = payInBean.getBody().getMap().getAppid();
                    sign = payInBean.getBody().getMap().getSign();
                    mch_id = payInBean.getBody().getMap().getMch_id();
                }

                sendPayRequest();
                break;
            /**
             * 获取会员类型
             */
            case ACTION.GETQUEENCARDPAYSTYLE:
                MineQueeenCardPayStyle mineQueeenCardPayStyle = GsonUtil.toObj(res,MineQueeenCardPayStyle.class);

                if(mineQueeenCardPayStyle.isSuccess()&&mineQueeenCardPayStyle.getErrorCode().equals("0")){

                    tv_mine_queen_card_first_number.setText("赠"+mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(0).getGivenDays()+"天");
                    int yuefen = Integer.parseInt(mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(0).getPurchaseDays())/30;
                    tv_mine_queen_card_first_yuefen.setText(yuefen+"个月");
                    tv_mine_queen_card_first_money.setText("¥"+mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(0).getPrice());

                    tv_mine_queen_card_second_number.setText("赠"+mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(1).getGivenDays()+"天");
                    tv_mine_queen_card_second_money.setText("¥"+mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(1).getPrice());
                    int yuefen1 = Integer.parseInt(mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(1).getPurchaseDays())/30;
                    tv_mine_queen_card_second_yuefen.setText(yuefen1+"个月");

                    memberTypeId1 = mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(0).getId();
                    memberTypeId2 = mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(1).getId();
                    payMoney1 = mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(0).getPrice();
                    payMoney2 = mineQueeenCardPayStyle.getBody().getAnsQueenMemberTypeList().get(1).getPrice();
                    memberTypeId = memberTypeId1;
                    payMoney = payMoney1;

                    tv_queen_card_money.setText("¥"+payMoney1);
                }else{
                    T.show(mineQueeenCardPayStyle.getMsg());
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


    /**
     * 以下是支付宝部分
     */
    private static final int SDK_PAY_FLAG = 1;

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
                        //AfterPayData();
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

    private Thread payThread;
    private void startPay() {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(MineQueenCardPayActivity.this);
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

        req.sign = signNum(mch_id,we_prepayId,"Sign=WXPay",non_str,time_stamp,"Nnvwangmojingcduanweixinzhifu888");
        //3.调用微信支付sdk支付方法

        SP.put(MineQueenCardPayActivity.this,SpContent.PayWhere,"3");//代表是购买女王会员

        api.sendReq(req);
    }

    private String signNum(String partnerId,String prepayId,String packageValue,String nonceStr,String timeStamp,String key){

        String stringA=
                "appid="+ WXPayEntryActivity.APP_ID
                        +"&noncestr="+nonceStr
                        +"&package="+packageValue
                        +"&partnerid="+partnerId
                        +"&prepayid="+prepayId
                        +"&timestamp="+timeStamp;


        String stringSignTemp = stringA+"&key="+key;
        String sign = MD5.md5(stringSignTemp).toUpperCase();
        return  sign;
    }

    private String genNonceStr() {
        Random random = new Random();
        return MD5.md5(String.valueOf(random.nextInt(10000)));
    }

    /**
     * 生成时间戳
     * @return
     */
    private String genTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getIP(Context context){

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address))
                    {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        }
        catch (SocketException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
