package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineRedPacketAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineRedPacketRecprdBean;
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

/**
 * Created by john on 2018/8/21.
 *
 * jl
 */

public class MineRedPacketRecordFragment  extends BaseFragment implements HttpCallBack {

    private int position;
    @Bind(R.id.re_red_packet_record)
    RecyclerView re_red_packet_record;
    @Bind(R.id.mine_evaluate_refreshLayout)
    SmartRefreshLayout mine_evaluate_refreshLayout;

    List<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean> commentList = new ArrayList<>();

    MineRedPacketAdapter mineRedPacketAdapter;
    int pageNumber = 1,pageIndex=0,pageSum=0;
    @Override
    public int getLayoutResource() {
        return R.layout.mine_redpacket_record;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        position = getArguments().getInt("position");

        mineRedPacketAdapter = new MineRedPacketAdapter(R.layout.mine_redpacket_list_item, commentList,getActivity(),position+"");
        re_red_packet_record.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        re_red_packet_record.setAdapter(mineRedPacketAdapter);

        mine_evaluate_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                getMineRePacketData();
                refreshlayout.finishRefresh(1000);
            }
        });
        mine_evaluate_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                if(pageSum < Integer.parseInt(SpContent.pageSize)){
                    refreshlayout.finishLoadmore(1000);
                    T.show("您已加载完全部数据");
                }else{
                    pageNumber++;
                    getMineRePacketData();
                    refreshlayout.finishLoadmore(1000);
                }
            }
        });
    }

    /**
     * 获取我的红包记录
     */
    private void getMineRePacketData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("pageNumber",pageNumber+"");
        parames.put("pageSize",SpContent.pageSize);
        parames.put("token", SP.get(getActivity(), SpContent.UserToken,"")+"");
        parames.put("type",position+"");
        HttpUtils.doPost(ACTION.GETMINEREDPACKETRECORD, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void doFitsrData() {
        getMineRePacketData();
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.GETMINEREDPACKETRECORD:
                MineRedPacketRecprdBean mineRedPacketRecprdBean = GsonUtil.toObj(res,MineRedPacketRecprdBean.class);
                if(mineRedPacketRecprdBean.isSuccess()&&mineRedPacketRecprdBean.getErrorCode().equals("0")){

                    pageSum = mineRedPacketRecprdBean.getBody().getRedPacketRecords().size();

                    loadMoreData(mineRedPacketRecprdBean.getBody().getRedPacketRecords());

                }else{
                    T.show(mineRedPacketRecprdBean.getMsg());
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

    public void loadMoreData(List<MineRedPacketRecprdBean.BodyBean.RedPacketRecordsBean> apiOrderListMore){

        if(commentList == null){
            commentList = new ArrayList<>();
        }
        if(pageIndex == 0){
            mineRedPacketAdapter.Clear();
        }
        commentList.addAll(apiOrderListMore);
        if(pageIndex == 0){
            mineRedPacketAdapter.setmDate(commentList);
        }else{
            mineRedPacketAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }
}
