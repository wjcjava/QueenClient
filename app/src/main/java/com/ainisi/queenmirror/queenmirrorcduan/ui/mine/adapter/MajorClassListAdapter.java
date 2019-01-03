package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorClassListBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author jiangchao
 * @Module.Name
 * @Create.Date 2018/5/8 下午5:24
 * @Update.By jiangchao
 * @Update.Content
 * @Update.Date 2018/5/8 下午5:24
 * @see
 */


public class MajorClassListAdapter extends RecyclerView.Adapter<MajorClassListAdapter.ViewHolder> {

    private List<MajorClassListBean.BodyEntity.ClassListEntity> mDatas;

    private LayoutInflater mInflater;

    private OnItemClickListener mListener;

    private OnRefuseItemClickListener mRefuseListener;

    private OnGoodsChangeItemClickListener mGoodsChangeListener;


    public OnLongItemClickListener mOnLongItemClickListener = null;

    Context mContext;

//    private IonSlidingViewClickListener mIDeleteBtnClickListener;


    public void setOnItemListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setOnRefuseItemListener(OnRefuseItemClickListener listener) {
        mRefuseListener = listener;
    }

    public void setOnGoodsChangeItemListener(OnGoodsChangeItemClickListener listener) {
        mGoodsChangeListener = listener;
    }


    public void setOnLongItemClickListener(OnLongItemClickListener listener) {
        this.mOnLongItemClickListener = listener;
    }


    public MajorClassListAdapter(Context context, List<MajorClassListBean.BodyEntity.ClassListEntity> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //读取布局文件
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_list_major_class, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvVideoTitle.setText(mDatas.get(position).getClassName());


//        if (mDatas.get(position).getEcGoodsBasic() != null) {
//
//            holder.tvProductName.setText(mDatas.get(position).getEcGoodsBasic().getGoodsName());
//            //线上
//            holder.tvProductPrice.setText("¥" + new DecimalFormat("0.00").format(Double.parseDouble(mDatas.get(position).getEcGoodsBasic().getSalesPrice())));
//            holder.tvProductIntroduce.setText("商品介绍:" + mDatas.get(position).getEcGoodsBasic().getGoodsBrief());
//
////            if (mDatas.get(position).getEcGoodsBasic() != null) {
//////                String paths = mDatas.get(position).getEcGoodsBasic().getGoodsPic();
//////                if (!StringUtil.isNullString(paths)) {
//////                    String[] pathArr = paths.split(",");
//////                    Glide.with(mContext).load(pathArr[0]).into(holder.ivGoodsPic);
//////                }
////
//               Glide.with(mContext).load(mDatas.get(position).getClassCover().apply(GlideUtil.setPlaceholder()).into(holder.ivVideoThumbnail));
////
        Glide.with(mContext).load(mDatas.get(position).getClassCover()).placeholder(R.drawable.dismiss).into(holder.ivVideoThumbnail);
////            }
//
//            //待上架
//            if ("3".equals(mDatas.get(position).getEcGoodsBasic().getSaleFlag())) {
//                holder.tvProductState.setVisibility(View.VISIBLE);
//                holder.tvProductState.setText("上架");
//                holder.tvShelfState.setText("[未上架]");
//                holder.tvRefuseReason.setVisibility(View.GONE);
//                //待审批
//            } else if ("1".equals(mDatas.get(position).getEcGoodsBasic().getSaleFlag())) {
//                holder.tvShelfState.setText("[审批中]");
//                holder.tvProductState.setVisibility(View.GONE);
//                holder.tvRefuseReason.setVisibility(View.GONE);
//                //上架
//            } else if ("2".equals(mDatas.get(position).getEcGoodsBasic().getSaleFlag())) {
//                holder.tvProductState.setVisibility(View.VISIBLE);
//                holder.tvProductState.setText("下架");
//                holder.tvShelfState.setText("[已上架]");
//                holder.tvRefuseReason.setVisibility(View.GONE);
//                //下架
//            } else if ("4".equals(mDatas.get(position).getEcGoodsBasic().getSaleFlag())) {
//                holder.tvShelfState.setText("[已下架]");
//                holder.tvRefuseReason.setVisibility(View.GONE);
//                holder.tvProductState.setVisibility(View.GONE);
//            } else if ("8".equals(mDatas.get(position).getEcGoodsBasic().getSaleFlag())) {
//                holder.tvShelfState.setText("[被驳回]");
//                holder.tvRefuseReason.setVisibility(View.VISIBLE);
//                holder.tvProductState.setVisibility(View.GONE);
//            }
//
//        }
//
//        holder.tvProductState.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mGoodsChangeListener != null) {
//                    mGoodsChangeListener.onClick(view, holder.getLayoutPosition(), mDatas);
//                }
//            }
//        });
//
//        holder.tvRefuseReason.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mRefuseListener != null) {
//                    mRefuseListener.onClick(view, holder.getLayoutPosition(), mDatas);
//                }
//            }
//        });
//
//
        holder.llVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(v, holder.getLayoutPosition(), mDatas);
                }
            }
        });
//
//        holder.llGoodsItem.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                if (mOnLongItemClickListener != null) {
//                    mOnLongItemClickListener.onLongItemClick(v, holder.getLayoutPosition());
//                }
//                return true;
//            }
//        });


    }


    public void addData(int position, MajorClassListBean.BodyEntity.ClassListEntity entity) {
        mDatas.add(position, entity);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        //需要注意的是我再删除动画的下面加了notifyDataSetChanged();代码，因为我们在删除条目时不一定是按照顺序删除的，
        // 也许是错位删除，这样会因为position的原因造成角标越界异常，所以需要整体刷新一下。
        notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvVideoTitle;
        private ImageView ivVideoThumbnail;
        private CardView cardView;
        private LinearLayout llVideo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvVideoTitle = itemView.findViewById(R.id.tv_video_title);
            ivVideoThumbnail = itemView.findViewById(R.id.iv_video_thumbnail);
            llVideo=itemView.findViewById(R.id.ll_video);
//            cardView = itemView.findViewById(R.id.cardView);
//            //设置图片圆角的半径大小
//            cardView.setRadius(8);
//            //设置阴影部分大小
//            cardView.setCardElevation(8);
//            //设置图片距离阴影大小
//            cardView.setContentPadding(5, 5, 5, 5);
        }
    }


    public interface OnItemClickListener {
        void onClick(View v, int position, List<MajorClassListBean.BodyEntity.ClassListEntity> entity);
    }


    public interface OnRefuseItemClickListener {
        void onClick(View v, int position, List<MajorClassListBean.BodyEntity.ClassListEntity> entity);
    }


    public interface OnGoodsChangeItemClickListener {
        void onClick(View v, int position, List<MajorClassListBean.BodyEntity.ClassListEntity> entity);
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(View view, int position);
    }


    /**
     * 下拉刷新，清除原有数据，添加新数据
     *
     * @param newData
     */
    public void refreshData(List<MajorClassListBean.BodyEntity.ClassListEntity> newData) {
        mDatas.clear();
        mDatas.addAll(newData);
        notifyItemRangeChanged(0, mDatas.size());
    }

    /**
     * 在原来数据的末尾追加新数据
     *
     * @param moreData
     */
    public void loadMoreData(List<MajorClassListBean.BodyEntity.ClassListEntity> moreData) {
        int lastPosition = mDatas.size();
        mDatas.addAll(lastPosition, moreData);
        notifyItemRangeInserted(lastPosition, moreData.size());
    }

}
