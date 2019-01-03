package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SecKillCombinationActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.SeckillAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SecKillListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SeckillTabBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * 作者：linxi on 2018/9/27 16:28
 * 邮箱：707078566@qq.com
 * 用途：秒杀Fragment
 */
public class SecKillFragment extends BaseFragment implements OnRefreshListener, OnLoadmoreListener, HttpCallBack {
    @Bind(R.id.seckill_lv)
    NoScrollListview mSeckillLv;
    @Bind(R.id.seckill_refreshLayout)
    SmartRefreshLayout mSeckillRefreshLayout;
    @Bind(R.id.seckill_content)
    TextView mSeckillContent;
    @Bind(R.id.seckill_time_tv)
    TextView mSeckillTimeTv;
    @Bind(R.id.tv_miaosha_shi)
    TextView mTvMiaoshaShi;
    @Bind(R.id.tv_miaosha_minter)
    TextView mTvMiaoshaMinter;
    @Bind(R.id.tv_miaosha_second)
    TextView mTvMiaoshaSecond;
    @Bind(R.id.miaosha_ll)
    LinearLayout mMiaoshaLl;
    private SeckillAdapter mAdapter;
    private myHandler mMyHandler;
    private SeckillTabBean.BodyBean.ListBean mListBean;
    private String time;
    private int pageNumber = 1;
    private int pageSize = 10;
    private int position;
    private boolean isskill = true;
    private int type;

    private FragmentInteraction listterner;

    public interface FragmentInteraction {
        void process(int position, int type);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_seckill;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mSeckillLv.setFocusable(false);
        mSeckillRefreshLayout.setOnRefreshListener(this);
        mSeckillRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected void doFitsrData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mListBean = (SeckillTabBean.BodyBean.ListBean) bundle.getSerializable("bean");
            position = bundle.getInt("position");
        }
        setDefault();
        secKillActivity();
    }

    private void setDefault() {
        switch (mListBean.getStateType()) {
            //已秒杀
            case 1:
                isskill = false;
                mSeckillContent.setText(getString(R.string.seckill_2));
                mMiaoshaLl.setVisibility(View.GONE);
                mSeckillTimeTv.setText(getString(R.string.seckill_4));
                break;
            //秒杀中
            case 2:
                type = 2;
                isskill = true;
                time = mListBean.getEndTime();
                mMiaoshaLl.setVisibility(View.VISIBLE);
                if (mMyHandler == null)
                    mMyHandler = new myHandler(this);
                mMyHandler.sendEmptyMessage(0);
                mSeckillContent.setText(getString(R.string.seckill_1));
                mSeckillTimeTv.setText(getString(R.string.seckill_5));
                break;
            //即将秒杀
            case 3:
                type = 3;
                isskill = true;
                time = mListBean.getBeginTime();
                mMiaoshaLl.setVisibility(View.VISIBLE);
                if (mMyHandler == null)
                    mMyHandler = new myHandler(this);
                mMyHandler.sendEmptyMessage(0);
                mSeckillContent.setText(getString(R.string.seckill_3));
                mSeckillTimeTv.setText(getString(R.string.seckill_6));
                break;
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        pageNumber = 1;
        secKillActivity();
        refreshLayout.finishRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshLayout) {
        pageNumber++;
        secKillActivity();
        refreshLayout.finishLoadmore();
    }

    private void secKillActivity() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("secKillActivityId", mListBean.getId());
        hashMap1.put("pageNumber", String.valueOf(pageNumber));
        hashMap1.put("pageSize", String.valueOf(pageSize));
        HttpUtils.doPost(ACTION.PACKAGELIST, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.PACKAGELIST:
                SecKillListBean listBean = GsonUtil.toObj(res, SecKillListBean.class);
                if (listBean.isSuccess()) {
                    if (mAdapter == null) {
                        mAdapter = new SeckillAdapter(getActivity());
                        mSeckillLv.setAdapter(mAdapter);
                    }
                    mAdapter.setType(mListBean.getStateType());
                    final List<SecKillListBean.BodyBean.ListBean> list = mAdapter.getList();
                    if (pageNumber == 1) {
                        list.clear();
                    }
                    list.addAll(listBean.getBody().getList());
                    mAdapter.notifyDataSetChanged();
                    mSeckillLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(getActivity(), SecKillCombinationActivity.class);
                            intent.putExtra("type", mListBean.getStateType());
                            intent.putExtra("id", list.get(i).getId());
                            intent.putExtra("begintime", mListBean.getBeginTime());
                            intent.putExtra("endtime", mListBean.getEndTime());
                            if (mListBean.getStateType() == 2 && list.get(i).getSalesProgressRate() < 100) {
                                intent.putExtra("isbuy", true);
                            } else {
                                intent.putExtra("isbuy", false);
                            }
                            startActivity(intent);
                        }
                    });
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

    class myHandler extends Handler {

        private WeakReference mActivityWeakReference;

        public myHandler(Fragment fragment) {
            this.mActivityWeakReference = new WeakReference<>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SecKillFragment fragment = (SecKillFragment) mActivityWeakReference.get();
            if (fragment != null && isskill == true) {
                countDown();
                sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    /**
     * 秒杀
     */
    private void countDown() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String format = df.format(curDate);
        StringBuffer buffer = new StringBuffer();
        String substring = format.substring(0, 11);
        buffer.append(substring);
        String totime = time;
        try {
            java.util.Date date = df.parse(totime);
            java.util.Date date1 = df.parse(format);
            long defferenttime = date.getTime() - date1.getTime();
            if (defferenttime >= 0) {
                long days = defferenttime / (1000 * 60 * 60 * 24);
                long hours = (defferenttime - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
                long minute = (defferenttime - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
                long seconds = defferenttime % 60000;
                long second = Math.round((float) seconds / 1000);
                if (mTvMiaoshaShi != null)
                    if (hours > 9) {
                        mTvMiaoshaShi.setText(hours + "");
                    } else {
                        mTvMiaoshaShi.setText("0" + hours + "");
                    }
                if (minute >= 10) {
                    if (mTvMiaoshaMinter != null)
                        mTvMiaoshaMinter.setText(minute + "");
                } else {
                    if (mTvMiaoshaMinter != null)
                        mTvMiaoshaMinter.setText("0" + minute + "");
                }
                if (second >= 10) {
                    if (mTvMiaoshaSecond != null)
                        mTvMiaoshaSecond.setText(second + "");
                } else {
                    if (mTvMiaoshaSecond != null)
                        mTvMiaoshaSecond.setText("0" + second + "");
                }
            } else {
                listterner.process(position, type);
                switch (type) {
                    case 2:
                        mListBean.setStateType(1);
                        break;
                    case 3:
                        mListBean.setStateType(2);
                        break;
                }
                setDefault();
                mSeckillRefreshLayout.autoRefresh();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteraction) {
            listterner = (FragmentInteraction) context;
        } else {
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listterner = null;
    }

    @Override
    public void onDestroy() {
        if (mMyHandler != null)
            mMyHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public SecKillFragment newInstance(SeckillTabBean.BodyBean.ListBean bean, int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        bundle.putInt("position", i);
        SecKillFragment testFm = new SecKillFragment();
        testFm.setArguments(bundle);
        return testFm;
    }
}
