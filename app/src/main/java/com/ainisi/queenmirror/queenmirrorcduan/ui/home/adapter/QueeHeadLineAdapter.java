package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PageBannerBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 作者：linxi on 2018/9/18 10:41
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class QueeHeadLineAdapter extends RecyclerView.Adapter<QueeHeadLineAdapter.ViewHolder> {
    private Context mContext;
    private List<PageBannerBean.BodyBean.BannerListDataBean> bannerList;

    public QueeHeadLineAdapter(Context mContext, List<PageBannerBean.BodyBean.BannerListDataBean> bannerList) {
        this.mContext = mContext;
        this.bannerList = bannerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mine_homepager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_shop.setText(bannerList.get(position).getBannerName());

        if (bannerList.get(position).getBannerLabel() == null || bannerList.get(position).getBannerLabel().equals("")) {
            holder.tv_new.setVisibility(View.GONE);
        } else {
            holder.tv_new.setVisibility(View.VISIBLE);
            holder.tv_new.setText(bannerList.get(position).getBannerLabel());
        }

        holder.tv_mine_pager_number.setText(bannerList.get(position).getBannerPreview());
        Glide.with(mContext).load(bannerList.get(position).getBannerLogo()).into(holder.iv_mine_homepager_title);

        holder.tv_name.setText("发布日期：" + bannerList.get(position).getReleaseDate());


        holder.rl_queen_headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HomeAdvertisingActivity.class);
                intent.putExtra("bannerId", bannerList.get(position).getId());
                intent.putExtra("bannerStyle", bannerList.get(position).getBannerStyle());
                intent.putExtra("weburl", bannerList.get(position).getBannerUrl());
                intent.putExtra("bannerLogo", bannerList.get(position).getBannerLogo());
                intent.putExtra("bannerTitle", bannerList.get(position).getBannerName());
                mContext.startActivity(intent);
                int num = Integer.valueOf(bannerList.get(position).getBannerPreview());
                bannerList.get(position).setBannerPreview(String.valueOf(num + 1));
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_shop, tv_name, tv_new, tv_mine_pager_number;
        private ImageView iv_mine_homepager_title;
        private RelativeLayout rl_queen_headline;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_shop = itemView.findViewById(R.id.tv_shop);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_new = itemView.findViewById(R.id.tv_new);
            tv_mine_pager_number = itemView.findViewById(R.id.tv_mine_pager_number);
            iv_mine_homepager_title = itemView.findViewById(R.id.iv_mine_homepager_title);
            rl_queen_headline = itemView.findViewById(R.id.rl_queen_headline);
        }
    }
}
