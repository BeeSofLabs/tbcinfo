package com.beelabs.tbcinfo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.beelabs.tbcinfo.R;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.ButterKnife;

public class NotifActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);
        ButterKnife.bind(this);
    }
}
