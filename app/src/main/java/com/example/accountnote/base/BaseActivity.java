package com.example.accountnote.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected final String TAG = this.getClass().getSimpleName();

    protected ProgressDialog pd;

    protected Context mContext;
    protected BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;

        initPd();
    }

    private void initPd() {
        pd=  new ProgressDialog(mContext);
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
    }

    /**
     * 展示加载圈
     *
     * @param title
     * @param msg
     */
    public void show(String title, String msg){
        Log.i(TAG, "show: ==" + pd.isShowing());
        if (pd != null && !pd.isShowing()) {
            pd.setTitle(title);
            pd.setMessage(msg);
            pd.show();
        }
    }


    /**
     * 隐藏加载全
     *
     */
    public void dismiss(){
        Log.i(TAG, "dismiss: ==" + pd.isShowing());
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

}
