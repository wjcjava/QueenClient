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
import android.widget.LinearLayout;
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

public class HomeListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> ShopListData = new ArrayList<>();
    private String where;
    String mine_lon, mine_lat, shop_lon, shop_lat;
    private double distance;

    public HomeListViewAdapter(Context context, List<ShopListHomeBean.BodyBean.ShopListDataBean> ShopListData, String where) {
        this.context = context;
        this.ShopListData = ShopListData;
        inflater = LayoutInflater.from(context);
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
        return ShopListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"SetTextI18n", "WrongViewCast"})
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.item_shortrecycler, parent, false);
            holder.sort_time = convertView.findViewById(R.id.tv_sort_time);
            holder.sort_name = convertView.findViewById(R.id.tv_sort_name);
            holder.sort_distance = convertView.findViewById(R.id.sort_distance);
            holder.iv_homepage_shop_listview = convertView.findViewById(R.id.iv_homepage_shop_listview);
            holder.sort_groupshop = convertView.findViewById(R.id.sort_groupshop);
            holder.iv_queen = convertView.findViewById(R.id.iv_queen);
            holder.iv_homepage_list_queen = convertView.findViewById(R.id.iv_homepage_list_queen);
            holder.sort_fg_itme1 = convertView.findViewById(R.id.sort_fg_itme1);
            holder.sort_fg_itme2 = convertView.findViewById(R.id.sort_fg_itme2);
            holder.sort_fg_itme3 = convertView.findViewById(R.id.sort_fg_itme3);
            holder.sort_fg_itme4 = convertView.findViewById(R.id.sort_fg_itme4);

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
        holder.sort_time.setText("营业时间：" + ShopListData.get(position).getAnsShopBasic().getOpenTime() + "-" + ShopListData.get(position).getAnsShopBasic().getCloseTime());
        String freetype = ShopListData.get(position).getFreeType();
        String[] keyValue = freetype.split(",");
        List<String> list = new ArrayList<>();
        for (String str : keyValue) {
            list.add(str);
        }
        if (list.contains("1")) {
            holder.sort_fg_itme1.setVisibility(View.VISIBLE);
        } else {
            holder.sort_fg_itme1.setVisibility(View.GONE);
        }
        if (list.contains("2")) {
            holder.sort_fg_itme2.setVisibility(View.VISIBLE);
        } else {
            holder.sort_fg_itme2.setVisibility(View.GONE);
        }
        if (list.contains("3")) {
            holder.sort_fg_itme3.setVisibility(View.VISIBLE);
        } else {
            holder.sort_fg_itme3.setVisibility(View.GONE);
        }
        if (list.contains("4")) {
            holder.sort_fg_itme4.setVisibility(View.VISIBLE);
        } else {
            holder.sort_fg_itme4.setVisibility(View.GONE);
        }
        holder.sort_name.setText(ShopListData.get(position).getAnsShopBasic().getShopName());

        if (ShopListData.get(position).getAnsShopBasic().getQueenCard().equals("0")) {
            holder.iv_homepage_list_queen.setVisibility(View.GONE);
        } else {
            holder.iv_homepage_list_queen.setVisibility(View.VISIBLE);
        }

        if (ShopListData.get(position).getAnsShopBasic().getShopLogo() == null || ShopListData.get(position).getAnsShopBasic().getShopLogo().equals("")) {

        } else {
            String shopLogo = ShopListData.get(position).getAnsShopBasic().getShopLogo();
            String[] split = shopLogo.split(",");
            for (String s : split) {
                Glide.with(context).load(s).placeholder(R.drawable.dismiss).into(holder.iv_homepage_shop_listview);
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
            holder.sort_distance.setText("暂无定位信息");
        } else {
            holder.sort_distance.setVisibility(View.VISIBLE);
            distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
            holder.sort_distance.setText("距" + MD5.doubleToString(String.valueOf(distance)) + "km");
        }

        String comRate;
        if (ShopListData.get(position).getComScore() == null || ShopListData.get(position).getComScore().equals("") || ShopListData.get(position).getComScore().equals("0.0")) {
            comRate = "3.5";
        } else {
            comRate = ShopListData.get(position).getComScore();
        }

        holder.sort_groupshop.setRating(Float.parseFloat(comRate));

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        private LinearLayout li_home_short;
        private TextView sort_name, sort_distance, sort_fg_itme1, sort_fg_itme2, sort_fg_itme3, sort_fg_itme4;
        private TextView sort_time;
        private ImageView iv_homepage_shop_listview;
        private CustomRatingBar sort_groupshop;
        private ImageView iv_queen;
        private ImageView iv_homepage_list_queen;
    }


}
