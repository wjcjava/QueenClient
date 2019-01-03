package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SpecialCommentBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseNowActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/10/19 16:09
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class SpecialPriceGvAdapter extends BaseAdapter {
    private Context mContext;
    private List<SpecialCommentBean.BodyBean.SpecialOfferGoodsRecommendedListBean> mList;

    public SpecialPriceGvAdapter(Context mContext, List<SpecialCommentBean.BodyBean.SpecialOfferGoodsRecommendedListBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_specialpricegv, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String[] split = mList.get(i).getGoodsThumb().split(",");
        Glide.with(mContext).load(split[0]).into(holder.mImg);
        holder.mPrice.setText(String.valueOf(mList.get(i).getSalesPrice()));
        holder.mOldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.mOldprice.setText("原价：" + mList.get(i).getMarketPrice());
        holder.mBuynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SP.get(mContext, SpContent.isLogin, "").equals("1")) {
                    Intent intent = new Intent(mContext, PurchaseNowActivity.class);
                    intent.putExtra("shopName", mList.get(i).getShopName());
                    intent.putExtra("shopId", mList.get(i).getShopId());
                    intent.putExtra("goodId", mList.get(i).getId());
                    intent.putExtra("goodName", mList.get(i).getGoodsName());
                    intent.putExtra("goodPrice", String.valueOf(mList.get(i).getSalesPrice()));
                    intent.putExtra("goodPriceSale", String.valueOf(mList.get(i).getMarketPrice()));
                    intent.putExtra("goods_image", mList.get(i).getGoodsThumb());
                    intent.putExtra("isBean", "0");
                    intent.putExtra("isQueenVip", "false");
                    intent.putExtra("disCount", "10");
                    intent.putExtra("buyRules", "1");
                    mContext.startActivity(intent);
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    mContext.startActivity(intent);
                }
            }
        });
        return view;
    }

    class ViewHolder {
        @Bind(R.id.img)
        ImageView mImg;
        @Bind(R.id.price)
        TextView mPrice;
        @Bind(R.id.oldprice)
        TextView mOldprice;
        @Bind(R.id.buynow)
        TextView mBuynow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
