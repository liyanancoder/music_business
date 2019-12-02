package com.example.sevencat.lib_network.listener;

/**
 * 业务逻辑层真正处理的地方，包括Java层异常和业务层异常
 */
public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     *
     * @param responseObj
     */
    void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     *
     * @param reasonObj
     */
    void onFailure(Object reasonObj);
}
