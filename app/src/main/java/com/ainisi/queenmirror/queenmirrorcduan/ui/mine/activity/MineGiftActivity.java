package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.AgreementBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.GetSharePeopleBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.MineGiftLvAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.InvitePaizeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WebService;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//邀请有奖
public class MineGiftActivity extends BaseNewActivity implements HttpCallBack {

    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.tv_gift_sll)
    ScrollView tv_gift_sll;
    @Bind(R.id.tv_mine_modou_number)
    TextView tv_mine_modou_number;
    @Bind(R.id.tv_mine_people_number)
    TextView tv_mine_people_number;
    @Bind(R.id.wb_gift_aggrement)
    WebView wb_gift_aggrement;
    CustomShareListener mShareListener;
    ShareAction mShareAction;
    @Bind(R.id.lv_gift_aggrement)
    ListView mLvGiftAggrement;
    private ShareAction mShareAction1;

    LoadingDialog loadingDialog;
    String content = "";

    private String urlIcon = "https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineGiftActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_gift;
    }

    @Override
    public void initView() {
        title_title.setText("邀请有奖");
        loadingDialog = new LoadingDialog(this);
        inithttp();
        inithttpshop();
        getMineMoDouData();

        getXieyiData();
        mShareListener = new CustomShareListener(MineGiftActivity.this);
        mLvGiftAggrement.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mLvGiftAggrement.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        tv_gift_sll.smoothScrollTo(0, 0);
    }

    /**
     * 邀请有奖协议
     */
    private void getXieyiData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("title", "邀请有奖");
        params.put("code", "7");
        HttpUtils.doPost(ACTION.WEBVIEWAGREEMENT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("objectType", "1");//这个代表是谁分享出去的（用户端为1，商户端为2）
        parames.put("objectId", SP.get(this, SpContent.UserId, "") + "");
        parames.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INVITEPRIZE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void inithttpshop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("objectType", "1");
        parames.put("objectId", SP.get(this, SpContent.UserId, "") + "");
        parames.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INVITEBDUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取我的魔豆
     */
    private void getMineMoDouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(MineGiftActivity.this, SpContent.UserId, "") + "");
        params.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETPEOPLEBYSHARE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @OnClick({R.id.title_back, R.id.tv_gift_firend, R.id.tv_gift_shop})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_gift_firend:
                mShareAction.open();
                break;
            case R.id.tv_gift_shop:
                mShareAction1.open();
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 邀请有奖
             */
            case ACTION.WEBVIEWAGREEMENT:
                AgreementBean agreementBean = GsonUtil.toObj(res, AgreementBean.class);
                if (agreementBean.isSuccess()) {
                    content = agreementBean.getBody().getProtocal().getContent();

                    new WebService(this, Html.fromHtml(content).toString(), wb_gift_aggrement);
                    //硬件加速
                    wb_gift_aggrement.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    mLvGiftAggrement.setAdapter(new MineGiftLvAdapter(MineGiftActivity.this));
                } else {
                    T.show(agreementBean.getMsg());
                }
                break;
            /**
             * 获取累计邀请人数
             */
            case ACTION.GETPEOPLEBYSHARE:
                loadingDialog.cancel();
                GetSharePeopleBean getSharePeopleBean = GsonUtil.toObj(res, GetSharePeopleBean.class);
                if (getSharePeopleBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (getSharePeopleBean.isSuccess()) {

                        String invitees = getSharePeopleBean.getBody().getInvitees();
                        String points = getSharePeopleBean.getBody().getPoints();

                        tv_mine_modou_number.setText(points);
                        tv_mine_people_number.setText(invitees);

                    } else {
                        T.show(getSharePeopleBean.getMsg());
                    }
                }
                break;
            case ACTION.INVITEPRIZE:
                InvitePaizeBean invitePaizeBean = GsonUtil.toObj(res, InvitePaizeBean.class);
                if (invitePaizeBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (invitePaizeBean.isSuccess()) {
                        final String url = invitePaizeBean.getBody().getInviteUrlGenForC();
                        mShareAction = new ShareAction(MineGiftActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb(url);
                                web.setTitle("邀请有奖");
                                web.setDescription("邀请好友即送会员+现金+魔豆");
                                web.setThumb(new UMImage(MineGiftActivity.this, urlIcon));
                                new ShareAction(MineGiftActivity.this).withMedia(web)
                                        .setPlatform(share_media)
                                        .setCallback(mShareListener)
                                        .share();
                            }
                        });
                    }
                }
                break;
            case ACTION.INVITEBDUAN:
                InviteShopBean invitePaizeBean1 = GsonUtil.toObj(res, InviteShopBean.class);
                if (invitePaizeBean1.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (invitePaizeBean1.isSuccess()) {
                        final String url = invitePaizeBean1.getBody().getInviteUrlGenForB();
                        mShareAction1 = new ShareAction(MineGiftActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb(url);
                                web.setTitle("邀请有奖");
                                web.setDescription("邀请好友即送会员+现金+魔豆");
                                web.setThumb(new UMImage(MineGiftActivity.this, urlIcon));
                                new ShareAction(MineGiftActivity.this).withMedia(web)
                                        .setPlatform(share_media)
                                        .setCallback(mShareListener)
                                        .share();
                            }
                        });
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private static class CustomShareListener implements UMShareListener {

        private WeakReference<MineGiftActivity> mActivity;

        private CustomShareListener(MineGiftActivity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mActivity.get(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                        && platform != SHARE_MEDIA.EMAIL
                        && platform != SHARE_MEDIA.FLICKR
                        && platform != SHARE_MEDIA.FOURSQUARE
                        && platform != SHARE_MEDIA.TUMBLR
                        && platform != SHARE_MEDIA.POCKET
                        && platform != SHARE_MEDIA.PINTEREST
                        && platform != SHARE_MEDIA.INSTAGRAM
                        && platform != SHARE_MEDIA.GOOGLEPLUS
                        && platform != SHARE_MEDIA.YNOTE
                        && platform != SHARE_MEDIA.EVERNOTE) {
                    Toast.makeText(mActivity.get(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL
                    && platform != SHARE_MEDIA.FLICKR
                    && platform != SHARE_MEDIA.FOURSQUARE
                    && platform != SHARE_MEDIA.TUMBLR
                    && platform != SHARE_MEDIA.POCKET
                    && platform != SHARE_MEDIA.PINTEREST
                    && platform != SHARE_MEDIA.INSTAGRAM
                    && platform != SHARE_MEDIA.GOOGLEPLUS
                    && platform != SHARE_MEDIA.YNOTE
                    && platform != SHARE_MEDIA.EVERNOTE) {
                Toast.makeText(mActivity.get(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            }
            if (t != null) {
                L.e("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mActivity.get(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }
}