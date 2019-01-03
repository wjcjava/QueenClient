package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ShopcatAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsInfo;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShoppingCartBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.StoreInfo;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.UtilTool;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.UtilsLog;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 购物车
 */
public class ShoppingCartActivity extends BaseNewActivity implements HttpCallBack, View.OnClickListener, ShopcatAdapter.CheckInterface, ShopcatAdapter.ModifyCountInterface, ShopcatAdapter.GroupEditorListener {

    @Bind(R.id.listView)
    ExpandableListView listView;
    @Bind(R.id.all_checkBox)
    CheckBox allCheckBox;
    @Bind(R.id.total_price)
    TextView totalPrice;
    @Bind(R.id.go_pay)
    TextView goPay;
    @Bind(R.id.del_goods)
    TextView delGoods;
    @Bind(R.id.ll_cart)
    LinearLayout llCart;
    @Bind(R.id.title_shopcart_back)
    ImageView title_shopcart_back;

    @Bind(R.id.shoppingcat_num)
    TextView shoppingcatNum;
    @Bind(R.id.actionBar_edit)
    TextView actionBarEdit;
    @Bind(R.id.layout_empty_shopcart)
    LinearLayout empty_shopcart;
    private Context mcontext;
    private double mtotalPrice = 0.00;
    private int mtotalCount = 0;
    //false就是编辑，ture就是完成
    private boolean flag = false;
    private ShopcatAdapter adapter;
    private List<StoreInfo> groups = new ArrayList<StoreInfo>(); //组元素的列表
    private Map<String, List<GoodsInfo>> childs = new HashMap<String, List<GoodsInfo>>(); //子元素的列表
    public ShoppingCartBean shoppingCartBean;

    String delIds = "";
    List<ShoppingCartBean.BodyBean.ShopListBean.ApiAnsCustCartListBean> apiAnsCustCartListBeans = new ArrayList<>();
    public static ShoppingCartActivity instance = null;
    LoadingDialog loadingDialog;

    @Override
    protected int getLayoutId() {
        instance = this;
        StatusBarUtil.getStatusBarLightMode(getWindow());
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 获取购物车数据
             */
            case ACTION.GETSHOPPINDCART:
                loadingDialog.cancel();
                shoppingCartBean = GsonUtil.toObj(res, ShoppingCartBean.class);
                if (shoppingCartBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    initEvents();
                }
                break;
            case ACTION.DELETESHOPCART:
                loadingDialog.cancel();
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (successBean.isSuccess()) {
                        T.show(successBean.getMsg());
                        getShopCartData();
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

    @Override
    protected void initView() {
        super.initView();
        loadingDialog = new LoadingDialog(ShoppingCartActivity.this);

        getShopCartData();
    }

    /**
     * 获取购物车数据
     */
    private void getShopCartData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(ShoppingCartActivity.this, SpContent.UserId, "") + "");//用户ID
        params.put("token", SP.get(ShoppingCartActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETSHOPPINDCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 删除购物车数据
     */
    private void DeleteShopCartData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(ShoppingCartActivity.this, SpContent.UserId, "") + "");//用户ID
        params.put("delIds", delIds);
        params.put("token", SP.get(ShoppingCartActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.DELETESHOPCART, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initEvents() {
        mcontext = this;
        groups = new ArrayList<StoreInfo>();
        childs = new HashMap<String, List<GoodsInfo>>();
        for (int i = 0; i < shoppingCartBean.getBody().getShopList().size(); i++) {
            groups.add(new StoreInfo(i + "", shoppingCartBean.getBody().getShopList().get(i).getShopName()));
            List<GoodsInfo> goods = new ArrayList<>();
            apiAnsCustCartListBeans = shoppingCartBean.getBody().getShopList().get(i).getApiAnsCustCartList();
            for (int j = 0; j < shoppingCartBean.getBody().getShopList().get(i).getApiAnsCustCartList().size(); j++) {
                int img = R.drawable.icon_home_beautiful;
                //i-j 就是商品的id， 对应着第几个店铺的第几个商品，1-1 就是第一个店铺的第一个商品,价格,在加商品时的数量
                goods.add(new GoodsInfo(apiAnsCustCartListBeans.get(j).getAnsCustCart().getId(),
                        apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getGoodsName(),
                        apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getGoodsBrief(),
                        Double.parseDouble(apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getSalesPrice()),
                        Double.parseDouble(apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getSalesPrice()),
                        "第一排",
                        "出头天者"
                        , img,
                        Integer.parseInt(apiAnsCustCartListBeans.get(j).getAnsCustCart().getPurchaseNumber()),
                        apiAnsCustCartListBeans.get(j).getAnsCustCart().getId(),
                        apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getGoodsShow(),
                        apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getPointRule(),
                        shoppingCartBean.getBody().getShopList().get(i).getQueenCard(),
                        shoppingCartBean.getBody().getShopList().get(i).getQueenShopDiscount(),
                        apiAnsCustCartListBeans.get(j).getEcGoodsBasic().getBuyRule()));
            }
            childs.put(groups.get(i).getId(), goods);
        }
        setCartNum();
        actionBarEdit.setOnClickListener(this);
        adapter = new ShopcatAdapter(groups, childs, mcontext);
        adapter.setCheckInterface(this);//关键步骤1：设置复选框的接口
        adapter.setModifyCountInterface(this); //关键步骤2:设置增删减的接口
        adapter.setGroupEditorListener(this);//关键步骤3:监听组列表的编辑状态
        listView.setGroupIndicator(null); //设置属性 GroupIndicator 去掉向下箭头
        listView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int firstVisiablePostion = view.getFirstVisiblePosition();
                int top = -1;
                View firstView = view.getChildAt(firstVisibleItem);
                UtilsLog.i("childCount=" + view.getChildCount());//返回的是显示层面上的所包含的子view的个数
                if (firstView != null) {
                    top = firstView.getTop();
                }
                UtilsLog.i("firstVisiableItem=" + firstVisibleItem + ",fistVisiablePosition=" + firstVisiablePostion + ",firstView=" + firstView + ",top=" + top);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * 设置购物车的数量
     */
    private void setCartNum() {
        int count = 0;
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            group.setChoosed(allCheckBox.isChecked());
            List<GoodsInfo> Childs = childs.get(group.getId());
            for (GoodsInfo childs : Childs) {
                count++;
            }
        }
        //购物车已经清空
        if (count == 0) {
            clearCart();
        } else {
            shoppingcatNum.setText("购物车");
        }
    }

    private void clearCart() {
        shoppingcatNum.setText("去支付");
        actionBarEdit.setVisibility(View.GONE);
        llCart.setVisibility(View.GONE);
        empty_shopcart.setVisibility(View.VISIBLE);//这里发生过错误
    }

    /**
     * @param groupPosition 组元素的位置
     * @param isChecked     组元素的选中与否
     *                      思路:组元素被选中了，那么下辖全部的子元素也被选中
     */
    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        StoreInfo group = groups.get(groupPosition);
        List<GoodsInfo> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            child.get(i).setChoosed(isChecked);
        }
        if (isCheckAll()) {
            allCheckBox.setChecked(true);//全选
        } else {
            allCheckBox.setChecked(false);//反选
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @return 判断组元素是否全选
     */
    private boolean isCheckAll() {
        for (StoreInfo group : groups) {
            if (!group.isChoosed()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param groupPosition 组元素的位置
     * @param childPosition 子元素的位置
     * @param isChecked     子元素的选中与否
     */
    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean allChildSameState = true; //判断该组下面的所有子元素是否处于同一状态
        StoreInfo group = groups.get(groupPosition);
        List<GoodsInfo> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            //不选全中
            if (child.get(i).isChoosed() != isChecked) {
                allChildSameState = false;
                break;
            }
        }

        if (allChildSameState) {
            group.setChoosed(isChecked);//如果子元素状态相同，那么对应的组元素也设置成这一种的同一状态
        } else {
            group.setChoosed(false);//否则一律视为未选中
        }

        if (isCheckAll()) {
            allCheckBox.setChecked(true);//全选
        } else {
            allCheckBox.setChecked(false);//反选
        }

        adapter.notifyDataSetChanged();
        calulate();

    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        count++;
        good.setCount(count);
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @param groupPosition
     * @param childPosition
     * @param showCountView
     * @param isChecked
     */
    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        if (count == 1) {
            return;
        }
        count--;
        good.setCount(count);
        ((TextView) showCountView).setText("" + count);
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @param groupPosition
     * @param childPosition 思路:当子元素=0，那么组元素也要删除
     */
    @Override
    public void childDelete(int groupPosition, int childPosition) {
        StoreInfo group = groups.get(groupPosition);
        List<GoodsInfo> child = childs.get(group.getId());
        child.remove(childPosition);
        if (child.size() == 0) {
            groups.remove(groupPosition);
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    public void doUpdate(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        GoodsInfo good = (GoodsInfo) adapter.getChild(groupPosition, childPosition);
        int count = good.getCount();
        UtilsLog.i("进行更新数据，数量" + count + "");
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();
    }

    @Override
    public void groupEditor(int groupPosition) {

    }

    @OnClick({R.id.all_checkBox, R.id.go_pay, R.id.del_goods, R.id.title_shopcart_back})
    public void onClick(View view) {
        AlertDialog dialog;
        switch (view.getId()) {
            case R.id.title_shopcart_back:
                finish();
                break;
            case R.id.all_checkBox:
                doCheckAll();
                break;
            case R.id.go_pay:
                if (mtotalCount == 0) {
                    UtilTool.toast(mcontext, "请选择要支付的商品");
                    return;
                }
                calulates();
                break;
            case R.id.del_goods:
                if (mtotalCount == 0) {
                    UtilTool.toast(mcontext, "请选择要删除的商品");
                    return;
                }
                dialog = new AlertDialog.Builder(mcontext).create();
                dialog.setMessage("确认要删除该商品吗?");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doDelete();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.show();
                break;
            case R.id.actionBar_edit:
                flag = !flag;
                setActionBarEditor();
                setVisiable();
                break;
        }
    }


    /**
     * 这里删除的是购物车未选中相关信息
     */
    //思路:当子元素=0，那么组元素也要删除
    private void calulates() {
        String pos = "";
        boolean isBuyRule = false;
        boolean isrdinary = false;
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            List<GoodsInfo> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                GoodsInfo good = child.get(j);
                if (good.isChoosed()) {
                    if (good.getBuyRule().equals("1")) {
                        isBuyRule = true;
                    }
                    if (!good.getBuyRule().equals("1")) {
                        isrdinary = true;
                    }
                } else {
                    child.remove(j);
                    shoppingCartBean.getBody().getShopList().get(i).getApiAnsCustCartList().remove(j);

                    if (child.size() == 0) {
                        pos = pos + i + ",";
                    }
                    j--;
                }
            }
        }
        if (isBuyRule && isrdinary) {
            AlertDialog dialog = new AlertDialog.Builder(mcontext).create();
            dialog.setMessage("特价商品无法与其他商品一起结算");
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            return;
        }
        Intent intent = new Intent(ShoppingCartActivity.this, PurchaseActivity.class);
        intent.putExtra("cartBean", (Serializable) shoppingCartBean);
        startActivity(intent);
    }


    /**
     * 删除操作
     * 1.不要边遍历边删除,容易出现数组越界的情况
     * 2.把将要删除的对象放进相应的容器中，待遍历完，用removeAll的方式进行删除
     */
    List<GoodsInfo> toBeDeleteChilds;
    List<GoodsInfo> childde;

    private void doDelete() {
        delIds = "";
        List<StoreInfo> toBeDeleteGroups = new ArrayList<StoreInfo>(); //待删除的组元素
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            if (group.isChoosed()) {
                toBeDeleteGroups.add(group);
            }
            toBeDeleteChilds = new ArrayList<GoodsInfo>();//待删除的子元素
            childde = childs.get(group.getId());
            for (int j = 0; j < childde.size(); j++) {
                if (childde.get(j).isChoosed()) {
                    toBeDeleteChilds.add(childde.get(j));
                    delIds = delIds + childde.get(j).getId() + ",";
                }
            }
        }
        childde.removeAll(toBeDeleteChilds);
        groups.removeAll(toBeDeleteGroups);

        /**
         * 删除购物车数据
         */
        DeleteShopCartData();
        //重新设置购物车
        setCartNum();

        totalPrice.setText("¥0.00");
        goPay.setText("去结算");

        adapter.notifyDataSetChanged();
    }

    /**
     * ActionBar标题上点编辑的时候，只显示每一个店铺的商品修改界面
     * ActionBar标题上点完成的时候，只显示每一个店铺的商品信息界面
     */
    private void setActionBarEditor() {
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            if (group.isActionBarEditor()) {
                group.setActionBarEditor(false);
            } else {
                group.setActionBarEditor(true);
            }
        }
        adapter.notifyDataSetChanged();
    }


    /**
     * 全选和反选
     * 错误标记：在这里出现过错误
     */
    private void doCheckAll() {

        if (groups.size() > 0) {
            for (int i = 0; i < groups.size(); i++) {
                StoreInfo group = groups.get(i);
                group.setChoosed(allCheckBox.isChecked());
                List<GoodsInfo> child = childs.get(group.getId());
                for (int j = 0; j < child.size(); j++) {
                    child.get(j).setChoosed(allCheckBox.isChecked());//这里出现过错误
                }
            }
            adapter.notifyDataSetChanged();
            calulate();
        } else {
            T.show("请先添加商品");
        }

    }

    /**
     * 计算商品总价格，操作步骤
     * 1.先清空全局计价,计数
     * 2.遍历所有的子元素，只要是被选中的，就进行相关的计算操作
     * 3.给textView填充数据
     */
    private void calulate() {
        mtotalPrice = 0.00;
        mtotalCount = 0;
        for (int i = 0; i < groups.size(); i++) {
            StoreInfo group = groups.get(i);
            List<GoodsInfo> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                String discount = "";
                GoodsInfo good = child.get(j);
                if (good.isChoosed()) {
                    mtotalCount++;

                    /**
                     * 判断是否是会员商家，判断是否为特价商品
                     */

                    if (SP.get(ShoppingCartActivity.this, SpContent.IsQueenVip, "0").equals("1")) {
                        if (good.getQueenCard().equals("1")) {
                            if (good.getBuyRule().equals("1")) {
                                discount = "10";
                            } else {
                                discount = good.getQueenShopDiscount();
                            }
                        } else {
                            discount = "10";
                        }
                    } else {
                        discount = "10";
                    }

                    mtotalPrice += good.getPrice() * Double.parseDouble(discount) * good.getCount() / 10;
                }
            }
        }
        totalPrice.setText("¥" + MD5.doubleToString(mtotalPrice + "") + "");
        goPay.setText("去支付(" + mtotalCount + "）");
        if (mtotalCount == 0) {
            setCartNum();
        } else {
            shoppingcatNum.setText("购物车");
        }

    }

    private void setVisiable() {

        if (flag) {
            goPay.setVisibility(View.GONE);
            delGoods.setVisibility(View.VISIBLE);
            actionBarEdit.setText("完成");
        } else {
            goPay.setVisibility(View.VISIBLE);
            delGoods.setVisibility(View.GONE);
            actionBarEdit.setText("编辑");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter = null;
        if (childs.isEmpty()) {

        } else {
            childs.clear();
        }
        if (groups.isEmpty()) {

        } else {
            groups.clear();
        }
        mtotalPrice = 0.00;
        mtotalCount = 0;
    }
}
