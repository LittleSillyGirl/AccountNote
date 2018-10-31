package com.example.accountnote.base;

import android.content.Context;

/**
 * Created by boys on 2018/10/31.
 */

public abstract class BaseController {

    protected Context mContext;
    protected BaseActivity mActivity;

    public BaseController(Context context, BaseActivity activity) {
        this.mContext = context;
        this.mActivity = activity;
    }
}
