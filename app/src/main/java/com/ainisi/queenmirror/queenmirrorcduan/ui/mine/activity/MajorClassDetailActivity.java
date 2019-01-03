package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.EducationCourseListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter.MajorCourseListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.AliyunPlayAuthBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.EducationCourseListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorClassDetailBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MajorClassListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCourseListBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.WatchRecordBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.Formatter;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GsonUtils;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NetworkUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.WrapContentLinearLayoutManager;
import com.alivc.player.AliyunErrorCode;
import com.alivc.player.VcPlayerLog;
import com.aliyun.vodplayer.media.AliyunLocalSource;
import com.aliyun.vodplayer.media.AliyunPlayAuth;
import com.aliyun.vodplayer.media.AliyunVidSource;
import com.aliyun.vodplayer.media.AliyunVidSts;
import com.aliyun.vodplayer.media.AliyunVodPlayer;
import com.aliyun.vodplayer.media.IAliyunVodPlayer;
import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

import static com.aliyun.vodplayer.media.IAliyunVodPlayer.PlayerState.Completed;
import static com.aliyun.vodplayer.media.IAliyunVodPlayer.PlayerState.Idle;
import static com.aliyun.vodplayer.media.IAliyunVodPlayer.PlayerState.Stopped;

/**
 * 课程详情
 *
 * @author jiangchao
 * created at 2018/9/7 下午3:32
 */
public class MajorClassDetailActivity extends BaseNewActivity implements HttpCallBack {


    private static final String TAG = "MajorClassDetailActivit";
    @Bind(R.id.title_title)
    TextView commentTitle;
    @Bind(R.id.rv_video_list)
    RecyclerView rvVideoList;
    @Bind(R.id.rv_education_course_list)
    RecyclerView rvEducationCourseList;
    @Bind(R.id.title_back)
    ImageView titleBack;
    @Bind(R.id.tv_class_name)
    TextView tvClassName;
    @Bind(R.id.tv_play_nums)
    TextView tvPlayNums;
    @Bind(R.id.tv_remarks)
    TextView tvRemarks;
    @Bind(R.id.surfaceView)
    SurfaceView surfaceView;
    //    @Bind(R.id.play)
//    Button playBtn;
//    @Bind(R.id.stop)
//    Button stopBtn;
//    @Bind(R.id.pause)
//    Button pauseBtn;
//    @Bind(R.id.replay)
//    Button replayBtn;
    @Bind(R.id.currentPosition)
    TextView positionTxt;
    @Bind(R.id.progress)
    SeekBar progressBar;
    @Bind(R.id.totalDuration)
    TextView durationTxt;
    //    @Bind(R.id.cb_play_video)
//    CheckBox cbPlayVideo;
    //    @Bind(R.id.video_view)
//    AliyunVodPlayerView mAliyunVodPlayerView;
    @Bind(R.id.iv_class_cover)
    ImageView ivClassCover;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.iv_play_video)
    ImageView ivPlayVideo;
    @Bind(R.id.iv_pause_video)
    ImageView ivPauseVideo;
    @Bind(R.id.iv_get_more)
    ImageView ivGetMore;
    @Bind(R.id.iv_cancel_full_screen)
    ImageView ivCancelFullScreen;
    @Bind(R.id.iv_full_screen)
    ImageView ivFullScreen;
    @Bind(R.id.ssv)
    ScrollInterceptScrollView ssv;
    @Bind(R.id.ll_ssv)
    LinearLayout llSsv;
    @Bind(R.id.progress_layout)
    LinearLayout progressLayout;
    @Bind(R.id.root_title)
    RelativeLayout rootTitle;
    @Bind(R.id.rl_control)
    RelativeLayout rlControl;
    @Bind(R.id.rl_screen)
    RelativeLayout rlScreen;
    private String videoTitle;
    List<MajorClassDetailBean.BodyEntity.VideoListEntity> videoListEntityList;
    List<EducationCourseListBean.BodyEntity.ClassListEntity> classListEntityList;
    MajorCourseListAdapter mAdapter;
    EducationCourseListAdapter educationAdapter;
    MajorClassListBean.BodyEntity.ClassListEntity classListEntity;
    MajorClassDetailBean.BodyEntity.AnsSchoolClassEntity ansSchoolClassEntity;

    /**
     * 课程ID
     */
    private String classId;

    /**
     * 专业ID
     */
    private String majorId;

    private int playNums;
    private String playAuth;

    private String videoId;
    private String isFree;
    private String remarks;
    private String className;
    private double videoPrice;
    private AliyunVodPlayer aliyunVodPlayer;
    private String vid;
    private String classCover;
    private MyCourseListBean.BodyEntity.ListEntity myCourseListEntity;
    private WatchRecordBean.BodyEntity.RecordsListEntity recordsListEntity;
    private String flag;
    private Boolean isOpen = true;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_major_class_detail;
    }

    @Override
    protected void initData() {
        super.initData();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d(TAG, "surfaceCreated");
                aliyunVodPlayer.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.d(TAG, "surfaceChanged");
                aliyunVodPlayer.surfaceChanged();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.d(TAG, "surfaceDestroyed");
            }
        });
        initVodPlayer();
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");
        classListEntity = (MajorClassListBean.BodyEntity.ClassListEntity) intent.getSerializableExtra("classListEntity");
        myCourseListEntity = (MyCourseListBean.BodyEntity.ListEntity) intent.getSerializableExtra("myCourseListEntity");
        recordsListEntity = (WatchRecordBean.BodyEntity.RecordsListEntity) intent.getSerializableExtra("recordsListEntity");
        if ("1".equals(flag)) {
            videoTitle = myCourseListEntity.getClassName();
            classId = myCourseListEntity.getId();
            majorId = myCourseListEntity.getMajorId();
        } else if ("2".equals(flag)) {
            videoTitle = recordsListEntity.getClassName();
            classId = recordsListEntity.getClassId();
            majorId = recordsListEntity.getMajorId();
        } else if ("3".equals(flag)) {
            videoTitle = classListEntity.getClassName();
            classId = classListEntity.getId();
            majorId = classListEntity.getMajorId();
        }
        commentTitle.setText(videoTitle);
        if (NetworkUtil.isNetWorkConnected(this)) {
            getCourseData(classId);
            getEducationData(classId, majorId);
        } else {
            Toast.makeText(this, "当前无网络连接，请稍候再试", Toast.LENGTH_SHORT).show();
            progressbar.setVisibility(View.INVISIBLE);
        }

//        }


//        cbPlayVideo.setOnCheckedChangeListener(cbPlayOnCheckedChangeListener);


//        pauseBtn();

        //Android获取屏幕高宽度
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        screenWidth = outMetrics.widthPixels;
        screenHeight = outMetrics.heightPixels;

    }


    int screenWidth, screenHeight;

    private void intentUtil() {
        Intent intent = new Intent(MajorClassDetailActivity.this, WatchCourseTipActivity.class);
        intent.putExtra("videoId", videoId);
        intent.putExtra("chargeAmount", videoPrice);
        startActivity(intent);
    }


//    CompoundButton.OnCheckedChangeListener cbPlayOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            if (b) {
//                //播放
////                cbAlipay.setChecked(true);
////                cbWechat.setChecked(false);
//                pauseBtn();
//
//            } else {
//                //暂停
////                cbAlipay.setChecked(false);
////                cbWechat.setChecked(true);
//                progressbar.setVisibility(View.VISIBLE);
//                if (!StringUtil.isNullOrEmpty(videoId)) {
//                    playBtn();
//                    ivClassCover.setVisibility(View.GONE);
//                    progressbar.setVisibility(View.GONE);
//
//                } else {
//                    Toast.makeText(MajorClassDetailActivity.this, "请先选择课程集数", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        }
//    };


    private void pauseBtn() {
        mPlayerState = aliyunVodPlayer.getPlayerState();
        if (mPlayerState == IAliyunVodPlayer.PlayerState.Started) {
            aliyunVodPlayer.pause();
//            pauseBtn.setText(R.string.resume_button);
        } else if (mPlayerState == IAliyunVodPlayer.PlayerState.Paused) {
            aliyunVodPlayer.resume();
//            pauseBtn.setText(R.string.pause_button);
        }
    }

    private void setPlaySource(String vid, String playAuth) {
//        String type = getIntent().getStringExtra("type");
//        if ("authInfo".equals(type)) {
        //auth方式
        //NOTE： 注意过期时间。特别是重播的时候，可能已经过期。所以重播的时候最好重新请求一次服务器。
//            mVid = getIntent().getStringExtra("vid").toString();
//            String authInfo = getIntent().getStringExtra("authinfo");
        AliyunPlayAuth.AliyunPlayAuthBuilder aliyunPlayAuthBuilder = new AliyunPlayAuth.AliyunPlayAuthBuilder();
        aliyunPlayAuthBuilder.setVid(vid);
        aliyunPlayAuthBuilder.setPlayAuth(playAuth);
        aliyunPlayAuthBuilder.setQuality(IAliyunVodPlayer.QualityValue.QUALITY_LOW);
        //aliyunVodPlayer.setAuthInfo(aliyunPlayAuthBuilder.build());
        mPlayAuth = aliyunPlayAuthBuilder.build();
//        } else if ("localSource".equals(type)) {
//            //本地播放
//            String url = getIntent().getStringExtra("url");
//            AliyunLocalSource.AliyunLocalSourceBuilder asb = new AliyunLocalSource.AliyunLocalSourceBuilder();
//            asb.setSource(url);
//            //aliyunVodPlayer.setLocalSource(asb.build());
//            mLocalSource = asb.build();
//        } else if ("vidSource".equals(type)) {
//            mVid = getIntent().getStringExtra("vid").toString();
//            mVidSource = new AliyunVidSource();
//            String authInfo = getIntent().getStringExtra("authinfo");
//            String token = getIntent().getStringExtra("token");
//            String akid = getIntent().getStringExtra("akid");
//            String aks = getIntent().getStringExtra("aks");
//            mVidSource.setVid(mVid);
//            mVidSource.setAuthInfo(authInfo);
//            mVidSource.setStsToken(token);
//            mVidSource.setAcKey(aks);
//            mVidSource.setAcId(akid);
//            mVidSource.setDomainRegion("cn-shanghai");
//            mVidSource.setHlsUriToken("hlsuritokenaaaa");
//            //mVidSource.setDomain("vod-test5.cn-shanghai.aliyuncs.com");
////             mVidSource.setDomain("jiyoujia.com");
//        }else if("vidsts".equals(type))
//        {
//            mVid = getIntent().getStringExtra("vid").toString();
//
//            String akid = getIntent().getStringExtra("akId");
//            String aks = getIntent().getStringExtra("akSecret");
//            String token = getIntent().getStringExtra("securityToken");
//
//            mVidSts = new AliyunVidSts();
//            mVidSts.setVid(mVid);
//            mVidSts.setAcId(akid);
//            mVidSts.setAkSceret(aks);
//            mVidSts.setSecurityToken(token);
//
//        }
    }

    private void getCourseData(String classId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", SP.get(this, SpContent.UserToken, "") + "");
        map.put("classId", classId);
        HttpUtils.doPost(ACTION.GET_CLASS_DETAILS, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    private void getEducationData(String classId, String majorId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", SP.get(this, SpContent.UserToken, "") + "");
        map.put("classId", classId);
        map.put("majorId", majorId);
        HttpUtils.doPost(ACTION.CLASS_RECOMMEND, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    private void getPlayAuth(String videoId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", SP.get(this, SpContent.UserToken, "") + "");
        map.put("videoId", videoId);
        HttpUtils.doPost(ACTION.GET_PLAY_AUTH, map, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action) {
            case ACTION.GET_CLASS_DETAILS:
                MajorClassDetailBean majorClassDetailBean = GsonUtils.jsonToBean(res, MajorClassDetailBean.class);
                if (majorClassDetailBean.isSuccess()) {
                    if ("6".equals(majorClassDetailBean.getErrorCode())) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        ansSchoolClassEntity = majorClassDetailBean.getBody().getAnsSchoolClass();
                        if (ansSchoolClassEntity != null) {
                            remarks = ansSchoolClassEntity.getRemarks();
                            className = ansSchoolClassEntity.getClassName();
                            playNums = ansSchoolClassEntity.getPlayNums();
                            tvPlayNums.setText(playNums + "次播放");
                            tvClassName.setText(className);
                            //内容处理
                            tvRemarks.setText("教程简介:" + remarks);//先把内容填充
//                            if (tvRemarks.getLineCount() > 1) {//判断TextView有没有超过1行
//                                tvRemarks.setMaxLines(1);//超过10行就设置只能显示1行
//                                ivGetMore.setVisibility(View.VISIBLE);//把展示按钮显示出来
//                            } else {
//                                ivGetMore.setVisibility(View.GONE);//没有超过10行，就把展示展示按钮隐藏
//                            }


                            classCover = ansSchoolClassEntity.getClassCover();
                            Glide.with(this).load(classCover).into(ivClassCover);

                        }
                        videoListEntityList = majorClassDetailBean.getBody().getVideoList();
                        if (videoListEntityList.size() > 0 && videoListEntityList != null) {
                            videoListEntityList.get(0).getVideoId();
                            isFree = videoListEntityList.get(0).getIsFree();
                            videoId = videoListEntityList.get(0).getId();
                            videoPrice = videoListEntityList.get(0).getVideoPrice();
                            vid = videoListEntityList.get(0).getVideoId();

                            if ("1".equals(isFree)) {
                                //可以直接播放
                                //1.获取授权token
//                                progressbar.setVisibility(View.VISIBLE);
                                getPlayAuth(videoId);
//                                sAutoPlay=true;
//                                        playBtn();
//                                inSeek = false;
//                                aliyunVodPlayer.start();
//                                ivPauseVideo.setVisibility(View.VISIBLE);
//                                ivPlayVideo.setVisibility(View.GONE);

                            } else if ("0".equals(isFree)) {
                                //要购买
                                intentUtil();
                            }
                        }


                        showVideoList();
                    }


                }
                Log.i(TAG, res);
                break;

            case ACTION.CLASS_RECOMMEND:
                EducationCourseListBean educationCourseListBean = GsonUtils.jsonToBean(res, EducationCourseListBean.class);
                if (educationCourseListBean.isSuccess()) {
                    if ("6".equals(educationCourseListBean.getErrorCode())) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        classListEntityList = educationCourseListBean.getBody().getClassList();
                        showEducationVideoList(classListEntityList);
                    }


                }

                Log.i(TAG, res);
                break;

            case ACTION.GET_PLAY_AUTH:
                AliyunPlayAuthBean aliyunPlayAuthBean = GsonUtils.jsonToBean(res, AliyunPlayAuthBean.class);
                if (aliyunPlayAuthBean.isSuccess()) {
                    if ("6".equals(aliyunPlayAuthBean.getErrorCode())) {
                        T.show("您的账号已过期，请重新登录");
                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("activite", "no");
                        startActivity(intent);
                    } else {
                        playAuth = aliyunPlayAuthBean.getBody().getPlayAuth();
                        setPlaySource(vid, playAuth);


                    }

                }
                Log.i(TAG, res);
                break;
            default:
                break;
        }
    }

    //用来记录前后台切换时的状态，以供恢复。
    private IAliyunVodPlayer.PlayerState mPlayerState;
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SS");


    private AliyunPlayAuth mPlayAuth = null;
    private AliyunVidSource mVidSource = null;
    private AliyunLocalSource mLocalSource = null;
    private AliyunVidSts mVidSts = null;
    //    public boolean mAutoPlay = false;
    public boolean mAutoPlay = false;

    private boolean mMute = false;
    private boolean replay = false;
    private boolean inSeek = false;
    private boolean isCompleted = false;

    private List<String> logStrs = new ArrayList<>();

    private void showEducationVideoList(List<EducationCourseListBean.BodyEntity.ClassListEntity> classListEntityList) {
        educationAdapter = new EducationCourseListAdapter(MajorClassDetailActivity.this, classListEntityList);
        GridLayoutManager lm = new GridLayoutManager(this, 2);
        rvEducationCourseList.setLayoutManager(lm);
        rvEducationCourseList.setAdapter(educationAdapter);
        educationAdapter.setOnItemListener(new EducationCourseListAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, List<EducationCourseListBean.BodyEntity.ClassListEntity> entity) {

                if (entity != null) {
                    classId = entity.get(position).getId();
                    majorId = entity.get(position).getMajorId();
                    getCourseData(classId);
                    getEducationData(classId, majorId);
                }
            }
        });
    }

    private Map<String, String> qualityList = new HashMap<>();

    private LinearLayout qualityLayout;
    private List<String> mQualities = new ArrayList<>();
    private List<Button> qualityIds = new ArrayList<>();

    private void initVodPlayer() {
        sAutoPlay = true;
//        aliyunVodPlayer = new AliyunVodPlayer(this);
//        String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test_save_cache";
//        aliyunVodPlayer.setPlayingCache(true, sdDir, 60 * 60 /*时长, s */, 300 /*大小，MB*/);
//        aliyunVodPlayer.setCirclePlay(true);
//        aliyunVodPlayer.setOnPreparedListener(new IAliyunVodPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared() {
////                Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), R.string.toast_prepare_success, Toast.LENGTH_SHORT).show();
//                logStrs.add(format.format(new Date()) + getString(R.string.log_prepare_success));
//
//
////                qualityLayout.removeAllViews();
//
//                if (mLocalSource == null) {
//                    qualityIds.clear();
//                    mQualities = aliyunVodPlayer.getMediaInfo().getQualities();
//                    String current = aliyunVodPlayer.getCurrentQuality();
//                    //update quality buttons
//                    for (String quality : mQualities) {
//                        Button btn = new Button(getBaseContext());
//                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                        layoutParams.weight = 1;
//                        layoutParams.setMargins(10, 0, 10, 0);
//                        btn.setText(qualityList.get(quality));
//                        btn.setTextSize(14);
//                        btn.setTag(quality);
//                        btn.setTextColor(Color.rgb(49, 50, 51));
//                        btn.setBackgroundColor(Color.rgb(207, 207, 207));
//                        btn.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                changeQuality((Button) v);
//                            }
//                        });
//                        if (current.equals(quality)) {
//                            btn.setTextColor(Color.rgb(255, 255, 255));
//                            btn.setBackgroundColor(Color.rgb(3, 106, 150));
//                        }
//                        qualityIds.add(btn);
////                        qualityLayout.addView(btn, layoutParams);
//
//                    }
//                }
//
//
//                if (sAutoPlay || mAutoPlay) {
//                    aliyunVodPlayer.start();
////                    pauseBtn.setText(R.string.pause_button);
////                    cbPlayVideo.setChecked(false);
////                    logStrs.add(format.format(new Date()) + getString(R.string.log_strart_play));
//                    if (mMute) {
//                        aliyunVodPlayer.setMuteMode(mMute);
//                    }
////                    brightnessBar.setProgress(aliyunVodPlayer.getScreenBrightness());
////                    volumeBar.setProgress(aliyunVodPlayer.getVolume());
//                }
//                mAutoPlay = false;
//            }
//        });
//        aliyunVodPlayer.setOnFirstFrameStartListener(new IAliyunVodPlayer.OnFirstFrameStartListener() {
//            @Override
//            public void onFirstFrameStart() {
//
//                //首帧显示之后再开始更新进度信息。
//                inSeek = false;
//                showVideoProgressInfo();
////                showVideoSizeInfo();
//
//
//                Map<String, String> debugInfo = aliyunVodPlayer.getAllDebugInfo();
//                long createPts = 0;
//                if (debugInfo.get("create_player") != null) {
//                    String time = debugInfo.get("create_player");
//                    createPts = (long) Double.parseDouble(time);
////                    logStrs.add(format.format(new Date(createPts)) + getString(R.string.log_player_create_success));
//                }
//                if (debugInfo.get("open-url") != null) {
//                    String time = debugInfo.get("open-url");
//                    long openPts = (long) Double.parseDouble(time) + createPts;
////                    logStrs.add(format.format(new Date(openPts)) + getString(R.string.log_open_url_success));
//                }
//                if (debugInfo.get("find-stream") != null) {
//                    String time = debugInfo.get("find-stream");
//                    VcPlayerLog.d(TAG + "lfj0914", "find-Stream time =" + time + " , createpts = " + createPts);
//                    long findPts = (long) Double.parseDouble(time) + createPts;
////                    logStrs.add(format.format(new Date(findPts)) + getString(R.string.log_request_stream_success));
//                }
//                if (debugInfo.get("open-stream") != null) {
//                    String time = debugInfo.get("open-stream");
//                    VcPlayerLog.d(TAG + "lfj0914", "open-Stream time =" + time + " , createpts = " + createPts);
//                    long openPts = (long) Double.parseDouble(time) + createPts;
////                    logStrs.add(format.format(new Date(openPts)) + getString(R.string.log_start_open_stream));
//                }
////                logStrs.add(format.format(new Date()) + getString(R.string.log_first_frame_played));
//            }
//        });
//        aliyunVodPlayer.setOnErrorListener(new IAliyunVodPlayer.OnErrorListener() {
//            @Override
//            public void onError(int arg0, int arg1, String msg) {
//
//                if (aliyunVodPlayer != null) {
//                    aliyunVodPlayer.stop();
//                }
//
//                if (arg0 == AliyunErrorCode.ALIVC_ERR_INVALID_INPUTFILE.getCode()) {
//                    //当播放本地报错4003的时候，可能是文件地址不对，也有可能是没有权限。
//                    //如果是没有权限导致的，就做一个权限的错误提示。其他还是正常提示：
//                    int storagePermissionRet = ContextCompat.checkSelfPermission(MajorClassDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                    if (storagePermissionRet != PackageManager.PERMISSION_GRANTED) {
//                        Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), getString(R.string.toast_fail_msg) + getString(R.string.toast_no_local_storage_permission), Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                }
//
//                Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), getString(R.string.toast_fail_msg) + msg, Toast.LENGTH_SHORT).show();
//            }
//        });
//        aliyunVodPlayer.setOnCompletionListener(new IAliyunVodPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion() {
//                Log.d(TAG, "onCompletion--- ");
//                isCompleted = true;
//                inSeek = false;
//                showVideoProgressInfo();
//                stopUpdateTimer();
//            }
//        });
//        aliyunVodPlayer.setOnSeekCompleteListener(new IAliyunVodPlayer.OnSeekCompleteListener() {
//            @Override
//            public void onSeekComplete() {
//                logStrs.add(format.format(new Date()) + getString(R.string.log_seek_completed));
//                inSeek = false;
//            }
//        });
//        aliyunVodPlayer.setOnStoppedListner(new IAliyunVodPlayer.OnStoppedListener() {
//            @Override
//            public void onStopped() {
//                logStrs.add(format.format(new Date()) + getString(R.string.log_play_stopped));
//                if (replay) {
//                    logStrs.add(format.format(new Date()) + getString(R.string.log_start_get_data));
//                    if (mVidSource != null) {
//                        aliyunVodPlayer.prepareAsync(mVidSource);
//                    } else if (mPlayAuth != null) {
//                        aliyunVodPlayer.prepareAsync(mPlayAuth);
//                    } else if (mLocalSource != null) {
//                        aliyunVodPlayer.prepareAsync(mLocalSource);
//                    } else if (mVidSts != null) {
//                        aliyunVodPlayer.prepareAsync(mVidSts);
//                    }
//                    mAutoPlay = true;
//                }
//                replay = false;
//                inSeek = false;
//            }
//        });
//
//        aliyunVodPlayer.setOnChangeQualityListener(new IAliyunVodPlayer.OnChangeQualityListener() {
//            @Override
//            public void onChangeQualitySuccess(String finalQuality) {
//                Log.d(TAG, "onChangeQualitySuccess");
//                inSeek = false;
//                logStrs.add(format.format(new Date()) + getString(R.string.log_change_quality_success));
//                showVideoProgressInfo();
//            }
//
//            @Override
//            public void onChangeQualityFail(int code, String msg) {
//                Log.d(TAG, "onChangeQualityFail。。。" + code + " ,  " + msg);
//                logStrs.add(format.format(new Date()) + getString(R.string.log_change_quality_fail));
//            }
//        });
//        aliyunVodPlayer.enableNativeLog();


        aliyunVodPlayer = new AliyunVodPlayer(this);
        String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test_save_cache";
        aliyunVodPlayer.setPlayingCache(true, sdDir, 60 * 60 /*时长, s */, 300 /*大小，MB*/);
        aliyunVodPlayer.setCirclePlay(false);
        aliyunVodPlayer.setOnPreparedListener(new IAliyunVodPlayer.OnPreparedListener() {
            @Override
            public void onPrepared() {
//                Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), R.string.toast_prepare_success, Toast.LENGTH_SHORT).show();
//                logStrs.add(format.format(new Date()) + getString(R.string.log_prepare_success));


//                qualityLayout.removeAllViews();

//                if (mLocalSource == null) {
//                    qualityIds.clear();
//                    mQualities = aliyunVodPlayer.getMediaInfo().getQualities();
//                    String current = aliyunVodPlayer.getCurrentQuality();
//                    //update quality buttons
//                    for (String quality : mQualities) {
//                        Button btn = new Button(getBaseContext());
//                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                        layoutParams.weight = 1;
//                        layoutParams.setMargins(10, 0, 10, 0);
//                        btn.setText(qualityList.get(quality));
//                        btn.setTextSize(14);
//                        btn.setTag(quality);
//                        btn.setTextColor(Color.rgb(49, 50, 51));
//                        btn.setBackgroundColor(Color.rgb(207, 207, 207));
//                        btn.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                changeQuality((Button) v);
//                            }
//                        });
//                        if (current.equals(quality)) {
//                            btn.setTextColor(Color.rgb(255, 255, 255));
//                            btn.setBackgroundColor(Color.rgb(3, 106, 150));
//                        }
//                        qualityIds.add(btn);
////                        qualityLayout.addView(btn, layoutParams);
//
//                    }
//                }


                if (sAutoPlay || mAutoPlay) {
                    aliyunVodPlayer.start();
//                    pauseBtn.setText(R.string.pause_button);
                    ivPauseVideo.setVisibility(View.VISIBLE);

//                    logStrs.add(format.format(new Date()) + getString(R.string.log_strart_play));
                    if (mMute) {
                        aliyunVodPlayer.setMuteMode(mMute);
                    }
//                    brightnessBar.setProgress(aliyunVodPlayer.getScreenBrightness());
//                    volumeBar.setProgress(aliyunVodPlayer.getVolume());
                }
                mAutoPlay = false;
            }
        });
        aliyunVodPlayer.setOnFirstFrameStartListener(new IAliyunVodPlayer.OnFirstFrameStartListener() {
            @Override
            public void onFirstFrameStart() {

                //首帧显示之后再开始更新进度信息。
                inSeek = false;
                showVideoProgressInfo();
//                showVideoSizeInfo();

                progressbar.setVisibility(View.GONE);

                Map<String, String> debugInfo = aliyunVodPlayer.getAllDebugInfo();
                long createPts = 0;
                if (debugInfo.get("create_player") != null) {
                    String time = debugInfo.get("create_player");
                    createPts = (long) Double.parseDouble(time);
//                    logStrs.add(format.format(new Date(createPts)) + getString(R.string.log_player_create_success));
                }
                if (debugInfo.get("open-url") != null) {
                    String time = debugInfo.get("open-url");
                    long openPts = (long) Double.parseDouble(time) + createPts;
//                    logStrs.add(format.format(new Date(openPts)) + getString(R.string.log_open_url_success));
                }
                if (debugInfo.get("find-stream") != null) {
                    String time = debugInfo.get("find-stream");
                    VcPlayerLog.d(TAG + "lfj0914", "find-Stream time =" + time + " , createpts = " + createPts);
                    long findPts = (long) Double.parseDouble(time) + createPts;
//                    logStrs.add(format.format(new Date(findPts)) + getString(R.string.log_request_stream_success));
                }
                if (debugInfo.get("open-stream") != null) {
                    String time = debugInfo.get("open-stream");
                    VcPlayerLog.d(TAG + "lfj0914", "open-Stream time =" + time + " , createpts = " + createPts);
                    long openPts = (long) Double.parseDouble(time) + createPts;
//                    logStrs.add(format.format(new Date(openPts)) + getString(R.string.log_start_open_stream));
                }
//                logStrs.add(format.format(new Date()) + getString(R.string.log_first_frame_played));
            }
        });
        aliyunVodPlayer.setOnErrorListener(new IAliyunVodPlayer.OnErrorListener() {
            @Override
            public void onError(int arg0, int arg1, String msg) {

                if (aliyunVodPlayer != null) {
                    aliyunVodPlayer.stop();
                }

                if (arg0 == AliyunErrorCode.ALIVC_ERR_INVALID_INPUTFILE.getCode()) {
                    //当播放本地报错4003的时候，可能是文件地址不对，也有可能是没有权限。
                    //如果是没有权限导致的，就做一个权限的错误提示。其他还是正常提示：
                    int storagePermissionRet = ContextCompat.checkSelfPermission(MajorClassDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (storagePermissionRet != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), getString(R.string.toast_fail_msg) + getString(R.string.toast_no_local_storage_permission), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

//                Toast.makeText(MajorClassDetailActivity.this.getApplicationContext(), getString(R.string.toast_fail_msg) + msg, Toast.LENGTH_SHORT).show();
            }
        });
        aliyunVodPlayer.setOnCompletionListener(new IAliyunVodPlayer.OnCompletionListener() {
            @Override
            public void onCompletion() {
                Log.d(TAG, "onCompletion--- ");
                isCompleted = true;
                inSeek = false;
                showVideoProgressInfo();
                stopUpdateTimer();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                ivPauseVideo.setVisibility(View.GONE);
                ivPlayVideo.setVisibility(View.VISIBLE);
//                    }
//                });

            }
        });
        aliyunVodPlayer.setOnSeekCompleteListener(new IAliyunVodPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete() {
//                logStrs.add(format.format(new Date()) + getString(R.string.log_seek_completed));
                inSeek = false;


            }
        });
        aliyunVodPlayer.setOnStoppedListner(new IAliyunVodPlayer.OnStoppedListener() {
            @Override
            public void onStopped() {
//                logStrs.add(format.format(new Date()) + getString(R.string.log_play_stopped));
                if (replay) {
//                    logStrs.add(format.format(new Date()) + getString(R.string.log_start_get_data));
                    if (mVidSource != null) {
                        aliyunVodPlayer.prepareAsync(mVidSource);
                    } else if (mPlayAuth != null) {
                        aliyunVodPlayer.prepareAsync(mPlayAuth);
                    } else if (mLocalSource != null) {
                        aliyunVodPlayer.prepareAsync(mLocalSource);
                    } else if (mVidSts != null) {
                        aliyunVodPlayer.prepareAsync(mVidSts);
                    }
                    mAutoPlay = true;
                }
                replay = false;
                inSeek = false;

            }
        });

        aliyunVodPlayer.setOnChangeQualityListener(new IAliyunVodPlayer.OnChangeQualityListener() {
            @Override
            public void onChangeQualitySuccess(String finalQuality) {
                Log.d(TAG, "onChangeQualitySuccess");
                inSeek = false;
//                logStrs.add(format.format(new Date()) + getString(R.string.log_change_quality_success));
                showVideoProgressInfo();
            }

            @Override
            public void onChangeQualityFail(int code, String msg) {
                Log.d(TAG, "onChangeQualityFail。。。" + code + " ,  " + msg);
//                logStrs.add(format.format(new Date()) + getString(R.string.log_change_quality_fail));
            }
        });
        aliyunVodPlayer.enableNativeLog();


    }

    private void stopUpdateTimer() {
        progressUpdateTimer.removeMessages(0);
    }

    //    public static boolean sAutoPlay = false;
    public static boolean sAutoPlay = true;


    private Handler progressUpdateTimer = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            showVideoProgressInfo();
        }
    };

//    private void showVideoSizeInfo() {
//        videoWidthTxt.setText(getString(R.string.video_width) + aliyunVodPlayer.getVideoWidth() + " , ");
//        videoHeightTxt.setText(getString(R.string.video_height) + aliyunVodPlayer.getVideoHeight() + "   ");
//    }

    private TextView videoWidthTxt;
    private TextView videoHeightTxt;

    @Override
    protected void onDestroy() {
        aliyunVodPlayer.stop();
        aliyunVodPlayer.release();
        stopUpdateTimer();
        progressUpdateTimer = null;

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();


        //保存播放器的状态，供resume恢复使用。
        resumePlayerState();
    }

    @Override
    public void onStop() {
        super.onStop();
        //onStop中记录下来的状态，在这里恢复使用
        savePlayerState();

    }

    private void resumePlayerState() {
        if (mPlayerState == IAliyunVodPlayer.PlayerState.Paused) {
            aliyunVodPlayer.pause();
        } else if (mPlayerState == IAliyunVodPlayer.PlayerState.Started) {
            aliyunVodPlayer.start();
//            pauseBtn.setText(R.string.pause_button);
//            cbPlayVideo.setChecked(false);
        }
    }

    private void savePlayerState() {
        mPlayerState = aliyunVodPlayer.getPlayerState();
        if (aliyunVodPlayer.isPlaying()) {
            //然后再暂停播放器
            aliyunVodPlayer.pause();
        }
    }

    private void showVideoList() {
        mAdapter = new MajorCourseListAdapter(MajorClassDetailActivity.this, videoListEntityList);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(1000);
        alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
        rvVideoList.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
        rvVideoList.setItemAnimator(new SlideInLeftAnimator());
        rvVideoList.getItemAnimator().setAddDuration(1000);
        rvVideoList.getItemAnimator().setRemoveDuration(1000);
        rvVideoList.getItemAnimator().setMoveDuration(1000);
        rvVideoList.getItemAnimator().setChangeDuration(1000);
        WrapContentLinearLayoutManager lm = new WrapContentLinearLayoutManager(this);
        lm.setOrientation(WrapContentLinearLayoutManager.HORIZONTAL);
        rvVideoList.setLayoutManager(lm);
        mAdapter.setOnItemListener(new MajorCourseListAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int position, List<MajorClassDetailBean.BodyEntity.VideoListEntity> entity) {

                mAdapter.setPosition(position);

                isFree = entity.get(position).getIsFree();
                videoId = entity.get(position).getId();
                videoPrice = entity.get(position).getVideoPrice();
                vid = entity.get(position).getVideoId();
//                if (aliyunVodPlayer != null) {
//                    aliyunVodPlayer.stop();
//                    ivPauseVideo.setVisibility(View.GONE);
//                    ivPlayVideo.setVisibility(View.VISIBLE);
//                }
                if ("1".equals(isFree)) {
                    if (aliyunVodPlayer != null) {
                        aliyunVodPlayer.stop();
                    }
                    ivClassCover.setVisibility(View.GONE);
                    ivPlayVideo.setVisibility(View.GONE);


//                    mPlayerState = aliyunVodPlayer.getPlayerState();
//                    if (mPlayerState == IAliyunVodPlayer.PlayerState.Started) {
//                        aliyunVodPlayer.pause();
////                    pauseBtn.setText(R.string.resume_button);
//                        ivPlayVideo.setVisibility(View.VISIBLE);
//                        ivPauseVideo.setVisibility(View.GONE);
//                    } else if (mPlayerState == IAliyunVodPlayer.PlayerState.Paused) {
//                        aliyunVodPlayer.resume();
////                    pauseBtn.setText(R.string.pause_button);
//                        ivPlayVideo.setVisibility(View.GONE);
//                        ivPauseVideo.setVisibility(View.VISIBLE);
//                    }

//                    pauseBtn();
                    //可以直接播放
                    //1.获取授权token

                    getPlayAuth(videoId);
                    playBtn();
                } else if ("0".equals(isFree)) {
                    ivClassCover.setVisibility(View.VISIBLE);
                    ivPlayVideo.setVisibility(View.VISIBLE);
                    ivPauseVideo.setVisibility(View.GONE);

                    if (aliyunVodPlayer != null) {
                        aliyunVodPlayer.stop();
                    }

                    //要购买
                    intentUtil();
                }
            }
        });
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


    @OnClick({R.id.title_back, R.id.iv_pause_video, R.id.iv_play_video, R.id.iv_get_more, R.id.iv_full_screen, R.id.iv_cancel_full_screen
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
//            case R.id.play:
//                playBtn();
//
//                break;
            case R.id.iv_play_video:
//                Toast.makeText(this, "播放", Toast.LENGTH_SHORT).show();
                //暂停
//                cbAlipay.setChecked(false);
//                cbWechat.setChecked(true);
//                progressbar.setVisibility(View.VISIBLE);
//                if (!StringUtil.isNullOrEmpty(videoId)) {

                if ("1".equals(isFree)) {
                    playBtn();
                    ivClassCover.setVisibility(View.GONE);
//                    progressbar.setVisibility(View.GONE);
                    ivPauseVideo.setVisibility(View.VISIBLE);
                    ivPlayVideo.setVisibility(View.GONE);
                } else if ("0".equals(isFree)) {
                    //要购买
                    intentUtil();
                }


//                } else {
//                    Toast.makeText(MajorClassDetailActivity.this, "请先选择课程集数", Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.iv_pause_video:
//                Toast.makeText(this, "暂停", Toast.LENGTH_SHORT).show();
                //播放
//                cbAlipay.setChecked(true);
//                cbWechat.setChecked(false);
                if (NetworkUtil.isNetWorkConnected(this)) {
                    pauseBtn();
                } else {
                    Toast.makeText(this, "当前无网络连接，请稍候再试", Toast.LENGTH_SHORT).show();
                }

                ivPauseVideo.setVisibility(View.GONE);
                ivPlayVideo.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_get_more:

//                ivGetMore.setVisibility(View.GONE);//把展开按钮隐藏
//                tvRemarks.setMaxLines(Integer.MAX_VALUE);//把TextView行数显示取消掉

                if (isOpen) {
                    isOpen = false;
                    tvRemarks.setEllipsize(null); // 展开
                    tvRemarks.setSingleLine(isOpen);
                    ivGetMore.setImageResource(R.mipmap.ic_down_push);
                } else {
                    isOpen = true;
                    tvRemarks.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                    tvRemarks.setMaxLines(1);
                    ivGetMore.setImageResource(R.mipmap.ic_down_pull);
                }

                break;


            case R.id.iv_full_screen:
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                ssv.setVisibility(View.GONE);
                rootTitle.setVisibility(View.GONE);
                llSsv.setVisibility(View.GONE);
                ViewGroup.LayoutParams lp1 = rlScreen.getLayoutParams();
                lp1.height = screenWidth;
                lp1.width = screenHeight;
                rlScreen.setLayoutParams(lp1);
                ViewTreeObserver vto = rlScreen.getViewTreeObserver();
                vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        rlScreen.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        rlScreen.getHeight();
                        rlScreen.getWidth();
                    }
                });
                SP.put(this, "originalHeight", rlScreen.getHeight() + "");
                rlControl.setVisibility(View.GONE);
                ivCancelFullScreen.setVisibility(View.VISIBLE);
                ivFullScreen.setVisibility(View.INVISIBLE);

                break;
            case R.id.iv_cancel_full_screen:
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                ssv.setVisibility(View.VISIBLE);
                rootTitle.setVisibility(View.VISIBLE);
                llSsv.setVisibility(View.VISIBLE);
                rlControl.setVisibility(View.VISIBLE);


                ViewGroup.LayoutParams lp2 = rlScreen.getLayoutParams();
                lp2.height = Integer.parseInt(String.valueOf(SP.get(this, "originalHeight", "")));
                lp2.width = screenWidth;
                rlScreen.setLayoutParams(lp2);
                ivCancelFullScreen.setVisibility(View.INVISIBLE);
                ivFullScreen.setVisibility(View.VISIBLE);

                break;
            default:
                break;
        }
    }

    private void playBtn() {
//        mPlayerState = aliyunVodPlayer.getPlayerState();
//        if (mPlayerState == Idle || mPlayerState == Stopped || mPlayerState == Completed) {
//            if (mVidSource != null) {
//                aliyunVodPlayer.prepareAsync(mVidSource);
//            } else if (mPlayAuth != null) {
//                aliyunVodPlayer.prepareAsync(mPlayAuth);
//            } else if (mLocalSource != null) {
//                aliyunVodPlayer.prepareAsync(mLocalSource);
//            } else if (mVidSts != null) {
//                aliyunVodPlayer.prepareAsync(mVidSts);
//            }
//            mAutoPlay = true;
//        } else {
//            inSeek = false;
//            aliyunVodPlayer.start();
//
//        }
//        if (mMute) {
//            aliyunVodPlayer.setMuteMode(mMute);
//        }

        mPlayerState = aliyunVodPlayer.getPlayerState();
        if (mPlayerState == Idle || mPlayerState == Stopped ||
                mPlayerState == Completed) {
            if (mVidSource != null) {
                aliyunVodPlayer.prepareAsync(mVidSource);
            } else if (mPlayAuth != null) {
                aliyunVodPlayer.prepareAsync(mPlayAuth);
            } else if (mLocalSource != null) {
                aliyunVodPlayer.prepareAsync(mLocalSource);
            } else if (mVidSts != null) {
                aliyunVodPlayer.prepareAsync(mVidSts);
            }
            mAutoPlay = true;
        } else {
            inSeek = false;
            aliyunVodPlayer.start();
//            pauseBtn.setText(R.string.pause_button);
            ivPauseVideo.setVisibility(View.VISIBLE);
            ivPlayVideo.setVisibility(View.GONE);


        }
        if (mMute) {
            aliyunVodPlayer.setMuteMode(mMute);
        }
//        brightnessBar.setProgress(aliyunVodPlayer.getScreenBrightness());
//        logStrs.add(format.format(new Date()) + getString(R.string.log_strart_play));
//        volumeBar.setProgress(aliyunVodPlayer.getVolume());

    }

    private void showVideoProgressInfo() {
        if ((aliyunVodPlayer.getPlayerState().equals(AliyunVodPlayer.PlayerState.Started)
                || aliyunVodPlayer.getPlayerState().equals(AliyunVodPlayer.PlayerState.Replay) ||
                aliyunVodPlayer.getPlayerState().equals(AliyunVodPlayer.PlayerState.Completed))
                && !inSeek) {
            int curPosition = (int) aliyunVodPlayer.getCurrentPosition();
            positionTxt.setText(Formatter.formatTime(curPosition));
            int duration = (int) aliyunVodPlayer.getDuration();
            durationTxt.setText(Formatter.formatTime(duration));
            Log.d(TAG, "lfj0918 duration = " + duration + " , curPosition = " + curPosition);
            int bufferPosition = aliyunVodPlayer.getBufferingPosition();
            progressBar.setMax(duration);
            progressBar.setSecondaryProgress(bufferPosition);
            progressBar.setProgress(curPosition);
        }

        startUpdateTimer();
    }

    private void startUpdateTimer() {
        Log.d(TAG, "startUpdateTimer--- ");
        progressUpdateTimer.removeMessages(0);
        progressUpdateTimer.sendEmptyMessageDelayed(0, 1000);
    }

    private void changeQuality(Button v) {
        if (aliyunVodPlayer != null &&
                (aliyunVodPlayer.getPlayerState() == IAliyunVodPlayer.PlayerState.Paused
                        || aliyunVodPlayer.getPlayerState() == IAliyunVodPlayer.PlayerState.Started ||
                        aliyunVodPlayer.getPlayerState() == IAliyunVodPlayer.PlayerState.Error)) {
            Button fouces = v;
            fouces.setTextColor(Color.rgb(255, 255, 255));
            fouces.setBackgroundColor(Color.rgb(3, 106, 150));
//            logStrs.add(format.format(new Date()) + getString(R.string.log_change_quality) + fouces.getText());
            //refreshPlaySource();
            aliyunVodPlayer.changeQuality((String) fouces.getTag());
            for (Button otherBtn : qualityIds) {
                if (!otherBtn.equals(fouces)) {
                    otherBtn.setTextColor(Color.rgb(49, 50, 51));
                    otherBtn.setBackgroundColor(getResources().getColor(R.color.alivc_info_text_duration));
                }
            }

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
//            cancelFullScreen();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
