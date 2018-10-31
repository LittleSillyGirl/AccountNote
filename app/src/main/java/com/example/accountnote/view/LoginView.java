package com.example.accountnote.view;

import com.example.accountnote.model.bean.UserBean;

/**
 */

public interface LoginView {

    /**
     * 用户登录成功
     *
     * @param userBean
     */
    void onLoginSucess(UserBean userBean);


    /**
     * 用户登录失败
     * @param userBean
     */
    void onLoginFailed(UserBean userBean);


    /**
     * 用户查询成功
     *
     * @param userBean
     */
    void onQueryUserSucess(UserBean userBean);

    /**
     * 用户查询失败
     * @param userBean
     */
    void onQueryUserFailed(UserBean userBean);
}
