package com.ainisi.queenmirror.queenmirrorcduan.ui.master.activity;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.AccountSettingFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.DynamicManagementFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.master.fragment.FansManagementFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideSimpleLoader;
import com.github.ielse.imagewatcher.ImageWatcher;
import com.github.ielse.imagewatcher.ImageWatcherHelper;
import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Muzik 个人中心
 */
public class BigMasterPersonalCenterActivity extends BaseNewActivity implements HttpCallBack, ImageWatcherHelper.Provider{
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    TextView postitleright;
    @Bind(R.id.profile_image)
    CircleImageView profileImage;
    @Bind(R.id.tv_nick_name)
    TextView tvNickName;
    @Bind(R.id.tv_dynamic_management)
    TextView tvDynamicManagement;
    @Bind(R.id.tv_fans_management)
    TextView tvFansManagement;
    @Bind(R.id.tv_account_setting)
    TextView tvAccountSetting;

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
    private ImageWatcherHelper iwHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_big_master_personal_center;
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {

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


    @Override
    protected void initView() {
        super.initView();
        postitle.setText("我的名字");
        postitle.setTextSize(16);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        setVp();
        setImageLoader();

    }

    @Override
    public void onBackPressed() {
        if (!iwHelper.handleBackPressed()) {
            super.onBackPressed();
        }
    }

    private void setImageLoader() {
        iwHelper = ImageWatcherHelper.with(this, new GlideSimpleLoader())
                .setErrorImageRes(R.mipmap.error_picture)
                .setOnPictureLongPressListener(new ImageWatcher.OnPictureLongPressListener() {
                    @Override
                    public void onPictureLongPress(ImageView imageView, Uri uri, int i) {

                    }
                });// 配置error图标 如果不介意使用lib自带的图标，并不一定要调用这个API;
    }


    private void setVp() {
        mFragments = new ArrayList<>();
        Fragment mTab01 = new DynamicManagementFragment();
        Fragment mTab02 = new FansManagementFragment();
        Fragment mTab03 = new AccountSettingFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        setSelect(0);
    }

    @OnClick({R.id.title_back
            , R.id.tv_dynamic_management, R.id.tv_fans_management, R.id.tv_account_setting
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_dynamic_management:
                setSelect(0);
                break;
            case R.id.tv_fans_management:
                setSelect(1);
                break;
            case R.id.tv_account_setting:
                setSelect(2);
                break;
            default:
                break;
        }
    }


    private void setSelect(int i) {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }

    private void setTab(int i) {
        resetImgs();
        switch (i) {
            case 0:
                tvDynamicManagement.setBackgroundResource(R.drawable.shape_half_label_corner);
                tvDynamicManagement.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.text_pink));
                break;
            case 1:
                tvFansManagement.setBackgroundResource(R.drawable.shape_half_label_corner);
                tvFansManagement.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.text_pink));
                break;
            case 2:
                tvAccountSetting.setBackgroundResource(R.drawable.shape_half_label_corner);
                tvAccountSetting.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.text_pink));
                break;
            default:
                break;
        }
    }

    /**
     * 切换图片至暗色
     */
    private void resetImgs() {
        tvDynamicManagement.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.grey_color1));
        tvFansManagement.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.grey_color1));
        tvAccountSetting.setTextColor(ContextCompat.getColor(BigMasterPersonalCenterActivity.this, R.color.grey_color1));

        tvAccountSetting.setBackgroundResource(R.color.common_bg);
        tvFansManagement.setBackgroundResource(R.color.common_bg);
        tvDynamicManagement.setBackgroundResource(R.color.common_bg);


    }


    @Override
    public ImageWatcherHelper iwHelper() {
        return iwHelper;
    }
}
