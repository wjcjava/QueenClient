package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by john on 2018/5/11.
 *
 * jl
 */

public class CommentsAdapter extends BaseQuickAdapter<CommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder> {

    Context context;


    public CommentsAdapter(Context context,int layoutResId, @Nullable List<CommentsBean.BodyBean.CommentsListDataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentsBean.BodyBean.CommentsListDataBean item) {

        helper.setText(R.id.tv_evaluate,item.getEcAppraiseGoods().getApprDetails())
                .setText(R.id.tv_member,item.getEcAppraiseGoods().getApprTime())
                .setText(R.id.tv_consum,"消费评价-"+item.getShopIdName());

        CircleImageView iv_title = helper.getView(R.id.iv_title);
        if(item.getHeadPic() == null){

        }else{
            String head_pic = item.getHeadPic();
            String[] headPic = head_pic.split(",");
            Glide.with(context).load(headPic[0]).dontAnimate().into(iv_title);
        }

        if(item.getEcAppraiseGoods().getIfAnon().equals("1")){
            helper.setText(R.id.tv_name,"匿名用户");
        }else{
            helper.setText(R.id.tv_name,item.getCustIdName());
        }


        CustomRatingBar score_goods_comment_evaluate = helper.getView(R.id.score_goods_comment_evaluate);
        float level ;

        if(item.getEcAppraiseGoods().getEmployeeAbility() == null||item.getEcAppraiseGoods().getEmployeeAbility().equals("")||item.getEcAppraiseGoods().getEmployeeAbility().equals("0.0")){
            level = 3.5f;
        }else{
            level = Float.parseFloat(item.getEcAppraiseGoods().getEmployeeAbility());
        }
        score_goods_comment_evaluate.setRating(level);
        NoScrollGridView gv_fullactivity_gridView = helper.getView(R.id.gv_fullactivity_gridView);

        if(item.getEcAppraiseGoods().getApprPic()== null ||item.getEcAppraiseGoods().getApprPic().equals("")){
            gv_fullactivity_gridView.setVisibility(View.GONE);
        }else{
            gv_fullactivity_gridView.setVisibility(View.VISIBLE);

            String apprPic = item.getEcAppraiseGoods().getApprPic()+"";
            String[] appPics = apprPic.split(",");
            CommentGridViewAdapter gridViewAdapter = new CommentGridViewAdapter(context, appPics);
            gv_fullactivity_gridView.setAdapter(gridViewAdapter);
        }
    }
}
