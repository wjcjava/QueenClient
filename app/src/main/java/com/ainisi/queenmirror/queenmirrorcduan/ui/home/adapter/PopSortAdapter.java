package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/18 13:36
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class PopSortAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int position;

    public PopSortAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
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
            view = View.inflate(mContext, R.layout.pop_sort_gv, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mSortGvTv.setText(mList.get(i));
        if (position == i) {
            holder.mSortGvTv.setTextColor(ContextCompat.getColor(mContext, R.color.grey_color1));
        } else {
            holder.mSortGvTv.setTextColor(ContextCompat.getColor(mContext, R.color.order_number));
        }
        return view;
    }

    class ViewHolder {
        @Bind(R.id.sort_gv_tv)
        TextView mSortGvTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
