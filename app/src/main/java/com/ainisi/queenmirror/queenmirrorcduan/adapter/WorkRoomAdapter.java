package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopSalesProduct;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 * <p>
 * jl
 */

public class WorkRoomAdapter extends BaseAdapter implements HttpCallBack {
    private final LayoutInflater inflater;
    private Context context;
    String queenShopDiscount, isQueenCard;
    List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList = new ArrayList<>();

    int pos_cart;
    private String[] split;
    String isPintuan;

    public WorkRoomAdapter(Context context, List<ShopSalesProduct.BodyBean.ApiGoodsListBean> apiGoodsList, String isQueenCard, String queenShopDiscount) {
        this.context = context;
        this.apiGoodsList = apiGoodsList;
        this.queenShopDiscount = queenShopDiscount;
        this.isQueenCard = isQueenCard;
        inflater = LayoutInflater.from(context);
    }

    public void Clear() {
        apiGoodsList.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopSalesProduct.BodyBean.ApiGoodsListBean> ShopListData) {
        this.apiGoodsList = ShopListData;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return apiGoodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.re_workroom_short, parent, false);

            holder.tv_weorkroom_title = convertView.findViewById(R.id.tv_weorkroom_title);
            holder.tv_weorkroom_name = convertView.findViewById(R.id.tv_weorkroom_name);
            holder.tv_workroom_service_time = convertView.findViewById(R.id.tv_workroom_service_time);
            holder.tv_browse = convertView.findViewById(R.id.tv_browse);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            holder.tv_workroom_service_price = convertView.findViewById(R.id.tv_workroom_service_price);
            holder.iv_workroom_add_cat = convertView.findViewById(R.id.iv_workroom_add_cat);
            holder.rl_workroom_list = convertView.findViewById(R.id.rl_workroom_list);
            holder.iv_weorkroom_title = convertView.findViewById(R.id.iv_weorkroom_title);
            holder.tv_fabulous = convertView.findViewById(R.id.tv_fabulous);
            holder.buy_workroom_only_one = convertView.findViewById(R.id.buy_workroom_only_one);
            holder.tv_workroom_bean_number = convertView.findViewById(R.id.tv_workroom_bean_number);
            holder.iv_workroom_pintuan = convertView.findViewById(R.id.iv_workroom_pintuan);
            holder.tv_workroom_discount = convertView.findViewById(R.id.tv_workroom_discount);
            holder.tv_workroom_pintuan = convertView.findViewById(R.id.tv_workroom_pintuan);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.buy_workroom_only_one.setVisibility(View.VISIBLE);
        holder.tv_workroom_bean_number.setVisibility(View.VISIBLE);

        holder.tv_weorkroom_title.setText(apiGoodsList.get(position).getEcGoodsBasic().getGoodsName());
        holder.tv_weorkroom_name.setText(apiGoodsList.get(position).getEcGoodsBasic().getGoodsBrief());
        holder.tv_workroom_service_time.setText(apiGoodsList.get(position).getEcGoodsBasic().getServiceTime());

        if (apiGoodsList.get(position).getEcGoodsBrowses() == null) {
            holder.tv_browse.setText("浏览0次");
        } else {
            if (apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() == null) {
                holder.tv_browse.setText("浏览0次");
            } else {
                holder.tv_browse.setText("浏览" + apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() + "次");
            }
        }

        String praiseRate;
        if (apiGoodsList.get(position).getPraiseRate() == null || apiGoodsList.get(position).getPraiseRate().equals("")) {
            praiseRate = "1";
        } else {
            praiseRate = apiGoodsList.get(position).getPraiseRate();
        }
        double rate = Double.parseDouble(praiseRate) * 100;
        holder.tv_fabulous.setText("好评率" + rate + "%");

        String price = MD5.doubleToString(apiGoodsList.get(position).getEcGoodsBasic().getSalesPrice());
        String price1 = MD5.doubleToString(apiGoodsList.get(position).getEcGoodsBasic().getMarketPrice());
        holder.tv_price.setText("¥" + price);
        holder.tv_workroom_service_price.setText("¥" + price1);
        holder.tv_workroom_service_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


        if (apiGoodsList.get(position).getEcGoodsBasic().getGoodsThumb() == null) {
        } else {
            split = apiGoodsList.get(position).getEcGoodsBasic().getGoodsThumb().split(",");
            Glide.with(context).load(split[0]).placeholder(R.drawable.dismiss).into(holder.iv_weorkroom_title);
        }

        isPintuan = apiGoodsList.get(position).getEcGoodsBasic().getGroupGoods();
        if ("1".equals(isPintuan)) {
            holder.iv_workroom_pintuan.setVisibility(View.VISIBLE);
            holder.tv_workroom_pintuan.setVisibility(View.VISIBLE);
            holder.iv_workroom_add_cat.setVisibility(View.GONE);

            holder.buy_workroom_only_one.setVisibility(View.VISIBLE);
            holder.buy_workroom_only_one.setText("限拼一次");
        } else {
            if (apiGoodsList.get(position).getEcGoodsBasic().getBuyRule().equals("0")) {
                holder.buy_workroom_only_one.setVisibility(View.GONE);
            } else {
                holder.buy_workroom_only_one.setVisibility(View.VISIBLE);
            }

            holder.iv_workroom_pintuan.setVisibility(View.GONE);
            holder.tv_workroom_pintuan.setVisibility(View.GONE);
            holder.iv_workroom_add_cat.setVisibility(View.VISIBLE);

            if (isQueenCard.equals("0")) {
                holder.tv_workroom_discount.setVisibility(View.GONE);
            } else if (isQueenCard.equals("1")) {
                holder.tv_workroom_discount.setVisibility(View.VISIBLE);
                if (apiGoodsList.get(position).getEcGoodsBasic().getBuyRule().equals("0")) {
                    String memberPrice = MD5.doubleToString(Double.parseDouble(price) * Double.parseDouble(queenShopDiscount) / 10 + "");
                    holder.tv_workroom_discount.setText("女王会员立减：¥" + MD5.doubleToString((Double.parseDouble(price) - Double.parseDouble(memberPrice)) + ""));
                } else {
                    holder.tv_workroom_discount.setVisibility(View.GONE);
                }
            }
        }

        holder.iv_workroom_add_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pos_cart = position;
                if (SP.get(context, SpContent.isLogin, "0").toString().equals("1")) {
                    AddCatData();
                } else {
                    T.show("请您先登录APP");
                    Intent intentc = new Intent(context, LoginActivity.class);
                    intentc.putExtra("activite", "no");
                    context.startActivity(intentc);
                }
            }
        });

        if (apiGoodsList.get(position).getEcGoodsBasic().getPointRule() == null || apiGoodsList.get(position).getEcGoodsBasic().getPointRule().equals("")) {
            holder.tv_workroom_bean_number.setVisibility(View.GONE);
        } else {
            holder.tv_workroom_bean_number.setText("另需支付魔豆：" + MD5.doubleToString(apiGoodsList.get(position).getEcGoodsBasic().getPointRule()));
        }

        holder.rl_workroom_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isPintuan = apiGoodsList.get(position).getEcGoodsBasic().getGroupGoods();

                if (isPintuan.equals("1")) {
                    /**
                     * 这里需要传商品的相关信息的？
                     */
                    Intent intent = new Intent(context, FightaloneActivity.class);
                    intent.putExtra("activityId", apiGoodsList.get(position).getEcGoodsBasic().getActivityId());
                    intent.putExtra("goodsName", apiGoodsList.get(position).getEcGoodsBasic().getGoodsName());
                    intent.putExtra("goodsId", apiGoodsList.get(position).getEcGoodsBasic().getId());
                    intent.putExtra("goodsBrief", apiGoodsList.get(position).getEcGoodsBasic().getGoodsBrief());
                    intent.putExtra("goodsService", apiGoodsList.get(position).getEcGoodsBasic().getServiceTime());
                    intent.putExtra("goodsSales", apiGoodsList.get(position).getEcGoodsBasic().getSalesPrice());
                    intent.putExtra("goodsGroup", apiGoodsList.get(position).getEcGoodsBasic().getGroupPrice());

                    if (apiGoodsList.get(position).getEcGoodsBrowses() == null || apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() == null || apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts().equals("")) {
                        intent.putExtra("number", "0");
                    } else {
                        intent.putExtra("number", apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() + "");
                    }

                    if (apiGoodsList.get(position).getEcGoodsBasic().getMarketPrice() == null) {
                        intent.putExtra("goodsMarket", "0");
                    } else {
                        intent.putExtra("goodsMarket", apiGoodsList.get(position).getEcGoodsBasic().getMarketPrice());

                    }
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, FullActivity.class);
                    intent.putExtra("goodsId", apiGoodsList.get(position).getEcGoodsBasic().getId() + "");
                    intent.putExtra("shopId", apiGoodsList.get(position).getEcGoodsBasic().getShopId() + "");
                    intent.putExtra("shopName", apiGoodsList.get(position).getShopIdName());
                    intent.putExtra("activityId", apiGoodsList.get(position).getEcGoodsBasic().getActivityId());
                    if (apiGoodsList.get(position).getEcGoodsBrowses() == null || apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() == null || apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts().equals("")) {
                        intent.putExtra("number", "0");
                    } else {
                        intent.putExtra("number", apiGoodsList.get(position).getEcGoodsBrowses().getBrowseCounts() + "");
                    }

                    if (apiGoodsList.get(position).getEcGoodsBasic() == null || apiGoodsList.get(position).getEcGoodsBasic().getGoodsThumb() == null) {
                        intent.putExtra("shopLogo", "");
                    } else {
                        split = apiGoodsList.get(position).getEcGoodsBasic().getGoodsThumb().split(",");
                        intent.putExtra("shopLogo", split[0]);
                    }

                    context.startActivity(intent);
                }

            }
        });

        return convertView;
    }

    /**
     * 添加购物车
     */
    private void AddCatData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(context, SpContent.UserId, "").toString());//
        params.put("goodsId", apiGoodsList.get(pos_cart).getEcGoodsBasic().getId());
        params.put("unitPrice", Double.parseDouble(apiGoodsList.get(pos_cart).getEcGoodsBasic().getSalesPrice()) + "");
        params.put("purchaseNumber", "1");
        params.put("token", SP.get(context, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ADDTOCAT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.ADDTOCAT:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    context.startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
                        T.show("加入购物车成功");
                        WorkRoomDetailActivity.instance.getShopCartData();
                        T.show("已成功添加到购物车");
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

    //就是View的持有
    public final class ViewHolder {
        private LinearLayout li_home_short;
        private TextView tv_weorkroom_title;
        private TextView tv_weorkroom_name;
        private TextView tv_workroom_service_time;
        private TextView tv_browse;
        private TextView tv_price;
        private TextView tv_workroom_service_price;
        private ImageView iv_workroom_add_cat;
        private RelativeLayout rl_workroom_list;
        private ImageView iv_weorkroom_title;
        private TextView tv_fabulous;
        private TextView buy_workroom_only_one;
        private TextView tv_workroom_bean_number;
        private ImageView iv_workroom_pintuan;
        private TextView tv_workroom_discount;
        private TextView tv_workroom_pintuan;
    }
}
