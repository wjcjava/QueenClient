package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RefundReasonAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 退款原因
 */
public class RefundReasonActivity extends BaseNewActivity {
    @Bind(R.id.re_refundReason)
    RecyclerView recyclerView;
    @Bind(R.id.title_title)
    TextView refundReasonTitle;
    private List<String> list = new ArrayList<>();

    String where = "";

    public static RefundReasonActivity instance = null;
    @Override
    protected int getLayoutId() {
        instance = this;
        return R.layout.activity_refund_reason;
    }

    @Override
    protected void initView() {
        super.initView();
        refundReasonTitle.setText(R.string.arefund_reason);

    }
    @Override
    protected void initData() {
        super.initData();
        list.add("不喜欢/效果不好");
        list.add("拍错了");
        list.add("不想去了");
        list.add("重拍");
        list.add("太远了");
        list.add("其他");

        Intent intent = this.getIntent();
        where = intent.getStringExtra("where");

        RefundReasonAdapter sbmitWholeAdapter = new RefundReasonAdapter(R.layout.refundreason_re_listitem, list,where);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(sbmitWholeAdapter);
    }
    @OnClick({R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }
}