package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullDetailAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 项目详情页面
 */
public class FullDetailActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;

    @Bind(R.id.rv_full_detail_content)
    RecyclerView rv_full_detail_content;
    String goods_content,goods_pic;

    List<String> goodsPic = new ArrayList<>();

    FullDetailAdapter fullDetailAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_full_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("商品介绍");

        Intent intent = this.getIntent();
        goods_content = intent.getStringExtra("goods_content");
        goods_pic = intent.getStringExtra("goods_pic");


        if(goods_pic == null||goods_pic.equals("null")||goods_pic.equals("")){

        }else {
            String[] goodsp = goods_pic.split(",");
            for (int i = 0; i < goodsp.length; i++) {
                goodsPic.add(goodsp[i]);
            }
        }

        fullDetailAdapter = new FullDetailAdapter(FullDetailActivity.this,R.layout.full_detail_list_item,goodsPic);
        rv_full_detail_content.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv_full_detail_content.setAdapter(fullDetailAdapter);

        View footView=getLayoutInflater().inflate(R.layout.full_detail_list_footer_item, null);

        footView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tv_full_detail_content = footView.findViewById(R.id.tv_full_detail_content);
        tv_full_detail_content.setText(goods_content);

        fullDetailAdapter.addFooterView(footView);
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) throws WriterException {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
