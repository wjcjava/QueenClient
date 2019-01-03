package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/10/17 09:02
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class MineGiftLvAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public MineGiftLvAdapter(Context mContext) {
        this.mContext = mContext;
        String[] stringArray = mContext.getResources().getStringArray(R.array.minegiftlv);
        for (String s : stringArray) {
            mList.add(s);
        }
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
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_minegiftlv_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mMinegiftlvTv.setText(mList.get(i));
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.minegiftlv_tv)
        TextView mMinegiftlvTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
