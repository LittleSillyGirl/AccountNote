package com.example.accountnote.model.data;

import android.content.ContentValues;
import android.content.Context;

import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseModel;
import com.example.accountnote.db.MySqliteHelper;
import com.example.accountnote.model.bean.UserBean;

/**
 */

public class RegisterModel extends BaseModel {

    public RegisterModel(Context context, BaseActivity activity) {
        super(context, activity);
        initDb();
    }

    /**
     * 添加用户
     *
     *
     * @param userBean
     * @return
     */
    public boolean insertUser(UserBean userBean){
        long insert = -1;
        db.beginTransaction();//事务
        try {
            ContentValues values = new ContentValues();//一个map类型可以放好几对<key,values>
            values.put(MySqliteHelper.KEY_NAME, userBean.getUserAccount());
            values.put(MySqliteHelper.KEY_PWD, userBean.getUserPwd());
            values.put(MySqliteHelper.KEY_PWD_HELP, userBean.getUserPwdHelp());
            insert = db.insert(MySqliteHelper.DATABASE_USER_TABLE, null, values);
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
     * 查询用户是否存在
     *
     * @param userAccpunt
     * @return
     */
    public UserBean queryUser(String userAccpunt){
        LoginModel loginModel = new LoginModel(mContext, mActivity);
        return loginModel.queryUser(userAccpunt);
    }
}
