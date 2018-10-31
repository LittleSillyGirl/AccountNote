package com.example.accountnote.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.accountnote.R;
import com.example.accountnote.model.bean.HomeClassfiyBean;

import java.util.List;


/**
 */

public class MineDescAdapter extends RecyclerView.Adapter<MineDescAdapter.MineDescViewHolder> {

    private static final String TAG = "HomeClassfiyAdapter";

    private List<HomeClassfiyBean> mDatas;
    private Context mContext;

    public MineDescAdapter(List<HomeClassfiyBean> datas, Context context) {
        this.mDatas = datas;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MineDescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MineDescViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recylcerview_mine_desc, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MineDescViewHolder holder, int position) {
        HomeClassfiyBean homeClassfiyBean = mDatas.get(position);
        Log.e(TAG, "onBindViewHolder: homeClassfiyBean==" + homeClassfiyBean.toString());
        holder.idTvItemNameMine.setText(homeClassfiyBean.getClassfiyName());
        holder.idIvItemIconLeft.setImageResource(homeClassfiyBean.getImgId());
    }


    public class MineDescViewHolder extends RecyclerView.ViewHolder {

        ImageView idIvItemIconLeft;
        TextView idTvItemNameMine;
        ImageView idIvItemIconMine;
        LinearLayout idClItemMine;

        public MineDescViewHolder(View itemView) {
            super(itemView);
            idIvItemIconLeft = itemView.findViewById(R.id.id_iv_item_icon_left);
            idTvItemNameMine = itemView.findViewById(R.id.id_tv_item_name_mine);
            idIvItemIconMine = itemView.findViewById(R.id.id_iv_item_icon_mine);
            idClItemMine = itemView.findViewById(R.id.id_cl_item_mine);
        }
    }
}
