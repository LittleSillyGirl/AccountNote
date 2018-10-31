package com.example.accountnote.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boys on 2018/10/31.
 */

public class MySqliteHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySqliteHelper";

    private List<String> tables;

    /**
     * 表的名字
     */
    public static final String DATABASE_USER_TABLE = "tb_user";

    /**
     * 表的行名称 用户的id、名称、密保、
     */
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "userAccount";
    public static final String KEY_PWD = "userPwd";
    public static final String KEY_PWD_HELP = "userPwdHelp";
    
    public MySqliteHelper(Context context) {
        super(context, "accout_db", null, 1);
        tables = new ArrayList<>();
        String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + DATABASE_USER_TABLE + " ("+ KEY_ID +" integer primary key autoincrement, " +
                KEY_NAME + " text not null, " + KEY_PWD + " text not null, " + KEY_PWD_HELP + " text not null);";
        tables.add(CREATE_USER_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String tableSql : tables) {
            Log.i(TAG, "Creating DataBase: " + tableSql);
            db.execSQL(tableSql);
        }
    }
    
    

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
