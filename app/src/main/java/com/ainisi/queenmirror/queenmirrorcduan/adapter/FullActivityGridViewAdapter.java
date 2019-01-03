package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 * <p>
 * jl
 */

public class FullActivityGridViewAdapter extends BaseAdapter {
    private Context context;
    List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> ShopListData = new ArrayList<>();

    public FullActivityGridViewAdapter(Context context, List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> ShopListData) {
        this.context = context;
        this.ShopListData = ShopListData;
    }


    @Override
    public int getCount() {
        return ShopListData.size();
    }

    @Override
    public Object getItem(int position) {
        return ShopListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fullrecycler, parent, false);
            holder.iv_shop_title = convertView.findViewById(R.id.iv_shop_title);
            holder.sote_name = convertView.findViewById(R.id.sote_name);
            holder.tv_full_introduction = convertView.findViewById(R.id.tv_full_introduction);
            holder.tv_full_evaluate = convertView.findViewById(R.id.tv_full_evaluate);
            holder.sort_time = convertView.findViewById(R.id.sort_time);
            holder.tv_goods_market = convertView.findViewById(R.id.tv_goods_market);
            holder.rl_full_bottom = convertView.findViewById(R.id.rl_full_bottom);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String logo = ShopListData.get(position).getEcGoodsBasic().getGoodsThumb();
        String[] logoPic = logo.split(",");
        Glide.with(context).load(logoPic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(holder.iv_shop_title);
        holder.sote_name.setText(ShopListData.get(position).getEcGoodsBasic().getGoodsName());
        holder.tv_full_introduction.setText(ShopListData.get(position).getEcGoodsBasic().getShopName());
        String praiseRate;
        if (ShopListData.get(position).getPraiseRate() == null || ShopListData.get(position).getPraiseRate().equals("")) {
            praiseRate = "1";
        } else {
            praiseRate = ShopListData.get(position).getPraiseRate();
        }
        double rate = Double.parseDouble(praiseRate) * 100;
        if ("1".equals(ShopListData.get(position).getAnsShopBasic().getQueenCard())) {
            holder.tv_full_evaluate.setVisibility(View.VISIBLE);
            holder.tv_full_evaluate.setText("女王会员" + ShopListData.get(position).getAnsShopBasic().getQueenShopDiscount() + "折价：" +
                    "¥" + MD5.doubleToString(String.valueOf(Double.valueOf(ShopListData.get(position).getEcGoodsBasic().getSalesPrice()) * ShopListData.get(position).getAnsShopBasic().getQueenShopDiscount() / 10)));
        } else {
            holder.tv_full_evaluate.setVisibility(View.INVISIBLE);
        }
        holder.sort_time.setText("¥" + MD5.doubleToString(ShopListData.get(position).getEcGoodsBasic().getSalesPrice()));
        holder.tv_goods_market.setText("¥" + MD5.doubleToString(ShopListData.get(position).getEcGoodsBasic().getMarketPrice()));
        holder.tv_goods_market.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        holder.rl_full_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullActivity.class);
                intent.putExtra("goodsId", ShopListData.get(position).getEcGoodsBasic().getId());
                intent.putExtra("shopId", ShopListData.get(position).getEcGoodsBasic().getShopId());
                intent.putExtra("shopName", ShopListData.get(position).getEcGoodsBasic().getShopName());
                String[] split = ShopListData.get(position).getEcGoodsBasic().getGoodsThumb().split(",");
                intent.putExtra("shopLogo", split[0]);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        TextView sote_name;
        ImageView iv_shop_title;
        TextView tv_full_introduction;
        TextView tv_full_evaluate;
        TextView sort_time;
        TextView tv_goods_market;
        RelativeLayout rl_full_bottom;
    }
}
