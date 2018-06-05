package com.m00061016.gamenews.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterGames extends FragmentPagerAdapter {

    private final List<Fragment> lstfragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    public ViewPagerAdapterGames(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstfragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int pos){ return lstTitles.get(pos);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    public void AddFragment(Fragment fragment, String title){
        lstfragment.add(fragment);
        lstTitles.add(title);
    }

}
