package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MySystemMessageAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsMessageSystemBean;
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

/**
 * 系统消息
 */
public class SystemActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.recycler_systemmessage)
    RecyclerView systemRecyclerView;
    @Bind(R.id.system_refreshLayout)
    SmartRefreshLayout system_refreshLayout;
    int pageNumber = 1;
    int pageSum = 0;
    int pageIndex = 0;
    List<NewsMessageSystemBean.BodyBean.MessListBean> messList = new ArrayList<>();
    MySystemMessageAdapter adapter;
    String messType="1";
    LoadingDialog loadingDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_system;
    }

    @Override
    protected void initView() {
        super.initView();
        title.setText("系统消息");
        loadingDialog = new LoadingDialog(SystemActivity.this);
        Intent intent = this.getIntent();
        messType = intent.getStringExtra("type");
        getSystemData();
        adapter = new MySystemMessageAdapter(R.layout.message_system_list_item, messList);
        systemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        systemRecyclerView.setAdapter(adapter);
        system_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                getSystemData();
                refreshlayout.finishRefresh(2000);
            }
        });
        system_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                } else {
                    pageNumber++;
                    getSystemData();
                    refreshlayout.finishLoadmore(2000);
                }
            }
        });
    }

    /**
     * 获取系统消息数据
     */
    private void getSystemData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("token", SP.get(SystemActivity.this,SpContent.UserToken,"0")+"");
        parames.put("messType",messType);
        parames.put("pageNumber",pageNumber+"");
        parames.put("pageSize",SpContent.pageSize);
        HttpUtils.doPost(ACTION.MESSAGEDETAIL, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.MESSAGEDETAIL:
                loadingDialog.cancel();
                NewsMessageSystemBean newsMessageSystemBean = GsonUtil.toObj(res,NewsMessageSystemBean.class);
                if(newsMessageSystemBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (newsMessageSystemBean.isSuccess()) {
                        pageSum = newsMessageSystemBean.getBody().getMessList().size();

                        loadMoreData(newsMessageSystemBean.getBody().getMessList());

                    /*adapter = new MySystemMessageAdapter(R.layout.item_system, messList);
                    systemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    systemRecyclerView.setAdapter(adapter);*/

                    } else {
                        T.show(newsMessageSystemBean.getMsg());
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

    public void loadMoreData(List<NewsMessageSystemBean.BodyBean.MessListBean> messListMore) {

        if (messList == null) {
            messList = new ArrayList<>();
        }
        if (pageIndex == 0) {
            adapter.Clear();
        }
        messList.addAll(messListMore);
        if (pageIndex == 0) {
            adapter.setmDate(messList);
        } else {
            adapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
