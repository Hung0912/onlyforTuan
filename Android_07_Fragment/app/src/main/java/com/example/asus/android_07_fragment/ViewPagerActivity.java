package com.example.asus.android_07_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements QuestionFragment.OnSendResult,View.OnClickListener, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<QuestionFragment> mFragment;
    private Button mButtonNext;
    private Button mButtonBack;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_question);
        mButtonBack = (Button) findViewById(R.id.button_back);
        mButtonNext = (Button) findViewById(R.id.button_next);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mButtonBack.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
        mFragment = new ArrayList<>();
        for(int i = 0; i<2; i++) mFragment.add(QuestionFragment.newInstance(i));
        mAdapter = new PagerAdapter(getSupportFragmentManager(), mFragment);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(this);
        mTabLayout.setupWithViewPager(mViewPager);
       for (int i = 0; i<mTabLayout.getTabCount(); i++) mTabLayout.getTabAt(i).setIcon(R.mipmap.ic_launcher);
        mTabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void sendResult(int Result) {

    }

    @Override
    public void onClick(View view) {
        int currentPos = mViewPager.getCurrentItem();
        switch (view.getId()) {
            case R.id.button_back:
                currentPos--;
                mViewPager.setCurrentItem(currentPos);
                break;
            case R.id.button_next:
                currentPos++;
                mViewPager.setCurrentItem(currentPos);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            mButtonBack.setVisibility(View.GONE);
            mButtonNext.setVisibility(View.VISIBLE);
        }
        else if (position == mAdapter.getCount() - 1) {
            mButtonNext.setVisibility(View.GONE);
            mButtonBack.setVisibility(View.VISIBLE);
        }
        else {
            mButtonBack.setVisibility(View.VISIBLE);
            mButtonNext.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.setIcon(R.mipmap.ic_launcher_round);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
