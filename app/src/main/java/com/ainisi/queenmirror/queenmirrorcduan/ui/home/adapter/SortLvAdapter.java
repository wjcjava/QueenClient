package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/17 13:06
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SortLvAdapter extends BaseAdapter {
    private Context mContext;
    private int position = 0;
    private HomeIndustryBean homeIndustryBean;

    public SortLvAdapter(Context context, HomeIndustryBean homeIndustryBean) {
        this.mContext = context;
        this.homeIndustryBean = homeIndustryBean;
    }

    public void setposition(int i) {
        this.position = i;
    }

    @Override
    public int getCount() {
        return homeIndustryBean.getBody().getCategoryListData().size();
    }

    @Override
    public Object getItem(int i) {
        return homeIndustryBean.getBody().getCategoryListData().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_sort_lv_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mSortLvItemTv.setText(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
        if (i == position) {
            holder.mSortLvItemImg.setVisibility(View.VISIBLE);
            holder.mSortLvItemLl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.sort));
            Shader shader = new LinearGradient(0, 0, 0, 20,
                    ContextCompat.getColor(mContext, R.color.color5),
                    ContextCompat.getColor(mContext, R.color.color4),
                    Shader.TileMode.CLAMP);
            holder.mSortLvItemTv.getPaint().setShader(shader);
        } else {
            holder.mSortLvItemImg.setVisibility(View.GONE);
            holder.mSortLvItemLl.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
            Shader shader = new LinearGradient(0, 0, 0, 0,
                    ContextCompat.getColor(mContext, R.color.grey_color1),
                    ContextCompat.getColor(mContext, R.color.grey_color1),
                    Shader.TileMode.CLAMP);
            holder.mSortLvItemTv.getPaint().setShader(shader);
        }
        return view;
    }

    class ViewHolder {
        @Bind(R.id.sort_lv_item_img)
        ImageView mSortLvItemImg;
        @Bind(R.id.sort_lv_item_tv)
        TextView mSortLvItemTv;
        @Bind(R.id.sort_lv_item_ll)
        RelativeLayout mSortLvItemLl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
