package com.example.sevencat.music_business.view.login.inter;

/**
 * UI层对外提供的方法
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void finishActivity();

    void showLoginFailedView();

    void showLoadingView();

    void hideLoadingView();
}
