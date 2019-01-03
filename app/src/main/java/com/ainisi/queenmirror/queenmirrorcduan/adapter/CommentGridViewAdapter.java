package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShowImageViewActivity;
import com.bumptech.glide.Glide;

/**
 * Created by Mloong on 2017/11/25.
 *
 * jl
 */

public class CommentGridViewAdapter extends BaseAdapter {
    private Context context;
    String[] ShopListData;

    public CommentGridViewAdapter(Context context, String[] ShopListData) {
        this.context = context;
        this.ShopListData = ShopListData;
    }

    @Override
    public int getCount() {
        return ShopListData.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.comment_full_activity_item, parent, false);
            holder.tv_img = convertView.findViewById(R.id.tv_img);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(ShopListData[position]).placeholder(R.drawable.dismiss).into(holder.tv_img);

        holder.tv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image_url = "";
                for(int i=0;i< ShopListData.length;i++){
                    image_url = image_url + ShopListData[i]+",";
                }

                Intent intent = new Intent(context, ShowImageViewActivity.class);
                intent.putExtra("image_url",image_url);
                context.startActivity(intent);
            }
        });

        return convertView;

    }


    //就是View的持有
    public final class ViewHolder {
        ImageView tv_img;
    }
}
