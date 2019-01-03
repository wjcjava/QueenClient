package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineQueenCardRecordAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardRecordBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 购买记录
 */
public class MineQueenCardBuyRecordActivity extends BaseActivity implements HttpCallBack {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.mine_record_refreshLayout)
    SmartRefreshLayout mine_record_refreshLayout;
    @Bind(R.id.rc_mine_queen_card_record)
    RecyclerView rc_mine_queen_card_record;

    private List<MineQueenCardRecordBean.BodyBean.RecordsListBean> list = new ArrayList<>();
    MineQueenCardRecordAdapter sortAdapter2;
    int pageNumber = 1,pageIndex=0,pageSum=0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_queen_card_buy_record;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title_title.setText("购买记录");

        getBuyRecordData();

        sortAdapter2 = new MineQueenCardRecordAdapter(R.layout.mine_queen_card_list_item_record, list,this);
        rc_mine_queen_card_record.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc_mine_queen_card_record.setAdapter(sortAdapter2);

        mine_record_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                getBuyRecordData();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_record_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    getBuyRecordData();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    /**
     * 获取购买记录
     */
    private void getBuyRecordData() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("pageSize",SpContent.pageSize);
        parames.put("pageNumber", pageNumber+"");
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.QUEENCARDBUYRECORD,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @OnClick({R.id.title_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.QUEENCARDBUYRECORD:
                MineQueenCardRecordBean mineQueenCardRecordBean = GsonUtil.toObj(res,MineQueenCardRecordBean.class);
                if(mineQueenCardRecordBean.isSuccess()&&mineQueenCardRecordBean.getErrorCode().equals("0")){
                    pageSum = mineQueenCardRecordBean.getBody().getRecordsList().size();

                    loadMoreData(mineQueenCardRecordBean.getBody().getRecordsList());
                }else{
                    T.show(mineQueenCardRecordBean.getMsg());
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

    public void loadMoreData(List<MineQueenCardRecordBean.BodyBean.RecordsListBean> apiOrderListMore){

        if(list == null){
            list = new ArrayList<>();
        }
        if(pageIndex == 0){
            sortAdapter2.Clear();
        }
        list.addAll(apiOrderListMore);
        if(pageIndex == 0){
            sortAdapter2.setmDate(list);
        }else{
            sortAdapter2.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
