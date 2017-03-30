package com.example.asus.android_07_fragment;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by asus on 3/28/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private List<QuestionFragment> mFragments;

    public PagerAdapter(FragmentManager fm, List<QuestionFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //Trả về fragment tại vị trí position
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        //Trả về số lượng fragment có trong viewpager
        if (mFragments != null)
            return mFragments.size();
        else return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "position "+ position;
    }
}
