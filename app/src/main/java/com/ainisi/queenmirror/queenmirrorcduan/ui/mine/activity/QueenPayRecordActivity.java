package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.QueenRecordAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.QueenPayRecordBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class QueenPayRecordActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.queen_record_product)
    RecyclerView queen_record_product;

    LoadingDialog loadingDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_queen_pay_record;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("充值记录");
        loadingDialog = new LoadingDialog(this);
        getQueenRecordData();
    }

    /**
     * 获取女王卡充值记录
     */
    private void getQueenRecordData() {
        loadingDialog.loadShow();
        HashMap<String,String> parames=new HashMap<>();
        parames.put("custId", SP.get(this, SpContent.UserId,"")+"");
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        parames.put("rechargeConsume","1");
        HttpUtils.doPost(ACTION.QUEENBUYRECORD,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
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
        switch (action){
            case ACTION.QUEENBUYRECORD:
                loadingDialog.cancel();
                QueenPayRecordBean queenPayRecordBean = GsonUtil.toObj(res,QueenPayRecordBean.class);
                if(queenPayRecordBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (queenPayRecordBean.isSuccess()) {
                        QueenRecordAdapter sortAdapter = new QueenRecordAdapter(R.layout.queen_buy_record_item, queenPayRecordBean.getBody().getQueenChargeRecords());
                        queen_record_product.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        queen_record_product.setAdapter(sortAdapter);
                    } else {
                        T.show(queenPayRecordBean.getMsg());
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
