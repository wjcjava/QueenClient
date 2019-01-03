package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by john on 2018/6/2.
 */

public class PreferentialAdapter extends RecyclerView.Adapter<PreferentialAdapter.MyViewHolder> {

    //这个是checkbox的Hashmap集合
    private final HashMap<Integer, Boolean> map;
    //这个是数据集合
    private final List<PreferentialBean.BodyBean.FeatureKeysListDataBean> list;

    public PreferentialAdapter(List<PreferentialBean.BodyBean.FeatureKeysListDataBean> merchantsList) {
        map = new HashMap<>();
        this.list=merchantsList;
        for (int i = 0; i < list.size(); i++) {

            map.put(i, false);
        }

    }

    /**
     * 单选
     *
     * @param postion
     */
    public void singlesel(int postion) {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(false);
        }
        map.put(postion, true);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_preferential, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //放入集合中的值
        holder.checkBox.setText(list.get(position).getEcTab().getTabName());
        holder.checkBox.setChecked(map.get(position));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put(position, !map.get(position));
                //刷新适配器
                notifyDataSetChanged();
                //单选
                singlesel(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkBox =itemView.findViewById(R.id.tv_preferential_name);
        }
    }
}
