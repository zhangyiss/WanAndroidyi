package com.bier.myapplication.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabLayoutViewPageAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<Fragment>fragmentList;
    private  List <String>titles;
    public TabLayoutViewPageAdapter(FragmentManager fm, Context context,List<Fragment>fragmentList,List<String>titles) {
        super(fm);
        this.mContext=context;
        this.fragmentList=fragmentList;
        this.titles=titles;


    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
