package com.vumobile.vmate.dynamicpager.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by toukirul on 10/1/2018.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<String> fragments;
    private Fragment fragment;

    public MyPagerAdapter(FragmentManager fm, List<String> l) {
        super(fm);
        this.fragments = l;
    }

    @Override
    public Fragment getItem(int position) {
        fragment = new FragmentLatest();
        Bundle bundle = new Bundle();
        bundle.putString("key",fragments.get(position));
        fragment.setArguments(bundle);
        Log.d("FragmentListe",String.valueOf(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position);
    }
}
