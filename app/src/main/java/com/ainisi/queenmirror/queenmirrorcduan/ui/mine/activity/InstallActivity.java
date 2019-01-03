package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的设置
 */
public class InstallActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView settitle;
    @Bind(R.id.iv_unselected)
    ImageView unselscetd;
    @Bind(R.id.layout_we)
    RelativeLayout layout_we;


    private boolean isClick;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, InstallActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_install;
    }

    @Override
    public void initView() {
        settitle.setText("设置");
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.title_back, R.id.iv_unselected, R.id.layout_privacy, R.id.tv_install_loginout,R.id.layout_we
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.layout_we:
                Intent intent = new Intent(this,AboutUsActivity.class);
                startActivity(intent);
                break;
            case R.id.title_back:
                finish();
                break;
            //隐私
            case R.id.layout_privacy:
                ReplaceActivity.startActivity(InstallActivity.this);
                break;
            case R.id.iv_unselected:
                if (isClick) {
                    unselscetd.setImageResource(R.drawable.icon_install_unselected);
                    isClick = false;
                } else {
                    unselscetd.setImageResource(R.drawable.icon_install_selected);
                    isClick = true;
                }
                break;
            case R.id.tv_install_loginout:
                initParams();
                break;
            default:
                break;

        }
    }

    /**
     * 退出登录
     */
    private void initParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", SP.get(this, SpContent.UserCall, "0") + "");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        params.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.LOGINOUT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.LOGINOUT:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.isSuccess()) {
                        SP.put(this, SpContent.isLogin, "0");
                        SP.put(this, SpContent.UserId, "0");
                        SP.put(this, SpContent.UserName, "");
                        finish();
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
