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
//                intent = new Intent(this, TodoListActivity.class);
//                startActivity(intent);
                return true;
            case R.id.nav_calendar:
                drawerLayout.closeDrawers();
                item.setChecked(false);
//                intent = new Intent(this, ProfileActivity.class);
//                startActivity(intent);
                return true;
            case R.id.nav_alarm:
                drawerLayout.closeDrawers();
                item.setChecked(false);
//                intent = new Intent(this, HistoryActivity.class);
//                startActivity(intent);
                return true;
            case R.id.nav_article:
                drawerLayout.closeDrawers();
                item.setChecked(false);
//                intent = new Intent(this, MerchantListActivity.class);
//                startActivity(intent);
                return true;

            case R.id.nav_statistic:
                drawerLayout.closeDrawers();
                item.setChecked(false);

                return true;

            case R.id.nav_notif:
                drawerLayout.closeDrawers();
                item.setChecked(false);

                return true;

            case R.id.nav_biodata:
                drawerLayout.closeDrawers();
                item.setChecked(false);

                return true;
        }
        return false;

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(mNavListener);
    }

    @OnClick(R.id.button_menu)
    public void onDrawerNav(View view){
        drawerLayout.openDrawer(navigationView);
    }
}
