package com.beelabs.tbcinfo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.presenter.manager.SessionManager;
import com.beelabs.tbcinfo.ui.adapter.OnbardingPagerAdapter;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by ary on 23/03/18.
 */

public class OnboardingActivity extends BaseActivity {
    @BindView(R.id.pager_onboarding)
    ViewPager pagerOnboarding;
    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        ButterKnife.bind(this);

        SessionManager.setNotFirstInstall(true, this);

        pagerOnboarding.setAdapter(new OnbardingPagerAdapter(getSupportFragmentManager(), pagerOnboarding, circleIndicator, this));
        circleIndicator.setViewPager(pagerOnboarding);

    }
}
