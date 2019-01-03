package com.ainisi.queenmirror.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ainisi.queenmirror.common.baserx.RxManager;
import com.ainisi.queenmirror.common.commonutils.SPManager;
import com.ainisi.queenmirror.common.commonutils.TUtil;
import com.ainisi.queenmirror.common.commonutils.network.NetWorkUtils;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;


/**
 * des:基类fragment
 * Created by xsf
 * on 2016.07.12:38
 */

public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    private KProgressHUD hud;
    public NetWorkUtils mNetWorkUtils;
    protected boolean isInit = false;
    protected boolean isLoad = false;

    protected boolean bIsViewCreated;
    protected boolean bIsDataLoaded;

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getName()); //
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(this.getClass().getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new RxManager();
        ButterKnife.bind(this, rootView);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
            mPresenter.mActivity = this.getActivity();
        }
        mNetWorkUtils = new NetWorkUtils(getContext());
        mNetWorkUtils.registerNetBroadCast();
        initPresenter();
        initView();
        //处理viewpager预加载问题
        isInit = true;
        /**初始化的时候去加载数据**/

        bIsViewCreated = true;

        if (getUserVisibleHint() && !bIsDataLoaded) {
            bIsDataLoaded = true;
            doFitsrData();
        }
        return rootView;
    }

    //获取布局文件
    protected abstract int getLayoutResource();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();


    //初始化view
    protected abstract void initView();

    //检查登录
    public void checkLogin() {
        if (!SPManager.getInstance().isLogin()) {
            try {
                Class c = Class.forName("com.ailisi.queenmirror.ui.user.activity.LoginActivity");
                startActivity(c);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void doFitsrData();

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && bIsViewCreated && !bIsDataLoaded) {
            doFitsrData();
            bIsDataLoaded = true;
        }
        //isCanLoadData();
    }

    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }


    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected void lazyLoad() {
    }

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

        bIsViewCreated = false;
        bIsDataLoaded = false;

        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
        mNetWorkUtils.unregisterNetBroadCast();
    }


}
