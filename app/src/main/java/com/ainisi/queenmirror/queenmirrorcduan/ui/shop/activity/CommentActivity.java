package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class CommentActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView commentTitle;
    @Bind(R.id.title_right)
    TextView rightTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initData() {
        super.initData();
        commentTitle.setText("发表评价");
        rightTitle.setText("发布");
    }
    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }


    }
}
