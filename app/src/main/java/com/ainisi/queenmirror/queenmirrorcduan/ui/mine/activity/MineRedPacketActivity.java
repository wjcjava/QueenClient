package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MineRedPacketFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 我的红包
 */
public class MineRedPacketActivity extends BaseNewActivity {
    @Bind(R.id.title_back)
    ImageView title_back;
    @Bind(R.id.title_title)
    TextView title_title;
    @Bind(R.id.fr_mine_redpacket)
    FrameLayout fr_mine_redpacket;

    MineRedPacketFragment minediscountFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_red_packet;
    }

    @Override
    protected void initView() {
        super.initView();
        title_title.setText("我的红包");

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        minediscountFragment= new MineRedPacketFragment();
        transaction.add(R.id.fr_mine_redpacket, minediscountFragment);
        transaction.commit();
    }

    @OnClick({R.id.title_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.title_back:
                finish();
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
        fragmentTransaction.replace(R.id.fr_mine_redpacket, fragment, tag);
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
