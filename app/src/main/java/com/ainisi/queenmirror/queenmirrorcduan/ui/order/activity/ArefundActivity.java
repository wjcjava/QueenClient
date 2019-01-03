package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.AreFundAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 退款
 */
public class ArefundActivity extends BaseNewActivity {
    @Bind(R.id.re_arefund)
    RecyclerView areRecyclerView;
    @Bind(R.id.title_title)
    TextView areTitle;

    AreFundBean areFundBean;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> getApiOrderDetailsList = new ArrayList();
    List<AreFundBean> areFundBeanList = new ArrayList<>();

    List<AreFundBean> areFundCheckList;
    String orderNo,shopId,orderId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_arefund;
    }

    @Override
    protected void initView() {
        super.initView();
        areTitle.setText(R.string.arefund);
        Intent intentGet = getIntent();
        getApiOrderDetailsList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean>) intentGet.getSerializableExtra("lstBean");
        orderNo = intentGet.getStringExtra("orderNo");
        shopId = intentGet.getStringExtra("shopId");
        orderId = intentGet.getStringExtra("orderId");

        for(int i=0;i<getApiOrderDetailsList.size();i++){
            areFundBean = new AreFundBean();
            AreFundBean.IntfAnsOrderDetailsBean  intfAnsOrderDetailsBean = new AreFundBean.IntfAnsOrderDetailsBean();
            intfAnsOrderDetailsBean.setGoodsId(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getGoodsId());
            intfAnsOrderDetailsBean.setGoodsName(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getGoodsName());
            intfAnsOrderDetailsBean.setPurchaseNumber(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getPurchaseNumber());
            intfAnsOrderDetailsBean.setUnitPrice(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getUnitPrice());
            intfAnsOrderDetailsBean.setSumAmount(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getSumAmount());
            intfAnsOrderDetailsBean.setCpAmount(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getCpAmount());
            intfAnsOrderDetailsBean.setAfterAmount(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getAfterAmount());
            intfAnsOrderDetailsBean.setGoodsThumb(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getGoodsThumb());
            intfAnsOrderDetailsBean.setId(getApiOrderDetailsList.get(i).getIntfAnsOrderDetails().getId());

            areFundBean.setIntfAnsOrderDetails(intfAnsOrderDetailsBean);
            areFundBean.setCheck(false);
            areFundBeanList.add(areFundBean);
        }

        AreFundAdapter areFundAdapter = new AreFundAdapter(ArefundActivity.this,R.layout.arefund_re_listitem,areFundBeanList);
        areRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        areRecyclerView.setAdapter(areFundAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.title_back, R.id.bt_confirm_refund})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //确认退款
            case R.id.bt_confirm_refund:
                areFundCheckList = new ArrayList<>();
                for(int i = 0;i<areFundBeanList.size();i++){
                    if(areFundBeanList.get(i).isCheck()){

                        areFundBean = new AreFundBean();
                        AreFundBean.IntfAnsOrderDetailsBean  intfAnsOrderDetailsBean = new AreFundBean.IntfAnsOrderDetailsBean();
                        intfAnsOrderDetailsBean.setGoodsId(areFundBeanList.get(i).getIntfAnsOrderDetails().getGoodsId());
                        intfAnsOrderDetailsBean.setGoodsName(areFundBeanList.get(i).getIntfAnsOrderDetails().getGoodsName());
                        intfAnsOrderDetailsBean.setPurchaseNumber(areFundBeanList.get(i).getIntfAnsOrderDetails().getPurchaseNumber());
                        intfAnsOrderDetailsBean.setUnitPrice(areFundBeanList.get(i).getIntfAnsOrderDetails().getUnitPrice());
                        intfAnsOrderDetailsBean.setSumAmount(areFundBeanList.get(i).getIntfAnsOrderDetails().getSumAmount());
                        intfAnsOrderDetailsBean.setCpAmount(areFundBeanList.get(i).getIntfAnsOrderDetails().getCpAmount());
                        intfAnsOrderDetailsBean.setAfterAmount(areFundBeanList.get(i).getIntfAnsOrderDetails().getAfterAmount());
                        intfAnsOrderDetailsBean.setGoodsThumb(areFundBeanList.get(i).getIntfAnsOrderDetails().getGoodsThumb());
                        intfAnsOrderDetailsBean.setId(areFundBeanList.get(i).getIntfAnsOrderDetails().getId());
                        areFundBean.setIntfAnsOrderDetails(intfAnsOrderDetailsBean);
                        areFundCheckList.add(areFundBean);
                    }
                }

                if(areFundCheckList.size() >0){
                    Intent intent = new Intent(this,ConfirmRefundActivity.class);
                    intent.putExtra("lstBean", (Serializable)areFundCheckList);
                    intent.putExtra("orderNo",orderNo);
                    intent.putExtra("shopId",shopId);
                    intent.putExtra("orderId",orderId);
                    startActivity(intent);
                    finish();
                }else{
                    T.show("请选择需要退款的商品");
                }

                break;
        }
    }
}
