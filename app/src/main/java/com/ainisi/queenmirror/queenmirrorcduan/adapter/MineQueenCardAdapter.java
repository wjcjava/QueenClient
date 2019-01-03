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
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineQueenCardBottomActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/8/14.
 */

public class MineQueenCardAdapter extends BaseAdapter{

    private Context context;
    List<MineQueenCardBean.BodyBean.ListBean> ShopListData = new ArrayList<>();

    public MineQueenCardAdapter(Context context,List<MineQueenCardBean.BodyBean.ListBean> ShopListData) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.mine_queen_card_list_item, parent, false);
            holder.iv_mine_queen_card_image = convertView.findViewById(R.id.iv_mine_queen_card_image);
            holder.tv_mine_queen_card_text = convertView.findViewById(R.id.tv_mine_queen_card_text);
            holder.li_mine_queen_card_listitem = convertView.findViewById(R.id.li_mine_queen_card_listitem);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_mine_queen_card_text.setText(ShopListData.get(position).getRoyaltyName());
        Glide.with(context).load(ShopListData.get(position).getIcon()).placeholder(R.drawable.dismiss).into(holder.iv_mine_queen_card_image);

        final String[] input = new String[ShopListData.size()];
        final String[] text_name = new String [ShopListData.size()];
        for(int i=0;i<ShopListData.size();i++){
            input[i] = ShopListData.get(i).getContent();
            text_name[i] = ShopListData.get(i).getRoyaltyName();
        }

        holder.li_mine_queen_card_listitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentd = new Intent(context,MineQueenCardBottomActivity.class);
                intentd.putExtra("where",position+"");
                intentd.putExtra("text_name",text_name);
                intentd.putExtra("input",input);
                intentd.putExtra("changdu",ShopListData.size()+"");
                context.startActivity(intentd);
            }
        });

        return convertView;

    }
    //就是View的持有
    public final class ViewHolder{
        ImageView iv_mine_queen_card_image;
        TextView tv_mine_queen_card_text;
        LinearLayout li_mine_queen_card_listitem;
    }
}
