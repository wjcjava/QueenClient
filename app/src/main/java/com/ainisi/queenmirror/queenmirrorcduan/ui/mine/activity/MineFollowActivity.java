package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineFollowAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineFollowBean;
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
 *
 * 关注店铺
 */
public class MineFollowActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.mine_follow_recycler)
    RecyclerView recycler;
    @Bind(R.id.title_title)
    TextView folltitle;
    @Bind(R.id.li_mine_follow_none)
    LinearLayout li_mine_follow_none;
    @Bind(R.id.mine_follow_refreshLayout)
    SmartRefreshLayout mine_follow_refreshLayout;
    List<MineFollowBean.BodyBean.CommentsListDataBean> commentsListDataBeanList = new ArrayList<>();
    int pageNumber = 1,pageIndex = 0,pageSum = 0;
    LoadingDialog loadingDialog;
    MineFollowAdapter sortAdapter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineFollowActivity.class));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_follow;
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.MINEINSHOP:
                loadingDialog.cancel();
                MineFollowBean mineFollowBean = GsonUtil.toObj(res,MineFollowBean.class);
                if(mineFollowBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else if(mineFollowBean.isSuccess()&&mineFollowBean.getErrorCode().equals("0")){
                    if (mineFollowBean.getBody().getCommentsListData().size() > 0) {
                        li_mine_follow_none.setVisibility(View.GONE);

                        pageSum = mineFollowBean.getBody().getCommentsListData().size();

                        loadMoreData(mineFollowBean.getBody().getCommentsListData());

                        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(MineFollowActivity.this, WorkRoomDetailActivity.class);
                                intent.putExtra("shopName", commentsListDataBeanList.get(position).getAnsShopBasic().getShopName());
                                intent.putExtra("shopId", commentsListDataBeanList.get(position).getAnsShopBasic().getId());
                                intent.putExtra("cpCate", "1");
                                startActivity(intent);
                            }
                        });
                    } else {

                        if(pageIndex == 0){
                            li_mine_follow_none.setVisibility(View.VISIBLE);
                        }else{
                            li_mine_follow_none.setVisibility(View.GONE);
                        }

                    }
                }else{
                    T.show(mineFollowBean.getMsg());
                }

                break;
        }
    }
    @Override
    protected void doFirstRequest() {
        super.doFirstRequest();
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber+"");
        params.put("userId", SP.get(MineFollowActivity.this,SpContent.UserId,"")+"");
        params.put("pageSize", SpContent.pageSize);
        params.put("token",SP.get(MineFollowActivity.this,SpContent.UserToken,"0")+"");
        HttpUtils.doPost(ACTION.MINEINSHOP, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initView() {
        super.initView();
        folltitle.setText("关注店铺");
        loadingDialog = new LoadingDialog(this);

        sortAdapter = new MineFollowAdapter(this, R.layout.item_fullshortrecycler, commentsListDataBeanList);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(sortAdapter);


        mine_follow_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                doFirstRequest();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_follow_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
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

    @Override
    protected void initData() {
        super.initData();
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

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    public void loadMoreData(List<MineFollowBean.BodyBean.CommentsListDataBean> apiOrderListMore){


        if(commentsListDataBeanList == null){
            commentsListDataBeanList = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter.Clear();
        }
        commentsListDataBeanList.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter.setmDate(commentsListDataBeanList);
        }else{
            sortAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
