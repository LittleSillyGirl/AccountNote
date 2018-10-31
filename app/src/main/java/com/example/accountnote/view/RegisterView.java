package com.example.accountnote.view;

import com.example.accountnote.model.bean.UserBean;

/**
 */

public interface RegisterView {

    void onQueryUserFailed(UserBean userBean);

    void onInsertUserOnSucess(UserBean userBean);

    void onInsertUserOnFailed(UserBean userBean);
}
