package com.ainisi.queenmirror.queenmirrorcduan.utils;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by jiangchao on 2018/8/15 下午4:33.
 */


public class JSInterface {

    private static final String TAG = "JSInterface";

    private JsBridge jsBridge;

    public JSInterface(JsBridge jsBridge) {
        this.jsBridge = jsBridge;
    }


    @JavascriptInterface
    public void setValue(String value) {
        Log.i(TAG, "value---" + value);
        jsBridge.setTextViewValue(value);
    }
}
