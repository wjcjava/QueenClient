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
import com.ainisi.queenmirror.queenmirrorcduan.bean.PayPurchaseBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PurchaseSelectActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 *
 *              jl
 */

public class  PurchaseListViewAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShoppingCartBean.BodyBean.ShopListBean> shopList = new ArrayList<>();
    int flag = 0;
    private boolean moudou = false;
    double pointRules=0;
    List<PayPurchaseBean> payPurchaseBeanList = new ArrayList<>();
    int moDou;
    boolean isTejia  = false;

    public PurchaseListViewAdapter(Context context,List<ShoppingCartBean.BodyBean.ShopListBean> shopList,List<PayPurchaseBean> payPurchaseBeanList,int moDou) {
        this.context = context;
        this.shopList = shopList;
        this.payPurchaseBeanList = payPurchaseBeanList;
        this.moDou = moDou;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return shopList.size();
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
            convertView = inflater.inflate(R.layout.item_purchase, parent, false);
            holder.li_purchase_product = convertView.findViewById(R.id.li_purchase_product);
            holder.purchase_shop_name = convertView.findViewById(R.id.purchase_shop_name);
            holder.rl_purchase_select = convertView.findViewById(R.id.rl_purchase_select);
            holder.tv_pur_youhui = convertView.findViewById(R.id.tv_pur_youhui);
            holder.tv_pur_modou = convertView.findViewById(R.id.tv_pur_modou);
            holder.tv_pur_selectname = convertView.findViewById(R.id.tv_pur_selectname);
            holder.rl_purchase_new_top = convertView.findViewById(R.id.rl_purchase_new_top);
            holder.tv_purch_beannumber = convertView.findViewById(R.id.tv_purch_beannumber);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(flag < shopList.size()){
            for(int i = 0;i<shopList.get(position).getApiAnsCustCartList().size();i++) {
                // 2、获取组件，设置组件属性
                View _view = LayoutInflater.from(context).inflate(R.layout.layout_upload_product, null);
                // 3、在布局中添加组件，设置组件属性
                holder.li_purchase_product.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                TextView tv_purchase_name = _view.findViewById(R.id.tv_purchase_name);
                tv_purchase_name.setText(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsName());

                ImageView iv_purchase_title = _view.findViewById(R.id.iv_purchase_title);

                if(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsThumb() == null){

                }else {
                    String good_thumb = shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getGoodsThumb();
                    String[] goodThumb = good_thumb.split(",");
                    Glide.with(context).load(goodThumb[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_purchase_title);
                }

                TextView tv_purchase_presentprice = _view.findViewById(R.id.tv_purchase_presentprice);
                NumberFormat nf = NumberFormat.getInstance();
                String price = Double.parseDouble(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getSalesPrice())+"";
                String price1 = nf.format(Double.parseDouble(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getMarketPrice()))+"";
                tv_purchase_presentprice.setText("¥"+MD5.doubleToString(price));
                TextView tv_purchase_originalprice = _view.findViewById(R.id.tv_purchase_originalprice);
                tv_purchase_originalprice.setText("¥"+price1);
                tv_purchase_originalprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
                TextView tv_purchase_adapter_number = _view.findViewById(R.id.tv_purchase_adapter_number);
                tv_purchase_adapter_number.setText("X"+shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getPurchaseNumber());

                TextView buy_workroom_only_one = _view.findViewById(R.id.buy_workroom_only_one);
                if(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getBuyRule().equals("1")){
                    buy_workroom_only_one.setVisibility(View.VISIBLE);
                    isTejia = true;
                }else{
                    buy_workroom_only_one.setVisibility(View.INVISIBLE);
                }

                /**
                 * 判断是否为女王会员店
                 */
                TextView tv_purchase_discount = _view.findViewById(R.id.tv_purchase_discount);
                if(shopList.get(position).getQueenCard().equals("1")){

                    if(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getBuyRule().equals("1")){
                        tv_purchase_discount.setText("特价商品不参与优惠券满减");
                    }else{
                        tv_purchase_discount.setVisibility(View.VISIBLE);
                        String disCount = shopList.get(position).getQueenShopDiscount();
                        String memberPrice = MD5.doubleToString((Double.parseDouble(price)*Double.parseDouble(disCount)/10)+"");
                        tv_purchase_discount.setText("女王会员立减：¥"+MD5.doubleToString((Double.parseDouble(price)-Double.parseDouble(memberPrice))+""));
                    }
                }else{
                    tv_purchase_discount.setVisibility(View.INVISIBLE);
                }

                String pointRule;

                TextView tv_purchase_bean_number = _view.findViewById(R.id.tv_purchase_bean_number);
                if(shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getPointRule() == null||shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getPointRule().equals("")){
                    pointRule = "0";
                    tv_purchase_bean_number.setVisibility(View.INVISIBLE);
                }else{
                    pointRule = shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getPointRule();
                    tv_purchase_bean_number.setVisibility(View.VISIBLE);
                }

                tv_purchase_bean_number.setText("所需魔豆："+Double.parseDouble(pointRule) * Integer.parseInt(shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getPurchaseNumber()));
                pointRules =  pointRules + Double.parseDouble(pointRule) * Integer.parseInt(shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getPurchaseNumber());

                if(i == shopList.get(position).getApiAnsCustCartList().size()-1){
                    if(pointRules == 0){
                        holder.tv_purch_beannumber.setVisibility(View.GONE);
                    }else{
                        holder.tv_purch_beannumber.setText("账户现有魔豆："+moDou+"      本店所需魔豆："+ MD5.doubleToString(pointRules+""));
                    }
                    pointRules = 0;
                }
            }
            flag++;
        }else{

        }

        if(shopList.get(position).getApiAnsCustCartList().size() < 1){

            /**
             * 这里是所有的子菜单都不显示了
             */
            holder.rl_purchase_new_top.setVisibility(View.GONE);
        }


        if(payPurchaseBeanList.get(position).getCpMethod().equals("")||payPurchaseBeanList.get(position).getCpMethod().equals("1")||payPurchaseBeanList.get(position).getCpMethod().equals("3")){
            if(payPurchaseBeanList.get(position).getCpName().equals("")){
                holder.tv_pur_selectname.setText("请选择优惠券");
            }else{
                holder.tv_pur_selectname.setText(payPurchaseBeanList.get(position).getCpName());
            }
        }


        holder.purchase_shop_name.setText(shopList.get(position).getShopName());
        holder.rl_purchase_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isTejia){
                    T.show("订单中包含特价商品，不能使用优惠券哦！");
                }else {
                    /**
                     * 代表选择的是优惠券
                     */
                    String isbean = "false";
                    String goodsIds = "";
                    for (int i = 0; i < shopList.get(position).getApiAnsCustCartList().size(); i++) {
                        goodsIds = goodsIds + shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getId() + ",";

                        if (shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getPointRule() == null ||
                                shopList.get(position).getApiAnsCustCartList().get(i).getEcGoodsBasic().getPointRule().equals("")) {
                        } else {
                            isbean = "true";
                        }
                    }
                    Intent intentP = new Intent(context, PurchaseSelectActivity.class);
                    intentP.putExtra("shopId", shopList.get(position).getId().toString() + "");
                    intentP.putExtra("goodsIds", goodsIds.substring(0, goodsIds.length() - 1) + "");
                    intentP.putExtra("postion", position + "");
                    intentP.putExtra("purchaseNow", "list");
                    intentP.putExtra("isBean", isbean);
                    double price = 0;
                    for (int i = 0; i < shopList.get(position).getApiAnsCustCartList().size(); i++) {
                        price = price + Double.parseDouble(shopList.get(position).getApiAnsCustCartList().get(i).getAnsCustCart().getUnitPrice());
                    }
                    intentP.putExtra("amount", price + "");
                    context.startActivity(intentP);
                }
            }
        });
        return convertView;
    }
    //就是View的持有
    public final class ViewHolder {
        private LinearLayout li_purchase_product;
        private TextView purchase_shop_name;
        private RelativeLayout rl_purchase_select;//选择优惠券
        private TextView tv_pur_youhui;
        private TextView tv_pur_modou;
        private TextView tv_pur_selectname;
        private RelativeLayout rl_purchase_new_top;
        private TextView tv_purch_beannumber;
    }
}