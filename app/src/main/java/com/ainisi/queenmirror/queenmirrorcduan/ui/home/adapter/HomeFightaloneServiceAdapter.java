package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：linxi on 2018/10/29 14:46
 * 邮箱：707078566@qq.com
 * 用途：
 */
public class HomeFightaloneServiceAdapter extends RecyclerView.Adapter<HomeFightaloneServiceAdapter.ViewHolder> {
    private Context mContext;
    private List<PinTuanBean.BodyBean.GroupActivityListDataBean> mList = new ArrayList<>();

    public HomeFightaloneServiceAdapter(Context context) {
        this.mContext = context;
    }

    public List<PinTuanBean.BodyBean.GroupActivityListDataBean> getList() {
        return mList;
    }

    @Override
    public HomeFightaloneServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_homefightaloneservice, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeFightaloneServiceAdapter.ViewHolder holder, final int position) {
        String goods_thumb = mList.get(position).getEcGoodsBasic().getGoodsThumb();
        String[] doodThumb = goods_thumb.split(",");
        Glide.with(mContext).load(doodThumb[0]).dontAnimate().into(holder.homefight_service_img);
        holder.homefight_service_title.setText(mList.get(position).getGpActivity().getGroupName());
        holder.homefight_service_content.setText(mList.get(position).getEcGoodsBasic().getGoodsBrief());
        holder.tv_fightalone_presentprice.setText(mList.get(position).getGpActivity().getGroupPrice());
        holder.tv_fightalone_presentprice_two.setText(mList.get(position).getGpActivity().getGroupNumber() + "人团·已团" + mList.get(position).getGpActivity().getSaleNums() + "件");
        holder.homefight_service_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, FightaloneActivity.class);
                intent.putExtra("activityId", mList.get(position).getGpActivity().getId());
                intent.putExtra("goodsName", mList.get(position).getEcGoodsBasic().getGoodsName());
                intent.putExtra("goodsId", mList.get(position).getEcGoodsBasic().getId());
                intent.putExtra("goodsBrief", mList.get(position).getEcGoodsBasic().getGoodsBrief());
                intent.putExtra("goodsService", mList.get(position).getEcGoodsBasic().getServiceTime());
                intent.putExtra("goodsSales", mList.get(position).getEcGoodsBasic().getSalesPrice());
                intent.putExtra("goodsGroup", mList.get(position).getGpActivity().getGroupPrice());
                if (mList.get(position).getEcGoodsBasic().getMarketPrice() == null) {
                    intent.putExtra("goodsMarket", "0");
                } else {
                    intent.putExtra("goodsMarket", mList.get(position).getEcGoodsBasic().getMarketPrice());

                }
                //  intent.putExtra("goodsNumber",sortlist.get(position).getEcGoodsBasic().get)
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView homefight_service_img;
        private TextView homefight_service_title, homefight_service_content, tv_fightalone_presentprice, tv_fightalone_presentprice_two;
        private FrameLayout homefight_service_ll;

        public ViewHolder(View itemView) {
            super(itemView);
            homefight_service_img = itemView.findViewById(R.id.homefight_service_img);
            homefight_service_title = itemView.findViewById(R.id.homefight_service_title);
            homefight_service_content = itemView.findViewById(R.id.homefight_service_content);
            tv_fightalone_presentprice = itemView.findViewById(R.id.tv_fightalone_presentprice);
            tv_fightalone_presentprice_two = itemView.findViewById(R.id.tv_fightalone_presentprice_two);
            homefight_service_ll = itemView.findViewById(R.id.homefight_service_ll);
        }
    }
}
