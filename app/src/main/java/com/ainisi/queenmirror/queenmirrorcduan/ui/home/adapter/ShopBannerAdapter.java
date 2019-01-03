package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopBannerBean;
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
 * Created by john on 2018/6/16.
 *
 * jl
 */

public class ShopBannerAdapter extends BaseQuickAdapter<ShopBannerBean.BodyBean.ShopListDataBean, BaseViewHolder> {

    double distance;
    String mine_lon, mine_lat, shop_lon, shop_lat;
    Context context;
    public ShopBannerAdapter(Context context,int layoutResId, @Nullable List<ShopBannerBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopBannerBean.BodyBean.ShopListDataBean item) {
        helper.setText(R.id.tv_sort_name,item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_sort_time,"营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());

        shop_lat = item.getAnsShopBasic().getGeoY()+"";
        shop_lon = item.getAnsShopBasic().getGeoX()+"";
        mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
        mine_lat = SP.get(context, SpContent.UserLat, "0") + "";

        if(item.getAnsShopBasic().getQueenCard().equals("0")){
            helper.setVisible(R.id.iv_homepage_list_queen,false);
        }else{
            helper.setVisible(R.id.iv_homepage_list_queen,true);
        }

        if(mine_lat.equals("0")){
            helper.setText(R.id.sort_distance,"暂无定位信息");
        }else{
            distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
            helper.setText(R.id.sort_distance,"相距 " + MD5.doubleToString(String.valueOf(distance)) + "km");
        }

        String shoplogo = item.getAnsShopBasic().getShopLogo();
        String[] shop_logo = shoplogo.split(",");
        Glide.with(mContext).load(shop_logo[0]).placeholder(R.drawable.dismiss).into((ImageView) helper.getView(R.id.iv_homepage_shop_listview));

        helper.setOnClickListener(R.id.li_home_short, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName", item.getAnsShopBasic().getShopName());
                intent.putExtra("shopId", item.getAnsShopBasic().getId());
                context.startActivity(intent);
            }
        });
    }
}
