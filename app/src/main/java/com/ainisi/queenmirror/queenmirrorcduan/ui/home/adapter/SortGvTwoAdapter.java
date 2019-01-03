package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsScreenBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/17 14:07
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SortGvTwoAdapter extends BaseAdapter {
    private Context mContext;
    private List<GoodsScreenBean.BodyBean.GoodsScreeningBean> mlist;

    public SortGvTwoAdapter(Context mContext) {
        this.mContext = mContext;
        if (mlist == null) {
            mlist = new ArrayList<>();
        }
    }

    public List<GoodsScreenBean.BodyBean.GoodsScreeningBean> getList() {
        return mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_sortgv, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(mlist.get(position).getGoodsThumb().split(",")[0]).into(holder.mSortGvItemImg);
        holder.mSortGvItemPrice.setText("¥" + mlist.get(position).getSalesPrice());
        holder.mSortGvItemTitle.setText(mlist.get(position).getGoodsName());
        return view;
    }

    class ViewHolder {
        @Bind(R.id.sort_gv_item_img)
        ImageView mSortGvItemImg;
        @Bind(R.id.sort_gv_item_price)
        TextView mSortGvItemPrice;
        @Bind(R.id.sort_gv_item_title)
        TextView mSortGvItemTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
