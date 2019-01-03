package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AreFundBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class AreFundAdapter  extends BaseQuickAdapter<AreFundBean,BaseViewHolder> {
    Context context;

    public AreFundAdapter(Context context,int layoutResId, @Nullable List<AreFundBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final AreFundBean item) {
        helper.setText(R.id.tv_shop_name,item.getIntfAnsOrderDetails().getGoodsName())
                .setText(R.id.tv_arefund_number,"X"+item.getIntfAnsOrderDetails().getPurchaseNumber())
                .setText(R.id.tv_arefund_price,item.getIntfAnsOrderDetails().getUnitPrice());

        ImageView iv_shop = helper.getView(R.id.iv_shop);
        String goods_logo = item.getIntfAnsOrderDetails().getGoodsThumb();
        String[] goodLogo = goods_logo.split(",");
        Glide.with(context).load(goodLogo[0]).placeholder(R.drawable.dismiss).into(iv_shop);

        CheckBox box_goods = helper.getView(R.id.box_goods);
        box_goods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    item.setCheck(true);
                }else{
                    item.setCheck(false);
                }
            }
        });

    }
}