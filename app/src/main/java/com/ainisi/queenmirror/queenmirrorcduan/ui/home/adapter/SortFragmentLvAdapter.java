package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsRanking;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DensityUtils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/19 09:04
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SortFragmentLvAdapter extends BaseAdapter {
    private Context mContext;
    private List<GoodsRanking.BodyBean.GoodsRankingListBean> mList;
    private String mRankingList;
    private int num;

    public SortFragmentLvAdapter(Context mContext, String rankingList) {
        this.mContext = mContext;
        this.mRankingList = rankingList;
        if (mList == null) {
            mList = new ArrayList<>();
        }
    }

    public List<GoodsRanking.BodyBean.GoodsRankingListBean> getList() {
        return mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_sort_fragment_lv, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Shader shader = new LinearGradient(0, 0, 0, 20,
                ContextCompat.getColor(mContext, R.color.color5),
                ContextCompat.getColor(mContext, R.color.color4),
                Shader.TileMode.CLAMP);
        holder.mSortFgPrice.getPaint().setShader(shader);
        switch (position) {
            case 0:
                holder.mSortfgnumbertv.setVisibility(View.GONE);
                holder.mSortFgNumberimg.setVisibility(View.VISIBLE);
                holder.mSortFgNumberimg.setImageResource(R.drawable.one);
                break;
            case 1:
                holder.mSortfgnumbertv.setVisibility(View.GONE);
                holder.mSortFgNumberimg.setVisibility(View.VISIBLE);
                holder.mSortFgNumberimg.setImageResource(R.drawable.two);
                break;
            case 2:
                holder.mSortfgnumbertv.setVisibility(View.GONE);
                holder.mSortFgNumberimg.setVisibility(View.VISIBLE);
                holder.mSortFgNumberimg.setImageResource(R.drawable.three);
                break;
            default:
                holder.mSortFgNumberimg.setVisibility(View.GONE);
                holder.mSortfgnumbertv.setVisibility(View.VISIBLE);
                holder.mSortfgnumbertv.setText(position + 1 + "名");
                break;
        }
        if (!TextUtils.isEmpty(mList.get(position).getGoodsThumb())) {
            String[] split = mList.get(position).getGoodsThumb().split(",");
            Glide.with(mContext).load(split[0]).into(holder.mSortFgImg);
        }
        holder.mSortFgName.setText(mList.get(position).getGoodsName());
        holder.mSortFgSub.setText(mList.get(position).getGoodsBrief());
        if ("1".equals(mList.get(position).getPointRule())) {
            holder.mSortFgItme1.setVisibility(View.VISIBLE);
        } else {
            holder.mSortFgItme1.setVisibility(View.GONE);
        }
        //魔豆
        if ("1".equals(mList.get(position).getIfPoint())) {
            holder.mSortFgItme2.setVisibility(View.VISIBLE);
        } else {
            holder.mSortFgItme2.setVisibility(View.GONE);
        }
        //拼团1
        if ("1".equals(mList.get(position).getGroupGoods())) {
            holder.mSortFgItme3.setVisibility(View.VISIBLE);
            holder.mSortFgPrice.setText("¥" + mList.get(position).getGroupPrice());
        } else {
            holder.mSortFgItme3.setVisibility(View.GONE);
            holder.mSortFgPrice.setText("¥" + mList.get(position).getSalesPrice());
        }
        //限购1
        if ("1".equals(mList.get(position).getBuyRule())) {
            holder.mSortFgItme4.setVisibility(View.VISIBLE);
        } else {
            holder.mSortFgItme4.setVisibility(View.GONE);
        }
        holder.mSortFgRatingbar.setRating(mList.get(position).getGoodsEvaluation());
        ViewGroup.LayoutParams layoutParams = holder.mSortFgView.getLayoutParams();
        switch (mRankingList) {
            //人气榜
            case "1":
                if (position == 0) {
                    num = mList.get(position).getGoodsSentiment();
                    if (num == 0) {
                        num = 1;
                    }
                }
                holder.mSortFgNum.setText("浏览：" + mList.get(position).getGoodsSentiment());
                layoutParams.width = Integer.valueOf(DensityUtils.dp2px(mContext, 60f) * mList.get(position).getGoodsSentiment() / num);
                break;
            //热销榜
            case "2":
                if (position == 0) {
                    num = mList.get(position).getGoodsSales();
                    if (num == 0) {
                        num = 1;
                    }
                }
                holder.mSortFgNum.setText("月销：" + mList.get(position).getGoodsSales());
                layoutParams.width = Integer.valueOf(DensityUtils.dp2px(mContext, 60f) * mList.get(position).getGoodsSales() / num);
                break;
            //好评榜
            case "3":
                if (position == 0) {
                    num = mList.get(position).getGoodsPraise();
                    if (num == 0) {
                        num = 1;
                    }
                }
                holder.mSortFgNum.setText("好评：" + mList.get(position).getGoodsPraise());
                layoutParams.width = Integer.valueOf(DensityUtils.dp2px(mContext, 60f) * mList.get(position).getGoodsPraise() / num);
                break;
        }
        holder.mSortFgView.setLayoutParams(layoutParams);
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.sort_fg_numberimg)
        ImageView mSortFgNumberimg;
        @Bind(R.id.sort_fg_img)
        ImageView mSortFgImg;
        @Bind(R.id.sort_fg_name)
        TextView mSortFgName;
        @Bind(R.id.sort_fg_sub)
        TextView mSortFgSub;
        @Bind(R.id.sort_fg_ratingbar)
        CustomRatingBar mSortFgRatingbar;
        @Bind(R.id.sort_fg_itme1)
        TextView mSortFgItme1;
        @Bind(R.id.sort_fg_itme2)
        TextView mSortFgItme2;
        @Bind(R.id.sort_fg_itme3)
        TextView mSortFgItme3;
        @Bind(R.id.sort_fg_itme4)
        TextView mSortFgItme4;
        @Bind(R.id.sort_fg_view)
        View mSortFgView;
        @Bind(R.id.sort_fg_num)
        TextView mSortFgNum;
        @Bind(R.id.sort_fg_price)
        TextView mSortFgPrice;
        @Bind(R.id.sort_fg_numbertv)
        TextView mSortfgnumbertv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
