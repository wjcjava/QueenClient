package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullActivityGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullDetailListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullGoodsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullactivityListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProductDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopScoreBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.InvitePaizeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CoodinateCovertor;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.LngLat;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MD5;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NavtagationUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 商品详情
 */
public class FullActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView fullTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;
    @Bind(R.id.tv_shopping_oldprice)
    TextView tv_shopping_oldprice;
    @Bind(R.id.rl_full_collection)
    RelativeLayout rl_full_collection;
    @Bind(R.id.iv_full_collection)
    ImageView iv_full_collection;
    @Bind(R.id.full_cash)
    TextView full_cash;
    @Bind(R.id.tv_brief)
    TextView tv_brief;
    @Bind(R.id.tv_time)
    TextView tv_time;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.tv_full_shoppingcart)
    TextView tv_full_shoppingcart;
    @Bind(R.id.re_full_shop)
    RelativeLayout re_full_shop;
    @Bind(R.id.tv_fullactivity_name)
    TextView tv_fullactivity_name;
    @Bind(R.id.sc_full_top)
    ScrollInterceptScrollView sc_full_top;
    @Bind(R.id.full_activity_banner)
    Banner full_activity_banner;
    @Bind(R.id.re_full_customerservice)
    RelativeLayout re_full_customerservice;
    @Bind(R.id.tv_full_buyonly)
    TextView tv_full_buyonly;
    @Bind(R.id.tv_full_buy_bean)
    TextView tv_full_buy_bean;
    @Bind(R.id.li_fullactivity_discount)
    LinearLayout li_fullactivity_discount;
    @Bind(R.id.li_fullactivity_modou)
    LinearLayout li_fullactivity_modou;
    @Bind(R.id.full_activity_xuanfu)
    LinearLayout full_activity_xuanfu;
    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;
    @Bind(R.id.nsli_fullactivity_detail_pic)
    NoScrollListview nsli_fullactivity_detail_pic;
    @Bind(R.id.nsgd_fullactivity_jingpin)
    NoScrollGridView nsgd_fullactivity_jingpin;
    @Bind(R.id.nsli_fullactivity_comment)
    NoScrollListview nsli_fullactivity_comment;
    @Bind(R.id.tv_fullactivity_detail)
    TextView tv_fullactivity_detail;
    @Bind(R.id.ic_fullactivity_tishi)
    LinearLayout ic_fullactivity_tishi;
    @Bind(R.id.tv_full_navigation_tv)
    TextView mTvFullNavigationTv;
    @Bind(R.id.nsli_fullactivity_ratingbar)
    CustomRatingBar mNsliFullactivityRatingbar;
    @Bind(R.id.nsli_fullactivity_ratingbar_tv)
    TextView mNsliFullactivityRatingbarTv;

    private CommentsBean commentsBean;
    private CommendGoodBean goodBean;
    private FullGoodsAdapter myAdapter;
    boolean isColl = false;
    String goodsId, shopId, isLogin, userId, shopName;
    private int pageSum;
    private String shopLogo;
    int pageNumber = 1;
    String goods_pic, goods_content;
    CustomShareListener mShareListener;
    ShareAction mShareAction;
    private String urlIcon = "https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";
    private String service_tel = "4000885115", head_pic = "";
    LoadingDialog loadingDialog;
    String price;
    String goods_image = "";
    String isBean = "";
    String buyRules;
    int hight;
    @Bind(R.id.ic_fullactivity_detail)
    LinearLayout ic_fullactivity_detail;
    @Bind(R.id.ic_fullactivity_comment)
    LinearLayout ic_fullactivity_comment;
    @Bind(R.id.tv_fullactivity_detail_bottom)
    TextView tv_fullactivity_detail_bottom;
    @Bind(R.id.li_fullactivity_comment_bottom)
    LinearLayout li_fullactivity_comment_bottom;
    @Bind(R.id.li_fullactivity_comment)
    LinearLayout li_fullactivity_comment;
    @Bind(R.id.tv_fullactivity_comment_number)
    TextView tv_fullactivity_comment_number;
    @Bind(R.id.tv_fullactivity_comment_numbertop)
    TextView tv_fullactivity_comment_numbertop;
    @Bind(R.id.score_mine_evaluate)
    CustomRatingBar score_mine_evaluate;
    @Bind(R.id.tv_fullactivity_comment_score)
    TextView tv_fullactivity_comment_score;
    @Bind(R.id.full_activity_number_score)
    TextView full_activity_number_score;
    @Bind(R.id.score_fullactivity_evaluate)
    CustomRatingBar score_fullactivity_evaluate;
    @Bind(R.id.tv_fullactivity_discount)
    TextView tv_fullactivity_discount;
    @Bind(R.id.tv_fullactivity_tishi_bottom)
    TextView tv_fullactivity_tishi_bottom;
    @Bind(R.id.tv_fullactivity_tishi)
    TextView tv_fullactivity_tishi;
    @Bind(R.id.view_top)
    View view_top;

    String isQueenVip = "false";
    String disCount = "10";
    private String longitude;
    private String latitude;
    private String address;
    private boolean isbaidu = false;
    private boolean isgaode = false;
    private boolean istencent = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_full;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData() {
        super.initData();
        loadingDialog = new LoadingDialog(this);
        sc_full_top.smoothScrollTo(0, 0);
        sc_full_top.setFocusableInTouchMode(true);
        sc_full_top.requestFocus();

        Intent intent = this.getIntent();
        goodsId = intent.getStringExtra("goodsId");
        shopId = intent.getStringExtra("shopId");
        shopName = intent.getStringExtra("shopName");
        shopLogo = intent.getStringExtra("shopLogo");
//        number = intent.getStringExtra("number");

        isLogin = SP.get(FullActivity.this, SpContent.isLogin, "").toString();
        userId = SP.get(FullActivity.this, SpContent.UserId, "").toString();

        mShareListener = new CustomShareListener(FullActivity.this);

        inithttp();
        getProductDetailData();

        getShopScore();

        if (SP.get(FullActivity.this, SpContent.isLogin, "").equals("1")) {
//            shareData();

        }
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        linearLayout.measure(w, h);
        hight = linearLayout.getMeasuredHeight();

        sc_full_top.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (i1 >= hight) {
                    full_activity_xuanfu.setVisibility(View.VISIBLE);
                } else {
                    full_activity_xuanfu.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private static class CustomShareListener implements UMShareListener {

        private WeakReference<FullActivity> mActivity;

        private CustomShareListener(FullActivity activity) {
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
    protected void doFirstRequest() {
        super.doFirstRequest();
        doAddDetailData();
    }

    /**
     * 获取商品详情信息
     */
    private void getProductDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", goodsId);//商品ID
        params.put("userId", userId);//UID  可以不传
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETPRODUCTDETAIL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商品浏览次数增加
     */
    private void doAddDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", goodsId);//商品ID  0b5e8db1e94b4c44b3075940bc67a2e9
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ADDGOODSLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
        hashMap1.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商品的评价数据
     */
    private void inithttp() {
        loadingDialog.loadShow();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("goodsId", goodsId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.EVALUATION, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 收藏商品
     */
    private void getCollectionData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);//
        params.put("goodsId", goodsId);
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COLLECTIONPRODUCT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消收藏商品
     */
    private void getCancleCollectionData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);//
        params.put("goodsId", goodsId);
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CANCELCOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 添加购物车
     */
    private void AddCatData() {
        loadingDialog.loadShow();
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", userId);//用户ID
        params.put("goodsId", goodsId);
        params.put("unitPrice", price);//价格
        params.put("purchaseNumber", "1");//数量
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ADDTOCAT, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    /**
     * 获取店铺评分
     */
    private void getShopScore() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", goodsId);
        params.put("token", SP.get(FullActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETSHOPSCORE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @Override
    public void initView() {
        initText();
        initshophttp();
    }

    private void initText() {
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
        tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @OnClick({R.id.tv_purchase, R.id.title_back, R.id.tv_full_shoppingcart, R.id.rl_full_collection, R.id.title_photo, R.id.re_full_shop
            /*,R.id.rl_fullactivity_shop,R.id.rl_comment_top*/, R.id.re_full_customerservice, R.id.tv_fullactivity_detail, R.id.li_fullactivity_comment
            , R.id.tv_fullactivity_detail_bottom, R.id.li_fullactivity_comment_bottom, R.id.tv_fullactivity_tishi, R.id.tv_fullactivity_tishi_bottom, R.id.tv_full_navigation})

    public void OnClick(View view) {
        switch (view.getId()) {
            /**
             * 点击温馨提示
             */
            case R.id.tv_fullactivity_tishi_bottom:
            case R.id.tv_fullactivity_tishi:
                ic_fullactivity_tishi.setVisibility(View.VISIBLE);
                ic_fullactivity_detail.setVisibility(View.GONE);
                ic_fullactivity_comment.setVisibility(View.GONE);
                tv_fullactivity_tishi_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_tishi.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_detail_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_detail.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                break;
            /**
             * 点击评论
             */
            case R.id.li_fullactivity_comment:
            case R.id.li_fullactivity_comment_bottom:
                ic_fullactivity_detail.setVisibility(View.GONE);
                ic_fullactivity_comment.setVisibility(View.VISIBLE);
                ic_fullactivity_tishi.setVisibility(View.GONE);

                tv_fullactivity_detail_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_detail.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_tishi_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                break;
            /**
             * 点击商品详情
             */
            case R.id.tv_fullactivity_detail:
            case R.id.tv_fullactivity_detail_bottom:
                ic_fullactivity_detail.setVisibility(View.VISIBLE);
                ic_fullactivity_comment.setVisibility(View.GONE);
                ic_fullactivity_tishi.setVisibility(View.GONE);

                tv_fullactivity_detail_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                li_fullactivity_comment_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_detail.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.white));
                li_fullactivity_comment.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi_bottom.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi.setBackgroundColor(FullActivity.this.getResources().getColor(R.color.mine_back_gray));

                break;
            /**
             * 客服电话
             */
            case R.id.re_full_customerservice:
                Intent intentt = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + service_tel);
                intentt.setData(data);
                startActivity(intentt);
                break;
            /**
             * 点击底部店铺
             */
            case R.id.re_full_shop:
                Intent intentr = new Intent(this, WorkRoomDetailActivity.class);
                intentr.putExtra("shopName", shopName);
                intentr.putExtra("shopId", shopId);

                startActivity(intentr);
                break;
            /**
             * 分享
             */
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
            case R.id.title_back:
                finish();
                break;
            //提交订单
            case R.id.tv_purchase:
                if (isLogin.equals("1")) {
                    Intent intent = new Intent(FullActivity.this, PurchaseNowActivity.class);
                    intent.putExtra("shopName", shopName);
                    intent.putExtra("shopId", shopId);
                    intent.putExtra("goodId", goodsId);
                    intent.putExtra("goodName", fullTitle.getText().toString());
                    intent.putExtra("goodPrice", full_cash.getText().toString());
                    intent.putExtra("goodPriceSale", tv_shopping_oldprice.getText().toString());
                    intent.putExtra("goods_image", goods_image);
                    intent.putExtra("isBean", isBean);
                    intent.putExtra("isQueenVip", isQueenVip);
                    intent.putExtra("disCount", disCount);
                    intent.putExtra("buyRules", buyRules);

                    startActivity(intent);
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //加入购物车
            case R.id.tv_full_shoppingcart:
                if (isLogin.equals("1")) {
                    AddCatData();
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //收藏
            case R.id.rl_full_collection:
                if (isLogin.equals("1")) {
                    if (isColl) {
                        getCancleCollectionData();
                    } else {
                        getCollectionData();
                    }
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //导航
            case R.id.tv_full_navigation:
                if (NavtagationUtil.isAvilible(FullActivity.this, "com.baidu.BaiduMap")) {
                    isbaidu = true;
                }
                if (NavtagationUtil.isAvilible(FullActivity.this, "com.autonavi.minimap")) {
                    isgaode = true;
                }
                if (NavtagationUtil.isAvilible(FullActivity.this, "com.tencent.map")) {
                    istencent = true;
                }
                if (isbaidu == false && istencent == false && isgaode == false) {
                    Intent intent = new Intent(this, NavigationActivity.class);
                    intent.putExtra("latitude", latitude);
                    intent.putExtra("longitude", longitude);
                    intent.putExtra("address", address);
                    startActivity(intent);
                } else {
                    setDialog();
                }
                break;
        }
    }

    private void shareData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("objectType", "1");
        parames.put("objectId", SP.get(this, SpContent.UserId, "") + "");
        parames.put("token", SP.get(this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.INVITEPRIZE, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 获取店铺评分
             */
            case ACTION.GETSHOPSCORE:
                loadingDialog.cancel();
                ShopScoreBean shopScoreBean = GsonUtil.toObj(res, ShopScoreBean.class);
                if (shopScoreBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (shopScoreBean.isSuccess()) {
                        String score = shopScoreBean.getBody().getApiGoodsScoreGet().getAvgScore();
                        score_mine_evaluate.setRating(Float.parseFloat(score));
                        score_fullactivity_evaluate.setRating(Float.parseFloat(score));
                        NumberFormat nf = NumberFormat.getInstance();
                        String prices = nf.format(Double.parseDouble(score)) + "";
                        tv_fullactivity_comment_score.setText(prices);
                        full_activity_number_score.setText(prices);

                        mNsliFullactivityRatingbar.setRating(Float.parseFloat(score));
                        mNsliFullactivityRatingbarTv.setText(score);
                    } else {
                        T.show(shopScoreBean.getMsg());
                    }
                }
                break;
            /**
             * 获取分享链接地址
             */
            case ACTION.INVITEPRIZE:
                loadingDialog.cancel();
                InvitePaizeBean invitePaizeBean = GsonUtil.toObj(res, InvitePaizeBean.class);
                if (invitePaizeBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    if (invitePaizeBean.isSuccess()) {

                        final String url = invitePaizeBean.getBody().getInviteUrlGenForC();

                        mShareAction = new ShareAction(FullActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb(url);
                                web.setTitle("邀请有奖");
                                web.setDescription("邀请好友即送会员+现金+魔豆");
                                web.setThumb(new UMImage(FullActivity.this, urlIcon));
                                new ShareAction(FullActivity.this).withMedia(web)
                                        .setPlatform(share_media)
                                        .setCallback(mShareListener)
                                        .share();
                            }
                        });
                    }
                }
                break;
            /**
             * 加入购物车
             */
            case ACTION.ADDTOCAT:
                loadingDialog.cancel();
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
                        T.show(successBean.getMsg());
                        startActivity(new Intent(this, ShoppingCartActivity.class));
                    } else {
                        T.show(successBean.getMsg());
                    }
                }
                break;
            /**
             * 商品详情
             */
            case ACTION.GETPRODUCTDETAIL:
                loadingDialog.cancel();
                final ProductDetailBean productDetailBean = GsonUtil.toObj(res, ProductDetailBean.class);
                if (productDetailBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {

                    buyRules = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getBuyRule();

                    if (productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule().equals("")) {
                        tv_full_buy_bean.setVisibility(View.GONE);
                        li_fullactivity_modou.setVisibility(View.GONE);
                        isBean = "";
                    } else {
                        tv_full_buy_bean.setText("抵扣" + MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule()) + "魔豆");
                        isBean = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule();
                        li_fullactivity_modou.setVisibility(View.VISIBLE);
                    }

                    if (buyRules.equals("0")) {
                        tv_full_buyonly.setVisibility(View.GONE);
                    } else {
                        /**
                         *  1代表   只能购买一次
                         */
                        tv_full_buyonly.setVisibility(View.VISIBLE);

                        tv_fullactivity_discount.setVisibility(View.GONE);
                        li_fullactivity_discount.setVisibility(View.GONE);
                        view_top.setVisibility(View.GONE);
                    }

                    String isCollection = productDetailBean.getBody().getIfCollect();
                    if (isCollection.equals("1")) {
                        isColl = true;
                        iv_full_collection.setImageResource(R.drawable.collection_bein);
                    } else {
                        isColl = false;
                        iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                    }
                    goods_pic = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsPic();

                    /**
                     * 店铺详情图片
                     */

                    String[] goodPic = goods_pic.split(",");
                    List<String> good_pic_detail = new ArrayList<>();
                    for (int i = 0; i < goodPic.length; i++) {
                        good_pic_detail.add(goodPic[i]);
                    }
                    FullDetailListViewAdapter fullListViewAdapter = new FullDetailListViewAdapter(FullActivity.this, good_pic_detail);
                    nsli_fullactivity_detail_pic.setAdapter(fullListViewAdapter);


                    goods_content = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief();
                    goods_image = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsShow();
                    String[] goodsImage = goods_image.split(",");

                    List<String> goodsPics = new ArrayList<>();

                    for (int i = 0; i < goodsImage.length; i++) {
                        goodsPics.add(goodsImage[i]);
                    }

                    full_activity_banner.setBannerStyle(BannerConfig.NOT_INDICATOR)
                            .setImageLoader(new GlideImageLoader())
                            .setImages(goodsPics)
                            .setViewPagerIsScroll(true)
                            .setFocusable(true);
                    full_activity_banner.requestFocus();
                    full_activity_banner.start();

                    NumberFormat nf = NumberFormat.getInstance();
                    price = MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getSalesPrice()) + "";
                    String price1 = MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getMarketPrice()) + "";


                    if (productDetailBean.getBody().getGoodsListData().getAnsShopBasic() == null || productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard() == null || productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard().equals("0")) {
                        tv_fullactivity_discount.setVisibility(View.GONE);
                        li_fullactivity_discount.setVisibility(View.GONE);
                        isQueenVip = "false";
//                        view_top.setVisibility(View.GONE);
                    } else if (productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard().equals("1") && !"1".equals(buyRules)) {
                        tv_fullactivity_discount.setVisibility(View.VISIBLE);
                        li_fullactivity_discount.setVisibility(View.VISIBLE);
                        isQueenVip = "true";
                        double zhekou = Double.parseDouble(productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenShopDiscount());

                        disCount = zhekou + "";
                        double memeberPrice = Double.parseDouble(price) * zhekou / 10;
                        double end_price = Double.parseDouble(price) - memeberPrice;
                        tv_fullactivity_discount.setText("女王会员立减¥" + MD5.doubleToString(end_price + ""));

                    }
                    if (!TextUtils.isEmpty((productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule())) || productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard().equals("1")) {
                        if (!"1".equals(buyRules))
                            view_top.setVisibility(View.VISIBLE);
                    } else
                        view_top.setVisibility(View.GONE);
                    full_cash.setText("¥" + price);
                    tv_shopping_oldprice.setText("¥" + price1);
                    tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
                    tv_brief.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief());
                    if (productDetailBean.getBody().getGoodsListData() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getServiceTime() == null) {
                        tv_time.setText("服务时长：等待店铺填充");
                    } else {
                        tv_time.setText("服务时长：" + productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getServiceTime() + "分钟");
                    }
//                    if (number == null || number.equals("0") || "".equals(number)) {
//                        textView4.setText("已浏览：1次");
//                    } else {
//                        textView4.setText("已浏览：" + number + "次");
                    textView4.setText("已浏览：" + productDetailBean.getBody().getGoodsListData().getEcGoodsBrowses().getBrowseCounts() + "次");
//                    }
                    fullTitle.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                    tv_fullactivity_name.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                    ProductDetailBean.BodyBean.GoodsListDataBean.AnsShopBasicBean ansShopBasic = productDetailBean.getBody().getGoodsListData().getAnsShopBasic();
                    latitude = ansShopBasic.getGeoY();
                    longitude = ansShopBasic.getGeoX();
                    address = ansShopBasic.getAddrCity() + ansShopBasic.getAddrDistrict() + ansShopBasic.getShopAddr();
                    mTvFullNavigationTv.setText("商家地址：" + address);
                    final String[] split = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsThumb().split(",");
                    mShareAction = new ShareAction(FullActivity.this).setDisplayList(
                            SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                            SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                    ).setShareboardclickCallback(new ShareBoardlistener() {
                        @Override
                        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                            UMWeb web = new UMWeb("https://t.jiyuanet.com/wg/h5/h5specificity/goodsDetail.html?goodsId=" + goodsId);
                            web.setTitle(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                            web.setDescription(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief());
                            web.setThumb(new UMImage(FullActivity.this, split[0]));
                            new ShareAction(FullActivity.this).withMedia(web)
                                    .setPlatform(share_media)
                                    .setCallback(mShareListener)
                                    .share();
                        }
                    });
                }
                break;
            case ACTION.EVALUATION:
                loadingDialog.cancel();
                commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                if (commentsBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                } else {
                    List<CommentsBean.BodyBean.CommentsListDataBean> commList = commentsBean.getBody().getCommentsListData();
                    pageSum = commentsBean.getBody().getPageSum();

                    tv_fullactivity_comment_number.setText("评论（" + pageSum + "）");
                    tv_fullactivity_comment_numbertop.setText("评论（" + pageSum + "）");


                    FullactivityListViewAdapter fullcListViewAdapter = new FullactivityListViewAdapter(FullActivity.this, commList);
                    nsli_fullactivity_comment.setAdapter(fullcListViewAdapter);
                }
                break;
            case ACTION.ADDGOODSLIULAN://添加浏览量
                loadingDialog.cancel();
                SuccessBean successBean1 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean1.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean1.isSuccess()) {

                    } else {
                        T.show(successBean1.getMsg());
                    }
                }
                break;
            /**
             * 精品推荐
             */
            case ACTION.COMMENDGOODS:
                loadingDialog.cancel();
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (goodBean.isSuccess()) {
                        final List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();

                        FullActivityGridViewAdapter gridViewAdapter = new FullActivityGridViewAdapter(FullActivity.this, list);
                        nsgd_fullactivity_jingpin.setAdapter(gridViewAdapter);

                    } else {
                        T.show(goodBean.getMsg());
                    }
                }
                break;
            case ACTION.COLLECTIONPRODUCT://收藏商品
                loadingDialog.cancel();
                isColl = true;
                SuccessBean successBean2 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean2.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean2.isSuccess()) {
                        iv_full_collection.setImageResource(R.drawable.collection_bein);
                        //collection_bein
                        T.show(successBean2.getMsg());//成功
                    } else {
                        iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                        T.show(successBean2.getMsg());
                    }
                }
                break;
            case ACTION.CANCELCOLLECTION://取消收藏
                loadingDialog.cancel();
                isColl = false;
                SuccessBean successBean3 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean3.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean3.isSuccess()) {
                        iv_full_collection.setImageResource(R.drawable.icon_full_collection);
                        T.show(successBean3.getMsg());//成功
                    } else {
                        iv_full_collection.setImageResource(R.drawable.collection_bein);
                        T.show(successBean3.getMsg());
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 地图导航弹窗
     */
    private void setDialog() {
        View root = LayoutInflater.from(this).inflate(
                R.layout.map_navagation_sheet, null);
        //初始化视图
        LinearLayout pop_baidu = root.findViewById(R.id.pop_baidu);
        LinearLayout pop_gaode = root.findViewById(R.id.pop_gaode);
        LinearLayout pop_tenxun = root.findViewById(R.id.pop_tenxun);
        LinearLayout pop_cancel = root.findViewById(R.id.pop_cancel);
        final PopupWindow popupWindow = new PopupWindow(root, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.popwin_anim_style);
        popupWindow.setContentView(root);
        setWindowAlpha(0.5f);
        popupWindow.showAtLocation(findViewById(R.id.full_rl), Gravity.BOTTOM, 0, 0);
        if (isgaode == false) {
            pop_gaode.setVisibility(View.GONE);
        }
        if (isbaidu == false) {
            pop_baidu.setVisibility(View.GONE);
        }
        if (istencent == false) {
            pop_tenxun.setVisibility(View.GONE);
        }
        //百度地图
        pop_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.baidu.BaiduMap")) {
                LngLat lngLat = new LngLat(Double.valueOf(longitude), Double.valueOf(latitude));
                LngLat lngLat1 = CoodinateCovertor.bd_encrypt(lngLat);
                Intent intent = new Intent();
                intent.setData(Uri.parse("baidumap://map/direction?" +
                        "destination=latlng:" + lngLat1.getLantitude() + "," + lngLat1.getLongitude() + "|name:" + address + "&mode=driving"));
                startActivity(intent);
//                } else {
//                    //market为路径，id为包名
//                    //显示手机上所有的market商店
//                    Toast.makeText(FullActivity.this, "您尚未安装百度地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        //高德地图
        pop_gaode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.autonavi.minimap")) {
                Intent intent = new Intent();
                intent.setPackage("com.autonavi.minimap");
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
//                CoordinateConverter converter = new CoordinateConverter();
//                LatLng srcCoord = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
//                LatLng newEnd = converter.from(BD09LL).coord(srcCoord).convert();
                intent.setData(Uri.parse("androidamap://route?sourceApplication=女王魔镜&dlat=" + latitude + "&dlon=" + longitude + "&dname=" + address + "&dev=0&t=0"));
                startActivity(intent);
//                } else {
//                    Toast.makeText(FullActivity.this, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        //腾讯地图
        pop_tenxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (isAvilible(FullActivity.this, "com.tencent.map")) {
                Intent intent = new Intent();
//                CoordinateConverter converter = new CoordinateConverter();
//                LatLng srcCoord = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
//                LatLng newEnd = converter.from(BD09LL).coord(srcCoord).convert();
                intent.setData(Uri.parse("qqmap://map/routeplan?type=drive&to=" + address + "&tocoord=" + latitude + "," + longitude + "&policy=1&referer=女王魔镜"));
                startActivity(intent);
//                } else {
//                    Toast.makeText(FullActivity.this, "您尚未安装腾讯地图", Toast.LENGTH_LONG).show();
//                    Uri uri = Uri.parse("market://details?id=com.tencent.map");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
                popupWindow.dismiss();
            }
        });
        pop_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(1f);
            }
        });
    }

    private void setWindowAlpha(float alpha) {
        if (alpha < 0 || alpha > 1) return;
        WindowManager.LayoutParams windowLP = getWindow().getAttributes();
        windowLP.alpha = alpha;
        if (alpha == 1) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        getWindow().setAttributes(windowLP);
    }

}
