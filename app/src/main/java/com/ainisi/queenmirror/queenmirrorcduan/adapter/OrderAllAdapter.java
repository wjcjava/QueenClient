package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GetZxingBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.IsGpOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PurchaseCheckBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitPinTuanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundByCpgronpActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.OrderDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ScoreActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.bean.OrderNoBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.BitmapUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.DensityUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.ainisi.queenmirror.queenmirrorcduan.ui.order.fragment.WholeFragment.instance;

public class OrderAllAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean, BaseViewHolder> implements HttpCallBack {

    Context context;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderListBeanList = new ArrayList<>();

    OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean apiOrderDetailsListBean;

    OrderMyAllOrderBean.BodyBean.ApiOrderListBean end_next = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean();

    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data;
    String shopId, orderId;
    private String orderNo;
    private TextView order_tuikuan;
    private String goodId;
    private TextView textView;
    String amount = "0";
    String isCheckQueen;
    String isPay = "0";//0是付款   1是退款   2是取消
    String isGP = "false";
    String groupId;

    public OrderAllAdapter(Context context, int layoutResId, List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> data) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    public List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean> getdata() {
        return data;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(final BaseViewHolder helper, final OrderMyAllOrderBean.BodyBean.ApiOrderListBean item) {

        if (item.getIntfAnsShopBasic() == null) {

        } else {
            if (item.getIntfAnsShopBasic().getShopName() == null || item.getIntfAnsShopBasic().getShopName().toString().equals("")) {
            } else {
                helper.setText(R.id.tv_shangpin, item.getIntfAnsShopBasic().getShopName());
            }
        }

        helper.setOnClickListener(R.id.rl_orderlist_all, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("orderId", item.getIntfAnsOrder().getId());
                intent.putExtra("orderNo", item.getIntfAnsOrder().getOrderNo());

                if (item.getIntfAnsShopBasic() == null) {
                    intent.putExtra("orderTel", "");
                } else {
                    intent.putExtra("orderTel", item.getIntfAnsShopBasic().getServiceTel());
                }
                intent.putExtra("orderTime", item.getIntfAnsOrder().getOrderTime());
                intent.putExtra("orderState", item.getIntfAnsOrder().getOrderStatus());
                intent.putExtra("orderType", item.getIntfAnsOrder().getOrderType());
                if (item.getIntfAnsShopBasic() == null) {
                    intent.putExtra("shopId", "");
                } else {
                    intent.putExtra("shopId", item.getIntfAnsShopBasic().getId());
                }
                if (item.getIntfAnsOrder().getCpAmount() == null || item.getIntfAnsOrder().getCpAmount().equals("")) {
                    intent.putExtra("cpAmount", "0.00");
                } else {
                    intent.putExtra("cpAmount", item.getIntfAnsOrder().getCpAmount());
                }
                intent.putExtra("OrderHeji", item.getIntfAnsOrder().getAfterAmount() + "");
                intent.putExtra("lstBean", (Serializable) item.getIntfAnsOrder().getApiOrderDetailsList());
                context.startActivity(intent);
            }
        });

        ImageView img_title = helper.getView(R.id.img_title);

        if (item.getIntfAnsShopBasic() == null) {

        } else {

            if (item.getIntfAnsShopBasic().getShopLogo() == null) {

            } else {
                String shop_logo = item.getIntfAnsShopBasic().getShopLogo();
                String[] shop_logos = shop_logo.split(",");

                Glide.with(context).load(shop_logos[0]).placeholder(R.drawable.dismiss).into(img_title);
            }
        }

        if (item.getIntfAnsOrder() == null) {
        } else {
            //待接单
            switch (item.getIntfAnsOrder().getOrderType()) {
                //秒杀
                case "1":
                    helper.setVisible(R.id.tv_taocan_img, true);
                    helper.setImageDrawable(R.id.tv_taocan_img, ContextCompat.getDrawable(mContext, R.mipmap.seckill));
                    helper.setText(R.id.tv_order_tuikuan, "核单")
                            .setVisible(R.id.tv_order_tuikuan, true);
                    helper.setVisible(R.id.tv_order_again, false);
                    break;
                //特价
                case "3":
                    helper.setVisible(R.id.tv_taocan_img, true);
                    helper.setImageDrawable(R.id.tv_taocan_img, ContextCompat.getDrawable(mContext, R.mipmap.ordertejia));
                    helper.setText(R.id.tv_order_tuikuan, "核单")
                            .setVisible(R.id.tv_order_tuikuan, true);
                    helper.setVisible(R.id.tv_order_again, false);
                    break;
                default:
                    helper.setVisible(R.id.tv_taocan_img, false);
                    break;
            }
            if (item.getIntfAnsOrder().getOrderStatus().toString().equals("UP")) {
                //待付款
                helper.setText(R.id.tv_order_tuikuan, "付款")
                        .setGone(R.id.tv_order_tuikuan, false)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again, "取消")
                        .setGone(R.id.tv_order_again, false)
                        .setGone(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "待付款")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
                orderNo = item.getIntfAnsOrder().getOrderNo();
                goodId = item.getIntfAnsOrder().getId();
                order_tuikuan = helper.getView(R.id.tv_order_tuikuan);
                textView = helper.getView(R.id.tv_jiage);

                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        /**
                         * 付款
                         */
                        orderId = item.getIntfAnsOrder().getId();
                        amount = item.getIntfAnsOrder().getAfterAmount();
                        isPay = "0";
                        isGpOrder();
                    }
                });

                helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        /**
                         * 取消
                         */
                        orderId = item.getIntfAnsOrder().getId();
                        shopId = item.getIntfAnsShopBasic().getId();

                        isPay = "2";

                        isGpOrder();
                    }
                });
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("UT")) {
                //待接单
                switch (item.getIntfAnsOrder().getOrderType()) {
                    //普通
                    case "0":
                        if (!TextUtils.isEmpty(item.getIntfAnsOrder().getAfterAmount()) && Double.valueOf(item.getIntfAnsOrder().getAfterAmount()) != 0) {
                            helper.setText(R.id.tv_order_tuikuan, "退款")
                                    .setVisible(R.id.tv_order_tuikuan, true);
                            helper.setVisible(R.id.tv_order_again, true)
                                    .setText(R.id.tv_order_again, "核单");
                        } else {
                            helper.setText(R.id.tv_order_tuikuan, "核单")
                                    .setVisible(R.id.tv_order_tuikuan, true);
                            helper.setVisible(R.id.tv_order_again, false);
                        }
                        break;
                    //秒杀
                    case "1":
                        helper.setText(R.id.tv_order_tuikuan, "核单")
                                .setVisible(R.id.tv_order_tuikuan, true);
                        helper.setVisible(R.id.tv_order_again, false);
                        break;
                    default:
                        break;
                }
                helper.setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "待接单")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
                //核单
                helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderId = item.getIntfAnsOrder().getId();
                        getZxingData();
                    }
                });
                /**
                 * 退款
                 */
                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView view1 = helper.getView(R.id.tv_order_tuikuan);
                        if ("退款".equals(view1.getText().toString())) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            LayoutInflater inflater = LayoutInflater.from(mContext);
                            View v = inflater.inflate(R.layout.back_money_layout, null);
                            TextView tv_dialog_go = (TextView) v.findViewById(R.id.tv_dialog_go);
                            TextView tv_dialog_cancel = (TextView) v.findViewById(R.id.tv_dialog_cancel);
                            final Dialog dialog = builder.create();
                            dialog.show();
                            dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                            tv_dialog_go.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    isPay = "1";
                                    end_next = item;

                                    Intent intent = new Intent(context, ConfirmRefundActivity.class);

                                    apiOrderListBeanList = new ArrayList<>();
                                    for (int i = 0; i < end_next.getIntfAnsOrder().getApiOrderDetailsList().size(); i++) {
                                        apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                                        apiOrderDetailsListBean = end_next.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                                        apiOrderListBeanList.add(apiOrderDetailsListBean);
                                    }
                                    intent.putExtra("lstBean", (Serializable) apiOrderListBeanList);
                                    intent.putExtra("orderNo", end_next.getIntfAnsOrder().getOrderNo());
                                    intent.putExtra("orderId", end_next.getIntfAnsOrder().getId());
                                    intent.putExtra("shopId", end_next.getIntfAnsShopBasic().getId());
                                    context.startActivity(intent);
                                    // isGpOrder();

                                    dialog.dismiss();
                                }
                            });
                            tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });

                        } else if ("核单".equals(view1.getText().toString())) {
                            orderId = item.getIntfAnsOrder().getId();
                            getZxingData();
                        }
                    }
                });

            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("FT")) {
                //已接单
                //待接单
                switch (item.getIntfAnsOrder().getOrderType()) {
                    //普通
                    case "0":
                        helper.setVisible(R.id.tv_order_again, true)
                                .setText(R.id.tv_order_again, "退款")
                                .setVisible(R.id.tv_order_like, true)
                                .setText(R.id.tv_order_like, "核单");
                        break;
                    //秒杀
                    case "1":
                        helper.setVisible(R.id.tv_order_again, true)
                                .setText(R.id.tv_order_again, "核单")
                                .setVisible(R.id.tv_order_like, false);
                        break;
                    default:
                        break;
                }
                helper.setText(R.id.tv_order_tuikuan, "查看订单")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_submit, "已接单")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
                helper.setOnClickListener(R.id.tv_order_like, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderId = item.getIntfAnsOrder().getId();
                        getZxingData();
                    }
                });
                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OrderDetailActivity.class);
                        intent.putExtra("orderNo", item.getIntfAnsOrder().getOrderNo());
                        intent.putExtra("orderTel", item.getIntfAnsShopBasic().getServiceTel());
                        intent.putExtra("orderTime", item.getIntfAnsOrder().getOrderTime());
                        intent.putExtra("OrderHeji", item.getIntfAnsOrder().getAfterAmount() + "");
                        intent.putExtra("lstBean", (Serializable) item.getIntfAnsOrder().getApiOrderDetailsList());
                        intent.putExtra("orderId", item.getIntfAnsOrder().getId());
                        intent.putExtra("orderState", item.getIntfAnsOrder().getOrderStatus());
                        intent.putExtra("shopId", item.getIntfAnsShopBasic().getId());
                        intent.putExtra("orderType", item.getIntfAnsOrder().getOrderType());
                        context.startActivity(intent);
                    }
                });

                /**
                 * 退款
                 */
                helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView view1 = helper.getView(R.id.tv_order_again);
                        if ("退款".equals(view1.getText().toString())) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            LayoutInflater inflater = LayoutInflater.from(mContext);
                            View v = inflater.inflate(R.layout.back_money_layout, null);
                            TextView tv_dialog_go = (TextView) v.findViewById(R.id.tv_dialog_go);
                            TextView tv_dialog_cancel = (TextView) v.findViewById(R.id.tv_dialog_cancel);
                            final Dialog dialog = builder.create();
                            dialog.show();
                            dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                            tv_dialog_go.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    isPay = "1";
                                    end_next = item;
                                    isGpOrder();
                                    dialog.dismiss();

                                }
                            });
                            tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                        } else if ("核单".equals(view1.getText().toString())) {
                            orderId = item.getIntfAnsOrder().getId();
                            getZxingData();
                        }
                    }
                });

            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("US")) {
                switch (item.getIntfAnsOrder().getOrderType()) {
                    //普通
                    case "0":
                        helper.setVisible(R.id.tv_order_again, true);
                        break;
                    //秒杀
                    case "1":
                        helper.setVisible(R.id.tv_order_again, false);
                        break;
                    default:
                        break;
                }
                //待服务
                helper.setText(R.id.tv_order_tuikuan, "查看订单")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again, "退款")
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "待服务")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, OrderDetailActivity.class);
                        intent.putExtra("orderNo", item.getIntfAnsOrder().getOrderNo());
                        intent.putExtra("orderTel", item.getIntfAnsShopBasic().getServiceTel());
                        intent.putExtra("orderTime", item.getIntfAnsOrder().getOrderTime());
                        intent.putExtra("OrderHeji", item.getIntfAnsOrder().getAfterAmount() + "");
                        intent.putExtra("lstBean", (Serializable) item.getIntfAnsOrder().getApiOrderDetailsList());
                        intent.putExtra("orderId", item.getIntfAnsOrder().getId());
                        intent.putExtra("orderState", item.getIntfAnsOrder().getOrderStatus());
                        intent.putExtra("shopId", item.getIntfAnsShopBasic().getId());
                        intent.putExtra("orderType", item.getIntfAnsOrder().getOrderType());
                        context.startActivity(intent);
                    }
                });

                /**
                 * 退款
                 */
                helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        LayoutInflater inflater = LayoutInflater.from(mContext);
                        View v = inflater.inflate(R.layout.back_money_layout, null);
                        TextView tv_dialog_go = (TextView) v.findViewById(R.id.tv_dialog_go);
                        TextView tv_dialog_cancel = (TextView) v.findViewById(R.id.tv_dialog_cancel);
                        final Dialog dialog = builder.create();
                        dialog.show();
                        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                        tv_dialog_go.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                isPay = "1";
                                end_next = item;
                                isGpOrder();

                                dialog.dismiss();
                            }
                        });
                        tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                    }
                });

            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("UF")) {
                //待确认
                helper.setText(R.id.tv_order_tuikuan, "完成服务")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "正在服务")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, true);
                /**
                 * 这里需要添加待确认
                 */

                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /**
                         * 确认服务
                         */
                        orderId = item.getIntfAnsOrder().getId();
                        ConfimServiceData();
                    }
                });
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("FN")) {
                //已完成
                helper.setGone(R.id.tv_order_tuikuan, false)
                        .setGone(R.id.tv_order_again, false)
                        .setGone(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "已完成")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("UC")) {
                //待评价
                helper.setText(R.id.tv_order_tuikuan, "去评价")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "待评价")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);
                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /**
                         * 评价页面
                         */
                        Intent intent = new Intent(context, ScoreActivity.class);
                        intent.putExtra("apiOrderListBeanList", (Serializable) item.getIntfAnsOrder().getApiOrderDetailsList());
                        intent.putExtra("shopName", item.getIntfAnsShopBasic().getShopName());
                        intent.putExtra("shopId", item.getIntfAnsShopBasic().getId());
                        intent.putExtra("orderId", item.getIntfAnsOrder().getId());
                        //待接单
                        switch (item.getIntfAnsOrder().getOrderType()) {
                            //普通
                            case "0":
                                intent.putExtra("ordertype", true);
                                break;
                            //秒杀
                            case "1":
                                intent.putExtra("ordertype", false);
                                break;
                            default:
                                break;
                        }
                        instance.startActivityForResult(intent, 1);
                    }
                });
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("CA")) {
                //已取消
                helper.setGone(R.id.tv_order_tuikuan, false)
                        .setGone(R.id.tv_order_again, false)
                        .setGone(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "已取消")
                        .setVisible(R.id.tv_submit, true)
                        .setGone(R.id.tv_order_new, false);

            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("PR")) {
                //部分退款中
                helper.setText(R.id.tv_order_tuikuan, "部分退款中")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again, "取消")
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "部分退款中")
                        .setGone(R.id.tv_order_new, false)
                        .setVisible(R.id.tv_submit, true);
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("PF")) {
                //部分已退款
                helper.setText(R.id.tv_order_tuikuan, "部分已退款")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "部分已退款")
                        .setGone(R.id.tv_order_new, false)
                        .setVisible(R.id.tv_submit, true);
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("RA")) {
                //退款中
                helper.setText(R.id.tv_order_tuikuan, "退款中")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setBackgroundRes(R.id.tv_order_tuikuan, R.drawable.button_shap_queen)
                        .setTextColor(R.id.tv_order_tuikuan, context.getResources().getColor(R.color.white))
                        .setText(R.id.tv_order_again, "取消")
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "退款中")
                        .setGone(R.id.tv_order_new, false)
                        .setGone(R.id.tv_submit, true);

                helper.setOnClickListener(R.id.tv_order_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        orderId = item.getIntfAnsOrder().getId();
                        shopId = item.getIntfAnsShopBasic().getId();

                        CancelOrderData();
                    }
                });
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("RF")) {
                //已退款
                helper.setGone(R.id.tv_order_tuikuan, false)
                        .setGone(R.id.tv_order_again, false)
                        .setGone(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "已退款")
                        .setGone(R.id.tv_order_new, false)
                        .setVisible(R.id.tv_submit, true);
            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("PT")) {
                /**
                 * 拼团中
                 */
                //退款中
                helper.setText(R.id.tv_order_tuikuan, "退款")
                        .setVisible(R.id.tv_order_tuikuan, true)
                        .setVisible(R.id.tv_order_again, false)
                        .setVisible(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "拼团中")
                        .setGone(R.id.tv_order_new, false)
                        .setVisible(R.id.tv_submit, true);


                helper.setOnClickListener(R.id.tv_order_tuikuan, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        LayoutInflater inflater = LayoutInflater.from(mContext);
                        View v = inflater.inflate(R.layout.back_money_layout, null);
                        TextView tv_dialog_go = (TextView) v.findViewById(R.id.tv_dialog_go);
                        TextView tv_dialog_cancel = (TextView) v.findViewById(R.id.tv_dialog_cancel);
                        final Dialog dialog = builder.create();
                        dialog.show();
                        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                        tv_dialog_go.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                isPay = "1";
                                end_next = item;
                                orderNo = item.getIntfAnsOrder().getOrderNo();
                                isGpOrder();

                                dialog.dismiss();

                            }
                        });
                        tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                    }
                });


            } else if (item.getIntfAnsOrder().getOrderStatus().toString().equals("FD")) {
                //已过期
                helper.setGone(R.id.tv_order_tuikuan, false)
                        .setGone(R.id.tv_order_again, false)
                        .setGone(R.id.tv_order_like, false)
                        .setText(R.id.tv_submit, "已过期")
                        .setGone(R.id.tv_order_new, false)
                        .setVisible(R.id.tv_submit, true);
            }

            List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderDetailsList = item.getIntfAnsOrder().getApiOrderDetailsList();

            if (apiOrderDetailsList.size() == 0) {

            } else if (apiOrderDetailsList.size() == 1) {
                helper.setText(R.id.tv_taocan, apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView19, "X " + apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setVisible(R.id.tv_taocan, true)
                        .setVisible(R.id.textView19, true)
                        .setGone(R.id.tv_xijian, false)
                        .setGone(R.id.tv_tangran, false)
                        .setGone(R.id.textView29, false)
                        .setGone(R.id.textView30, false);

            } else if (apiOrderDetailsList.size() == 2) {
                helper.setText(R.id.tv_taocan, apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView19, "X " + apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian, apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView29, "X " + apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setVisible(R.id.tv_taocan, true)
                        .setVisible(R.id.textView19, true)
                        .setVisible(R.id.tv_xijian, true)
                        .setVisible(R.id.textView29, true)
                        .setGone(R.id.tv_tangran, false)
                        .setGone(R.id.textView30, false);

            } else if (apiOrderDetailsList.size() == 3) {
                helper.setText(R.id.tv_taocan, apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView19, "X " + apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian, apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView29, "X " + apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran, apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView30, "X " + apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setVisible(R.id.tv_taocan, true)
                        .setVisible(R.id.textView19, true)
                        .setVisible(R.id.tv_xijian, true)
                        .setVisible(R.id.textView29, true)
                        .setVisible(R.id.tv_tangran, true)
                        .setVisible(R.id.textView30, true);
            } else {
                helper.setText(R.id.tv_taocan, apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView19, "X " + apiOrderDetailsList.get(0).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_xijian, apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView29, "X " + apiOrderDetailsList.get(1).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setText(R.id.tv_tangran, apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getGoodsName())
                        .setText(R.id.textView30, "X " + apiOrderDetailsList.get(2).getIntfAnsOrderDetails().getPurchaseNumber())
                        .setVisible(R.id.tv_taocan, true)
                        .setVisible(R.id.textView19, true)
                        .setVisible(R.id.tv_xijian, true)
                        .setVisible(R.id.textView29, true)
                        .setVisible(R.id.tv_tangran, true)
                        .setVisible(R.id.textView30, true);
            }
            switch (item.getIntfAnsOrder().getOrderType()) {
                //普通
                case "0":
                    if (apiOrderDetailsList.size() > 3) {
                        if (Double.parseDouble(item.getIntfAnsOrder().getAfterAmount()) >= 0) {
                            helper.setText(R.id.tv_head, "...                        共" + apiOrderDetailsList.size() + "个，商品实付")
                                    .setText(R.id.tv_jiage, "¥" + MD5.doubleToString(item.getIntfAnsOrder().getAfterAmount()));
                        } else {
                            helper.setText(R.id.tv_head, "...                        共" + apiOrderDetailsList.size() + "个，商品实付")
                                    .setText(R.id.tv_jiage, "¥0.00");
                        }

                    } else {
                        if (item.getIntfAnsOrder().getAfterAmount() == null) {
                            helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                    .setText(R.id.tv_jiage, "¥0.00");
                        } else {
                            if (Double.parseDouble(item.getIntfAnsOrder().getAfterAmount()) >= 0) {
                                helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                        .setText(R.id.tv_jiage, "¥" + MD5.doubleToString(item.getIntfAnsOrder().getAfterAmount()));
                            } else {
                                helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                        .setText(R.id.tv_jiage, "¥0.00");
                            }
                        }
                    }
                    break;
                //秒杀
                case "1":
                    helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个商品，")
                            .setText(R.id.tv_jiage, "实付金额参考套餐价格");
                    break;
                //团购
                case "2":
                    if (Double.parseDouble(item.getIntfAnsOrder().getAfterAmount()) >= 0) {
                        helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                .setText(R.id.tv_jiage, "¥" + MD5.doubleToString(item.getIntfAnsOrder().getAfterAmount()));
                    } else {
                        helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                .setText(R.id.tv_jiage, "¥0.00");
                    }
                    break;
                //特价
                case "3":
                    if (Double.parseDouble(item.getIntfAnsOrder().getAfterAmount()) >= 0) {
                        helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                .setText(R.id.tv_jiage, "¥" + MD5.doubleToString(item.getIntfAnsOrder().getAfterAmount()));
                    } else {
                        helper.setText(R.id.tv_head, "共" + apiOrderDetailsList.size() + "个，商品实付")
                                .setText(R.id.tv_jiage, "¥0.00");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 获取二维码数据内容
     */
    private void getZxingData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("custId", SP.get(context, SpContent.UserId, "") + "");
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETZXING, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 查看是否是拼团订单
     */
    private void isGpOrder() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderNo", orderNo);
        params.put("userId", SP.get(context, SpContent.UserId, "0").toString());
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ISGPORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 确认服务完成
     */
    private void ConfimServiceData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("userId", SP.get(context, SpContent.UserId, "0").toString());
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CONFIMSERVICE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消订单
     */
    private void CancelOrderData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("shopId", shopId);
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CANCLEORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消拼团订单
     */
    private void CancelGPOrderData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("shopId", shopId);
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GPCANCELORDER, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 待付款订单付款前的校验
     */
    private void shopPayCheck() {
        HashMap<String, String> params = new HashMap<>();
        params.put("orderNo", orderNo);
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.SHOPPAYCHECK, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 查看是否是拼团订单
             */
            case ACTION.ISGPORDER:
                IsGpOrderBean isGpOrderBean = GsonUtil.toObj(res, IsGpOrderBean.class);
                if (isGpOrderBean.isSuccess()) {
                    if (isGpOrderBean.getBody().isIsGporder()) {
                        /**
                         * 是拼团订单
                         */

                        if (isPay.equals("0")) {
                            /**
                             * 付款
                             */
                            isGP = "true";
                            groupId = isGpOrderBean.getBody().getGroupId();
                            shopPayCheck();
                        } else if (isPay.equals("1")) {
                            /**
                             * 退款
                             */

                            apiOrderListBeanList = new ArrayList<>();

                            Intent intent = new Intent(context, ConfirmRefundByCpgronpActivity.class);

                            for (int i = 0; i < end_next.getIntfAnsOrder().getApiOrderDetailsList().size(); i++) {
                                apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                                apiOrderDetailsListBean = end_next.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                                apiOrderListBeanList.add(apiOrderDetailsListBean);
                            }
                            intent.putExtra("lstBean", (Serializable) apiOrderListBeanList);
                            intent.putExtra("orderNo", end_next.getIntfAnsOrder().getOrderNo());
                            intent.putExtra("orderId", end_next.getIntfAnsOrder().getId());
                            intent.putExtra("shopId", end_next.getIntfAnsShopBasic().getId());
                            context.startActivity(intent);
                        } else if (isPay.equals("2")) {
                            /**
                             * 取消
                             */
                            CancelGPOrderData();
                        }

                    } else {
                        /**
                         * 不是拼团订单
                         */
                        if (isPay.equals("0")) {
                            /**
                             * 付款
                             */
                            isGP = "false";
                            shopPayCheck();
                        } else if (isPay.equals("1")) {
                            /**
                             * 退款
                             */

                            apiOrderListBeanList = new ArrayList<>();

                            Intent intent = new Intent(context, ConfirmRefundActivity.class);
                            apiOrderListBeanList = new ArrayList<>();
                            for (int i = 0; i < end_next.getIntfAnsOrder().getApiOrderDetailsList().size(); i++) {
                                apiOrderDetailsListBean = new OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean();
                                apiOrderDetailsListBean = end_next.getIntfAnsOrder().getApiOrderDetailsList().get(i);
                                apiOrderListBeanList.add(apiOrderDetailsListBean);
                            }
                            intent.putExtra("lstBean", (Serializable) apiOrderListBeanList);
                            intent.putExtra("orderNo", end_next.getIntfAnsOrder().getOrderNo());
                            intent.putExtra("orderId", end_next.getIntfAnsOrder().getId());
                            intent.putExtra("shopId", end_next.getIntfAnsShopBasic().getId());
                            context.startActivity(intent);
                        } else if (isPay.equals("2")) {
                            /**
                             * 取消
                             */
                            CancelOrderData();
                        }
                    }
                } else {
                    T.show(isGpOrderBean.getMsg());
                }
                break;
            /**
             * 取消拼团订单
             */
            case ACTION.GPCANCELORDER:
                SuccessBean successBeans = GsonUtil.toObj(res, SuccessBean.class);
                if (successBeans.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (successBeans.isSuccess()) {
                        T.show("取消成功");
                    } else {
                        T.show(successBeans.getMsg());
                    }
                }
                break;
            /**
             * 取消订单
             */
            case ACTION.CANCLEORDER:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
                        T.show("取消成功");
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            case ACTION.CONFIMSERVICE:
                SuccessBean successBeanss = GsonUtil.toObj(res, SuccessBean.class);
                if (successBeanss.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (successBeanss.isSuccess()) {
                        T.show("确认成功");
                    } else {
                        T.show(successBeanss.getMsg());
                    }
                }
                break;
            /**
             * 待付款订单付款前的校验
             */
            case ACTION.SHOPPAYCHECK:
                final OrderNoBean orderNoBean = GsonUtil.toObj(res, OrderNoBean.class);
                if (orderNoBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (orderNoBean.getErrorCode().equals("0")) {

                        if (isGP.equals("true")) {
                            Intent intent = new Intent(context, SubmitPinTuanActivity.class);
                            intent.putExtra("businessIds", goodId);
                            intent.putExtra("amount", amount + "");
                            intent.putExtra("groupId", orderId + "");
                            intent.putExtra("groupIds", groupId);
                            context.startActivity(intent);
                        } else {
                            Intent intent = new Intent(context, SubmitActivity.class);
                            intent.putExtra("businessIds", goodId);
                            intent.putExtra("amount", amount + "");
                            context.startActivity(intent);
                        }
                    } else if (orderNoBean.getErrorCode().equals("1")) {
                        //待付款订单付款前的校验
                        T.show(orderNoBean.getMsg());
                    }
                }
                break;
            /**
             * 是否支持女王卡支付
             */
            case ACTION.CHECKQUEENCARD:
                PurchaseCheckBean purchaseCheckBean = GsonUtil.toObj(res, PurchaseCheckBean.class);
                if (purchaseCheckBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
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
            //二维码
            case ACTION.GETZXING:
                GetZxingBean getZxingBean = GsonUtil.toObj(res, GetZxingBean.class);
                if (getZxingBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (getZxingBean.isSuccess() && "0".equals(getZxingBean.getErrorCode())) {
                        setDialog(getZxingBean);
                    } else {
//                        T.show(getZxingBean.getMsg());
                        setDialog();
                    }
                }
                break;
            default:
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
     * 核单ImageDialig
     *
     * @param getZxingBean
     */
    private void setDialog(GetZxingBean getZxingBean) {
        final Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_orderall, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ImageView dialog_orderall_cancel = view.findViewById(R.id.dialog_orderall_cancel);
        ImageView dialog_orderall_img = view.findViewById(R.id.dialog_orderall_img);
        dialog_orderall_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Bitmap bitmap = null;
        try {
            bitmap = BitmapUtils.makeQRImage(getZxingBean.getBody().getCustOrderQrGet() + "," + orderId, DensityUtils.dp2px(context, 230), DensityUtils.dp2px(context, 230));
            dialog_orderall_img.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 核单ImageDialig
     *
     * @param
     */
    private void setDialog() {
        final Dialog dialog = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_orderall_cancel, null);
        ImageView order_cancel = view.findViewById(R.id.order_cancel);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        order_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
