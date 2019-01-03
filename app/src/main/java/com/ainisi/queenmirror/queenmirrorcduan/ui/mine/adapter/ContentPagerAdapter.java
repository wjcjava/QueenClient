package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.BuyRecordFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.MyCourseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment.WatchRecordFragment;

import java.util.HashMap;

/**
 * Created by jiangchao on 2018/9/10 下午4:03.
 */


public class ContentPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "ContentPagerAdapter";
    private int num;
    private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();

    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ContentPagerAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {

        return createFragment(position);
    }

    @Override
    public int getCount() {
        return num;
    }

    private Fragment createFragment(int pos) {
        Fragment fragment = mFragmentHashMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new MyCourseFragment();
                    Log.i(TAG, "MyCourseFragment");
                    break;
                case 1:
                    fragment = new WatchRecordFragment();
                    Log.i(TAG, "WatchRecordFragment");
                    break;
                case 2:
                    fragment = new BuyRecordFragment();
                    Log.i(TAG, "BuyRecordFragment");
                    break;
                default:
                    break;
            }
            mFragmentHashMap.put(pos, fragment);
        }
        return fragment;
    }
}
