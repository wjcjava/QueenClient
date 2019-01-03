package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SpecialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/9/4.
 * <p>
 * jl
 */

public class SpecialAdapter extends BaseAdapter {
    private Context context;
    List<SpecialBean.BodyBean.SpecialOfferGoodsListBean> ShopListData = new ArrayList<>();

    public SpecialAdapter(Context context, List<SpecialBean.BodyBean.SpecialOfferGoodsListBean> ShopListData) {
        this.context = context;
        this.ShopListData = ShopListData;
    }

    public void Clear() {
        ShopListData.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<SpecialBean.BodyBean.SpecialOfferGoodsListBean> ShopListData) {
        this.ShopListData = ShopListData;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ShopListData.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.layout_special_list_item_bottom, parent, false);
            holder.iv_special_image = convertView.findViewById(R.id.iv_special_image);
            holder.tv_special_name = convertView.findViewById(R.id.tv_special_name);
            holder.tv_special_price = convertView.findViewById(R.id.tv_special_price);
            holder.tv_special_price_market = convertView.findViewById(R.id.tv_special_price_market);
            holder.li_special_full = convertView.findViewById(R.id.li_special_full);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String[] split = ShopListData.get(position).getGoodsThumb().split(",");
        Glide.with(context).load(split[0]).dontAnimate().into(holder.iv_special_image);
        holder.tv_special_name.setText(ShopListData.get(position).getGoodsName());
        holder.tv_special_price.setText("¥" + MD5.doubleToString(ShopListData.get(position).getSalesPrice() + ""));
        holder.tv_special_price_market.setText("¥" + MD5.doubleToString(ShopListData.get(position).getMarketPrice() + ""));
        holder.tv_special_price_market.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        holder.li_special_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullActivity.class);
                intent.putExtra("goodsId", ShopListData.get(position).getId());
                intent.putExtra("shopId", ShopListData.get(position).getShopId());
                intent.putExtra("shopName", ShopListData.get(position).getShopName());
                intent.putExtra("number", "1");
                intent.putExtra("shopLogo", ShopListData.get(position).getGoodsThumb());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        ImageView iv_special_image;
        TextView tv_special_name;
        TextView tv_special_price;
        TextView tv_special_price_market;
        LinearLayout li_special_full;
    }

}
