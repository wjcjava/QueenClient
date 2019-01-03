package com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/6/2.
 */

public class MerchantsAdapter extends BaseQuickAdapter<MerchantsBean.BodyBean.ActivityKeysListDataBean, BaseViewHolder> {


    public MerchantsAdapter(int layoutResId, @Nullable List<MerchantsBean.BodyBean.ActivityKeysListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantsBean.BodyBean.ActivityKeysListDataBean item) {
        helper.setText(R.id.tv_merchants_name,item.getEcActivity().getActStyle());
    }
}
