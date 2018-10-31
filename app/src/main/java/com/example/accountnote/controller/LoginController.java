package com.example.accountnote.controller;

import android.content.Context;
import android.content.Intent;

import com.example.accountnote.Constanse;
import com.example.accountnote.activity.ForgetPwdActivity;
import com.example.accountnote.activity.MainActivity;
import com.example.accountnote.activity.RegisterActivity;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.model.data.LoginModel;
import com.example.accountnote.util.SPUtil;
import com.example.accountnote.view.LoginView;
import com.google.gson.Gson;

/**
 */

public class LoginController extends BaseController {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(Context context, BaseActivity activity, LoginView loginView) {
        super(context, activity);
        loginModel = new LoginModel(mContext, mActivity);
        this.loginView = loginView;
    }

    /**
     * 登录逻辑
     *
     * @param userAccount
     * @param userPwd
     */
    public void login(final String userAccount, final String userPwd){
        new Thread(){
            @Override
            public void run() {
                super.run();
                final UserBean userBean = loginModel.queryUser(userAccount);
                if (userBean == null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginView.onQueryUserFailed(userBean);
                        }
                    });
                }else{
                    final UserBean userBeanLogin = loginModel.queryUser(userAccount, userPwd);
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (null == userBeanLogin){
                                loginView.onLoginFailed(userBean);
                            }else{
                                loginView.onLoginSucess(userBean);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    /**
     * 跳转到首页
     *
     * @param userBean
     */
    public void toMain(UserBean userBean){
        String userInfo = new Gson().toJson(userBean);
        SPUtil.getInstanse().setParam(Constanse.USER_INFO, userInfo);
        mActivity.startActivity(new Intent(mContext, MainActivity.class));
        mActivity.finish();
    }

    /**
     * 进入注册界面
     *
     */
    public void toRegister(){
        mActivity.startActivity(new Intent(mContext, RegisterActivity.class));
    }


    /**
     * 进入忘记密码的界面
     *
     */
    public void toForgetPwd(){
        mActivity.startActivity(new Intent(mContext, ForgetPwdActivity.class));
    }
}
