package com.zuoyu.yuanlsn.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zuoyu.yuanlsn.application.TitleManage;
import com.zuoyu.yuanlsn.utils.HttpUtil;
import com.zuoyu.yuanlsn.widget.LoadingProgress;

/**
 * Function：Activity 基类
 *
 * Created by Joann on 17/1/22 16:35
 * E-mail:q8622268@163.com
 */
public abstract class BaseActivity extends AutoLayoutActivity implements View.OnClickListener {

    public Context context;
    public Activity activity;

    public HttpUtil httpUtil;// 初始化网络请求
    public TitleManage titleManage;// 标题栏管理类
    public LoadingProgress loadingProgress;// 加载进度条


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        //强制屏幕
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        context = this;
        activity = this;
        httpUtil = new HttpUtil(this);
        loadingProgress = new LoadingProgress(this);


        // 子类需要重写的方法
        initTitle();
        initView();
        initStatusBar();

    }


    /**
     * 初始化标题栏
     */
    public abstract void initTitle();

    /**
     * 初始化View组件
     */
    public abstract void initView();


    @Override
    public void onClick(View v) {
        // 需要时调用
    }

    /**
     * 设置沉浸式状态栏
     */
    protected void initStatusBar() {
//        StatusBarUtil.setColor(this, ContextCompat.getColor(context, R.color.colorPrimary));
        StatusBarUtil.setTransparent(this);
    }

    /**
     * 以下为生命周期
     */


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        httpUtil.cancel();
        super.onDestroy();

    }

}

