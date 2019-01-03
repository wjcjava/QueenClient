package com.ainisi.queenmirror.queenmirrorcduan.ui.user;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.LoginBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.HomePageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.bean.UserBindBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

public class GuanLianActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.gl_et_login_pghone)
    EditText gl_et_login_pghone;
    @Bind(R.id.gl_et_login_pass)
    EditText gl_et_login_pass;
    @Bind(R.id.gl_bt_login_submit)
    TextView gl_bt_login_submit;

    String nickName,headPic,openId,loginToken,deviceToken,loginFlag;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guan_lian;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("关联账号");

        Intent intent = this.getIntent();
        nickName = intent.getStringExtra("nickName");
        headPic = intent.getStringExtra("headPic");
        openId = intent.getStringExtra("openId");
        loginToken = intent.getStringExtra("loginToken");
        loginFlag = intent.getStringExtra("loginFlag");
    }

    @OnClick({R.id.title_back,R.id.gl_bt_login_submit})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.gl_bt_login_submit:
                if(gl_et_login_pghone.getText().toString().equals("")||gl_et_login_pass.getText().toString().equals("")){
                    T.show("请完善相关信息");
                }else{
                    LoginData();
                }
                break;
        }
    }
    /**
     * 登录数据
     */
    private void LoginData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("loginFlag", loginFlag);
        params.put("openId",openId);
        params.put("loginToken",loginToken);
        params.put("cellPhone",gl_et_login_pghone.getText().toString());
        params.put("userPass",gl_et_login_pass.getText().toString());
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.USERBIND, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 登录数据
     */
    private void LoginthereData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
       // params.put("deviceToken", SP.get(this,SpContent.UmengToken,"")+"");
        params.put("cellPhone", gl_et_login_pghone.getText().toString());
        params.put("userPass", MD5.md5(gl_et_login_pass.getText().toString()+ "MYN888"));
        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.LOGIN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.USERBIND:
                UserBindBean bindBean=GsonUtil.toObj(res, UserBindBean.class);
                if(bindBean.isSuccess()){
                    LoginthereData();
                }else {
                    T.show(bindBean.getMsg());
                }
                break;
            case ACTION.LOGIN://登录
                LoginBean loginBean = GsonUtil.toObj(res,LoginBean.class);
                if(loginBean.isSuccess()){
                    MobclickAgent.onProfileSignIn(loginBean.getBody().getToken());

                    SP.put(this, SpContent.UserId ,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getId());
                    SP.put(this,SpContent.UserCall,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getCellPhone());
                    SP.put(this,SpContent.UserName,nickName);
                    SP.put(this,SpContent.isLogin,"1");
                    SP.put(this,SpContent.userHeadPic,loginBean.getBody().getApiAnsCustBasic().getAnsCustBasic().getHeadPic());
                    SP.put(this,SpContent.UserToken,loginBean.getBody().getToken());
                    SP.put(this, SpContent.Current,"2");
                    SP.put(this, SpContent.Lickname,"");
                    SP.put(this, SpContent.LickPhone,"");
                    SP.put(this, SpContent.LickSex,"");
                    Intent intent = new Intent(this, HomePageActivity.class);
                    startActivity(intent);
                }else{
                    T.show(loginBean.getMsg());}
        }
    }
    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
