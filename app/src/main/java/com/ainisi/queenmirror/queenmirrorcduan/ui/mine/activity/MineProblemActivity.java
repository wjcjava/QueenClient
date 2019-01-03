package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.app.Instrumentation;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 帮助与反馈
 */
public class MineProblemActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView proTitle;
    @Bind(R.id.web_problem)
    WebView webProblem;

    LoadingDialog loadingDialog;

    String Url = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_problem;
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        proTitle.setText("帮助与反馈");

        getUrlData();
    }

    /**
     * 获取帮助与反馈的地址
     */
    private void getUrlData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("token", SP.get(this,SpContent.UserToken,"")+"");
        params.put("requestType","client");
        HttpUtils.doPost(ACTION.GETHELPURL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && webProblem.canGoBack()) {
            webProblem.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                actionKey(KeyEvent.KEYCODE_BACK);
                break;
            default:
                break;
        }
    }

    public void actionKey(final int keyCode) {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETHELPURL:
                loadingDialog.cancel();
                MineProblemBean mineProblemBean = GsonUtil.toObj(res,MineProblemBean.class);
                if(mineProblemBean.isSuccess()){
                    Url = mineProblemBean.getBody().getProposalUrl();

                    webProblem.setWebViewClient(new WebViewClient() {
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            view.loadUrl(url);
                            return true;
                        }
                    });
                    webProblem.loadUrl(Url);
                    //支持屏幕缩放
                    WebSettings webSettings = webProblem.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webSettings.setSupportZoom(true);
                    webSettings.setBuiltInZoomControls(true);
                }else{
                    T.show(mineProblemBean.getMsg());
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
