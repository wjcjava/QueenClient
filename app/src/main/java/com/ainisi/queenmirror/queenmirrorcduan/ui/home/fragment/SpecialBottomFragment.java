package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SpecialAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SpecialBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by john on 2018/9/4.
 * <p>
 * jl
 */

public class SpecialBottomFragment extends BaseFragment implements HttpCallBack {
    private String position;

    @Bind(R.id.gv_special_gridView)
    NoScrollGridView gv_special_gridView;

    int pageNumber = 1, pageIndex = 0, pageSum = 0;

    List<SpecialBean.BodyBean.SpecialOfferGoodsListBean> commentList = new ArrayList<>();
    private SpecialAdapter specialAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.mine_special_record;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        position = getArguments().getString("position");

        specialAdapter = new SpecialAdapter(getActivity(), commentList);
        gv_special_gridView.setAdapter(specialAdapter);
    }

    @Override
    protected void doFitsrData() {
        getMineRePacketData();
    }

    /**
     * 获取我的红包记录
     */
    private void getMineRePacketData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber + "");
        parames.put("pageSize", "10000");
        parames.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        parames.put("goodsCate", position + "");
        parames.put("belongCity", SP.get(getActivity(), SpContent.CityCode, "0512") + "");
        HttpUtils.doPost(ACTION.SPECIALLISTITEM, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.SPECIALLISTITEM:
                SpecialBean specialBean = GsonUtil.toObj(res, SpecialBean.class);
                if (specialBean.isSuccess() && specialBean.getErrorCode().equals("0")) {
                    pageSum = specialBean.getBody().getPageSum();


                    loadMoreData(specialBean.getBody().getSpecialOfferGoodsList());

                   /* specialAdapter = new SpecialAdapter(getActivity());
                    gv_special_gridView.setAdapter(specialAdapter);
                    specialAdapter.Clear();

                    specialAdapter.setmDate(specialBean.getBody().getSpecialOfferGoodsList());*/
                } else {
                    T.show(specialBean.getMsg());
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

    public void loadMoreData(List<SpecialBean.BodyBean.SpecialOfferGoodsListBean> apiOrderListMore) {

        if (commentList == null) {
            commentList = new ArrayList<>();
        }
        if (pageIndex == 0) {
            specialAdapter.Clear();
        }
        commentList.addAll(apiOrderListMore);
        if (pageIndex == 0) {
            specialAdapter.setmDate(commentList);
        } else {
            specialAdapter.notifyDataSetChanged();
        }
    }

}
