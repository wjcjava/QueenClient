package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.google.zxing.WriterException;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * 关于我们
 *
 * @author jiangchao
 *         created at 2018/5/11 下午1:38
 */
public class AboutUsActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_banben)
    TextView tv_banben;

    String versionName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("关于我们");
        try {
            versionName = AboutUsActivity.this.getPackageManager().getPackageInfo(
                    AboutUsActivity.this.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        tv_banben.setText("女王魔镜 V"+versionName);
    }

    @OnClick({R.id.title_back,R.id.tv_about_xieyi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_about_xieyi:
                startActivity(new Intent(this, AboutXieyiActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
        }
    }

    @Override
    public void showLoadingDialog() {
    }

    @Override
    public void showErrorMessage(String s) {
    }
}
