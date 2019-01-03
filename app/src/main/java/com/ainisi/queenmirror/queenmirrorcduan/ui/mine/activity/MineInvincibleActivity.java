package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.content.Context;
import android.content.Intent;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

//无敌劵
public class MineInvincibleActivity extends BaseNewActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_invincible;
    }



    @Override
    public void initView() {

    }

    public static void startActivity(Context context) {
       context.startActivity(new Intent(context,MineInvincibleActivity.class));
    }
}
