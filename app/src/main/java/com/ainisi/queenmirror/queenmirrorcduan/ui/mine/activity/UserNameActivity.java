package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
 * 修改用户名
 *
 */
public class UserNameActivity extends BaseNewActivity implements HttpCallBack{
    @Bind(R.id.title_title)
    TextView usertitle;
    @Bind(R.id.title_right)
    TextView titleright;
    @Bind(R.id.et_username_newname)
    EditText et_username_newname;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,UserNameActivity.class));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_user_name;
    }


    @Override
    public void initView() {
        usertitle.setText("修改用户名");
        titleright.setText("确定");
        initDate();
    }

    private void initDate() {

    }
    @OnClick({R.id.title_back,R.id.title_right})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_right:
                if(et_username_newname.getText().toString().length() <4 || et_username_newname.getText().toString().length()>16){
                    T.show("请输入正确的用户名");
                }else{
                    UploadData();
                }
                break;
        }
    }

    /**
     * 修改用户名
     */
    private void UploadData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userName", et_username_newname.getText().toString());
        params.put("userId", SP.get(UserNameActivity.this, SpContent.UserId,"")+"");
        params.put("token",SP.get(UserNameActivity.this,SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.CHANGENAME, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.CHANGENAME:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.isSuccess()) {
                        T.show("修改成功");
                        SP.put(UserNameActivity.this, SpContent.UserName, et_username_newname.getText().toString());
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
