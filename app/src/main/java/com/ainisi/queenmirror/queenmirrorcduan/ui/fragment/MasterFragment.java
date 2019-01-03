package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RecyclerVarietyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.BigshotBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 大咖
 */

public class MasterFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.re_big_shot)
    RecyclerView reBigshot;
    @Bind(R.id.iv_master_news)
    ImageView iv_master_news;
    private List<BigshotBean> mData;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_master;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onResume() {
        super.onResume();
        //  getNewNewsData();
    }
    /**
     * 获取新消息提示
     */
    private void getNewNewsData() {
        java.util.HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("messageType", "");
        HttpUtils.doPost(ACTION.GETNEWNEWS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initView() {
        initDate();
    }

    @Override
    protected void doFitsrData() {

    }

    private void initDate() {
        mData = new ArrayList<>();
//        随机数 用来标记item界面的类型
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            BigshotBean more = new BigshotBean();
            more.type = random.nextInt(3);
            mData.add(more);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            reBigshot.setLayoutManager(linearLayoutManager);
            RecyclerVarietyAdapter adapter = new RecyclerVarietyAdapter(getActivity(), mData);
            reBigshot.setAdapter(adapter);

        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETNEWNEWS:
                NewsBean newsBean = GsonUtil.toObj(res, NewsBean.class);

               /* if (newsBean.isSuccess()) {
                    if (newsBean.getBody().getIsRead().equals("0")) {

                    } else {
                        QBadgeView badgeView = new QBadgeView(getActivity());
                        badgeView.bindTarget(iv_master_news);
                        badgeView.setBadgeTextSize(10, false);
                        badgeView.setBadgeText("");
                        badgeView.setBadgeTextColor(this.getResources().getColor(R.color.white));
                        badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
                        badgeView.setBadgeBackgroundColor(this.getResources().getColor(R.color.colorPri));
                        badgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                            @Override
                            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                            }
                        });
                    }
                } else {
                    T.show(newsBean.getMsg());
                }*/
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
