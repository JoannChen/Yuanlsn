package com.zuoyu.yuanlsn.application


import android.app.Application
import android.content.Context
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.log.LoggerInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Function：全局管理类
 *
 * Created by Joann on 2017/2/28 17:15
 * E-mail:q8622268@163.com
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = applicationContext


        /*
         * 初始化HttpClient
         */
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(LoggerInterceptor("网络请求"))
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                //其他配置
                .build()
        OkHttpUtils.initClient(okHttpClient)
    }

    companion object {

        var instance: Context? = null
            private set

    }

}
