package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 添加银行卡
 */
public class MineAddcartActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView addcartTitle;


    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_addcart;
    }


    @Override
    public void initView() {

        initText();

    }

    private void initText() {
        addcartTitle.setText(getIntent().getStringExtra("name"));
        addcartTitle.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));
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
