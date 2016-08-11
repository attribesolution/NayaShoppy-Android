package com.attribe.nayashoppy.app.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.attribe.nayashoppy.app.model.Children;
import com.attribe.nayashoppy.app.util.NavigationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sabih Ahmed on 18-Jul-16.
 */
public class MainScreenPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private final List<String> mFragmentTitleList = new ArrayList<String>();

    public MainScreenPagerAdapter(FragmentManager fm) {
        super(fm);
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

    /**
    public void addFrag(Fragment fragment, String fragmentTitle, @NonNull ArrayList<Children> children) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(NavigationUtils.CHILD_MENU,children);
        fragment.setArguments(bundle);
        mFragmentList.add(fragment);
        mFragmentTitleList.add(fragmentTitle);

    }**/

    public void addFrag(Fragment fragment, String fragmentTitle,Bundle bundle) {
        //Bundle bundle = new Bundle();
        //bundle.putSerializable(NavigationUtils.CHILD_MENU,children);
        fragment.setArguments(bundle);
        mFragmentList.add(fragment);
        mFragmentTitleList.add(fragmentTitle);

    }
}
