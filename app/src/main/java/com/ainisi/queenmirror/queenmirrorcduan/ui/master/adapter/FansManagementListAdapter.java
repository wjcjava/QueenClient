package com.ainisi.queenmirror.queenmirrorcduan.ui.master.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.DemoListModel;

import java.util.ArrayList;
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


public class FansManagementListAdapter extends RecyclerView.Adapter<FansManagementListAdapter.ViewHolder> {

    private List<DemoListModel.BodyEntity.MessListEntity> mDatas;


    private LayoutInflater mInflater;

    private OnItemClickListener mListener;

    private OnGoodsChangeItemClickListener mGoodsChangeListener;


    public OnLongItemClickListener mOnLongItemClickListener = null;

    Context mContext;

//    private IonSlidingViewClickListener mIDeleteBtnClickListener;


    public void setOnItemListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setOnGoodsChangeItemListener(OnGoodsChangeItemClickListener listener) {
        mGoodsChangeListener = listener;
    }


    public void setOnLongItemClickListener(OnLongItemClickListener listener) {
        this.mOnLongItemClickListener = listener;
    }


    public FansManagementListAdapter(Context context, List<DemoListModel.BodyEntity.MessListEntity> datas) {
        mContext = context;
        mDatas = datas;
    }

    public FansManagementListAdapter(Context context) {
        mContext = context;
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //读取布局文件
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_fans_content, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvFansName.setText("叫我女王大人");
//        holder.tvMessageDetails.setText(mDatas.get(position).getMessDetails());


    }

    public void addData(int position, DemoListModel.BodyEntity.MessListEntity entity) {
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

        private TextView tvFansName;
        private TextView tvMessageDetails;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFansName = itemView.findViewById(R.id.tv_fans_name);
//            tvSendDate = itemView.findViewById(R.id.tv_send_date);
//            cardView = itemView.findViewById(R.id.cardView);
//            设置图片圆角的半径大小
//            cardView.setRadius(8);
//            设置阴影部分大小
//            cardView.setCardElevation(8);
//            设置图片距离阴影大小
//            cardView.setContentPadding(5, 5, 5, 5);


        }
    }


    public interface OnItemClickListener {
        void onClick(View v, int position, List<DemoListModel.BodyEntity.MessListEntity> entity);
    }


    public interface OnGoodsChangeItemClickListener {
        void onClick(View v, int position, List<DemoListModel.BodyEntity.MessListEntity> entity);
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(View view, int position);
    }


    public List<DemoListModel.BodyEntity.MessListEntity> getList() {
        return mDatas;
    }

    /**
     * 下拉刷新，清除原有数据，添加新数据
     *
     * @param newData
     */
    public void refreshData(List<DemoListModel.BodyEntity.MessListEntity> newData) {
        mDatas.clear();
        mDatas.addAll(newData);
        notifyItemRangeChanged(0, mDatas.size());
    }

    /**
     * 在原来数据的末尾追加新数据
     *
     * @param moreData
     */
    public void loadMoreData(List<DemoListModel.BodyEntity.MessListEntity> moreData) {
        int lastPosition = mDatas.size();
        mDatas.addAll(lastPosition, moreData);
        notifyItemRangeInserted(lastPosition, moreData.size());
    }

}
