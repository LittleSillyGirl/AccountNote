package com.example.accountnote.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * 上下文生命周期
     */
    protected BaseFragment mFragment;
    protected BaseActivity mActivity;
    protected Context mContext;

    protected View mContentView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragment = this;
        mActivity = (BaseActivity) mFragment.getActivity();
        mContext = context;
    }


}
