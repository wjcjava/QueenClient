package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/17.
 *
 * jl
 */

public class MyCommentsAdapter extends BaseQuickAdapter<MyCommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder>{

    private final Context context;
    private List<MyCommentsBean.BodyBean.CommentsListDataBean> data;

    public MyCommentsAdapter(int layoutResId, @Nullable List<MyCommentsBean.BodyBean.CommentsListDataBean> data, Context context) {
        super(layoutResId, data);
        this.data = data;
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MyCommentsBean.BodyBean.CommentsListDataBean item) {
        helper.setText(R.id.tv_shopname,item.getShopIdName())
                .setText(R.id.tv_mine_evaluate_goodname,item.getGoodsIdName())
                .setText(R.id.tv_mine_evaluate_content,item.getEcAppraiseGoods().getApprDetails());
        CustomRatingBar score_mine_evaluate = helper.getView(R.id.score_mine_evaluate);
        if(item.getEcAppraiseGoods().getEmployeeAbility().equals("")||item.getEcAppraiseGoods().getEmployeeAbility().equals("0.0")){
            score_mine_evaluate.setRating(3.5f);
        }else{
            score_mine_evaluate.setRating(Float.parseFloat(item.getEcAppraiseGoods().getEmployeeAbility()));
        }
        String logo_pic = item.getEcAppraiseGoods().getApprPic();
        String[] logoPic = logo_pic.split(",");

        NoScrollGridView gv_fullactivity_gridView = helper.getView(R.id.gv_mineevaluate_gridView);

        if(logo_pic== null ||logo_pic.equals("")){
            gv_fullactivity_gridView.setVisibility(View.GONE);
        }else{
            gv_fullactivity_gridView.setVisibility(View.VISIBLE);
            CommentGridViewAdapter gridViewAdapter = new CommentGridViewAdapter(context, logoPic);
            gv_fullactivity_gridView.setAdapter(gridViewAdapter);
        }
    }

    public void Clear(){
        data.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<MyCommentsBean.BodyBean.CommentsListDataBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }
}
