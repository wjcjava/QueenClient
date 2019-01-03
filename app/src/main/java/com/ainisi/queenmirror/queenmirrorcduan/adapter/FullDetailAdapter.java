package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/23.
 */

public class FullDetailAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    Context context;

    public FullDetailAdapter(Context context,int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        ImageView imageView = helper.getView(R.id.iv_full_detail_item);

        Glide.with(context).load(item).placeholder(R.drawable.dismiss).into(imageView);
    }
}
