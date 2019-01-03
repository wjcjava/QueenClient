package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommentsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 更多评价
 */
public class FullMoreCommentActivity extends BaseNewActivity implements HttpCallBack{

    String goodsId;
    int pageNumber = 1,pageSum=0;
    private CommentsBean commentsBean;
    @Bind(R.id.title_title)
    TextView title_title;

    @Bind(R.id.rv_full_more_coment)
    RecyclerView rv_full_more_coment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_full_more_comment;
    }

    @Override
    protected void initView() {
        super.initView();

        Intent intent = this.getIntent();
        goodsId = intent.getStringExtra("goodsId");

        title_title.setText("更多评价");
        inithttp();
    }

    /**
     * 商品的评价数据
     */
    private void inithttp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("goodsId", goodsId);
        hashMap.put("pageNumber", pageNumber+"");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("token", SP.get(FullMoreCommentActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.EVALUATION, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.EVALUATION:

                commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                if(commentsBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    List<CommentsBean.BodyBean.CommentsListDataBean> commList = commentsBean.getBody().getCommentsListData();
                    CommentsAdapter sortAdapter2 = new CommentsAdapter(FullMoreCommentActivity.this, R.layout.item_fullrecyclertwo, commList);
                    pageSum = commentsBean.getBody().getPageSum();
                    rv_full_more_coment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    rv_full_more_coment.setAdapter(sortAdapter2);
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

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }
}
