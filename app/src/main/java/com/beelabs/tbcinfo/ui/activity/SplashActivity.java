package com.beelabs.tbcinfo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.ui.component.dialog.SplashDialog;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        SplashDialog dialog = new SplashDialog(this, R.style.CoconutDialogFullScreen);
        dialog.show();
    }
}
