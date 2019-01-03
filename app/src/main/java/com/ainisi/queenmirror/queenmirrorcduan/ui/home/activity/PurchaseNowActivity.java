package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PurchaseRedPacketAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineRedPacketBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PurchaseCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PurchaseNowBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ScrollRecyclerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 立即购买
 */
public class PurchaseNowActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    String lick_name, lick_phone, link_sex;
    @Bind(R.id.tv_name)
    TextView tv_name;
    @Bind(R.id.tv_sex)
    TextView tv_sex;
    @Bind(R.id.tv_phone)
    TextView tv_phone;
    @Bind(R.id.tv_now_submit)
    TextView tv_now_submit;//提交
    @Bind(R.id.tv_shopping_cart_number_now)
    TextView tv_shopping_cart_number_now;//总价
    @Bind(R.id.purchase_shop_name)
    TextView purchase_shop_name;//店铺名字
    @Bind(R.id.li_purchase_product)
    LinearLayout li_purchase_product;//店铺商品
    @Bind(R.id.tv_pur_youhui)
    TextView tv_pur_youhui;//优惠券
    @Bind(R.id.tv_pur_modou)
    TextView tv_pur_modou;//魔豆
    @Bind(R.id.tv_pur_selectname)
    public TextView tv_pur_selectname;//魔豆优惠券文字
    @Bind(R.id.rl_purchase_select)
    RelativeLayout rl_purchase_select;//魔豆优惠券选择
    @Bind(R.id.rl_purchase_top)
    RelativeLayout rl_purchase_top;
    @Bind(R.id.tv_purchase_now_youhui)
    public TextView tv_purchase_now_youhui;
    @Bind(R.id.tv_purch_beannumber)
    TextView tv_purch_beannumber;
    private boolean moudou = false;
    String shopName, shopId, goodId, goodName, goodPrice, goodPriceSale;
    public String cpMethod = "", cpId = "", cp_money = "";
    double cp_endprice = 0;
    public static PurchaseNowActivity instance = null;
    LoadingDialog loadingDialog;
    String isCheckQueen = "false";
    String goods_image = "", isBean, usePoints;
    int moDou = 0;
    String disCount, isQueenVip;

    @Bind(R.id.tv_red_packet_modou)
    TextView tv_red_packet_modou;//魔豆值
    @Bind(R.id.tv_red_packet_queen_money)
    TextView tv_red_packet_queen_money;//女王会员优惠
    @Bind(R.id.tv_purchase_red_packet_name)
    TextView tv_purchase_red_packet_name;//请选择红包
    @Bind(R.id.tv_purchase_red_packet_money)
    TextView tv_purchase_red_packet_money;//红包金额
    @Bind(R.id.purchase_red_packet)
    ScrollRecyclerView purchase_red_packet;
    @Bind(R.id.rl_purchase_red_packet_select)
    RelativeLayout rl_purchase_red_packet_select;
    @Bind(R.id.tv_purchase_non)
    TextView tv_purchase_non;
    @Bind(R.id.iv_purchase_right)
    ImageView iv_purchase_right;
    @Bind(R.id.rl_purchase_bean)
    RelativeLayout rl_purchase_bean;
    @Bind(R.id.rl_purchase_queencard)
    RelativeLayout rl_purchase_queencard;

    String disCountP, buyRules;
    double prica, price_change;
    PurchaseRedPacketAdapter purchaseRedPacketAdapter;

    String redPacketId = "";

    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_purchase_now;
    }

    @Override
    protected void onResume() {
        super.onResume();

        lick_name = SP.get(this, SpContent.UserName, "") + "";
        lick_phone = SP.get(this, SpContent.UserCall, "") + "";
        tv_name.setText("订单联系人：" + lick_name);
        tv_phone.setText(lick_phone);
    }

    public void ChangeMoney() {
        redPacketId = "";
        cpMethod = "1";
        cp_endprice = 0;

        if (Double.parseDouble(cp_money) > Double.parseDouble(goodPrice.substring(1, goodPrice.length()))) {
            cp_endprice = cp_endprice + 0;
        } else {
            cp_endprice = cp_endprice + Double.parseDouble(goodPrice.substring(1, goodPrice.length())) - Double.parseDouble(cp_money);
        }

        if (isQueenVip.equals("false") || SP.get(this, SpContent.IsQueenVip, "0").equals("0")) {
            cp_endprice = cp_endprice;
        } else {
            if (buyRules.equals("0")) {
                cp_endprice = cp_endprice * Double.parseDouble(disCount) / 10;
            } else {
                cp_endprice = cp_endprice;
            }
        }

        double end_price = Double.parseDouble(goodPrice.substring(1, goodPrice.length())) - cp_endprice;

        tv_purchase_now_youhui.setText("已优惠¥" + MD5.doubleToString(end_price + ""));
        tv_shopping_cart_number_now.setText("¥" + cp_endprice);
    }

    @Override
    protected void initView() {
        super.initView();
        loadingDialog = new LoadingDialog(this);
        title_title.setText("提交订单");
        Intent intent = this.getIntent();
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        goodId = intent.getStringExtra("goodId");
        goodName = intent.getStringExtra("goodName");
        goodPrice = intent.getStringExtra("goodPrice");
        goodPriceSale = intent.getStringExtra("goodPriceSale");
        goods_image = intent.getStringExtra("goods_image");
        isBean = intent.getStringExtra("isBean");
        isQueenVip = intent.getStringExtra("isQueenVip");
        disCount = intent.getStringExtra("disCount");
        buyRules = intent.getStringExtra("buyRules");//是否限购

        CheckQueenData();
        getMinebeanData();

        disCountP = goodPrice;

        if (disCountP.length() > 0) {
            if (disCountP.substring(0, 1).equals("¥")) {
                disCountP = disCountP.substring(1, disCountP.length());
            } else {
                disCountP = disCountP;
            }
        }

        purchase_shop_name.setText(shopName);

        if (isQueenVip.equals("false") || SP.get(this, SpContent.IsQueenVip, "0").equals("0")) {

            if (goodPrice.length() > 0) {
                if (goodPrice.substring(0, 1).equals("¥")) {
                    tv_shopping_cart_number_now.setText(goodPrice);
                } else {
                    tv_shopping_cart_number_now.setText("¥" + goodPrice);
                }
            } else {
                tv_shopping_cart_number_now.setText("¥0");
            }

        } else {
            disCountP = goodPrice;

            if (disCountP.substring(0, 1).equals("¥")) {
                disCountP = disCountP.substring(1, disCountP.length());
            } else {
                disCountP = disCountP;
            }

            tv_shopping_cart_number_now.setText("¥" + Double.parseDouble(disCountP) * Double.parseDouble(disCount) / 10);

        }

        getRedPacketData();


        View _view = LayoutInflater.from(this).inflate(R.layout.layout_upload_product, null);
        // 3、在布局中添加组件，设置组件属性
        li_purchase_product.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        TextView tv_purchase_name = _view.findViewById(R.id.tv_purchase_name);
        tv_purchase_name.setText(goodName);

        ImageView iv_purchase_title = _view.findViewById(R.id.iv_purchase_title);
        String[] good_thumb = goods_image.split(",");
        Glide.with(this).load(good_thumb[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_purchase_title);

        TextView tv_purchase_bean_number = _view.findViewById(R.id.tv_purchase_bean_number);
        if (isBean == null || isBean.equals("")) {
            tv_purchase_bean_number.setVisibility(View.INVISIBLE);
        } else {
            tv_purchase_bean_number.setVisibility(View.VISIBLE);
            tv_purchase_bean_number.setText("所需魔豆：" + isBean);
        }

        TextView tv_purchase_presentprice = _view.findViewById(R.id.tv_purchase_presentprice);

        if (goodPrice.length() > 0) {
            if (goodPrice.substring(0, 1).equals("¥")) {
                tv_purchase_presentprice.setText(goodPrice);
            } else {
                tv_purchase_presentprice.setText("¥" + goodPrice);
            }

        }

        TextView tv_purchase_discount = _view.findViewById(R.id.tv_purchase_discount);
        if (isQueenVip.equals("false")) {
            tv_purchase_discount.setVisibility(View.INVISIBLE);
        } else {
            tv_purchase_discount.setVisibility(View.VISIBLE);
            String priceDis = goodPrice;
            if (priceDis.length() > 0) {
                if (priceDis.substring(0, 1).equals("¥")) {
                    priceDis = priceDis.substring(1, priceDis.length());
                } else {
                    priceDis = priceDis;
                }
            } else {
                priceDis = "0";
            }

            double price_dis = Double.parseDouble(priceDis) * Double.parseDouble(disCount) / 10;
            prica = Double.parseDouble(priceDis) - price_dis;
            if (buyRules.equals("0")) {
                tv_purchase_discount.setText("女王会员立减：¥" + MD5.doubleToString(prica + ""));
            } else {
                tv_purchase_discount.setVisibility(View.GONE);
            }
        }


        TextView tv_purchase_originalprice = _view.findViewById(R.id.tv_purchase_originalprice);
        if (goodPriceSale.length() > 0) {
            if (goodPriceSale.substring(0, 1).equals("¥")) {
                tv_purchase_originalprice.setText(goodPriceSale);
            } else {
                tv_purchase_originalprice.setText("¥" + goodPriceSale);
            }
        } else {
            tv_purchase_originalprice.setText("¥0");
        }

        /**
         * 设置限购一次
         */
        TextView buy_workroom_only_one = _view.findViewById(R.id.buy_workroom_only_one);
        if ("0".equals(buyRules)) {
            buy_workroom_only_one.setVisibility(View.GONE);
        } else {
            buy_workroom_only_one.setVisibility(View.VISIBLE);
        }

        tv_purchase_originalprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        TextView tv_purchase_adapter_number = _view.findViewById(R.id.tv_purchase_adapter_number);
        tv_purchase_adapter_number.setText("X 1");
    }

    /**
     * 获取我的红包数据
     */
    private void getRedPacketData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "1");
        params.put("token", SP.get(PurchaseNowActivity.this, SpContent.UserToken, "") + "");

        if (disCountP.equals("")) {
            params.put("orderAmount", "0");
        } else {
            params.put("orderAmount", (Double.parseDouble(disCountP) * Double.parseDouble(disCount) / 10) + "");
        }

        HttpUtils.doPost(ACTION.GETMINEUSEREDPACKET, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @SuppressLint("WrongConstant")
    @OnClick({R.id.title_back, R.id.tv_now_submit, R.id.rl_purchase_top, R.id.tv_pur_modou, R.id.tv_pur_youhui, R.id.rl_purchase_select, R.id.rl_purchase_red_packet_select})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.rl_purchase_red_packet_select:
                if (purchase_red_packet.getVisibility() == 0) {
                    purchase_red_packet.setVisibility(View.GONE);
                    iv_purchase_right.setBackground(PurchaseNowActivity.this.getResources().getDrawable(R.drawable.arrow_up_black));
                } else {
                    purchase_red_packet.setVisibility(View.VISIBLE);
                    iv_purchase_right.setBackground(PurchaseNowActivity.this.getResources().getDrawable(R.drawable.arrow_dwon_blue));
                }
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_now_submit:
                UploadData();
                break;
            case R.id.rl_purchase_top:
                //startActivity(new Intent(PurchaseNowActivity.this, SelectLinkPeopleActivity.class));
                break;
            case R.id.tv_pur_youhui:
                if (moudou) {
                    //true代表现在是在魔豆
                    tv_pur_selectname.setText("请选择优惠券");
                    moudou = false;
                    tv_pur_youhui.setBackground(this.getResources().getDrawable(R.drawable.back_pur_right_select));
                    tv_pur_youhui.setTextColor(this.getResources().getColor(R.color.alpha_85_black));
                    tv_pur_modou.setBackground(this.getResources().getDrawable(R.drawable.back_pur_select));
                    tv_pur_modou.setTextColor(this.getResources().getColor(R.color.white));
                } else {
                    //flase代表现在在优惠券
                }
                break;
            case R.id.tv_pur_modou:
                if (moudou) {
                    //true代表现在是在魔豆
                } else {
                    //flase代表现在在优惠券
                    tv_pur_selectname.setText("请选择抵扣商品");
                    moudou = true;
                    tv_pur_youhui.setTextColor(this.getResources().getColor(R.color.white));
                    tv_pur_modou.setTextColor(this.getResources().getColor(R.color.alpha_85_black));
                    tv_pur_youhui.setBackground(this.getResources().getDrawable(R.drawable.back_pur_select));
                    tv_pur_modou.setBackground(this.getResources().getDrawable(R.drawable.back_pur_right_select));
                }
                break;
            case R.id.rl_purchase_select:
                /**
                 * 代表选择的是优惠券
                 */
                Intent intentP = new Intent(PurchaseNowActivity.this, PurchaseSelectActivity.class);
                intentP.putExtra("shopId", shopId);
                intentP.putExtra("goodsIds", goodId);
                intentP.putExtra("purchaseNow", "now");
                intentP.putExtra("postion", "0");
                intentP.putExtra("amount", goodPrice.substring(1, goodPrice.length()) + "");

                if (isBean.equals("")) {
                    cpMethod = "";
                    intentP.putExtra("isBean", "false");
                } else {
                    cpMethod = "";
                    intentP.putExtra("isBean", "true");
                }
                startActivity(intentP);
                break;
        }
    }

    /**
     * 获取我的魔豆数
     */
    private void getMinebeanData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(PurchaseNowActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(PurchaseNowActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    /**
     * 判断店铺是否支持女王卡
     */
    private void CheckQueenData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("shopIds", shopId);
        params.put("token", SP.get(PurchaseNowActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CHECKQUEENCARD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 立即付款获取订单编号
     */
    private void UploadData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", goodId);
        params.put("userId", SP.get(PurchaseNowActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(PurchaseNowActivity.this, SpContent.UserToken, "") + "");
        params.put("cpMethod", cpMethod);
        params.put("cpId", cpId);
        params.put("usePoints", usePoints);
        params.put("redPacketId", redPacketId);
        params.put("platform", "3");
        params.put("purchaseNumber", "1");
        HttpUtils.doPost(ACTION.PAYNOWINPAYNew, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            /**
             * 获取我的红包
             */
            case ACTION.GETMINEUSEREDPACKET:

                if (isBean == null || isBean.equals("") || isBean.equals("0")) {
                    tv_red_packet_modou.setText("-0");
                    rl_purchase_bean.setVisibility(View.GONE);
                } else {
                    tv_red_packet_modou.setText("-" + isBean);
                    rl_purchase_bean.setVisibility(View.VISIBLE);
                }
                if (buyRules.equals("0")) {

                    if (SP.get(this, SpContent.IsQueenVip, "0").equals("0")) {
                        tv_red_packet_queen_money.setText("-¥0.00");
                        tv_purchase_now_youhui.setText("已优惠¥0.00");
                        rl_purchase_queencard.setVisibility(View.GONE);
                    } else {
                        tv_red_packet_queen_money.setText("-¥" + MD5.doubleToString(prica + ""));
                        tv_purchase_now_youhui.setText("已优惠¥" + MD5.doubleToString(prica + ""));

                        if (prica == 0) {
                            rl_purchase_queencard.setVisibility(View.GONE);
                        } else {
                            rl_purchase_queencard.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    tv_red_packet_queen_money.setText("-¥0");
                    tv_purchase_now_youhui.setText("已优惠¥0");
                    rl_purchase_queencard.setVisibility(View.GONE);
                }


                final MineRedPacketBean mineRedPacketBean = GsonUtil.toObj(res, MineRedPacketBean.class);
                if (mineRedPacketBean.isSuccess() && mineRedPacketBean.getErrorCode().equals("0")) {
                    if (mineRedPacketBean.getBody().getPageSum() == 0) {
                        tv_purchase_non.setText("暂无红包记录");
                        rl_purchase_red_packet_select.setClickable(false);
                    } else {
                        rl_purchase_red_packet_select.setClickable(true);
                        tv_purchase_red_packet_name.setText("请选择红包");
                        tv_purchase_non.setText("不使用红包");

                        tv_purchase_non.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                cpMethod = "";
                                cpId = "";
                                redPacketId = "";
                                tv_purchase_red_packet_name.setText("请选择红包");
                                tv_purchase_red_packet_money.setText("-¥0.00");


                                if (isQueenVip.equals("false") || SP.get(PurchaseNowActivity.this, SpContent.IsQueenVip, "0").equals("0")) {

                                    if (goodPrice.length() > 0) {
                                        if (goodPrice.substring(0, 1).equals("¥")) {
                                            tv_shopping_cart_number_now.setText(goodPrice);
                                        } else {
                                            tv_shopping_cart_number_now.setText("¥" + goodPrice);
                                        }
                                    } else {
                                        tv_shopping_cart_number_now.setText("¥0");
                                    }

                                } else {
                                    disCountP = goodPrice;

                                    if (disCountP.substring(0, 1).equals("¥")) {
                                        disCountP = disCountP.substring(1, disCountP.length());
                                    } else {
                                        disCountP = disCountP;
                                    }

                                    tv_shopping_cart_number_now.setText("¥" + Double.parseDouble(disCountP) * Double.parseDouble(disCount) / 10);

                                }

                                if (buyRules.equals("0")) {

                                    if (SP.get(PurchaseNowActivity.this, SpContent.IsQueenVip, "0").equals("0")) {
                                        tv_purchase_now_youhui.setText("已优惠¥0.00");
                                    } else {
                                        tv_purchase_now_youhui.setText("已优惠¥" + MD5.doubleToString(prica + ""));
                                    }
                                } else {
                                    tv_purchase_now_youhui.setText("已优惠¥0");
                                }

                            }
                        });

                        purchaseRedPacketAdapter = new PurchaseRedPacketAdapter(R.layout.purchase_red_packet_list_item, mineRedPacketBean.getBody().getRedPackets());
                        purchase_red_packet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        purchase_red_packet.setAdapter(purchaseRedPacketAdapter);

                        purchaseRedPacketAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                                cpMethod = "2";
                                cpId = "";
                                redPacketId = mineRedPacketBean.getBody().getRedPackets().get(position).getId();
                                tv_purchase_red_packet_name.setText(mineRedPacketBean.getBody().getRedPackets().get(position).getRedPacketTitle());
                                tv_purchase_red_packet_money.setText("-¥" + MD5.doubleToString(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney()));

                                String disCount_end = "10";
                                if (SP.get(PurchaseNowActivity.this, SpContent.IsQueenVip, "0").equals("0")) {
                                    disCount_end = "10";
                                } else {
                                    disCount_end = disCount;
                                }


                                if (Double.parseDouble(disCountP) * Double.parseDouble(disCount_end) / 10 >= Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney())) {
                                    double red_price = Double.parseDouble(disCountP) * Double.parseDouble(disCount_end) / 10 - Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney());
                                    tv_shopping_cart_number_now.setText("¥" + MD5.doubleToString(red_price + ""));
                                    double packet_price = Double.parseDouble(disCountP) - Double.parseDouble(disCountP) * Double.parseDouble(disCount_end) / 10 + Double.parseDouble(mineRedPacketBean.getBody().getRedPackets().get(position).getMoney());
                                    tv_purchase_now_youhui.setText("已优惠¥" + MD5.doubleToString(packet_price + ""));
                                } else {
                                    tv_shopping_cart_number_now.setText("¥0.00");
                                    tv_purchase_now_youhui.setText("已优惠¥" + Double.parseDouble(disCountP) * Double.parseDouble(disCount_end) / 10);
                                }


                            }
                        });
                    }
                } else {
                    T.show(mineRedPacketBean.getMsg());
                }
                break;
            case ACTION.GETMINEMODOU:
                MoDouBean moDouBean = GsonUtil.toObj(res, MoDouBean.class);
                if (moDouBean.isSuccess()) {
                    moDou = moDouBean.getBody().getMap().getPointsNow();
                    if (isBean.equals("")) {
                        cpMethod = "";
                        usePoints = "";
                        tv_purch_beannumber.setVisibility(View.GONE);
                    } else {
                        cpMethod = "";
                        usePoints = (int) Double.parseDouble(isBean) + "";
                        tv_purch_beannumber.setText("账户现有魔豆：" + moDou + "      本店所需魔豆：" + MD5.doubleToString(isBean + ""));
                    }
                } else {
                    T.show(moDouBean.getMsg());
                }
                break;
              /*
              是否支持女王卡支付
                    */
            case ACTION.CHECKQUEENCARD:
                loadingDialog.cancel();
                PurchaseCheckBean purchaseCheckBean = GsonUtil.toObj(res, PurchaseCheckBean.class);
                if (purchaseCheckBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
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
            /**
             * 立即购买
             */
            case ACTION.PAYNOWINPAYNew:

                PurchaseNowBean purchaseNowBean = GsonUtil.toObj(res, PurchaseNowBean.class);
                if (purchaseNowBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (purchaseNowBean.getErrorCode().equals("0")) {
                        String price_next = tv_shopping_cart_number_now.getText().toString();

                        if (Double.parseDouble(price_next.substring(1, price_next.length())) == 0) {
                            Intent intent = new Intent(PurchaseNowActivity.this, DealSuccessActivity.class);
                            intent.putExtra("payType", "4");
                            intent.putExtra("payMonet", "0.00");
                            intent.putExtra("payId", purchaseNowBean.getBody().getOrderId());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(PurchaseNowActivity.this, SubmitActivity.class);
                            intent.putExtra("businessIds", purchaseNowBean.getBody().getOrderId());
                            intent.putExtra("amount", tv_shopping_cart_number_now.getText().toString());
                            intent.putExtra("submitId", purchaseNowBean.getBody().getSubmitId());
                            startActivity(intent);
                        }
                        finish();
                    } else if (purchaseNowBean.getErrorCode().equals("1")) {
                        T.show(purchaseNowBean.getMsg());
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
