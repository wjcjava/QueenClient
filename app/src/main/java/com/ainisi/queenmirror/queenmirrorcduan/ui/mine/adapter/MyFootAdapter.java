package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MineFootBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/5/11.
 *
 * jl
 */

public class MyFootAdapter extends BaseQuickAdapter<MineFootBean.BodyBean.ViewListDataBean,BaseViewHolder> {

    List<MineFootBean.BodyBean.ViewListDataBean> ViewListData = new ArrayList<>();

    Context context;

    public MyFootAdapter(Context context,int layoutResId, @Nullable List<MineFootBean.BodyBean.ViewListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MineFootBean.BodyBean.ViewListDataBean item) {

        //helper.setText(R.id.foot_name,item.getBody().getViewListData().get(1).getEcGoodsBasic().getGoodsName());
        ImageView iv_mine_fllow_logo = helper.getView(R.id.iv_mine_fllow_logo);

        if(item.getAnsShopBasic()==null||item.getAnsShopBasic().getShopLogo() == null){

        }else {
            String shop_logo = item.getAnsShopBasic().getShopLogo();
            String[] shopLogo = shop_logo.split(",");
            Glide.with(context).load(shopLogo[0]).placeholder(R.drawable.dismiss).into(iv_mine_fllow_logo);

            helper.setText(R.id.foot_name,item.getAnsShopBasic().getShopName())
                    .setText(R.id.sort_time,"营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());
        }
    }
}
