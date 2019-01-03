package com.ainisi.queenmirror.queenmirrorcduan.ui.home.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SuggestionBean;
import com.bumptech.glide.Glide;
import com.gongwen.marqueen.MarqueeFactory;

/**
 * 作者：linxi on 2018/9/13 15:30
 * 邮箱：707078566@qq.com
 * 用途：
 */
//MarqueeFactory<T extends View, E>
//泛型T:指定ItemView的类型
//泛型E:指定ItemView填充的数据类型
public class ComplexViewMF extends MarqueeFactory<LinearLayout, SuggestionBean> {
    private LayoutInflater inflater;
    private Context mContext;

    public ComplexViewMF(Context mContext) {
        super(mContext);
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public LinearLayout generateMarqueeItemView(SuggestionBean data) {
        LinearLayout mView = (LinearLayout) inflater.inflate(R.layout.complex_view, null);
        ((TextView) mView.findViewById(R.id.complex_tv1)).setText(data.getTitle());
        if (!TextUtils.isEmpty(data.getTap1())) {
            ((TextView) mView.findViewById(R.id.complex_tap1)).setVisibility(View.VISIBLE);
            ((TextView) mView.findViewById(R.id.complex_tap1)).setText(data.getTap1());
        } else {
            ((TextView) mView.findViewById(R.id.complex_tap1)).setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(data.getTap2())) {
            ((TextView) mView.findViewById(R.id.complex_tap2)).setVisibility(View.VISIBLE);
            ((TextView) mView.findViewById(R.id.complex_tap2)).setText(data.getTap2());
        } else {
            ((TextView) mView.findViewById(R.id.complex_tap2)).setVisibility(View.GONE);
        }
        ((TextView) mView.findViewById(R.id.complex_tv2)).setText(data.getContent());
        Glide.with(mContext).load(data.getImg()).into((ImageView) mView.findViewById(R.id.complex_img));
        return mView;
    }
}
