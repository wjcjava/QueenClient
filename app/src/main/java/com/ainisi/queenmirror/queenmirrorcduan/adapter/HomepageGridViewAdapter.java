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
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 * <p>
 * jl
 */

public class HomepageGridViewAdapter extends BaseAdapter {
    private Context context;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> ShopListData = new ArrayList<>();
    private String where;
    double distance;
    String mine_lon, mine_lat, shop_lon, shop_lat;

    public HomepageGridViewAdapter(Context context, List<ShopListHomeBean.BodyBean.ShopListDataBean> ShopListData, String where) {
        this.context = context;
        this.ShopListData = ShopListData;
        this.where = where;
    }

    public void Clear() {
        ShopListData.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopListHomeBean.BodyBean.ShopListDataBean> ShopListData) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.item_recycler_waterfall, parent, false);
            holder.tv_shopName = convertView.findViewById(R.id.tv_shopName);
            holder.tv_shop_time = convertView.findViewById(R.id.tv_shop_time);
            holder.iv_homepage_shop = convertView.findViewById(R.id.iv_homepage_shop);
            holder.tv_homepage_distance = convertView.findViewById(R.id.tv_homepage_distance);
            holder.iv_xingxing = convertView.findViewById(R.id.iv_xingxing);
            holder.iv_queen = convertView.findViewById(R.id.iv_queen);
            holder.iv_homepage_queen = convertView.findViewById(R.id.iv_homepage_queen);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (where.equals("home")) {
                        Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());
                        intent.putExtra("cpCate", "1");
                        context.startActivity(intent);
                    } else {
                        Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                        intent.putExtra("shopName", ShopListData.get(position).getAnsShopBasic().getShopName());
                        intent.putExtra("shopId", ShopListData.get(position).getAnsShopBasic().getId());
                        intent.putExtra("cpCate", "2");
                        context.startActivity(intent);
                    }
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_shopName.setText(ShopListData.get(position).getAnsShopBasic().getShopName());

        String freetype = ShopListData.get(position).getFreeType();
        String[] keyValue = freetype.split(",");
        boolean istype = false;
        for (String str : keyValue) {
            if (istype == true) {
                break;
            }
            switch (str) {
                case "1":
                    istype = true;
                    holder.tv_shop_time.setVisibility(View.VISIBLE);
                    holder.tv_shop_time.setText("特价");
                    break;
                case "2":
                    istype = true;
                    holder.tv_shop_time.setVisibility(View.VISIBLE);
                    holder.tv_shop_time.setText("拼团");
                    break;
                case "3":
                    istype = true;
                    holder.tv_shop_time.setVisibility(View.VISIBLE);
                    holder.tv_shop_time.setText("优惠券");
                    break;
                case "4":
                    istype = true;
                    holder.tv_shop_time.setVisibility(View.VISIBLE);
                    holder.tv_shop_time.setText("魔豆");
                    break;
                default:
                    holder.tv_shop_time.setVisibility(View.GONE);
                    break;
            }
        }
        if (ShopListData.get(position).getAnsShopBasic().getQueenCard().equals("0")) {
            holder.iv_homepage_queen.setVisibility(View.GONE);
        } else {
            holder.iv_homepage_queen.setVisibility(View.VISIBLE);
        }
        if (ShopListData.get(position).getAnsShopBasic().getShopLogo() == null || ShopListData.get(position).getAnsShopBasic().getShopLogo().equals("")) {
        } else {
            String shopLogo = ShopListData.get(position).getAnsShopBasic().getShopLogo();
            String[] split = shopLogo.split(",");
            for (String s : split) {
                Glide.with(context).load(s).placeholder(R.drawable.dismiss).into(holder.iv_homepage_shop);
            }
        }
        if (ShopListData.get(position).getAnsShopBasic().getGeoX() == null || ShopListData.get(position).getAnsShopBasic().getGeoY() == null ||
                ShopListData.get(position).getAnsShopBasic().getGeoX().equals("") || ShopListData.get(position).getAnsShopBasic().getGeoY().equals("")) {
            shop_lon = "0";
            shop_lat = "0";
            mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
            mine_lat = SP.get(context, SpContent.UserLat, "0") + "";
        } else {
            mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
            mine_lat = SP.get(context, SpContent.UserLat, "0") + "";
            shop_lon = ShopListData.get(position).getAnsShopBasic().getGeoX();
            shop_lat = ShopListData.get(position).getAnsShopBasic().getGeoY();
        }
        if (mine_lat.equals("0") || mine_lon.equals("0")) {
            holder.tv_homepage_distance.setText("暂无定位信息");
        } else {
            holder.tv_homepage_distance.setVisibility(View.VISIBLE);
            distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
            holder.tv_homepage_distance.setText("距" + MD5.doubleToString(String.valueOf(distance)) + "km");
        }
        String comRate = "3.5";
        if (ShopListData.get(position).getComScore() == null || ShopListData.get(position).getComScore().equals("") || ShopListData.get(position).getComScore().equals("0.0")) {
            comRate = "3.5";
        } else {
            comRate = ShopListData.get(position).getComScore();
        }
        holder.iv_xingxing.setRating(Float.parseFloat(comRate));
        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        TextView tv_shopName;
        TextView tv_shop_time;
        ImageView iv_homepage_shop;
        TextView tv_homepage_distance;
        CustomRatingBar iv_xingxing;
        ImageView iv_queen;
        ImageView iv_homepage_queen;
    }
}
