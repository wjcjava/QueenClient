package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullActivityGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullDetailListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullactivityListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneAddBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProductDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopScoreBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CommendGoodBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
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
import com.bumptech.glide.Glide;
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

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 拼单
 */
public class FightaloneActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView fullTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;
    @Bind(R.id.tv_spell_shopbrowse)
    TextView tv_spell_shopbrowse;
    @Bind(R.id.iv_spell_shopcollection)
    ImageView iv_spell_shopcollection;
    @Bind(R.id.full_cash)
    TextView full_cash;
    @Bind(R.id.tv_spell_shopname)
    TextView tv_spell_shopname;
    @Bind(R.id.tv_spell_shopabstract)
    TextView tv_spell_shopabstract;
    @Bind(R.id.tv_spell_shoptime)
    TextView tv_spell_shoptime;
    @Bind(R.id.tv_collage)
    TextView tv_collage;
    @Bind(R.id.civ_title)
    CircleImageView civ_title;
    @Bind(R.id.tv_fightalone_textname)
    TextView tv_fightalone_textname;
    @Bind(R.id.tv_surplus)
    TextView tv_surplus;
    @Bind(R.id.tv_fightalone_shengyu)
    TextView tv_fightalone_shengyu;
    @Bind(R.id.tv_fightalone_name2)
    TextView tv_fightalone_name2;
    @Bind(R.id.tv_surplustwo)
    TextView tv_surplustwo;
    @Bind(R.id.tv_fightalone_shengyu2)
    TextView tv_fightalone_shengyu2;
    @Bind(R.id.re_surplus)
    RelativeLayout re_surplus;
    @Bind(R.id.view_fightaltwo)
    View view_fightaltwo;
    @Bind(R.id.re_surplustwo)
    RelativeLayout re_surplustwo;
    @Bind(R.id.tv_home_goShare)
    TextView tv_home_goShare;
    @Bind(R.id.tv_home_goShare1)
    TextView tv_home_goShare1;
    @Bind(R.id.iv_titletwo)
    CircleImageView iv_titletwo;
    @Bind(R.id.tv_spell_date)
    TextView mTvSpellDate;
    @Bind(R.id.tv_full_navigation_tv)
    TextView mTvFullNavigationTv;
    private int pageSum;
    private String isLogin, activityId, goodsName, goodsId, goodsBrief, goodsService, goodsSales, goodsMarket;
    String groupId = "", isOwner;
    String groupOrderId;
    String orderId;
    FightaloneBean fightaloneBean;
    String first_name, second_name, first_head, second_head, first_dialog_date, second_dialog_date, first_number, second_number;
    private CommendGoodBean goodBean;
    int hight, hight1;
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
    @Bind(R.id.tv_fullactivity_detail)
    TextView tv_fullactivity_detail;
    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;
    @Bind(R.id.sc_fightalone_top)
    ScrollInterceptScrollView sc_fightalone_top;
    @Bind(R.id.fightalone_activity_xuanfu)
    LinearLayout fightalone_activity_xuanfu;
    boolean isColl = false;
    String shopId, userId, shopName, number_fighta;
    String goods_pic, goods_content;
    @Bind(R.id.nsli_fullactivity_detail_pic)
    NoScrollListview nsli_fullactivity_detail_pic;
    String goods_image = "";
    @Bind(R.id.full_activity_banner)
    Banner full_activity_banner;
    String price;
    @Bind(R.id.fightalone_text_view)
    TextView tv_shopping_oldprice;
    @Bind(R.id.tv_full_buyonly)
    TextView tv_full_buyonly;
    @Bind(R.id.tv_full_buy_bean)
    TextView tv_full_buy_bean;
    @Bind(R.id.score_fight_evaluate)
    CustomRatingBar score_fight_evaluate;
    @Bind(R.id.tv_fightalone_number_score)
    TextView tv_fightalone_number_score;
    String isBean = "";
    int pageNumber = 1;
    private CommentsBean commentsBean;
    @Bind(R.id.nsli_fullactivity_comment)
    NoScrollListview nsli_fullactivity_comment;
    @Bind(R.id.nsgd_fullactivity_jingpin)
    NoScrollGridView nsgd_fullactivity_jingpin;
    @Bind(R.id.tv_fightalone_buy)
    TextView tv_fightalone_buy;
    @Bind(R.id.tv_startspell)
    TextView tv_startspell;
    @Bind(R.id.full_gp_number)
    TextView full_gp_number;
    String goodsGroup;
    private String service_tel = "4000885115";
    String yuanjia_first = "", yuanjia_second = "";
    @Bind(R.id.tv_fullactivity_discount)
    TextView tv_fullactivity_discount;
    @Bind(R.id.li_fighta_modou)
    LinearLayout li_fighta_modou;

    @Bind(R.id.tv_fullactivity_tishi_bottom)
    TextView tv_fullactivity_tishi_bottom;
    @Bind(R.id.tv_fullactivity_tishi)
    TextView tv_fullactivity_tishi;
    @Bind(R.id.ic_fullactivity_tishi)
    LinearLayout ic_fullactivity_tishi;
    @Bind(R.id.rl_fightalone_hight)
    RelativeLayout rl_fightalone_hight;
    /*@Bind(R.id.tv_fightalone_time)
    TextView tv_fightalone_time;*/
    @Bind(R.id.view0)
    View view0;
    @Bind(R.id.view_one)
    View view_one;

    String isQueenVip = "false";
    String disCount = "10";
    String buyRules;
    private String longitude;
    private String latitude;
    private String address;
    private boolean isbaidu = false;
    private boolean isgaode = false;
    private boolean istencent = false;
    CustomShareListener mShareListener;
    private String urlIcon = "https://mmbiz.qlogo.cn/mmbiz_png/XDC8ot2yPvMMpEwKmIrIgD6zqnVE3ex8vmXLnMMdq31GN9kalYqIvWZnL8zTfmEliaSTibRSibc27iacE9mPyj1kZA/0?wx_fmt=png";
    private ShareAction mShareAction;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fightalone;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView() {
        sc_fightalone_top.smoothScrollTo(0, 0);
        initText();
        Intent intent = this.getIntent();
        activityId = intent.getStringExtra("activityId");
        goodsName = intent.getStringExtra("goodsName");
        goodsId = intent.getStringExtra("goodsId");
        goodsBrief = intent.getStringExtra("goodsBrief");
        goodsService = intent.getStringExtra("goodsService");
        goodsSales = intent.getStringExtra("goodsSales");
        goodsMarket = intent.getStringExtra("goodsMarket");
        goodsGroup = intent.getStringExtra("goodsGroup");

        number_fighta = intent.getStringExtra("number");

        doAddDetailData();
        getFigHtData();
        inithttp();
        inithttps();
        initshophttp();
        getShopScore();

        isLogin = SP.get(this, SpContent.isLogin, "").toString();

        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        linearLayout.measure(w, h);
        rl_fightalone_hight.measure(w, h);
        hight = linearLayout.getMeasuredHeight();
        hight1 = rl_fightalone_hight.getMeasuredHeight();

        sc_fightalone_top.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if (i1 >= (hight + hight1 + 110)) {
                    fightalone_activity_xuanfu.setVisibility(View.VISIBLE);
                } else {
                    fightalone_activity_xuanfu.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * 商品浏览次数增加
     */
    private void doAddDetailData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("goodsId", goodsId);//商品ID  0b5e8db1e94b4c44b3075940bc67a2e9
        params.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.ADDGOODSLIULAN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取拼团人数
     */
    private void getFigHtData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("orderstatus", "PT");
        parames.put("activityId", activityId);
        parames.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.GETPINTUANDATA, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    private void initText() {
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back, R.id.relative_look_more, R.id.tv_home_goShare, R.id.tv_startspell, R.id.rl_spell_shopcollection,
            R.id.tv_home_goShare1, R.id.li_fullactivity_comment, R.id.li_fullactivity_comment_bottom, R.id.tv_fullactivity_detail, R.id.tv_fullactivity_detail_bottom
            , R.id.re_full_customerservice, R.id.re_full_shop, R.id.tv_fightalone_buy, R.id.tv_fullactivity_tishi_bottom, R.id.tv_fullactivity_tishi, R.id.tv_full_navigation, R.id.title_photo})
    public void click(View view) {
        switch (view.getId()) {
            /**
             * 点击温馨提示
             */
            case R.id.tv_fullactivity_tishi_bottom:
            case R.id.tv_fullactivity_tishi:
                ic_fullactivity_tishi.setVisibility(View.VISIBLE);
                ic_fullactivity_detail.setVisibility(View.GONE);
                ic_fullactivity_comment.setVisibility(View.GONE);

                tv_fullactivity_tishi_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_tishi.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_detail_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_detail.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                break;
            /**
             * 原价购买
             */
            case R.id.tv_fightalone_buy:
                if (isLogin.equals("1")) {
                    Intent intent = new Intent(FightaloneActivity.this, PurchaseNowActivity.class);
                    intent.putExtra("shopName", shopName);
                    intent.putExtra("shopId", shopId);
                    intent.putExtra("goodId", goodsId);
                    intent.putExtra("goodName", fullTitle.getText().toString());
                    intent.putExtra("goodPrice", yuanjia_first);
                    intent.putExtra("goodPriceSale", yuanjia_second);
                    intent.putExtra("goods_image", goods_image);
                    intent.putExtra("isBean", isBean);
                    intent.putExtra("isQueenVip", isQueenVip);
                    intent.putExtra("disCount", disCount);
                    intent.putExtra("buyRules", buyRules);
                    startActivity(intent);
                } else {
                    T.show("请您先登录APP");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
            /**
             * 店铺
             */
            case R.id.re_full_shop:
                Intent intentr = new Intent(this, WorkRoomDetailActivity.class);
                intentr.putExtra("shopName", shopName);
                intentr.putExtra("shopId", shopId);
                startActivity(intentr);
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
             * 点击评论
             */
            case R.id.li_fullactivity_comment:
            case R.id.li_fullactivity_comment_bottom:
                ic_fullactivity_detail.setVisibility(View.GONE);
                ic_fullactivity_comment.setVisibility(View.VISIBLE);
                ic_fullactivity_tishi.setVisibility(View.GONE);

                tv_fullactivity_detail_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_detail.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                li_fullactivity_comment.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                tv_fullactivity_tishi_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                break;
            /**
             * 点击商品详情
             */
            case R.id.tv_fullactivity_detail:
            case R.id.tv_fullactivity_detail_bottom:
                ic_fullactivity_detail.setVisibility(View.VISIBLE);
                ic_fullactivity_comment.setVisibility(View.GONE);
                ic_fullactivity_tishi.setVisibility(View.GONE);

                tv_fullactivity_detail_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                li_fullactivity_comment_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_detail.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.white));
                li_fullactivity_comment.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi_bottom.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));
                tv_fullactivity_tishi.setBackgroundColor(FightaloneActivity.this.getResources().getColor(R.color.mine_back_gray));


                break;
            case R.id.title_back:
                finish();
                break;
            //拼单剩余人数（查看更多）
            case R.id.relative_look_more:
                /**
                 * 点击查看更多
                 */

                Intent intent = new Intent(this, SpellOrderListActivity.class);
                intent.putExtra("goodsId", goodsId);
                intent.putExtra("activityId", activityId);
                intent.putExtra("goodsSales", goodsGroup);
                intent.putExtra("bean", (Serializable) fightaloneBean);
                startActivity(intent);
                break;
            case R.id.tv_home_goShare1:
                if (isLogin.equals("1")) {
                    isOwner = "1";
                    groupId = fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getGroupId();

                    final AlertDialog.Builder builder = new AlertDialog.Builder(FightaloneActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(FightaloneActivity.this);
                    View v = inflater.inflate(R.layout.dialog_fightalone_submit, null);
                    final Dialog dialog = builder.create();
                    dialog.show();
                    dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                    RelativeLayout rl_top_dissmiss = v.findViewById(R.id.rl_top_dissmiss);
                    TextView tv_dialog_name = v.findViewById(R.id.tv_dialog_name);
                    TextView tv_dialog_number = v.findViewById(R.id.tv_dialog_number);
                    TextView tv_dialog_date = v.findViewById(R.id.tv_dialog_date);
                    CircleImageView civ_dialog_head = v.findViewById(R.id.civ_dialog_head);
                    Button bt_dialog_pindan = v.findViewById(R.id.bt_dialog_pindan);

                    rl_top_dissmiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    tv_dialog_name.setText("参与" + second_name + "的拼单");
                    tv_dialog_number.setText(second_number);
                    tv_dialog_date.setText(second_dialog_date.substring(0, 10) + "过期");
                    Glide.with(FightaloneActivity.this).load(second_head).dontAnimate().into(civ_dialog_head);

                    bt_dialog_pindan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PinTuanData();
                        }
                    });

                } else {
                    T.show("请登录");
                    Intent intents = new Intent(this, LoginActivity.class);
                    startActivity(intents);
                }
                break;
            case R.id.tv_home_goShare:
                if (isLogin.equals("1")) {
                    isOwner = "1";
                    groupId = fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getGroupId();

                    final AlertDialog.Builder builder = new AlertDialog.Builder(FightaloneActivity.this);
                    LayoutInflater inflater = LayoutInflater.from(FightaloneActivity.this);
                    View v = inflater.inflate(R.layout.dialog_fightalone_submit, null);
                    final Dialog dialog = builder.create();
                    dialog.show();
                    dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后

                    RelativeLayout rl_top_dissmiss = v.findViewById(R.id.rl_top_dissmiss);
                    TextView tv_dialog_name = v.findViewById(R.id.tv_dialog_name);
                    TextView tv_dialog_number = v.findViewById(R.id.tv_dialog_number);
                    TextView tv_dialog_date = v.findViewById(R.id.tv_dialog_date);
                    CircleImageView civ_dialog_head = v.findViewById(R.id.civ_dialog_head);
                    Button bt_dialog_pindan = v.findViewById(R.id.bt_dialog_pindan);

                    rl_top_dissmiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    tv_dialog_name.setText("参与" + first_name + "的拼单");
                    tv_dialog_number.setText(first_number);
                    tv_dialog_date.setText(first_dialog_date.substring(0, 10) + "过期");
                    Glide.with(FightaloneActivity.this).load(first_head).dontAnimate().into(civ_dialog_head);

                    bt_dialog_pindan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PinTuanData();
                        }
                    });
                } else {
                    T.show("请登录");
                    Intent intent1 = new Intent(this, LoginActivity.class);
                    startActivity(intent1);

                }
                break;
            //开启拼单
            case R.id.tv_startspell:
                if (isLogin.equals("1")) {
                    isOwner = "0";
                    groupId = "";
                    PinTuanData();
                } else {
                    T.show("请登录");
                    Intent intent2 = new Intent(this, LoginActivity.class);
                    startActivity(intent2);
                }
                break;
            case R.id.rl_spell_shopcollection:
                if (isLogin.equals("1")) {
                    if (isColl) {
                        getCancleCollectionData();
                    } else {
                        initCollectiongp();
                    }
                } else {
                    T.show("请先登录");
                    Intent intent3 = new Intent(this, LoginActivity.class);
                    startActivity(intent3);
                }
                break;
            //导航
            case R.id.tv_full_navigation:
                if (NavtagationUtil.isAvilible(FightaloneActivity.this, "com.baidu.BaiduMap")) {
                    isbaidu = true;
                }
                if (NavtagationUtil.isAvilible(FightaloneActivity.this, "com.autonavi.minimap")) {
                    isgaode = true;
                }
                if (NavtagationUtil.isAvilible(FightaloneActivity.this, "com.tencent.map")) {
                    istencent = true;
                }
                if (isbaidu == false && istencent == false && isgaode == false) {
                    Intent intent1 = new Intent(this, NavigationActivity.class);
                    intent1.putExtra("latitude", latitude);
                    intent1.putExtra("longitude", longitude);
                    intent1.putExtra("address", address);
                    startActivity(intent1);
                } else {
                    setDialog();
                }
                break;
            //分享
            case R.id.title_photo:
                if (isLogin.equals("1")) {
                    mShareAction.open();
                }
                break;
        }
    }

    /**
     * 拼团Data(点击拼团)
     */
    private void PinTuanData() {
        /**
         * platform ：3”（固定值）  purchaseNumber ：1”（购买数量）  groupId：“”(建团不需要传值，参加拼团传拼团ID)
         * grouptype：“2”（拼团模式固定值）
         * ifrefund：“1”（固定值）   isOwner：“0”（是否房主    建团传0，参团传1）
         */
        HashMap<String, String> parames = new HashMap<>();
        parames.put("goodsId", goodsId);//拼团商品的ID
        parames.put("userId", SP.get(this, SpContent.UserId, "0") + "");
        parames.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        parames.put("platform", "3");
        parames.put("purchaseNumber", "1");
        parames.put("activityId", activityId);
        parames.put("groupId", groupId);
        parames.put("grouptype", "2");
        parames.put("ifrefund", "1");
        parames.put("isOwner", isOwner);
        HttpUtils.doPost(ACTION.ADDPINTUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 拼单详情
     */
    private void inithttp() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", goodsId);//商品ID
        params.put("userId", SP.get(FightaloneActivity.this, SpContent.UserId, "") + "");//UID  可以不传
        params.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETPRODUCTDETAIL, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 商品的评价数据
     */
    private void inithttps() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("goodsId", goodsId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", SpContent.pageSize);
        hashMap.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.EVALUATION, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 收藏拼单
     */
    private void initCollectiongp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("userId", SP.get(this, SpContent.UserId, "0") + "");
        parames.put("goodsId", goodsId);
        parames.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COLLECTIONPRODUCT, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 精品推荐
     */
    private void initshophttp() {
        HashMap<String, String> hashMap1 = new HashMap();
        hashMap1.put("saleFlag", "2");
        hashMap1.put("pageNumber", pageNumber + "");
        hashMap1.put("cityCode", SP.get(this, SpContent.CityCode, "") + "");//shopId  111
        hashMap1.put("pageSize", SpContent.pageSize);
        hashMap1.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.COMMENDGOODS, hashMap1, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 取消收藏商品
     */
    private void getCancleCollectionData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", userId);//
        params.put("goodsId", goodsId);
        params.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.CANCELCOLLECTION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取店铺评分
     */
    private void getShopScore() {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", goodsId);
        params.put("token", SP.get(FightaloneActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETSHOPSCORE, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 增加浏览次数
             */
            case ACTION.ADDGOODSLIULAN:
                SuccessBean successBean1 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean1.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (successBean1.isSuccess()) {

                    } else {
                        T.show(successBean1.getMsg());
                    }
                }
                break;
            /**
             * 获取店铺评分
             */
            case ACTION.GETSHOPSCORE:
                ShopScoreBean shopScoreBean = GsonUtil.toObj(res, ShopScoreBean.class);
                if (shopScoreBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (shopScoreBean.isSuccess()) {
                        String score = shopScoreBean.getBody().getApiGoodsScoreGet().getAvgScore();
                        score_mine_evaluate.setRating(Float.parseFloat(score));
                        score_fight_evaluate.setRating(Float.parseFloat(score));
                        NumberFormat nf = NumberFormat.getInstance();
                        String prices = nf.format(Double.parseDouble(score)) + "";
                        tv_fullactivity_comment_score.setText(prices);
                        tv_fightalone_number_score.setText(prices);
                    } else {
                        T.show(shopScoreBean.getMsg());
                    }
                }
                break;
            /**
             * 精品推荐
             */
            case ACTION.COMMENDGOODS:
                goodBean = GsonUtil.toObj(res, CommendGoodBean.class);
                if (goodBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (goodBean.isSuccess()) {
                        final List<CommendGoodBean.BodyBean.ApiEcGoodsBasicListBean> list = goodBean.getBody().getApiEcGoodsBasicList();

                        FullActivityGridViewAdapter gridViewAdapter = new FullActivityGridViewAdapter(FightaloneActivity.this, list);
                        nsgd_fullactivity_jingpin.setAdapter(gridViewAdapter);

                    } else {
                        T.show(goodBean.getMsg());
                    }
                }
                break;
            /**
             * 商品详情
             */
            case ACTION.GETPRODUCTDETAIL:
                final ProductDetailBean productDetailBean = GsonUtil.toObj(res, ProductDetailBean.class);
                if (productDetailBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    shopName = productDetailBean.getBody().getGoodsListData().getShopIdName();
                    shopId = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getShopId();

                    String isCollection = productDetailBean.getBody().getIfCollect();
                    if (isCollection.equals("1")) {
                        isColl = true;
                        iv_spell_shopcollection.setImageResource(R.drawable.collection_bein);
                    } else {
                        isColl = false;
                        iv_spell_shopcollection.setImageResource(R.drawable.icon_full_collection);
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
                    FullDetailListViewAdapter fullListViewAdapter = new FullDetailListViewAdapter(FightaloneActivity.this, good_pic_detail);
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
                    price = MD5.doubleToString(goodsGroup) + "";
                    String price1 = MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getSalesPrice()) + "";

                    yuanjia_first = price1 + "";
                    yuanjia_second = MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getMarketPrice()) + "";

                    full_cash.setText("¥" + price);
                    tv_shopping_oldprice.setText("¥" + price1);
                    tv_shopping_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
                    tv_spell_shopabstract.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief());
                    if (productDetailBean.getBody().getGoodsListData() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getServiceTime() == null) {
                        tv_spell_shoptime.setText("服务时长：等待店铺填充");
                    } else {
                        tv_spell_shoptime.setText("服务时长：" + productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getServiceTime() + "分钟");
                    }

                    number_fighta = productDetailBean.getBody().getGoodsListData().getEcGoodsBrowses().getBrowseCounts() + "";

                    if (number_fighta == null || number_fighta.equals("0")) {
                        tv_spell_shopbrowse.setText("已浏览：1次");
                    } else {
                        tv_spell_shopbrowse.setText("已浏览：" + number_fighta + "次");
                    }
                    fullTitle.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                    tv_spell_shopname.setText(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());

                    buyRules = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getBuyRule();

                    if (productDetailBean.getBody().getGoodsListData().getAnsShopBasic() == null || productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard() == null || productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard().equals("0")) {
                        tv_fullactivity_discount.setVisibility(View.GONE);

                        isQueenVip = "false";

                    } else if (productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenCard().equals("1")) {
                        tv_fullactivity_discount.setVisibility(View.GONE);

                        isQueenVip = "true";

                        double zhekou = Double.parseDouble(productDetailBean.getBody().getGoodsListData().getAnsShopBasic().getQueenShopDiscount());

                        disCount = zhekou + "";
                        double memeberPrice = Double.parseDouble(price) * zhekou / 10;
                        tv_fullactivity_discount.setText("女王会员立减：¥" + MD5.doubleToString((Double.parseDouble(price) - memeberPrice) + ""));
                    }

                    if (productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule() == null || productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule().equals("")) {
                        tv_full_buy_bean.setVisibility(View.GONE);
                        li_fighta_modou.setVisibility(View.GONE);
                        view0.setVisibility(View.GONE);
                        isBean = "";
                    } else {
                        tv_full_buy_bean.setText("抵扣" + MD5.doubleToString(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule()) + "魔豆");
                        isBean = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getPointRule();
                    }
                    tv_full_buyonly.setVisibility(View.VISIBLE);
                    ProductDetailBean.BodyBean.GoodsListDataBean.AnsShopBasicBean ansShopBasic = productDetailBean.getBody().getGoodsListData().getAnsShopBasic();
                    latitude = ansShopBasic.getGeoY();
                    longitude = ansShopBasic.getGeoX();
                    address = ansShopBasic.getAddrCity() + ansShopBasic.getAddrDistrict() + ansShopBasic.getShopAddr();
                    mTvFullNavigationTv.setText("商家地址：" + address);

                    ProductDetailBean.BodyBean.GoodsListDataBean.EcGoodsBasicBean ecGoodsBasic = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic();
                    mTvSpellDate.setText("活动日期：" + getdate(ecGoodsBasic.getCreateDate()) + "~" + getdate(ecGoodsBasic.getUpdateDate()));
                    final String[] split = productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsThumb().split(",");
                    if (mShareAction == null) {
                        mShareAction = new ShareAction(FightaloneActivity.this).setDisplayList(
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                                SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
                        ).setShareboardclickCallback(new ShareBoardlistener() {
                            @Override
                            public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                                UMWeb web = new UMWeb("https://t.jiyuanet.com/wg/h5/h5specificity/goodsDetail.html?goodsId=" + goodsId + "&activityId=" + activityId);
                                web.setTitle(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsName());
                                web.setDescription(productDetailBean.getBody().getGoodsListData().getEcGoodsBasic().getGoodsBrief());
                                web.setThumb(new UMImage(FightaloneActivity.this, split[0]));
                                new ShareAction(FightaloneActivity.this).withMedia(web)
                                        .setPlatform(share_media)
                                        .setCallback(mShareListener)
                                        .share();
                            }
                        });
                    }
                }
                break;
            /**
             * 点击拼团
             */
            case ACTION.ADDPINTUAN:
                FightaloneAddBean fightaloneAddBean = GsonUtil.toObj(res, FightaloneAddBean.class);
                if (fightaloneAddBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (fightaloneAddBean.isSuccess() && fightaloneAddBean.getErrorCode().equals("0")) {
                        groupOrderId = fightaloneAddBean.getBody().getGroupOrderId();
                        orderId = fightaloneAddBean.getBody().getOrderId();
                        groupId = fightaloneAddBean.getBody().getGroupId();

                        Intent intent = new Intent(this, SubmitPinTuanActivity.class);
                        intent.putExtra("businessIds", orderId);
                        intent.putExtra("amount", goodsGroup);
                        intent.putExtra("groupId", groupId);
                        intent.putExtra("groupIds", groupId);
                        startActivity(intent);
                    } else {
                        T.show(fightaloneAddBean.getMsg());
                    }
                }

                break;
            /**
             * 拼团之外的信息
             */
            case ACTION.GETPINTUANDATA:

                fightaloneBean = GsonUtil.toObj(res, FightaloneBean.class);
                if (fightaloneBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    tv_collage.setText(fightaloneBean.getBody().getJoinSums() + "人在拼团");

                    full_gp_number.setText(fightaloneBean.getBody().getGroupNums() + "人团");
                    //tv_fightalone_time.setText("活动时间："+fightaloneBean.getBody().getActivity().getGroupStart()+"至"+fightaloneBean.getBody().getActivity().getGroupEnd());

                    goodsSales = fightaloneBean.getBody().getEcGoodsBasic().getSalesPrice() + "";
                    goodsGroup = fightaloneBean.getBody().getActivity().getGroupPrice();

                    tv_fightalone_buy.setText("¥" + MD5.doubleToString(goodsSales) + "\n" + "原价购买");
                    tv_startspell.setText("¥" + MD5.doubleToString(goodsGroup) + "\n" + "开启拼单");


                    if (fightaloneBean.getBody().getGpOrderList().size() == 0 || fightaloneBean.getBody().getGpOrderList() == null ||
                            fightaloneBean.getBody().getJoinSums() == 0) {
                        re_surplus.setVisibility(View.GONE);
                        view_fightaltwo.setVisibility(View.GONE);
                        re_surplustwo.setVisibility(View.GONE);
                    } else if (fightaloneBean.getBody().getGpOrderList().size() == 1) {
                        re_surplus.setVisibility(View.VISIBLE);
                        view_fightaltwo.setVisibility(View.GONE);
                        re_surplustwo.setVisibility(View.GONE);

                        tv_fightalone_textname.setText(fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName());
                        tv_surplus.setText("还差" + (fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums()) + "人拼成");
                        long second = Long.parseLong(fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndTimes().toString());
                        Date date1 = new Date(second);
                        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
                        tv_fightalone_shengyu.setText("剩余时间" + format1.format(date1));

                        if (fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic() == null || fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic().equals("")) {

                        } else {
                            String head_pic = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic();
                            String[] headPic = head_pic.split(",");
                            Glide.with(FightaloneActivity.this).load(headPic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(civ_title);
                        }

                        first_name = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName();
                        first_head = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic();
                        first_dialog_date = fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndDate();

                        first_number = fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums() + "";
                    } else {
                        re_surplus.setVisibility(View.VISIBLE);
                        view_fightaltwo.setVisibility(View.VISIBLE);
                        re_surplustwo.setVisibility(View.VISIBLE);
                        tv_fightalone_textname.setText(fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName());
                        tv_surplus.setText("还差" + (fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums()) + "人拼成");
                        view_fightaltwo.setVisibility(View.VISIBLE);

                        long second = Long.parseLong(fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndTimes().toString());
                        Date date1 = new Date(second);
                        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
                        tv_fightalone_shengyu.setText("剩余时间" + format1.format(date1));

                        tv_fightalone_name2.setText(fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getUserName());
                        tv_surplustwo.setText("还差" + (fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getJoinNums()) + "人拼成");
                        long second1 = Long.parseLong(fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getEndTimes().toString());

                        Date date = new Date(second1);
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        tv_fightalone_shengyu2.setText("剩余时间" + format.format(date));


                        if (fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic() == null || fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic().equals("")) {

                        } else {
                            String head_pic = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic();
                            String[] headPic = head_pic.split(",");
                            Glide.with(FightaloneActivity.this).load(headPic[0]).dontAnimate().placeholder(R.drawable.dismiss).into(civ_title);
                        }

                        if (fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getHeadPic() == null || fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getHeadPic().equals("")) {

                        } else {
                            String head_pics = fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getHeadPic();
                            String[] headPics = head_pics.split(",");
                            Glide.with(FightaloneActivity.this).load(headPics[0]).dontAnimate().placeholder(R.drawable.dismiss).into(iv_titletwo);
                        }

                        first_name = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName();
                        second_name = fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getUserName();
                        first_head = fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getHeadPic();
                        second_head = fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getHeadPic();
                        first_dialog_date = fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndDate();
                        second_dialog_date = fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getEndDate();

                        first_number = fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums() + "";
                        second_number = fightaloneBean.getBody().getGroupNums() - fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getJoinNums() + "";
                    }
                }
                break;
            case ACTION.COLLECTIONPRODUCT:
                isColl = true;
                SuccessBean successBean2 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean2.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (successBean2.isSuccess()) {
                        iv_spell_shopcollection.setImageResource(R.drawable.collection_bein);
                        //collection_bein
                        T.show(successBean2.getMsg());//成功
                    } else {
                        iv_spell_shopcollection.setImageResource(R.drawable.icon_full_collection);
                        T.show(successBean2.getMsg());
                    }
                }
                break;
            case ACTION.CANCELCOLLECTION://取消收藏
                isColl = false;
                SuccessBean successBean3 = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean3.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    if (successBean3.isSuccess()) {
                        iv_spell_shopcollection.setImageResource(R.drawable.icon_full_collection);
                        T.show(successBean3.getMsg());//成功
                    } else {
                        iv_spell_shopcollection.setImageResource(R.drawable.collection_bein);
                        T.show(successBean3.getMsg());
                    }
                }
                break;
            case ACTION.EVALUATION:
                commentsBean = GsonUtil.toObj(res, CommentsBean.class);
                if (commentsBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    List<CommentsBean.BodyBean.CommentsListDataBean> commList = commentsBean.getBody().getCommentsListData();
                    pageSum = commentsBean.getBody().getPageSum();

                    tv_fullactivity_comment_number.setText("评论（" + pageSum + "）");
                    tv_fullactivity_comment_numbertop.setText("评论（" + pageSum + "）");

                    FullactivityListViewAdapter fullcListViewAdapter = new FullactivityListViewAdapter(FightaloneActivity.this, commList);
                    nsli_fullactivity_comment.setAdapter(fullcListViewAdapter);
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
        popupWindow.showAtLocation(findViewById(R.id.sc_fightalone_ll), Gravity.BOTTOM, 0, 0);
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

    private String getdate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf2.format(date);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
