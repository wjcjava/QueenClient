package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineGiftActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MondelActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.banner_model)
    Banner modelBanner;
    @Bind(R.id.re_mondel)
    RecyclerView reMondel;
    @Bind(R.id.re_mondel_exchange)
    RecyclerView reExchange;
    @Bind(R.id.tv_mondel_number)
    TextView tv_mondel_number;
    @Bind(R.id.iv_model_my)
    ImageView iv_model_my;
    private List<SortBean> mondelList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_mondel;
    }

    @Override
    public void initView() {
        initDate();

        getMineMoDouData();
    }

    /**
     * 获取我的魔豆数
     */
    private void getMineMoDouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(MondelActivity.this, SpContent.UserId, "") + "");
        params.put("token",SP.get(MondelActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initDate() {
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add(R.drawable.icon_mondel_banner);
        }
        modelBanner.setImageLoader(new GlideImageLoader());
        modelBanner.setImages(images);
        modelBanner.setIndicatorGravity(BannerConfig.LEFT);
        modelBanner.start();

        for (int i = 0; i < 4; i++) {
            SortBean sortBean = new SortBean();
            mondelList.add(sortBean);
        }

        MyAdapter myAdapter = new MyAdapter(R.layout.re_mondel_service, mondelList);
        reMondel.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reMondel.setAdapter(myAdapter);
        MyAdapter myAdaptertwo = new MyAdapter(R.layout.re_mondel_exchange, mondelList);
        reExchange.setLayoutManager(new GridLayoutManager(this, 2));
        reExchange.setAdapter(myAdaptertwo);
    }

    @OnClick({R.id.title_back,R.id.iv_model_my})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.iv_model_my:
                Intent intent = new Intent(this,MineGiftActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETMINEMODOU:
                int moDou = 0;
                MoDouBean moDouBean = GsonUtil.toObj(res,MoDouBean.class);
                if(moDouBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (moDouBean.isSuccess()) {
                        moDou = moDouBean.getBody().getMap().getPointsNow();
                        tv_mondel_number.setText(moDou + "");
                    } else {
                        T.show(moDouBean.getMsg());
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
