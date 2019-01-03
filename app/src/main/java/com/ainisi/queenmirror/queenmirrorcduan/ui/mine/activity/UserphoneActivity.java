package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 更换手机号
 */
public class UserphoneActivity extends BaseNewActivity{
    @Bind(R.id.title_title)
    TextView phonetitle;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,UserphoneActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_userphone;
    }



    @Override
    public void initView() {
        phonetitle.setText("更换手机号");

    }
    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;

        }


    }
}
