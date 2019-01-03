package com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.RateGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.CommentShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OrderMyAllOrderBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ScoreSelectPicBeam;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopProductListBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DateUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSRespContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.OSSUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomRatingBar;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.cache.CacheMode;
import com.ufo.imageselector.DWImages;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * 发表评价
 */
public class ScoreActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView scoreTitle;
    @Bind(R.id.title_right)
    TextView scoreRightTitle;
    @Bind(R.id.re_score)
    RecyclerView reScore;

    /**
     * 门店服务
     */
    @Bind(R.id.service_custom)
    CustomRatingBar service_custom;
    @Bind(R.id.rl_bottom)
    RelativeLayout rl_bottom;
    /**
     * 门店环境
     */
    @Bind(R.id.store_custom)
    CustomRatingBar store_custom;
    CommentShopBean commentShopBean = new CommentShopBean();
    String shopName;
    String shopId, orderId;
    int new_list_score = 0;
    String et_score_order_list;
    List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> apiOrderListBeanList = new ArrayList<>();
    List<ShopProductListBean> shopProductListBeans = new ArrayList<>();
    List<String> head_images = new ArrayList<>();

    List<ScoreSelectPicBeam> scoreSelectPicBeams = new ArrayList<>();
    List<String> new_upload = new ArrayList<>();
    NoScrollGridView gv_comment_gridView;
    int new_index = 0;
    String head_pic;
    ScoreAdapter myAdapter;
    LoadingDialog loadingDialog;
    private boolean ordertype;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_score;
    }

    @Override
    protected void initView() {
        super.initView();
        loadingDialog = new LoadingDialog(this);
        Intent intent = this.getIntent();
        apiOrderListBeanList = (List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean>) intent.getSerializableExtra("apiOrderListBeanList");
        shopName = intent.getStringExtra("shopName");
        shopId = intent.getStringExtra("shopId");
        orderId = intent.getStringExtra("orderId");
        ordertype = intent.getBooleanExtra("ordertype", true);
        if (ordertype == false) {
            rl_bottom.setVisibility(View.GONE);
        }
        for (int i = 0; i < apiOrderListBeanList.size(); i++) {
            ScoreSelectPicBeam selectPicBeam = new ScoreSelectPicBeam();
            selectPicBeam.setPostion(i + "");
            selectPicBeam.setNumber("6");
            selectPicBeam.setLocalPic("");
            selectPicBeam.setUploadPic("");
            scoreSelectPicBeams.add(selectPicBeam);
        }
        getOSSToken();
        initTitle();
        initDate();
    }

    private void initDate() {
        myAdapter = new ScoreAdapter(this, R.layout.item_score, apiOrderListBeanList);
        reScore.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reScore.setAdapter(myAdapter);
    }

    /**
     * 获取OSSToken
     */
    private void getOSSToken() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token", SP.get(ScoreActivity.this, SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.OSSGETTOKEN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initTitle() {
        scoreTitle.setText(R.string.published_order);
        scoreTitle.setTextColor(Color.BLACK);
        scoreRightTitle.setText(R.string.release);
        scoreRightTitle.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back, R.id.title_right})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            /**
             * 提交
             */
            case R.id.title_right:
                int mendian_service = (int) service_custom.getRating();
                int mendian_huanjing = (int) store_custom.getRating();

                commentShopBean.setOrderId(orderId);
                if (ordertype == true) {
                    commentShopBean.setServiceAttitude(mendian_service + "");
                    commentShopBean.setShopEnvironment(mendian_huanjing + "");
                }
                shopProductListBeans = new ArrayList<>();
                for (int i = 0; i < reScore.getChildCount(); i++) {

                    ShopProductListBean shopProductListBean = new ShopProductListBean();

                    android.widget.RelativeLayout layout = (android.widget.RelativeLayout) reScore.getChildAt(i);// 获得子item的layout
                    CustomRatingBar score_custom_list = layout.findViewById(R.id.score_custom_list);
                    EditText et_score_order = layout.findViewById(R.id.et_score_order);
                    CheckBox cb_order_checked = layout.findViewById(R.id.cb_order_checked);

                    new_list_score = (int) score_custom_list.getRating();
                    et_score_order_list = et_score_order.getText().toString();
                    String isCheck = "1";
                    if (cb_order_checked.isChecked()) {
                        isCheck = "1";
                    } else {
                        isCheck = "0";
                    }
                    shopProductListBean.setGoodsId(apiOrderListBeanList.get(i).getIntfAnsOrderDetails().getGoodsId());
                    shopProductListBean.setDetailId(apiOrderListBeanList.get(i).getIntfAnsOrderDetails().getId());
                    shopProductListBean.setIfMatch("");
                    shopProductListBean.setEmployeeAbility(new_list_score + "");//技师能力
                    shopProductListBean.setApprDetails(et_score_order_list);
                    shopProductListBean.setApprPic(scoreSelectPicBeams.get(i).getUploadPic());//评价图片
                    shopProductListBean.setIfAnon(isCheck);
                    shopProductListBean.setApprLevel(new_list_score + "");

                    shopProductListBeans.add(shopProductListBean);
                }
                Gson gson = new Gson();
                String str = gson.toJson(shopProductListBeans);
                String str1 = gson.toJson(commentShopBean);
                HashMap<String, String> params = new HashMap<>();
                params.put("shopId", shopId);
                params.put("goodsInfo", str);
                params.put("userId", SP.get(ScoreActivity.this, SpContent.UserId, "") + "");
                params.put("token", SP.get(ScoreActivity.this, SpContent.UserToken, "") + "");
                params.put("appraiseShopInfo", str1);
                HttpUtils.doPost(ACTION.COMMENTPRO, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.COMMENTPRO:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (successBean.isSuccess()) {
                        T.show("已完成评价");
                        Intent intent = new Intent();
                        intent.putExtra("orderId", orderId);
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        T.show("已评价，请返回订单页刷新页面");
                    }
                }
                break;
            /**
             * 获取Token
             */
            case ACTION.OSSGETTOKEN:
                OSSRespContent ossstsModel = GsonUtil.toObj(res, OSSRespContent.class);
                if (ossstsModel.getErrorCode().equals("6")) {
                    T.show("您的账号已过期，请重新登录");
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                } else {
                    if (ossstsModel.isSuccess()) {
                        OSSUtil.getInstance().initOSS(ScoreActivity.this, SpContent.ENDPOINT, ossstsModel);
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

    int cancel = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DWImages.parserResult(requestCode, data, new DWImages.GetImagesCallback() {
            @Override
            public void onResult(final List<String> images) {
                loadingDialog.loadShow();
                cancel = 0;
                head_pic = scoreSelectPicBeams.get(new_index).getUploadPic();

                for (int i = 0; i < images.size(); i++) {


                    final int index = i;
                    File oldFile = new File(images.get(i));
                    Luban.with(ScoreActivity.this) // 初始化
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
                                            loadingDialog.cancel();
                                            head_pic = head_pic + ("https://" + SpContent.BUCKET + "." + SpContent.ENDPOINTS + "/" + objectKey) + ",";
                                            cancel++;
                                            if (cancel == images.size()) {
                                                String end_pic = scoreSelectPicBeams.get(new_index).getLocalPic();
                                                String number = scoreSelectPicBeams.get(new_index).getNumber();
                                                ScoreSelectPicBeam newSelect = new ScoreSelectPicBeam();
                                                newSelect.setPostion(new_index + "");
                                                newSelect.setNumber(number + "");
                                                newSelect.setLocalPic(end_pic);
                                                newSelect.setUploadPic(head_pic);
                                                scoreSelectPicBeams.set(new_index, newSelect);
                                            }
                                            /*if (new_upload.size()==images.size()){
                                                UploadHeadData();
                                            }*/
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







                    /*final String objectKey = DateUtil.getCurrentDateTime("yyyyMMddhhmmssSSS") + ((int) ((Math.random() * 9 + 1) * 10000) + "") + ".jpg";

                    OSSUtil.getInstance().setBucket("prodr").asyncPutImage(objectKey, images.get(i), new OSSProgressCallback<PutObjectRequest>() {
                        @Override
                        public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                        }
                    }, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                        @Override
                        public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                            loadingDialog.cancel();
                            head_pic = head_pic+("https://" + SpContent.BUCKET + "." + SpContent.ENDPOINTS + "/" + objectKey)+",";
                            cancel++;
                            if(cancel == images.size()){
                                String end_pic = scoreSelectPicBeams.get(new_index).getLocalPic();
                                String number = scoreSelectPicBeams.get(new_index).getNumber();
                                ScoreSelectPicBeam newSelect = new ScoreSelectPicBeam();
                                newSelect.setPostion(new_index+"");
                                newSelect.setNumber(number+"");
                                newSelect.setLocalPic(end_pic);
                                newSelect.setUploadPic(head_pic);
                                scoreSelectPicBeams.set(new_index,newSelect);
                            }
                        }
                        @Override
                        public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                        }
                    });*/
                }
/**
 * 原来位置
 */
                String end_pic = scoreSelectPicBeams.get(new_index).getLocalPic();
                for (int i = 0; i < images.size(); i++) {
                    end_pic = end_pic + images.get(i) + ",";
                }
                String number = scoreSelectPicBeams.get(new_index).getNumber();
                int end_number = Integer.parseInt(number) - images.size();
                ScoreSelectPicBeam newSelect = new ScoreSelectPicBeam();
                newSelect.setPostion(new_index + "");
                newSelect.setNumber(end_number + "");
                newSelect.setLocalPic(end_pic);
                newSelect.setUploadPic(head_pic);
                scoreSelectPicBeams.set(new_index, newSelect);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    public class ScoreAdapter extends BaseQuickAdapter<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean, BaseViewHolder> {

        Context context;
        RateGridViewAdapter rateGridViewAdapter;

        public ScoreAdapter(Context context, int layoutResId, @Nullable List<OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean> data) {
            super(layoutResId, data);
            this.context = context;
        }

        @Override
        protected void convert(final BaseViewHolder helper, OrderMyAllOrderBean.BodyBean.ApiOrderListBean.IntfAnsOrderBean.ApiOrderDetailsListBean item) {
            helper.setText(R.id.tv_shop_name, item.getIntfAnsOrderDetails().getGoodsName());

            ImageView iv_order_title = helper.getView(R.id.iv_order_title);
            String goods_thumb = item.getIntfAnsOrderDetails().getGoodsThumb();
            String[] goodThumb = goods_thumb.split(",");
            Glide.with(context).load(goodThumb[0]).placeholder(R.drawable.dismiss).into(iv_order_title);

            CustomRatingBar score_custom_list = helper.getView(R.id.score_custom_list);
            score_custom_list.setmOnStarChangeListener(new CustomRatingBar.onStarChangedListener() {
                @Override
                public void onStarChange(CustomRatingBar ratingBar, float mark) {
                    if (mark == 1) {
                        helper.setText(R.id.tv_score, "非常差");
                    } else if (mark == 2) {
                        helper.setText(R.id.tv_score, "差");
                    } else if (mark == 3) {
                        helper.setText(R.id.tv_score, "一般");
                    } else if (mark == 4) {
                        helper.setText(R.id.tv_score, "好");
                    } else if (mark == 5) {
                        helper.setText(R.id.tv_score, "非常好");
                    }
                }
            });
            gv_comment_gridView = helper.getView(R.id.gv_comment_gridView);
            String head_ = scoreSelectPicBeams.get(helper.getLayoutPosition()).getLocalPic();
            if (head_.length() > 0) {
                head_images = new ArrayList<>();
                for (int i = 0; i < head_.split(",").length; i++) {
                    head_images.add(head_.split(",")[i]);
                }
            } else {
                head_images = new ArrayList<>();
            }
            rateGridViewAdapter = new RateGridViewAdapter(context, head_images);
            gv_comment_gridView.setAdapter(rateGridViewAdapter);
            rateGridViewAdapter.notifyDataSetChanged();

            rateGridViewAdapter.setOnItemClickListen(new RateGridViewAdapter.OnItemClickListen() {
                @Override
                public void OnItemClickAdd() {
                    new_index = helper.getLayoutPosition();
                    DWImages.getImages(ScoreActivity.this, DWImages.ACTION_ALBUM, Integer.parseInt(scoreSelectPicBeams.get(helper.getLayoutPosition()).getNumber()));
                }

                @Override
                public void OnItemClickDel(int position) {

                    int number = Integer.parseInt(scoreSelectPicBeams.get(helper.getLayoutPosition()).getNumber()) + 1;

                    String loca_pic = scoreSelectPicBeams.get(helper.getLayoutPosition()).getLocalPic();
                    String upload_pic = scoreSelectPicBeams.get(helper.getLayoutPosition()).getUploadPic();
                    String[] locaPic = loca_pic.split(",");
                    String[] uploadPic = upload_pic.split(",");

                    locaPic[position] = "";
                    uploadPic[position] = "";
                    //用StringBuffer来存放数组中的非空元素，用“;”分隔
                    /**
                     * 本地图片
                     */
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < locaPic.length; i++) {
                        if ("".equals(locaPic[i])) {
                            continue;
                        }
                        sb.append(locaPic[i]);
                        if (i != locaPic.length - 1) {
                            sb.append(";");
                        }
                    }
                    //用String的split方法分割，得到数组
                    locaPic = sb.toString().split(";");
                    String end_pic = "";
                    for (int i = 0; i < locaPic.length; i++) {
                        end_pic = end_pic + locaPic[i] + ",";
                    }
                    /**
                     * 上传图片
                     */
                    StringBuffer sbs = new StringBuffer();
                    for (int i = 0; i < uploadPic.length; i++) {
                        if ("".equals(uploadPic[i])) {
                            continue;
                        }
                        sbs.append(uploadPic[i]);
                        if (i != uploadPic.length - 1) {
                            sbs.append(";");
                        }
                    }
                    //用String的split方法分割，得到数组
                    uploadPic = sbs.toString().split(";");
                    String upend_pic = "";
                    for (int i = 0; i < uploadPic.length; i++) {
                        upend_pic = upend_pic + uploadPic[i] + ",";
                    }
                    ScoreSelectPicBeam selectPicBeam = new ScoreSelectPicBeam();
                    selectPicBeam.setPostion(helper.getLayoutPosition() + "");
                    selectPicBeam.setNumber(number + "");
                    selectPicBeam.setLocalPic(end_pic);
                    selectPicBeam.setUploadPic(upend_pic);

                    scoreSelectPicBeams.set(helper.getLayoutPosition(), selectPicBeam);
                    myAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}