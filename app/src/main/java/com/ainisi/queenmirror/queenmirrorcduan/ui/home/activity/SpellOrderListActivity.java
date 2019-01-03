package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SpellOrderAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SpellOrderListActivity extends BaseNewActivity{

    @Bind(R.id.re_spellorder)
    RecyclerView reSpellOrder;
    @Bind(R.id.title_title)
    TextView spellTitle;
    @Bind(R.id.title_back)
    ImageView title_back;

    FightaloneBean fightaloneBean = null;
    String goodsId,activityId,goodsSales;
    List<FightaloneBean.BodyBean.GpOrderListBean> gpOrderList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_spell_orderlist;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = this.getIntent();
        fightaloneBean = (FightaloneBean) intent.getSerializableExtra("bean");
        goodsId = intent.getStringExtra("goodsId");
        activityId = intent.getStringExtra("activityId");
        goodsSales = intent.getStringExtra("goodsSales");
        spellTitle.setText("更多拼单");

        gpOrderList = fightaloneBean.getBody().getGpOrderList();

        SpellOrderAdapter myAdapter = new SpellOrderAdapter(SpellOrderListActivity.this,R.layout.item_spellorder_list, gpOrderList,fightaloneBean.getBody().getGroupNums(),goodsId,activityId,goodsSales);
        reSpellOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reSpellOrder.setAdapter(myAdapter);
    }

    @OnClick({R.id.title_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
