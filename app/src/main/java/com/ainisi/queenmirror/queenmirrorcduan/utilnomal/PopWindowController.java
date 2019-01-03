package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.example.john.library.PopWindowHome;

/**
 * Created by HMY on 2016/9/13.
 *
 * jl
 */
public class PopWindowController {

    public static PopWindowHome showPopDownList(Activity activity, BaseAdapter adapter, View controlView, View rotateView,
                                                int[] margins, AdapterView.OnItemClickListener listener) {
        return showPopDownList(activity, adapter, controlView, rotateView, true, margins, listener);
    }

    public static PopWindowHome showPopDownList(Activity activity, BaseAdapter adapter, View controlView, View rotateView,
                                            boolean rotateViewAnim, int[] margins, AdapterView.OnItemClickListener listener) {
        Animation openAnim = AnimationUtils.loadAnimation(activity, R.anim.btn_rotate_anim_1);
        Animation closeAnim = AnimationUtils.loadAnimation(activity, R.anim.btn_rotate_anim_2);
        return showPopDownList(activity, adapter, controlView, rotateView, openAnim, closeAnim, rotateViewAnim, margins, listener);
    }

    public static PopWindowHome showPopDownList(Activity activity, BaseAdapter adapter, View controlView, View rotateView, int openAnimId,
                                            int closeAnimId, boolean rotateViewAnim, int[] margins,
                                            AdapterView.OnItemClickListener listener) {
        Animation openAnim = AnimationUtils.loadAnimation(activity, openAnimId);
        Animation closeAnim = AnimationUtils.loadAnimation(activity, closeAnimId);
        return showPopDownList(activity, adapter, controlView, rotateView, openAnim, closeAnim, rotateViewAnim, margins, listener);
    }


    public static PopWindowHome showPopDownList(Activity activity, final BaseAdapter adapter, View controlView, View rotateView,
                                            Animation openAnim, Animation closeAnim, boolean rotateViewAnim, int[] margins,
                                            AdapterView.OnItemClickListener listener) {
        final ListView listView = new ListView(activity);
        listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listView.setDivider(null);
        listView.setOnItemClickListener(listener);
        listView.setAdapter(adapter);

        int leftMargin = 0, topMargin = 0, rightMargin = 0, bottomMargin = 0;
        if (margins != null) {
            for (int i = 0; i < margins.length; i++) {
                if (i == 0) {
                    leftMargin = margins[i];
                } else if (i == 1) {
                    topMargin = margins[i];
                } else if (i == 2) {
                    rightMargin = margins[i];
                } else if (i == 3) {
                    bottomMargin = margins[i];
                }
            }
        }

        PopWindowHome popWindow = new PopWindowHome.Builder(activity)
                .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                .setView(listView)
                .setControlViewAnim(rotateView, openAnim, closeAnim, rotateViewAnim)
                .setPopWindowMargins(leftMargin, topMargin, rightMargin, bottomMargin)
                .create();
        popWindow.show(controlView);
        return popWindow;
    }

}
