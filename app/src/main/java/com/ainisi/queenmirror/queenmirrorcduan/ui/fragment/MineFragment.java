package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MineQiandaoBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SuccessBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.AboutUsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.BigClassroomActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.BigClassroomTabActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineBeanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineBeautyActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineCollectionActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineDiscountActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineEvaluateActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineFollowActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineGiftActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineMyWalletActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineProblemActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineQueenCardActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineRedPacketActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.PortraitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by EWorld on 2018/3/6.
 * 我的
 */

public class MineFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.tv_mine_uername)
    TextView tv_mine_uername;
    @Bind(R.id.tv_mine_modou)
    TextView tv_mine_modou;
    @Bind(R.id.iv_mine_title)
    CircleImageView iv_mine_title;
    @Bind(R.id.layout_about_us)
    LinearLayout layout_about_us;
    @Bind(R.id.tv_mine_qiandao_not)
    RelativeLayout tv_mine_qiandao_not;
    @Bind(R.id.tv_mine_qiandao)
    TextView tv_mine_qiandao;
    boolean isLogin = false;
    private String service_tel = "4000885115", head_pic = "";
    int moDou = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SP.get(getActivity(), SpContent.isLogin, "").toString().equals("1")) {
            isLogin = true;
            tv_mine_uername.setText(SP.get(getActivity(), SpContent.UserName, "") + "\n\n个人信息>>");
            head_pic = SP.get(getActivity(), SpContent.userHeadPic, "") + "";
            Glide.with(getActivity()).load(head_pic).dontAnimate().placeholder(R.drawable.dismiss).into(iv_mine_title);
            getMineModouData();

            getQianDaoDataStatus();
        } else {
            isLogin = false;
            tv_mine_uername.setText("点击登录");

            tv_mine_qiandao_not.setVisibility(View.VISIBLE);
            tv_mine_qiandao.setVisibility(View.GONE);
        }
    }

    @Override
    protected void doFitsrData() {

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    /**
     * 签到状态
     */
    private void getQianDaoDataStatus() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.QIANDAODAYSTATUS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 签到
     */
    private void getQianDaoData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.QIANDAODAY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取我的魔豆数据
     */
    private void getMineModouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("token", SP.get(getActivity(), SpContent.UserToken, "") + "");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initView() {
    }

    @OnClick({R.id.iv_mine_title, R.id.layout_collection, R.id.layout_follow,
            R.id.layout_evaluate, R.id.ly_mine_discount, R.id.ly_mine_foot, R.id.ly_mine_bean,
            R.id.layout_gift, R.id.layout_beauty, R.id.li_mine_redbag,
            R.id.layout_problem, R.id.lay_service, R.id.ly_mine_wallet, R.id.tv_mine_uername, R.id.layout_about_us, R.id.tv_mine_qiandao_not,
            R.id.li_mine_pintuan, R.id.li_mine_renzheng, R.id.layout_big_classroom, R.id.layout_big_classroom_tab})
    public void click(View view) {
        switch (view.getId()) {
            /**
             * 点击红包
             */
            case R.id.li_mine_redbag:
                startActivity(new Intent(getContext(), MineRedPacketActivity.class));
                break;
            case R.id.li_mine_renzheng:
                T.show("开发准备中，敬请期待...");
//                MineAuthenticationActivity.startActivity(getActivity());
                break;
            /**
             * 拼团
             */
            case R.id.li_mine_pintuan:
                startActivity(new Intent(getContext(), HomeFightaloneActivity.class));
                break;
            /**
             * 签到
             */
            case R.id.tv_mine_qiandao_not:
                if (isLogin) {
                    getQianDaoData();
                } else {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            case R.id.layout_about_us:
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                break;
            case R.id.tv_mine_uername:
                if (isLogin) {
                    startActivity(new Intent(getContext(), PortraitActivity.class));
                } else {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //更改头像和个人信息
            case R.id.iv_mine_title:
                //PortraitActivity.startActivity(getActivity());
                if (isLogin) {
                    startActivity(new Intent(getContext(), PortraitActivity.class));
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //我的收藏
            case R.id.layout_collection:
                if (isLogin) {
                    MineCollectionActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //关注店铺
            case R.id.layout_follow:
                if (isLogin) {
                    MineFollowActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //评价
            case R.id.layout_evaluate:
                if (isLogin) {
                    MineEvaluateActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //优惠券
            case R.id.ly_mine_discount:
                if (isLogin) {
                    MineDiscountActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //我的资产（女王卡）
            case R.id.ly_mine_foot:
                if (isLogin) {

                    Intent intent = new Intent(getActivity(), MineQueenCardActivity.class);
                    startActivity(intent);
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //我的钱包
            case R.id.ly_mine_wallet:
                if (isLogin) {

                    MineMyWalletActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //我的魔豆
            case R.id.ly_mine_bean:
                if (isLogin) {
                    MineBeanActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //邀请有奖
            case R.id.layout_gift:
                if (isLogin) {
                    MineGiftActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //成为美业人
            case R.id.layout_beauty:
                if (isLogin) {
                    MineBeautyActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("activite", "no");
                    startActivity(intent);
                }
                break;
            //帮助与反馈
            case R.id.layout_problem:
                getActivity().startActivity(new Intent(getActivity(), MineProblemActivity.class));
                break;
            //客服
            case R.id.lay_service:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + service_tel);
                intent.setData(data);
                startActivity(intent);
                break;
            case R.id.layout_big_classroom:
                getActivity().startActivity(new Intent(getActivity(), BigClassroomActivity.class));
                break;
            case R.id.layout_big_classroom_tab:
                getActivity().startActivity(new Intent(getActivity(), BigClassroomTabActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETMINEMODOU:
                MoDouBean moDouBean = GsonUtil.toObj(res, MoDouBean.class);
                if (moDouBean.isSuccess()) {
                    moDou = moDouBean.getBody().getMap().getPointsNow();
                    tv_mine_modou.setText("魔豆记录");
                } else {
                    T.show(moDouBean.getMsg());
                }
                break;
            /**
             * 签到
             */
            case ACTION.QIANDAODAY:
                SuccessBean successBean = GsonUtil.toObj(res, SuccessBean.class);
                if (successBean.getErrorCode().equals("0")) {
                    tv_mine_qiandao_not.setVisibility(View.GONE);
                    tv_mine_qiandao.setVisibility(View.VISIBLE);
                } else {
                    T.show(successBean.getMsg());
                }
                break;
            /**
             * 签到状态
             */
            case ACTION.QIANDAODAYSTATUS:
                MineQiandaoBean mineQiandaoBean = GsonUtil.toObj(res, MineQiandaoBean.class);
                if (mineQiandaoBean.getErrorCode().equals("0")) {
                    if (mineQiandaoBean.getBody().getIsSignin().equals("not")) {
                        tv_mine_qiandao_not.setVisibility(View.VISIBLE);
                        tv_mine_qiandao.setVisibility(View.GONE);

                    } else {
                        tv_mine_qiandao_not.setVisibility(View.GONE);
                        tv_mine_qiandao.setVisibility(View.VISIBLE);
                    }
                } else {
                    T.show(mineQiandaoBean.getMsg());
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

