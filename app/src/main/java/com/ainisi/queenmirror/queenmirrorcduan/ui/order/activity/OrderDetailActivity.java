package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.OrderDetailListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GetZxingBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.NavigationActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BitmapUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CoodinateCovertor;
import com.ainisi.queenmirror.queenmirrorcduan.utils.LngLat;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NavtagationUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 订单详情
 */

public class OrderDetailActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.tv_common_title)
    TextView tv_common_title;
    @Bind(R.id.rv_orderdetail_order)
    RecyclerView rv_orderdetail_order;
    @Bind(R.id.tv_order_detail_ordernum)
    TextView tv_order_detail_ordernum;
    @Bind(R.id.tv_order_detail_tel)
    TextView tv_order_detail_tel;
    @Bind(R.id.tv_order_detail_ordertime)
    TextView tv_order_detail_ordertime;
    @Bind(R.id.tv_orderdetail_heji)
    TextView tv_orderdetail_heji;
    @Bind(R.id.iv_order_detail_zxing)
    ImageView iv_order_detail_zxing;
    @Bind(R.id.re_order_refund)
    RelativeLayout re_order_refund;
    @Bind(R.id.tv_orderdetail_cpamount)
    TextView tv_orderdetail_cpamount;

    @Bind(R.id.tv_order_detail_shopname)
    TextView tv_order_detail_shopname;
    @Bind(R.id.tv_order_detail_counp)
    TextView tv_order_detail_counp;
    @Bind(R.id.tv_order_detail_bean)
    TextView tv_order_detail_bean;
    @Bind(R.id.tv_order_detail_discount)
    TextView tv_order_detail_discount;
    @Bind(R.id.rl_order_detail_counp)
    RelativeLayout rl_order_detail_counp;
    @Bind(R.id.tv_order_detail_counp_name)
    TextView tv_order_detail_counp_name;
    @Bind(R.id.tv_order_detail_pintuan)
    TextView tv_order_detail_pintuan;
    @Bind(R.id.tv_order_detail_address_tv)
    TextView tv_order_detail_address_tv;
    @Bind(R.id.rl_order_detail_ll_prc)
    LinearLayout rl_order_detail_ll_prc;
    @Bind(R.id.rl_order_detail_ll_ct)
    LinearLayout rl_order_detail_ll_ct;
    String orderNo, orderTel, orderTime, OrderHeji, orderId, orderState, shopId, cpAmount;
    List<OrderDetailBean.BodyBean.ApiOrderShopBean.ApiDetailsOrderListBean> apiDetailsOrderList = new ArrayList<>();
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> getApiOrderDetailsList = new ArrayList();
    private String longitude;
    private String latitude;
    private String address;
    private boolean isbaidu = false;
    private boolean isgaode = false;
    private boolean istencent = false;
    private String orderType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intentGet = getIntent();
        getApiOrderDetailsList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean>) intentGet.getSerializableExtra("lstBean");
        orderNo = intentGet.getStringExtra("orderNo");
        orderTel = intentGet.getStringExtra("orderTel");
        orderTime = intentGet.getStringExtra("orderTime");
        OrderHeji = intentGet.getStringExtra("OrderHeji");
        orderId = intentGet.getStringExtra("orderId");
        orderState = intentGet.getStringExtra("orderState");
        shopId = intentGet.getStringExtra("shopId");
        cpAmount = intentGet.getStringExtra("cpAmount");
        orderType = intentGet.getStringExtra("orderType");

        tv_common_title.setText("订单详情页");
        switch (orderType) {
            //普通
            case "0":
                rl_order_detail_ll_prc.setVisibility(View.VISIBLE);
                rl_order_detail_ll_ct.setVisibility(View.GONE);
                break;
            //秒杀
            case "1":
                rl_order_detail_ll_ct.setVisibility(View.VISIBLE);
                rl_order_detail_ll_prc.setVisibility(View.GONE);
                break;
            //拼团
            case "2":
                rl_order_detail_ll_prc.setVisibility(View.VISIBLE);
                rl_order_detail_ll_ct.setVisibility(View.GONE);
                break;
            default:
                break;
        }
        if (cpAmount == null || cpAmount.equals("null") || cpAmount.equals("")) {
            cpAmount = "0";
        }
        tv_order_detail_ordernum.setText("订单号码：" + orderNo);

        tv_orderdetail_heji.setText("¥" + MD5.doubleToString(OrderHeji));

        getOrderDetail();

        if (orderState.equals("UT") || orderState.equals("FT")) {
            if (!TextUtils.isEmpty(OrderHeji) && Double.valueOf(OrderHeji) != 0) {
                re_order_refund.setVisibility(View.VISIBLE);
            } else {
                re_order_refund.setVisibility(View.GONE);
            }
        } else {
            re_order_refund.setVisibility(View.GONE);
        }

//        if (orderState.equals("UT") || orderState.equals("UP") || orderState.equals("UP") || orderState.equals("CA") || orderState.equals("RA")
//                || orderState.equals("RF") || orderState.equals("PR") || orderState.equals("PF") || orderState.equals("PT")) {
//            iv_order_detail_zxing.setVisibility(View.GONE);
//        } else {
//            iv_order_detail_zxing.setVisibility(View.VISIBLE);
//            getZxingData();
//        }

        if (orderState.equals("PT")) {
            tv_order_detail_pintuan.setVisibility(View.VISIBLE);
        } else {
            tv_order_detail_pintuan.setVisibility(View.GONE);
        }
    }

    /**
     * 获取订单详情数据
     */
    private void getOrderDetail() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("custId", SP.get(OrderDetailActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(OrderDetailActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ORDERDETAIL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取二维码数据内容
     */
    private void getZxingData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("custId", SP.get(OrderDetailActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(OrderDetailActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETZXING, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.iv_common_back, R.id.re_order_refund, R.id.tv_orderdetail_content, R.id.tv_order_detail_address_ll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_orderdetail_content:
                //用intent启动拨打电话
                Intent intentc = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + orderTel);
                intentc.setData(data);
                startActivity(intentc);
                break;
            case R.id.iv_common_back:
                finish();
                break;
            case R.id.re_order_refund:
                //退款
                AlertDialog.Builder builder = new AlertDialog.Builder(OrderDetailActivity.this);
                LayoutInflater inflater = LayoutInflater.from(OrderDetailActivity.this);
                View v = inflater.inflate(R.layout.back_money_layout, null);
                TextView tv_dialog_go = (TextView) v.findViewById(R.id.tv_dialog_go);
                TextView tv_dialog_cancel = (TextView) v.findViewById(R.id.tv_dialog_cancel);
                final Dialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                tv_dialog_go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(OrderDetailActivity.this, ConfirmRefundActivity.class);
                        intent.putExtra("lstBean", (Serializable) getApiOrderDetailsList);
                        intent.putExtra("orderNo", orderNo);
                        intent.putExtra("orderId", orderId);
                        intent.putExtra("shopId", shopId);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                break;
            //导航
            case R.id.tv_order_detail_address_ll:
                if (NavtagationUtil.isAvilible(OrderDetailActivity.this, "com.baidu.BaiduMap")) {
                    isbaidu = true;
                }
                if (NavtagationUtil.isAvilible(OrderDetailActivity.this, "com.autonavi.minimap")) {
                    isgaode = true;
                }
                if (NavtagationUtil.isAvilible(OrderDetailActivity.this, "com.tencent.map")) {
                    istencent = true;
                }
                if (isbaidu == false && istencent == false && isgaode == false) {
                    Intent intent = new Intent(this, NavigationActivity.class);
                    intent.putExtra("latitude", latitude);
                    intent.putExtra("longitude", longitude);
                    intent.putExtra("address", address);
                    startActivity(intent);
                } else {
                    setDialog();
                }
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            /**
             * 订单详情
             */
            case ACTION.ORDERDETAIL:
                final OrderDetailBean orderDetailBean = GsonUtil.toObj(res, OrderDetailBean.class);
                if (orderDetailBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    apiDetailsOrderList = orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList();

                    tv_order_detail_shopname.setText(orderDetailBean.getBody().getApiOrderShop().getShopName());

                    double couponDiscount = orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(0).getCouponDiscount();//优惠券
                    double memberDiscount = orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(0).getMemberDiscount();//女王会员折扣
                    double redPacketDiscount = orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(0).getRedPacketDiscount();//红包优惠

                    if (couponDiscount == 0 && redPacketDiscount == 0) {
                        rl_order_detail_counp.setVisibility(View.GONE);
                    } else {
                        rl_order_detail_counp.setVisibility(View.VISIBLE);
                        if (couponDiscount == 0) {
                            tv_order_detail_counp_name.setText("红包优惠");
                            tv_order_detail_counp.setText("-¥" + MD5.doubleToString(redPacketDiscount + ""));
                        } else {
                            tv_order_detail_counp_name.setText("店铺通用券");
                            tv_order_detail_counp.setText("-¥" + MD5.doubleToString(couponDiscount + ""));
                        }
                    }
                    tv_order_detail_bean.setText("魔豆" + orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(0).getUsePoints());
                    tv_order_detail_discount.setText("-¥" + MD5.doubleToString(memberDiscount + ""));

                    OrderDetailListAdapter sbmitWholeAdapter = new OrderDetailListAdapter(OrderDetailActivity.this, R.layout.order_detail_listitem, apiDetailsOrderList);
                    rv_orderdetail_order.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
                    rv_orderdetail_order.setAdapter(sbmitWholeAdapter);

                    sbmitWholeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(OrderDetailActivity.this, FullActivity.class);
                            intent.putExtra("goodsId", orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(position).getGoodsId());
                            intent.putExtra("shopId", orderDetailBean.getBody().getApiOrderShop().getShopId());
                            intent.putExtra("shopName", orderDetailBean.getBody().getApiOrderShop().getShopName());
                            intent.putExtra("shopLogo", orderDetailBean.getBody().getApiOrderShop().getApiDetailsOrderList().get(position).getGoodsThumb());
                            intent.putExtra("number", "1");
                            startActivity(intent);
                        }
                    });

                    double price_youhui = Double.parseDouble(orderDetailBean.getBody().getApiOrderShop().getOrderAmount()) - Double.parseDouble(orderDetailBean.getBody().getApiOrderShop().getAfterAmount());
                    tv_order_detail_tel.setText("手机号码：" + orderDetailBean.getBody().getApiOrderShop().getCustTelNo());
                    tv_orderdetail_cpamount.setText("优惠¥" + MD5.doubleToString(String.valueOf(price_youhui)));
                    tv_order_detail_ordertime.setText("下单时间：" + orderDetailBean.getBody().getApiOrderShop().getOrderTime());
                    tv_order_detail_address_tv.setText(orderDetailBean.getBody().getApiOrderShop().getShopAddress());
                    address = orderDetailBean.getBody().getApiOrderShop().getShopAddress();
                    latitude = orderDetailBean.getBody().getApiOrderShop().getGeoY();
                    longitude = orderDetailBean.getBody().getApiOrderShop().getGeoX();
                }
                break;
            /**
             * 二维码
             */
            case ACTION.GETZXING:
                GetZxingBean getZxingBean = GsonUtil.toObj(res, GetZxingBean.class);
                if (getZxingBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (getZxingBean.isSuccess()) {
                        Bitmap bitmap = BitmapUtils.makeQRImage(getZxingBean.getBody().getCustOrderQrGet() + "," + orderId, iv_order_detail_zxing.getWidth(), iv_order_detail_zxing.getHeight());
                        iv_order_detail_zxing.setImageBitmap(bitmap);
                    } else {
                        T.show(getZxingBean.getMsg());
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

    /**
     * 地图导航弹窗
     */
    private void setDialog() {
        View root = LayoutInflater.from(this).inflate(
                R.layout.map_navagation_sheet, null);
        //初始化视图
        LinearLayout pop_baidu = root.findViewById(R.id.pop_baidu);
        LinearLayout pop_gaode = root.findViewById(R.id.pop_gaode);
        LinearLayout pop_tenxun = root.findViewById(R.id.pop_tenxun);
        LinearLayout pop_cancel = root.findViewById(R.id.pop_cancel);
        final PopupWindow popupWindow = new PopupWindow(root, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.popwin_anim_style);
        popupWindow.setContentView(root);
        setWindowAlpha(0.5f);
        popupWindow.showAtLocation(findViewById(R.id.tv_order_detail_all), Gravity.BOTTOM, 0, 0);
        if (isgaode == false) {
            pop_gaode.setVisibility(View.GONE);
        }
        if (isbaidu == false) {
            pop_baidu.setVisibility(View.GONE);
        }
        if (istencent == false) {
            pop_tenxun.setVisibility(View.GONE);
        }
        //百度地图
        pop_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.baidu.BaiduMap")) {
                LngLat lngLat = new LngLat(Double.valueOf(longitude), Double.valueOf(latitude));
                LngLat lngLat1 = CoodinateCovertor.bd_encrypt(lngLat);
                Intent intent = new Intent();
                intent.setData(Uri.parse("baidumap://map/direction?" +
                        "destination=latlng:" + lngLat1.getLantitude() + "," + lngLat1.getLongitude() + "|name:" + address + "&mode=driving"));
                startActivity(intent);
//                } else {
//                    //market为路径，id为包名
//                    //显示手机上所有的market商店
//                    Toast.makeText(FullActivity.this, "您尚未安装百度地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        //高德地图
        pop_gaode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.autonavi.minimap")) {
                Intent intent = new Intent();
                intent.setPackage("com.autonavi.minimap");
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
//                CoordinateConverter converter = new CoordinateConverter();
//                LatLng srcCoord = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
//                LatLng newEnd = converter.from(BD09LL).coord(srcCoord).convert();
                intent.setData(Uri.parse("androidamap://route?sourceApplication=女王魔镜&dlat=" + latitude + "&dlon=" + longitude + "&dname=" + address + "&dev=0&t=0"));
                startActivity(intent);
//                } else {
//                    Toast.makeText(FullActivity.this, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        //腾讯地图
        pop_tenxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.tencent.map")) {
                Intent intent = new Intent();
//                CoordinateConverter converter = new CoordinateConverter();
//                LatLng srcCoord = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
//                LatLng newEnd = converter.from(BD09LL).coord(srcCoord).convert();
                intent.setData(Uri.parse("qqmap://map/routeplan?type=drive&to=" + address + "&tocoord=" + latitude + "," + longitude + "&policy=1&referer=女王魔镜"));
                startActivity(intent);
//                } else {
//                    Toast.makeText(FullActivity.this, "您尚未安装腾讯地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.tencent.map");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        pop_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(1f);
            }
        });
    }

    private void setWindowAlpha(float alpha) {
        if (alpha < 0 || alpha > 1) return;
        WindowManager.LayoutParams windowLP = getWindow().getAttributes();
        windowLP.alpha = alpha;
        if (alpha == 1) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        getWindow().setAttributes(windowLP);
    }
}
