package com.example.accountnote.model.bean;

/**
 * Created by boys on 2018/10/31.
 */

public class UserBean {

    private String userAccount;
    private String userPwd;
    private String userPwdHelp;
    private int userId;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPwdHelp() {
        return userPwdHelp;
    }

    public void setUserPwdHelp(String userPwdHelp) {
        this.userPwdHelp = userPwdHelp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userAccount='" + userAccount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPwdHelp='" + userPwdHelp + '\'' +
                ", userId=" + userId +
                '}';
    }
}
