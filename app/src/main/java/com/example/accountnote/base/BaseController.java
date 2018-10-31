package com.example.accountnote.base;

import android.content.Context;

/**
 */

public abstract class BaseController {

    protected Context mContext;
    protected BaseActivity mActivity;

    public BaseController(Context context, BaseActivity activity) {
        this.mContext = context;
        this.mActivity = activity;
    }
}
