package org.behive.com.workstream_platform;

import android.app.Application;

import org.behive.com.workstream_platform.utils.SharedPrefs;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefs.initialize(this);
    }
}
