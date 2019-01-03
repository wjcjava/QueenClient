package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineFollowBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DistanceGet;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MineFollowAdapter extends BaseQuickAdapter<MineFollowBean.BodyBean.CommentsListDataBean,BaseViewHolder> {


    Context context;
    private double distance;
    String mine_lon, mine_lat, shop_lon, shop_lat;
    List<MineFollowBean.BodyBean.CommentsListDataBean> data = new ArrayList<>();
    public MineFollowAdapter(Context context,int layoutResId, @Nullable List<MineFollowBean.BodyBean.CommentsListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }
    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MineFollowBean.BodyBean.CommentsListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, MineFollowBean.BodyBean.CommentsListDataBean item) {

        if(item.getAnsShopBasic().getShopName() == null||item.getAnsShopBasic().getOpenTime() == null || item.getAnsShopBasic().getCloseTime() == null){
            helper.setText(R.id.foot_name,"")
                    .setText(R.id.tv_mine_follow_score,"5");
        }else{
            helper.setText(R.id.foot_name,item.getAnsShopBasic().getShopName().toString())
                    .setText(R.id.tv_mine_follow_score,"5")
                    .setText(R.id.sort_time,"营业时间："+item.getAnsShopBasic().getOpenTime()+"-"+item.getAnsShopBasic().getCloseTime());
        }
        String shop_logo = item.getAnsShopBasic().getShopLogo();
        String[] logo = shop_logo.split(",");
        ImageView iv_mine_fllow_logo = helper.getView(R.id.iv_mine_fllow_logo);
        Glide.with(context).load(logo[0]).placeholder(R.drawable.dismiss).into(iv_mine_fllow_logo);

        mine_lon = SP.get(context, SpContent.UserLon, "0") + "";
        mine_lat = SP.get(context, SpContent.UserLat, "0") + "";
        shop_lon = item.getAnsShopBasic().getGeoX()+"";
        shop_lat = item.getAnsShopBasic().getGeoY()+"";

        distance = (DistanceGet.getDistance(Double.parseDouble(shop_lat), Double.parseDouble(shop_lon), Double.parseDouble(mine_lat), Double.parseDouble(mine_lon))) / 1000;
        TextView distance_text = helper.getView(R.id.sort_distance);
        if(mine_lon.equals("0")){
            distance_text.setText("暂无定位信息");
        }else {
            distance_text.setText("相距 " + MD5.doubleToString(String.valueOf(distance)) + "km");
        }

        CustomRatingBar score_mine_follow_evaluate = helper.getView(R.id.score_mine_foot_evaluate);
        float rating;
        if(item.getComScore() == null||item.getComScore().equals("")||item.getComScore().equals("0.0")){
            rating= 3.5f;
        }else {
            rating = Float.parseFloat(item.getComScore());
        }
        score_mine_follow_evaluate.setRating(rating);
        helper.setText(R.id.tv_mine_follow_score,item.getComScore());
    }
}
