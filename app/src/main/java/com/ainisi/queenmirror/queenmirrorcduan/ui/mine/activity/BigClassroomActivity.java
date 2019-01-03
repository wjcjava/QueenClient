package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.TabContentFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GsonUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.SelectorUtil;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 大课堂
 *
 * @author jiangchao
 *         created at 2018/9/3 下午1:08
 */
public class BigClassroomActivity extends BaseNewActivity implements HttpCallBack {

    private static final String TAG = "BigClassroomActivity";
    @Bind(R.id.title_title)
    TextView commentTitle;

    @Bind(R.id.tl_tab)
    TabLayout mTabTl;
    @Bind(R.id.vp_content)
    ViewPager mContentVp;

    private List<String> tabIndicators;

    List<String> majorIds = new ArrayList<>();

    private List<String> majorIcon;
    private List<String> majorIconSelect;

    private List<Integer> imgRes;

    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_classroom;
    }


    @Override
    protected void initData() {
        super.initData();
        commentTitle.setText("艾尼斯大课堂");
        tabIndicators = new ArrayList<>();
        imgRes = new ArrayList<>();
        majorIcon = new ArrayList<>();
        majorIconSelect = new ArrayList<>();
        getData();

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        HttpUtils.doPost(ACTION.MAJOR_LIST, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void initTab() {
        mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabTl.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(mTabTl, 10);
        mTabTl.setupWithViewPager(mContentVp);
        for (int i = 0; i < tabIndicators.size(); i++) {
            TabLayout.Tab itemTab = mTabTl.getTabAt(i);
            if (itemTab != null) {
                itemTab.setCustomView(R.layout.item_tab_layout_custom);
                TextView itemTv = itemTab.getCustomView().findViewById(R.id.tv_menu_item);
                itemTv.setText(tabIndicators.get(i));
                ImageView itemIv = itemTab.getCustomView().findViewById(R.id.iv_menu_icon);

                SelectorUtil.addSeletorFromNet(BigClassroomActivity.class,majorIcon.get(i),majorIconSelect.get(i),itemIv);
//                imgRes.add();
//                itemIv.setBackgroundResource(imgRes.get(i));

            }
        }
        mTabTl.getTabAt(0).getCustomView().setSelected(true);
    }

    private void initContent() {

//        tabIndicators.add("待上架");
//        tabIndicators.add("审核中");
//        tabIndicators.add("已上架");
//        tabIndicators.add("已下架");

//        imgRes.add(R.drawable.selector_bottom_tab_home);
//        imgRes.add(R.drawable.selector_bottom_tab_shop_mall);
//        imgRes.add(R.drawable.selector_bottom_tab_order);
//        imgRes.add(R.drawable.selector_bottom_tab_master);


        tabFragments = new ArrayList<>();


        for (String s : majorIds) {
            tabFragments.add(TabContentFragment.newInstance(s));

        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.MAJOR_LIST:
//                ShopGoodsListModel shopGoodsListModel = GsonUtils.jsonToBean(res, ShopGoodsListModel.class);
//                if (shopGoodsListModel.isSuccess()) {
//                    //得到总页数，上拉加载更多的时候用于判断还有没有更多数据
//                    //这里的PageSum是总数量，后台名字起错了
//                    totalPage = (shopGoodsListModel.getBody().getPageSum() / pageSize);
//                    //得到数据
//                    goodsListEntities = shopGoodsListModel.getBody().getApiEcGoodsBasicList();
//                    if (goodsListEntities.size() == 0) {
//                        hasData(true);
//                    } else {
//                        hasData(false);
//                    }
//                    showData();
//                }


                MajorListBean majorListBean = GsonUtils.jsonToBean(res, MajorListBean.class);
                if (majorListBean.isSuccess()) {
                    for (int i = 0; i < majorListBean.getBody().getMajorList().size(); i++) {
                        tabIndicators.add(majorListBean.getBody().getMajorList().get(i).getMajorName());
                        majorIcon.add(majorListBean.getBody().getMajorList().get(i).getMajorIcon());
                        majorIconSelect.add(majorListBean.getBody().getMajorList().get(i).getMajorIconSelect());
                        majorIds.add(majorListBean.getBody().getMajorList().get(i).getId());
//                                imgRes.add(R.drawable.selector_bottom_tab_home);
//

                    }
                }
                Log.i(TAG, res);
                initContent();
                initTab();
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

    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }
    }
}
