package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.CouponGetBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.bean.ShopDiscounBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 */

public class WorkSingleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1;
    private Context context;

    public WorkSingleAdapter(Context context, List<ShopDiscounBean.BodyBean.CouponListDataItemBean> list1) {
        this.context = context;
        this.list1=list1;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.re_workroom_single, parent, false);
            holder.tv_discount=convertView.findViewById(R.id.tv_discount);
            holder.tv_youxiao=convertView.findViewById(R.id.tv_youxiao);
            holder.tv_price=convertView.findViewById(R.id.tv_price);
            holder.rl_workshop_danpin = convertView.findViewById(R.id.rl_workshop_danpin);
            holder.img_overdue = convertView.findViewById(R.id.img_overdue);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv_discount.setText(list1.get(position).getCpCreateInfo().getCpName());
        holder.tv_price.setText("¥"+list1.get(position).getCpCreateInfo().getReduceAmount());
        holder.tv_youxiao.setText(list1.get(position).getCpCreateInfo().getUseFrom()+"-"+list1.get(position).getCpCreateInfo().getUseTo());

        if(list1.get(position).getCpGetRecord() == null){
            holder.rl_workshop_danpin.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_shap_queen));
            holder.img_overdue.setImageResource(R.drawable.icon_shop_receive);
        }else if(list1.get(position).getCpGetRecord().getGetStatus().equals("1")||list1.get(position).getCpGetRecord().getGetStatus().equals("2")||list1.get(position).getCpGetRecord().getGetStatus().equals("6")||list1.get(position).getCpGetRecord().getGetStatus().equals("9")){
            holder.rl_workshop_danpin.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_shap_youhuiquan));
            holder.img_overdue.setImageResource(R.drawable.ic_beuse);
        }

        holder.rl_workshop_danpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.inithttp(position);

              /*  holder.re_workroom.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_shap_youhuiquan));
                holder.img_overdue.setImageResource(R.drawable.ic_beuse);*/
            }
        });

        return convertView;
    }


    //就是View的持有
    public final class ViewHolder implements HttpCallBack{
        TextView tv_discount;
        TextView tv_youxiao;
        TextView tv_price;
        RelativeLayout rl_workshop_danpin;
        ImageView img_overdue;

        CouponGetBean couponGetBean;


        public void inithttp(int position) {
            HashMap<String, String> params = new HashMap<>();
            params.put("cpId", list1.get(position).getCpCreateInfo().getId());//优惠券ID
            params.put("userId", SP.get(context, SpContent.UserId,"")+"");//用户ID
            params.put("shopId", list1.get(position).getCpCreateInfo().getShopId());//商品ID
            params.put("token",SP.get(context,SpContent.UserToken,"")+"");
            HttpUtils.doPost(ACTION.COUPONGET, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        }

        @Override
        public void onSuccess(int action, String res) throws WriterException {
            switch (action) {
                case ACTION.COUPONGET:
                    couponGetBean = GsonUtil.toObj(res, CouponGetBean.class);
                    if(couponGetBean.getErrorCode().equals("6")){
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.putExtra("activite","no");
                        context.startActivity(intent);
                    }else {
                        if (couponGetBean.isSuccess() && couponGetBean.getErrorCode().equals("0")) {
                            T.show("领取成功");

                            WorkRoomDetailActivity.instance.geeshopDiscoun();
                        } else {
                            T.show(couponGetBean.getMsg());

                            WorkRoomDetailActivity.instance.geeshopDiscoun();
                        }
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
}
