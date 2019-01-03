package com.ainisi.queenmirror.common.commonutils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.R;
import com.ainisi.queenmirror.common.baseapp.BaseApplication;


/**
 * Created by Administrator on 2017/3/8.
 */

public class ToastUtils {

    public static Toast mToast;
    private static ToastUtils mInstance;
    private static Context mContext;

    private ToastUtils(Context context) {
        this.mContext = context;
    }

    public static ToastUtils getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ToastUtils(context);
        }
        return mInstance;
    }

    /**
     * 短时间显示吐司
     *
     * @param msg
     */
    public static void showShotToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示吐司
     *
     * @param msg
     */
    public static void showLongToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param strResId
     */
    public static void showShort(int strResId) {
        showShotToast(mContext.getResources().getString(strResId));
    }

    public static void showShort(String text) {
        showShotToast(text);
    }

    /**
     * 长时间显示Toast
     *
     * @param strResId
     */
    public static void showLong(int strResId) {
        showLongToast(mContext.getResources().getString(strResId));
    }

    public static void showLong(String text) {
        showLongToast(text);
    }

    public static void showShortTime(String msg, int duration) {
        Toast.makeText(mContext, msg, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param strResId
     * @param duration
     */
    public static void showShortTime(int strResId, int duration) {
        Toast.makeText(mContext, mContext.getResources().getString(strResId), duration).show();
    }

    public static void showToastWithImg(String tvStr, int imageResource) {
        if (mToast == null) {
            mToast = new Toast(BaseApplication.getAppContext());
        }
        View view = LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.toast_custom, null);
        TextView tv = (TextView) view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
        ImageView iv = (ImageView) view.findViewById(R.id.toast_custom_iv);
        if (imageResource > 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imageResource);
        } else {
            iv.setVisibility(View.VISIBLE);
        }
        mToast.setView(view);
        mToast.show();
    }


}
