package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GoodsListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.GoodsSearchAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.GoodsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.LabelBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.FlowLayout;
import com.ainisi.queenmirror.queenmirrorcduan.utils.StatusBarUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2017/11/12.
 * 搜索
 */

public class SearchActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.his_flowLayout)
    FlowLayout his_flowLayout;
    @Bind(R.id.search_radio_shop)
    RadioButton searchShop;
    @Bind(R.id.search_radio_nails)
    RadioButton searchNails;
    @Bind(R.id.re_search_footprint)
    RelativeLayout footprineRelayout;
    @Bind(R.id.rg_search_list_type)

    RadioGroup rg_search_list_type;
    @Bind(R.id.et_search_title)
    public EditText et_search_title;
    @Bind(R.id.search_recycler_view)
    RecyclerView search_recycler_view;
    @Bind(R.id.btn_clear_history_search)
    Button btn_clear_history_search;
    @Bind(R.id.tv_history_search)
    TextView tv_history_search;
    @Bind(R.id.iv_search_diss)
    ImageView iv_search_diss;

    String shopCate;
    ShopListHomeBean shopListHomeBean;
    String index = "1",history_string="";
    int pageNumber=1,pageIndex=0,pageSum=0;
    SearchAdapter sortAdapter2;
    LoadingDialog loadingDialog;

    public static void startActivity(Context context) {
        Intent in = new Intent(context, SearchActivity.class);
        context.startActivity(in);
    }

    public static SearchActivity instance = null;
    @Override
    public int getLayoutId() {
        instance = this;
        StatusBarUtil.getStatusBarLightMode(getWindow());
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        shopCate = intent.getStringExtra("shopCate");
        inithttp();

        history_string = SP.get(SearchActivity.this,SpContent.History,"")+"";
        if(history_string.equals("")){
            btn_clear_history_search.setVisibility(View.GONE);
        }else{
            btn_clear_history_search.setVisibility(View.VISIBLE);
            List<String>  history = new ArrayList<>();
            String[] his_string = history_string.split(",");
            for(int i =0;i<his_string.length;i++){
                history.add(i,his_string[i]);
            }
            sortAdapter2 = new SearchAdapter(R.layout.homepage_search_item,history);
            search_recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            search_recycler_view.setAdapter(sortAdapter2);
        }
        rg_search_list_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                pageIndex = 0;
                inithttp();
            }
        });

    }

    @OnClick({R.id.title_back, R.id.title_search,R.id.btn_clear_history_search,R.id.iv_search_diss})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_search_diss:
                et_search_title.setText("");
                break;
            case R.id.btn_clear_history_search:
                btn_clear_history_search.setVisibility(View.GONE);
                SP.put(SearchActivity.this,SpContent.History,"");

                List<String>  history = new ArrayList<>();
                history.add("暂无历史搜索数据");

                sortAdapter2 = new SearchAdapter(R.layout.homepage_search_item,history);
                search_recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                search_recycler_view.setAdapter(sortAdapter2);

                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.title_search:
                if(et_search_title.getText().toString().equals("")){
                    T.show("请输入店铺或商品关键字");
                }else{
                    btn_clear_history_search.setVisibility(View.VISIBLE);
                    history_string = SP.get(SearchActivity.this,SpContent.History,"")+"";

                    if(history_string.equals("")){
                        history_string = history_string + et_search_title.getText().toString() + ",";
                        List<String>  historys = new ArrayList<>();

                        String[] his_string = history_string.split(",");

                        for(int i =0;i<his_string.length;i++){
                            historys.add(i,his_string[i]);
                        }
                        sortAdapter2 = new SearchAdapter(R.layout.homepage_search_item,historys);
                        search_recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                        search_recycler_view.setAdapter(sortAdapter2);
                    }else {

                        String[] str_his = history_string.split(",");

                        boolean isEquals = false;
                        for(int i=0;i<str_his.length;i++){
                            if(str_his[i].equals(et_search_title.getText().toString())){
                                isEquals = true;
                                break;
                            }else{
                            }
                        }

                        if(isEquals){

                        }else{
                            history_string = history_string+et_search_title.getText().toString() + ",";
                        }

                        List<String>  historys = new ArrayList<>();
                        String[] his_string = history_string.split(",");
                        for(int i =0;i<his_string.length;i++){
                            historys.add(i,his_string[i]);
                        }
                        sortAdapter2 = new SearchAdapter(R.layout.homepage_search_item,historys);
                        search_recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                        search_recycler_view.setAdapter(sortAdapter2);
                    }

                    SP.put(SearchActivity.this,SpContent.History,history_string);
                    if (searchShop.isChecked()){
                        initShopSearch();
                    } else if (searchNails.isChecked()) {
                        initNailsSearch();
                    } else {
                        T.show("请选择条件进行搜索");
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 搜索商品列表
     */
    private void initNailsSearch() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("saleFlag", "2");//活动的ID
        parames.put("pageNumber", pageNumber+"");//商铺状态ID 1.首页 2.异业
        parames.put("contentByTitle", et_search_title.getText().toString());
        parames.put("shopCate",shopCate);
        parames.put("pageSize",SpContent.pageSize);
        parames.put("cityCode",SP.get(SearchActivity.this,SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.GOODLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 获取搜索店铺列表
     */
    private void initShopSearch() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber", pageNumber+"");//活动的ID
        parames.put("contentByTitle", et_search_title.getText().toString());//商铺状态ID 1.首页 2.异业
        parames.put("shopCate",shopCate);
        parames.put("pageSize",SpContent.pageSize);
        parames.put("cityCode",SP.get(SearchActivity.this,SpContent.CityCode,"0512")+"");
        HttpUtils.doPost(ACTION.SHOPLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 热门标签
     */
    private void inithttp() {
        if (searchShop.isChecked()){
            index = "1";
            et_search_title.setHint("请输入店铺关键信息");
        } else if (searchNails.isChecked()) {
            index = "2";
            et_search_title.setHint("请输入商品关键信息");
        }
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("keyObject", index);
        params.put("keyIndustry", shopCate);//1美业  2异业
        params.put("keyCategory","");
        params.put("token", SP.get(SearchActivity.this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SEARCHKEY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GOODLIST:
                /**
                 * 获取搜索商品列表
                 */
                loadingDialog.cancel();
                GoodsListBean goodsListBean = GsonUtil.toObj(res,GoodsListBean.class);
                if(goodsListBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (goodsListBean.isSuccess()) {
                        if (goodsListBean.getBody().getGoodsListData().size() > 0) {
                            pageSum = goodsListBean.getBody().getPageSum();

                            Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                            intent.putExtra("which", "good");
                            intent.putExtra("shopCate", shopCate);
                            intent.putExtra("contentByTitle", et_search_title.getText().toString());
                            intent.putExtra("lstBean", (Serializable) goodsListBean.getBody().getGoodsListData());
                            intent.putExtra("pageSum", pageSum + "");
                            startActivity(intent);

                        } else {
                            T.show("暂无商品信息");
                        }
                    } else {
                        T.show(goodsListBean.getMsg());
                    }
                }
                break;
            /**
             * 获取店铺列表
             */
            case ACTION.SHOPLIST:
                loadingDialog.cancel();
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if(shopListHomeBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (shopListHomeBean.isSuccess()) {
                        if (shopListHomeBean.getBody().getShopListData().size() > 0) {

                            pageSum = shopListHomeBean.getBody().getPageSum();

                            Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                            intent.putExtra("which", "shop");
                            intent.putExtra("shopCate", shopCate);
                            intent.putExtra("contentByTitle", et_search_title.getText().toString());
                            intent.putExtra("lstBean", (Serializable) shopListHomeBean.getBody().getShopListData());
                            intent.putExtra("pageSum", pageSum + "");
                            startActivity(intent);
                        } else {
                            T.show("暂无店铺信息");
                        }
                    } else {
                        T.show(shopListHomeBean.getMsg());
                    }
                }
                break;
            case ACTION.SEARCHKEY:
                loadingDialog.cancel();
                his_flowLayout.cleanTag();
                LabelBean labelBean = GsonUtil.toObj(res, LabelBean.class);
                if(labelBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (labelBean.isSuccess()) {
                        if (labelBean.getBody().getHotSearchKeysListData().size() < 1) {
                            his_flowLayout.cleanTag();
                        } else {
                            String[] mStrings = new String[labelBean.getBody().getHotSearchKeysListData().size()];
                            for (int i = 0; i < labelBean.getBody().getHotSearchKeysListData().size(); i++) {
                                mStrings[i] = labelBean.getBody().getHotSearchKeysListData().get(i).getEcSearchKey().getKeyName();
                            }
                            his_flowLayout.setColorful(false);//设置是否是多彩的颜色
                            his_flowLayout.setData(mStrings);
                            his_flowLayout.setOnTagClickListener(new FlowLayout.OnTagClickListener() {
                                @Override
                                public void TagClick(String text) {
                                    et_search_title.setText(text);
                                }
                            });
                        }
                    } else {
                        T.show(labelBean.getMsg());
                    }
                }
                break;
            case ACTION.ACTIVITYGOODS:
                loadingDialog.cancel();
                GoodsBean goodsBean = GsonUtil.toObj(res, GoodsBean.class);
                if(goodsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (goodsBean.isSuccess()){
                        footprineRelayout.setVisibility(View.GONE);
                        List<GoodsBean.BodyBean.ActivityListDataBean> goodsList = goodsBean.getBody().getActivityListData();
                        GoodsSearchAdapter searchAdapter = new GoodsSearchAdapter(R.layout.item_shopsearch, goodsList);
                        initstartAdapter(search_recycler_view, searchAdapter);
                    }else {
                        T.show(goodsBean.getMsg());
                    }
                }
                break;
        }
    }
    private void initstartAdapter(RecyclerView shopsearchRecycler, BaseQuickAdapter adapter) {
        shopsearchRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        shopsearchRecycler.setAdapter(adapter);
    }
    @Override
    public void showLoadingDialog() {
    }
    @Override
    public void showErrorMessage(String s) {
    }

}