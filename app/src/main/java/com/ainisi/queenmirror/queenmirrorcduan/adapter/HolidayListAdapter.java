package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HolidayListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/9/11.
 *
 * jl
 */

public class HolidayListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    Context context;
    List<HolidayListBean.BodyBean.BannerListBean> bannerList = new ArrayList<>();

    public HolidayListAdapter(Context context,List<HolidayListBean.BodyBean.BannerListBean> bannerList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.bannerList = bannerList;
    }

    @Override
    public int getCount() {
        return bannerList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.layout_holiday_list_item_first, viewGroup, false);
            holder.iv_holiday_image = convertView.findViewById(R.id.iv_holiday_image);
            holder.rl_holiday_list_click = convertView.findViewById(R.id.rl_holiday_list_click);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String image = bannerList.get(i).getBannerLogo();

        L.e("???????????              "+image);

        Glide.with(context).load(image).dontAnimate().into(holder.iv_holiday_image);

        holder.rl_holiday_list_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FightaloneActivity.class);
                intent.putExtra("activityId", bannerList.get(i).getActivityId());
                intent.putExtra("goodsName", "");
                intent.putExtra("goodsId", bannerList.get(i).getGoodsId());
                intent.putExtra("goodsBrief", "");
                intent.putExtra("goodsService", "");
                intent.putExtra("goodsSales", "");
                intent.putExtra("goodsGroup","");
                intent.putExtra("goodsMarket", "");

                context.startActivity(intent);
            }
        });
        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        ImageView iv_holiday_image;
        RelativeLayout rl_holiday_list_click;
    }

}
