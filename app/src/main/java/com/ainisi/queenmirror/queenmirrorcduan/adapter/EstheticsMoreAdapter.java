package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class EstheticsMoreAdapter extends BaseQuickAdapter<EstheticsBean.BodyBean.ShopListBean,BaseViewHolder> {

    Context context;
    double distance;
    List<EstheticsBean.BodyBean.ShopListBean> data;
    public EstheticsMoreAdapter(Context context, int layoutResId, @Nullable List<EstheticsBean.BodyBean.ShopListBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<EstheticsBean.BodyBean.ShopListBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
    @Override
    protected void convert(BaseViewHolder helper, EstheticsBean.BodyBean.ShopListBean item) {

        String shop_logo = item.getAnsShopBasic().getShopLogo();
        String[] shopLogo = shop_logo.split(",");
        ImageView iv_homepage_shop = helper.getView(R.id.iv_homepage_shop_listview);
        Glide.with(context).load(shopLogo[0]).placeholder(R.drawable.dismiss).into(iv_homepage_shop);
        helper.setText(R.id.tv_sort_name,item.getAnsShopBasic().getShopName())
                .setText(R.id.tv_sort_time,"营业时间"+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());

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

        String comRate="1";
        if(item.getComScore()== null||item.getComScore().equals("")){
            comRate = "1";
        }else {
            comRate =item.getComScore();
        }
        CustomRatingBar iv_xingxing = helper.getView(R.id.sort_groupshop);
        iv_xingxing.setRating(Float.parseFloat(comRate));
    }
}