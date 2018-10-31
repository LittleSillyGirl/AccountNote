package com.example.accountnote.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.accountnote.R;
import com.example.accountnote.adapter.MainAdapter;
import com.example.accountnote.base.BaseActivity;
import com.example.accountnote.base.BaseFragment;
import com.example.accountnote.fragment.HomeFragment;
import com.example.accountnote.fragment.MineFragment;
import com.example.accountnote.fragment.MyAccountFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    protected ViewPager idVpContentHome;
    protected View idVLine;
    protected TabLayout idTlTabsHome;

    private MainAdapter mMainAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        setTabs();
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MyAccountFragment());
        fragmentList.add(new MineFragment());
        mMainAdapter = new MainAdapter(getSupportFragmentManager(), fragmentList);
        idVpContentHome.setAdapter(mMainAdapter);
        idVpContentHome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(idTlTabsHome));
        idTlTabsHome.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(idVpContentHome));
    }

    /**
     * 设置添加Tab
     */
    private void setTabs() {
        TypedArray typedArray = mContext.getResources().obtainTypedArray(R.array.int_main_tab);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        String[] tabTitles = mContext.getResources().getStringArray(R.array.text_main_tab);
        for (int i = 0; i < tabTitles.length; i++) {
            TabLayout.Tab tab = idTlTabsHome.newTab();
            View view = inflater.inflate(R.layout.item_tab_main, null);
            view.measure(0, 0);
            TextView idTvMainTabItem = view.findViewById(R.id.id_tv_main_tab_item);
            idTvMainTabItem.setText(tabTitles[i]);
            ImageView idIvMainTabItem = view.findViewById(R.id.id_iv_main_tab_item);
            idIvMainTabItem.setImageResource(typedArray.getResourceId(i, 0));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) idTlTabsHome.getLayoutParams();
            Log.d(TAG, "setTabs: view.getHeight()==" + view.getMeasuredHeight());
            layoutParams.height = view.getMeasuredHeight();
            idTlTabsHome.setLayoutParams(layoutParams);
            tab.setCustomView(view);
            idTlTabsHome.addTab(tab);
        }
    }

    private void initView() {
        idVpContentHome = findViewById(R.id.id_vp_content_home);
        idVLine = findViewById(R.id.id_v_line);
        idTlTabsHome = findViewById(R.id.id_tl_tabs_home);
    }
}
