package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;

import java.util.List;

//号码设置内部类
public class PositionListAdapter extends BaseAdapter {

    private int selectedPosition = -1;// 选中的位置

    private Context context;

    private List<String> list;

    private String CurrentContent = "";

    public PositionListAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_phone_list, null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv_phone_category);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv_phone_chosen);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        //缓存的选中位置
        int CurrentPosition = Integer.parseInt(getCurrentPosition());
        //当前位置是选中位置
        if (CurrentPosition == position) {
            convertView.setSelected(true);
            convertView.setPressed(true);
            holder.iv.setImageResource(R.drawable.icon_checked);
        }
        //当前不是选中位置
        else {
            convertView.setSelected(false);
            convertView.setPressed(false);
            holder.iv.setImageResource(R.drawable.icon_unchecked);
        }
        return convertView;
    }

    class ViewHolder{
        TextView tv;
        ImageView iv;
    }

    public Context getContext() {
        return context;
    }

    private String getCurrentPosition(){
        SharedPreferences preferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        CurrentContent = preferences.getString("CurrentPosition", "0");
        return CurrentContent;
    }

}
