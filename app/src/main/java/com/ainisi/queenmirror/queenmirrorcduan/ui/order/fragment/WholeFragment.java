package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderAllAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
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
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

import static android.app.Activity.RESULT_OK;

/**
 * Created by EWorld on 2018/3/6.
 * 全部订单
 */

public class WholeFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.rc_whole)
    RecyclerView whole;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.tv_shop_null_text)
    TextView tv_shop_null_text;
    int pageSum = 0, pageNumber = 1, pageIndex = 0;
    String state;
    public static WholeFragment instance = null;
    OrderAllAdapter sbmitWholeAdapter;
    LoadingDialog loadingDialog;
    private List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data = new ArrayList();

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.fragment_sort_whole;
    }

    public WholeFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);
        WholeFragment testFm = new WholeFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    protected void doFitsrData() {
        if (SP.get(getActivity(), SpContent.isLogin, "").equals("1")) {
            doFirstData();
        }
    }

    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());
        tv_shop_null_text.setText("暂无订单信息");
        if (sbmitWholeAdapter == null) {
            sbmitWholeAdapter = new OrderAllAdapter(getActivity(), R.layout.item_sbmitrecycler, data);
            whole.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
            whole.setAdapter(sbmitWholeAdapter);
        }
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                doFirstData();
                refreshlayout.finishRefresh(1000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                } else {
                    pageNumber++;
                    doFirstData();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    /**
     * 获取全部订单的数据
     */
    public void doFirstData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            state = bundle.getString("state");
        }
        if (state.equals("")) {
        } else {
            loadingDialog.loadShow();
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("orderStatus", state);
        params.put("pageNumber", pageNumber + "");
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("pageSize", SpContent.pageSize);
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ALLOFMYORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {

            case ACTION.ALLOFMYORDER:
                if (state.equals("")) {
                } else {
                    loadingDialog.cancel();
                }
                OrderMyAllOrderBean orderMyAllOrderBean = GsonUtil.toObj(res, OrderMyAllOrderBean.class);
                if (orderMyAllOrderBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (orderMyAllOrderBean.isSuccess()) {
                        pageSum = orderMyAllOrderBean.getBody().getApiOrderList().size();

                        if (pageSum == 0) {
                            if (pageIndex == 0) {
                                shop_list_null.setVisibility(View.VISIBLE);
                            } else {
                                shop_list_null.setVisibility(View.GONE);
                            }

                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            loadMoreData(orderMyAllOrderBean.getBody().getApiOrderList());
                        }
                    } else {
                        T.show(orderMyAllOrderBean.getMsg());
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

    public void loadMoreData(List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> apiOrderListMore) {
        List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> getdata = sbmitWholeAdapter.getdata();
        if (pageIndex == 0) {
            getdata.clear();
        }
        getdata.addAll(apiOrderListMore);
        sbmitWholeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> getdata = sbmitWholeAdapter.getdata();
        String orderId = data.getStringExtra("orderId");
        if (requestCode == 1 && resultCode == RESULT_OK) {
            for (int i = 0; i < getdata.size(); i++) {
                String id = getdata.get(i).getIntfAnsOrder().getId();
                if (id.equals(orderId)) {
                    getdata.remove(i);
                    sbmitWholeAdapter.notifyDataSetChanged();
                    break;
                }
            }
        }
    }
}
