package com.example.accountnote.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.accountnote.R;
import com.example.accountnote.adapter.MineDescAdapter;
import com.example.accountnote.base.BaseFragment;
import com.example.accountnote.model.bean.HomeClassfiyBean;
import com.example.accountnote.util.SPUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    protected CircleImageView idCirMine;
    protected TextView idTvUserName;
    protected ImageView idIvMineDivider;
    protected RecyclerView idRvMine;
    protected TextView idTvLoginOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(mContentView);

        String[] descArr = mContext.getResources().getStringArray(R.array.text_mine_desc);
        TypedArray typedArray = mContext.getResources().obtainTypedArray(R.array.int_mine_desc);
        List<HomeClassfiyBean> descList = new ArrayList<>();
        for (int i = 0; i < descArr.length; i++) {
            HomeClassfiyBean homeClassfiyBean = new HomeClassfiyBean();
            homeClassfiyBean.setImgId(typedArray.getResourceId(i, 0));
            homeClassfiyBean.setClassfiyName(descArr[i]);
            descList.add(homeClassfiyBean);
        }
        MineDescAdapter mineDescAdapter = new MineDescAdapter(descList, mContext);
        idRvMine.setLayoutManager(new LinearLayoutManager(mContext));
        idRvMine.setAdapter(mineDescAdapter);
        return mContentView;
    }

    private void initView(View rootView) {
        idCirMine = rootView.findViewById(R.id.id_cir_mine);
        idTvUserName = rootView.findViewById(R.id.id_tv_user_name);
        idIvMineDivider = rootView.findViewById(R.id.id_iv_mine_divider);
        idRvMine = rootView.findViewById(R.id.id_rv_mine);
        idTvLoginOut = rootView.findViewById(R.id.id_tv_login_out);
        idTvLoginOut.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.id_tv_login_out) {
            SPUtil.getInstanse().clear();
            mActivity.finish();
        }
    }
}
