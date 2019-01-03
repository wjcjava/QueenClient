package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.UploadPicBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DateUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSRespContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;
import com.ufo.imageselector.DWImages;
import com.umeng.analytics.MobclickAgent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

//我的账号
public class PortraitActivity extends BaseNewActivity implements View.OnClickListener, HttpCallBack {
    @Bind(R.id.title_title)
    TextView title;
    @Bind(R.id.iv_portrait_head)
    CircleImageView iv_portrait_head;
    @Bind(R.id.tv_portrait_loginout)
    TextView tv_portrait_loginout;
    @Bind(R.id.tv_portrait_username)
    TextView tv_portrait_username;
    @Bind(R.id.tv_userphone)
    TextView tv_userphone;
    private CustomPopWindow popWindow;
    String head_pic = "";
    List<String> new_upload = new ArrayList<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, PortraitActivity.class));
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_portrait_username.setText(SP.get(this, SpContent.UserName, "") + "");
        tv_userphone.setText(SP.get(this, SpContent.UserCall, "") + "");

        Glide.with(this).load(SP.get(this, SpContent.userHeadPic, "") + "").dontAnimate().placeholder(R.drawable.dismiss).into(iv_portrait_head);
    }

    @Override
    protected void initData() {
        super.initData();
        title.setText("我的账号");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_portrait;
    }

    @OnClick({R.id.layout_userimg, R.id.layout_username, R.id.layout_password, R.id.layout_passphone, R.id.title_back, R.id.tv_portrait_loginout})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_portrait_loginout:
                LoadOutData();
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.layout_userimg:
                getOSSToken();
                break;
            //修改用户名
            case R.id.layout_username:
                UserNameActivity.startActivity(this);
                break;
            //账户密码
            case R.id.layout_password:
                boolean isPassword = (Boolean) SP.get(this, SpContent.isPassword, true);
                if (isPassword) {
                    UserpassActivity.startActivity(this);
                } else {
                    startActivity(new Intent(this, SettingPsdActivity.class));
                }
                break;
            //修改手机号
            case R.id.layout_passphone:
                UserphoneActivity.startActivity(this);
                break;
            default:
                break;
        }
    }

    /**
     * 退出当前账号
     */
    private void LoadOutData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("telNo", SP.get(this, SpContent.UserCall, "") + "");
        params.put("token", SP.get(this, SpContent.UserToken, "0") + "");
        HttpUtils.doPost(ACTION.LOGINOUT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取OSSToken
     */
    private void getOSSToken() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token", SP.get(this, SpContent.UserToken, "0") + "");
        HttpUtils.doPost(ACTION.OSSGETTOKEN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //退出
            case R.id.btn_cancel:
                popWindow.dissmiss();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DWImages.parserResult(requestCode, data, new DWImages.GetImagesCallback() {
            @Override
            public void onResult(final List<String> images) {
                // Log.d(TAG, "onResult:--> : images: " + images.size());

                for (int i = 0; i < images.size(); i++) { //在这里做图片压缩 //得到newImagelist
                    final int index = i;
                    File oldFile = new File(images.get(i));
                    Luban.with(PortraitActivity.this) // 初始化
                            .load(oldFile) // 要压缩的图片
                            .setCompressListener(new OnCompressListener() {
                                @Override
                                public void onStart() {

                                }

                                @Override
                                public void onSuccess(File newFile) {
                                    // 压缩成功后调用，返回压缩后的图片文件
                                    // 获取返回的图片地址 newfile
                                    String newPath = newFile.getAbsolutePath();
                                    new_upload.add(newPath);
                                    // 输出图片的大小

                                    final String objectKey = DateUtil.getCurrentDateTime("yyyyMMddhhmmssSSS") + ((int) ((Math.random() * 9 + 1) * 10000) + "") + ".jpg";

                                    OSSUtil.getInstance().setBucket("prodr").asyncPutImage(objectKey, new_upload.get(index), new OSSProgressCallback<PutObjectRequest>() {
                                        @Override
                                        public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                                        }
                                    }, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                                        @Override
                                        public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                                            head_pic = head_pic + ("https://" + SpContent.BUCKET + "." + SpContent.ENDPOINTS + "/" + objectKey);
                                            if (new_upload.size() == images.size()) {
                                                UploadHeadData();
                                            }
                                        }

                                        @Override
                                        public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                                        }
                                    });

                                }

                                @Override
                                public void onError(Throwable e) {

                                }
                            }).launch(); // 启动压缩
                }
            }
        });
    }


    /**
     * 上传头像
     */
    private void UploadHeadData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("picName", head_pic);
        params.put("userId", SP.get(this, SpContent.UserId, "") + "");
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.HEADPICUPLOAD, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 上传头像
             */
            case ACTION.HEADPICUPLOAD:
                UploadPicBean uploadPicBean = GsonUtil.toObj(res, UploadPicBean.class);
                if (uploadPicBean.isSuccess() && uploadPicBean.getErrorCode().toString().equals("0")) {
                    Glide.with(this).load(uploadPicBean.getBody().getHeadPic()).dontAnimate().placeholder(R.drawable.dismiss).into(iv_portrait_head);

                    SP.put(this, SpContent.userHeadPic, uploadPicBean.getBody().getHeadPic());
                } else {
                    T.show(uploadPicBean.getMsg());
                }
                break;
            case ACTION.LOGINOUT:
                MobclickAgent.onProfileSignOff();
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.isSuccess()) {
                    SP.put(this, SpContent.isLogin, "0");
                    SP.put(this, SpContent.UserId, "0");
                    SP.put(this, SpContent.UserName, "");
                    finish();
                } else {
                    T.show(successBean.getMsg());
                    SP.put(this, SpContent.isLogin, "0");
                    SP.put(this, SpContent.UserId, "0");
                    SP.put(this, SpContent.UserName, "");
                    finish();
                }
                break;
            case ACTION.OSSGETTOKEN:
                OSSRespContent ossstsModel = GsonUtil.toObj(res, OSSRespContent.class);

                if (ossstsModel.isSuccess()) {
                    OSSUtil.getInstance().initOSS(PortraitActivity.this, SpContent.ENDPOINT, ossstsModel);
                    DWImages.getImages(this, DWImages.ACTION_ALBUM, 1);
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

    //重写onKeyDown方法,
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//当返回按键被按下
            L.e("??????????        ");
            finish();
        }
        return false;
    }
}
