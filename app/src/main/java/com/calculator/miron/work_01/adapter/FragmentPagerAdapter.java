package com.calculator.miron.work_01.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.calculator.miron.work_01.model.TabArchive;
import com.calculator.miron.work_01.model.TabFavorites;
import com.calculator.miron.work_01.model.TabInfo;
import com.calculator.miron.work_01.model.TabReminder;
import com.calculator.miron.work_01.model.TabSettings;

/**
 * Created by Miron on 28.09.16.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private String[] mTabTitles;


    public FragmentPagerAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabReminder();
            case 1:
                return new TabFavorites();
            case 2:
                return new TabArchive();
            case 3:
                return new TabSettings();
            case 4:
                return new TabInfo();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
