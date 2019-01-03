package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RefundAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.RefundBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 退款
 */

public class RefundFragment extends BaseFragment implements HttpCallBack{
    @Bind(R.id.rc_refund)
    RecyclerView refund;
    private RefundBean refundBean;
    List<RefundBean.BodyBean.ApiRefundListBean> apiRefundList = new ArrayList<>();

    LoadingDialog loadingDialog;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_sort_refund;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());
        inithttp();
    }

    @Override
    protected void doFitsrData() {

    }

    /**
     *  获取退款的列表数据
     */
    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("userId", SP.get(getActivity(), SpContent.UserId,"0")+"");
        hashMap.put("token",SP.get(getActivity(),SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.LIST,hashMap, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            /**
             * 获取退款列表数据
             */
            case ACTION.LIST:
                loadingDialog.cancel();
                refundBean = GsonUtil.toObj(res, RefundBean.class);
                if(refundBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    apiRefundList = refundBean.getBody().getApiRefundList();

                    RefundAdapter sbmitWholeAdapter = new RefundAdapter(getActivity(), R.layout.item_sbmitrecycler, apiRefundList);
                    refund.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
                    refund.setAdapter(sbmitWholeAdapter);
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
