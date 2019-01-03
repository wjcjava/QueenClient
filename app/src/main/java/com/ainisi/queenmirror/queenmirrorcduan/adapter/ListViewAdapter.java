package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopMallListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class ListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopMallListBean.BodyBean.ShopListBean> shopListNew = new ArrayList<>();

    public ListViewAdapter(Context context,List<ShopMallListBean.BodyBean.ShopListBean> shopListNew) {
        this.context = context;
        this.shopListNew = shopListNew;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return shopListNew.size();
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

            convertView = inflater.inflate(R.layout.item_shortrecycler, parent, false);

            holder.li_home_short = convertView.findViewById(R.id.li_home_short);
            holder.sote_name = convertView.findViewById(R.id.sote_name);
            holder.sort_time = convertView.findViewById(R.id.sort_time);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.sote_name.setText(shopListNew.get(position).getAnsShopBasic().getShopName());
        holder.sort_time.setText(shopListNew.get(position).getAnsShopBasic().getOpenTime()+"-"+shopListNew.get(position).getAnsShopBasic().getCloseTime());

        holder.li_home_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, WorkRoomDetailActivity.class);
                intent.putExtra("shopName",shopListNew.get(position).getAnsShopBasic().getShopName());
                intent.putExtra("shopId",shopListNew.get(position).getAnsShopBasic().getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder{
        private LinearLayout li_home_short;
        private TextView sote_name;
        private TextView sort_time;
    }
}
