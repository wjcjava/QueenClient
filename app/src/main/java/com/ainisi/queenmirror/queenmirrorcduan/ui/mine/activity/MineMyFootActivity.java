package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.MyFootAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MineFootBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//我的足迹
public class MineMyFootActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.mine_foot_recycler)
    RecyclerView recycler;
    @Bind(R.id.title_title)
    TextView folltitle;
    @Bind(R.id.title_right)
    TextView titleRight;
    List<MineFootBean.BodyBean.ViewListDataBean> ViewListData = new ArrayList<>();
    LoadingDialog loadingDialog;

    int pageNumber = 1;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineMyFootActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_my_foot;
    }


    @Override
    protected void initView() {
        super.initView();
        folltitle.setText("我的足迹");
        folltitle.setTextSize(16);
        titleRight.setText("编辑");
        titleRight.setTextSize(14);
        titleRight.setVisibility(View.GONE);
        loadingDialog = new LoadingDialog(this);

        inithttp();
    }

    @Override
    protected void initData() {
        super.initData();
    }


    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:

                finish();
                break;
        }
    }


    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userId", SP.get(MineMyFootActivity.this,SpContent.UserId,"")+"");
        hashMap.put("token",SP.get(MineMyFootActivity.this,SpContent.UserToken,"")+"");
        hashMap.put("pageNumber", pageNumber+"");
        hashMap.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.MYFOOT, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {

        switch (action) {
            //我的足迹
            case ACTION.MYFOOT:
                loadingDialog.cancel();
                MineFootBean sortBean = GsonUtil.toObj(res,MineFootBean.class);
                if(sortBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    ViewListData = sortBean.getBody().getViewListData();
                    MyFootAdapter sortAdapter = new MyFootAdapter(MineMyFootActivity.this, R.layout.item_fullshortrecycler, ViewListData);
                    recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    recycler.setAdapter(sortAdapter);
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
