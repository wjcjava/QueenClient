package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineBeanByTimeItemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineBeanByTimeBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBeanOne;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的魔豆
 */
public class MineBeanActivity extends BaseActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView beantitle;
    @Bind(R.id.rc_mine_bean)
    RecyclerView rc_mine_bean;
    @Bind(R.id.tv_mine_bean_zhichu)
    TextView tv_mine_bean_zhichu;
    @Bind(R.id.tv_mine_bean_shouru)
    TextView tv_mine_bean_shouru;
    @Bind(R.id.modou_refreshLayout)
    SmartRefreshLayout modou_refreshLayout;

    private List<SortBean> list = new ArrayList<>();

    List<MoDouListBean> moDouListBeans = new ArrayList<>();

    List<MineBeanByTimeBean.BodyBean.PointsRecordBean> pointsRecord = new ArrayList<>();

    int pageSum = 0, pageNumber = 1,pageIndex = 0;

    MineBeanByTimeItemAdapter mineBeanByTimeItemAdapter;
    LoadingDialog loadingDialog;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineBeanActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_dean;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        beantitle.setText(R.string.magic_bean);
        beantitle.setTextColor(Color.WHITE);
        loadingDialog = new LoadingDialog(this);

        getMineMoDouData();
        getMonthMoDouData();

        mineBeanByTimeItemAdapter = new MineBeanByTimeItemAdapter(MineBeanActivity.this, R.layout.item_modou_bean_list, pointsRecord);
        rc_mine_bean.setLayoutManager(new LinearLayoutManager(MineBeanActivity.this, LinearLayout.VERTICAL, false));
        rc_mine_bean.setAdapter(mineBeanByTimeItemAdapter);

        modou_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                getMineMoDouData();
                refreshlayout.finishRefresh(1000);
            }
        });
        modou_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    getMineMoDouData();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    /**
     * 按月获取魔豆
     */
    private void getMonthMoDouData() {
        String months = "";
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;

        if(month<10){
            months = "0" + month;
        }else{
            months = ""+ month;
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("searchMonth", year + months);
        params.put("custId",SP.get(MineBeanActivity.this,SpContent.UserId,"0")+"");
        params.put("token",SP.get(MineBeanActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETMONTHMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取我的魔豆列表
     */
    private void getMineMoDouData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("searchDayFrom", "");
        params.put("searchDayTo", "");
        params.put("custId",SP.get(MineBeanActivity.this,SpContent.UserId,"0")+"");
        params.put("pageSize",SpContent.pageSize);
        params.put("pageNumber",pageNumber+"");
        params.put("token",SP.get(MineBeanActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETMINEMODOUBEAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
//            case R.id.iv_date:
//                startActivity(new Intent(this,BeanstalkActivity.class));
//                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            //按月获取魔豆收入支出
            case ACTION.GETMONTHMODOU:
                MoDouBeanOne moDouBeanOne = GsonUtil.toObj(res,MoDouBeanOne.class);
                if(moDouBeanOne.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (moDouBeanOne.isSuccess()) {
                        tv_mine_bean_zhichu.setText(moDouBeanOne.getBody().getPointsChargeSumByMonth().get(1).getSumPoints() + "");

                        tv_mine_bean_shouru.setText(moDouBeanOne.getBody().getPointsChargeSumByMonth().get(0).getSumPoints() + "");
                    } else {
                        T.show(moDouBeanOne.getMsg());
                    }
                }
                break;
            //获取魔豆列表
            case ACTION.GETMINEMODOUBEAN:
                loadingDialog.cancel();
                MineBeanByTimeBean mineBeanByTimeBean = GsonUtil.toObj(res, MineBeanByTimeBean.class);
                if(mineBeanByTimeBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (mineBeanByTimeBean.isSuccess()) {
                        pageSum = mineBeanByTimeBean.getBody().getPointsRecord().size();

                        loadMoreData(mineBeanByTimeBean.getBody().getPointsRecord());
                    } else {
                        T.show(mineBeanByTimeBean.getMsg());
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


    public void loadMoreData(List<MineBeanByTimeBean.BodyBean.PointsRecordBean> apiOrderListMore){

        if(pointsRecord == null){
            pointsRecord = new ArrayList<>();
        }
        if(pageIndex == 0){
            mineBeanByTimeItemAdapter.Clear();
        }
        pointsRecord.addAll(apiOrderListMore);
        if(pageIndex == 0){
            mineBeanByTimeItemAdapter.setmDate(pointsRecord);
        }else{
            mineBeanByTimeItemAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
