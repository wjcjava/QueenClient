package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.WebDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class PageBannerActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.web_home_banner)
    WebView webBanner;
    @Bind(R.id.title_title)
    TextView title_title;

    private String bannerDetails;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_page_banner;
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();

        title_title.setText("活动详情");

        bannerDetails=getIntent().getStringExtra("bannerId");

        getDetail();

    }

    /**
     * 获取富文本信息
     */
    private void getDetail() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("id",bannerDetails);
        HttpUtils.doPost(ACTION.GETFUWENBENDETAIL,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETFUWENBENDETAIL:
                WebDetailBean webDetailBean = GsonUtil.toObj(res,WebDetailBean.class);
                if(webDetailBean.isSuccess()&&webDetailBean.getErrorCode().equals("0")){
                    String bannerDetails = webDetailBean.getBody().getBannerDetails();

                    new WebService(this, Html.fromHtml(bannerDetails).toString(), webBanner);
                    //硬件加速
                    webBanner.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                }else{
                    T.show(webDetailBean.getMsg());
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
