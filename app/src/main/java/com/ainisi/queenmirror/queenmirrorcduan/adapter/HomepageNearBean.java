package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomepageNearByBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeNewFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.ShopMallFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/6/29.
 *
 * jl
 */

public class HomepageNearBean extends BaseAdapter {

    List<HomepageNearByBean> stringList = new ArrayList<>();
    Context context;
    String where;

    public HomepageNearBean(Context context, List<HomepageNearByBean> stringList,String where) {
        this.context = context;
        this.stringList = stringList;
        this.where = where;
    }

    public void Clear() {
        stringList.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<HomepageNearByBean> stringList) {
        this.stringList = stringList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.homepage_list_item, viewGroup, false);

            holder.tv_near_list_item = convertView.findViewById(R.id.tv_near_list_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_near_list_item.setText(stringList.get(i).getName());


        if(where.equals("1")){
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeNewFragment.instance.bt_up_home.setText(stringList.get(i).getName());
                    HomeNewFragment.instance.bt_app_home.setText(stringList.get(i).getName());
                    HomeNewFragment.instance.input_where = 1;
                    HomeNewFragment.instance.pageIndex = 0;
                    HomeNewFragment.instance.pageNumber = 1;
                    HomeNewFragment.instance.distance_code = "1";
                    if(i == 0){//getDistanPaixuData
                        HomeNewFragment.instance.getDistanPaixuData("1");
                        HomeNewFragment.instance.distance = "1";
                    }else if(i == 1){
                        HomeNewFragment.instance.getDistanPaixuData("1");
                        HomeNewFragment.instance.distance = "1";
                    }else if(i == 2){
                        HomeNewFragment.instance.getDistanPaixuData("3");
                        HomeNewFragment.instance.distance = "3";
                    }else if(i == 3){
                        HomeNewFragment.instance.getDistanPaixuData("5");
                        HomeNewFragment.instance.distance = "5";
                    }else if(i == 4){
                        HomeNewFragment.instance.getDistanPaixuData("10");
                        HomeNewFragment.instance.distance = "10";
                    }
                    HomeNewFragment.instance.popWindowHomes.dismiss();
                }
            });
        }else if(where.equals("2")){
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeNewFragment.instance.bt_up_home.setText(stringList.get(i).getName());
                    HomeNewFragment.instance.bt_app_home.setText(stringList.get(i).getName());
                    HomeNewFragment.instance.input_where = 1;
                    HomeNewFragment.instance.pageIndex = 0;
                    HomeNewFragment.instance.pageNumber = 1;
                    HomeNewFragment.instance.distance_code = "2";
                    HomeNewFragment.instance.distance = stringList.get(i).getId();

                    HomeNewFragment.instance.getNearPaixuData(stringList.get(i).getId());
                    HomeNewFragment.instance.popWindowHomes.dismiss();
                }
            });
        }else if(where.equals("3")){
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShopMallFragment.instance.bt_shopmalll_up_home.setText(stringList.get(i).getName());
                    ShopMallFragment.instance.bt_app_home.setText(stringList.get(i).getName());

                    ShopMallFragment.instance.input_where = 1;
                    ShopMallFragment.instance.pageIndex = 0;
                    ShopMallFragment.instance.pageNumber = 1;

                    if(i == 0){//getDistanPaixuData
                        ShopMallFragment.instance.getDistanPaixuData("1");
                        ShopMallFragment.instance.distance = "1";
                    }else if(i == 1){
                        ShopMallFragment.instance.getDistanPaixuData("1");
                        ShopMallFragment.instance.distance = "1";
                    }else if(i == 2){
                        ShopMallFragment.instance.getDistanPaixuData("3");
                        ShopMallFragment.instance.distance = "3";
                    }else if(i == 3){
                        ShopMallFragment.instance.getDistanPaixuData("5");
                        ShopMallFragment.instance.distance = "5";
                    }else if(i == 4){
                        ShopMallFragment.instance.getDistanPaixuData("10");
                        ShopMallFragment.instance.distance = "10";
                    }

                    ShopMallFragment.instance.popWindowHomes.dismiss();
                }
            });
        }else if(where.equals("4")){
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShopMallFragment.instance.bt_shopmalll_up_home.setText(stringList.get(i).getName());
                    ShopMallFragment.instance.bt_app_home.setText(stringList.get(i).getName());
                    ShopMallFragment.instance.input_where = 1;
                    ShopMallFragment.instance.pageIndex = 0;
                    ShopMallFragment.instance.pageNumber = 1;
                    ShopMallFragment.instance.distance = stringList.get(i).getId();
                    ShopMallFragment.instance.getNearPaixuData(stringList.get(i).getId());

                    ShopMallFragment.instance.popWindowHomes.dismiss();
                }
            });
        }else if(where.equals("5")){//
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EstheticsActivity.instance.bt_esthetics_up_home.setText(stringList.get(i).getName());
                    EstheticsActivity.instance.input_where = 1;
                    EstheticsActivity.instance.pageIndex = 0;
                    EstheticsActivity.instance.pageNumber = 1;

                    if(i == 0){//getDistanPaixuData
                        EstheticsActivity.instance.getDistanPaixuData("1");
                        EstheticsActivity.instance.distance = "1";
                    }else if(i == 1){
                        EstheticsActivity.instance.getDistanPaixuData("1");
                        EstheticsActivity.instance.distance = "1";
                    }else if(i == 2){
                        EstheticsActivity.instance.getDistanPaixuData("3");
                        EstheticsActivity.instance.distance = "3";
                    }else if(i == 3){
                        EstheticsActivity.instance.getDistanPaixuData("5");
                        EstheticsActivity.instance.distance = "5";
                    }else if(i == 4){
                        EstheticsActivity.instance.getDistanPaixuData("10");
                        EstheticsActivity.instance.distance = "10";
                    }

                    EstheticsActivity.instance.popWindowHomes.dismiss();
                }
            });
        }else if(where.equals("6")){
            holder.tv_near_list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EstheticsActivity.instance.bt_esthetics_up_home.setText(stringList.get(i).getName());
                    EstheticsActivity.instance.input_where = 1;
                    EstheticsActivity.instance.pageIndex = 0;
                    EstheticsActivity.instance.pageNumber = 1;
                    EstheticsActivity.instance.distance = stringList.get(i).getId();
                    EstheticsActivity.instance.getNearPaixuData(stringList.get(i).getId());

                    EstheticsActivity.instance.popWindowHomes.dismiss();
                }
            });
        }

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        TextView tv_near_list_item;
    }
}
