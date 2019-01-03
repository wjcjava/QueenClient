package com.ainisi.queenmirror.queenmirrorcduan.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/3/22.
 */

public class ViewPager extends FragmentPagerAdapter{
    List<Fragment> fllist;
    List<String> list;

    public ViewPager(FragmentManager fm,List<Fragment> fllist, List<String> list) {
        super(fm);
        this.fllist=fllist;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return fllist.get(position);
    }

    @Override
    public int getCount() {
        return fllist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }


}
