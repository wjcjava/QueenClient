package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 第三方登录
 */
public class LoginThirdActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_third_login_regist)
    TextView tv_third_login_regist;
    @Bind(R.id.tv_third_login_login)
    TextView tv_third_login_login;
    @Bind(R.id.iv_title)
    CircleImageView iv_title;

    String nickName,headPic,openId,loginToken,loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_third;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("绑定账号");
        Intent intent = this.getIntent();
        nickName = intent.getStringExtra("nickName");
        headPic = intent.getStringExtra("headPic");
        openId = intent.getStringExtra("openId");
        loginToken = intent.getStringExtra("loginToken");
        loginFlag = intent.getStringExtra("loginFlag");
        Glide.with(LoginThirdActivity.this).load(headPic).placeholder(R.drawable.dismiss).into(iv_title);
    }
    @OnClick({R.id.title_back,R.id.tv_third_login_regist,R.id.tv_third_login_login})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
                //注册
            case R.id.tv_third_login_regist:
                Intent intent1 = new Intent(this,RegisterActivity.class);
                intent1.putExtra("where","third");
                intent1.putExtra("nickName",nickName);
                intent1.putExtra("headPic",headPic);
                intent1.putExtra("openId",openId);
                intent1.putExtra("loginToken",loginToken);
                intent1.putExtra("loginFlag",loginFlag);
                startActivity(intent1);
                break;
                //关联
            case R.id.tv_third_login_login:
                Intent intent = new Intent(this,GuanLianActivity.class);
                intent.putExtra("nickName",nickName);
                intent.putExtra("headPic",headPic);
                intent.putExtra("openId",openId);
                intent.putExtra("loginToken",loginToken);
                intent.putExtra("loginFlag",loginFlag);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
