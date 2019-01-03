package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.NumberFormat;
import java.util.List;

public class PintuanListAdapter extends BaseQuickAdapter<PinTuanBean.BodyBean.GroupActivityListDataBean, BaseViewHolder> {
    Context context;
    List<PinTuanBean.BodyBean.GroupActivityListDataBean> data;

    public PintuanListAdapter(Context context, int layoutResId, @Nullable List<PinTuanBean.BodyBean.GroupActivityListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, PinTuanBean.BodyBean.GroupActivityListDataBean item) {

        NumberFormat nf = NumberFormat.getInstance();
        String price = nf.format(Double.parseDouble(item.getGpActivity().getGroupPrice())) + "";

        ImageView iv_fightalone_title = helper.getView(R.id.iv_fightalone_title);
        String goods_thumb = item.getEcGoodsBasic().getGoodsThumb();
        String[] doodThumb = goods_thumb.split(",");

        Glide.with(context).load(doodThumb[0]).dontAnimate().into(iv_fightalone_title);

        helper.setText(R.id.tv_fightalone_name, item.getGpActivity().getGroupName())
                .setText(R.id.tv_fightalone_briefintroduction, item.getEcGoodsBasic().getGoodsBrief())
                .setText(R.id.tv_fightalone_presentprice, "¥ " + price)
                .setText(R.id.tv_fightalone_presentprice_two, "¥" + item.getGpActivity().getSinglePrice())
                .setText(R.id.tv_fightalone_num, item.getGpActivity().getGroupNumber() + "人团·已团" + item.getGpActivity().getSaleNums() + "件");
        TextView view = helper.getView(R.id.tv_fightalone_presentprice_two);
        view.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public void Clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<PinTuanBean.BodyBean.GroupActivityListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}