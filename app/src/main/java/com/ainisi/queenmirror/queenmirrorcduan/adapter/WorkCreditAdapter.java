package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopCommentBean;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mloong on 2017/11/25.
 * <p>
 * jl
 */

public class WorkCreditAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context context;
    List<ShopCommentBean.BodyBean.EcAppraiseGoodsListBean> ecAppraiseGoodsList = new ArrayList<>();

    public WorkCreditAdapter(Context context, List<ShopCommentBean.BodyBean.EcAppraiseGoodsListBean> ecAppraiseGoodsList) {
        this.context = context;
        this.ecAppraiseGoodsList = ecAppraiseGoodsList;
        inflater = LayoutInflater.from(context);
    }

    public void Clear() {
        ecAppraiseGoodsList.clear();
        notifyDataSetChanged();
    }

    public void setmDate(List<ShopCommentBean.BodyBean.EcAppraiseGoodsListBean> ecAppraiseGoodsList) {
        this.ecAppraiseGoodsList = ecAppraiseGoodsList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return ecAppraiseGoodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_fullrecyclertwo, parent, false);
            holder.iv_title = convertView.findViewById(R.id.iv_title);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_evaluate = convertView.findViewById(R.id.tv_evaluate);
            holder.tv_consum = convertView.findViewById(R.id.tv_consum);
            holder.tv_member = convertView.findViewById(R.id.tv_member);
            holder.score_goods_comment_evaluate = convertView.findViewById(R.id.score_goods_comment_evaluate);
            holder.gv_fullactivity_gridView = convertView.findViewById(R.id.gv_fullactivity_gridView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String head_pic = ecAppraiseGoodsList.get(position).getCustHeadPic();
        Glide.with(context).load(head_pic).dontAnimate().placeholder(R.drawable.dismiss).into(holder.iv_title);
        holder.tv_evaluate.setText(ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getApprDetails());
        holder.tv_member.setText(ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getApprTime());

        if (ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getIfAnon().equals("1")) {
            holder.tv_name.setText("匿名用户");
        } else {
            holder.tv_name.setText(ecAppraiseGoodsList.get(position).getCustIdName());
        }

        float level;
        if (ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getEmployeeAbility() == null || ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getEmployeeAbility().equals("") || ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getEmployeeAbility().equals("0.0")) {
            level = 3.5f;
        } else {
            level = Float.parseFloat(ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getEmployeeAbility());
        }
        holder.score_goods_comment_evaluate.setRating(level);


        if (ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getApprPic() == null || ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getApprPic().equals("")) {
            holder.gv_fullactivity_gridView.setVisibility(View.GONE);
        } else {
            holder.gv_fullactivity_gridView.setVisibility(View.VISIBLE);

            String apprPic = ecAppraiseGoodsList.get(position).getEcAppraiseGoods().getApprPic() + "";
            String[] appPics = apprPic.split(",");
            CommentGridViewAdapter gridViewAdapter = new CommentGridViewAdapter(context, appPics);
            holder.gv_fullactivity_gridView.setAdapter(gridViewAdapter);
        }
        return convertView;
    }

    //就是View的持有
    public final class ViewHolder {

        private CircleImageView iv_title;
        private TextView tv_name;
        private TextView tv_evaluate;
        private TextView tv_consum;
        private TextView tv_member;
        private CustomRatingBar score_goods_comment_evaluate;
        private NoScrollGridView gv_fullactivity_gridView;
    }
}
