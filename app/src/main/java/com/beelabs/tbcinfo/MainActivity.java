package com.beelabs.tbcinfo;

import android.os.Bundle;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}