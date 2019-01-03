package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullTwoActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PackageInfoBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 作者：linxi on 2018/10/9 10:13
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class CombinationAdapter extends RecyclerView.Adapter<CombinationAdapter.ViewHolder> {
    private Context mContext;
    private List<PackageInfoBean.BodyBean.SecKillPackageInfoBean.SecKillGoodsListBean> mList;

    public CombinationAdapter(Context context, List<PackageInfoBean.BodyBean.SecKillPackageInfoBean.SecKillGoodsListBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public CombinationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_combination, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CombinationAdapter.ViewHolder holder, final int position) {
        if (position == 0) {
            holder.combin_add.setVisibility(View.GONE);
        } else {
            holder.combin_add.setVisibility(View.VISIBLE);
        }
        String[] split = mList.get(position).getGoodsCover().split(",");
        Glide.with(mContext).load(split[0]).into(holder.mImageView);
        holder.mTextView.setText(mList.get(position).getGoodsName());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FullTwoActivity.class);
                intent.putExtra("id", mList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView, combin_add;
        private TextView mTextView;
        private LinearLayout mRelativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.combin_img);
            combin_add = itemView.findViewById(R.id.combin_add);
            mTextView = itemView.findViewById(R.id.combin_tv);
            mRelativeLayout = itemView.findViewById(R.id.combin_rl);
        }
    }
}
