package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineCollectionListBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MineCollectionAdapter extends BaseQuickAdapter<MineCollectionListBean.BodyBean.CollectListDataBean,BaseViewHolder> {

    Context context;
    List<MineCollectionListBean.BodyBean.CollectListDataBean> data = new ArrayList<>();
    public MineCollectionAdapter(Context context,int layoutResId, @Nullable List<MineCollectionListBean.BodyBean.CollectListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }
    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineCollectionListBean.BodyBean.CollectListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, MineCollectionListBean.BodyBean.CollectListDataBean item) {

        NumberFormat nf = NumberFormat.getInstance();
        String price = nf.format(Double.parseDouble(item.getEcGoodsBasic().getSalesPrice()))+"";

        helper.setText(R.id.tv_name,item.getGoodsIdName())
                .setText(R.id.tv_price,"¥"+price)
                .setText(R.id.tv_address,item.getAnsShopBasic().getShopName());

        ImageView img_title = helper.getView(R.id.img_title);

        String good_logo = item.getEcGoodsBasic().getGoodsThumb();
        String[] good_logos = good_logo.split(",");
        Glide.with(context).load(good_logos[0]).placeholder(R.drawable.dismiss).into(img_title);
    }
}
