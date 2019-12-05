package com.example.sevencat.music_business.utils;

import com.example.sevencat.music_business.model.user.User;

/**
 * 单例管理登录用户信息
 */
public class UserManager {

    private static UserManager userManager = null;
    private User user = null;

    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null) {
                    userManager = new UserManager();
                }
                return userManager;
            }
        } else {
            return userManager;
        }
    }

    public void setUser(User user) {
        this.user = user;
        saveLocal(user);
    }

    /**
     * 持久化用户信息
     *
     * @param user
     */
    public void saveLocal(User user) {

    }

    /**
     * 判断是否登录过
     *
     * @return
     */
    public boolean hasLogined() {
        return user == null ? false : true;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public User getUser() {
        return this.user;
    }

    /**
     * 从本地获取
     *
     * @return
     */
    public User getLocal() {
        return null;
    }

    public void removeUser() {
        this.user = null;
        removeLocal();
    }

    public void removeLocal(){

    }

}
