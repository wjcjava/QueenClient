package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MinediscountFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MinediscountTwoFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的优惠券
 */
public class MineDiscountActivity extends BaseNewActivity {

    private MinediscountFragment minediscountFragment;
    private MinediscountTwoFragment minediscountTwoFragment;
    @Bind(R.id.radio_preferential)
    RadioButton preferential;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_discount;
    }

    @Override
    public void initView() {
        initshowdiscountFragment();
    }

    private void initshowdiscountFragment() {
        preferential.setChecked(true);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        minediscountFragment= new MinediscountFragment();
        transaction.add(R.id.fr_mine_discount, minediscountFragment);
        transaction.commit();
    }

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MineDiscountActivity.class));
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.title_back, R.id.radio_preferential, R.id.radio_invincible})
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.radio_preferential:
                minediscountFragment= new MinediscountFragment();
                replaceFragment(minediscountFragment, "", false);
                break;
            case R.id.radio_invincible:
                minediscountTwoFragment = new MinediscountTwoFragment();
                replaceFragment(minediscountTwoFragment, "", false);
                break;
            default:
                break;
        }
    }

    /**
     * fragment切换
     *
     * @param fragment       需要显示的Fragment
     * @param tag            Tag标签
     * @param addToBackStack 是否加入栈
     */
    public void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fr_mine_discount, fragment, tag);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * 解决重影问题
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
    }
}