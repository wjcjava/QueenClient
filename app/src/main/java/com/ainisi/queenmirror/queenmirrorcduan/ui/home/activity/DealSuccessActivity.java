package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RedPacketOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.HomePageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 交易成功
 */
public class DealSuccessActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_deal_success_type)
    TextView tv_deal_success_type;//支付方式
    @Bind(R.id.tv_deal_success_money)
    TextView tv_deal_success_money;//支付金额
    @Bind(R.id.tv_deal_success_code)
    TextView tv_deal_success_code;//支付编号
    @Bind(R.id.tv_deal_success_buy)
    TextView tv_deal_success_buy;//继续购物
    @Bind(R.id.tv_deal_success_order)
    TextView tv_deal_success_order;//查看订单
    String payType,payMonet,payId;
    String money = "0",bottom,text;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deal_success;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("支付成功");

        Intent intent = this.getIntent();
        payType = intent.getStringExtra("payType");
        payMonet = intent.getStringExtra("payMonet");
        payId = intent.getStringExtra("payId");

        if(payType.equals("0")){
            tv_deal_success_type.setText("微信支付");
        }else if(payType.equals("1")){
            tv_deal_success_type.setText("支付宝支付");
        }else if(payType.equals("2")){
            tv_deal_success_type.setText("女王卡支付");
        }else if(payType.equals("3")){
            tv_deal_success_type.setText("余额支付");
        }else if(payType.equals("4")){
            tv_deal_success_type.setText("零元支付");
        }

        tv_deal_success_money.setText(payMonet);
        tv_deal_success_code.setText(payId);


        SuccessGetPacket();

    }

    /**
     *  判断是否是首次订单
     */
    private void SuccessGetPacket() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("flag","1");
        parames.put("platformType","1");//
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.ISFIRSTORDER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @OnClick({R.id.title_back,R.id.tv_deal_success_buy,R.id.tv_deal_success_order})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_deal_success_buy:
                finish();
                break;
            case R.id.tv_deal_success_order:
                SP.put(this, SpContent.Current,"2");
                Intent intent = new Intent(this,HomePageActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.ISFIRSTORDER:

                RedPacketOrderBean redPacketOrderBean = GsonUtil.toObj(res,RedPacketOrderBean.class);
                if(redPacketOrderBean.isSuccess()&&redPacketOrderBean.getErrorCode().equals("0")){
                    if(redPacketOrderBean.getBody().getStatus().equals("-1")){
                        /**
                         * 用户不符合条件
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("0")){
                        /**
                         * 首单红包不存在
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("1")){
                        /**
                         * 领取条件为非会员用户或者 领取条件为会员用户
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("2")){
                        /**
                         * 分情况
                         */
                        if(redPacketOrderBean.getBody().getHasReceive().equals("0")){
                            money = redPacketOrderBean.getBody().getAnsRedPacket().getRedPacketMoney();
                            bottom = redPacketOrderBean.getBody().getAnsRedPacket().getOpenButtonTitle();
                           text = redPacketOrderBean.getBody().getAnsRedPacket().getOpenBottomTitle();
                            DialogByRedOrder();
                        }else{
                        }
                    }
                }else{
                    T.show(redPacketOrderBean.getMsg());
                }
                break;
        }
    }

    private void DialogByRedOrder() {
        SP.put(DealSuccessActivity.this,SpContent.isRedPacket,"1");

        final AlertDialog.Builder builder = new AlertDialog.Builder(DealSuccessActivity.this,R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(DealSuccessActivity.this);
        View v = inflater.inflate(R.layout.homepage_red_packet_order_two, null);//注册
        final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

        ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);
        iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        TextView tv_red_packet_top = v.findViewById(R.id.tv_red_packet_top);
        tv_red_packet_top.setText(money);
        TextView tv_red_packet_bootom = v.findViewById(R.id.tv_red_packet_bootom);

        TextView tv_red_packet_regist = v.findViewById(R.id.tv_red_packet_regist);
        tv_red_packet_regist.setText(text);

        tv_red_packet_bootom.setText(bottom);
        tv_red_packet_bootom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(DealSuccessActivity.this,HomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}