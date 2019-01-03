package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineQueenCardAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardFreeBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardRegistBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineQueenCardFreeActivity extends BaseActivity implements HttpCallBack {

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;

    @Bind(R.id.re_shop_mall)
    NoScrollGridView re_shop_mall;
    @Bind(R.id.iv_mine_title)
    CircleImageView iv_mine_title;
    @Bind(R.id.tv_user_name)
    TextView tv_user_name;
    @Bind(R.id.mine_queen_card_get2)
    TextView mine_queen_card_get2;
    @Bind(R.id.tv_mine_queen_card_free_date)
    TextView tv_mine_queen_card_free_date;
    @Bind(R.id.tv_mine_queen_card_freetext)
    TextView tv_mine_queen_card_freetext;
    @Bind(R.id.tv_mine_queen_card_regist_day)
    TextView tv_mine_queen_card_regist_day;
    @Bind(R.id.mine_queen_card_get)
    TextView mine_queen_card_get;
    @Bind(R.id.rl_mine_queen_card_free)
    RelativeLayout rl_mine_queen_card_free;
    @Bind(R.id.rl_mine_queen_card_regist)
    RelativeLayout rl_mine_queen_card_regist;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_queen_card_free;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title_title.setText("会员活动");
        String headPic = SP.get(this, SpContent.userHeadPic,"")+"";
        Glide.with(this).load(headPic).dontAnimate().into(iv_mine_title);

        tv_user_name.setText(SP.get(this,SpContent.UserName,"")+"");
        getTequanData();

        getFreeStatueData();

        getRegistStatueData();

    }

    /**
     * 获取完成注册登录会员活动状态
     */
    private void getRegistStatueData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId",SP.get(this,SpContent.UserId,"")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.QUEENCARDREGISTLOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取免费试用会员活动状态
     */
    private void getFreeStatueData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId",SP.get(this,SpContent.UserId,"")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.HUIYUANACTIVITYSTAUTE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取女王特权项
     */
    private void getTequanData() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.QUEENROYALTY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back,R.id.mine_queen_card_get2,R.id.mine_queen_card_get})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.mine_queen_card_get2:
                setFreeStatueData();
                break;
            case R.id.mine_queen_card_get:
                setRegistStatueData();
                break;
        }
    }

    /**
     * 设置注册登录
     */
    private void setRegistStatueData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId",SP.get(this,SpContent.UserId,"")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETQUEENREGISTCARD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 设置免费试用会员
     */
    private void setFreeStatueData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId",SP.get(this,SpContent.UserId,"")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.SETFREESTATUEDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 注册登录使用会员
             */
            case ACTION.GETQUEENREGISTCARD:
                SuccessBean successBean1 = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean1.isSuccess()&&successBean1.getErrorCode().equals("0")){
                    T.show("领取成功");
                    mine_queen_card_get.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_seven));
                    mine_queen_card_get.setText("已领取");
                    mine_queen_card_get.setClickable(false);
                    mine_queen_card_get.setTextColor(this.getResources().getColor(R.color.queen_card_two));
                }else{
                    T.show(successBean1.getMsg());
                }
                break;
            /**
             * 完成登录注册状态
             */
            case ACTION.QUEENCARDREGISTLOGIN:
                MineQueenCardRegistBean mineQueenCardRegistBean = GsonUtil.toObj(res,MineQueenCardRegistBean.class);
                if(mineQueenCardRegistBean.isSuccess()&&mineQueenCardRegistBean.getErrorCode().equals("0")){


                    if(mineQueenCardRegistBean.getBody().getStatus().equals("0")){//未领取
                        rl_mine_queen_card_regist.setVisibility(View.VISIBLE);
                        tv_mine_queen_card_regist_day.setText("+"+mineQueenCardRegistBean.getBody().getGivenDays()+"天VIP");
                        mine_queen_card_get.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_five));
                        mine_queen_card_get.setText("领取");
                        mine_queen_card_get.setTextColor(this.getResources().getColor(R.color.white));
                        mine_queen_card_get.setClickable(true);
                    }else if(mineQueenCardRegistBean.getBody().getStatus().equals("1")){//已领取
                        rl_mine_queen_card_regist.setVisibility(View.VISIBLE);
                        tv_mine_queen_card_regist_day.setText("+"+mineQueenCardRegistBean.getBody().getGivenDays()+"天VIP");
                        mine_queen_card_get.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_seven));
                        mine_queen_card_get.setText("已领取");
                        mine_queen_card_get.setClickable(false);
                        mine_queen_card_get.setTextColor(this.getResources().getColor(R.color.queen_card_two));
                    }else if(mineQueenCardRegistBean.getBody().getStatus().equals("3")){//不可领取
                        rl_mine_queen_card_regist.setVisibility(View.GONE);
                    }else {//不可领取
                        rl_mine_queen_card_regist.setVisibility(View.VISIBLE);
                        tv_mine_queen_card_regist_day.setText("+"+mineQueenCardRegistBean.getBody().getGivenDays()+"天VIP");
                        mine_queen_card_get.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_six));
                        mine_queen_card_get.setText("不可领");
                        mine_queen_card_get.setTextColor(this.getResources().getColor(R.color.white));
                        mine_queen_card_get.setClickable(false);
                    }
                }else{
                    T.show(mineQueenCardRegistBean.getMsg());
                }
                break;
            /**
             * 领取免费试用会员
             */
            case ACTION.SETFREESTATUEDATA:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.isSuccess()&&successBean.getErrorCode().equals("0")){
                    T.show("领取成功");
                    mine_queen_card_get2.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_seven));
                    mine_queen_card_get2.setText("已领取");
                    mine_queen_card_get2.setClickable(false);
                    mine_queen_card_get2.setTextColor(this.getResources().getColor(R.color.queen_card_two));
                }else{
                    T.show(successBean.getMsg());
                }
                break;
            /**
             * 获取免费试用的状态
             */
            case ACTION.HUIYUANACTIVITYSTAUTE:

                MineQueenCardFreeBean mineQueenCardFreeBean = GsonUtil.toObj(res,MineQueenCardFreeBean.class);
                if(mineQueenCardFreeBean.isSuccess()&&mineQueenCardFreeBean.getErrorCode().equals("0")){

                    if(mineQueenCardFreeBean.getBody().getStatus().equals("0")){//未领取
                        tv_mine_queen_card_free_date.setText("+"+mineQueenCardFreeBean.getBody().getGivenDays()+"天VIP");
                        tv_mine_queen_card_freetext.setText(mineQueenCardFreeBean.getBody().getRemarks());
                        rl_mine_queen_card_free.setVisibility(View.VISIBLE);
                        mine_queen_card_get2.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_five));
                        mine_queen_card_get2.setText("领取");
                        mine_queen_card_get2.setTextColor(this.getResources().getColor(R.color.white));
                        mine_queen_card_get2.setClickable(true);
                    }else if(mineQueenCardFreeBean.getBody().getStatus().equals("1")){//已领取
                        rl_mine_queen_card_free.setVisibility(View.VISIBLE);
                        tv_mine_queen_card_free_date.setText("+"+mineQueenCardFreeBean.getBody().getGivenDays()+"天VIP");
                        tv_mine_queen_card_freetext.setText(mineQueenCardFreeBean.getBody().getRemarks());
                        mine_queen_card_get2.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_seven));
                        mine_queen_card_get2.setText("已领取");
                        mine_queen_card_get2.setTextColor(this.getResources().getColor(R.color.queen_card_two));

                        mine_queen_card_get2.setClickable(false);
                    }else if(mineQueenCardFreeBean.getBody().getStatus().equals("3")){//不可领取

                        rl_mine_queen_card_free.setVisibility(View.GONE);
                    }else{//不可领取
                        rl_mine_queen_card_free.setVisibility(View.VISIBLE);
                        tv_mine_queen_card_free_date.setText("+"+mineQueenCardFreeBean.getBody().getGivenDays()+"天VIP");
                        tv_mine_queen_card_freetext.setText(mineQueenCardFreeBean.getBody().getRemarks());
                        mine_queen_card_get2.setBackground(this.getResources().getDrawable(R.drawable.button_mine_queen_card_six));
                        mine_queen_card_get2.setText("不可领取");
                        mine_queen_card_get2.setTextColor(this.getResources().getColor(R.color.white));
                        mine_queen_card_get2.setClickable(false);
                    }


                }else{
                    T.show(mineQueenCardFreeBean.getMsg());
                }

                break;
            /**
             * 获取女王特权项
             */
            case ACTION.QUEENROYALTY:
                MineQueenCardBean mineQueenCardBean = GsonUtil.toObj(res,MineQueenCardBean.class);

                if(mineQueenCardBean.isSuccess()&&mineQueenCardBean.getErrorCode().equals("0")){
                    MineQueenCardAdapter gridViewAdapters = new MineQueenCardAdapter(MineQueenCardFreeActivity.this, mineQueenCardBean.getBody().getList());
                    re_shop_mall.setAdapter(gridViewAdapters);
                }else{
                    T.show(mineQueenCardBean.getMsg());
                }
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
