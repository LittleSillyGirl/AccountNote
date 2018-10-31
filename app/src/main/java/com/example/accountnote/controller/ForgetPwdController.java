package com.example.accountnote.controller;

import android.content.Context;
import android.content.Intent;

import com.example.accountnote.activity.LoginActivity;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.model.data.ForgetPwdModel;
import com.example.accountnote.view.ForgetPwdView;

/**
 */

public class ForgetPwdController extends BaseController {

    private ForgetPwdModel forgetPwdModel;
    private ForgetPwdView forgetPwdView;

    public ForgetPwdController(Context context, BaseActivity activity, ForgetPwdView forgetPwdView) {
        super(context, activity);
        forgetPwdModel = new ForgetPwdModel(mContext, mActivity);
        this.forgetPwdView = forgetPwdView;
    }

    public void save(final String userAccount, final String userPwd, final String userPwdHelp){

        new Thread() {
            @Override
            public void run() {
                super.run();
                final UserBean userBean = forgetPwdModel.queryUser(userAccount, userPwdHelp);
                if (userBean == null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            forgetPwdView.onQueryFailed(userBean);
                        }
                    });
                } else {
                    final UserBean userBeanInsert = new UserBean();
                    userBeanInsert.setUserAccount(userAccount);
                    userBeanInsert.setUserPwd(userPwd);
                    userBeanInsert.setUserPwdHelp(userPwdHelp);
                    final boolean isSucess = forgetPwdModel.updateUser(userBeanInsert);
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (isSucess) {
                                forgetPwdView.onUpdateSucess(userBeanInsert);
                            } else {
                                forgetPwdView.onUpdateFailed(userBeanInsert);
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
