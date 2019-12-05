package com.example.sevencat.music_business.api;

import android.util.Log;

import com.example.sevencat.lib_network.CommonOkHttpClient;
import com.example.sevencat.lib_network.listener.DisposeDataHandle;
import com.example.sevencat.lib_network.listener.DisposeDataListener;
import com.example.sevencat.lib_network.request.CommonRequest;
import com.example.sevencat.lib_network.request.RequestParams;
import com.example.sevencat.music_business.model.discory.BaseRecommandModel;
import com.example.sevencat.music_business.model.discory.BaseRecommandMoreModel;
import com.example.sevencat.music_business.model.friend.BaseFriendModel;
import com.example.sevencat.music_business.model.user.User;

/**
 * 请求中心
 */
public class RequestCenter {

    static class HttpConstants {
//        private static final String ROOT_URL = "http://imooc.com/api";
        private static final String ROOT_URL = "http://39.97.122.129";

        /**
         * 首页请求接口
         */
        private static String HOME_RECOMMAND = ROOT_URL + "/module_voice/home_recommand";

        private static String HOME_RECOMMAND_MORE = ROOT_URL + "/module_voice/home_recommand_more";

        private static String HOME_FRIEND = ROOT_URL + "/module_voice/home_friend";

        /**
         * 登陆接口
         */
        public static String LOGIN = ROOT_URL + "/module_voice/login_phone";
    }

    //根据参数发送所有的post请求
    public static void getRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    public static void requestRecommandData(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_RECOMMAND, null, listener, BaseRecommandModel.class);
    }

    public static void requestRecommandMore(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_RECOMMAND_MORE, null, listener, BaseRecommandMoreModel.class);
    }

    public static void requestFriendData(DisposeDataListener listener) {
        RequestCenter.getRequest(HttpConstants.HOME_FRIEND, null, listener, BaseFriendModel.class);
    }

    /**
     * 用户登录请求
     *
     * @param listener
     */
    public static void login(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("mb", "18734924592");
        params.put("pwd", "999999q");
        RequestCenter.getRequest(HttpConstants.LOGIN, params, listener, User.class);
    }
}
