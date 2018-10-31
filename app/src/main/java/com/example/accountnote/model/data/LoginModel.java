package com.example.accountnote.model.data;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseModel;
import com.example.accountnote.db.MySqliteHelper;
import com.example.accountnote.model.bean.UserBean;


/**
 * Created by boys on 2018/10/31.
 */

public class LoginModel extends BaseModel {
    public LoginModel(Context context, BaseActivity activity) {
        super(context, activity);
        initDb();
    }

    /**
     * 根据用户名和密码查询用户是否存在
     *
     * @param userAccount
     * @param userPwd
     */
    public UserBean queryUser(String userAccount, String userPwd){
        UserBean user = null;
        Cursor cursor = null;
        if (cursor == null) {
            String sql = "select * from " + MySqliteHelper.DATABASE_USER_TABLE + " where " + MySqliteHelper.KEY_NAME + "= ? and " + MySqliteHelper.KEY_PWD + " = ?";
            cursor = db.rawQuery(sql, new String[]{userAccount, userPwd});
        }
        if (cursor != null) {
            if (cursor.moveToNext()){
                user = new UserBean();
                user.setUserId(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.KEY_ID)));
                user.setUserAccount(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_NAME)));
                user.setUserPwd(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_PWD)));
                user.setUserPwdHelp(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_PWD_HELP)));
                Log.e(TAG, "queryUser: " + user.toString() );
            }
            cursor.close();
        }
        return user;
    }

    /**
     * 根据用户名查询用户是否存在
     *
     * @param userAccount
     */
    public UserBean queryUser(String userAccount){
        UserBean user = null;
        Cursor cursor = null;
        if (cursor == null) {
            String sql = "select * from " + MySqliteHelper.DATABASE_USER_TABLE + " where " + MySqliteHelper.KEY_NAME + "= ? ";
            cursor = db.rawQuery(sql, new String[]{userAccount});
        }
        if (cursor != null) {
            if (cursor.moveToNext()){
                user = new UserBean();
                user.setUserId(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.KEY_ID)));
                user.setUserAccount(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_NAME)));
                user.setUserPwd(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_PWD)));
                user.setUserPwdHelp(cursor.getString(cursor.getColumnIndex(MySqliteHelper.KEY_PWD_HELP)));
                Log.e(TAG, "queryUser: " + user.toString() );
            }
            cursor.close();
        }
        return user;
    }
}
