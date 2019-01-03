package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RateGridViewAdapter extends BaseAdapter {
    private List<String> imgPaths = new ArrayList<>();//图片地址集合
    private Context context;
    private OnItemClickListen mOnItemClickListen;
    public RateGridViewAdapter(Context context , List<String> imgPaths) {
        this.context = context;
        this.imgPaths = imgPaths;
    }

    @Override
    public int getCount() {
        if(imgPaths.size() == 6){
            return 6;
        }
        return imgPaths.size()+1 ;
    }

    @Override
    public Object getItem(int position) {
        return  null;
    }

    @Override
    public long getItemId(int position) {
        return  0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.griditem_addpic, parent, false);
            holder = new ViewHolder();

            holder.iv_gridview_image = convertView.findViewById(R.id.iv_gridview_image);
            holder.ico_pic_cancle_40px = convertView.findViewById(R.id.ico_pic_cancle_40px);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == imgPaths.size()) {
            //显示加
            holder.iv_gridview_image.setImageResource(R.mipmap.icon_order_add);
            holder.ico_pic_cancle_40px.setImageResource(0);

            holder.iv_gridview_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnItemClickListen != null){
                        mOnItemClickListen.OnItemClickAdd();
                    }
                }
            });
        } else {
            holder.iv_gridview_image.setOnClickListener(null);
            Glide.with(context).load(Uri.fromFile( new File( imgPaths.get(position)))).placeholder(R.drawable.dismiss).into(holder.iv_gridview_image);
            holder.ico_pic_cancle_40px.setImageResource(R.drawable.icon_dialog_dismess);
            holder.ico_pic_cancle_40px.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListen.OnItemClickDel(position);
                    Log.d("RateGridViewAdapter", "position:" + position);
                }
            });

        }
        return convertView;
    }


    //就是View的持有
    public final class ViewHolder {
        private ImageView iv_gridview_image;
        private ImageView ico_pic_cancle_40px;
    }

    public interface OnItemClickListen{
        void OnItemClickAdd();
        void OnItemClickDel(int position);

    }

    public void setOnItemClickListen(OnItemClickListen onItemClickListen){
        this.mOnItemClickListen = onItemClickListen;
    }
}
