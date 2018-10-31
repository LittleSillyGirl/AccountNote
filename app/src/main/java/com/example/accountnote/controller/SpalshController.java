package com.example.accountnote.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;

import com.example.accountnote.Constanse;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseController;
import com.example.accountnote.util.SPUtil;
import com.example.accountnote.activity.LoginActivity;
import com.example.accountnote.activity.MainActivity;


/**
 */

public class SpalshController extends BaseController {

    public SpalshController(Context context, BaseActivity activity) {
        super(context, activity);
    }

    /**
     * 登录过之后 下次直接进入系统
     */
    public void toMain() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String userStr = (String) SPUtil.getInstanse().getParam(Constanse.USER_INFO, "");
                if (TextUtils.isEmpty(userStr)) {
                    mActivity.startActivity(new Intent(mContext, LoginActivity.class));
                } else {
                    mActivity.startActivity(new Intent(mContext, MainActivity.class));
                }
                mActivity.finish();
            }
        }, 3000);
    }
}
