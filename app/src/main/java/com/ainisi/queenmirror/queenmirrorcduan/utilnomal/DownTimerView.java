package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by john on 2018/7/3.
 *
 * jl
 */

public class DownTimerView extends BaseCountDownTimerView{

    public DownTimerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DownTimerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DownTimerView(Context context) {
        this(context,null);
    }

    @Override
    protected String getStrokeColor() {
        return "656565";
    }

    @Override
    protected String getTextColor() {
        return "FFFFFF";
    }

    @Override
    protected int getCornerRadius() {
        return 5;
    }

    @Override
    protected int getTextSize() {
        return 60;
    }

    @Override
    protected String getBackgroundColor() {
        return "656565";
    }

}
