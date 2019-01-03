package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * 作者： jl
 * 日期： 2017/2/23.
 */

public class T {
    private static Toast mToast;
    public static Context context;

    public static void show(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    public static void show(Integer text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, String.valueOf(text), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(String.valueOf(text));
        }
        mToast.show();
    }

    public static void show(Object text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text.toString(), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text.toString());
        }
        mToast.show();
    }
}
