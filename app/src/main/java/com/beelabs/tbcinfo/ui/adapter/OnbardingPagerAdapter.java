package com.beelabs.tbcinfo.ui.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.beelabs.tbcinfo.ui.fragment.OnboardingSlideFragment;

import me.relex.circleindicator.CircleIndicator;


/**
 * Created by arysuryawan on 1/15/18.
 */

public class OnbardingPagerAdapter extends FragmentStatePagerAdapter {
    private ViewPager pager;
    private Activity activity;
    private CircleIndicator indicator;

    public OnbardingPagerAdapter(FragmentManager fm, ViewPager pager, CircleIndicator indicator, Activity activity) {
        super(fm);
        this.pager = pager;
        this.activity = activity;
        this.indicator = indicator;
    }

    @Override
    public Fragment getItem(int position) {
        return new OnboardingSlideFragment(position, pager, indicator, activity);
    }


    @Override
    public int getCount() {
        return 3;
    }
}
