package com.example.accountnote.view;

import com.example.accountnote.model.bean.UserBean;

/**
 */

public interface ForgetPwdView {

    void onUpdateSucess(UserBean userBean);


    void onUpdateFailed(UserBean userBean);

    void onQueryFailed(UserBean userBean);
}
