package com.example.accountnote.activity;

import android.os.Bundle;

import com.example.accountnote.R;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.controller.SpalshController;

public class SpalshActivity extends BaseActivity {

    private SpalshController spalshController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        spalshController = new SpalshController(mContext, mActivity);
        spalshController.toMain();
    }
}
