package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 * <p>
 * jl
 */

public class FullDetailListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<String> good_pic_detail = new ArrayList<>();

    public FullDetailListViewAdapter(Context context, List<String> good_pic_detail) {
        this.context = context;
        this.good_pic_detail = good_pic_detail;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return good_pic_detail.size();
    }

    @Override
    public Object getItem(int position) {
        return good_pic_detail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.full_detail_list_item, parent, false);
            holder.iv_full_detail_item = convertView.findViewById(R.id.iv_full_detail_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        int wight = TUtil.getScreenWidth(context);
//
//        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) holder.iv_full_detail_item.getLayoutParams(); //取控件textView当前的布局参数
//        linearParams.height = wight * 9 / 16;// 控件的高强制设成20
//
//        linearParams.width = wight;// 控件的宽强制设成30
//
//        holder.iv_full_detail_item.setLayoutParams(linearParams); //使设置好的布局参数应用到控件


        Glide.with(context).load(good_pic_detail.get(position)).into(holder.iv_full_detail_item);

        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {
        private ImageView iv_full_detail_item;
    }


}
