package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.HomeFightaloneFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.HomeFightaloneServiceFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * 作者：linxi on 2018/9/29 09:58
 * 邮箱：707078566@qq.com
 * 用途：拼团Fragment
 */
public class FightgroupFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.tab_home_fightalone)
    TabLayout tabFightalone;
    @Bind(R.id.pager_home_fightalone)
    NoScrollViewPager pagerFightalone;
    List<String> tabList = new ArrayList<>();
    List<Fragment> pagerList = new ArrayList<>();
    @Bind(R.id.fight_return)
    ImageView mFightReturn;
    @Bind(R.id.img_information)
    ImageView mImgInformation;
    @Bind(R.id.fightfight_ll)
    LinearLayout mFightfightLl;
    @Bind(R.id.iv_home_search)
    LinearLayout iv_home_search;
    private HomeIndustryBean mHomeIndustryBean;
    private ViewPager mViewPager;
    private NewsBean newsBean;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_fightgroup;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mFightReturn.setVisibility(View.INVISIBLE);
        iv_home_search.getBackground().setAlpha(125);
    }

    @Override
    protected void doFitsrData() {
        if (SP.get(getActivity(), SpContent.isLogin, "").toString().equals("1")) {
            getNewNewsData();
        }
        getBannerData();
    }

    /**
     * 获取新消息提示
     */
    private void getNewNewsData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETNEWNEWS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取首页的行业分类
     */
    private void getBannerData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("tabType", "2");//type  2代表美业    4代表异业
        params.put("tabFather", "0");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INDUSTRY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            //首页的行业分类
            case ACTION.INDUSTRY:
                mHomeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (mHomeIndustryBean.isSuccess() && mHomeIndustryBean.getErrorCode().equals("0")) {
                    tabList.clear();
                    pagerList.clear();
                    setdata();
                } else {
                    T.show(mHomeIndustryBean.getMsg());
                }
                break;
            /**
             * 获取消息类型，并判断有无新消息
             */
            case ACTION.GETNEWNEWS:
                newsBean = GsonUtil.toObj(res, NewsBean.class);
                if (newsBean.isSuccess()) {
                    for (int i = 0; i < newsBean.getBody().getMessTypeList().size(); i++) {
                        if (newsBean.getBody().getMessTypeList().get(i).getValue().equals("1") || newsBean.getBody().getMessTypeList().get(i).getValue().equals("3") || newsBean.getBody().getMessTypeList().get(i).getValue().equals("5")) {

                            if (newsBean.getBody().getMessTypeList().get(i).getMsgContent().equals("")) {
                            } else {
                                QBadgeView badgeView = new QBadgeView(getActivity());
                                badgeView.bindTarget(mImgInformation);
                                badgeView.setBadgeTextSize(6, false);
                                badgeView.setBadgeText("");
                                badgeView.setBadgeTextColor(this.getResources().getColor(R.color.white));
                                badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
                                badgeView.setBadgeBackgroundColor(this.getResources().getColor(R.color.colorPri));
                                badgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                                    @Override
                                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                                    }
                                });
                            }
                        }
                    }
                } else {
//                    T.show(newsBean.getMsg());
                }
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

    private void setdata() {
        if (mHomeIndustryBean != null) {
            HomeIndustryBean.BodyBean.CategoryListDataBean bean = new HomeIndustryBean.BodyBean.CategoryListDataBean();
            HomeIndustryBean.BodyBean.CategoryListDataBean.EcCategoryBean categoryBean = new HomeIndustryBean.BodyBean.CategoryListDataBean.EcCategoryBean();
            categoryBean.setTabName("精选");
            categoryBean.setId("");
            bean.setEcCategory(categoryBean);
            mHomeIndustryBean.getBody().getCategoryListData().add(0, bean);

            for (int i = 0; i < mHomeIndustryBean.getBody().getCategoryListData().size(); i++) {
                tabList.add(mHomeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                if (i == 0) {
                    pagerList.add(new HomeFightaloneServiceFragment().newInstance());
                } else {
                    pagerList.add(new HomeFightaloneFragment().newInstance(mHomeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getId()));
                }
                tabFightalone.addTab(tabFightalone.newTab().setText(tabList.get(i)));
            }
            if (mViewPager == null) {
                mViewPager = new ViewPager(this.getChildFragmentManager(), pagerList, tabList);
                pagerFightalone.setAdapter(mViewPager);
                pagerFightalone.setScanScroll(true);
                tabFightalone.setupWithViewPager(pagerFightalone);
                tabFightalone.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        TextView title = (TextView) (((LinearLayout) ((LinearLayout) tabFightalone.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
                        title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        if (tab.getPosition() == 0) {
                            mFightfightLl.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.black));
                        } else {
                            mFightfightLl.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.ic_setting_breake));
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        TextView title = (TextView) (((LinearLayout) ((LinearLayout) tabFightalone.getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1));
                        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            } else {
                mViewPager.notifyDataSetChanged();
            }
        }
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

    @OnClick({R.id.iv_home_search, R.id.img_information})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //搜索
            case R.id.iv_home_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("shopCate", "1");
                startActivity(intent);
                break;
            //消息
            case R.id.img_information:
                if (SP.get(getActivity(), SpContent.isLogin, "").toString().equals("1")) {
                    Intent intent1 = new Intent(getActivity(), MessageActivity.class);
                    intent1.putExtra("newsBean", (Serializable) newsBean);
                    startActivity(intent1);
                } else {
                    T.show("请先进行登录");
                    Intent intents = new Intent(getActivity(), LoginActivity.class);
                    intents.putExtra("activite", "no");
                    startActivity(intents);
                }
                break;
            default:
                break;
        }
    }
}
