package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.SelectCityAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SelectCityBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeNewFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author weikailiang
 * @function Created on 2017/8/4.
 * 位置
 */
public class SelectCityActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView StTitle;
    @Bind(R.id.rc_selsctcity)
    RecyclerView HmSelecity;
    @Bind(R.id.tv_select_city_gps)
    TextView tv_select_city_gps;

    @Override
    public int getLayoutId() {
        return R.layout.activity_selectcity_layout;
    }

    @Override
    public void initView() {
        StTitle.setText("选择城市");
        initDate();
    }

    private void initDate() {
        HashMap<String, String> hashMap = new HashMap<>();
        HttpUtils.doPost(ACTION.GETCITYLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//获取已开通城市
    }

    @OnClick({R.id.title_back, R.id.tv_select_city_gps})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_select_city_gps:
                HomeNewFragment.instance.mLocation.setText(tv_select_city_gps.getText().toString() + " ");
                SelectCityActivity.this.finish();
                break;
            default:
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) {

        switch (action) {
            case ACTION.GETCITYLIST:

                final SelectCityBean selectCityBean = GsonUtil.toObj(res, SelectCityBean.class);
                if(selectCityBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    SelectCityAdapter sortAdapter = new SelectCityAdapter(R.layout.activity_city_layout, selectCityBean.getBody().getCityListData());
                    HmSelecity.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    HmSelecity.setAdapter(sortAdapter);

                    sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            L.e("&^&^&^&^              "+selectCityBean.getBody().getCityListData().get(position).getArea().getCode());
                            SP.put(SelectCityActivity.this, SpContent.CityCode, selectCityBean.getBody().getCityListData().get(position).getArea().getCode());
                            HomeNewFragment.instance.mLocation.setText(selectCityBean.getBody().getCityListData().get(position).getArea().getName() + " ");
                            SelectCityActivity.this.finish();
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
}