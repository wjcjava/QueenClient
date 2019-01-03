package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;

import butterknife.Bind;
import butterknife.OnClick;

//消息
public class MessageActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.tv_message_interactive)
    TextView tvInteractive;
    @Bind(R.id.tv_message_system)
    TextView tvSystem;
    @Bind(R.id.tv_message_review)
    TextView tvReview;

    @Bind(R.id.tv_message_system_content)
    TextView tv_message_system_content;
    @Bind(R.id.tv_message_hudong_content)
    TextView tv_message_hudong_content;
    @Bind(R.id.tv_message_activity_content)
    TextView tv_message_activity_content;
    boolean isLogin = false;
    NewsBean newsBean = new NewsBean();
    String system_string="",activity_string="";

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MessageActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_message;
    }

    @Override
    public void initView() {

        Intent intent = this.getIntent();
        newsBean = (NewsBean) intent.getSerializableExtra("newsBean");

        title.setText(R.string.message_center);
        title.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));

        for(int i=0;i<newsBean.getBody().getMessTypeList().size();i++){

            if(newsBean.getBody().getMessTypeList().get(i).getValue().equals("1")){
                if(newsBean.getBody().getMessTypeList().get(i).getMsgContent() == null){
                    system_string = "";
                }else{
                    system_string = newsBean.getBody().getMessTypeList().get(i).getMsgContent();
                }
            }else if(newsBean.getBody().getMessTypeList().get(i).getValue().equals("5")){
                if(newsBean.getBody().getMessTypeList().get(i).getMsgContent() == null){
                    activity_string = "";
                }else {
                    activity_string = newsBean.getBody().getMessTypeList().get(i).getMsgContent();
                }
            }
        }
        if(system_string.equals("")){
            tv_message_system_content.setText("暂无消息");
        }else {
            tv_message_system_content.setText(system_string);
        }

        if(activity_string.equals("")){
            tv_message_activity_content.setText("暂无消息");
        }else{
            tv_message_activity_content.setText(activity_string);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SP.get(this, SpContent.isLogin, "").toString().equals("1")) {
            isLogin = true;
        } else {
            isLogin = false;
        }
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.title_back, R.id.layout_message_interactive, R.id.layout_message_system, R.id.layout_message_review})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //活动消息
            case R.id.layout_message_review:
                if (isLogin) {
                    Intent intent = new Intent(this, SystemActivity.class);
                    intent.putExtra("type","5");
                    startActivity(intent);
                } else {
                    T.show("请登录");
                }
                break;
            //系统消息
            case R.id.layout_message_interactive:
                if (isLogin) {
                    Intent intent = new Intent(this, SystemActivity.class);
                    intent.putExtra("type","2");
                    startActivity(intent);
                } else {
                    T.show("请登录");
                }
                break;
            default:
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