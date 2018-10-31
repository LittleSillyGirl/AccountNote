package com.example.accountnote.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.accountnote.R;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.controller.RegisterController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.util.ToastUtil;
import com.example.accountnote.view.RegisterView;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, RegisterView {

    protected ImageView idIvBackTitle;
    protected TextView idTvTitle;
    protected EditText idEtUserName;
    protected EditText idEtUserPwd;
    protected EditText idEtUserSurePwd;
    protected EditText idEtUserPwdHelp;
    protected Button idBtnRegister;

    private RegisterController registerController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_register);
        initView();
        registerController = new RegisterController(mContext, mActivity, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_iv_back_title:
                mActivity.finish();
                break;
            case R.id.id_btn_register:
                String userAccount = idEtUserName.getText().toString().trim();
                if (TextUtils.isEmpty(userAccount)) {
                    ToastUtil.showToastShort("用户名不能为空!!!");
                    return;
                }
                String usePwd = idEtUserPwd.getText().toString().trim();
                if (TextUtils.isEmpty(usePwd)) {
                    ToastUtil.showToastShort("用户名密码不能为空!!!");
                    return;
                }

                String usePwdSure = idEtUserSurePwd.getText().toString().trim();
                if (TextUtils.isEmpty(usePwdSure)) {
                    ToastUtil.showToastShort("用户名再次密码不能为空!!!");
                    return;
                }

                String usePwdHelp = idEtUserPwdHelp.getText().toString().trim();
                if (TextUtils.isEmpty(usePwdHelp)) {
                    ToastUtil.showToastShort("用户名密保不能为空!!!");
                    return;
                }

                if (!TextUtils.equals(usePwd, usePwdSure)) {
                    ToastUtil.showToastShort("两次密码不一致，请重新输入!!!");
                    idEtUserSurePwd.setText("");
                    return;
                }

                registerController.register(userAccount, usePwd, usePwdHelp);
                break;
        }
    }

    private void initView() {
        idIvBackTitle = findViewById(R.id.id_iv_back_title);
        idTvTitle = findViewById(R.id.id_tv_title);
        idEtUserName = findViewById(R.id.id_et_user_name);
        idEtUserPwd = findViewById(R.id.id_et_user_pwd);
        idEtUserSurePwd = findViewById(R.id.id_et_user_sure_pwd);
        idEtUserPwdHelp = findViewById(R.id.id_et_user_pwd_help);
        idBtnRegister = findViewById(R.id.id_btn_register);

        idTvTitle.setText("注 册");

        idEtUserSurePwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    String usePwd = idEtUserPwd.getText().toString().trim();
                    String usePwdSure = idEtUserSurePwd.getText().toString().trim();

                    if (!TextUtils.equals(usePwd, usePwdSure)) {
                        ToastUtil.showToastShort("两次密码不一致，请重新输入!!!");
                        idEtUserSurePwd.setText("");
                        return;
                    }
                }
            }
        });

        idIvBackTitle.setOnClickListener(RegisterActivity.this);
        idBtnRegister.setOnClickListener(RegisterActivity.this);
    }

    @Override
    public void onQueryUserFailed(UserBean userBean) {
        ToastUtil.showToastShort("该用户已经存在，请重新注册其他用户！！！");


    }

    @Override
    public void onInsertUserOnSucess(UserBean userBean) {
        ToastUtil.showToastShort("恭喜您， 注册成功！！！");
        registerController.toLogin(userBean);
    }

    @Override
    public void onInsertUserOnFailed(UserBean userBean) {
        ToastUtil.showToastShort("注册失败，请再次尝试！！！");
    }
}
