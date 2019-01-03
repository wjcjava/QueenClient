package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommentGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ReplyCommentBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ReplyCommentTwoBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 更多评价
 */
public class ReplyCommentActivity extends BaseNewActivity implements HttpCallBack{

    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_reply_comment_shopname)
    TextView tv_reply_comment_shopname;
    @Bind(R.id.tv_reply_comment_nickname)
    TextView tv_reply_comment_nickname;
    @Bind(R.id.score_reply_comment_evaluate)
    CustomRatingBar score_reply_comment_evaluate;
    @Bind(R.id.tv_reply_comment_time)
    TextView tv_reply_comment_time;
    @Bind(R.id.tv_reply_comment_service)
    TextView tv_reply_comment_service;
    @Bind(R.id.tv_reply_comment_content)
    TextView tv_reply_comment_content;
    @Bind(R.id.tv_reply_comment_goodsname)
    TextView tv_reply_comment_goodsname;
    @Bind(R.id.li_reply_comment_linear)
    LinearLayout li_reply_comment_linear;
    @Bind(R.id.li_reply_comment_zhuiping)
    LinearLayout li_reply_comment_zhuiping;
    @Bind(R.id.li_reply_comment_input)
    LinearLayout li_reply_comment_input;
    @Bind(R.id.tv_reply_comment_submit)
    TextView tv_reply_comment_submit;
    @Bind(R.id.et_reply_comment_content)
    EditText et_reply_comment_content;
    @Bind(R.id.iv_title)
    CircleImageView iv_title;
    @Bind(R.id.gv_mineevaluate_gridView)
    NoScrollGridView gv_mineevaluate_gridView;

    String shopName,shopDevice,serviceAttitude,shopEnvironment,apprTime,service="",goodsName,commentgContent,commentId,shopId,commshopId;
    String logo_pic;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reply_comment;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("更多评论");

        Intent intent = this.getIntent();
        shopName = intent.getStringExtra("shopName");
        shopDevice = intent.getStringExtra("shopDevice");
        serviceAttitude = intent.getStringExtra("serviceAttitude");
        shopEnvironment = intent.getStringExtra("shopEnvironment");
        apprTime = intent.getStringExtra("apprTime");
        goodsName = intent.getStringExtra("goodsName");
        commentgContent = intent.getStringExtra("commentgContent");
        commentId = intent.getStringExtra("commentId");
        shopId = intent.getStringExtra("shopId");
        commshopId = intent.getStringExtra("commshopId");
        logo_pic = intent.getStringExtra("logo_pic");

        Glide.with(this).load(SP.get(this,SpContent.userHeadPic,"")+"").dontAnimate().placeholder(R.drawable.dismiss).into(iv_title);

        String[] logoPic = logo_pic.split(",");

        if(logo_pic== null ||logo_pic.equals("")){
            gv_mineevaluate_gridView.setVisibility(View.GONE);
        }else{
            gv_mineevaluate_gridView.setVisibility(View.VISIBLE);
            CommentGridViewAdapter gridViewAdapter = new CommentGridViewAdapter(ReplyCommentActivity.this, logoPic);
            gv_mineevaluate_gridView.setAdapter(gridViewAdapter);
        }

        tv_reply_comment_shopname.setText(shopName);
        tv_reply_comment_nickname.setText(SP.get(this, SpContent.UserName,"")+"");

        if(shopDevice.equals("")){
            shopDevice = "0";
        }
        score_reply_comment_evaluate.setRating(Float.parseFloat(shopDevice));
        tv_reply_comment_time.setText(apprTime);

        if(Double.parseDouble(serviceAttitude)>4){
            service = service+"服务：非常满意        ";
        }else if(Double.parseDouble(serviceAttitude)>2&&Double.parseDouble(serviceAttitude)<5){
            service = service+"服务：满意        ";
        }else{
            service = service+"服务：不满意        ";
        }

        if(Double.parseDouble(shopEnvironment)>4){
            service = service+"态度：非常满意";
        }else if(Double.parseDouble(serviceAttitude)>2&&Double.parseDouble(serviceAttitude)<5){
            service = service+"态度：满意";
        }else{
            service = service+"态度：不满意";
        }
        tv_reply_comment_service.setText(service);
        tv_reply_comment_content.setText(commentgContent);
        tv_reply_comment_goodsname.setText(goodsName);

        getReplyData();
    }

    /**
     *  得到回复列表
     */
    private void getReplyData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("commentId", commentId);
        parames.put("objectId", commentId);
        parames.put("token",SP.get(ReplyCommentActivity.this,SpContent.UserToken,"")+"");
        // parames.put("objectId", SP.get(ReplyCommentActivity.this,SpContent.UserId,"0")+"");
        HttpUtils.doPost(ACTION.CommentReplyList, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.title_back,R.id.li_reply_comment_zhuiping,R.id.tv_reply_comment_submit})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.li_reply_comment_zhuiping:
                /**
                 * 追评
                 */
                li_reply_comment_zhuiping.setVisibility(View.GONE);
                li_reply_comment_input.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_reply_comment_submit:
                /**
                 * 点击评论
                 */
                if(et_reply_comment_content.getText().toString().equals("")){
                    T.show("请输入追评内容");
                }else{
                    DoReplyData();
                }
                break;
        }
    }

    /**
     * 追评
     */
    private void DoReplyData() {
        ReplyCommentTwoBean replyCommentTwoBean = new ReplyCommentTwoBean();

        replyCommentTwoBean.setAppraiseId(commentId);
        replyCommentTwoBean.setObjectId(commentId);
        replyCommentTwoBean.setObjectUser(shopId);
        replyCommentTwoBean.setReplyContent(et_reply_comment_content.getText().toString());
        replyCommentTwoBean.setReplyFrom("1");
        replyCommentTwoBean.setReplyUser(SP.get(this,SpContent.UserId,"0")+"");

        Gson gson = new Gson();
        String replyinfo = gson.toJson(replyCommentTwoBean);

        HashMap<String, String> params = new HashMap<>();
        params.put("replyInfo", replyinfo);//评论ID
        params.put("token", SP.get(this, SpContent.UserToken,"")+"");
        HttpUtils.doPost(ACTION.COMMENTINPUT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            /**
             * 商品回复
             */
            case ACTION.COMMENTINPUT:
                SuccessBean successBean = GsonUtil.toObj(res,SuccessBean.class);
                if(successBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (successBean.isSuccess() && successBean.getErrorCode().equals("0")) {
                        // 2、获取组件，设置组件属性
                        View _view = LayoutInflater.from(ReplyCommentActivity.this).inflate(R.layout.reply_comment_item, null);
                        // 3、在布局中添加组件，设置组件属性
                        li_reply_comment_linear.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        TextView tv_reply_comment_where = _view.findViewById(R.id.tv_reply_comment_where);
                        tv_reply_comment_where.setText(SP.get(this, SpContent.UserName, "") + ":");

                        TextView tv_reply_comment_content = _view.findViewById(R.id.tv_reply_comment_content);
                        tv_reply_comment_content.setText(et_reply_comment_content.getText().toString());

                        et_reply_comment_content.setText("");
                        li_reply_comment_zhuiping.setVisibility(View.VISIBLE);
                        li_reply_comment_input.setVisibility(View.GONE);
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            case ACTION.CommentReplyList:

                ReplyCommentBean replyCommentBean = GsonUtil.toObj(res,ReplyCommentBean.class);
                if(replyCommentBean.getErrorCode().equals("6")){
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite","no");
                    startActivity(intent);
                }else {
                    if (replyCommentBean.isSuccess()) {

                        if (replyCommentBean.getBody().getApiEcAppraiseReplyList().size() > 0) {

                            for (int i = 0; i < replyCommentBean.getBody().getApiEcAppraiseReplyList().size(); i++) {
                                // 2、获取组件，设置组件属性
                                View _view = LayoutInflater.from(ReplyCommentActivity.this).inflate(R.layout.reply_comment_item, null);
                                // 3、在布局中添加组件，设置组件属性
                                li_reply_comment_linear.addView(_view, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                                TextView tv_reply_comment_where = _view.findViewById(R.id.tv_reply_comment_where);

                                if (replyCommentBean.getBody().getApiEcAppraiseReplyList().get(i).getReplyUserName() == null || replyCommentBean.getBody().getApiEcAppraiseReplyList().get(i).getReplyUserName().equals("")) {
                                    tv_reply_comment_where.setText("商家回应：");
                                } else {
                                    tv_reply_comment_where.setText(replyCommentBean.getBody().getApiEcAppraiseReplyList().get(i).getReplyUserName() + ":");
                                }
                                TextView tv_reply_comment_content = _view.findViewById(R.id.tv_reply_comment_content);
                                tv_reply_comment_content.setText(replyCommentBean.getBody().getApiEcAppraiseReplyList().get(i).getEcAppraiseReply().getReplyContent());
                            }
                        }

                    } else {
                        T.show("暂无回复");
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
