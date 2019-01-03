package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.DiscountAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.ItemCouponsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * Created by EWorld on 2018/3/6.
 * 历史优惠券
 */

public class HistorydiscountFragment extends BaseFragment implements  HttpCallBack {
    @Bind(R.id.re_distance)
    RecyclerView disrecycler;
    @Bind(R.id.re_itemcoupons)
    RecyclerView itemCoupons;

    @Bind(R.id.tv_history_usuall_null)
    TextView tv_history_usuall_null;

    @Bind(R.id.tv_history_singal_null)
    TextView tv_history_singal_null;
    private Handler handler = new Handler();
    private int position;
    private ReceiveDiscounBean receiveBean;
    private List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> discountList;
    private List<ReceiveDiscounBean.BodyBean.CustCouponListDataItemBean> discountList_single;

    LoadingDialog loadingDialog;
    String cpCate="1";

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_history_mine;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    protected void initView() {
        loadingDialog = new LoadingDialog(getActivity());
        position = getArguments().getInt("position");
        cpCate = getArguments().getString("cpCate");

        disrecycler.setHasFixedSize(true);
        disrecycler.setNestedScrollingEnabled(false);
        itemCoupons.setHasFixedSize(true);
        itemCoupons.setNestedScrollingEnabled(false);
        getReceiveDiscoun();

    }

    @Override
    protected void doFitsrData() {

    }

    private void getReceiveDiscoun() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId,"0")+"");//用户ID
        params.put("cpStatus", position + "");
        params.put("token",SP.get(getActivity(),SpContent.UserToken,"0")+"");
        params.put("cpCate",cpCate);
        HttpUtils.doPost(ACTION.RECEIVEDISCOUN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.RECEIVEDISCOUN:
                loadingDialog.cancel();
                receiveBean = GsonUtil.toObj(res, ReceiveDiscounBean.class);
                if(receiveBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (receiveBean.isSuccess()) {
                        discountList = receiveBean.getBody().getCustCouponListData();

                        if (discountList.size() == 0) {
                            tv_history_usuall_null.setVisibility(View.VISIBLE);
                        } else {
                            tv_history_usuall_null.setVisibility(View.INVISIBLE);
                            DiscountAdapter sortAdapter = new DiscountAdapter(R.layout.item_discount, discountList, position);
                            disrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            disrecycler.setAdapter(sortAdapter);
                        }
                        discountList_single = receiveBean.getBody().getCustCouponListDataItem();

                        if (discountList_single.size() == 0) {
                            tv_history_singal_null.setVisibility(View.VISIBLE);
                        } else {
                            tv_history_singal_null.setVisibility(View.INVISIBLE);
                            ItemCouponsAdapter couponsAdapter = new ItemCouponsAdapter(R.layout.item_itemcount, discountList_single, 1, "", position + "","false");
                            itemCoupons.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            itemCoupons.setAdapter(couponsAdapter);
                        }
                    } else {
                        T.show(receiveBean.getMsg());
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
