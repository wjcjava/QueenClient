package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */

public class ProblemAdapter extends BaseQuickAdapter<ProblemBean,BaseViewHolder> {


    public ProblemAdapter(int layoutResId, @Nullable List<ProblemBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, ProblemBean item) {
        helper.setText(R.id.tv_replace,item.getName());
    }
}
