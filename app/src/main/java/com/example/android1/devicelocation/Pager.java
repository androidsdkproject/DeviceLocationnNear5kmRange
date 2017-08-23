package com.example.android1.devicelocation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;


    public Pager(FragmentManager fm, int tabCount) {
        super(fm);

        this.tabCount = tabCount;
    }


    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                ListFragment tab1 = new ListFragment();
                return tab1;
            case 1:
                MapFragment tab2 = new MapFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "List";
            case 1:
                return "Map";

            default:return null;
        }


    }
}
