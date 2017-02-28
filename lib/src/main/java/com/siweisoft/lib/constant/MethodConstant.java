package com.siweisoft.lib.constant;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;


/**
 * 方法常量
 * Created by ${viwmox} on 2016-05-12.
 */
public class MethodConstant {
    /**
     * 获取账号
     */
    public static String getAccount(Context context) {
        return SPUtil.getInstance().init(context).getAccount();
    }

//    public static int getMainColor(Context context){
//
//    }

    public static String toObject(Object o) {
        return "{data:" + GsonUtil.getInstance().toJson(o) + "}";
    }

    public static String getVersionName(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (info != null) {
                return info.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
