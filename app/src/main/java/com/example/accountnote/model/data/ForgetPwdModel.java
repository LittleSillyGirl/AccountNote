package com.example.accountnote.model.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseModel;
import com.example.accountnote.db.MySqliteHelper;
import com.example.accountnote.model.bean.UserBean;

/**
 */

public class ForgetPwdModel extends BaseModel {

    public ForgetPwdModel(Context context, BaseActivity activity) {
        super(context, activity);
        initDb();
    }

    /**
     * 修改密码
     *
     *
     * @param userBean
     * @return
     */
    public boolean updateUser(UserBean userBean){
        long insert = -1;
        db.beginTransaction();//事务
        try {
            ContentValues values = new ContentValues();//一个map类型可以放好几对<key,values>
            values.put(MySqliteHelper.KEY_PWD, userBean.getUserPwd());
            insert = db.update(MySqliteHelper.DATABASE_USER_TABLE, values, MySqliteHelper.KEY_NAME+"=? and " + MySqliteHelper.KEY_PWD_HELP + "=?",
                    new String[]{userBean.getUserAccount(), userBean.getUserPwdHelp()});
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
        if (insert != -1) {
            return true;
        }
        return false;
    }


    /**
     * 根据用户名和密保查询用户是否存在
     *
     * @param userAccount
     */
    public UserBean queryUser(String userAccount, String userPwdHelp){
        UserBean user = null;
        Cursor cursor = null;
        if (cursor == null) {
            String sql = "select * from " + MySqliteHelper.DATABASE_USER_TABLE + " where " + MySqliteHelper.KEY_NAME + "= ? and " + MySqliteHelper.KEY_PWD_HELP + "=?";
            cursor = db.rawQuery(sql, new String[]{userAccount, userPwdHelp});
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
