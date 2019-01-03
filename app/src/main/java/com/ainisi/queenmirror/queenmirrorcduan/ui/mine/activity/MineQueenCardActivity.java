package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineQueenCardAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.QueenCardStatueBean;
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

/**
 * 我的女王会员
 */
public class MineQueenCardActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_queen_card_duihuan)
    TextView tv_queen_card_duihuan;

    @Bind(R.id.re_shop_mall)
    NoScrollGridView re_shop_mall;
    @Bind(R.id.iv_mine_title)
    CircleImageView iv_mine_title;
    @Bind(R.id.tv_mine_queen_card_usrname)
    TextView tv_mine_queen_card_usrname;
    @Bind(R.id.tv_mine_queen_card_statue)
    TextView tv_mine_queen_card_statue;
    @Bind(R.id.tv_mine_queen_card_vip)
    TextView tv_mine_queen_card_vip;
    @Bind(R.id.tv_queencard_buynow)
    TextView tv_queencard_buynow;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_queen_card;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("我的女王会员");

        String headPic = SP.get(this, SpContent.userHeadPic,"").toString();
        Glide.with(this).load(headPic).dontAnimate().into(iv_mine_title);
        tv_mine_queen_card_usrname.setText(SP.get(this,SpContent.UserName,"")+"");

        getTequanData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getQueenStaute();
    }

    /**
     * 获取会员状态
     */
    private void getQueenStaute() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId",SP.get(this,SpContent.UserId,"")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETHUIYUANSTAUTE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取女王特权项
     */
    private void getTequanData() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.QUEENROYALTY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back,R.id.tv_queen_card_duihuan,R.id.tv_mine_queen_card_free,R.id.tv_queencard_buynow})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_queen_card_duihuan:
                Intent intent = new Intent(this,MineQueenCardChangeActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_mine_queen_card_free:
                Intent intent1 = new Intent(this,MineQueenCardFreeActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_queencard_buynow:
                Intent intent2= new Intent(this,MineQueenCardPayActivity.class);
                startActivity(intent2);
                break;

        }
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 获取会员状态
             */
            case ACTION.GETHUIYUANSTAUTE:

                QueenCardStatueBean queenCardStatueBean = GsonUtil.toObj(res,QueenCardStatueBean.class);
                if(queenCardStatueBean.isSuccess()&&queenCardStatueBean.getErrorCode().equals("0")){
                    if(queenCardStatueBean.getBody().getMemberStatus().equals("not")){
                        tv_mine_queen_card_statue.setText("开通会员尊享女王特权");
                        tv_mine_queen_card_vip.setVisibility(View.VISIBLE);

                        tv_queencard_buynow.setText("立即开通");
                    }else{
                        String endTime = queenCardStatueBean.getBody().getEndTime();
                        tv_mine_queen_card_statue.setText(endTime+"到期");
                        tv_mine_queen_card_vip.setVisibility(View.GONE);

                        tv_queencard_buynow.setText("续费");
                    }
                }else{
                    T.show(queenCardStatueBean.getMsg());
                }

                break;
            /**
             * 获取特权向
             */
            case ACTION.QUEENROYALTY:
                MineQueenCardBean mineQueenCardBean = GsonUtil.toObj(res,MineQueenCardBean.class);

                if(mineQueenCardBean.isSuccess()&&mineQueenCardBean.getErrorCode().equals("0")){
                    MineQueenCardAdapter gridViewAdapters = new MineQueenCardAdapter(MineQueenCardActivity.this, mineQueenCardBean.getBody().getList());
                    re_shop_mall.setAdapter(gridViewAdapters);
                }else{
                    T.show(mineQueenCardBean.getMsg());
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
