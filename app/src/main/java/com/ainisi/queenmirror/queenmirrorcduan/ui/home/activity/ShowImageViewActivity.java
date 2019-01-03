package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HackyViewPager;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.OnClick;

public class ShowImageViewActivity extends BaseNewActivity{
    @Bind(R.id.workroom_detail_image)
    HackyViewPager workroom_detail_image;
    @Bind(R.id.title_title)
    TextView title_title;

    SamplePagerAdapter adapter;
    String image_url;
    String[] imageUrl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("图片展示");
        Intent intent = this.getIntent();
        image_url = intent.getStringExtra("image_url");

        imageUrl = image_url.split(",");

        adapter = new SamplePagerAdapter();
        workroom_detail_image.setAdapter(adapter);
    }


    class SamplePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageUrl.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, final int position) {
            ImageView photoView = new ImageView(container.getContext());
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            Glide.with(ShowImageViewActivity.this).load(imageUrl[position]).placeholder(R.drawable.dismiss).into(photoView);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewPager.LayoutParams.WRAP_CONTENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
