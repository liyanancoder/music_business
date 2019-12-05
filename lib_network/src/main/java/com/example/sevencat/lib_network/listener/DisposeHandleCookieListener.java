package com.example.sevencat.lib_network.listener;

import java.util.ArrayList;

/**
 * 当需要专门处理cookie时创建此回调接口
 */
public interface DisposeHandleCookieListener extends DisposeDataListener {

    public void onCookie(ArrayList<String> cookieStrLists);
}
