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
import com.example.accountnote.controller.ForgetPwdController;
import com.example.accountnote.model.bean.UserBean;
import com.example.accountnote.util.ToastUtil;
import com.example.accountnote.view.ForgetPwdView;

public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener, ForgetPwdView {

    protected ImageView idIvBackTitle;
    protected TextView idTvTitle;
    protected EditText idEtUserName;
    protected EditText idEtUserPwdHelp;
    protected EditText idEtUserNewPwd;
    protected Button idBtnSave;

    private ForgetPwdController forgetPwdController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_forget_pwd);
        initView();
        forgetPwdController = new ForgetPwdController(mContext, mActivity, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_iv_back_title:
                mActivity.finish();
                break;
            case R.id.id_btn_save:

                String userAccount = idEtUserName.getText().toString().trim();
                if (TextUtils.isEmpty(userAccount)) {
                    ToastUtil.showToastShort("用户名不能为空!!!");
                    return;
                }
                String usePwd = idEtUserNewPwd.getText().toString().trim();
                if (TextUtils.isEmpty(usePwd)) {
                    ToastUtil.showToastShort("用户名密码不能为空!!!");
                    return;
                }

                String usePwdHelp = idEtUserPwdHelp.getText().toString().trim();
                if (TextUtils.isEmpty(usePwdHelp)) {
                    ToastUtil.showToastShort("用户名密保不能为空!!!");
                    return;
                }

                forgetPwdController.save(userAccount, usePwd, usePwdHelp);

                break;
        }
    }

    private void initView() {
        idIvBackTitle = findViewById(R.id.id_iv_back_title);
        idIvBackTitle.setOnClickListener(ForgetPwdActivity.this);
        idTvTitle = findViewById(R.id.id_tv_title);
        idEtUserName = findViewById(R.id.id_et_user_name);
        idEtUserPwdHelp = findViewById(R.id.id_et_user_pwd_help);
        idEtUserNewPwd = findViewById(R.id.id_et_user_new_pwd);
        idBtnSave = findViewById(R.id.id_btn_save);
        idBtnSave.setOnClickListener(ForgetPwdActivity.this);

        idTvTitle.setText("找回密码");
    }

    @Override
    public void onUpdateSucess(UserBean userBean) {
        ToastUtil.showToastShort("密码修改成功!!!");
        forgetPwdController.toLogin(userBean);
    }

    @Override
    public void onUpdateFailed(UserBean userBean) {
        ToastUtil.showToastShort("密码修改失败!!!");
    }

    @Override
    public void onQueryFailed(UserBean userBean) {
        ToastUtil.showToastShort("用户名或者密保输入错误!!!");
    }
}
