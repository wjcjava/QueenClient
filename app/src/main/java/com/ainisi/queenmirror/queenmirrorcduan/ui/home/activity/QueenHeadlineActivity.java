package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.QueeHeadLineAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PageBannerBean;
import com.google.zxing.WriterException;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 女王活动
 */
public class QueenHeadlineActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.rv_queen_headline_list)
    RecyclerView rv_queen_headline_list;

    private List<PageBannerBean.BodyBean.BannerListDataBean> bannerList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_queen_headline;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("女王活动");
        bannerList = getIntent().getParcelableArrayListExtra("bannerList");

        QueeHeadLineAdapter myAdapter = new QueeHeadLineAdapter(this, bannerList);
        rv_queen_headline_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_queen_headline_list.setAdapter(myAdapter);

    }

    @OnClick({R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
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
