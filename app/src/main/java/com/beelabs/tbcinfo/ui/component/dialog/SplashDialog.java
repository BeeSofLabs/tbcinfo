package com.beelabs.tbcinfo.ui.component.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.beelabs.tbcinfo.R;
import com.beelabs.tbcinfo.ui.activity.OnboardingActivity;

import app.beelabs.com.codebase.base.BaseDialog;
import butterknife.ButterKnife;

/**
 * Created by arysuryawan on 1/15/18.
 */

public class SplashDialog extends BaseDialog {

    private int progressStatus = 0;
    private Handler handler = new Handler();
    private Activity activity;

    public SplashDialog(@NonNull Activity activity, int style) {
        super(activity, style);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowContentDialogLayout(R.layout.dialog_splash);
        ButterKnife.bind(this);


        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {

                        }
                    });
                    try {
                        // Sleep for 50 milliseconds.
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (progressStatus == 100) {
                    SplashDialog.this.dismiss();
                    Intent intent = new Intent(activity, OnboardingActivity.class);
                    activity.startActivity(intent);
                    activity.finish();

                }
            }
        }).start();
    }
}
