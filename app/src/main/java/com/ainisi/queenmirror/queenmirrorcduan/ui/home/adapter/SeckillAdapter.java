package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SecKillListBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/28 13:21
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SeckillAdapter extends BaseAdapter {
    private Context mContext;
    private int mType;
    private List<SecKillListBean.BodyBean.ListBean> mList;

    public SeckillAdapter(Context context) {
        this.mContext = context;
        if (mList == null) {
            mList = new ArrayList<>();
        }
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public List<SecKillListBean.BodyBean.ListBean> getList() {
        return mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_seckill, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (mList.get(position).getPackageThumb() != null) {
            String[] split = mList.get(position).getPackageThumb().split(",");
            Glide.with(mContext).load(split[0]).into(holder.mSeckillImg);
        }
        holder.mSeckillPricetwo.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.mSeckillTitle.setText(mList.get(position).getPackageName());
        holder.mSeckillContent.setText(mList.get(position).getPackageGoodsName());
        holder.mSeckillPrice.setText(mList.get(position).getPackagePrice());
        holder.mSeckillPricetwo.setText("¥" + mList.get(position).getOfflinePrice());
        switch (mType) {
            //已秒杀
            case 1:
                holder.mSeckillLl.setVisibility(View.GONE);
                holder.mSeckillBtn.setText(mContext.getString(R.string.seckill_8));
                holder.mSeckillBtn.setSelected(true);
                break;
            //秒杀中
            case 2:
                holder.mSeckillLl.setVisibility(View.VISIBLE);
                if (mList.get(position).getSalesProgressRate() < 100) {
                    holder.mSeckillBtn.setSelected(false);
                    holder.mSeckillBtn.setText(mContext.getString(R.string.seckill_7));
                    holder.mSeckillLl.setVisibility(View.VISIBLE);
                    holder.mSeckillNum.setText("已售" + mList.get(position).getSalesProgressRate() + "%");
                    holder.mSeckillProgressbar.setProgress(mList.get(position).getSalesProgressRate());
                } else {
                    holder.mSeckillBtn.setSelected(true);
                    holder.mSeckillBtn.setText(mContext.getString(R.string.seckill_14));
                    holder.mSeckillLl.setVisibility(View.GONE);
                }
                break;
            //即将秒杀
            case 3:
                holder.mSeckillLl.setVisibility(View.GONE);
                holder.mSeckillBtn.setText(mContext.getString(R.string.seckill_9));
                holder.mSeckillBtn.setSelected(true);
                break;
        }

        return view;
    }

    class ViewHolder {
        @Bind(R.id.seckill_img)
        ImageView mSeckillImg;
        @Bind(R.id.seckill_title)
        TextView mSeckillTitle;
        @Bind(R.id.seckill_content)
        TextView mSeckillContent;
        @Bind(R.id.seckill_price)
        TextView mSeckillPrice;
        @Bind(R.id.seckill_pricetwo)
        TextView mSeckillPricetwo;
        @Bind(R.id.seckill_btn)
        TextView mSeckillBtn;
        @Bind(R.id.seckill_num)
        TextView mSeckillNum;
        @Bind(R.id.seckill_progressbar)
        ProgressBar mSeckillProgressbar;
        @Bind(R.id.seckill_ll)
        LinearLayout mSeckillLl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
