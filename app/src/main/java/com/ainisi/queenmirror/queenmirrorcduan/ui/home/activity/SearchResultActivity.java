package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SearchGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.ShopSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
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

public class SearchResultActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.rc_search_result)
    RecyclerView rc_search_result;
    @Bind(R.id.search_refreshLayout)
    SmartRefreshLayout search_refreshLayout;
    String which;
    List<ShopListHomeBean.BodyBean.ShopListDataBean> shoplist = new ArrayList<>();
    List<GoodsListBean.BodyBean.GoodsListDataBean> goodsListDataBeans = new ArrayList<>();

    List<ShopListHomeBean.BodyBean.ShopListDataBean> shoplists = new ArrayList<>();
    List<GoodsListBean.BodyBean.GoodsListDataBean> goodsListDataBeanss = new ArrayList<>();
    SearchGoodsAdapter searchGoodsAdapter;
    ShopSearchAdapter searchAdapter;
    int pageNumber =1,pageIndex=0,pageSum=0;

    LoadingDialog loadingDialog;
    ShopListHomeBean shopListHomeBean;
    String shopCate,contentByTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void initView() {
        super.initView();
        loadingDialog = new LoadingDialog(SearchResultActivity.this);
        title_title.setText("搜索结果");
        Intent intent = this.getIntent();
        which = intent.getStringExtra("which");
        shopCate = intent.getStringExtra("shopCate");
        contentByTitle = intent.getStringExtra("contentByTitle");
        pageSum = Integer.parseInt(intent.getStringExtra("pageSum"));
        if(which.equals("good")){
            goodsListDataBeanss = (List<GoodsListBean.BodyBean.GoodsListDataBean>) intent.getSerializableExtra("lstBean");
        }else if(which.equals("shop")){
            shoplists = (List<ShopListHomeBean.BodyBean.ShopListDataBean>) intent.getSerializableExtra("lstBean");
        }

        if(which.equals("good")){
            searchGoodsAdapter = new SearchGoodsAdapter(SearchResultActivity.this,R.layout.re_workroom_short,goodsListDataBeans);
            rc_search_result.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rc_search_result.setAdapter(searchGoodsAdapter);
        }else if(which.equals("shop")){

            searchAdapter = new ShopSearchAdapter(SearchResultActivity.this,R.layout.item_shopsearch, shoplist);
            rc_search_result.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rc_search_result.setAdapter(searchAdapter);
        }

        if(which.equals("good")){
            loadMoreData(goodsListDataBeanss);
        }else if(which.equals("shop")){
            loadMoreShopData(shoplists);
        }

        search_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                if (which.equals("shop")){
                    initShopSearch();
                } else if (which.equals("good")) {
                    initNailsSearch();
                }
                refreshlayout.finishRefresh(1000);
            }
        });
        search_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    if (which.equals("shop")){
                        initShopSearch();
                    } else if (which.equals("good")) {
                        initNailsSearch();
                    }
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }


    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    /**
     * 搜索商品列表
     */
    private void initNailsSearch() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("saleFlag", "2");//活动的ID
        parames.put("pageNumber", pageNumber+"");//商铺状态ID 1.首页 2.异业
        parames.put("contentByTitle", contentByTitle);
        parames.put("shopCate",shopCate);
        parames.put("pageSize",SpContent.pageSize);
        parames.put("cityCode", SP.get(SearchResultActivity.this,SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.GOODLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 获取搜索店铺列表
     */
    private void initShopSearch() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber+"");//活动的ID
        parames.put("contentByTitle", contentByTitle);//商铺状态ID 1.首页 2.异业
        parames.put("shopCate",shopCate);
        parames.put("pageSize",SpContent.pageSize);
        parames.put("cityCode",SP.get(SearchResultActivity.this,SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.SHOPLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    public void loadMoreData(List<GoodsListBean.BodyBean.GoodsListDataBean> apiOrderListMore){

        if(goodsListDataBeans == null){

            goodsListDataBeans = new ArrayList<>();
        }
        if(pageIndex == 0){
            searchGoodsAdapter.Clear();
        }
        goodsListDataBeans.addAll(apiOrderListMore);
        if(pageIndex == 0){
            searchGoodsAdapter.setmDate(goodsListDataBeans);
        }else{
            searchGoodsAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }

    public void loadMoreShopData(List<ShopListHomeBean.BodyBean.ShopListDataBean> shopListMore){

        if(shoplist == null){
            shoplist = new ArrayList<>();
        }
        if(pageIndex == 0){
            searchAdapter.Clear();
        }
        shoplist.addAll(shopListMore);
        if(pageIndex == 0){
            searchAdapter.setmDate(shoplist);
        }else{
            searchAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GOODLIST:
                /**
                 * 获取搜索商品列表
                 */
                loadingDialog.cancel();
                GoodsListBean goodsListBean = GsonUtil.toObj(res,GoodsListBean.class);
                if(goodsListBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (goodsListBean.isSuccess()) {
                        if (goodsListBean.getBody().getGoodsListData().size() > 0) {
                            pageSum = goodsListBean.getBody().getGoodsListData().size();
                            loadMoreData(goodsListBean.getBody().getGoodsListData());
                        } else {
                            T.show("暂无商品信息");
                        }
                    } else {
                        T.show(goodsListBean.getMsg());
                    }
                }
                break;
            /**
             * 获取店铺列表
             */
            case ACTION.SHOPLIST:
                loadingDialog.cancel();
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(shopListHomeBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (shopListHomeBean.isSuccess()) {
                        if (shopListHomeBean.getBody().getShopListData().size() > 0) {
                            pageSum = shopListHomeBean.getBody().getShopListData().size();
                            loadMoreShopData(shopListHomeBean.getBody().getShopListData());
                        } else {
                            T.show("暂无店铺信息");
                        }
                    } else {
                        T.show(shopListHomeBean.getMsg());
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
