package com.example.sevencat.music_business.view.login.presenter;

import android.util.Log;

import com.example.sevencat.lib_network.listener.DisposeDataListener;
import com.example.sevencat.music_business.api.RequestCenter;
import com.example.sevencat.music_business.model.login.LoginEvent;
import com.example.sevencat.music_business.model.user.User;
import com.example.sevencat.music_business.utils.UserManager;
import com.example.sevencat.music_business.view.login.inter.IUserLoginPresenter;
import com.example.sevencat.music_business.view.login.inter.IUserLoginView;

import org.greenrobot.eventbus.EventBus;

public class UserLoginPresenter implements IUserLoginPresenter, DisposeDataListener {

    private IUserLoginView mIView;

    public UserLoginPresenter(IUserLoginView iView) {
        mIView = iView;
    }

    @Override
    public void onSuccess(Object responseObj) {
        mIView.hideLoadingView();
        User user = (User) responseObj;
        UserManager.getInstance().setUser(user);
        //发送登陆Event
        EventBus.getDefault().post(new LoginEvent());
        mIView.finishActivity();
    }

    @Override
    public void onFailure(Object reasonObj) {
        mIView.hideLoadingView();
//        onSuccess(new Gson().fromJson(MockData.LOGIN_DATA, User.class));
        mIView.showLoginFailedView();
    }

    @Override
    public void login(String username, String password) {
        mIView.showLoadingView();
        RequestCenter.login( this);
    }
}
