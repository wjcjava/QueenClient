package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullActivityGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullDetailListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.CombinationAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PackageInfoBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SeckillOrderSubmitBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.InvitePaizeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 作者：linxi on 2018/10/8 13:27
 * 邮箱：707078566@qq.com
 * 用途：秒杀套餐
 */
public class SecKillCombinationActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView mTitleTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;
    @Bind(R.id.com_banner)
    ImageView mComBanner;
    @Bind(R.id.com_price)
    TextView mComPrice;
    @Bind(R.id.com_old_price)
    TextView mComOldPrice;
    @Bind(R.id.com_ll1)
    LinearLayout mComLl1;
    @Bind(R.id.com_type_tv)
    TextView mComTypeTv;
    @Bind(R.id.tv_miaosha_shi)
    TextView mTvMiaoshaShi;
    @Bind(R.id.tv_miaosha_shi_dian1)
    TextView mTvMiaoshaShiDian1;
    @Bind(R.id.tv_miaosha_minter)
    TextView mTvMiaoshaMinter;
    @Bind(R.id.tv_miaosha_shi_dian2)
    TextView mTvMiaoshaShiDian2;
    @Bind(R.id.tv_miaosha_second)
    TextView mTvMiaoshaSecond;
    @Bind(R.id.com_ll2)
    LinearLayout mComLl2;
    @Bind(R.id.com_title)
    TextView mComTitle;
    @Bind(R.id.com_content)
    TextView mComContent;
    @Bind(R.id.com_num_tv)
    TextView mComNumTv;
    @Bind(R.id.com_rl)
    RecyclerView mComRl;
    @Bind(R.id.com_detail_btn)
    TextView mComDetailBtn;
    @Bind(R.id.com_hint_btn)
    TextView mComHintBtn;
    @Bind(R.id.com_lv)
    NoScrollListview mComLv;
    @Bind(R.id.com_gv)
    NoScrollGridView mComGv;
    @Bind(R.id.com_buy_btn)
    Button mComBuyBtn;
    @Bind(R.id.com_img)
    ImageView mComImg;
    @Bind(R.id.com_ll3)
    LinearLayout mComLl3;
    @Bind(R.id.com_ll4)
    LinearLayout mComLl4;
    private int type;
    private CombinationAdapter mCombinationAdapter;
    private myHandler mMyHandler;
    private int pageNumber = 1;
    private String id;
    private String begintime;
    private String endtime;
    private String time;
    private FullDetailListViewAdapter mFullListViewAdapter;
    private PackageInfoBean mPackageInfoBean;
    private boolean isskill = true;
    private String isLogin, userId;
    private ShareAction mShareAction;
    CustomShareListener mShareListener;
    private String urlIcon = "https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";
    private boolean mIsbuy;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seckillcombination;
    }

    @Override
    protected void initView() {
        super.initView();
        mTitleTitle.setText(getString(R.string.tcnr));
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
        isLogin = SP.get(SecKillCombinationActivity.this, SpContent.isLogin, "").toString();
        userId = SP.get(SecKillCombinationActivity.this, SpContent.UserId, "").toString();
        mShareListener = new CustomShareListener(SecKillCombinationActivity.this);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 0);
        id = intent.getStringExtra("id");
        begintime = intent.getStringExtra("begintime");
        endtime = intent.getStringExtra("endtime");
        mIsbuy = getIntent().getBooleanExtra("isbuy", true);
        mComOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        setdefault();
        packageInfo();
        initshophttp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SP.get(SecKillCombinationActivity.this, SpContent.isLogin, "").equals("1")) {
//            shareData();
        }
    }

    @OnClick({R.id.title_back, R.id.com_detail_btn, R.id.com_hint_btn, R.id.com_buy_btn, R.id.title_photo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //套餐详情
            case R.id.com_detail_btn:
                mComLl3.setVisibility(View.VISIBLE);
                mComLl4.setVisibility(View.GONE);
                mComDetailBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_seckill_white));
                mComHintBtn.setBackground(null);
                break;
            //温馨提示
            case R.id.com_hint_btn:
                mComLl3.setVisibility(View.GONE);
                mComLl4.setVisibility(View.VISIBLE);
                mComDetailBtn.setBackground(null);
                mComHintBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_seckill_white));
                break;
            //立即购买
            case R.id.com_buy_btn:
                secKillOrderSubmit();
                break;
            //秒杀
            case R.id.title_photo:
                if (isLogin.equals("1")) {
                    mShareAction.open();
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
        }
    }

    private void setdefault() {
        switch (type) {
            //已秒杀
            case 1:
                isskill = false;
                mComBuyBtn.setEnabled(false);
                mComBuyBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                mComImg.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nwms));
                mComTypeTv.setText(getString(R.string.seckill_4));
                mComTypeTv.setTextColor(ContextCompat.getColor(this, R.color.grey_color3));
                mComLl1.setBackgroundColor(ContextCompat.getColor(this, R.color.grey_color3));
                mComLl2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                mTvMiaoshaShi.setText("00");
                mTvMiaoshaMinter.setText("00");
                mTvMiaoshaSecond.setText("00");
                mTvMiaoshaShi.setBackground(getDrawable(R.drawable.shape_miaosha_time_light));
                mTvMiaoshaMinter.setBackground(getDrawable(R.drawable.shape_miaosha_time_light));
                mTvMiaoshaSecond.setBackground(getDrawable(R.drawable.shape_miaosha_time_light));
                mTvMiaoshaShiDian1.setTextColor(ContextCompat.getColor(this, R.color.grey_color3));
                mTvMiaoshaShiDian2.setTextColor(ContextCompat.getColor(this, R.color.grey_color3));
                break;
            //秒杀中
            case 2:
                isskill = true;
                time = endtime;
                if (mMyHandler == null)
                    mMyHandler = new myHandler(this);
                mMyHandler.sendEmptyMessage(0);
                if (mIsbuy) {
                    mComBuyBtn.setEnabled(true);
                    mComBuyBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.seckill_btn));
                } else {
                    mComBuyBtn.setEnabled(false);
                    mComBuyBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                }
                mComTypeTv.setText(getString(R.string.seckill_10));
                break;
            //即将秒杀
            case 3:
                isskill = true;
                time = begintime;
                if (mMyHandler == null)
                    mMyHandler = new myHandler(this);
                mMyHandler.sendEmptyMessage(0);
                mComBuyBtn.setEnabled(false);
                mComBuyBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                mComTypeTv.setText(getString(R.string.seckill_13));
                break;
        }
    }

    /**
     * 秒杀提交订单
     */
    private void secKillOrderSubmit() {
        String token = SP.get(SecKillCombinationActivity.this, SpContent.UserToken, "") + "";
        if (TextUtils.isEmpty(token)) {
            T.show("您的账号已过期，请重新登录");
            Intent intent = new Intent(SecKillCombinationActivity.this, LoginActivity.class);
            intent.putExtra("activite", "no");
            startActivity(intent);
            return;
        }
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("token", token);
        hashMap1.put("packageId", id);
        hashMap1.put("platform", "3");
        HttpUtils.doPost(ACTION.SECKILLORDERSUBMIT, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 套餐商品详情
     */
    private void packageInfo() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("packageId", id);
        hashMap1.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.PACKAGEINFO, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商家推荐商品的数据
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", pageNumber + "");
        hashMap1.put("cityCode", SP.get(this, SpContent.CityCode, "") + "");//shopId  111
        hashMap1.put("pageSize", SpContent.pageSize);
        hashMap1.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void shareData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("objectType", "1");
        parames.put("objectId", SP.get(this, SpContent.UserId, "") + "");
        parames.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INVITEPRIZE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            //精品推荐
            case ACTION.COMMENDGOODS:
                CommendGoodBean goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.isSuccess()) {
                    final List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();
                    FullActivityGridViewAdapter gridViewAdapter = new FullActivityGridViewAdapter(SecKillCombinationActivity.this, list);
                    mComGv.setAdapter(gridViewAdapter);
                } else {
                    T.show(goodBean.getMsg());
                }
                break;
            //秒杀套餐详情
            case ACTION.PACKAGEINFO:
                mPackageInfoBean = GsonUtil.toObj(res, PackageInfoBean.class);
                if (mPackageInfoBean.isSuccess() && "0".equals(mPackageInfoBean.getErrorCode())) {
                    final PackageInfoBean.BodyBean.SecKillPackageInfoBean secKillPackageInfo = mPackageInfoBean.getBody().getSecKillPackageInfo();
                    final String[] split = secKillPackageInfo.getPackageCover().split(",");
                    Glide.with(SecKillCombinationActivity.this).load(split[0]).into(mComBanner);
                    mComPrice.setText(secKillPackageInfo.getPackagePrice());
                    mComOldPrice.setText("¥" + secKillPackageInfo.getOfflinePrice());
                    mComTitle.setText(secKillPackageInfo.getPackageName());
                    mComContent.setText(secKillPackageInfo.getPackageExplain());
                    if (secKillPackageInfo.getSecKillGoodsList() != null) {
                        mComNumTv.setText("套餐内容（" + secKillPackageInfo.getSecKillGoodsList().size() + "）");
                        mComRl.setLayoutManager(new LinearLayoutManager(SecKillCombinationActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        if (mCombinationAdapter == null) {
                            mCombinationAdapter = new CombinationAdapter(SecKillCombinationActivity.this, secKillPackageInfo.getSecKillGoodsList());
                            mComRl.setAdapter(mCombinationAdapter);
                        }
                    } else {
                        mComNumTv.setText("套餐内容（" + 0 + "）");
                    }
                    if (secKillPackageInfo.isQuotaStatus() == true) {
                        mComBuyBtn.setEnabled(false);
                        mComBuyBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                    } else {
                        if (mIsbuy) {
                            mComBuyBtn.setEnabled(true);
                            mComBuyBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.seckill_btn));
                        } else {
                            mComBuyBtn.setEnabled(false);
                            mComBuyBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.color_CFCFCF));
                        }
                    }
                    if (mFullListViewAdapter == null) {
                        mFullListViewAdapter = new FullDetailListViewAdapter(SecKillCombinationActivity.this, secKillPackageInfo.getPackageDetailsList());
                        mComLv.setAdapter(mFullListViewAdapter);
                    }

                    mShareAction = new ShareAction(SecKillCombinationActivity.this).setDisplayList(
                            SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                            SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                    ).setShareboardclickCallback(new ShareBoardlistener() {
                        @Override
                        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                            UMWeb web = new UMWeb("https://t.jiyuanet.com/wg/h5/h5specificity/skillDetail.html?packageId=" +
                                    id + "&endTime=" + endtime + "&beginTime=" + begintime + "&status=" + type + "&finished=" + mIsbuy);
                            web.setTitle(secKillPackageInfo.getPackageName());
                            web.setDescription(secKillPackageInfo.getPackageExplain());
                            web.setThumb(new UMImage(SecKillCombinationActivity.this, split[0]));
                            new ShareAction(SecKillCombinationActivity.this).withMedia(web)
                                    .setPlatform(share_media)
                                    .setCallback(mShareListener)
                                    .share();
                        }
                    });
                } else {
                    T.show(mPackageInfoBean.getMsg());
                }
                break;
            //秒杀订单提交
            case ACTION.SECKILLORDERSUBMIT:
                SeckillOrderSubmitBean seckillOrderSubmitBean = GsonUtil.toObj(res, SeckillOrderSubmitBean.class);
                if (seckillOrderSubmitBean.isSuccess()) {
                    Intent intent = new Intent(SecKillCombinationActivity.this, SubmitActivity.class);
                    intent.putExtra("isseckill", true);
                    intent.putExtra("businessIds", seckillOrderSubmitBean.getBody().getOrderIds());
                    intent.putExtra("amount", mPackageInfoBean.getBody().getSecKillPackageInfo().getPackagePrice());
                    intent.putExtra("submitId", seckillOrderSubmitBean.getBody().getSubmitId());
                    startActivity(intent);
                } else {
                    T.show(seckillOrderSubmitBean.getMsg());
                }
                break;
            //获取分享链接地址
            case ACTION.INVITEPRIZE:
                InvitePaizeBean invitePaizeBean = GsonUtil.toObj(res, InvitePaizeBean.class);
                if (invitePaizeBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (invitePaizeBean.isSuccess()) {

                        final String url = invitePaizeBean.getBody().getInviteUrlGenForC();

                        mShareAction = new ShareAction(SecKillCombinationActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb(url);
                                web.setTitle("邀请有奖");
                                web.setDescription("邀请好友即送会员+现金+魔豆");
                                web.setThumb(new UMImage(SecKillCombinationActivity.this, urlIcon));
                                new ShareAction(SecKillCombinationActivity.this).withMedia(web)
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

    class myHandler extends Handler {

        private WeakReference mActivityWeakReference;

        public myHandler(Activity activity) {
            this.mActivityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SecKillCombinationActivity activity = (SecKillCombinationActivity) mActivityWeakReference.get();
            if (activity != null && isskill == true) {
                countDown();
                sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    /**
     * 秒杀
     */
    private void countDown() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String format = df.format(curDate);
        StringBuffer buffer = new StringBuffer();
        String substring = format.substring(0, 11);
        buffer.append(substring);
        String totime = time;
        try {
            java.util.Date date = df.parse(totime);
            java.util.Date date1 = df.parse(format);
            long defferenttime = date.getTime() - date1.getTime();
            if (defferenttime >= 0) {
                long days = defferenttime / (1000 * 60 * 60 * 24);
                long hours = (defferenttime - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
                long minute = (defferenttime - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
                long seconds = defferenttime % 60000;
                long second = Math.round((float) seconds / 1000);
                if (mTvMiaoshaShi != null)
                    if (hours > 9) {
                        mTvMiaoshaShi.setText(hours + "");
                    } else {
                        mTvMiaoshaShi.setText("0" + hours + "");
                    }
                if (minute >= 10) {
                    if (mTvMiaoshaMinter != null)
                        mTvMiaoshaMinter.setText(minute + "");
                } else {
                    if (mTvMiaoshaMinter != null)
                        mTvMiaoshaMinter.setText("0" + minute + "");
                }
                if (second >= 10) {
                    if (mTvMiaoshaSecond != null)
                        mTvMiaoshaSecond.setText(second + "");
                } else {
                    if (mTvMiaoshaSecond != null)
                        mTvMiaoshaSecond.setText("0" + second + "");
                }
            } else {
                switch (type) {
                    case 2:
                        type = 1;
                        break;
                    case 3:
                        type = 2;
                        mIsbuy = true;
                        break;
                }
                setdefault();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        if (mMyHandler != null)
            mMyHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private static class CustomShareListener implements UMShareListener {

        private WeakReference<FullActivity> mActivity;

        private CustomShareListener(SecKillCombinationActivity activity) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
