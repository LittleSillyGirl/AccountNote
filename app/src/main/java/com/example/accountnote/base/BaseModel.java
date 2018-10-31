package com.example.accountnote.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.accountnote.db.MySqliteHelper;

/**
 */

public abstract class BaseModel {

    protected final String TAG = this.getClass().getSimpleName();

    protected Context mContext;
    protected BaseActivity mActivity;

    protected MySqliteHelper mySqliteHelper;
    protected SQLiteDatabase db;

    public BaseModel(Context context, BaseActivity activity) {
        this.mContext = context;
        this.mActivity = activity;

    }

    public void initDb(){
        mySqliteHelper = new MySqliteHelper(mContext);
        db = mySqliteHelper.getReadableDatabase();
    }


}
