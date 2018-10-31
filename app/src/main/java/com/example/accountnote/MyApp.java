package com.example.accountnote;

import android.app.Application;

import com.example.accountnote.util.SPUtil;
import com.example.accountnote.util.ToastUtil;

/**
 * Created by boys on 2018/10/31.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SPUtil.getInstanse().init(this);
        ToastUtil.init(this);
    }
}
