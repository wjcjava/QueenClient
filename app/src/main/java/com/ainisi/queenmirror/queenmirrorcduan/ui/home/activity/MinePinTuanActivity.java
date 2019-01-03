package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullActivityGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanSuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.RedPacketOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.HomePageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 拼团成功
 */

public class MinePinTuanActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.iv_pintuan_head)
    ImageView iv_pintuan_head;
    @Bind(R.id.tv_pintuan_name)
    TextView tv_pintuan_name;
    @Bind(R.id.tv_pintuan_price)
    TextView tv_pintuan_price;
    @Bind(R.id.tv_pintuan_number)
    TextView tv_pintuan_number;
    @Bind(R.id.tv_pintuan_number_bottom_2)
    TextView tv_pintuan_number_bottom;
    @Bind(R.id.tvpintuan_date)
    TextView tvpintuan_date;
   /* @Bind(R.id.full_recycler)
    ScrollRecyclerView full_recycler;*/
   @Bind(R.id.nsgd_fullactivity_jingpin)
   NoScrollGridView nsgd_fullactivity_jingpin;

    @Bind(R.id.ic_mine_pintuan_two)
    LinearLayout ic_mine_pintuan_two;
    @Bind(R.id.ic_mine_pintuan_three)
    LinearLayout ic_mine_pintuan_three;
    @Bind(R.id.ic_mine_pintuan_five)
    LinearLayout ic_mine_pintuan_five;
    @Bind(R.id.ic_mine_pintuan_eight)
    LinearLayout ic_mine_pintuan_eight;
    @Bind(R.id.ic_mine_pintuan_ten)
    LinearLayout ic_mine_pintuan_ten;
    @Bind(R.id.civ_pintuan_head_2_first)
    CircleImageView civ_pintuan_head_2_first;
    @Bind(R.id.civ_pintuan_head_2_second)
    CircleImageView civ_pintuan_head_2_second;
    @Bind(R.id.civ_pintuan_head_3_first)
    CircleImageView civ_pintuan_head_3_first;
    @Bind(R.id.civ_pintuan_head_3_second)
    CircleImageView civ_pintuan_head_3_second;
    @Bind(R.id.civ_pintuan_head_3_third)
    CircleImageView civ_pintuan_head_3_third;
    @Bind(R.id.civ_pintuan_head_5_first)
    CircleImageView civ_pintuan_head_5_first;
    @Bind(R.id.civ_pintuan_head_5_second)
    CircleImageView civ_pintuan_head_5_second;
    @Bind(R.id.civ_pintuan_head_5_third)
    CircleImageView civ_pintuan_head_5_third;
    @Bind(R.id.civ_pintuan_head_5_forth)
    CircleImageView civ_pintuan_head_5_forth;
    @Bind(R.id.civ_pintuan_head_5_fivth)
    CircleImageView civ_pintuan_head_5_fivth;
    @Bind(R.id.civ_pintuan_head_8_first)
    CircleImageView civ_pintuan_head_8_first;
    @Bind(R.id.civ_pintuan_head_8_second)
    CircleImageView civ_pintuan_head_8_second;
    @Bind(R.id.civ_pintuan_head_8_third)
    CircleImageView civ_pintuan_head_8_third;
    @Bind(R.id.civ_pintuan_head_8_forth)
    CircleImageView civ_pintuan_head_8_forth;
    @Bind(R.id.civ_pintuan_head_8_fivth)
    CircleImageView civ_pintuan_head_8_fivth;
    @Bind(R.id.civ_pintuan_head_8_sixth)
    CircleImageView civ_pintuan_head_8_sixth;
    @Bind(R.id.civ_pintuan_head_8_sevth)
    CircleImageView civ_pintuan_head_8_sevth;
    @Bind(R.id.civ_pintuan_head_8_eight)
    CircleImageView civ_pintuan_head_8_eight;
    @Bind(R.id.civ_pintuan_head_10_first)
    CircleImageView civ_pintuan_head_10_first;
    @Bind(R.id.civ_pintuan_head_10_second)
    CircleImageView civ_pintuan_head_10_second;
    @Bind(R.id.civ_pintuan_head_10_third)
    CircleImageView civ_pintuan_head_10_third;
    @Bind(R.id.civ_pintuan_head_10_forth)
    CircleImageView civ_pintuan_head_10_forth;
    @Bind(R.id.civ_pintuan_head_10_fivth)
    CircleImageView civ_pintuan_head_10_fivth;
    @Bind(R.id.civ_pintuan_head_10_sixth)
    CircleImageView civ_pintuan_head_10_sixth;
    @Bind(R.id.civ_pintuan_head_10_sevth)
    CircleImageView civ_pintuan_head_10_sevth;
    @Bind(R.id.civ_pintuan_head_10_eight)
    CircleImageView civ_pintuan_head_10_eight;
    @Bind(R.id.civ_pintuan_head_10_nine)
    CircleImageView civ_pintuan_head_10_nine;
    @Bind(R.id.civ_pintuan_head_10_ten)
    CircleImageView civ_pintuan_head_10_ten;

    String groupId,orderNo;
    int pageNumber = 1;
    LoadingDialog loadingDialog;
    private CommendGoodBean goodBean;
    FullGoodsAdapter myAdapter;
    String payType;

    List<String> heads_pic = new ArrayList<>();
    String money = "0",bottom,text;

    Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_pin_tuan;
    }

    @OnClick({R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(dialog != null){
            dialog.dismiss();
        }
    }

    @Override
    public void initView() {
        loadingDialog = new LoadingDialog(this);
        title_title.setText("我的拼团");

        Intent intent = this.getIntent();
        groupId = intent.getStringExtra("groupId");
        orderNo = intent.getStringExtra("orderNo");
        payType = intent.getStringExtra("payType");

        getMinePintuanData();

        initshophttp();

        SuccessGetPacket();
    }

    /**
     *  判断是否是首次订单
     */
    private void SuccessGetPacket() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("flag","1");
        parames.put("platformType","1");//
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.ISFIRSTORDER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取拼团后的数据
     */
    private void getMinePintuanData() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("groupId", groupId);//拼团商品的ID
        parames.put("orderNo","");
        parames.put("payType",payType);
        parames.put("custId",SP.get(MinePinTuanActivity.this,SpContent.UserId,"")+"");
        parames.put("token", SP.get(MinePinTuanActivity.this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETPINTUANAFTER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    /**
     * 商家精品推荐商品的数据
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", pageNumber+"");
        hashMap1.put("cityCode", SP.get(this,SpContent.CityCode,"")+"");//shopId  111
        hashMap1.put("pageSize", SpContent.pageSize);
        hashMap1.put("token",SP.get(MinePinTuanActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void DialogByRedOrder() {
        SP.put(MinePinTuanActivity.this,SpContent.isRedPacket,"1");

        final AlertDialog.Builder builder = new AlertDialog.Builder(MinePinTuanActivity.this,R.style.dialog);
        LayoutInflater inflater = LayoutInflater.from(MinePinTuanActivity.this);
        View v = inflater.inflate(R.layout.homepage_red_packet_order_two, null);//注册
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

        ImageView iv_home_page_dissmiss = v.findViewById(R.id.iv_home_page_dissmiss);
        iv_home_page_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        TextView tv_red_packet_top = v.findViewById(R.id.tv_red_packet_top);
        tv_red_packet_top.setText(money);
        TextView tv_red_packet_bootom = v.findViewById(R.id.tv_red_packet_bootom);

        TextView tv_red_packet_regist = v.findViewById(R.id.tv_red_packet_regist);
        tv_red_packet_regist.setText(text);

        tv_red_packet_bootom.setText(bottom);
        tv_red_packet_bootom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(MinePinTuanActivity.this,HomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){

            /**
             * 是否为首单红包
             */
            case ACTION.ISFIRSTORDER:

                RedPacketOrderBean redPacketOrderBean = GsonUtil.toObj(res,RedPacketOrderBean.class);
                if(redPacketOrderBean.isSuccess()&&redPacketOrderBean.getErrorCode().equals("0")){
                    if(redPacketOrderBean.getBody().getStatus().equals("-1")){
                        /**
                         * 用户不符合条件
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("0")){
                        /**
                         * 首单红包不存在
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("1")){
                        /**
                         * 领取条件为非会员用户或者 领取条件为会员用户
                         */
                    }else if(redPacketOrderBean.getBody().getStatus().equals("2")){
                        /**
                         * 分情况
                         */
                        if(redPacketOrderBean.getBody().getHasReceive().equals("0")){
                            money = redPacketOrderBean.getBody().getAnsRedPacket().getRedPacketMoney();
                            bottom = redPacketOrderBean.getBody().getAnsRedPacket().getOpenButtonTitle();
                            text = redPacketOrderBean.getBody().getAnsRedPacket().getOpenBottomTitle();
                            DialogByRedOrder();
                        }else{
                        }
                    }
                }else{
                    T.show(redPacketOrderBean.getMsg());
                }
                break;
            case ACTION.GETPINTUANAFTER:
                loadingDialog.cancel();
                PinTuanSuccessBean pinTuanSuccessBean = GsonUtil.toObj(res,PinTuanSuccessBean.class);
                if(pinTuanSuccessBean.isSuccess()){
                    String pic = pinTuanSuccessBean.getBody().getGoodsPic();
                    String[] Pic = pic.split(",");
                    Glide.with(MinePinTuanActivity.this).load(Pic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_pintuan_head);
                    tv_pintuan_name.setText(pinTuanSuccessBean.getBody().getGroupName());
                    tv_pintuan_price.setText("¥"+pinTuanSuccessBean.getBody().getGroupPrice());
                    tv_pintuan_number.setText("已拼"+(pinTuanSuccessBean.getBody().getSaleNums())+"件");
                    tv_pintuan_number_bottom.setText(pinTuanSuccessBean.getBody().getJoinNums()+"");
                    tvpintuan_date.setText(pinTuanSuccessBean.getBody().getEndDate().substring(0,10)+"后结束");

                    heads_pic = pinTuanSuccessBean.getBody().getHeadPics();

                    String groupNums = pinTuanSuccessBean.getBody().getGroupNums()+"";
                    if(groupNums.equals("2")){
                        ic_mine_pintuan_two.setVisibility(View.VISIBLE);
                        ic_mine_pintuan_three.setVisibility(View.GONE);
                        ic_mine_pintuan_five.setVisibility(View.GONE);
                        ic_mine_pintuan_eight.setVisibility(View.GONE);
                        ic_mine_pintuan_ten.setVisibility(View.GONE);

                        if(heads_pic.size() == 1){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_2_first);
                        }else{
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_2_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_2_second);
                        }

                    }else if(groupNums.equals("3")){
                        ic_mine_pintuan_two.setVisibility(View.GONE);
                        ic_mine_pintuan_three.setVisibility(View.VISIBLE);
                        ic_mine_pintuan_five.setVisibility(View.GONE);
                        ic_mine_pintuan_eight.setVisibility(View.GONE);
                        ic_mine_pintuan_ten.setVisibility(View.GONE);

                        if(heads_pic.size() == 1){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_3_first);
                        }else if(heads_pic.size() == 2){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_3_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_3_second);
                        }else{
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_3_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_3_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_3_third);
                        }
                    }else if(groupNums.equals("5")){
                        ic_mine_pintuan_two.setVisibility(View.GONE);
                        ic_mine_pintuan_three.setVisibility(View.GONE);
                        ic_mine_pintuan_five.setVisibility(View.VISIBLE);
                        ic_mine_pintuan_eight.setVisibility(View.GONE);
                        ic_mine_pintuan_ten.setVisibility(View.GONE);


                        if(heads_pic.size() == 1){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_5_first);
                        }else if(heads_pic.size() == 2){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_5_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_5_second);
                        }else if(heads_pic.size() == 3){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_5_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_5_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_5_third);
                        }else if(heads_pic.size() == 4){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_5_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_5_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_5_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_5_forth);
                        }else if(heads_pic.size() == 5){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_5_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_5_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_5_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_5_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_5_fivth);
                        }
                    }else if(groupNums.equals("8")){
                        ic_mine_pintuan_two.setVisibility(View.GONE);
                        ic_mine_pintuan_three.setVisibility(View.GONE);
                        ic_mine_pintuan_five.setVisibility(View.GONE);
                        ic_mine_pintuan_eight.setVisibility(View.VISIBLE);
                        ic_mine_pintuan_ten.setVisibility(View.GONE);


                        if(heads_pic.size() == 1){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                        }else if(heads_pic.size() == 2){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                        }else if(heads_pic.size() == 3){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                        }else if(heads_pic.size() == 4){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_8_forth);
                        }else if(heads_pic.size() == 5){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_8_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_8_fivth);
                        }else if(heads_pic.size() == 6){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_8_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_8_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_8_sixth);
                        }else if(heads_pic.size() == 7){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_8_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_8_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_8_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_8_sevth);
                        }else if(heads_pic.size() == 8){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_8_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_8_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_8_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_8_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_8_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_8_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_8_sevth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(7)).dontAnimate().into(civ_pintuan_head_8_eight);
                        }
                    }else if(groupNums.equals("10")){
                        ic_mine_pintuan_two.setVisibility(View.GONE);
                        ic_mine_pintuan_three.setVisibility(View.GONE);
                        ic_mine_pintuan_five.setVisibility(View.GONE);
                        ic_mine_pintuan_eight.setVisibility(View.GONE);
                        ic_mine_pintuan_ten.setVisibility(View.VISIBLE);

                        if(heads_pic.size() == 1){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                        }else if(heads_pic.size() == 2){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                        }else if(heads_pic.size() == 3){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                        }else if(heads_pic.size() == 4){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                        }else if(heads_pic.size() == 5){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                        }else if(heads_pic.size() == 6){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_10_sixth);
                        }else if(heads_pic.size() == 7){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_10_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_10_sevth);
                        }else if(heads_pic.size() == 8){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_10_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_10_sevth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(7)).dontAnimate().into(civ_pintuan_head_10_eight);
                        }else if(heads_pic.size() == 9){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_10_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_10_sevth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(7)).dontAnimate().into(civ_pintuan_head_10_eight);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(8)).dontAnimate().into(civ_pintuan_head_10_nine);
                        }else if(heads_pic.size() == 10){
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(0)).dontAnimate().into(civ_pintuan_head_10_first);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(1)).dontAnimate().into(civ_pintuan_head_10_second);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(2)).dontAnimate().into(civ_pintuan_head_10_third);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(3)).dontAnimate().into(civ_pintuan_head_10_forth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(4)).dontAnimate().into(civ_pintuan_head_10_fivth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(5)).dontAnimate().into(civ_pintuan_head_10_sixth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(6)).dontAnimate().into(civ_pintuan_head_10_sevth);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(7)).dontAnimate().into(civ_pintuan_head_10_eight);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(8)).dontAnimate().into(civ_pintuan_head_10_nine);
                            Glide.with(MinePinTuanActivity.this).load(heads_pic.get(9)).dontAnimate().into(civ_pintuan_head_10_ten);
                        }
                    }
                }else{
                    T.show(pinTuanSuccessBean.getMsg());
                }
                break;
            /**
             * 精品推荐
             */
            case ACTION.COMMENDGOODS:
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if(goodBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (goodBean.isSuccess()) {
                        final List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();

                        FullActivityGridViewAdapter gridViewAdapter = new FullActivityGridViewAdapter(MinePinTuanActivity.this, list);
                        nsgd_fullactivity_jingpin.setAdapter(gridViewAdapter);

                    } else {
                        T.show(goodBean.getMsg());
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
