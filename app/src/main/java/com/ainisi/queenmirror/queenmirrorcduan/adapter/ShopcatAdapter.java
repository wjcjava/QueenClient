package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsInfo;
import com.ainisi.queenmirror.queenmirrorcduan.bean.StoreInfo;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.ShoppingCartActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.UtilTool;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/26.
 * 购物车适配器
 */

public class ShopcatAdapter extends BaseExpandableListAdapter implements HttpCallBack {
    private List<StoreInfo> groups;
    //这个String对应着StoreInfo的Id，也就是店铺的Id
    private Map<String, List<GoodsInfo>> childrens;
    private Context mcontext;
    private CheckInterface checkInterface;
    private ModifyCountInterface modifyCountInterface;
    private GroupEditorListener groupEditorListener;
    private int count = 0;

    String cartId;
    private boolean flag = true; //组的编辑按钮是否可见，true可见，false不可见

    public ShopcatAdapter(List<StoreInfo> groups, Map<String, List<GoodsInfo>> childrens, Context mcontext) {
        this.groups = groups;
        this.childrens = childrens;
        this.mcontext = mcontext;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupId = groups.get(groupPosition).getId();
        return childrens.get(groupId).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        List<GoodsInfo> childs = childrens.get(groups.get(groupPosition).getId());

        if (childs.size() > 0) {
            return childs.get(childPosition);
        }
        return "";
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.item_shopcat_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        final StoreInfo group = (StoreInfo) getGroup(groupPosition);
        groupViewHolder.storeName.setText(group.getName());

        groupViewHolder.storeCheckBox.setOnCheckedChangeListener(null);

        groupViewHolder.storeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                group.setChoosed(b);
                checkInterface.checkGroup(groupPosition, b);
            }
        });

        groupViewHolder.storeCheckBox.setChecked(group.isChoosed());
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mcontext, R.layout.item_shopcat_product, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        final GoodsInfo child = (GoodsInfo) getChild(groupPosition, childPosition);
        if (child != null) {
            cartId = child.getCustId();
            childViewHolder.goodsNum.setText(String.valueOf(child.getCount()));
            childViewHolder.tv_shop_name.setText(child.getName());
            childViewHolder.tv_shop_cart_price.setText("¥" + MD5.doubleToString(child.getPrice() + ""));

            if (child.getPointRule() == null || child.getPointRule().equals("")) {
                childViewHolder.tv_shopcart_modou.setVisibility(View.GONE);
            } else {
                childViewHolder.tv_shopcart_modou.setText("需支付魔豆：" + MD5.doubleToString(child.getPointRule()));
            }

            if (child.getQueenCard() == null || child.getQueenCard().equals("0") || child.getBuyRule() == null || child.getBuyRule().equals("1")) {
                childViewHolder.tv_shopcart_discount.setVisibility(View.GONE);
            } else {
                String discount = child.getQueenShopDiscount();
                String memeberPrice = MD5.doubleToString((child.getPrice() * Double.parseDouble(discount) / 10) + "");
                double end_price = child.getPrice() - Double.parseDouble(memeberPrice);
                childViewHolder.tv_shopcart_discount.setText("女王会员立减：¥" + MD5.doubleToString(end_price + ""));
            }

            if (child.getShopLogo() == null) {

            } else {
                String shopLogo = child.getShopLogo();
                if (shopLogo.length() > 0) {
                    String[] shop_logo = shopLogo.split(",");
                    Glide.with(mcontext).load(shop_logo[0]).placeholder(R.drawable.dismiss).into(childViewHolder.goodsImage);
                } else {

                }
            }


            /*childViewHolder.goodsImage.setImageResource(R.drawable.icon_home_beautiful);*/
            //设置打折前的原价
            SpannableString spannableString = new SpannableString("¥" + child.getPrime_price() + "");
            StrikethroughSpan span = new StrikethroughSpan();
            spannableString.setSpan(span, 0, spannableString.length() - 1 + 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            childViewHolder.singleCheckBox.setChecked(child.isChoosed());
            childViewHolder.singleCheckBox.setOnCheckedChangeListener(null);
            childViewHolder.singleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    child.setChoosed(b);
                    childViewHolder.singleCheckBox.setChecked(b);
                    checkInterface.checkChild(groupPosition, childPosition, b);
                }
            });

            childViewHolder.increaseGoodsNum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buyRule = ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getEcGoodsBasic().getBuyRule();
                    if ("1".equals(buyRule)) {
                        T.show("特价商品限购一个");
                        return;
                    }
                    /**
                     * 点击加号
                     */
                    cartId = child.getCustId();
                    modifyCountInterface.doIncrease(groupPosition, childPosition, childViewHolder.goodsNum, childViewHolder.singleCheckBox.isChecked());
                    count = Integer.parseInt(childViewHolder.goodsNum.getText().toString());
                    ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getAnsCustCart().setPurchaseNumber(count + "");
                    doNumberData();
                }
            });
            childViewHolder.reduceGoodsNum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buyRule = ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getEcGoodsBasic().getBuyRule();
                    if ("1".equals(buyRule)) {
                        T.show("特价商品限购一个");
                        return;
                    }
                    cartId = child.getCustId();
                    modifyCountInterface.doDecrease(groupPosition, childPosition, childViewHolder.goodsNum, childViewHolder.singleCheckBox.isChecked());
                    count = Integer.parseInt(childViewHolder.goodsNum.getText().toString());
                    ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getAnsCustCart().setPurchaseNumber(count + "");
                    doNumberData();
                }
            });
            childViewHolder.goodsNum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buyRule = ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getEcGoodsBasic().getBuyRule();
                    if ("1".equals(buyRule)) {
                        T.show("特价商品限购一个");
                        return;
                    }
                    showDialog(groupPosition, childPosition, childViewHolder.goodsNum, childViewHolder.singleCheckBox.isChecked(), child);
                }
            });

        }
        return convertView;
    }

    /**
     * 点击改变数量，通知服务器
     */
    private void doNumberData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(mcontext, SpContent.UserId, "0") + "");//用户ID
        params.put("num", count + "");
        params.put("token", SP.get(mcontext, SpContent.UserToken, "") + "");
        params.put("cartId", cartId);
        HttpUtils.doPost(ACTION.CHANGENUMBERCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.CHANGENUMBERCART:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(mcontext, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    mcontext.startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
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

    /**
     * @param groupPosition
     * @param childPosition
     * @param showCountView
     * @param isChecked
     * @param child
     */
    private void showDialog(final int groupPosition, final int childPosition, final View showCountView, final boolean isChecked, final GoodsInfo child) {
        final AlertDialog.Builder alertDialog_Builder = new AlertDialog.Builder(mcontext);
        View view = LayoutInflater.from(mcontext).inflate(R.layout.dialog_change_num, null);
        final AlertDialog dialog = alertDialog_Builder.create();
        dialog.setView(view);//errored,这里是dialog，不是alertDialog_Buidler
        count = child.getCount();
        final EditText num = (EditText) view.findViewById(R.id.dialog_num);
        num.setText(count + "");
        //自动弹出键盘
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                UtilTool.showKeyboard(mcontext, showCountView);
            }
        });
        final TextView increase = (TextView) view.findViewById(R.id.dialog_increaseNum);
        final TextView DeIncrease = (TextView) view.findViewById(R.id.dialog_reduceNum);
        final TextView pButton = (TextView) view.findViewById(R.id.dialog_Pbutton);
        final TextView nButton = (TextView) view.findViewById(R.id.dialog_Nbutton);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(num.getText().toString().trim());
                if (number == 0) {
                    dialog.dismiss();
                } else {
                    num.setText(String.valueOf(number));
                    child.setCount(number);
                    modifyCountInterface.doUpdate(groupPosition, childPosition, showCountView, isChecked);
                    ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getAnsCustCart().setPurchaseNumber(number + "");
                    doNumberData();
                    dialog.dismiss();
                }
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                num.setText(String.valueOf(count));

                ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getAnsCustCart().setPurchaseNumber(count + "");

            }
        });
        DeIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) {
                    count--;
                    num.setText(String.valueOf(count));
                    ShoppingCartActivity.instance.shoppingCartBean.getBody().getShopList().get(groupPosition).getApiAnsCustCartList().get(childPosition).getAnsCustCart().setPurchaseNumber(count + "");
                }
            }
        });
        dialog.show();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    public GroupEditorListener getGroupEditorListener() {
        return groupEditorListener;
    }

    public void setGroupEditorListener(GroupEditorListener groupEditorListener) {
        this.groupEditorListener = groupEditorListener;
    }

    public CheckInterface getCheckInterface() {
        return checkInterface;
    }

    public void setCheckInterface(CheckInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    public ModifyCountInterface getModifyCountInterface() {
        return modifyCountInterface;
    }

    public void setModifyCountInterface(ModifyCountInterface modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }


    static class GroupViewHolder {
        @Bind(R.id.store_checkBox)
        CheckBox storeCheckBox;
        @Bind(R.id.store_name)
        TextView storeName;

        public GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 店铺的复选框
     */
    public interface CheckInterface {
        /**
         * 组选框状态改变触发的事件
         *
         * @param groupPosition 组元素的位置
         * @param isChecked     组元素的选中与否
         */
        void checkGroup(int groupPosition, boolean isChecked);

        /**
         * 子选框状态改变触发的事件
         *
         * @param groupPosition 组元素的位置
         * @param childPosition 子元素的位置
         * @param isChecked     子元素的选中与否
         */
        void checkChild(int groupPosition, int childPosition, boolean isChecked);
    }


    /**
     * 改变数量的接口
     */
    public interface ModifyCountInterface {
        /**
         * 增加操作
         *
         * @param groupPosition 组元素的位置
         * @param childPosition 子元素的位置
         * @param showCountView 用于展示变化后数量的View
         * @param isChecked     子元素选中与否
         */
        void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);

        void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);

        void doUpdate(int groupPosition, int childPosition, View showCountView, boolean isChecked);

        /**
         * 删除子Item
         *
         * @param groupPosition
         * @param childPosition
         */
        void childDelete(int groupPosition, int childPosition);
    }

    /**
     * 监听编辑状态
     */
    public interface GroupEditorListener {
        void groupEditor(int groupPosition);
    }

    /**
     * 使某个小组处于编辑状态
     */
    private class GroupViewClick implements View.OnClickListener {
        private StoreInfo group;
        private int groupPosition;
        private TextView editor;

        public GroupViewClick(StoreInfo group, int groupPosition, TextView editor) {
            this.group = group;
            this.groupPosition = groupPosition;
            this.editor = editor;
        }

        @Override
        public void onClick(View v) {
            if (editor.getId() == v.getId()) {
                groupEditorListener.groupEditor(groupPosition);
                if (group.isEditor()) {
                    group.setEditor(false);
                } else {
                    group.setEditor(true);
                }
                notifyDataSetChanged();
            }
        }
    }


    static class ChildViewHolder {
        @Bind(R.id.single_checkBox)
        CheckBox singleCheckBox;
        @Bind(R.id.goods_image)
        ImageView goodsImage;
        @Bind(R.id.reduce_goodsNum)
        TextView reduceGoodsNum;
        @Bind(R.id.goods_Num)
        TextView goodsNum;
        @Bind(R.id.increase_goods_Num)
        TextView increaseGoodsNum;
        @Bind(R.id.tv_shop_name)
        TextView tv_shop_name;
        @Bind(R.id.tv_shop_cart_price)
        TextView tv_shop_cart_price;
        @Bind(R.id.tv_shopcart_modou)
        TextView tv_shopcart_modou;
        @Bind(R.id.tv_shopcart_discount)
        TextView tv_shopcart_discount;


        public ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
