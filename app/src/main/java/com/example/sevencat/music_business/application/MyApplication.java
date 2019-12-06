package com.example.sevencat.music_business.application;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.example.sevencat.lib_audio.app.AudioHelper;
import com.example.sevencat.lib_share.ShareManager;
import com.example.sevencat.lib_video.app.VideoHelper;

public class MyApplication extends Application {

    private static MyApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        MultiDex.install(this);

        //音频SDK初始化
        AudioHelper.init(this);

        //分享SDK初始化
        ShareManager.initSDK(this);

        //视频SDK初始化
        VideoHelper.init(this);
    }

    public static MyApplication getInstance() {
        return mApplication;
    }
}
