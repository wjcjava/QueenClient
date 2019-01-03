package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.adapter.ShopListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopListBean;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class ProductActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView productTitle;
    //本店成品
    @Bind(R.id.re_product)
    RecyclerView reProduct;
    private ShopListBean shopListBean;
    private List<ShopListBean.BodyBean.ApiGoodsListBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product;
    }
    @Override
    protected void initView() {
        super.initView();

    }


    @Override
    protected void initData() {
        super.initData();
        productTitle.setText("全部成品");
        productTitle.setTextColor(Color.BLACK);
        Intent intent = this.getIntent();
        shopListBean= (ShopListBean) intent.getSerializableExtra("shopListBean");
        list=shopListBean.getBody().getApiGoodsList();
        ShopListAdapter shopListAdapter = new ShopListAdapter(R.layout.re_shop_store, list);
        reProduct.setLayoutManager(new GridLayoutManager(this, 2));
        reProduct.setAdapter(shopListAdapter);

    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }


    }
}
