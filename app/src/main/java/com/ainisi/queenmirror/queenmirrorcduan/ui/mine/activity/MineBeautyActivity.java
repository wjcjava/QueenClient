package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的——成为美业人
 */
public class MineBeautyActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView beautyTitle;
    @Bind(R.id.title_right)
    TextView titleRight;
    @Bind(R.id.et_beauty_name)
    EditText et_beauty_name;
    @Bind(R.id.et_beauty_id)
    EditText et_beauty_id;
    @Bind(R.id.et_beauty_phone)
    EditText et_beauty_phone;
    @Bind(R.id.rg_beauty_select)
    RadioGroup rg_beauty_select;
    @Bind(R.id.title_back)
    ImageView title_back;
    String isZhuan = "1";
    LoadingDialog loadingDialog;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,MineBeautyActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_beauty;
    }

    @Override
    public void initView() {
        beautyTitle.setText(R.string.beauty);
        titleRight.setText(R.string.reservation);
        loadingDialog = new LoadingDialog(this);

        rg_beauty_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_beauty_yes){
                    isZhuan = "1";
                }else{
                    isZhuan = "0";
                }
            }
        });
    }
    @OnClick({R.id.title_right,R.id.title_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_right:
                if(et_beauty_name.getText().toString().length()<1 || et_beauty_id.getText().toString().length() < 15 ||et_beauty_phone.getText().toString().length() < 11){
                    T.show("请完善相关信息");
                }else{
                    UploadData();
                }
                break;
            case R.id.title_back:
                finish();
                break;
        }
    }

    /**
     * 申请成为美业人
     */
    private void UploadData() {
        loadingDialog.loadShow();
        HashMap<String,String> params=new HashMap<>();
        params.put("custId", SP.get(MineBeautyActivity.this, SpContent.UserId,"0")+"");
        params.put("token",SP.get(this,SpContent.UserToken,"")+"");
        params.put("applyName",et_beauty_name.getText().toString());
        params.put("applyTel",et_beauty_phone.getText().toString());
        params.put("ifTrainning",isZhuan);
        params.put("applyDetails",et_beauty_id.getText().toString());
        HttpUtils.doPost(ACTION.BEMEIYEREN,params, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.BEMEIYEREN:
                loadingDialog.cancel();
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.isSuccess()) {
                        T.show("申请已提交");
                        finish();
                    } else {
                        T.show(successBean.getMsg());
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
