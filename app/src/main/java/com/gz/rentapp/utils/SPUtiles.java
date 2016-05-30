package com.gz.rentapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @创建着: wuzhenyang
 * @描述: 缓存数据工具类, 主要用来存放SharedPreferences中的数据, 和常量
 */
public class SPUtiles {
    public static String SPNAME = "spname";// SharedPreferences的名字
    private static SharedPreferences mSP;//

    /**
     * @param context 上下文
     * @return 返回一个SharedPreferences的实列
     */
    public static SharedPreferences getSP(Context context) {
        if (mSP == null) {
            mSP = context.getSharedPreferences(SPNAME, Context.MODE_PRIVATE);
        }
        return mSP;
    }

    /**
     * @param context 上下文
     * @param keyName 缓存的数据的Key
     * @return 返回Key对应的View 默认返回false
     */
    public static boolean getBoolean(Context context, String keyName) {

        SharedPreferences sp = getSP(context);

        return sp.getBoolean(keyName, false);
    }

    /**
     * @param context 上下文
     * @param keyName 缓存的数据的Key
     * @param value   要设置的值
     */
    public static void setBoolean(Context context, String keyName, boolean value) {
        SharedPreferences sp = getSP(context);
        Editor edit = sp.edit();// 获得Sp的编辑器
        edit.putBoolean(keyName, value).commit();
    }

    /**
     * @param context 上下文
     * @param keyName 缓存的数据的Key
     * @return 返回Key对应的View 默认返回false
     */
    public static boolean getPush(Context context, String keyName) {

        SharedPreferences sp = getSP(context);

        return sp.getBoolean(keyName, true);
    }

    /**
     * @param context 上下文
     * @param keyName 缓存的数据的Key
     * @param value   要设置的值
     */
    public static void setPush(Context context, String keyName, boolean value) {
        SharedPreferences sp = getSP(context);
        Editor edit = sp.edit();// 获得Sp的编辑器
        edit.putBoolean(keyName, value).commit();
    }

    /**
     * @param context 上下文
     * @param keyName 获取Sp时的key值
     * @return 返回key值对应的缓存数据
     * 默认返回空字符串
     */
    public static String getString(Context context, String keyName) {

        SharedPreferences sp = getSP(context);

        return sp.getString(keyName, "");
    }

    /**
     * @param context 上下文
     * @param keyName 缓存的数据的Key
     * @param value   要设置的值
     */
    public static void setString(Context context, String keyName, String value) {
        SharedPreferences sp = getSP(context);
        Editor edit = sp.edit();// 获得Sp的编辑器
        edit.putString(keyName, value).commit();
    }


    /**
     * 通过SharedPreferences获得Long类型的数据，没有默认为-1
     *
     * @param context 上下文
     * @param key     long值对应的key
     * @return 默认返回-1
     */
    public static long getLong(Context context, String key) {
        mSP = getSP(context);
        return mSP.getLong(key, -1);
    }

    /**
     * 通过SharedPreferences获得Long类型的数据，没有默认为-1，没有默认为传入的defValue
     *
     * @param context  上下文
     * @param key      long值对应的key
     * @param defValue 默认的long值
     * @return
     */
    public static long getLong(Context context, String key, long defValue) {
        mSP = getSP(context);
        return mSP.getLong(key, defValue);
    }

    /**
     * 通过SharedPreferences获得Long类型的数据，没有默认为-1
     *
     * @param context 上下文
     * @param key     long值对应的key
     * @param value   需要保持的Long值
     */
    public static void setLong(Context context, String key, long value) {
        mSP = getSP(context);
        // 获得编辑器
        Editor mEdit = mSP.edit();
        mEdit.putLong(key, value).commit();
    }

    /**
     * 通过SharedPreferences获得int类型的数据，没有默认为0，没有默认为传入的defValue
     *
     * @param context 上下文
     * @param key     int值对应的key
     * @return
     */
    public static int getInt(Context context, String key) {
        mSP = getSP(context);
        return mSP.getInt(key, 0);
    }

    /**
     * 通过SharedPreferences设置int类型的数据
     *
     * @param context 上下文
     * @param key     int值对应的key
     * @param value   需要保持的Long值
     */
    public static void setint(Context context, String key, int value) {
        mSP = getSP(context);
        // 获得编辑器
        Editor mEdit = mSP.edit();
        mEdit.putInt(key, value).commit();
    }
}
