package com.ainisi.queenmirror.queenmirrorcduan.ui.order.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：linxi on 2018/10/24 10:37
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class WholeAdapter extends RecyclerView.Adapter<WholeAdapter.ViewHolder> {
    private Context mContext;
    private List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> mList = new ArrayList<>();

    public WholeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public WholeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sbmitrecycler, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WholeAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
