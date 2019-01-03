package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyCommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
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
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的评价
 */
public class MineEvaluateActivity extends BaseActivity implements HttpCallBack {

    @Bind(R.id.rc_evaluate)
    RecyclerView rcevaluate;
    private List<SortBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    private View evaluateView;
    @Bind(R.id.tv_name)
    TextView evalueteName;
    @Bind(R.id.tv_evaluate_number)
    TextView numeber;
    @Bind(R.id.li_mine_comment_null)
    LinearLayout li_mine_comment_null;
    @Bind(R.id.iv_mine_evaluate_title)
    CircleImageView iv_mine_evaluate_title;
    @Bind(R.id.mine_evaluate_refreshLayout)
    SmartRefreshLayout mine_evaluate_refreshLayout;
    List<MyCommentsBean.BodyBean.CommentsListDataBean> commentList = new ArrayList<>();
    int pageNumber = 1, pageIndex = 0, pageSum = 0;
    MyCommentsAdapter sortAdapter2;
    LoadingDialog loadingDialog;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineEvaluateActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_evaluate;
    }

    @Override
    public void initPresenter() {
        loadingDialog = new LoadingDialog(this);
    }

    @Override
    public void initView() {

        Glide.with(MineEvaluateActivity.this).load(SP.get(MineEvaluateActivity.this, SpContent.userHeadPic, "") + "").dontAnimate().placeholder(R.drawable.dismiss).into(iv_mine_evaluate_title);
        initReply();
        inithttp();
        sortAdapter2 = new MyCommentsAdapter(R.layout.item_evaluate, commentList, this);
        rcevaluate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcevaluate.setAdapter(sortAdapter2);

        mine_evaluate_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                inithttp();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_evaluate_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if (pageSum <= pageIndex) {
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                } else {
                    pageNumber++;
                    inithttp();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    private void initReply() {
        evalueteName.setText(SP.get(this, SpContent.UserName, "") + "");
    }

    public void initData() {
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

    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("userId", SP.get(MineEvaluateActivity.this, SpContent.UserId, "0") + "");
        parames.put("pageNumber", pageNumber + "");
        parames.put("pageSize", SpContent.pageSize);
        parames.put("token", SP.get(MineEvaluateActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.MYCOMMENTS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.MYCOMMENTS:
                loadingDialog.cancel();
                final MyCommentsBean commentsBean = GsonUtil.toObj(res, MyCommentsBean.class);

                if (commentsBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {

                    evaluateView = LayoutInflater.from(this).inflate(R.layout.item_evaluate, null);

                    pageSum = commentsBean.getBody().getPageSum();
                    if (commentsBean.getBody().getCommentsListData().size() > 0) {
                        numeber.setText("共有" + pageSum + "条数据");
                        li_mine_comment_null.setVisibility(View.INVISIBLE);
                    } else {
                        numeber.setText("共有0条数据");
                        li_mine_comment_null.setVisibility(View.VISIBLE);
                    }
                    if (commentsBean.isSuccess()) {
                        loadMoreData(commentsBean.getBody().getCommentsListData());

                        sortAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(MineEvaluateActivity.this, ReplyCommentActivity.class);
                                intent.putExtra("shopId", commentList.get(position).getEcAppraiseGoods().getShopId());
                                intent.putExtra("shopName", commentList.get(position).getShopIdName());
                                intent.putExtra("shopDevice", commentList.get(position).getEcAppraiseGoods().getEmployeeAbility());
                                if (commentList.get(position).getEcAppraiseShop() != null) {
                                    intent.putExtra("serviceAttitude", commentList.get(position).getEcAppraiseShop().getServiceAttitude());
                                    intent.putExtra("shopEnvironment", commentList.get(position).getEcAppraiseShop().getShopEnvironment());
                                } else {
                                    intent.putExtra("serviceAttitude", "4");
                                    intent.putExtra("shopEnvironment", "4");
                                }
                                intent.putExtra("apprTime", commentList.get(position).getEcAppraiseGoods().getApprTime());
                                intent.putExtra("goodsName", commentList.get(position).getGoodsIdName());
                                intent.putExtra("commentgContent", commentList.get(position).getEcAppraiseGoods().getApprDetails());
                                intent.putExtra("commentId", commentList.get(position).getEcAppraiseGoods().getId());
                                intent.putExtra("commshopId", commentList.get(position).getEcAppraiseGoods().getId());
                                intent.putExtra("logo_pic", commentList.get(position).getEcAppraiseGoods().getApprPic());
                                startActivity(intent);
                            }
                        });
                    } else {
                        T.show(commentsBean.getMsg());
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

    public void loadMoreData(List<MyCommentsBean.BodyBean.CommentsListDataBean> apiOrderListMore) {

        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        if (pageIndex == 0) {
            sortAdapter2.Clear();
        }
        commentList.addAll(apiOrderListMore);
        if (pageIndex == 0) {
            sortAdapter2.setmDate(commentList);
        } else {
            sortAdapter2.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}