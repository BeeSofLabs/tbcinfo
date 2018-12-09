package com.beelabs.tbcinfo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.beelabs.tbcinfo.R;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.pager_jadwal)
    ViewPager pagerJadwal;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    private NavigationView.OnNavigationItemSelectedListener mNavListener = item -> {
        Intent intent;

        switch (item.getItemId()) {

            case R.id.nav_dashboard:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                return true;
            case R.id.nav_calendar:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, CalendarScheduleActivity.class);
                startActivity(intent);

                return true;
            case R.id.nav_alarm:
                intent = new Intent(this, ReminderAlarmActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                item.setChecked(false);

                return true;
            case R.id.nav_article:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, ArticleActivity.class);
                startActivity(intent);

                return true;
            case R.id.nav_statistic:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, StatisticActivity.class);
                startActivity(intent);
                return true;

            case R.id.nav_notif:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, NotifActivity.class);
                startActivity(intent);
                return true;

            case R.id.nav_biodata:
                drawerLayout.closeDrawers();
                item.setChecked(false);
                intent = new Intent(this, BiodataActivity.class);
                startActivity(intent);
                return true;
        }
        return false;

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(mNavListener);
    }

    @OnClick(R.id.button_menu)
    public void onDrawerNav(View view) {
        drawerLayout.openDrawer(navigationView);
    }

    @OnClick(R.id.button_calendar)
    public void onCalendarView(View view) {
        Intent intent = new Intent(this, CalendarScheduleActivity.class);
        startActivity(intent);
    }
}
