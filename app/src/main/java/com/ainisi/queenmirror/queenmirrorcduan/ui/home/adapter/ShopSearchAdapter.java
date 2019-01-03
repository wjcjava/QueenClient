package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

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
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/1.
 *
 */

public class ShopSearchAdapter extends BaseQuickAdapter<ShopListHomeBean.BodyBean.ShopListDataBean, BaseViewHolder> {

    Context context;
    double distance;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> data;
    public ShopSearchAdapter(Context context,int layoutResId, @Nullable List<ShopListHomeBean.BodyBean.ShopListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }
    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopListHomeBean.BodyBean.ShopListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final ShopListHomeBean.BodyBean.ShopListDataBean item) {
        helper.setText(R.id.tv_search_shopname, item.getAnsShopBasic().getShopName());
        helper.setText(R.id.tv_search_shoptime, "营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());
        CustomRatingBar search_service_custom = helper.getView(R.id.search_service_custom);


        if(item.getComScore() == null||item.getComScore().equals("")||item.getComScore().equals("0.0")){
            search_service_custom.setRating(Float.parseFloat("3.5"));
        }else{
            search_service_custom.setRating(Float.parseFloat(item.getComScore()));
        }
        String shop_lon="",shop_lat = "";
        if(item.getAnsShopBasic().getGeoX() == null || item.getAnsShopBasic().getGeoY()==null){
            shop_lon="0";
        }else {
            shop_lon = item.getAnsShopBasic().getGeoX();
            shop_lat = item.getAnsShopBasic().getGeoY();
        }

        String mine_lat = SP.get(context, SpContent.UserLat,"0")+"";
        String mine_lon = SP.get(context,SpContent.UserLon,"0")+"";

        if(mine_lat.equals("0")){
            helper.setText(R.id.tv_search_shopdistance,"暂无定位信息");
        }else if(shop_lon.equals("0")){
            helper.setText(R.id.tv_search_shopdistance,"商家位置出错，请联系商家");
        }else{
            distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
            helper.setText(R.id.tv_search_shopdistance, "相距 " + MD5.doubleToString(String.valueOf(distance)) + "km");
        }

        helper.setOnClickListener(R.id.li_home_short, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName",item.getAnsShopBasic().getShopName());
                intent.putExtra("shopId",item.getAnsShopBasic().getId());
                intent.putExtra("cpCate","2");
                context.startActivity(intent);
            }
        });

        ImageView iv_search_shop_head = helper.getView(R.id.iv_search_shop_head);

        if(item.getAnsShopBasic()==null || item.getAnsShopBasic().getShopLogo()==null){

        }else {
            String shopLogo = item.getAnsShopBasic().getShopLogo();
            String[] shop_logo = shopLogo.split(",");
            Glide.with(context).load(shop_logo[0]).placeholder(R.drawable.dismiss).into(iv_search_shop_head);
        }


        ImageView iv_homepage_list_queen = helper.getView(R.id.iv_homepage_list_queen);

        if(item.getAnsShopBasic().getQueenCard().equals("0")){
            iv_homepage_list_queen.setVisibility(View.GONE);
        }else{
            iv_homepage_list_queen.setVisibility(View.VISIBLE);
        }
    }
}
