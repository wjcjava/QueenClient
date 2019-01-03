package com.ainisi.queenmirror.queenmirrorcduan.adapter;

/**
 * Created by john on 2018/8/26.
 *
 * jl
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.IsGpOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitPinTuanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.OrderNoBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.OrderBePayFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 待支付
 */
public class OrderPayAdapter extends BaseQuickAdapter<OrderPayBean.BodyBean.PendingOrderListBean,BaseViewHolder> implements HttpCallBack{
    OrderPaySecondAdapter orderPayAdapter;
    Context context;
    String orderId="";
    String pay_price;
    List<OrderPayBean.BodyBean.PendingOrderListBean.ListBean> list = new ArrayList<>();

    String isPay = "0";//0是付款   1是退款   2是取消
    String isGP = "false";
    String groupId;
    String submitId;

    public OrderPayAdapter(Context context,int layoutResId, @Nullable List<OrderPayBean.BodyBean.PendingOrderListBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final OrderPayBean.BodyBean.PendingOrderListBean item) {

        RecyclerView rv_orderpay_listitem = helper.getView(R.id.rv_orderpay_listitem);
        list = item.getList();

        orderPayAdapter = new OrderPaySecondAdapter(context, R.layout.order_pay_second_listitem, list);
        rv_orderpay_listitem.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        rv_orderpay_listitem.setAdapter(orderPayAdapter);

        RelativeLayout rl_order_pay_first_discount = helper.getView(R.id.rl_order_pay_first_discount);
        if(item.getRedPacketDiscount() == 0 && item.getCouponDiscount() == 0){
            rl_order_pay_first_discount.setVisibility(View.GONE);
        }else{
            rl_order_pay_first_discount.setVisibility(View.VISIBLE);

            if(item.getRedPacketDiscount() == 0){
                helper.setText(R.id.tv_order_pay_type,"店铺优惠券")
                        .setText(R.id.tv_order_pay_youhui,"-¥"+ MD5.doubleToString(item.getCouponDiscount()+""));
            }else{
                helper.setText(R.id.tv_order_pay_type,"红包优惠")
                        .setText(R.id.tv_order_pay_youhui,"-¥"+MD5.doubleToString(item.getRedPacketDiscount()+""));
            }
        }

        helper.setText(R.id.tv_order_pay_bean,"魔豆"+MD5.doubleToString(item.getUsePoints()+""))
                .setText(R.id.tv_order_pay_vip,"-¥"+MD5.doubleToString(item.getMemberDiscount()+""));

        int number = 0;
        for(int i=0;i<item.getList().size();i++){
            if(item.getList() == null || item.getList().get(i).getAnsSubmitGoodsRecordList() == null){

            }else {
                number = number + item.getList().get(i).getAnsSubmitGoodsRecordList().size();
            }
        }
        double price = item.getPayPrice()+item.getMemberDiscount()+item.getRedPacketDiscount()+item.getCouponDiscount();

        TextView tv_order_pay_number = helper.getView(R.id.tv_order_pay_number);
        tv_order_pay_number.setText("共"+number+"个商品，原价¥"+price+"    实际金额");
        helper.setText(R.id.tv_orderpay_all,"¥"+MD5.doubleToString(""+item.getPayPrice()));

        TextView tv_order_tuikuan = helper.getView(R.id.tv_order_tuikuan);

        tv_order_tuikuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitId = item.getId();
                orderId = "";
                for(int i=0;i<item.getList().size();i++){

                    for(int j=0;j<item.getList().get(i).getAnsSubmitGoodsRecordList().size();j++){
                        orderId = orderId + item.getList().get(i).getAnsSubmitGoodsRecordList().get(j).getOrderId()+",";
                    }
                }
                pay_price = item.getPayPrice()+"";
                /**
                 * 查看是否是拼团订单
                 */
                isGpOrder();
            }
        });

        TextView tv_order_again = helper.getView(R.id.tv_order_again);

        tv_order_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitId = item.getId();
                orderId = "";
                for(int i=0;i<item.getList().size();i++){

                    for(int j=0;j<item.getList().get(i).getAnsSubmitGoodsRecordList().size();j++){
                        orderId = orderId + item.getList().get(i).getAnsSubmitGoodsRecordList().get(j).getOrderId()+",";
                    }
                }
                CancelOrderData();
            }
        });
    }

    /**
     * 取消订单
     */
    private void CancelOrderData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("submitId",submitId);
        params.put("token",SP.get(context,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.CANCLEORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 查看是否是拼团订单
     */
    private void isGpOrder() {
        /**
         * 这里的OrderId需要改成OrderNO
         */
        HashMap<String, String> params = new HashMap<>();
        params.put("orderNo", orderId);
        params.put("userId", SP.get(context, SpContent.UserId,"0").toString());
        params.put("token",SP.get(context,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.ISGPORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 待付款订单付款前的校验
     */
    private void shopPayCheck(){
        /**
         * 这里的OrderId需要改成OrderNO
         */
        HashMap<String, String> params = new HashMap<>();
        params.put("orderNo",orderId);
        params.put("token", SP.get(context, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SHOPPAYCHECK, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 取消订单
             */
            case ACTION.CANCLEORDER:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite","no");
                    context.startActivity(intent);
                }else {
                    if (successBean.isSuccess()) {
                        T.show("取消成功");

                        OrderBePayFragment.instance.doFirstData();

                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            /**
             * 查看是否是拼团订单
             */
            case ACTION.ISGPORDER:
                IsGpOrderBean isGpOrderBean = GsonUtil.toObj(res,IsGpOrderBean.class);
                if(isGpOrderBean.isSuccess()){
                    if(isGpOrderBean.getBody().isIsGporder()){
                        /**
                         * 是拼团订单
                         */

                        if(isPay.equals("0")){
                            /**
                             * 付款
                             */
                            isGP = "true";
                            groupId = isGpOrderBean.getBody().getGroupId();
                            shopPayCheck();
                        }else if(isPay.equals("2")){
                            /**
                             * 取消
                             */
                           // CancelGPOrderData();
                        }

                    }else{
                        /**
                         * 不是拼团订单
                         */
                        if(isPay.equals("0")){
                            /**
                             * 付款
                             */
                            isGP = "false";
                            shopPayCheck();
                        }else if(isPay.equals("2")) {
                            /**
                             * 取消
                             */
                            //CancelOrderData();
                        }
                    }
                }else{
                    T.show(isGpOrderBean.getMsg());
                }
                break;

            /**
             * 待付款订单付款前的校验
             */
            case ACTION.SHOPPAYCHECK:
                final OrderNoBean orderNoBean=GsonUtil.toObj(res,OrderNoBean.class);
                if(orderNoBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite","no");
                    context.startActivity(intent);
                }else {
                    if (orderNoBean.getErrorCode().equals("0")) {

                        if(isGP.equals("true")){
                            Intent intent = new Intent(context, SubmitPinTuanActivity.class);
                           /* intent.putExtra("businessIds", goodId);
                            intent.putExtra("amount", amount + "");
                            intent.putExtra("groupId", orderId+ "");
                            intent.putExtra("groupIds",groupId);*/
                            context.startActivity(intent);
                        }else {


                            Intent intent = new Intent(context, SubmitActivity.class);
                            intent.putExtra("businessIds",orderId);
                            intent.putExtra("amount",pay_price);
                            intent.putExtra("submitId",submitId);
                            context.startActivity(intent);
                        }
                    } else if (orderNoBean.getErrorCode().equals("1")) {
                        //待付款订单付款前的校验
                        T.show(orderNoBean.getMsg());
                    }
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
}
