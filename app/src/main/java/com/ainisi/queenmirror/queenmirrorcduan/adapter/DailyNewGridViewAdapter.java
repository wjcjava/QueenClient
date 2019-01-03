package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.DailyNewBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/9/14.
 *
 * jl
 */

public class DailyNewGridViewAdapter  extends BaseAdapter {
    private Context context;
    List<DailyNewBean.BodyBean.NewShopAndGoodsListBean.ApiEcGoodsBasicBean> goodsBasicBeans = new ArrayList<>();
    String shopName;

    public DailyNewGridViewAdapter(Context context, List<DailyNewBean.BodyBean.NewShopAndGoodsListBean.ApiEcGoodsBasicBean> goodsBasicBeans, String shopName) {
        this.context = context;
        this.goodsBasicBeans = goodsBasicBeans;
        this.shopName = shopName;
    }

    @Override
    public int getCount() {
        return goodsBasicBeans.size();
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

            convertView = LayoutInflater.from(context).inflate(R.layout.layout_dailynew_list_item_bottom, parent, false);

            holder.iv_dailynew_bottom_image = convertView.findViewById(R.id.iv_dailynew_bottom_image);
            holder.tv_dailynew_bottom_number = convertView.findViewById(R.id.tv_dailynew_bottom_number);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(goodsBasicBeans.get(position).getEcGoodsBasic().getGoodsThumb()).dontAnimate().into(holder.iv_dailynew_bottom_image);

        holder.tv_dailynew_bottom_number.setText("¥"+goodsBasicBeans.get(position).getEcGoodsBasic().getSalesPrice());

        holder.iv_dailynew_bottom_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullActivity.class);
                intent.putExtra("goodsId",goodsBasicBeans.get(position).getEcGoodsBasic().getId());
                intent.putExtra("shopId",goodsBasicBeans.get(position).getEcGoodsBasic().getShopId());
                intent.putExtra("shopName",shopName);
                intent.putExtra("number",goodsBasicBeans.get(position).getEcGoodsBrowses().getBrowseCounts());
                intent.putExtra("shopLogo", goodsBasicBeans.get(position).getEcGoodsBasic().getGoodsThumb());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    //就是View的持有
    public final class ViewHolder {
        ImageView iv_dailynew_bottom_image;
        TextView tv_dailynew_bottom_number;
    }
}
