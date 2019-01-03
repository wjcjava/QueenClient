package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.RegistAgreementActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class AboutXieyiActivity extends BaseNewActivity {

    @Bind(R.id.title_title)
    TextView title_title;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_xieyi;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("协议及声明");
    }

    @OnClick({R.id.rl_xieyi_falv,R.id.title_back,R.id.rl_xieyi_yinsi,R.id.rl_xieyi_user})
    public void OnClick(View view){
        switch (view.getId()){
            /**
             * 法律声明
             */
            case R.id.rl_xieyi_falv:
                Intent intent = new Intent(this,RegistAgreementActivity.class);
                intent.putExtra("queryTitle","法律声明");
                intent.putExtra("code","1");
                startActivity(intent);
                break;
            /**
             * 隐私政策
             */
            case R.id.rl_xieyi_yinsi:
                Intent intents = new Intent(this,RegistAgreementActivity.class);
                intents.putExtra("queryTitle","隐私政策");
                intents.putExtra("code","3");
                startActivity(intents);
                break;
            /**
             * 用户协议
             */
            case R.id.rl_xieyi_user:
                Intent intentd = new Intent(this,RegistAgreementActivity.class);
                intentd.putExtra("queryTitle","用户协议");
                intentd.putExtra("code","2");
                startActivity(intentd);
                break;
            case R.id.title_back:
                finish();
                break;
        }
    }
}
