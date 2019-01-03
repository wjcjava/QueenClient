package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.util.List;

/**
 * Created by john on 2018/9/19.
 *
 * jl
 */

public class GridViewOneAdapter extends BaseAdapter {
    private final List<String> list;
    private Context context;

    public GridViewOneAdapter(Context context, List<String> list) {
        this.context = context;
        this.list =list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.layout_rank_gridview, parent, false);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        return convertView;

    }
    //就是View的持有
    public final class ViewHolder{

    }
}
