package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsMoreAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 更多
 */
public class RecommendedActivity extends BaseActivity implements HttpCallBack {
    @Bind(R.id.re_recommended)
    RecyclerView reRecommended;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    String categoryId;
    int pageNumber = 1,pageIndex = 0,pageSum = 0;
    LoadingDialog loadingDialog;
    EstheticsMoreAdapter sortAdapter;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    List<EstheticsBean.BodyBean.ShopListBean> apiOrderList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_recommended;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        categoryId = intent.getStringExtra("categoryId");
        inithttp();

        sortAdapter = new EstheticsMoreAdapter(this,R.layout.item_shortrecycler, apiOrderList);
        reRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reRecommended.setAdapter(sortAdapter);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                inithttp();
                refreshlayout.finishRefresh(1000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    inithttp();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", categoryId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("cityCode", SP.get(RecommendedActivity.this,SpContent.CityCode,"0512")+"");
        hashMap.put("shopCate", "1");
        hashMap.put("token",SP.get(RecommendedActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.MERCHANTSLIST:
                loadingDialog.cancel();
                EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                if(estheticsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (estheticsBean.isSuccess()) {
                        pageSum = estheticsBean.getBody().getShopList().size();
                        if (pageSum == 0) {
                            if(pageIndex == 0){
                                shop_list_null.setVisibility(View.VISIBLE);
                            }else{
                                shop_list_null.setVisibility(View.GONE);
                            }

                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            loadMoreData(estheticsBean.getBody().getShopList());
                        }
                        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(RecommendedActivity.this, WorkRoomDetailActivity.class);
                                intent.putExtra("shopName", apiOrderList.get(position).getAnsShopBasic().getShopName());
                                intent.putExtra("shopId", apiOrderList.get(position).getAnsShopBasic().getId());
                                startActivity(intent);
                            }
                        });
                    } else {
                        T.show(estheticsBean.getMsg());
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

    public void loadMoreData(List<EstheticsBean.BodyBean.ShopListBean> apiOrderListMore){

        if(apiOrderList == null){
            apiOrderList = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter.Clear();
        }
        apiOrderList.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter.setmDate(apiOrderList);
        }else{
            sortAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
