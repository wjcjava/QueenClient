package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseRedPacketAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineRedPacketBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderDetailsListInfoBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPayDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PurchaseCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
 * 提交订单
 *
 */
public class PurchaseActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.list_order)
    ListView listOrder;
    @Bind(R.id.title_title)
    TextView purtitle;
    private PurchaseListViewAdapter listadapter;
    @Bind(R.id.rl_purchase_top)
    RelativeLayout rl_purchase_top;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.tv_phone)
    TextView tv_phone;
    @Bind(R.id.tv_shopping_cart_number)
    TextView tv_shopping_cart_number;
    @Bind(R.id.tv_purcharse_cpmount)
    TextView tv_purcharse_cpmount;
    ShoppingCartBean shoppingCartBean;
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList = new ArrayList<>();
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList1 = new ArrayList<>();
    String lick_name, lick_phone, link_sex, shopId;
    List<OrderDetailsListInfoBean> orderDetailsListInfo;
    List<OrderPurchaseBean> orderPurchaseBeans;
    List<String> orderIdList = new ArrayList<>();
    double end_price = 0;
    double end_price1 = 0;
    String cartId = "";
    public PayPurchaseBean payPurchaseBean = null;
    public static PurchaseActivity instance = null;
    List<PayPurchaseBean> payPurchaseBeanList = new ArrayList<>();
    double cp_endprice = 0,first_price = 0;
    LoadingDialog loadingDialog;
    int moDou = 0;
    String isCheckQueen = "false";
    double youhui_price=0;
    private View mFooter;

    ImageView iv_purchase_right;
    TextView tv_purchase_red_packet_name;
    RecyclerView purchase_red_packet;
    RelativeLayout rl_purchase_red_packet_select;
    PurchaseRedPacketAdapter purchaseRedPacketAdapter;
    TextView tv_purchase_red_packet_money;
    TextView tv_red_packet_modou;
    TextView tv_red_packet_queen_money;
    TextView tv_purchase_non;
    RelativeLayout rl_purchase_bean;
    RelativeLayout rl_purchase_queencard;

    double end_modou = 0;

    String CP_method = "";
    String redPacketId = "";
    boolean isBuyRule = false;

    @Override
    public int getLayoutId() {
        instance = this;
        return R.layout.activity_purchase;
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        purtitle.setText("提交订单");
        Intent intent = this.getIntent();
        shoppingCartBean = (ShoppingCartBean) intent.getSerializableExtra("cartBean");

        mFooter = LayoutInflater.from(this).inflate(R.layout.purchase_footer_xml, null);  //加载footer的布局
        listOrder.addFooterView(mFooter);

        getMinebeanData();

        purchase_red_packet = mFooter.findViewById(R.id.purchase_red_packet);
        iv_purchase_right = mFooter.findViewById(R.id.iv_purchase_right);
        tv_purchase_red_packet_name = mFooter.findViewById(R.id.tv_purchase_red_packet_name);
        rl_purchase_red_packet_select = mFooter.findViewById(R.id.rl_purchase_red_packet_select);
        tv_purchase_red_packet_money = mFooter.findViewById(R.id.tv_purchase_red_packet_money);
        tv_purchase_non = mFooter.findViewById(R.id.tv_purchase_non);
        tv_red_packet_modou = mFooter.findViewById(R.id.tv_red_packet_modou);
        tv_red_packet_queen_money = mFooter.findViewById(R.id.tv_red_packet_queen_money);
        rl_purchase_bean = mFooter.findViewById(R.id.rl_purchase_bean);
        rl_purchase_queencard = mFooter.findViewById(R.id.rl_purchase_queencard);


        rl_purchase_red_packet_select.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if(purchase_red_packet.getVisibility() == 0){
                    purchase_red_packet.setVisibility(View.GONE);
                    iv_purchase_right.setBackground(PurchaseActivity.this.getResources().getDrawable(R.drawable.arrow_up_black));
                }else{
                    purchase_red_packet.setVisibility(View.VISIBLE);
                    iv_purchase_right.setBackground(PurchaseActivity.this.getResources().getDrawable(R.drawable.arrow_dwon_blue));
                }
            }
        });

    }

    /**
     * 获取我的魔豆数
     */
    private void getMinebeanData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(PurchaseActivity.this, SpContent.UserId, "") + "");
        params.put("token",SP.get(PurchaseActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lick_name = SP.get(this, SpContent.UserName, "") + "";
        lick_phone = SP.get(this, SpContent.UserCall, "") + "";
        tv_name.setText("订单联系人："+lick_name);
        tv_phone.setText(lick_phone);
    }

    /**
     * 选择优惠券
     * @param pos
     */
    public void addPurchaseData(int pos){
        /**
         *
         * 这里应该需要传过来优惠金额和优惠的文字显示在页面上
         *
         */
        CP_method = "";
        cp_endprice = 0;
        youhui_price = 0;
        for(int i=0;i<payPurchaseBeanList.size();i++){
            if(i == pos){
                payPurchaseBeanList.set(pos,payPurchaseBean);
            }
            if(i == payPurchaseBeanList.size()-1){
                for(int j=0;j<payPurchaseBeanList.size();j++){
                    double cp_end = 0;
                    double cp_end_not = 0;
                    for(int k=0;k<shopList1.get(j).getApiAnsCustCartList().size();k++){

                        int number = Integer.parseInt(shopList1.get(j).getApiAnsCustCartList().get(k).getAnsCustCart().getPurchaseNumber());//数量
                        double unitePrice = Double.parseDouble(shopList1.get(j).getApiAnsCustCartList().get(k).getAnsCustCart().getUnitPrice());//单价

                        /**
                         * 判断是否为特价商品（特价商品不参加满减）
                         */
                        if(shopList1.get(j).getApiAnsCustCartList().get(k).getEcGoodsBasic().getBuyRule().equals("1")){
                            //特价商品
                            cp_end_not = cp_end_not + number * unitePrice;
                        }else if(shopList1.get(j).getApiAnsCustCartList().get(k).getEcGoodsBasic().getBuyRule() ==null||shopList1.get(j).getApiAnsCustCartList().get(k).getEcGoodsBasic().getBuyRule().equals("0")){
                            cp_end = cp_end + number * unitePrice;
                        }
                    }

                    if(payPurchaseBeanList.get(j).getCpMoney().equals("")){
                        cp_end = cp_end;

                    }else{
                        if(Double.parseDouble(payPurchaseBeanList.get(j).getCpMoney())>cp_end){
                            cp_end = cp_end;
                            youhui_price = youhui_price+cp_end;
                        }else{
                            cp_end = cp_end - Double.parseDouble(payPurchaseBeanList.get(j).getCpMoney());
                            youhui_price = youhui_price + Double.parseDouble(payPurchaseBeanList.get(j).getCpMoney());
                        }
                    }

                    String disCount = "10";
                    /**
                     * 先判断用户自己是不是女王会员
                     */
                    if(SP.get(PurchaseActivity.this,SpContent.IsQueenVip,"0").equals("1")){
                        /**
                         * queenCard  "1"  说明是女王会员店
                         */
                        if(shopList1.get(j).getQueenCard().equals("1")){
                            disCount = shopList1.get(j).getQueenShopDiscount();
                        }else{
                            disCount = "10";
                        }
                    }else{
                        disCount = "10";
                    }
                    cp_endprice = cp_endprice + cp_end * Double.parseDouble(disCount)/10 + cp_end_not;
                }

                tv_purchase_red_packet_name.setText("请选择红包");
                tv_purchase_red_packet_money.setText("-¥0.00");

                tv_shopping_cart_number.setText("¥" + MD5.doubleToString(cp_endprice+""));
                tv_purcharse_cpmount.setText("已优惠¥"+MD5.doubleToString((youhui_price+end_price1-end_price)+""));
                listadapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * 获取购物车数据
     */
    private void getShopCartData() {
        shopList = shoppingCartBean.getBody().getShopList();
        orderPurchaseBeans = new ArrayList<>();
        for(int i=0;i<shopList.size();i++){
            if(shopList.get(i).getApiAnsCustCartList().size()>0){
                shopList1.add(shopList.get(i));
            }
        }
        for (int i = 0; i < shopList1.size(); i++){


            orderDetailsListInfo = new ArrayList<>();
            cartId = "";
            boolean isBean = false;
            for (int j = 0; j < shopList1.get(i).getApiAnsCustCartList().size(); j++) {

                /**
                 * 判断是否为特价商品（特价商品不参加满减）
                 */
                if(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getBuyRule().equals("1")){
                    isBuyRule = true;
                }else if(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getBuyRule() ==null||shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getBuyRule().equals("0")){
                }

                String point_rule ;
                if(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule() == null||shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule().equals("")){
                    point_rule = "0";
                }else{
                    point_rule = shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule();
                }
                end_modou = end_modou + Double.parseDouble(point_rule) * Integer.parseInt(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber());

                String disCount = "10";
                /**
                 * 先判断用户自己是不是女王会员
                 */
                if(SP.get(PurchaseActivity.this,SpContent.IsQueenVip,"0").equals("1")){
                    /**
                     * queenCard  "1"  说明是女王会员店
                     */
                    if(shopList1.get(i).getQueenCard().equals("1")){
                        if(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getBuyRule().equals("1")){
                            disCount = "10";
                        }else{
                            disCount = shopList1.get(i).getQueenShopDiscount();
                        }
                    }else{
                        disCount = "10";
                    }
                }else{
                    disCount = "10";
                }

                double dis_price = Double.parseDouble(disCount)*Integer.parseInt( shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber()) * (double)Double.parseDouble(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice())/10;
                end_price = end_price + dis_price;

                end_price1 = end_price1 + Integer.parseInt( shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber()) * (double)Double.parseDouble(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice());

                OrderDetailsListInfoBean orderDetailsListInfoBean = new OrderDetailsListInfoBean();
                orderDetailsListInfoBean.setGoodsId(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getId());
                orderDetailsListInfoBean.setPurchaseNumber(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber() + "");
                orderDetailsListInfoBean.setUnitPrice(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice() + "");
                orderDetailsListInfoBean.setSumAmount(Integer.parseInt(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getPurchaseNumber()) * (double) Double.parseDouble(shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getUnitPrice()) + "");
                orderDetailsListInfoBean.setDiscountAmount("");
                if(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule() == null||shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule().equals("")){
                    orderDetailsListInfoBean.setUsePoints("");
                }else {
                    isBean = true;
                    orderDetailsListInfoBean.setUsePoints((int)Double.parseDouble(shopList1.get(i).getApiAnsCustCartList().get(j).getEcGoodsBasic().getPointRule())+"");//使用魔豆值
                }
                orderDetailsListInfo.add(orderDetailsListInfoBean);
                cartId = cartId + shopList1.get(i).getApiAnsCustCartList().get(j).getAnsCustCart().getId() + ",";
            }
            shopId = shopList1.get(i).getId();
            OrderPurchaseBean orderPurchaseBean = new OrderPurchaseBean();
            orderPurchaseBean.setShopId(shopId);
            orderPurchaseBean.setCpId("");//   使用的优惠券ID
            if(isBean){
                orderPurchaseBean.setCpMethod("");//   1优惠券    2魔豆     3两者都有
            }else {
                orderPurchaseBean.setCpMethod("");//   1优惠券    2魔豆     3两者都有
            }
            orderPurchaseBean.setCartIds(cartId);
            orderPurchaseBean.setOrderDetailsListInfo(orderDetailsListInfo);
            orderPurchaseBeans.add(orderPurchaseBean);


            PayPurchaseBean payPurchaseBeand = new PayPurchaseBean();
            if(isBean){
                payPurchaseBeand.setCpMethod("");
            }else{
                payPurchaseBeand.setCpMethod("");
            }
            payPurchaseBeand.setCpId("");
            payPurchaseBeand.setCpName("");
            payPurchaseBeand.setCpMoney("");
            payPurchaseBeanList.add(payPurchaseBeand);
        }

        first_price = end_price;
        tv_shopping_cart_number.setText("¥" + MD5.doubleToString(end_price+""));
        listadapter = new PurchaseListViewAdapter(this,shopList1,payPurchaseBeanList,moDou);
        listOrder.setAdapter(listadapter);
        listadapter.notifyDataSetChanged();

        getRedPacketData();
    }


    /**
     * 获取我的红包
     */
    private void getRedPacketData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "1");
        params.put("token",SP.get(PurchaseActivity.this,SpContent.UserToken,"")+"");
        params.put("orderAmount",end_price+"");
        HttpUtils.doPost(ACTION.GETMINEUSEREDPACKET, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @SuppressLint("WrongConstant")
    @OnClick({R.id.tv_submit, R.id.title_back, R.id.rl_purchase_top})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            /**
             * 选择联系人
             */
            case R.id.rl_purchase_top:
                //startActivity(new Intent(PurchaseActivity.this, SelectLinkPeopleActivity.class));
                break;
            //提交订单
            case R.id.tv_submit:
                if(tv_name.getText().equals("请添加联系人")){
                    T.show("您还未添加联系人");
                }else{
                    CheckQueenData();
                    UploadData();
                }
                break;
        }
    }

    /**
     * 判断店铺是否支持女王卡
     */
    private void CheckQueenData() {
        loadingDialog.loadShow();
        String shopId="";
        for(int i=0;i<shopList1.size();i++){
            shopId = shopId + shopList1.get(i).getId()+",";
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("shopIds", shopId);
        params.put("token",SP.get(PurchaseActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.CHECKQUEENCARD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 提交订单
     */
    private void UploadData() {

        for(int i=0;i<payPurchaseBeanList.size();i++){

            if(CP_method.equals("2")){
                orderPurchaseBeans.get(i).setCpMethod("2");
            }else {
                orderPurchaseBeans.get(i).setCpMethod(payPurchaseBeanList.get(i).getCpMethod());
            }
            orderPurchaseBeans.get(i).setCpId(payPurchaseBeanList.get(i).getCpId());
        }
        Gson gson = new Gson();
        String str = gson.toJson(orderPurchaseBeans);
        HashMap<String, String> params = new HashMap<>();
        params.put("orderInfo", str);
        params.put("userId", SP.get(PurchaseActivity.this, SpContent.UserId, "") + "");
        params.put("token",SP.get(PurchaseActivity.this,SpContent.UserToken,"")+"");
        params.put("platform", "3");
        params.put("redPacketId",redPacketId);
        HttpUtils.doPost(ACTION.UPLOADORDERS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 获取我可用的红包记录
             */
            case ACTION.GETMINEUSEREDPACKET:

                tv_red_packet_modou.setText("-"+MD5.doubleToString(end_modou+""));

                if(end_modou == 0){
                    rl_purchase_bean.setVisibility(View.GONE);
                }else{
                    rl_purchase_bean.setVisibility(View.VISIBLE);
                }

                if(end_price1-end_price == 0){
                    rl_purchase_queencard.setVisibility(View.GONE);
                }else{
                    rl_purchase_queencard.setVisibility(View.VISIBLE);
                }

                tv_red_packet_queen_money.setText("-¥"+MD5.doubleToString((end_price1-end_price)+""));
                tv_purcharse_cpmount.setText("已优惠¥"+MD5.doubleToString((end_price1-end_price)+""));

                final MineRedPacketBean mineRedPacketBean = GsonUtil.toObj(res,MineRedPacketBean.class);
                if(mineRedPacketBean.isSuccess()&&mineRedPacketBean.getErrorCode().equals("0")){
                    if(mineRedPacketBean.getBody().getPageSum() == 0){
                        rl_purchase_red_packet_select.setClickable(false);

                        tv_purchase_non.setText("暂无红包");
                    }else{
                        rl_purchase_red_packet_select.setClickable(true);
                        tv_purchase_red_packet_name.setText("请选择红包");
                        tv_purchase_non.setText("不使用红包");


                        tv_purchase_non.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                CP_method = "";
                                redPacketId = "";
                                tv_shopping_cart_number.setText("¥"+MD5.doubleToString(end_price+""));
                                tv_purcharse_cpmount.setText("已优惠¥"+MD5.doubleToString((end_price1-end_price)+""));

                                tv_purchase_red_packet_name.setText("请选择红包");
                                tv_purchase_red_packet_money.setText("-¥0.00");
                            }
                        });

                        purchaseRedPacketAdapter = new PurchaseRedPacketAdapter(R.layout.purchase_red_packet_list_item, mineRedPacketBean.getBody().getRedPackets());
                        purchase_red_packet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        purchase_red_packet.setAdapter(purchaseRedPacketAdapter);

                        purchaseRedPacketAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                                if(isBuyRule){
                                    T.show("您选购的商品中含有特价商品，不能与红包一同使用哦！");
                                }else {
                                    CP_method = "2";
                                    redPacketId = mineRedPacketBean.getBody().getRedPackets().get(position).getId();

                                    tv_purchase_red_packet_name.setText(mineRedPacketBean.getBody().getRedPackets().get(position).getRedPacketTitle());
                                    tv_purchase_red_packet_money.setText("-¥" + mineRedPacketBean.getBody().getRedPackets().get(position).getMoney());


                                    if(end_price >= Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney())){
                                        double red_price = end_price - Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney());
                                        tv_shopping_cart_number.setText("¥" + MD5.doubleToString(red_price + ""));
                                        double packet_price = end_price1 - end_price + Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney());
                                        tv_purcharse_cpmount.setText("已优惠¥" + MD5.doubleToString(packet_price + ""));
                                    }else{
                                        tv_shopping_cart_number.setText("¥0.00");
                                        tv_purcharse_cpmount.setText("已优惠¥" + end_price);
                                    }

                                }
                            }
                        });
                    }
                }else{
                    T.show(mineRedPacketBean.getMsg());
                }
                break;
            /**
             * 获取我的魔豆
             */
            case ACTION.GETMINEMODOU:
                MoDouBean moDouBean = GsonUtil.toObj(res,MoDouBean.class);
                if (moDouBean.isSuccess()) {
                    moDou = moDouBean.getBody().getMap().getPointsNow();
                    getShopCartData();
                } else {
                    T.show(moDouBean.getMsg());
                }
                break;
            /**
             * 是否支持女王卡支付
             */
            case ACTION.CHECKQUEENCARD:

                PurchaseCheckBean purchaseCheckBean = GsonUtil.toObj(res,PurchaseCheckBean.class);
                if(purchaseCheckBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (purchaseCheckBean.isSuccess()) {

                        if (purchaseCheckBean.getBody().getCheckFlag().equals("not")) {
                            isCheckQueen = "false";
                        } else {
                            isCheckQueen = "true";
                        }
                    } else {
                        T.show(purchaseCheckBean.getMsg());
                    }
                }
                break;
            case ACTION.UPLOADORDERS://提交订单
                loadingDialog.cancel();
                OrderPayDetailBean successBean = GsonUtil.toObj(res, OrderPayDetailBean.class);

                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.getErrorCode().equals("0")) {
                        String businessIds = "";
                        orderIdList = successBean.getBody().getOrderIdList();
                        for (int i = 0; i < orderIdList.size(); i++) {
                            businessIds = businessIds + orderIdList.get(i) + ",";
                        }
                        String price_next = tv_shopping_cart_number.getText().toString();
                        if (Double.parseDouble(price_next.substring(1, price_next.length())) == 0) {

                            Intent intent = new Intent(PurchaseActivity.this, DealSuccessActivity.class);
                            intent.putExtra("payType", "4");
                            intent.putExtra("payMonet", "0.00");
                            intent.putExtra("payId", businessIds);
                            startActivity(intent);
                        } else {

                            Intent intent = new Intent(PurchaseActivity.this, SubmitActivity.class);
                            intent.putExtra("businessIds", businessIds);
                            intent.putExtra("amount", tv_shopping_cart_number.getText().toString());
                            intent.putExtra("submitId",successBean.getBody().getSubmitId());
                            startActivity(intent);
                        }
                        finish();
                    } else {
                        T.show(successBean.getMsg());
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