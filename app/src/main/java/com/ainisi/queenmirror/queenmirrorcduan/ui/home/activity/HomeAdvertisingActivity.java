package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.WebDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.GoodsBannerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.ShopBannerAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ShopBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.JSInterface;
import com.ainisi.queenmirror.queenmirrorcduan.utils.JsBridge;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class HomeAdvertisingActivity extends BaseNewActivity implements HttpCallBack, JsBridge {
    @Bind(R.id.web_home_banner)
    WebView bannerWeb;
    @Bind(R.id.re_banner_activity)
    RecyclerView reBanner;
    @Bind(R.id.line_banner)
    LinearLayout lineBanner;
    @Bind(R.id.iv_banner)
    ImageView ivBanner;
    @Bind(R.id.title_title)
    TextView title_banner;
    private String bannerId;
    private String bannerStyle;
    private String bannerLogo;
    private String bannerTitle;
    private String url;
    private String pageLocation, bannerDetail;
    public final static int FILECHOOSER_RESULTCODE = 1;
    public final static int FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 2;

    Handler mhandler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_advertising;
    }

    @Override
    protected void initView() {
        super.initView();

        mhandler = new Handler();


        url = getIntent().getStringExtra("weburl");
        bannerId = getIntent().getStringExtra("bannerId");
        bannerStyle = getIntent().getStringExtra("bannerStyle");
        bannerLogo = getIntent().getStringExtra("bannerLogo");
        bannerTitle = getIntent().getStringExtra("bannerTitle");
        pageLocation = getIntent().getStringExtra("pageLocation");

        if (SP.get(HomeAdvertisingActivity.this, SpContent.isLogin, "").equals("1")) {
            url = url + "?token=" + SP.get(HomeAdvertisingActivity.this, SpContent.UserToken, "") + "&userId=" + SP.get(HomeAdvertisingActivity.this, SpContent.UserId, "");
            initWebView(url);
        }

        if (bannerStyle.equals("5")) {
            bannerWeb.setVisibility(View.GONE);
            lineBanner.setVisibility(View.VISIBLE);
            title_banner.setText(bannerTitle);
            Glide.with(this).load(bannerLogo).placeholder(R.drawable.dismiss).centerCrop().into(ivBanner);
            initHttpBannerGood();
        } else if (bannerStyle.equals("4")) {
            bannerWeb.setVisibility(View.GONE);
            lineBanner.setVisibility(View.VISIBLE);
            title_banner.setText(bannerTitle);
            Glide.with(this).load(bannerLogo).placeholder(R.drawable.dismiss).centerCrop().into(ivBanner);
            initHttpBannerShop();
        } else if (bannerStyle.equals("2")) {
            bannerWeb.setVisibility(View.VISIBLE);
            lineBanner.setVisibility(View.GONE);
            title_banner.setText(bannerTitle);

            initWebView(url);
        } else if (bannerStyle.equals("1")) {
            getDetail();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * 获取富文本信息
     */
    private void getDetail() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("id", bannerId);
        HttpUtils.doPost(ACTION.GETFUWENBENDETAIL, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    //banner商家列表数据
    private void initHttpBannerShop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("bannerId", bannerId);
        parames.put("shopCate", "1");
        HttpUtils.doPost(ACTION.SHOPSBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    //banner商品列表数据
    private void initHttpBannerGood() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("bannerId", bannerId);
        parames.put("shopCate", "1");
        HttpUtils.doPost(ACTION.GOODSBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            /**
             * 获取富文本信息
             */
            case ACTION.GETFUWENBENDETAIL:
                WebDetailBean webDetailBean = GsonUtil.toObj(res, WebDetailBean.class);
                if (webDetailBean.isSuccess() && webDetailBean.getErrorCode().equals("0")) {
                    String bannerDetails = webDetailBean.getBody().getBannerDetails();

                    bannerWeb.setVisibility(View.VISIBLE);
                    lineBanner.setVisibility(View.GONE);
                    title_banner.setText(bannerTitle);
                    new WebService(this, Html.fromHtml(bannerDetails).toString(), bannerWeb);
                    //硬件加速
                    bannerWeb.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                } else {
                    T.show(webDetailBean.getMsg());
                }
                break;
            case ACTION.GOODSBANNER:
                GoodsBannerBean bannerBean = GsonUtil.toObj(res, GoodsBannerBean.class);
                if (bannerBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (bannerBean.isSuccess()) {
                        final List<GoodsBannerBean.BodyBean.BannerListDataBean> shopList = bannerBean.getBody().getBannerListData();
                        GoodsBannerAdapter bannerAdapter = new GoodsBannerAdapter(HomeAdvertisingActivity.this, R.layout.re_workroom_short, shopList);
                        reBanner.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        reBanner.setAdapter(bannerAdapter);
                    } else {
                        T.show(bannerBean.getMsg());
                    }
                }
                break;
            case ACTION.SHOPSBANNER:
                ShopBannerBean shopBannerBean = GsonUtil.toObj(res, ShopBannerBean.class);
                if (shopBannerBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (shopBannerBean.isSuccess()) {
                        List<ShopBannerBean.BodyBean.ShopListDataBean> shopList = shopBannerBean.getBody().getShopListData();
                        ShopBannerAdapter bannerAdapter = new ShopBannerAdapter(HomeAdvertisingActivity.this, R.layout.item_shortrecycler, shopList);
                        reBanner.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        reBanner.setAdapter(bannerAdapter);
                    } else {
                        T.show(shopBannerBean.getMsg());
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

    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }
    }


    private void initWebView(String proposalUrl) {
        bannerWeb.loadUrl(proposalUrl);
        bannerWeb.addJavascriptInterface(new JSInterface(this), "ainisiLauncher");//添加js监听 这样html就能调用客户端
        bannerWeb.setWebChromeClient(webChromeClient);
        bannerWeb.setWebViewClient(webViewClient);

        WebSettings webSettings = bannerWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        /**
         * LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
         * LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
         * LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
         * LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
         */
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存，只从网络获取数据

        //支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        //不显示webview缩放按钮    webSettings.setDisplayZoomControls(false);
    }

    //WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
    private WebChromeClient webChromeClient = new WebChromeClient() {
        //不支持js的alert弹窗，需要自己监听然后通过dialog弹窗
        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(webView.getContext());
            localBuilder.setMessage(message).setPositiveButton("确定", null);
            localBuilder.setCancelable(false);
            localBuilder.create().show();

            //注意:
            //必须要这一句代码:result.confirm()表示:
            //处理结果为确定状态同时唤醒WebCore线程
            //否则不能继续点击按钮
            result.confirm();
            return true;
        }

        //获取网页标题
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        //3.0++版本
        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
            openFileChooserImpl(uploadMsg);
        }

        //3.0--版本
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            openFileChooserImpl(uploadMsg);
        }

        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            openFileChooserImpl(uploadMsg);
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            onenFileChooseImpleForAndroid(filePathCallback);
            return true;
        }

        //加载进度回调
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //progressBar.setProgress(newProgress);
        }
    };
    // WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            //progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
            // progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            L.e("拦截url:" + url);
            if (url.equals("http://www.google.com/")) {
                Toast.makeText(HomeAdvertisingActivity.this, "国内不能访问google,拦截该url", Toast.LENGTH_LONG).show();
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            T.show("网络连接失败，请检查网络连接！");
        }
    };

    public ValueCallback<Uri> mUploadMessage;

    private void openFileChooserImpl(ValueCallback<Uri> uploadMsg) {
        mUploadMessage = uploadMsg;
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
    }

    public ValueCallback<Uri[]> mUploadMessageForAndroid5;

    private void onenFileChooseImpleForAndroid(ValueCallback<Uri[]> filePathCallback) {
        mUploadMessageForAndroid5 = filePathCallback;
        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
        contentSelectionIntent.setType("image/*");

        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");

        startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE_FOR_ANDROID_5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return;
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;

        } else if (requestCode == FILECHOOSER_RESULTCODE_FOR_ANDROID_5) {
            if (null == mUploadMessageForAndroid5)
                return;
            Uri result = (intent == null || resultCode != RESULT_OK) ? null : intent.getData();
            if (result != null) {
                mUploadMessageForAndroid5.onReceiveValue(new Uri[]{result});
            } else {
                mUploadMessageForAndroid5.onReceiveValue(new Uri[]{});
            }
            mUploadMessageForAndroid5 = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (bannerWeb.canGoBack() && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            //获取历史列表
            WebBackForwardList mWebBackForwardList = bannerWeb
                    .copyBackForwardList();
            //判断当前历史列表是否最顶端,其实canGoBack已经判断过
            if (mWebBackForwardList.getCurrentIndex() > 0) {
                bannerWeb.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setTextViewValue(final String value) {
        mhandler.post(new Runnable() {
            @Override
            public void run() {
//                textView.setText(value);

                if ("login".equals(value)) {

                    if (SP.get(HomeAdvertisingActivity.this, SpContent.isLogin, "").equals("0")) {
                        Intent intent = new Intent(HomeAdvertisingActivity.this, LoginActivity.class);
                        intent.putExtra("activite", "yes");
                        startActivity(intent);
                    } else {
                        url = url + "?token=" + SP.get(HomeAdvertisingActivity.this, SpContent.UserToken, "") + "&userId=" + SP.get(HomeAdvertisingActivity.this, SpContent.UserId, "");

                        initWebView(url);
                    }
                }
            }
        });
    }
}
