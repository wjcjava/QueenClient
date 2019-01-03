package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseNowActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseSelectActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/31.
 *
 * jl
 */

public class PurchaseAdapter extends BaseQuickAdapter<ReceiveDiscounBean.BodyBean.CustCouponListDataBean,BaseViewHolder> {

    String amount,postion,purchaseNow,isbean;
    public PurchaseAdapter(int layoutResId, @Nullable List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> data,String amount,String postion,String purchaseNow,String isbean) {
        super(layoutResId, data);
        this.amount = amount;
        this.postion = postion;
        this.purchaseNow = purchaseNow;
        this.isbean = isbean;
    }

    @Override
    protected void convert(BaseViewHolder helper, final ReceiveDiscounBean.BodyBean.CustCouponListDataBean item) {
        helper.setText(R.id.tv_discount,item.getCpCreateInfo().getCpName());
        helper.setText(R.id.tv_ten,item.getCpCreateInfo().getReduceAmount()+"元");

        helper.setOnClickListener(R.id.rl_select_use, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(purchaseNow.equals("list")){
                    PayPurchaseBean payPurchaseBean = new PayPurchaseBean();
                    payPurchaseBean.setCpId(item.getCpCreateInfo().getId());

                    if(isbean.equals("false")){
                        payPurchaseBean.setCpMethod("1");
                    }else{
                        payPurchaseBean.setCpMethod("1");
                    }
                    payPurchaseBean.setCpName("优惠金额¥"+item.getCpCreateInfo().getReduceAmount());
                    payPurchaseBean.setCpMoney(item.getCpCreateInfo().getReduceAmount());

                    PurchaseActivity.instance.payPurchaseBean = payPurchaseBean;
                    /**
                     * 这里的位置需要判断
                     */
                    PurchaseActivity.instance.addPurchaseData(Integer.parseInt(postion));

                    PurchaseSelectActivity.instance.finish();
                }else if(purchaseNow.equals("now")){
                    PurchaseNowActivity.instance.cpMethod = "1";
                    PurchaseNowActivity.instance.cpId = item.getCpCreateInfo().getId()+"";
                    PurchaseNowActivity.instance.cp_money = item.getCpCreateInfo().getReduceAmount();
                    PurchaseNowActivity.instance.tv_pur_selectname.setText("优惠金额¥"+item.getCpCreateInfo().getReduceAmount());

                    PurchaseNowActivity.instance.ChangeMoney();

                    PurchaseSelectActivity.instance.finish();
                }
            }
        });

        if(item.getCpCreateInfo().getFullCondition().equals("")){
            helper.setText(R.id.tv_no,"无条件使用");
        }else{
            helper.setText(R.id.tv_no,"满"+item.getCpCreateInfo().getFullCondition());
        }
        helper.setText(R.id.tv_time,item.getCpCreateInfo().getUseFrom()+"-"+item.getCpCreateInfo().getUseTo());
        helper.setText(R.id.tv_purpose,item.getCpCreateInfo().getShopName());
    }
}
