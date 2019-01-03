package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SecKillActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SpecialPriceActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.HomeFightaloneServiceAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PageBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.UserInfoListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.ActivityByHolidayActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.BigClassroomActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineGiftActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ComplexViewFight;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpaceItemDecoration;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.gongwen.marqueen.MarqueeView;
import com.gongwen.marqueen.util.OnItemClickListener;
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

/**
 * 作者：linxi on 2018/10/29 13:28
 * 邮箱：707078566@qq.com
 * 用途：拼团精选
 */
public class HomeFightaloneServiceFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.fight_banner)
    ImageView mFightBanner;
    @Bind(R.id.recycler_fragment_fightalone_service)
    RecyclerView mRecyclerFragmentFightaloneservice;
    @Bind(R.id.fightalone_refreshLayout)
    SmartRefreshLayout mFightaloneRefreshLayout;
    @Bind(R.id.fight_marqueeView)
    MarqueeView mFightMarqueeView;
    private int pageNumber = 1;
    private HomeFightaloneServiceAdapter mAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_homefightaloneservice;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mFightaloneRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                pageNumber = 1;
                initBanner();
                getData();
                initlist();
                mFightaloneRefreshLayout.finishRefresh();
            }
        });
        mFightaloneRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshLayout) {
                pageNumber++;
                initBanner();
                getData();
                initlist();
                mFightaloneRefreshLayout.finishLoadmore();
            }
        });
    }

    @Override
    protected void doFitsrData() {
        initBanner();
        getData();
        initlist();
    }

    private void getData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("groupStatus", "3");
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("pageSize", SpContent.pageSize);
        params.put("areaCode", SP.get(getActivity(), SpContent.CityCode, "0512") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        params.put("isChoice", "1");
        HttpUtils.doPost(ACTION.TUANDUILISTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initBanner() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("bannerCategory", "5");//0是首页   1是商城
        parames.put("platformType", "1");
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PAGEBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initlist() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", "1");//0是首页   1是商城
        parames.put("pageSize", "15");
        HttpUtils.doPost(ACTION.USERINFOLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    public HomeFightaloneServiceFragment newInstance() {
        Bundle bundle = new Bundle();
        HomeFightaloneServiceFragment testFm = new HomeFightaloneServiceFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            //banner
            case ACTION.PAGEBANNER:
                PageBannerBean bannerBean = GsonUtil.toObj(res, PageBannerBean.class);
                if (bannerBean.isSuccess()) {
                    final List<PageBannerBean.BodyBean.BannerListDataBean> bannerList = bannerBean.getBody().getBannerListData();
                    String[] split = bannerList.get(0).getBannerLogo().split(",");
                    Glide.with(getActivity()).load(split[0]).into(mFightBanner);
                    mFightBanner.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (bannerList.get(0).getBannerStyle().equals("1")) {
                                /**
                                 * 富文本
                                 */
                                Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                                intent.putExtra("bannerId", bannerList.get(0).getId());
                                intent.putExtra("bannerStyle", bannerList.get(0).getBannerStyle());
                                intent.putExtra("weburl", bannerList.get(0).getBannerUrl());
                                intent.putExtra("bannerLogo", bannerList.get(0).getBannerLogo());
                                intent.putExtra("bannerTitle", bannerList.get(0).getBannerName());
                                getActivity().startActivity(intent);
                            } else if (bannerList.get(0).getBannerStyle().equals("3")) {
                                /**
                                 * 本地模块
                                 */
                                if (bannerList.get(0).getBannerUrl().equals("inviting_users")) {
                                    if (SP.get(getActivity(), SpContent.isLogin, "0").equals("1")) {
                                        Intent intent = new Intent(getActivity(), MineGiftActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                                        intent.putExtra("activite", "no");
                                        startActivity(intent);
                                    }
                                } else if (bannerList.get(0).getBannerUrl().equals("collage")) {
                                    startActivity(new Intent(getContext(), HomeFightaloneActivity.class));
                                } else if (bannerList.get(0).getBannerUrl().equals("specialOfferGoods")) {
                                    startActivity(new Intent(getContext(), SpecialPriceActivity.class));
                                } else if (bannerList.get(0).getBannerUrl().equals("midAutumnFestival-gpActivity")) {
                                    startActivity(new Intent(getContext(), ActivityByHolidayActivity.class));
                                } else if (bannerList.get(0).getBannerUrl().equals("ans_school")) {
                                    startActivity(new Intent(getContext(), BigClassroomActivity.class));
                                } else if (bannerList.get(0).getBannerUrl().equals("second_kill")) {
                                    startActivity(new Intent(getContext(), SecKillActivity.class));
                                }

                            } else {
                                /**
                                 * 2代表获取的是URL    4代表的是店铺   5代表的是推荐商品
                                 */
                                Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                                intent.putExtra("bannerId", bannerList.get(0).getId());
                                intent.putExtra("bannerStyle", bannerList.get(0).getBannerStyle());
                                intent.putExtra("weburl", bannerList.get(0).getBannerUrl());
                                intent.putExtra("bannerLogo", bannerList.get(0).getBannerLogo());
                                intent.putExtra("bannerTitle", bannerList.get(0).getBannerName());
                                getActivity().startActivity(intent);
                            }
                        }
                    });
                }
                break;
            //精选
            case ACTION.TUANDUILISTDATA:
                PinTuanBean pinTuanBean = GsonUtil.toObj(res, PinTuanBean.class);
                if (pinTuanBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (pinTuanBean.isSuccess()) {
                        if (pinTuanBean.getBody().getGroupActivityListData().size() == 0) {
                            T.show("您已加载全部数据");
                        } else {
                            if (mAdapter == null) {
                                mRecyclerFragmentFightaloneservice.setLayoutManager(new LinearLayoutManager(getActivity()));
                                mRecyclerFragmentFightaloneservice.addItemDecoration(new SpaceItemDecoration(getActivity()).setSpace(10).setSpaceColor(0xFFF7F7F7));
                                mAdapter = new HomeFightaloneServiceAdapter(getActivity());
                                mRecyclerFragmentFightaloneservice.setAdapter(mAdapter);
                            }
                            List<PinTuanBean.BodyBean.GroupActivityListDataBean> list = mAdapter.getList();
                            if (pageNumber == 1) {
                                list.clear();
                            }
                            list.addAll(pinTuanBean.getBody().getGroupActivityListData());
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
                break;
            case ACTION.USERINFOLIST:
                UserInfoListBean infoListBean = GsonUtil.toObj(res, UserInfoListBean.class);
                if (infoListBean.isSuccess()) {
                    mFightMarqueeView.setVisibility(View.VISIBLE);
                    List<UserInfoListBean.BodyBean.ListBean> list = infoListBean.getBody().getList();
                    //设置消息滚动
                    ComplexViewFight factory = new ComplexViewFight(getActivity());
                    factory.setData(list);
                    mFightMarqueeView.setMarqueeFactory(factory);
                    mFightMarqueeView.startFlipping();
                    mFightMarqueeView.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClickListener(View view, Object o, int i) {

                        }
                    });
                }else {
                    mFightMarqueeView.setVisibility(View.GONE);
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
