package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HolidayListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/9/11.
 *
 * jl
 */

public class HolidayGridAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    Context context;
    List<HolidayListBean.BodyBean.GoodslistBean> goodslist = new ArrayList<>();

    public HolidayGridAdapter(Context context,List<HolidayListBean.BodyBean.GoodslistBean> goodslist) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.goodslist = goodslist;
    }

    @Override
    public int getCount() {
        return goodslist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.layout_holiday_list_item_second, viewGroup, false);
            holder.iv_holiday_list_image = convertView.findViewById(R.id.iv_holiday_list_image);
            holder.tv_holiday_list_people = convertView.findViewById(R.id.tv_holiday_list_people);
            holder.tv_holiday_list_name = convertView.findViewById(R.id.tv_holiday_list_name);
            holder.tv_holiday_list_price = convertView.findViewById(R.id.tv_holiday_list_price);
            holder.li_holiday_click = convertView.findViewById(R.id.li_holiday_click);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String image = goodslist.get(i).getEcGoodsBasic().getGoodsThumb();
        Glide.with(context).load(image).dontAnimate().into(holder.iv_holiday_list_image);
        holder.tv_holiday_list_people.setText(goodslist.get(i).getEcGoodsBasic().getGroupNumber()+"人团");
        holder.tv_holiday_list_name.setText(goodslist.get(i).getEcGoodsBasic().getGoodsName());
        holder.tv_holiday_list_price.setText(goodslist.get(i).getEcGoodsBasic().getGroupPrice()+"");

        holder.li_holiday_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FightaloneActivity.class);
                intent.putExtra("activityId", goodslist.get(i).getEcGoodsBasic().getActivityId());
                intent.putExtra("goodsName", goodslist.get(i).getEcGoodsBasic().getGoodsName());
                intent.putExtra("goodsId", goodslist.get(i).getEcGoodsBasic().getId());
                intent.putExtra("goodsBrief", goodslist.get(i).getEcGoodsBasic().getGoodsBrief());
                intent.putExtra("goodsService", goodslist.get(i).getEcGoodsBasic().getServiceTime());
                intent.putExtra("goodsSales", goodslist.get(i).getEcGoodsBasic().getSalesPrice()+"");
                intent.putExtra("goodsGroup",goodslist.get(i).getEcGoodsBasic().getGroupPrice()+"");

                if (goodslist.get(i).getEcGoodsBasic().getMarketPrice() == null) {
                    intent.putExtra("goodsMarket", "0");
                } else {
                    intent.putExtra("goodsMarket", goodslist.get(i).getEcGoodsBasic().getMarketPrice());

                }
                //  intent.putExtra("goodsNumber",sortlist.get(position).getEcGoodsBasic().get)
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        ImageView iv_holiday_list_image;
        TextView tv_holiday_list_people;
        TextView tv_holiday_list_name;
        TextView tv_holiday_list_price;

        LinearLayout li_holiday_click;
    }

}
