package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SortGvOneAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SortLvAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SortItemFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.NoAnimationViewPager;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/9/17 10:21
 * 邮箱：707078566@qq.com
 * 用途：分类
 */
public class SortActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView mTitleTitle;
    @Bind(R.id.sort_lv)
    ListView mSortLv;
    @Bind(R.id.sort_popularity)
    ImageView mSortPopularity;
    @Bind(R.id.sort_hot)
    ImageView mSortHot;
    @Bind(R.id.sort_good)
    ImageView mSortGood;
    @Bind(R.id.sort_gv1)
    NoScrollGridView mSortGv1;
    @Bind(R.id.ll_top1)
    ScrollView mLlTop1;
    @Bind(R.id.sort_vp)
    NoAnimationViewPager mSortVp;
    private SortLvAdapter mLvAdapter;
    private SortGvOneAdapter mOneAdapter;
    private HomeIndustryBean homeIndustryBean;
    private List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> mApiEcGoodsBasicList;
    private List<Fragment> tabFragments = new ArrayList<>();
    private List<String> lv_Lists = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sort;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleTitle.setText(getString(R.string.sort_title));
    }

    @Override
    protected void initData() {
        super.initData();
        initshophttp();
        homeIndustryBean = (HomeIndustryBean) getIntent().getSerializableExtra("homeIndustryBean");
        HomeIndustryBean.BodyBean.CategoryListDataBean bean = new HomeIndustryBean.BodyBean.CategoryListDataBean();
        HomeIndustryBean.BodyBean.CategoryListDataBean.EcCategoryBean bean1 = new HomeIndustryBean.BodyBean.CategoryListDataBean.EcCategoryBean();
        bean1.setTabName("为你推荐");
        bean.setEcCategory(bean1);
        homeIndustryBean.getBody().getCategoryListData().add(0, bean);
        if (mLvAdapter == null) {
            mLvAdapter = new SortLvAdapter(this, homeIndustryBean);
            mSortLv.setAdapter(mLvAdapter);
        }
        for (int i = 1; i < homeIndustryBean.getBody().getCategoryListData().size(); i++) {
            lv_Lists.add(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
            tabFragments.add(new SortItemFragment().newInstance(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getId()));
        }
        ViewPager viewPager = new ViewPager(getSupportFragmentManager(), tabFragments, lv_Lists);
        mSortVp.setAdapter(viewPager);
        mSortLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mLvAdapter.setposition(i);
                mLvAdapter.notifyDataSetChanged();
                if (i == 0) {
                    mLlTop1.setVisibility(View.VISIBLE);
                    mSortVp.setVisibility(View.GONE);
                } else {
                    mLlTop1.setVisibility(View.GONE);
                    mSortVp.setVisibility(View.VISIBLE);
                    mSortVp.setCurrentItem(i - 1);
                }
            }
        });
    }

    @OnClick({R.id.title_back, R.id.sort_popularity, R.id.sort_hot, R.id.sort_good})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //人气榜
            case R.id.sort_popularity:
                intent = new Intent(this, SortItemActivity.class);
                intent.putExtra("homeIndustryBean", homeIndustryBean);
                intent.putExtra("sortitem_title", "人气榜");
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            //热销榜
            case R.id.sort_hot:
                intent = new Intent(this, SortItemActivity.class);
                intent.putExtra("homeIndustryBean", homeIndustryBean);
                intent.putExtra("sortitem_title", "热销榜");
                intent.putExtra("type", "2");
                startActivity(intent);
                break;
            //好评榜
            case R.id.sort_good:
                intent = new Intent(this, SortItemActivity.class);
                intent.putExtra("homeIndustryBean", homeIndustryBean);
                intent.putExtra("sortitem_title", "好评榜");
                intent.putExtra("type", "3");
                startActivity(intent);
                break;
        }
    }

    /**
     * 商家推荐商品的数据
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", "1");
        hashMap1.put("cityCode", (String) SP.get(this, SpContent.CityCode, "0512"));//shopId  111
        hashMap1.put("pageSize", "6");
        hashMap1.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.COMMENDGOODS:
                CommendGoodBean goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.isSuccess()) {
                    mApiEcGoodsBasicList = goodBean.getBody().getApiEcGoodsBasicList();
                    if (mOneAdapter == null) {
                        mOneAdapter = new SortGvOneAdapter(this, mApiEcGoodsBasicList);
                        mSortGv1.setAdapter(mOneAdapter);
                    }
                    mSortGv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(SortActivity.this, FullActivity.class);
                            intent.putExtra("goodsId", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getId());
                            intent.putExtra("shopId", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getShopId());
                            intent.putExtra("shopName", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getShopName());
                            intent.putExtra("shopLogo", mApiEcGoodsBasicList.get(i).getEcGoodsBasic().getGoodsThumb());
                            intent.putExtra("number", "");
                            startActivity(intent);
                        }
                    });
                } else {
                    T.show(goodBean.getMsg());
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
