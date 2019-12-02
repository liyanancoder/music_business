package com.example.sevencat.lib_network.response;

import android.os.Handler;
import android.os.Looper;

import com.example.sevencat.lib_network.exception.OkHttpException;
import com.example.sevencat.lib_network.listener.DisposeDataHandle;
import com.example.sevencat.lib_network.listener.DisposeDataListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 处理json类型的响应
 */
public class CommonJsonCallback implements Callback {

    protected final String EMPTY_MSG = "";

    /**
     * 异常
     */
    protected final int NETWORK_ERROR = -1; //网络相关的错误
    protected final int JSON_ERROR = -2; // json相关的错误
    protected final int OTHER_ERROR = -3; // 未知错误

    private DisposeDataListener mListener;

    //需要将json转换的对象
    private Class<?> mClass;

    //将请求回来的数据转换到主线程
    private Handler mDeliveryHandler;

    public CommonJsonCallback(DisposeDataHandle handle) {
        mListener = handle.mListener;
        mClass = handle.mClass;
        mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();

        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }


    private void handleResponse(Object responseObj) {
        if (null == responseObj || responseObj.toString().trim().equals("")) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
            return;
        }

        try {
            /**
             * 协议确定后看这里如何修改
             */
            JSONObject result = new JSONObject(responseObj.toString());
            //不需要解析
            if (mClass == null) {
                mListener.onSuccess(result);
            } else {
                //解析为实体对象，可用gson，fastjson替换
                Object obj = new Gson().fromJson(responseObj.toString(), mClass);
                if (obj != null) {
                    mListener.onSuccess(obj);
                } else {
                    mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
                }
            }
        } catch (Exception e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
            e.printStackTrace();
        }
    }
}
