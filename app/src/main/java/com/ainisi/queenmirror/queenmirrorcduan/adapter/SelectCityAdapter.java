package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SelectCityBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SelectCityAdapter  extends BaseQuickAdapter<SelectCityBean.BodyBean.CityListDataBean,BaseViewHolder> {


    public SelectCityAdapter(int layoutResId, @Nullable List<SelectCityBean.BodyBean.CityListDataBean> CityListData) {
        super(layoutResId, CityListData);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectCityBean.BodyBean.CityListDataBean item) {

        helper.setText(R.id.tv_select_city_name,item.getArea().getName());
    }
}
