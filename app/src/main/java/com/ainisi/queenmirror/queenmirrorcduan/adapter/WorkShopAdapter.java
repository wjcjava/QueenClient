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
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Mloong on 2017/11/25.
 *
 * jl
 */

public class WorkShopAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<ShopDiscounBean.BodyBean.CouponListDataBean> list;
    private Context context;
    private CouponGetBean couponGetBean;


    public WorkShopAdapter(Context context, List<ShopDiscounBean.BodyBean.CouponListDataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView = inflater.inflate(R.layout.re_workroom_coupon, parent, false);
            holder.counName = convertView.findViewById(R.id.tv_shop_discount);
            holder.couneMoney = convertView.findViewById(R.id.tv_shop_money);
            holder.couneConditions = convertView.findViewById(R.id.tv_coune_conditions);
            holder.couneTime = convertView.findViewById(R.id.tv_coune_time);
            holder.img_overdue = convertView.findViewById(R.id.img_overdue);
            holder.re_workroom = convertView.findViewById(R.id.re_workroom);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.counName.setText(list.get(position).getCpCreateInfo().getCpName());
        holder.couneMoney.setText(MD5.doubleToString(list.get(position).getCpCreateInfo().getReduceAmount()) + "元");

        if(list.get(position).getCpCreateInfo().getFullCondition().equals("")){
            holder.couneConditions.setText("无条件使用");
        }else{

            String s= list.get(position).getCpCreateInfo().getFullCondition();
            String[] str = s.split("-");
            holder.couneConditions.setText("满"+str[0]+"元可使用");
        }
        holder.couneTime.setText(list.get(position).getCpCreateInfo().getUseFrom()+"-"+list.get(position).getCpCreateInfo().getUseTo());


        if(list.get(position).getCpGetRecord() == null){
            holder.re_workroom.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_shap_queen));
            holder.img_overdue.setImageResource(R.drawable.icon_shop_receive);
        }else if(list.get(position).getCpGetRecord().getGetStatus().equals("1")||list.get(position).getCpGetRecord().getGetStatus().equals("2")||list.get(position).getCpGetRecord().getGetStatus().equals("6")||list.get(position).getCpGetRecord().getGetStatus().equals("9")){
            holder.re_workroom.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_shap_youhuiquan));
            holder.img_overdue.setImageResource(R.drawable.ic_beuse);
        }

        holder.re_workroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(SP.get(context,SpContent.isLogin,"0").toString().equals("1")){
                    holder.inithttp(position);
                }else{
                    context.startActivity(new Intent(context, LoginActivity.class));
                    T.show("请登录APP");
                }
            }
        });

        return convertView;
    }
    //就是View的持有
    public final class ViewHolder implements HttpCallBack {
        TextView counName;
        TextView couneMoney;
        TextView couneConditions;
        TextView couneTime;
        ImageView img_overdue;
        RelativeLayout re_workroom;

        public void inithttp(int position) {
            HashMap<String, String> params = new HashMap<>();
            params.put("cpId", list.get(position).getCpCreateInfo().getId());//优惠券ID
            params.put("userId", SP.get(context, SpContent.UserId,"")+"");//用户ID
            params.put("shopId", list.get(position).getCpCreateInfo().getShopId());//商品ID
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
