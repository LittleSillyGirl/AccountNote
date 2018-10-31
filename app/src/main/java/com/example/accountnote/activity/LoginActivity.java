package com.example.accountnote.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.accountnote.R;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.controller.LoginController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.util.ToastUtil;
import com.example.accountnote.view.LoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    private EditText idEtUserName;
    private EditText idEtUserPwd;
    private TextView idTvForgetPwd;
    private Button idBtnLogin;
    private Button idBtnRegister;
    private LoginController mLoginController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login);
        mLoginController = new LoginController(mContext, mActivity, this);
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_tv_forget_pwd:
                break;
            case R.id.id_btn_login:
                String userAccount = idEtUserName.getText().toString().trim();
                if (TextUtils.isEmpty(userAccount)) {
                    ToastUtil.showToastShort("用户名不能为空!!!");
                    return;
                }
                String usePwd = idEtUserPwd.getText().toString().trim();
                if (TextUtils.isEmpty(usePwd)) {
                    ToastUtil.showToastShort("用户明码不能为空!!!");
                    return;
                }

                mLoginController.login(userAccount, usePwd);

                break;
            case R.id.id_btn_register:
                break;
        }
    }

    private void initView() {
        idEtUserName = findViewById(R.id.id_et_user_name);
        idEtUserPwd = findViewById(R.id.id_et_user_pwd);
        idTvForgetPwd = findViewById(R.id.id_tv_forget_pwd);
        idBtnLogin = findViewById(R.id.id_btn_login);
        idBtnRegister = findViewById(R.id.id_btn_register);
        idTvForgetPwd.setOnClickListener(this);
        idBtnLogin.setOnClickListener(this);
        idBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onLoginSucess(UserBean userBean) {
        mLoginController.toMain(userBean);
    }

    @Override
    public void onLoginFailed(UserBean userBean) {
        ToastUtil.showToastShort("用户名或者密码错误，请重新输入");
        idEtUserName.setText("");
        idEtUserPwd.setText("");
    }

    @Override
    public void onQueryUserSucess(UserBean userBean) {

    }

    @Override
    public void onQueryUserFailed(UserBean userBean) {
        ToastUtil.showToastShort("用户名不存在，请先注册！！！");
        idEtUserName.setText("");
        idEtUserPwd.setText("");
    }
}
