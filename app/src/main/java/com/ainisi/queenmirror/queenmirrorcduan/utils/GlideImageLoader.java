package com.ainisi.queenmirror.queenmirrorcduan.utils;

import android.content.Context;
import android.widget.ImageView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by EWorld on 2018/3/7.
 */

public class GlideImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).placeholder(R.drawable.dismiss).into(imageView);
    }
}
