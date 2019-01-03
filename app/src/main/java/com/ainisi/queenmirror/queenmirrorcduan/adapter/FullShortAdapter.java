package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/12.
 *
 * jl
 */

public class FullShortAdapter extends BaseQuickAdapter<ShopListHomeBean.BodyBean.ShopListDataBean, BaseViewHolder> {

    Context context;
    double distance;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> data;

    public FullShortAdapter(Context context,int layoutResId, @Nullable List<ShopListHomeBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopListHomeBean.BodyBean.ShopListDataBean item) {

        helper.setText(R.id.tv_sort_name, item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_sort_time, "营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());

        ImageView iv_homepage_shop_listview = helper.getView(R.id.iv_homepage_shop_listview);
        String shopLogo = item.getAnsShopBasic().getShopLogo();

        if(item.getAnsShopBasic().getShopLogo() == null||item.getAnsShopBasic().getShopLogo().toString().length()<1){

        }else {
            String[] shop_logo = shopLogo.split(",");
            Glide.with(context).load(shop_logo[0]).placeholder(R.drawable.dismiss).into(iv_homepage_shop_listview);
        }

        if(item.getAnsShopBasic().getQueenCard().equals("0")){
            helper.setGone(R.id.iv_homepage_list_queen,false);
        }else{
            helper.setGone(R.id.iv_homepage_list_queen,true);
        }
        String shop_lon = item.getAnsShopBasic().getGeoX();
        String shop_lat = item.getAnsShopBasic().getGeoY();
        String mine_lat = SP.get(context, SpContent.UserLat,"0")+"";
        String mine_lon = SP.get(context,SpContent.UserLon,"0")+"";

        if(mine_lat.equals("0")){
            helper.setText(R.id.sort_distance,"暂无定位信息");
        }else {
            distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
            helper.setText(R.id.sort_distance, "相距 " + MD5.doubleToString(String.valueOf(distance)) + "km");
        }

        helper.setOnClickListener(R.id.li_home_short, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName",item.getAnsShopBasic().getShopName());
                intent.putExtra("shopId",item.getAnsShopBasic().getId());
                context.startActivity(intent);
            }
        });
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopListHomeBean.BodyBean.ShopListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
