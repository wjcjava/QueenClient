package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/14 11:04
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class NewTopAdapter extends BaseAdapter {
    private Context mContext;
    private List<HomeIndustryBean.BodyBean.CategoryListDataBean> mList;

    public NewTopAdapter(Context context, List<HomeIndustryBean.BodyBean.CategoryListDataBean> list) {
        this.mContext = context;
        if (this.mList == null) {
            mList = new ArrayList<>();
        }
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_newtop, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTvHomeEsthetics.setText(mList.get(i).getEcCategory().getTabName());
        Glide.with(mContext).load(mList.get(i).getEcCategory().getTabPic()).placeholder(R.drawable.dismiss).into(holder.mIvHomeNewFirst);
        return view;
    }

    class ViewHolder {
        @Bind(R.id.iv_home_new_first)
        ImageView mIvHomeNewFirst;
        @Bind(R.id.tv_home_esthetics)
        TextView mTvHomeEsthetics;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
