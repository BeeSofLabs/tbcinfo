package com.beelabs.tbcinfo.presenter.manager;

import android.content.Context;

import com.beelabs.tbcinfo.IConfig;

import app.beelabs.com.codebase.support.util.CacheUtil;


/**
 * Created by arysuryawan on 2/6/18.
 */

public class SessionManager {

    public static void putSessionLogin(boolean isLogin, Context context, int provider) {
        CacheUtil.putPreferenceBoolean(IConfig.SESSION_LOGIN_KEY, isLogin, context);
    }

    public static void clearSessionLogin(Context context) {
        CacheUtil.putPreferenceBoolean(IConfig.SESSION_LOGIN_KEY, false, context);
    }

    public static boolean isLogin(Context context) {
        return CacheUtil.getPreferenceBoolean(IConfig.SESSION_LOGIN_KEY, context);
    }

    public static void setNotFirstInstall(boolean value, Context context) {
        CacheUtil.putPreferenceBoolean(IConfig.KEY_FIRST_INSTALL, value, context);
    }

    public static boolean isNotFirstInstall(Context context) {
        return CacheUtil.getPreferenceBoolean(IConfig.KEY_FIRST_INSTALL, context);
    }

    public static boolean putCredential(String token, Context context) {
        if (token != null) {
            CacheUtil.putPreferenceString(IConfig.SESSION_CREDENTIAL_KEY, token, context);
        }
        return false;
    }
}
