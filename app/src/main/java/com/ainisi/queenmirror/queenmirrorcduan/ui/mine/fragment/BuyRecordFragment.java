package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.BuyRecordListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.BuyRecordBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorClassListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GsonUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.SpaceItemDecoration;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WrapContentLinearLayoutManager;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * 购买记录【接口无数据】
 *
 * @author jiangchao
 *         created at 2018/9/10 下午4:56
 */
public class BuyRecordFragment extends Fragment implements HttpCallBack {

    private static final String TAG = "BuyRecordFragment";
    @Bind(R.id.rv_video_list)
    RecyclerView rvVideoList;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @Bind(R.id.iv_have_no_data)
    ImageView ivHaveNoData;
    @Bind(R.id.rl_get_data_again)
    RelativeLayout rlGetDataAgain;

    private int curPage = 1;
    private int pageSize = 20;
    private static final int STATE_INIT = 0;
    private static final int STATE_REFRESH = 1;
    private static final int STATE_LOAD_MORE = 2;
    private int curState = 0;
    private int totalPage = 1;
    private BuyRecordListAdapter mAdapter;
    List<BuyRecordBean.BodyEntity.RecordsListEntity> classListEntityList;
    private String tabName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_buy_record, null);
//        ((TextView) contentView.findViewById(R.id.tv_content)).setText(getArguments().getString(EXTRA_CONTENT));
        ButterKnife.bind(this, contentView);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                curState = STATE_REFRESH;
                curPage = 1;
                getData();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshLayout) {
                curState = STATE_LOAD_MORE;
                curPage = curPage + 1;
                if (curPage <= totalPage) {
                    getData();
                } else {
                    refreshLayout.finishLoadmore();
                }
                refreshLayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }

        });


        getData();

        return contentView;
    }


    //获取验证码
    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        map.put("pageNumber", String.valueOf(curPage));
        map.put("pageSize", String.valueOf(pageSize));
        HttpUtils.doPost(ACTION.VIDEO_PAY_RECORDS, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.VIDEO_PAY_RECORDS:
                BuyRecordBean buyRecordBean = GsonUtils.jsonToBean(res, BuyRecordBean.class);
                if (buyRecordBean.isSuccess()) {
                    if ("6".equals(buyRecordBean.getErrorCode())) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        //得到总页数，上拉加载更多的时候用于判断还有没有更多数据
                        //这里的PageSum是总数量，后台名字起错了
                        totalPage = (buyRecordBean.getBody().getPageSum() / pageSize);
                        //得到数据
                        classListEntityList = buyRecordBean.getBody().getRecordsList();
                        if (classListEntityList.size() == 0) {
                            hasData(true);
                        } else {
                            hasData(false);
                        }
                        showData();
                    }
                }
                break;

            default:
                break;
        }
    }


    MajorClassListBean.BodyEntity.ClassListEntity classListEntity;

    private void showData() {

        switch (curState) {
            case STATE_INIT:
                //初始化状态，初始化列表
                mAdapter = new BuyRecordListAdapter(getActivity(), classListEntityList);
                rvVideoList.addItemDecoration(new SpaceItemDecoration(5));
                AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
                alphaAdapter.setFirstOnly(false);
                alphaAdapter.setDuration(1000);
                alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
                rvVideoList.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));

                rvVideoList.setItemAnimator(new SlideInLeftAnimator());
                rvVideoList.getItemAnimator().setAddDuration(1000);
                rvVideoList.getItemAnimator().setRemoveDuration(1000);
                rvVideoList.getItemAnimator().setMoveDuration(1000);
                rvVideoList.getItemAnimator().setChangeDuration(1000);

                rvVideoList.setLayoutManager(new WrapContentLinearLayoutManager(getActivity()));

                mAdapter.setOnItemListener(new BuyRecordListAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(View v, int position, List<BuyRecordBean.BodyEntity.RecordsListEntity> entity) {
                        if (entity != null) {
//                            classListEntity = entity.get(position);
//                            IntentUtil.goOrderDetailListActivity(classListEntity, position, getActivity());
//                            Intent intent = new Intent(getActivity(), MajorClassDetailActivity.class);
//                            intent.putExtra("classListEntity", classListEntity);
//                            startActivity(intent);
//                            Toast.makeText(getActivity(), classListEntity.getClassName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case STATE_REFRESH:
                if (classListEntityList.size() == 0) {
                    hasData(true);
                } else {
                    hasData(false);
                }
                //下拉刷新状态，刷新数据，列表回到最顶端，关闭下拉刷新
                mAdapter.refreshData(classListEntityList);
                rvVideoList.scrollToPosition(0);
                refreshLayout.finishRefresh();
                break;
            case STATE_LOAD_MORE:
                //上拉加载更多状态，追加数据，关闭上拉加载更多
                mAdapter.loadMoreData(classListEntityList);
                refreshLayout.finishLoadmore();
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

    public void hasData(boolean isFlag) {
        if (isFlag) {
            //无数据
//            if (goodsList != null) {
//                goodsList.setVisibility(View.GONE);
//            }
            if (rlGetDataAgain != null) {
                rlGetDataAgain.setVisibility(View.VISIBLE);
            }
//            if (ErrorView != null)
//                ErrorView.setVisibility(View.GONE);
//            if (mNoNetWorkView != null)
//                mNoNetWorkView.setVisibility(View.GONE);
        } else {
            //有数据
//            if (goodsList != null) {
//                goodsList.setVisibility(View.VISIBLE);
//            }
            if (rlGetDataAgain != null) {
                rlGetDataAgain.setVisibility(View.INVISIBLE);
            }
//            if (ErrorView != null)
//                ErrorView.setVisibility(View.GONE);
//            if (mNoNetWorkView != null)
//                mNoNetWorkView.setVisibility(View.GONE);
        }
    }
}
