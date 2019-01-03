package com.ainisi.queenmirror.queenmirrorcduan.base;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 作者： jl
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    protected Context context;

    private List<T> datas;

    private LayoutInflater inflater;

    private SparseIntArray resArray = new SparseIntArray();

    public BaseRecyclerViewAdapter(Context context, List<T> datas, int... layoutResIds) {
        this.context = context;
        if (datas == null) {
            this.datas = new ArrayList<>();
        } else {
            this.datas = datas;
        }
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < layoutResIds.length; i++) {
            resArray.append(i, layoutResIds[i]);
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutResId = resArray.get(viewType);
        View view = inflater.inflate(layoutResId, parent, false);
        BaseViewHolder baseViewHolder = new BaseViewHolder(context, view);
        return baseViewHolder;
    }

    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        final T data = this.datas.get(position);
        convert(holder, data, position);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(data, position);
                }
            });
        }
    }

    protected abstract void convert(BaseViewHolder holder, T data, int position);

    public abstract int getItemViewType(int position);

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void setDatas(List<T> datas) {
        if (datas == null){
            return;
        }
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public List<T> getDatas() {
        return datas;
    }

    public void addDatas(List<T> addDatas) {
        this.datas.addAll(addDatas);
        notifyDataSetChanged();
    }

    public void addData(T data) {
        this.datas.add(data);
        notifyDataSetChanged();
    }

    public void removeData(T data) {
        int position = this.datas.indexOf(data);
        this.datas.remove(data);
        notifyItemRemoved(position);
    }

    private OnItemClickListener<T> onItemClickListener;

    public interface OnItemClickListener<T> {
        void onItemClick(T data, int position);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        SparseArray<View> views = new SparseArray<>();
        Context context;

        public BaseViewHolder(Context context, View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.context = context;
        }

        public BaseViewHolder setText(int resId, String text) {
            TextView textView;
            if (views.get(resId) == null) {
                textView = ButterKnife.findById(itemView, resId);
                views.append(resId, textView);
            } else {
                textView = (TextView) views.get(resId);
            }
            textView.setText(text);
            return this;
        }

        public BaseViewHolder loadImage(int resId, String imgUrl) {
            ImageView imageView;
            if (views.get(resId) == null) {
                imageView = ButterKnife.findById(itemView, resId);
                views.append(resId, imageView);
            } else {
                imageView = (ImageView) views.get(resId);
            }
            Glide.with(context).load(imgUrl).placeholder(R.drawable.dismiss).into(imageView);
            return this;
        }

        public BaseViewHolder loadImage(int resId, int imgResId) {
            ImageView imageView;
            if (views.get(resId) == null) {
                imageView = ButterKnife.findById(itemView, resId);
                views.append(resId, imageView);
            } else {
                imageView = (ImageView) views.get(resId);
            }
            Glide.with(context).load(imgResId).placeholder(R.drawable.dismiss).into(imageView);
            return this;
        }

        public BaseViewHolder setCheckedTextViewChecked(int resId, boolean checked) {
            CheckedTextView checkedTextView;
            if (views.get(resId) == null) {
                checkedTextView = ButterKnife.findById(itemView, resId);
                views.append(resId, checkedTextView);
            } else {
                checkedTextView = (CheckedTextView) views.get(resId);
            }
            checkedTextView.setChecked(checked);
            return this;
        }

        public BaseViewHolder setOnCheckedChangeListener(int resId, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            CompoundButton compoundButton;
            if (views.get(resId) == null) {
                compoundButton = ButterKnife.findById(itemView, resId);
                views.append(resId, compoundButton);
            } else {
                compoundButton = (CompoundButton) views.get(resId);
            }
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
            return this;
        }
        /**
         * 适用于集成CompoundButton的控件
         *
         * @param resId
         * @param checked
         */
        public BaseViewHolder setChecked(int resId, boolean checked) {
            CompoundButton compoundButton;
            if (views.get(resId) == null) {
                compoundButton = ButterKnife.findById(itemView, resId);
                views.append(resId, compoundButton);
            } else {
                compoundButton = (CompoundButton) views.get(resId);
            }
            compoundButton.setChecked(checked);
            return this;
        }
        public BaseViewHolder setRatting(int resId, float star) {
            RatingBar ratingBar;
            if (views.get(resId) == null) {
                ratingBar = ButterKnife.findById(itemView, resId);
                views.append(resId, ratingBar);
            } else {
                ratingBar = (RatingBar) views.get(resId);
            }
            ratingBar.setRating(star);
            return this;
        }
        public BaseViewHolder setVisible(int resId, int visible) {
            View view;
            if (views.get(resId) == null) {
                view = ButterKnife.findById(itemView, resId);
                views.append(resId, view);
            } else {
                view = views.get(resId);
            }
            view.setVisibility(visible);
            return this;
        }

        public BaseViewHolder setOnClickListener(int resId, View.OnClickListener onClickListener) {
            View view;
            if (views.get(resId) == null) {
                view = ButterKnife.findById(itemView, resId);
                views.append(resId, view);
            } else {
                view = views.get(resId);
            }
            view.setOnClickListener(onClickListener);
            return this;
        }
        public BaseViewHolder setBgColor(int resId, String color) {
            View view;
            if (views.get(resId) == null) {
                view = ButterKnife.findById(itemView, resId);
                views.append(resId, view);
            } else {
                view = views.get(resId);
            }
            view.setBackgroundColor(Color.parseColor(color));
            return this;
        }
        public BaseViewHolder setBgColor(int resId, int resColor) {
            View view;
            if (views.get(resId) == null) {
                view = ButterKnife.findById(itemView, resId);
                views.append(resId, view);
            } else {
                view = views.get(resId);
            }
            view.setBackgroundColor(context.getResources().getColor(resColor));
            return this;
        }
        public BaseViewHolder setBgDrawable(int resId,int resDrawable){
            View view;
            if(views.get(resId) == null){
                view = ButterKnife.findById(itemView,resId);
                views.append(resId,view);
            }else{
                view = views.get(resId);
            }
            view.setBackgroundDrawable(context.getResources().getDrawable(resDrawable));
            return this;
        }
        public BaseViewHolder setTextColor(int resId, int resColor) {
            TextView view;
            if (views.get(resId) == null) {
                view = ButterKnife.findById(itemView, resId);
                views.append(resId, view);
            } else {
                view = (TextView) views.get(resId);
            }
            view.setTextColor(context.getResources().getColor(resColor));
            return this;
        }
        public <T extends View> T  getView(int resId){
            T t;
            if (views.get(resId) == null) {
                t = ButterKnife.findById(itemView, resId);
                views.append(resId, t);
            } else {
                t = (T) views.get(resId);
            }
            return t;
        }
    }
}