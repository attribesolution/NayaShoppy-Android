package com.attribe.nayashoppy.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Sabih Ahmed on 17-Aug-16.
 */
public class ProductScreenPager extends FragmentPagerAdapter {


    private final ArrayList<Fragment> mFragmentList;
    private final ArrayList<String> mFragmentTitleList;

    public ProductScreenPager(FragmentManager fm, ArrayList<Fragment> fragmentList,
                              ArrayList<String> fragmentTitleList) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mFragmentTitleList= fragmentTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
