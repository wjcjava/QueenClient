package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRoundAngleImageView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：linxi on 2018/9/14 15:06
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class HomeServerAdapter extends BaseAdapter {
    private Context mContext;
    private List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> mlist;

    public HomeServerAdapter(Context context, List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list) {
        this.mContext = context;
        this.mlist = list;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.adapter_homeserver, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (mlist.get(position).getEcGoodsBasic() != null) {
            holder.mHomeSearchLl1.setVisibility(View.VISIBLE);
            holder.mHomeSearchLl2.setVisibility(View.GONE);
            holder.mHomeSearchPrice2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//            Shader shader = new LinearGradient(0, 0, 0, 20,
//                    ContextCompat.getColor(mContext, R.color.color5),
//                    ContextCompat.getColor(mContext, R.color.color4),
//                    Shader.TileMode.CLAMP);
//            holder.mHomeSearchPrice1.getPaint().setShader(shader);
            String[] split = mlist.get(position).getEcGoodsBasic().getGoodsThumb().split(",");
            Glide.with(mContext).load(split[0]).into(holder.mHomeSearchImg);
            if (!TextUtils.isEmpty(mlist.get(position).getApiGoodsType())) {
                holder.mHomeSearchTv.setVisibility(View.VISIBLE);
                holder.mHomeSearchTv.setText(mlist.get(position).getApiGoodsType());
            } else {
                holder.mHomeSearchTv.setVisibility(View.GONE);
            }
            holder.mHomeSearchPrice1.setText("¥" + mlist.get(position).getEcGoodsBasic().getSalesPrice());
            holder.mHomeSearchPrice2.setText("¥" + mlist.get(position).getEcGoodsBasic().getMarketPrice());
            holder.mHomeSearchTitle.setText(mlist.get(position).getEcGoodsBasic().getGoodsName());
        } else {
            holder.mHomeSearchLl1.setVisibility(View.GONE);
            holder.mHomeSearchLl2.setVisibility(View.VISIBLE);
        }
        return view;
    }

    class ViewHolder {
        @Bind(R.id.home_search_img)
        CustomRoundAngleImageView mHomeSearchImg;
        @Bind(R.id.home_search_tv)
        TextView mHomeSearchTv;
        @Bind(R.id.home_search_price1)
        TextView mHomeSearchPrice1;
        @Bind(R.id.home_search_price2)
        TextView mHomeSearchPrice2;
        @Bind(R.id.home_search_title)
        TextView mHomeSearchTitle;
        @Bind(R.id.home_search_ll1)
        LinearLayout mHomeSearchLl1;
        @Bind(R.id.home_search_ll2)
        LinearLayout mHomeSearchLl2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
