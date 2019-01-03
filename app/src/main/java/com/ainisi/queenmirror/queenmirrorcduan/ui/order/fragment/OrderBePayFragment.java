package com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderPayAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;

/**
 * Created by john on 2018/8/26.
 * <p>
 * 待支付
 */

public class OrderBePayFragment extends BaseFragment implements HttpCallBack {

    @Bind(R.id.rv_orderpay_home)
    RecyclerView rv_orderpay_home;
    @Bind(R.id.shop_list_null)
    RelativeLayout shop_list_null;
    @Bind(R.id.tv_shop_null_text)
    TextView tv_shop_null_text;
    OrderPayAdapter orderPayAdapter;

    public static OrderBePayFragment instance = null;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.order_pay_fragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_shop_null_text.setText("暂无订单信息");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SP.get(getActivity(), SpContent.isLogin, "").equals("1")) {
            doFirstData();
        } else {
        }
    }

    @Override
    protected void doFitsrData() {

    }

    /**
     * 获取代付款订单的数据
     */
    public void doFirstData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ORDERPAYLISTITEM, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.ORDERPAYLISTITEM:
                OrderPayBean orderPayBean = GsonUtil.toObj(res, OrderPayBean.class);
                if (orderPayBean.isSuccess() && orderPayBean.getErrorCode().equals("0")) {
                    if (orderPayBean.getBody().getPendingOrderList().size() > 0) {
                        shop_list_null.setVisibility(View.GONE);
                        orderPayAdapter = new OrderPayAdapter(getActivity(), R.layout.order_pay_first_listitem, orderPayBean.getBody().getPendingOrderList());
                        rv_orderpay_home.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
                        rv_orderpay_home.setAdapter(orderPayAdapter);
                    } else {
                        shop_list_null.setVisibility(View.VISIBLE);
                    }
                } else {
                    T.show(orderPayBean.getMsg());
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