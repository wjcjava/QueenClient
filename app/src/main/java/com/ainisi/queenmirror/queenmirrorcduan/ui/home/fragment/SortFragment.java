package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SortFragmentLvAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsRanking;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * 作者：linxi on 2018/9/17 17:09
 * 邮箱：707078566@qq.com
 * 用途：排行榜
 */
public class SortFragment extends BaseFragment implements HttpCallBack, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.sort_lv)
    ListView mSortLv;
    @Bind(R.id.sort_refreshLayout)
    SmartRefreshLayout mSortRefreshLayout;
    private SortFragmentLvAdapter mAdapter;
    private String goodsCate;
    private String rankingList;
    private int pageNumber = 1;
    private int pageSize = 10;

    @Override

    protected int getLayoutResource() {
        return R.layout.fragment_sort;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mSortRefreshLayout.setOnRefreshListener(this);
        mSortRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected void doFitsrData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            goodsCate = bundle.getString("goodsCate");
            rankingList = bundle.getString("rankingList");
        }
        goodsRankingList();
    }

    private void goodsRankingList() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", String.valueOf(pageNumber));
        parames.put("pageSize", String.valueOf(pageSize));
        parames.put("goodsCate", goodsCate);
        parames.put("rankingList", rankingList);
        parames.put("belongCity", (String) SP.get(getActivity(), SpContent.CityCode, "0512"));
        HttpUtils.doPost(ACTION.GOODSRANKINGLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.GOODSRANKINGLIST:
                GoodsRanking goodsRanking = GsonUtil.toObj(res, GoodsRanking.class);
                if (goodsRanking.isSuccess() && goodsRanking.getErrorCode().equals("0")) {
                    if (mAdapter == null) {
                        mAdapter = new SortFragmentLvAdapter(getActivity(), rankingList);
                        mSortLv.setAdapter(mAdapter);
                    }
                    final List<GoodsRanking.BodyBean.GoodsRankingListBean> list = mAdapter.getList();
                    if (pageNumber == 1) {
                        list.clear();
                    }
                    list.addAll(goodsRanking.getBody().getGoodsRankingList());
                    mAdapter.notifyDataSetChanged();
                    mSortLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //拼团1
                            if ("1".equals(list.get(i).getGroupGoods())) {
                                Intent intent = new Intent(getActivity(), FightaloneActivity.class);
                                intent.putExtra("activityId", list.get(i).getActivityId());
                                intent.putExtra("goodsName", list.get(i).getGoodsName());
                                intent.putExtra("goodsId", list.get(i).getId());
                                intent.putExtra("goodsBrief", list.get(i).getGoodsBrief());
                                intent.putExtra("goodsService", list.get(i).getServiceTime());
                                intent.putExtra("goodsSales", list.get(i).getSalesPrice());
                                intent.putExtra("goodsGroup", list.get(i).getGroupPrice());
                                if (TextUtils.isEmpty(list.get(i).getMarketPrice())) {
                                    intent.putExtra("goodsMarket", "0");
                                } else {
                                    intent.putExtra("goodsMarket", list.get(i).getMarketPrice());
                                }
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(getActivity(), FullActivity.class);
                                intent.putExtra("goodsId", list.get(i).getId());
                                intent.putExtra("shopId", list.get(i).getShopId());
                                intent.putExtra("shopName", list.get(i).getShopName());
                                intent.putExtra("shopLogo", list.get(i).getGoodsThumb());
                                intent.putExtra("number", "");
                                startActivity(intent);
                            }

                        }
                    });
                } else {
                    T.show(goodsRanking.getMsg());
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

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        pageNumber = 1;
        goodsRankingList();
        mSortRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshLayout) {
        pageNumber++;
        goodsRankingList();
        mSortRefreshLayout.finishLoadmore();
    }

    public SortFragment newInstance(String goodsCate, String rankingList) {
        Bundle bundle = new Bundle();
        bundle.putString("goodsCate", goodsCate);
        bundle.putString("rankingList", rankingList);
        SortFragment testFm = new SortFragment();
        testFm.setArguments(bundle);
        return testFm;
    }
}
