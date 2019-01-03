package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MineQueenCardAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQueenCardBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessCardBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.GetShareBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import cz.msebera.android.httpclient.extras.Base64;

/**
 * 激活码兑换
 */
public class MineQueenCardChangeActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_mine_queen_card_change)
    TextView tv_mine_queen_card_change;

    @Bind(R.id.re_shop_mall)
    NoScrollGridView re_shop_mall;
    @Bind(R.id.et_mine_queen_card_input)
    EditText et_mine_queen_card_input;
    @Bind(R.id.tv_mine_queen_card_submit)
    TextView tv_mine_queen_card_submit;
    @Bind(R.id.rl_mine_queen_card_validation)
    RelativeLayout rl_mine_queen_card_validation;
    @Bind(R.id.iv_mine_queen_card_graphics_validation)
    ImageView iv_mine_queen_card_graphics_validation;
    @Bind(R.id.et_mine_queen_card_validation)
    EditText et_mine_queen_card_validation;

    private boolean addvalidatecode = false;
    private String tvValidation,isNeedImgValidateCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_queen_card_change;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("激活码兑换");
        tv_mine_queen_card_change.setText("您好，"+SP.get(this, SpContent.UserName,""));

        getTequanData();
    }


    /**
     * 获取女王特权项
     */
    private void getTequanData() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.QUEENROYALTY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back,R.id.tv_mine_queen_card_submit,R.id.iv_mine_queen_card_graphics_validation})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_mine_queen_card_submit:
                if(et_mine_queen_card_input.getText().toString().equals("")){
                    T.show("请输入卡号");
                }else{
                    JihuoData();
                }
                break;
            /**
             * 更换验证码
             */
            case R.id.iv_mine_queen_card_graphics_validation:
                initgetShape();
                break;
        }
    }


    //获取图形验证码
    private void initgetShape(){
        HashMap<String,String> parames=new HashMap<>();
        parames.put("token",SP.get(this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.GETSHAPE,parames,CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    /**
     * 激活卡号
     */
    private void JihuoData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("cardNo",et_mine_queen_card_input.getText().toString());
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        if (addvalidatecode) {
            tvValidation = et_mine_queen_card_validation.getText().toString();
            if(!TextUtils.isEmpty(tvValidation)){
                params.put("imgValidateCode", tvValidation);
            }else {
                T.show("请您输入图形验证码");
            }
        }
        HttpUtils.doPost(ACTION.QUEENROYALTYACTIVITY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            /**
             * 图形验证码
             */
            case ACTION.GETSHAPE:
                GetShareBean getShareBean=GsonUtil.toObj(res,GetShareBean.class);
                if(getShareBean.isSuccess()){
                    String imagestr = getShareBean.getBody().getImageStr();
                    if(!TextUtils.isEmpty(imagestr)){
                        Bitmap image = stringtoBitmap(imagestr);
                        iv_mine_queen_card_graphics_validation.setImageBitmap(image);
                        addvalidatecode=true;
                    }
                }else {
                    T.show(getShareBean.getMsg());
                }
                break;
            case ACTION.QUEENROYALTYACTIVITY:
                SuccessCardBean successBean = GsonUtil.toObj(res,SuccessCardBean.class);

                isNeedImgValidateCode = successBean.getBody().getIsNeedImgValidateCode();

                if(isNeedImgValidateCode.equals("0")){
                    rl_mine_queen_card_validation.setVisibility(View.GONE);
                }else{
                    rl_mine_queen_card_validation.setVisibility(View.VISIBLE);
                    initgetShape();
                }

                if(successBean.isSuccess()&&successBean.getErrorCode().equals("0")){
                    T.show("激活成功");
                    finish();
                }else{
                    T.show(successBean.getMsg());
                }
                break;
            case ACTION.QUEENROYALTY:
                MineQueenCardBean mineQueenCardBean = GsonUtil.toObj(res,MineQueenCardBean.class);

                if(mineQueenCardBean.isSuccess()&&mineQueenCardBean.getErrorCode().equals("0")){
                    MineQueenCardAdapter gridViewAdapters = new MineQueenCardAdapter(MineQueenCardChangeActivity.this, mineQueenCardBean.getBody().getList());
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

    public static Bitmap stringtoBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
