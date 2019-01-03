package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.ItemCouponsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter.PurchaseAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ReceiveDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 选择优惠券
 */
public class PurchaseSelectActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.re_select_common)
    RecyclerView re_select_common;
    @Bind(R.id.tv_history_common_null)
    TextView tv_history_common_null;
    @Bind(R.id.re_select_itemcoupons)
    RecyclerView re_select_itemcoupons;
    @Bind(R.id.tv_history_select_null)
    TextView tv_history_select_null;
    String shopId = "", goodsIds = "",amount,postion,purchaseNow,isbean = "";
    public static PurchaseSelectActivity instance = null;

    LoadingDialog loadingDialog;

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_purchase_select;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("选择优惠券");
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        shopId = intent.getStringExtra("shopId");
        goodsIds = intent.getStringExtra("goodsIds");
        amount = MD5.doubleToString(intent.getStringExtra("amount"));
        postion = intent.getStringExtra("postion");
        purchaseNow = intent.getStringExtra("purchaseNow");
        isbean = intent.getStringExtra("isBean");

        getPurData();
    }

    /**
     * 获取可用的优惠券
     */
    private void getPurData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(PurchaseSelectActivity.this, SpContent.UserId,"")+"");//用户ID
        params.put("token",SP.get(PurchaseSelectActivity.this,SpContent.UserToken,"")+"");//用户token
        params.put("shopId",shopId);
        params.put("goodsIds",goodsIds);
        params.put("goodsAmount",amount);
        HttpUtils.doPost(ACTION.GETUSEYOUHUIQUAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETUSEYOUHUIQUAN:
                loadingDialog.cancel();
                ReceiveDiscounBean receiveBean = GsonUtil.toObj(res, ReceiveDiscounBean.class);
                if(receiveBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (receiveBean.isSuccess()) {
                        List<ReceiveDiscounBean.BodyBean.CustCouponListDataBean> receiveList = receiveBean.getBody().getCustCouponListData();
                        if (receiveList.size() == 0) {
                            tv_history_common_null.setVisibility(View.VISIBLE);
                        } else {
                            tv_history_common_null.setVisibility(View.INVISIBLE);
                            PurchaseAdapter purchaseAdapter = new PurchaseAdapter(R.layout.item_discount, receiveList, amount, postion, purchaseNow,isbean);
                            re_select_common.setLayoutManager(new LinearLayoutManager(PurchaseSelectActivity.this, LinearLayoutManager.VERTICAL, false));
                            re_select_common.setAdapter(purchaseAdapter);
                        }
                        List<ReceiveDiscounBean.BodyBean.CustCouponListDataItemBean> discountList_single = receiveBean.getBody().getCustCouponListDataItem();
                        if (discountList_single.size() == 0) {
                            tv_history_select_null.setVisibility(View.VISIBLE);
                        } else {
                            tv_history_select_null.setVisibility(View.INVISIBLE);
                            ItemCouponsAdapter couponsAdapter = new ItemCouponsAdapter(R.layout.item_itemcount, discountList_single, 1, purchaseNow, postion,isbean);
                            re_select_itemcoupons.setLayoutManager(new LinearLayoutManager(PurchaseSelectActivity.this, LinearLayoutManager.VERTICAL, false));
                            re_select_itemcoupons.setAdapter(couponsAdapter);
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