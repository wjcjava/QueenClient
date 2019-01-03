package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.TouchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.TouchbalanceBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的钱包—余额—余额明细
 */
public class MineDetailedActivity extends BaseNewActivity implements  HttpCallBack {
    @Bind(R.id.title_title)
    TextView detailedTitle;
    @Bind(R.id.rc_all_detail)
    RecyclerView detailrecycle;
    private List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> list = new ArrayList<>();
    /*@Bind(R.id.mine_detail_refreshLayout)
    SmartRefreshLayout mine_detail_refreshLayout;*/
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.tv_queen_buy_getbean)
    TextView tv_queen_buy_getbean;
    @Bind(R.id.tv_queen_buy_buyno)
    TextView tv_queen_buy_buyno;
    @Bind(R.id.tv_queen_buy_time)
    TextView tv_queen_buy_time;

    LoadingDialog loadingDialog;
    int pageNumber =1,pageIndex=0,pageSum=0;
    TouchAdapter sortAdapter2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_detailed;
    }


    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        detailedTitle.setText(getIntent().getStringExtra("name"));
        tv_queen_buy_buyno.setText("明细");
        tv_queen_buy_time.setText("时间");

        tv_queen_buy_getbean.setVisibility(View.GONE);
        inithttp();


       /* mine_detail_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                inithttp();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_detail_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum <= pageIndex){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    inithttp();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });*/
    }

    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("custId", SP.get(this, SpContent.UserId,"")+"");
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.TOUCHBALANCE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
    }
    @OnClick({R.id.title_back})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {

            case ACTION.TOUCHBALANCE:
                loadingDialog.cancel();
                TouchbalanceBean touchbalanceBean = GsonUtil.toObj(res, TouchbalanceBean.class);
                if(touchbalanceBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (touchbalanceBean.isSuccess()) {
                        pageSum = touchbalanceBean.getBody().getAccountChargeRecords().size();
                        if (pageSum == 0) {
                            shop_list_null.setVisibility(View.VISIBLE);
                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            //loadMoreData(touchbalanceBean.getBody().getAccountChargeRecords());
                            sortAdapter2 = new TouchAdapter(MineDetailedActivity.this, R.layout.queen_buy_record_item, touchbalanceBean.getBody().getAccountChargeRecords());
                            detailrecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                            detailrecycle.setAdapter(sortAdapter2);

                        }

                    } else {
                        T.show(touchbalanceBean.getMsg());
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

    public void loadMoreData(List<TouchbalanceBean.BodyBean.AccountChargeRecordsBean> apiOrderListMore){

        if(list == null){
            list = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter2.Clear();
        }
        list.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter2.setmDate(list);
        }else{
            sortAdapter2.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}