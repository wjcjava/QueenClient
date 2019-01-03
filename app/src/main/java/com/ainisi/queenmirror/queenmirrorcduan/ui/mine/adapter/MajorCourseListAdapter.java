package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorClassDetailBean;

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


public class MajorCourseListAdapter extends RecyclerView.Adapter<MajorCourseListAdapter.ViewHolder> {

    private List<MajorClassDetailBean.BodyEntity.VideoListEntity> mDatas;

    private LayoutInflater mInflater;

    private OnItemClickListener mListener;

    private OnRefuseItemClickListener mRefuseListener;

    private OnGoodsChangeItemClickListener mGoodsChangeListener;


    public OnLongItemClickListener mOnLongItemClickListener = null;
    int mPosition = -1;
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


    public MajorCourseListAdapter(Context context, List<MajorClassDetailBean.BodyEntity.VideoListEntity> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //读取布局文件
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_major_course, parent, false);


        return new ViewHolder(view);
    }


    public void setPosition(int position) {
        this.mPosition = position;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvClassNumber.setText((position + 1) + "");
        if ("1".equals(mDatas.get(position).getIsFree())) {
            holder.ivVideoCharge.setVisibility(View.GONE);
        } else if ("0".equals(mDatas.get(position).getIsFree())) {
            holder.ivVideoCharge.setVisibility(View.VISIBLE);
        }


        if (mPosition == position) {
            holder.flMajorCourse.setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_home_text));
        } else {
            holder.flMajorCourse.setBackgroundColor(ContextCompat.getColor(mContext, R.color.video_bg));
        }

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
        holder.flMajorCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(v, holder.getLayoutPosition(), mDatas);
//                    setDefSelect(holder.getLayoutPosition());
//                    mPosition = holder.getLayoutPosition(); //选择的position赋值给参数，
//                    notifyItemChanged(mPosition);//刷新当前点击item
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



    public void addData(int position, MajorClassDetailBean.BodyEntity.VideoListEntity entity) {
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

        private TextView tvClassNumber;
        private ImageView ivVideoCharge;
        private CardView cardView;
        private LinearLayout llVideo;
        private FrameLayout flMajorCourse;

        public ViewHolder(View itemView) {
            super(itemView);
            tvClassNumber = itemView.findViewById(R.id.tv_class_number);
            ivVideoCharge = itemView.findViewById(R.id.iv_video_charge);

            flMajorCourse = itemView.findViewById(R.id.fl_major_course);
//            llVideo = itemView.findViewById(R.id.ll_video);
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
        void onClick(View v, int position, List<MajorClassDetailBean.BodyEntity.VideoListEntity> entity);
    }


    public interface OnRefuseItemClickListener {
        void onClick(View v, int position, List<MajorClassDetailBean.BodyEntity.VideoListEntity> entity);
    }


    public interface OnGoodsChangeItemClickListener {
        void onClick(View v, int position, List<MajorClassDetailBean.BodyEntity.VideoListEntity> entity);
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(View view, int position);
    }


    /**
     * 下拉刷新，清除原有数据，添加新数据
     *
     * @param newData
     */
    public void refreshData(List<MajorClassDetailBean.BodyEntity.VideoListEntity> newData) {
        mDatas.clear();
        mDatas.addAll(newData);
        notifyItemRangeChanged(0, mDatas.size());
    }

    /**
     * 在原来数据的末尾追加新数据
     *
     * @param moreData
     */
    public void loadMoreData(List<MajorClassDetailBean.BodyEntity.VideoListEntity> moreData) {
        int lastPosition = mDatas.size();
        mDatas.addAll(lastPosition, moreData);
        notifyItemRangeInserted(lastPosition, moreData.size());
    }

}
