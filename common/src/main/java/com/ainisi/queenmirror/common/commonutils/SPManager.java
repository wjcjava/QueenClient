
package com.ainisi.queenmirror.common.commonutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.ainisi.queenmirror.common.baseapp.BaseApplication;


/**
 * @author qndroid
 * @description 配置文件工具类
 * @date 2015年1月15日
 */
public class SPManager {
    public static final String USER_TOKEN = "user_token";
    public static final String USER_NAME = "user_name";
    public static final String USER_PHONE = "user_phone";
    public static final String USER_PHOTO_URL = "user_photo";
    public static final String CITY_NAME = "city_name";
    public static final String CITY_ID = "city_id";
    /**
     * 检查用户是否是第一次安装
     */
    public static final String CHECK_IS_FIRST_STALL = "check_first_stall";
    /**
     * 保存用户默认地址
     */
    public static final String SAVE_USER_ADDRESS = "user_address";
    private static SharedPreferences sp = null;
    private static SPManager spManager = null;
    private static Editor editor = null;


    /**
     * Preference文件名
     */
    private static final String SHARE_PREFREENCE_NAME = "meiyaoni.pre";

    private SPManager() {
        sp = BaseApplication.getAppContext().getSharedPreferences(SHARE_PREFREENCE_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 保存手机好
     *
     * @param phone
     */
    public void setUserPhone(String phone) {
        spManager.putString(USER_PHONE, phone);
    }

    /**
     * 获取手机好
     *
     * @return
     */
    public String getUserPhone() {
        return spManager.getString(USER_PHONE, "");
    }

    public void setUserName(String name) {
        spManager.putString(USER_NAME, name);
    }

    public String getUserName() {
        return spManager.getString(USER_NAME, "");
    }

    public void setUserPhotoUrl(String photoUrl) {
        spManager.putString(USER_PHOTO_URL, photoUrl);
    }

    public String getUserPhotoUrl() {
        return spManager.getString(USER_PHOTO_URL, "");
    }

    /**
     * 检查是否是第一次安装
     */
    public static boolean isFirstStall() {
        if (spManager.getBoolean(CHECK_IS_FIRST_STALL, false)) {
            return false;
        } else {
            spManager.putBoolean(CHECK_IS_FIRST_STALL, true);
            return true;
        }
    }


    public void setSaveUserAddress(String address) {
        spManager.putString(SAVE_USER_ADDRESS, address);
    }

    public String getSaveUserAddress() {
        return spManager.getString(SAVE_USER_ADDRESS, null);
    }

    public static SPManager getInstance() {
        if (spManager == null || sp == null || editor == null) {
            spManager = new SPManager();
        }
        return spManager;
    }

    public static String getCityID() {
        return spManager.getString(CITY_ID, "8");
    }

    public static void setCityID(String city_id) {
        spManager.putString(CITY_ID, city_id);
    }

    public static String getCityName() {
        return spManager.getString(CITY_NAME, "");
    }

    public static void setCityName(String name) {
        spManager.putString(CITY_NAME, name);
    }

    public String getToken() {
        return getString(USER_TOKEN, "");
    }

    public boolean isLogin() {
        return getString(USER_TOKEN, null) == null ? false : true;
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key, int defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public boolean isKeyExist(String key) {
        return sp.contains(key);
    }

    public float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除文件所有数据
     */
    public void clearAllCache() {
        editor.clear();
        editor.commit();
    }
}
