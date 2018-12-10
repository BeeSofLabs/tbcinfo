package com.beelabs.tbcinfo.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.presenter.manager.SessionManager;
import com.beelabs.tbcinfo.ui.activity.HomeActivity;
import com.beelabs.tbcinfo.ui.activity.SplashActivity;

import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by arysuryawan on 1/15/18.
 */

@SuppressLint("ValidFragment")
public class OnboardingSlideFragment extends Fragment {
    private int pos;
    private Activity activity;
    private ViewPager pager;
    private CircleIndicator indicator;

    public OnboardingSlideFragment(int pos, ViewPager pager, CircleIndicator indicator, Activity activity) {
        this.pos = pos;
        this.pager = pager;
        this.activity = activity;
        this.indicator = indicator;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(getLayoutResourceID(pos), container, false);
        ButterKnife.bind(this, fragmentView);

        if (pos == 2) {
            fragmentView.findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Class clazz = SessionManager.isLogin(activity) ? HomeActivity.class : HomeActivity.class;

                    Intent intent = new Intent(activity, clazz);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    activity.finish();

                }
            });
        }

        return fragmentView;
    }


    private int getLayoutResourceID(int pos) {
        int layoutResourceID = 0;
        switch (pos) {
            case 0:
                layoutResourceID = R.layout.content_onboarding1;
                break;
            case 1:
                layoutResourceID = R.layout.content_onboarding2;
                break;
            case 2:
                layoutResourceID = R.layout.content_onboarding3;
                break;
        }


        return layoutResourceID;
    }

    private void onStartApp() {
        Intent intent = new Intent(activity, HomeActivity.class);
        startActivity(intent);
        activity.finish();
    }

}
