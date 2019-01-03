package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.DailyNewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.DailyNewBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 每日新店列表
 */

public class DailyNewActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.rv_daily_new_list)
    RecyclerView rv_daily_new_list;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_daily_new;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("每日新店");

        getDailyData();
    }

    /**
     * 获取每日新店数据
     */
    private void getDailyData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("shopCate", "1");
        params.put("cityCode",SP.get(this,SpContent.CityCode,"")+"");
        HttpUtils.doPost(ACTION.GETDAILYNEWDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
            /**
             * 底部商品列表
             */
            case ACTION.GETDAILYNEWDATA:
                L.e("...............                  "+res);
                DailyNewBean dailyNewBean = GsonUtil.toObj(res,DailyNewBean.class);
                if(dailyNewBean.isSuccess()&&dailyNewBean.getErrorCode().equals("0")){

                    DailyNewAdapter sbmitWholeAdapter = new DailyNewAdapter(DailyNewActivity.this, R.layout.layout_dailynew_list_item, dailyNewBean.getBody().getNewShopAndGoodsList());
                    rv_daily_new_list.setLayoutManager(new LinearLayoutManager(DailyNewActivity.this, LinearLayout.VERTICAL, false));
                    rv_daily_new_list.setAdapter(sbmitWholeAdapter);

                }else{
                    T.show(dailyNewBean.getMsg());
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
