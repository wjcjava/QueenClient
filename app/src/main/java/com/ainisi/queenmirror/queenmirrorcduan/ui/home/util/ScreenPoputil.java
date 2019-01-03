package com.ainisi.queenmirror.queenmirrorcduan.ui.home.util;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.PopupWindow;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;

import java.util.List;

/**
 * Created by john on 2018/6/4.
 */

public class ScreenPoputil extends PopupWindow{

    private View popview;
    private PopupWindow popWindow;
    private Context context;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private MerchantsAdapter merchantsAdapter;
    private String text;



    public ScreenPoputil(Context context) {
        this.context = context;
    }

    public void showscreenPop(View view, List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList, List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList, String text) {
        this.merchantsList = merchantsList;
        this.preferentialList = preferentialList;
        this.text = text;

        popview = View.inflate(context, R.layout.pop_screening, null);
        popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT);
        popWindow.setContentView(popview);
        popWindow.setOutsideTouchable(true);
        popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
        popWindow.showAsDropDown(view, 0, 0);


    }



}