package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneAddBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SubmitPinTuanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpellOrderAdapter extends BaseQuickAdapter<FightaloneBean.BodyBean.GpOrderListBean,BaseViewHolder> implements HttpCallBack{

    int groupnum = 0;
    Context context;
    String goodsId,groupId,activityId,groupOrderId,orderId,goodsSales;
    String[] headPic;
    public SpellOrderAdapter(Context context,int layoutResId, @Nullable List<FightaloneBean.BodyBean.GpOrderListBean> data,int groupnum,
                             String goodsId,String activityId,String goodsSales) {
        super(layoutResId, data);
        this.groupnum = groupnum;
        this.context = context;
        this.goodsId = goodsId;
        this.activityId = activityId;
        this.goodsSales = goodsSales;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FightaloneBean.BodyBean.GpOrderListBean item) {
        Date date1 = new Date(Long.parseLong(item.getGpOrder().getEndTimes()));
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        helper.setText(R.id.tv_adapter_username,item.getAnsCustBasic().getUserName())
                .setText(R.id.tv_adapter_surplus,"还差"+(groupnum-item.getGpOrder().getJoinNums())+"人")
                .setText(R.id.tv_adapter_shengyu,"剩余时间"+format1.format(date1));

        if(item.getAnsCustBasic().getHeadPic() == null){

        }else {
            String head_pic = item.getAnsCustBasic().getHeadPic();
            headPic = head_pic.split(",");
            ImageView cv_adapter_headpic = helper.getView(R.id.cv_adapter_headpic);
            Glide.with(context).load(headPic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(cv_adapter_headpic);
        }


        helper.setOnClickListener(R.id.tv_home_goshare, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.dialog_fightalone_submit, null);
                final Dialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                RelativeLayout rl_top_dissmiss = v.findViewById(R.id.rl_top_dissmiss);
                TextView tv_dialog_name = v.findViewById(R.id.tv_dialog_name);
                TextView tv_dialog_number = v.findViewById(R.id.tv_dialog_number);
                TextView tv_dialog_date = v.findViewById(R.id.tv_dialog_date);
                CircleImageView civ_dialog_head = v.findViewById(R.id.civ_dialog_head);
                Button bt_dialog_pindan = v.findViewById(R.id.bt_dialog_pindan);

                rl_top_dissmiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_dialog_name.setText("参与"+item.getAnsCustBasic().getUserName()+"的拼单");
                tv_dialog_number.setText((groupnum-item.getGpOrder().getJoinNums())+"");
                tv_dialog_date.setText(item.getGpOrder().getEndDate().substring(0,10)+"过期");

                if(item.getAnsCustBasic().getHeadPic() == null){

                }else {
                    String head_pic = item.getAnsCustBasic().getHeadPic();
                    headPic = head_pic.split(",");
                    Glide.with(context).load(headPic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(civ_dialog_head);
                }

                groupId = item.getGpOrder().getGroupId();

                L.e("*************          "+groupId);

                bt_dialog_pindan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        PinTuanData();
                    }
                });
            }
        });
    }

    /**
     * 拼团Data(点击拼团)
     */
    private void PinTuanData() {
        /**
         * platform ：3”（固定值）  purchaseNumber ：1”（购买数量）  groupId：“”(建团不需要传值，参加拼团传拼团ID)
         * grouptype：“2”（拼团模式固定值）
         * ifrefund：“1”（固定值）   isOwner：“0”（是否房主    建团传0，参团传1）
         */
        HashMap<String, String> parames = new HashMap<>();
        parames.put("goodsId", goodsId);//拼团商品的ID
        parames.put("userId", SP.get(context, SpContent.UserId,"0")+"");
        parames.put("token",SP.get(context,SpContent.UserToken,"")+"");
        parames.put("platform","3");
        parames.put("purchaseNumber","1");
        parames.put("activityId",activityId);
        parames.put("groupId",groupId);
        parames.put("grouptype","2");
        parames.put("ifrefund","1");
        parames.put("isOwner","1");
        HttpUtils.doPost(ACTION.ADDPINTUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            /**
             * 点击拼团
             */
            case ACTION.ADDPINTUAN:
                FightaloneAddBean fightaloneAddBean = GsonUtil.toObj(res, FightaloneAddBean.class);
                if (fightaloneAddBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                } else {
                    if (fightaloneAddBean.isSuccess() && fightaloneAddBean.getErrorCode().equals("0")) {
                        groupOrderId = fightaloneAddBean.getBody().getGroupOrderId();
                        orderId = fightaloneAddBean.getBody().getOrderId();

                        Intent intent = new Intent(context, SubmitPinTuanActivity.class);
                        intent.putExtra("businessIds", orderId);
                        intent.putExtra("amount", goodsSales);
                        intent.putExtra("groupId", groupId);
                        intent.putExtra("groupIds",groupId);
                        context.startActivity(intent);
                    } else {
                        T.show(fightaloneAddBean.getMsg());
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
