package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MasterActivity extends BaseNewActivity {
    @Bind(R.id.re_master_evaluation)
    RecyclerView evaluation;
    @Bind(R.id.title_title)
    TextView masterTitle;
    private List<SortBean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_master;
    }

    @Override
    protected void initData() {
        super.initData();
        masterTitle.setText("纹身大师");
        masterTitle.setTextSize(16);
        for (int i = 0; i < 8; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            list.add(sortBean);
        }
        MyAdapter sortAdapter2 = new MyAdapter(R.layout.item_master_evaluation, list);

        evaluation.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        evaluation.setAdapter(sortAdapter2);
    }

    @OnClick({R.id.title_back})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;


        }


    }
}
