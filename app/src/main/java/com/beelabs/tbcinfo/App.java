package com.beelabs.tbcinfo;

import app.beelabs.com.codebase.base.BaseApp;
import app.beelabs.com.codebase.di.component.AppComponent;
import app.beelabs.com.codebase.di.component.DaggerAppComponent;

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        setupBuilder(DaggerAppComponent.builder(), this);
        setupDefaultFont("fonts/SF-Pro-Display-Black.otf");

    }

    public static AppComponent getAppComponent() {
        return getComponent();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
