package com.example.accountnote.view;

/**
 * Created by boys on 2018/10/31.
 */

public interface OnDataReturnListener<T> {

    /**
     *
     *
     * @param t
     */
    void onSucess(T t);

    void onFailed(T t);


}
