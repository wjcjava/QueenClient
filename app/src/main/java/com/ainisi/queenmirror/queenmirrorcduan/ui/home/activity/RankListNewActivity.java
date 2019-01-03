package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RankingFirstAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RankingListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ScrollRecyclerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.john.library.PopWindowHome;
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

public class RankListNewActivity extends BaseNewActivity implements HttpCallBack {

    LoadingDialog loadingDialog;
    @Bind(R.id.rv_ranking_top3)
    ScrollRecyclerView rv_ranking_top3;
    @Bind(R.id.rv_ranking_hor)
    ScrollRecyclerView rv_ranking_hor;
    @Bind(R.id.rv_ranking_top4)
    ScrollRecyclerView rv_ranking_top4;
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.or_tab)
    TabLayout or_tab;
    @Bind(R.id.li_rank_screen_bottom)
    LinearLayout li_rank_screen_bottom;
    @Bind(R.id.li_ranking_list_distance)
    LinearLayout li_ranking_list_distance;
    @Bind(R.id.tv_new_distance)
    TextView tv_new_distance;
    @Bind(R.id.rank_refreshLayout)
    SmartRefreshLayout rank_refreshLayout;
    @Bind(R.id.iv_ranklist_top_iamge)
    ImageView iv_ranklist_top_iamge;

    List<RankingListBean.BodyBean.ListBean> listBeans1 = new ArrayList<>();

    RankingFirstAdapter purchaseRedPacketAdapter;
    RankingFirstAdapter purchaseRedPacketAdapters;

    String categoryId, cateName, rankingType = "关注榜", distance, shopFeature = "", discountActivity = "";
    int pageNumber = 1, pageIndex = 0;

    boolean isSearch = false;
    private boolean istabchange = false;
    private View mCustomView;
    private PopWindowHome mPopWindowHome;
    String tabPic;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rank_list_new;
    }

    @Override
    protected void initView() {
        super.initView();
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        cateName = intent.getStringExtra("cateName");
        title_title.setText(cateName);
        categoryId = intent.getStringExtra("categoryId");
        tabPic = intent.getStringExtra("tabPic");

        Glide.with(this).load(tabPic).dontAnimate().into(iv_ranklist_top_iamge);


        or_tab.addTab(or_tab.newTab().setText("关注榜"));
        or_tab.addTab(or_tab.newTab().setText("收藏榜"));
        or_tab.addTab(or_tab.newTab().setText("口碑榜"));
        or_tab.addTab(or_tab.newTab().setText("环境榜"));
        or_tab.addTab(or_tab.newTab().setText("技师榜"));
        or_tab.addTab(or_tab.newTab().setText("销售榜"));

        getListData();
        getTuijianData();

        or_tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                rankingType = tab.getText().toString();
                istabchange = true;
                pageNumber = 1;
                getListData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        rank_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                getListData();
                refreshlayout.finishRefresh(1000);
            }
        });
        rank_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                pageNumber++;
                getListData();
                refreshlayout.finishLoadmore(1000);
            }
        });
    }

    /**
     * 获取排行榜数据
     */
    private void getListData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("cityCode", SP.get(this, SpContent.CityCode, "") + "");
        params.put("categoryId", categoryId);//    美业/异业具体的分类 id
        params.put("geoX", SP.get(this, SpContent.UserLon, "") + "");
        params.put("geoY", SP.get(this, SpContent.UserLat, "") + "");
        params.put("pageNumber", pageNumber + "");
        params.put("pageSize", SpContent.pageSize);
        params.put("rankingType", rankingType);
        params.put("shopFeature", shopFeature);//筛选条件1
        params.put("discountActivity", discountActivity);//筛选条件2
        params.put("distance", distance);//距离
        HttpUtils.doPost(ACTION.GETRANKINGLISTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取推荐好店的数据
     */
    private void getTuijianData() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", categoryId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("cityCode", SP.get(this, SpContent.CityCode, "0512") + "");
        hashMap.put("shopCate", "1");
        hashMap.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back, R.id.li_rank_screen_bottom, R.id.li_ranking_list_distance})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.li_rank_screen_bottom:
                /**
                 * 筛选
                 */
                if (mCustomView == null)
                    mCustomView = View.inflate(RankListNewActivity.this, R.layout.pop_screening, null);
                //show里面的内容是显示在空间下方的控件
                if (mPopWindowHome == null) {
                    mPopWindowHome = new PopWindowHome.Builder(RankListNewActivity.this)
                            .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                            .setView(mCustomView)
                            .show(li_rank_screen_bottom);
                } else {
                    mPopWindowHome.setStyle(PopWindowHome.PopWindowStyle.PopDown);
                    mPopWindowHome.show(li_rank_screen_bottom);
                }
                TextView tv_cancel = mCustomView.findViewById(R.id.tv_cancel);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPopWindowHome.dismiss();
                    }
                });
                TextView tv_submit = mCustomView.findViewById(R.id.tv_submit);
                tv_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPopWindowHome.dismiss();

                        isSearch = true;
                        pageNumber = 1;
                        getListData();
                    }
                });

                final TextView tv_home_queen = mCustomView.findViewById(R.id.tv_home_queen);
                final TextView tv_home_new = mCustomView.findViewById(R.id.tv_home_new);
                tv_home_queen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_queen.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_queen.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));

                        tv_home_new.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_new.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));
                        shopFeature = "1";
                    }
                });


                tv_home_new.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_queen.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_queen.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_new.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_new.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));
                        shopFeature = "2";
                    }
                });

                final TextView tv_home_first = mCustomView.findViewById(R.id.tv_home_first);
                final TextView tv_home_second = mCustomView.findViewById(R.id.tv_home_second);
                final TextView tv_home_third = mCustomView.findViewById(R.id.tv_home_third);
                final TextView tv_home_forth = mCustomView.findViewById(R.id.tv_home_forth);

                tv_home_first.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_first.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));

                        tv_home_second.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        discountActivity = "1";
                    }
                });
                tv_home_second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_second.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_second.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));

                        tv_home_third.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));
                        discountActivity = "2";
                    }
                });
                tv_home_third.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_second.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_third.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));

                        tv_home_forth.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_forth.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));
                        discountActivity = "3";

                    }
                });
                tv_home_forth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_home_first.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_first.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_second.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_second.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_third.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese));
                        tv_home_third.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.alpha_65_black));

                        tv_home_forth.setBackground(RankListNewActivity.this.getDrawable(R.drawable.button_home_tese_select));
                        tv_home_forth.setTextColor(RankListNewActivity.this.getResources().getColor(R.color.white));
                        discountActivity = "4";

                    }
                });
                break;
            case R.id.li_ranking_list_distance:
                /**
                 * 范围
                 */
                View customView1 = View.inflate(RankListNewActivity.this, R.layout.layout_rank_list, null);
                final PopWindowHome popWindowHome1 = new PopWindowHome.Builder(RankListNewActivity.this)
                        .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                        .setView(customView1)
                        .show(li_ranking_list_distance);//show里面的内容是显示在空间下方的控件

                TextView tv_rank_all = customView1.findViewById(R.id.tv_rank_all);
                tv_rank_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        distance = "";
                        tv_new_distance.setText("全部");
                        popWindowHome1.dismiss();
                        isSearch = true;
                        rank_refreshLayout.autoRefresh();
                    }
                });

                TextView tv_rank_three = customView1.findViewById(R.id.tv_rank_three);
                tv_rank_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        distance = "3";
                        tv_new_distance.setText("3KM");
                        popWindowHome1.dismiss();
                        isSearch = true;
                        pageNumber = 1;
                        getListData();
                    }
                });

                TextView tv_rank_five = customView1.findViewById(R.id.tv_rank_five);
                tv_rank_five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        distance = "5";
                        tv_new_distance.setText("5KM");
                        popWindowHome1.dismiss();
                        isSearch = true;
                        pageNumber = 1;
                        getListData();
                    }
                });


                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.GETRANKINGLISTDATA:
                loadingDialog.cancel();
                RankingListBean rankingListBean = GsonUtil.toObj(res, RankingListBean.class);
                if (rankingListBean.isSuccess()) {
                    loadMoreData(rankingListBean.getBody().getList());
                } else {
                    T.show(rankingListBean.getMsg());
                }
                break;

            /**
             * 推荐好店
             */
            case ACTION.MERCHANTSLIST:
                final EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                if (estheticsBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(RankListNewActivity.this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (estheticsBean.isSuccess()) {
                        if (estheticsBean.getBody().getShopList().size() > 0) {
                            EstheticsBean.BodyBean.ShopListBean bean = new EstheticsBean.BodyBean.ShopListBean();
                            estheticsBean.getBody().getShopList().add(bean);
                        }
                        EstheticsAdapter sortAdapter = new EstheticsAdapter(RankListNewActivity.this, R.layout.item_recycler_waterfalls, estheticsBean.getBody().getShopList());
                        rv_ranking_hor.setLayoutManager(new LinearLayoutManager(RankListNewActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        rv_ranking_hor.setAdapter(sortAdapter);

                        rv_ranking_hor.setNestedScrollingEnabled(false);

                        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                if (position != estheticsBean.getBody().getShopList().size() - 1) {
                                    Intent intent = new Intent(RankListNewActivity.this, WorkRoomDetailActivity.class);
                                    intent.putExtra("shopName", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getShopName());
                                    intent.putExtra("shopId", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getId());
                                    intent.putExtra("cpCate", "1");
                                    startActivity(intent);
                                } else {
                                    Intent intent1 = new Intent(RankListNewActivity.this, RecommendedActivity.class);
                                    intent1.putExtra("categoryId", categoryId);
                                    startActivity(intent1);
                                }
                            }
                        });
                    } else {
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


    public void loadMoreData(final List<RankingListBean.BodyBean.ListBean> apiOrderListMore) {
        if (pageNumber == 1 || istabchange == true) {
            if (apiOrderListMore.size() > 3) {
                purchaseRedPacketAdapter = new RankingFirstAdapter(RankListNewActivity.this, R.layout.layout_ranking_list_item, apiOrderListMore.subList(0, 3), "true", rankingType);
            } else {
                purchaseRedPacketAdapter = new RankingFirstAdapter(RankListNewActivity.this, R.layout.layout_ranking_list_item, apiOrderListMore, "true", rankingType);
            }
            rv_ranking_top3.setLayoutManager(new LinearLayoutManager(RankListNewActivity.this, LinearLayoutManager.VERTICAL, false));
            rv_ranking_top3.setAdapter(purchaseRedPacketAdapter);
            rv_ranking_top3.setNestedScrollingEnabled(false);
            purchaseRedPacketAdapter.notifyDataSetChanged();
            purchaseRedPacketAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(RankListNewActivity.this, WorkRoomDetailActivity.class);
                    intent.putExtra("shopName", purchaseRedPacketAdapter.getItem(position).getShopName());
                    intent.putExtra("shopId", purchaseRedPacketAdapter.getItem(position).getShopId());
                    intent.putExtra("cpCate", "1");
                    startActivity(intent);
                }
            });

        }
        if (pageNumber == 1 || istabchange == true) {
            listBeans1.clear();
            if (apiOrderListMore.size() > 3)
                listBeans1.addAll(apiOrderListMore.subList(3, apiOrderListMore.size()));
        } else {
            listBeans1.addAll(apiOrderListMore);
        }
        purchaseRedPacketAdapters = new RankingFirstAdapter(RankListNewActivity.this, R.layout.layout_ranking_list_item, listBeans1, "false", rankingType);
        rv_ranking_top4.setLayoutManager(new LinearLayoutManager(RankListNewActivity.this, LinearLayoutManager.VERTICAL, false));
        rv_ranking_top4.setAdapter(purchaseRedPacketAdapters);
        rv_ranking_top4.setNestedScrollingEnabled(false);
        purchaseRedPacketAdapters.notifyDataSetChanged();
        purchaseRedPacketAdapters.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(RankListNewActivity.this, WorkRoomDetailActivity.class);
                intent.putExtra("shopName", listBeans1.get(position).getShopName());
                intent.putExtra("shopId", listBeans1.get(position).getShopId());
                intent.putExtra("cpCate", "1");
                startActivity(intent);
            }
        });
        istabchange = false;
    }

}
