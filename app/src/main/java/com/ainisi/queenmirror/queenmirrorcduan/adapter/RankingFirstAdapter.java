package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RankingListBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/9/19.
 * <p>
 * jl
 */

public class RankingFirstAdapter extends BaseQuickAdapter<RankingListBean.BodyBean.ListBean, BaseViewHolder> {
    Context context;
    List<RankingListBean.BodyBean.ListBean> data = new ArrayList<>();
    String isTop;
    String rankingType;


    public RankingFirstAdapter(Context context, int layoutResId, List<RankingListBean.BodyBean.ListBean> data, String isTop, String rankingType) {
        super(layoutResId, data);
        this.data = data;
        this.context = context;
        this.isTop = isTop;
        this.rankingType = rankingType;
    }

    @Override
    protected void convert(BaseViewHolder helper, RankingListBean.BodyBean.ListBean item) {

        ImageView iv_homepage_shop_listview = helper.getView(R.id.iv_homepage_shop_listview);
        if (item.getShopLogo() == null || item.getShopLogo().equals("")) {

        } else {
            Glide.with(context).load(item.getShopLogo()).dontAnimate().into(iv_homepage_shop_listview);
        }

        helper.setText(R.id.tv_sort_name, item.getShopName())
                .setText(R.id.tv_sort_time, "营业时间：" + item.getOpenTime() + "-" + item.getCloseTime());
        CustomRatingBar sort_groupshop = helper.getView(R.id.sort_groupshop);
        sort_groupshop.setRating(Float.parseFloat(item.getComScore()));
        helper.setText(R.id.sort_distance, item.getDistance());

        TextView tv_sort_first = helper.getView(R.id.tv_sort_first);
        TextView tv_sort_second = helper.getView(R.id.tv_sort_second);
        TextView tv_sort_third = helper.getView(R.id.tv_sort_third);
        TextView tv_sort_forth = helper.getView(R.id.tv_sort_forth);

        // groupGoods拼团   bargainGoods特价      magicBean魔豆     discountCoupon优惠券

        if (Double.parseDouble(item.getDiscountCoupon()) > 0) {
            tv_sort_first.setVisibility(View.VISIBLE);
        }
        if (Double.parseDouble(item.getBargainGoods()) > 0) {
            tv_sort_forth.setVisibility(View.VISIBLE);
        }
        if (Double.parseDouble(item.getGroupGoods()) > 0) {
            tv_sort_third.setVisibility(View.VISIBLE);
        }
        if (Double.parseDouble(item.getMagicBean()) > 0) {
            tv_sort_second.setVisibility(View.VISIBLE);
        }

        int pos = helper.getLayoutPosition();
        if (isTop.equals("true")) {
            pos = pos + 1;
        } else {
            pos = pos + 4;
        }
        if (pos < 10) {
            helper.setText(R.id.tv_rank_number, "TOP 0" + pos);
        } else {
            helper.setText(R.id.tv_rank_number, "TOP " + pos);
        }

        if (rankingType.equals("关注榜")) {
            helper.setText(R.id.tv_sort_score, "关注 " + item.getCount());
        } else if (rankingType.equals("收藏榜")) {
            helper.setText(R.id.tv_sort_score, "收藏 " + item.getCount());
        } else if (rankingType.equals("口碑榜")) {
            helper.setText(R.id.tv_sort_score, "口碑 " + item.getCount());
        } else if (rankingType.equals("环境榜")) {
            helper.setText(R.id.tv_sort_score, "环境 " + item.getCount());
        } else if (rankingType.equals("技师榜")) {
            helper.setText(R.id.tv_sort_score, "技师 " + item.getCount());
        } else if (rankingType.equals("销售榜")) {
            helper.setText(R.id.tv_sort_score, "销售 " + item.getCount());
        }
    }

    public void Clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<RankingListBean.BodyBean.ListBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
