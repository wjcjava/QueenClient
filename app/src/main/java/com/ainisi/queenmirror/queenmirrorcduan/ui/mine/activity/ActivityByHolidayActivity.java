package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HolidayGridAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HolidayListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HolidayListBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 节日活动
 */
public class ActivityByHolidayActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.nli_holiday_list)
    NoScrollListview nli_holiday_list;
    @Bind(R.id.nsg_holiday_gridview)
    NoScrollGridView nsg_holiday_gridview;
    @Bind(R.id.sc_holiday_scroll)
    ScrollView sc_holiday_scroll;
    @Bind(R.id.li_holiday_out)
    LinearLayout li_holiday_out;
    @Bind(R.id.iv_holiday_topimage)
    ImageView iv_holiday_topimage;

    HolidayListAdapter holidayListAdapter;
    HolidayGridAdapter holidayGridAdapter;

    List<HolidayListBean.BodyBean.BannerListBean> bannerList = new ArrayList<>();
    List<HolidayListBean.BodyBean.GoodslistBean> goodslist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_by_holiday;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("中秋拼团");

        getListData();

        sc_holiday_scroll.smoothScrollTo(0,0);
        sc_holiday_scroll.setFocusableInTouchMode(true);
        sc_holiday_scroll.requestFocus();

    }

    /**
     * 获取数据
     */
    private void getListData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("platformType", "1");
        parames.put("bannerActivityType","mid-autumn-festival");
        HttpUtils.doPost(ACTION.GETACTIVITYLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
            case ACTION.GETACTIVITYLIST:

                HolidayListBean holidayListBean = GsonUtil.toObj(res,HolidayListBean.class);
                if(holidayListBean.isSuccess()&&holidayListBean.getErrorCode().equals("0")){
                    String color = holidayListBean.getBody().getColorNo();
                    li_holiday_out.setBackgroundColor(android.graphics.Color.parseColor("#"+color));
                    String top_image = holidayListBean.getBody().getAnsBannerphoto().getBannerLogo();
                    Glide.with(ActivityByHolidayActivity.this).load(top_image).dontAnimate().into(iv_holiday_topimage);

                    bannerList = holidayListBean.getBody().getBannerList();
                    goodslist = holidayListBean.getBody().getGoodslist();


                    holidayListAdapter = new HolidayListAdapter(ActivityByHolidayActivity.this,bannerList);
                    nli_holiday_list.setAdapter(holidayListAdapter);

                    holidayGridAdapter = new HolidayGridAdapter(ActivityByHolidayActivity.this,goodslist);
                    nsg_holiday_gridview.setAdapter(holidayGridAdapter);
                }else{
                    T.show(holidayListBean.getMsg());
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
