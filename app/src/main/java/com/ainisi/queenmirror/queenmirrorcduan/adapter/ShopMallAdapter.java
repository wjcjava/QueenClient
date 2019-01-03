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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ShopMallAdapter extends BaseAdapter{

    private Context context;
    List<ShopBean> ShopListData = new ArrayList<>();

    public ShopMallAdapter(Context context,List<ShopBean> ShopListData) {
        this.context = context;
        this.ShopListData = ShopListData;
    }
    @Override
    public int getCount() {
        return ShopListData.size();
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

            convertView = LayoutInflater.from(context).inflate(R.layout.re_shopmall_shop, parent, false);
            holder.image_title = convertView.findViewById(R.id.image_title);
            holder.text_name = convertView.findViewById(R.id.text_name);
            holder.li_shop_mall_top = convertView.findViewById(R.id.li_shop_mall_top);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.text_name.setText(ShopListData.get(position).getTextName());
        Glide.with(context).load(ShopListData.get(position).getImageTitle()).placeholder(R.drawable.dismiss).into(holder.image_title);
        holder.li_shop_mall_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EstheticsActivity.class);
                intent.putExtra("shop_name",ShopListData.get(position).getTextName());
                intent.putExtra("categoryId",ShopListData.get(position).getCategoryId());
                intent.putExtra("cpCate","2");
                context.startActivity(intent);
            }
        });

        return convertView;

    }
    //就是View的持有
    public final class ViewHolder{
        ImageView image_title;
        TextView text_name;
        LinearLayout li_shop_mall_top;
    }
}
