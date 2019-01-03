package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SortGvTwoAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsScreenBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.example.john.library.PopWindowHome;
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
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/9/21 09:25
 * 邮箱：707078566@qq.com
 * 用途：分类Fragment
 */
public class SortItemFragment extends BaseFragment implements HttpCallBack, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.sort_screen)
    TextView mSortScreen;
    @Bind(R.id.sort_bt_screen)
    RadioButton mSortBtScreen;
    @Bind(R.id.sort_distance_tv)
    TextView mSortDistanceTv;
    @Bind(R.id.sort_distance_img)
    ImageView mSortDistanceImg;
    @Bind(R.id.sort_gv2)
    GridView mSortGv2;
    @Bind(R.id.sort_refreshLayout)
    SmartRefreshLayout mSortRefreshLayout;
    @Bind(R.id.sort_ll)
    LinearLayout mSortLl;

    private SortGvTwoAdapter mAdapter;
    private int pageNumber = 1;
    private int pageSize = 20;
    private String goodsCate;
    private String distanceScope = "";
    private String shopFeatures = "";
    private String condition = "";
    private View mInflate;
    private PopWindowHome mPopWindowHome;
    private View mCustomView1;
    private PopWindowHome mPopWindowHome1;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_item;
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
        }
        goodsScreening();
    }

    @OnClick({R.id.sort_screen_bottom, R.id.sort_distance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //筛选
            case R.id.sort_screen_bottom:
                sort_screen_bottom();
                break;
            //范围
            case R.id.sort_distance:
                sort_distance();
                break;
        }
    }

    private void goodsScreening() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", String.valueOf(pageNumber));
        parames.put("pageSize", String.valueOf(pageSize));
        parames.put("goodsCate", goodsCate);
        parames.put("shopFeatures", shopFeatures);
        parames.put("condition", condition);
        parames.put("distanceScope", distanceScope);
        parames.put("geoX", (String) SP.get(getActivity(), SpContent.UserLon, ""));
        parames.put("geoY", (String) SP.get(getActivity(), SpContent.UserLat, ""));
        parames.put("belongCity", (String) SP.get(getActivity(), SpContent.CityCode, "0512"));
        HttpUtils.doPost(ACTION.GOODSSCREENING, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.GOODSSCREENING:
                GoodsScreenBean goodsRanking = GsonUtil.toObj(res, GoodsScreenBean.class);
                if (goodsRanking.isSuccess() && goodsRanking.getErrorCode().equals("0")) {
                    if (mAdapter == null) {
                        mAdapter = new SortGvTwoAdapter(getActivity());
                        mSortGv2.setAdapter(mAdapter);
                    }
                    final List<GoodsScreenBean.BodyBean.GoodsScreeningBean> list = mAdapter.getList();
                    if (pageNumber == 1) {
                        list.clear();
                    }
                    list.addAll(goodsRanking.getBody().getGoodsScreening());
                    mAdapter.notifyDataSetChanged();
                    if (list.size() > 0) {
                        mSortGv2.setVisibility(View.VISIBLE);
                    } else {
                        mSortGv2.setVisibility(View.GONE);
                    }
                    mSortGv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(getActivity(), FullActivity.class);
                            intent.putExtra("goodsId", list.get(i).getId());
                            intent.putExtra("shopId", list.get(i).getShopId());
                            intent.putExtra("shopName", list.get(i).getShopName());
                            intent.putExtra("shopLogo", list.get(i).getGoodsThumb());
                            intent.putExtra("number", "");
                            startActivity(intent);
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

    public SortItemFragment newInstance(String goodsCate) {
        Bundle bundle = new Bundle();
        bundle.putString("goodsCate", goodsCate);
        SortItemFragment testFm = new SortItemFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        pageNumber = 1;
        goodsScreening();
        mSortRefreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshLayout) {
        pageNumber++;
        goodsScreening();
        mSortRefreshLayout.finishLoadmore();
    }

    private void sort_screen_bottom() {
        if (mInflate == null)
            mInflate = View.inflate(getActivity(), R.layout.pop_screening, null);
        //show里面的内容是显示在空间下方的控件
        if (mPopWindowHome == null) {
            mPopWindowHome = new PopWindowHome.Builder(getActivity())
                    .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                    .setView(mInflate)
                    .show(mSortLl);
        } else {
            mPopWindowHome.setStyle(PopWindowHome.PopWindowStyle.PopDown);
            mPopWindowHome.show(mSortLl);
        }
        TextView tv_cancel = mInflate.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindowHome.dismiss();
            }
        });
        TextView tv_submit = mInflate.findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindowHome.dismiss();
                mSortRefreshLayout.autoRefresh();
            }
        });

        final TextView tv_home_queen = mInflate.findViewById(R.id.tv_home_queen);
        final TextView tv_home_new = mInflate.findViewById(R.id.tv_home_new);
        tv_home_queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_queen.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_queen.setTextColor(getActivity().getResources().getColor(R.color.white));

                tv_home_new.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_new.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                shopFeatures = "1";
            }
        });


        tv_home_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_queen.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_queen.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_new.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_new.setTextColor(getActivity().getResources().getColor(R.color.white));
                shopFeatures = "2";
            }
        });

        final TextView tv_home_first = mInflate.findViewById(R.id.tv_home_first);
        final TextView tv_home_second = mInflate.findViewById(R.id.tv_home_second);
        final TextView tv_home_third = mInflate.findViewById(R.id.tv_home_third);
        final TextView tv_home_forth = mInflate.findViewById(R.id.tv_home_forth);

        tv_home_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.white));

                tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                condition = "1";
            }
        });
        tv_home_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.white));

                tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                condition = "2";
            }
        });
        tv_home_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.white));

                tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));
                condition = "3";

            }
        });
        tv_home_forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_home_first.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_first.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_second.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_second.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_third.setBackground(getActivity().getDrawable(R.drawable.button_home_tese));
                tv_home_third.setTextColor(getActivity().getResources().getColor(R.color.alpha_65_black));

                tv_home_forth.setBackground(getActivity().getDrawable(R.drawable.button_home_tese_select));
                tv_home_forth.setTextColor(getActivity().getResources().getColor(R.color.white));
                condition = "4";

            }
        });
    }

    private void sort_distance() {
        if (mCustomView1 == null)
            mCustomView1 = View.inflate(getActivity(), R.layout.layout_rank_list, null);
        //show里面的内容是显示在空间下方的控件
        if (mPopWindowHome1 == null) {
            mPopWindowHome1 = new PopWindowHome.Builder(getActivity())
                    .setStyle(PopWindowHome.PopWindowStyle.PopDown)
                    .setView(mCustomView1)
                    .show(mSortLl);
        } else {
            mPopWindowHome1.setStyle(PopWindowHome.PopWindowStyle.PopDown);
            mPopWindowHome1.show(mSortLl);
        }
        TextView tv_rank_all = mCustomView1.findViewById(R.id.tv_rank_all);
        tv_rank_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distanceScope = "";
                mSortDistanceTv.setText("全城");
                mPopWindowHome1.dismiss();
                mSortRefreshLayout.autoRefresh();
            }
        });

        TextView tv_rank_three = mCustomView1.findViewById(R.id.tv_rank_three);
        tv_rank_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distanceScope = "3";
                mSortDistanceTv.setText("3KM");
                mPopWindowHome1.dismiss();
                mSortRefreshLayout.autoRefresh();
            }
        });

        TextView tv_rank_five = mCustomView1.findViewById(R.id.tv_rank_five);
        tv_rank_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                distanceScope = "5";
                mSortDistanceTv.setText("5KM");
                mPopWindowHome1.dismiss();
                mSortRefreshLayout.autoRefresh();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mInflate = null;
        mCustomView1 = null;
        if (mPopWindowHome != null) {
            mPopWindowHome.dismiss();
        }
        if (mPopWindowHome1 != null) {
            mPopWindowHome1.dismiss();
        }
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
