package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 发表评论
 */
public class DynamicActivity extends BaseNewActivity {
    @Bind(R.id.iv_title)
    CircleImageView imgTitle;
    @Bind(R.id.iv_righttitle)
    ImageView imgRight;
    @Bind(R.id.tv_righttitle)
    TextView txtRight;
    @Bind(R.id.title_title)
    TextView dynamicTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dynamic;
    }

    @Override
    protected void initView() {
        super.initView();
    }


    @Override
    protected void initData() {
        super.initData();
        imgTitle.setVisibility(View.GONE);
        imgRight.setVisibility(View.GONE);
        txtRight.setVisibility(View.VISIBLE);
        dynamicTitle.setText("发表评论");

    }
}
