package com.zuoyu.yuanlsn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.zuoyu.yuanlsn.base.BaseActivity;
import com.zuoyu.yuanlsn.fragment.HomeFragment;
import com.zuoyu.yuanlsn.fragment.MineFragment;
import com.zuoyu.yuanlsn.widget.TabStateLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    TabStateLayout homeTab, classTab, downloadTab, collectionTab, mineTab;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private ArrayList<TabStateLayout> mTabList = new ArrayList<>();
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
        setTabChecked(homeTab);
    }

    @Override
    public void initTitle() {

    }


    @Override
    public void initView() {

//        ViewPager
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

//        Tab首页
        homeTab = (TabStateLayout) findViewById(R.id.tab_home);
        homeTab.setText(getString(R.string.home));
        homeTab.setIcon(R.mipmap.tab_home_checked, R.mipmap.tab_home_unchecked);
        homeTab.setOnClickListener(this);


//        Tab课程
        classTab = (TabStateLayout) findViewById(R.id.tab_class);
        classTab.setText(getString(R.string.clazz));
        classTab.setIcon(R.mipmap.tab_class_checked, R.mipmap.tab_class_unchecked);
        classTab.setOnClickListener(this);


//        Tab下载
        downloadTab = (TabStateLayout) findViewById(R.id.tab_download);
        downloadTab.setText(getString(R.string.download));
        downloadTab.setIcon(R.mipmap.tab_download_checked, R.mipmap.tab_download_unchecked);
        downloadTab.setOnClickListener(this);


//        Tab收藏
        collectionTab = (TabStateLayout) findViewById(R.id.tab_collection);
        collectionTab.setText(getString(R.string.collection));
        collectionTab.setIcon(R.mipmap.tab_collection_checked, R.mipmap.tab_collection_unchecked);
        collectionTab.setOnClickListener(this);


//        Tab个人
        mineTab = (TabStateLayout) findViewById(R.id.tab_mine);
        mineTab.setText(getString(R.string.mine));
        mineTab.setIcon(R.mipmap.tab_mine_checked, R.mipmap.tab_mine_unchecked);
        mineTab.setOnClickListener(this);


    }

    @Override
    protected void initStatusBar() {
        StatusBarUtil.setTransparent(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text:
                loadingProgress.show();
                break;
            case R.id.tab_home:
                setTabChecked(homeTab);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tab_class:
                setTabChecked(classTab);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.tab_download:
                setTabChecked(downloadTab);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.tab_collection:
                setTabChecked(collectionTab);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.tab_mine:
                setTabChecked(mineTab);
                mViewPager.setCurrentItem(4);
                break;
        }

    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {

        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new MineFragment());
        mFragmentList.add(new MineFragment());
        mFragmentList.add(new MineFragment());
        mFragmentList.add(new MineFragment());

        mTabList.add(homeTab);
        mTabList.add(classTab);
        mTabList.add(downloadTab);
        mTabList.add(collectionTab);
        mTabList.add(mineTab);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }


        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTabChecked(mTabList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    /**
     * 设置Tab状态
     */
    private void setTabChecked(TabStateLayout tab) {

        for (TabStateLayout tabLayout : mTabList) {
            tabLayout.setChecked(false);
        }
        tab.setChecked(true);

    }

}
