package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2018/9/19.
 *
 * jl
 */

public class RankingListBottomFragment extends BaseFragment implements HttpCallBack {

    @Bind(R.id.rv_ranking_top3)
    ScrollRecyclerView rv_ranking_top3;
    @Bind(R.id.rv_ranking_hor)
    ScrollRecyclerView rv_ranking_hor;
    @Bind(R.id.rv_ranking_top4)
    ScrollRecyclerView rv_ranking_top4;

    int pageNumber=1;
    String rankingType;
    public String categoryId;
    String str;

    List<RankingListBean.BodyBean.ListBean> listBeans = new ArrayList<>();
    List<RankingListBean.BodyBean.ListBean> listBeans1 = new ArrayList<>();

    LoadingDialog loadingDialog;

    public RankingListBottomFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);
        RankingListBottomFragment testFm = new RankingListBottomFragment();
        testFm.setArguments(bundle);
        return testFm;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.layout_rankinglist_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());
    }

    @Override
    protected void doFitsrData() {
        getListData();

        getTuijianData();
    }

    /**
     * 获取排行榜数据
     */
    private void getListData() {
        loadingDialog.loadShow();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            str = bundle.getString("state");
        }
        String strs[] = str.split("@");
        categoryId = strs[1];
        rankingType = strs[0];
        HashMap<String, String> params= new HashMap<>();
        params.put("cityCode",  SP.get(getActivity(), SpContent.CityCode,"")+"");
        params.put("categoryId", strs[1]);//    美业/异业具体的分类 id
        params.put("geoX", SP.get(getActivity(), SpContent.UserLon,"")+"");
        params.put("geoY", SP.get(getActivity(), SpContent.UserLat,"")+"");
        params.put("pageNumber", pageNumber+"");
        params.put("pageSize",SpContent.pageSize);
        params.put("rankingType", rankingType);
        params.put("shopFeature", "");//筛选条件1
        params.put("discountActivity","");//筛选条件2
        params.put("distance","");//距离
        HttpUtils.doPost(ACTION.GETRANKINGLISTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    /**
     * 获取推荐好店的数据
     */
    private void getTuijianData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            str = bundle.getString("state");
        }
        String strs[] = str.split("@");
        categoryId = strs[1];
        rankingType = strs[0];

        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", categoryId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("cityCode",SP.get(getActivity(),SpContent.CityCode,"0512")+"");
        hashMap.put("shopCate", "1");
        hashMap.put("token",SP.get(getActivity(),SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETRANKINGLISTDATA:
                loadingDialog.cancel();

                RankingListBean rankingListBean = GsonUtil.toObj(res,RankingListBean.class);
                if(rankingListBean.isSuccess()&&rankingListBean.getErrorCode().equals("0")){

                  /*  if(rankingListBean.getBody().getList().size()>3){
                        listBeans = rankingListBean.getBody().getList();
                        listBeans1 = rankingListBean.getBody().getList();

                        for (int i = 0; i < listBeans.size()-3; i++) {
                            listBeans.remove(listBeans.size()-1);
                        }

                        RankingFirstAdapter purchaseRedPacketAdapter = new RankingFirstAdapter(getActivity(),R.layout.layout_ranking_list_item, listBeans,"true",rankingType);
                        rv_ranking_top3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                        rv_ranking_top3.setAdapter(purchaseRedPacketAdapter);


                        for (int i = 0; i < 3; i++) {
                            listBeans1.remove(0);
                        }
                        RankingFirstAdapter purchaseRedPacketAdapters = new RankingFirstAdapter(getActivity(),R.layout.layout_ranking_list_item, listBeans1,"false",rankingType);
                        rv_ranking_top4.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                        rv_ranking_top4.setAdapter(purchaseRedPacketAdapters);
                    }else{
                        listBeans = rankingListBean.getBody().getList();

                        RankingFirstAdapter purchaseRedPacketAdapter = new RankingFirstAdapter(getActivity(),R.layout.purchase_red_packet_list_item, listBeans,"true",rankingType);
                        rv_ranking_top3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                        rv_ranking_top3.setAdapter(purchaseRedPacketAdapter);
                    }
*/
                }else {
                    T.show(rankingListBean.getMsg());
                }
                break;

            /**
             * 推荐好店
             */
            case ACTION.MERCHANTSLIST:
                final EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                if(estheticsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (estheticsBean.isSuccess()) {

                        EstheticsAdapter sortAdapter = new EstheticsAdapter(getActivity(), R.layout.item_recycler_waterfalls, estheticsBean.getBody().getShopList());
                        rv_ranking_hor.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        rv_ranking_hor.setAdapter(sortAdapter);

                        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                Intent intent = new Intent(getActivity(), WorkRoomDetailActivity.class);
                                intent.putExtra("shopName", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getShopName());
                                intent.putExtra("shopId", estheticsBean.getBody().getShopList().get(position).getAnsShopBasic().getId());
                                intent.putExtra("cpCate", "1");
                                startActivity(intent);
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
}
