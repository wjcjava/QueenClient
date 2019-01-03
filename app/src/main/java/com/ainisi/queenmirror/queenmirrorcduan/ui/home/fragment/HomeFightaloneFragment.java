package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PintuanListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
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

/**
 * A simple {@link Fragment} subclass.
 * 拼团
 */
public class HomeFightaloneFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.recycler_fragment_fightalone)
    RecyclerView reFightalone;

    @Bind(R.id.fightalone_refreshLayout)
    SmartRefreshLayout fightalone_refreshLayout;
    @Bind(R.id.tv_shop_null_text)
    TextView tv_shop_null_text;

    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;

    List<PinTuanBean.BodyBean.GroupActivityListDataBean> sortlist = new ArrayList<>();
    String state = "0";
    int pageSum = 0, pageNumber = 1, pageIndex = 0;

    PintuanListAdapter pintuanListAdapter;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home_fightalone;
    }

    public HomeFightaloneFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);

        HomeFightaloneFragment testFm = new HomeFightaloneFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void doFitsrData() {
        if (sortlist.size() == 0)
            getData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initView() {
        tv_shop_null_text.setText("暂无拼团相关信息");
        if (pintuanListAdapter == null) {
            pintuanListAdapter = new PintuanListAdapter(getActivity(), R.layout.re_home_fightalone, sortlist);
            reFightalone.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            reFightalone.addItemDecoration(new SpaceItemDecoration(getActivity()).setSpace(5).setSpaceColor(0xFFF7F7F7));
            reFightalone.setAdapter(pintuanListAdapter);
        }

        fightalone_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                getData();
                refreshlayout.finishRefresh(1000);
            }
        });
        fightalone_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载全部数据");
                } else {
                    pageNumber++;
                    getData();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    /**
     * 获取数据
     */
    private void getData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            state = bundle.getString("state");
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("groupStatus", "3");
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", state);
        params.put("pageSize", SpContent.pageSize);
        params.put("areaCode", SP.get(getActivity(), SpContent.CityCode, "0512") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.TUANDUILISTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.TUANDUILISTDATA:
                PinTuanBean pinTuanBean = GsonUtil.toObj(res, PinTuanBean.class);
                if (pinTuanBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (pinTuanBean.isSuccess()) {
                        pageSum = pinTuanBean.getBody().getGroupActivityListData().size();


                        if (pinTuanBean.getBody().getGroupActivityListData().size() == 0) {
                            if (pageIndex == 0) {
                                shop_list_null.setVisibility(View.VISIBLE);
                            } else {
                                shop_list_null.setVisibility(View.GONE);
                            }

                            T.show("您已加载全部数据");
                        } else {
                            shop_list_null.setVisibility(View.GONE);
                            loadMoreData(pinTuanBean.getBody().getGroupActivityListData());
                        }

                        pintuanListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                /**
                                 * 这里需要传商品的相关信息的？
                                 */
                                Intent intent = new Intent(getActivity(), FightaloneActivity.class);
                                intent.putExtra("activityId", sortlist.get(position).getGpActivity().getId());
                                intent.putExtra("goodsName", sortlist.get(position).getEcGoodsBasic().getGoodsName());
                                intent.putExtra("goodsId", sortlist.get(position).getEcGoodsBasic().getId());
                                intent.putExtra("goodsBrief", sortlist.get(position).getEcGoodsBasic().getGoodsBrief());
                                intent.putExtra("goodsService", sortlist.get(position).getEcGoodsBasic().getServiceTime());
                                intent.putExtra("goodsSales", sortlist.get(position).getEcGoodsBasic().getSalesPrice());
                                intent.putExtra("goodsGroup", sortlist.get(position).getGpActivity().getGroupPrice());

                                if (sortlist.get(position).getEcGoodsBasic().getMarketPrice() == null) {
                                    intent.putExtra("goodsMarket", "0");
                                } else {
                                    intent.putExtra("goodsMarket", sortlist.get(position).getEcGoodsBasic().getMarketPrice());

                                }
                                //  intent.putExtra("goodsNumber",sortlist.get(position).getEcGoodsBasic().get)
                                startActivity(intent);

                            }
                        });
                    } else {
                        T.show("暂无相关信息");
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

    public void loadMoreData(List<PinTuanBean.BodyBean.GroupActivityListDataBean> apiOrderListMore) {


        if (sortlist == null) {
            sortlist = new ArrayList<>();
        }
        if (pageIndex == 0) {
            pintuanListAdapter.Clear();
        }
        sortlist.addAll(apiOrderListMore);
        if (pageIndex == 0) {
            pintuanListAdapter.setmDate(sortlist);
        } else {
            pintuanListAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
