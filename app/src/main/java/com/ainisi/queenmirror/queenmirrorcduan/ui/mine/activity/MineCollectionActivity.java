package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineCollectionAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineCollectionListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
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
 * 我的收藏
 */
public class MineCollectionActivity extends BaseNewActivity implements HttpCallBack {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineCollectionActivity.class));
    }
    @Bind(R.id.recyler_collection)
    RecyclerView collrecycler;
    @Bind(R.id.title_title)
    TextView colltitle;
    @Bind(R.id.mine_collection_refreshLayout)
    SmartRefreshLayout mine_collection_refreshLayout;
    List<MineCollectionListBean.BodyBean.CollectListDataBean> CollectListData = new ArrayList<>();
    int pageNumber = 1,pageIndex =0,pageSum=0;

    LoadingDialog loadingDialog;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.tv_shop_null_text)
    TextView tv_shop_null_text;

    MineCollectionAdapter sortAdapter2;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_collection;
    }

    @Override
    protected void initView() {
        super.initView();
        initText();

        tv_shop_null_text.setText("暂无收藏信息");
    }

    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();

        loadingDialog = new LoadingDialog(this);
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("userId", SP.get(MineCollectionActivity.this,SpContent.UserId,"")+"");
        params.put("token",SP.get(MineCollectionActivity.this,SpContent.UserToken,"")+"");
        params.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.MINECOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    private void initText() {
        colltitle.setText(R.string.my_collection);

        sortAdapter2 = new MineCollectionAdapter(MineCollectionActivity.this, R.layout.item_collection, CollectListData);
        collrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        collrecycler.setAdapter(sortAdapter2);


        mine_collection_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                doFirstRequest();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_collection_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载全部数据");
                }else{
                    pageNumber++;
                    doFirstRequest();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });

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
        switch (action){
            case ACTION.MINECOLLECTION:
                loadingDialog.cancel();

                MineCollectionListBean mineCollectionListBean = GsonUtil.toObj(res,MineCollectionListBean.class);

                if(mineCollectionListBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {



                    if (mineCollectionListBean.getBody().getCollectListData().size() > 0) {
                        shop_list_null.setVisibility(View.GONE);


                        pageSum = mineCollectionListBean.getBody().getCollectListData().size();

                        loadMoreData(mineCollectionListBean.getBody().getCollectListData());

                        sortAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(MineCollectionActivity.this, FullActivity.class);
                                intent.putExtra("goodsId", CollectListData.get(position).getEcGoodsBasic().getId() + "");
                                intent.putExtra("shopId", CollectListData.get(position).getEcGoodsBasic().getShopId() + "");
                                intent.putExtra("shopName", CollectListData.get(position).getAnsShopBasic().getShopName());
                                intent.putExtra("number", CollectListData.get(position).getEcGoodsBrowses().getBrowseCounts() + "");
                                String[] split = CollectListData.get(position).getEcGoodsBasic().getGoodsThumb().split(",");
                                intent.putExtra("shopLogo", split[0]);

                                startActivity(intent);
                            }
                        });
                    } else {

                        if(pageIndex == 0){
                            shop_list_null.setVisibility(View.VISIBLE);
                        }else{
                            shop_list_null.setVisibility(View.GONE);
                        }

                        DisplayMetrics dm = getResources().getDisplayMetrics();
                        int heigth = dm.heightPixels;
                        RelativeLayout.LayoutParams gallery_lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, heigth);
                        shop_list_null.setLayoutParams(gallery_lp);
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

    public void loadMoreData(List<MineCollectionListBean.BodyBean.CollectListDataBean> apiOrderListMore){


        if(CollectListData == null){
            CollectListData = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter2.Clear();
        }
        CollectListData.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter2.setmDate(CollectListData);
        }else{
            sortAdapter2.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
