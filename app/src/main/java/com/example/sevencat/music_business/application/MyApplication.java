package com.example.sevencat.music_business.application;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.example.sevencat.lib_audio.app.AudioHelper;

public class MyApplication extends Application {

    private static MyApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        MultiDex.install(this);

        AudioHelper.init(this);
    }

    public static MyApplication getInstance(){
        return mApplication;
    }
}
