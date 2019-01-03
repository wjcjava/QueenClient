package com.ainisi.queenmirror.common.commonutils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import com.ainisi.queenmirror.common.baseapp.BaseApplication;
import com.ainisi.queenmirror.common.commonwidget.CommonDialog;

/**
 * @author weikailiang
 * @function Created on 2017/10/16.
 */

public class SystemUtils {
    private static CommonDialog dialog;

    public static void startToSettingAuth(Context context) {
        dialog = new CommonDialog(context, "提示", "您的应用缺少定位权限,请到系统设置收到开启", "确定", "取消", new CommonDialog.DialogClickListener() {
            @Override
            public void onDialogClick() {
                SystemUtils.getAppDetailSettingIntent(BaseApplication.getAppContext());
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public static void startToSettingAuth(Context context, String text) {
        dialog = new CommonDialog(context, "提示", text, "确定", "取消", new CommonDialog.DialogClickListener() {
            @Override
            public void onDialogClick() {
                SystemUtils.getAppDetailSettingIntent(BaseApplication.getAppContext());
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public static void getAppDetailSettingIntent(Context context) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(localIntent);
    }
}
