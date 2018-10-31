package com.example.accountnote.controller;

import android.content.Context;
import android.content.Intent;

import com.example.accountnote.activity.LoginActivity;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.model.data.RegisterModel;
import com.example.accountnote.view.RegisterView;

/**
 */

public class RegisterController extends BaseController {

    private RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterController(Context context, BaseActivity activity, RegisterView registerView) {
        super(context, activity);
        registerModel = new RegisterModel(mContext, mActivity);
        this.registerView = registerView;
    }

    public void register(final String userAccount, final String userPwd, final String userPwdHelp) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final UserBean userBean = registerModel.queryUser(userAccount);
                if (userBean != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            registerView.onQueryUserFailed(userBean);
                        }
                    });

                } else {
                    final UserBean userBeanInsert = new UserBean();
                    userBeanInsert.setUserAccount(userAccount);
                    userBeanInsert.setUserPwd(userPwd);
                    userBeanInsert.setUserPwdHelp(userPwdHelp);
                    final boolean isSucess = registerModel.insertUser(userBeanInsert);
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (isSucess) {
                                registerView.onInsertUserOnSucess(userBeanInsert);
                            } else {
                                registerView.onInsertUserOnFailed(userBeanInsert);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void toLogin(UserBean userBean) {
        mActivity.startActivity(new Intent(mContext, LoginActivity.class));
        mActivity.finish();
    }

}
