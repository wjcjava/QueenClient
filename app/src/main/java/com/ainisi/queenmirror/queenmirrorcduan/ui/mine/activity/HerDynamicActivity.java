package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 动态（是否让看）
 */
public class HerDynamicActivity extends BaseNewActivity {
    @Bind(R.id.newtitle_title)
    TextView hertitle;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_her_dynamic;
    }


    @Override
    public void initView() {
        title = getIntent().getStringExtra("dynamic");
        hertitle.setText(title);
    }

    @OnClick({R.id.iv_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                break;


        }


    }
}
