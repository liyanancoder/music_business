package com.example.sevencat.lib_base;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 音频基本础对外接口
 */
public interface AudioService extends IProvider {
    void pauseAudio();

    void resumeAudio();
}
