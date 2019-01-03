package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 作者： jl
 * 日期： 2017/2/28.
 */

public class SP {
    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String key, Object object) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (object == null){
            return;
        }
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /*public static void saveUserInfo(Context context, UserInfo userInfo) {
        if (userInfo == null)
            return;
        put(context, "uid", userInfo.getUid());
        put(context, "ubirthday", userInfo.getUbirthday());
        put(context, "umailbox", userInfo.getUmailbox());
        put(context, "usex", userInfo.getUsex());
        put(context, "uwechat", userInfo.getUwechat());
        put(context, "umobile", userInfo.getUmobile());
//        put(context,"uzhifubao",userInfo.getu);
        put(context, "unickname", userInfo.getUnickname());
//        put(context,"uqq",);
//        put(context,"upicadress",userInfo.getu);
//        put(context,"uweibo",userInfo.get);
        put(context, "uregisterTime", userInfo.getUregisterTime());
        put(context, "ulocationID", userInfo.getUlocationID());
//        put(context,"ubackground",userInfo.getu);
    }


    public static UserInfo getUserInfo(Context context) {
        UserInfo userInfo = new UserInfo();

        userInfo.setUid((Integer) get(context, Key.UID, 0));
        userInfo.setUbirthday((String) get(context, Key.U_BIRTHDAY, ""));
        userInfo.setUmailbox((String) get(context, Key.U_EMAIL, ""));
        userInfo.setUwechat((String) get(context, Key.U_WECHAT, ""));
        userInfo.setUmobile((String) get(context, Key.U_MOBILE, ""));
//        userInfo.setUzhi 支付宝
        userInfo.setUnickname((String) get(context, Key.U_NICKNAME, ""));
//        userInfo.setUqq();
//        userInfo.setUpicadress();
//        userInfo.setUweibo();
        userInfo.setUregisterTime((String) get(context, Key.U_REGISTTIME, ""));
//        userInfo.setUbackground(get(context,Key.U_BACKGROUND,""));
        return userInfo;
    }*/

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}
