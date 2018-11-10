package com.zuoyu.yuanlsn.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.zuoyu.yuanlsn.application.MyApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Function：SharedPreferences保存数据工具类
 *
 * Created by JoannChen on 2017/3/10 15:48
 * E-mail:q8622268@163.com
 */
public class SharedUtil {

    /**
     * 文件名
     */
    private static final String FILE_NAME = "51Manager";

    // string token
    public static final String TOKEN = "token";

    // 登录状态？登录：未登录；
//    public static final String IS_LOGIN = "isLogin";

    // string token
    public static final String USER_INFO = "userInfo";

    // string 用户id
    public static final String USER_ID = "userId";

    // string 车场id
    public static final String PARK_ID = "parkId";

    // string 商户名
    public static final String USER_NAME = "userName";

    // string 车场名
    public static final String PARK_NAME = "parkName";


    /**
     * 将所有本地数据置空
     */
    public static void setEmptyAllData() {
        setString(TOKEN, "");
        setObject(USER_INFO, null);
        setString(USER_ID, "");
//        setBoolean(IS_LOGIN, false);
//        setString(PARK_ID, "");
//        setString(PARK_NAME, "");
//        setString(FILTER_SEARCH, "");
//        setString(FILTER_DATE, "");
//        setString(FILTER_PAY_TYPE, "");
//        setString(FILTER_CAR_TYPE, "");
    }

    /**
     * 获取SharedPreferences对象
     *
     * @return SharedPreferences
     */
    private static SharedPreferences getSharedPreferences() {

        return MyApplication.Companion.getInstance()
                .getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }


    /**
     * 保存String信息
     *
     * @param key     键名
     * @param content 默认值
     */
    public static void setString(String key, String content) {
        getSharedPreferences().edit().putString(key, content).apply();
    }

    public static String getString(String key) {
        return getSharedPreferences().getString(key, "");
    }


    /**
     * 保存Boolean类型的信息
     *
     * @param key  键名
     * @param flag 默认值
     */
    public static void setBoolean(String key, boolean flag) {
        getSharedPreferences().edit().putBoolean(key, flag).apply();
    }

    public static boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }


    /**
     * 保存Integer信息
     *
     * @param key     键名
     * @param content 默认值
     */
    public static void setInteger(String key, int content) {
        getSharedPreferences().edit().putInt(key, content).apply();
    }

    public static int getInteger(String key) {
        return getSharedPreferences().getInt(key, 0);
    }


    /**
     * 使用SharedPreference保存对象
     *
     * @param key 储存对象的key
     * @param obj 储存的对象
     */
    public static void setObject(String key, Object obj) {
        getSharedPreferences().edit().putString(key, Object2String(obj)).apply();
    }

    /**
     * 获取SharedPreference保存的对象
     *
     * @param key 储存对象的key
     * @return object 返回根据key得到的对象
     */
    public static Object getObject(String key) {
        String string = getSharedPreferences().getString(key, null);
        return string != null ? String2Object(string) : null;
    }

    /* ========================================================================== */

    /**
     * writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
     * 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
     *
     * @param object 待加密的转换为String的对象
     * @return String   加密后的String
     */
    private static String Object2String(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            String string = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            objectOutputStream.close();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用Base64解密String，返回Object对象
     *
     * @param objectString 待解密的String
     * @return object      解密后的object
     */
    private static Object String2Object(String objectString) {
        byte[] mobileBytes = Base64.decode(objectString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /* ========================================================================== */

}
