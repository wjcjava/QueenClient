package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/9/21 15:42
 * 邮箱：707078566@qq.com
 * 用途：H5导航
 */
public class NavigationActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView mTitleTitle;
    @Bind(R.id.navigation_webview)
    WebView mNavigationWebview;
    private String longitude;
    private String latitude;
    private String address;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_navagation;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleTitle.setText("导航");
        Intent intent = getIntent();
        longitude = intent.getStringExtra("longitude");
        latitude = intent.getStringExtra("latitude");
        address = intent.getStringExtra("address");
        mNavigationWebview.setWebViewClient(new WebViewClient());
        WebSettings settings = mNavigationWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        //启用地理定位
        settings.setGeolocationEnabled(true);

        //配置权限
        mNavigationWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        });
        String urls = "http://uri.amap.com/navigation?from=" + SP.get(this, SpContent.UserLon,
                "0") + "," + SP.get(this, SpContent.UserLat, "0")
                + ",我的位置&to=" + longitude + "," + latitude + "," + address + "&mode=car&policy=1&src=mypage&coordinate=gaode&callnative=0";
        mNavigationWebview.loadUrl(urls);
    }

    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mNavigationWebview != null) {
            mNavigationWebview.removeAllViews();
            mNavigationWebview.destroy();
        }
    }
}
