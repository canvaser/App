package com.siweisoft.aplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.siweisoft.exception.exception.CrashHander;
import com.siweisoft.network.NetWork;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.index.activity.IndexActivity;
import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.service.main.AppService;
import com.siweisoft.util.AppUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.ScreenUtil;
import com.siweisoft.util.uuzuche.lib_zxing.activity.ZXingLibrary;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;


/**
 * 用于一些跟应用程序生命周期一致的处理
 */
public class AppAplication extends Application {


    HashMap<String, Activity> activityHashMap = new HashMap<>();

    ArrayList<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();
        initServer();
        initCrash();
        initUUUId();
        initZxing();
        initBmob();

    }

    private void initBmob() {
        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
                //设置appkey
                .setApplicationId("01a66429dd6e1f5f50441404631d2bc4")
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);
    }

    private void initBase() {
        ScreenUtil.getInstance().getScreenSize(this);
        ValueConstant.DIMEN_1 = (int) getResources().getDimension(R.dimen.dimen_1);
        NetWork.getInstance(this).init(DataValue.URL_NURSE);

        DataValue.init();
    }


    private void initServer() {
        Intent intent = new Intent(this, AppService.class);
        startService(intent);

    }

    private void initCrash() {
        CrashHander.getInstance().init(this);
    }


    public void initEM() {

    }

    private String initUUUId() {
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        ValueConstant.UUUID = uniqueId;
        return uniqueId;
    }

    private void initZxing() {
        ZXingLibrary.initDisplayOpinion(this);
    }

    private boolean JustInitOnce() {
        String processAppName = AppUtil.getInstance().getAppName(this, android.os.Process.myPid());
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            LogUtil.E("enter the service process!");
            // 则此application::onCreate 是被service 调用的，直接返回
            return false;
        }
        return true;
    }

    /**
     * 退出结束所有界面
     */
    public void exit() {
        Iterator iterator = activityHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            activityHashMap.get(iterator.next()).finish();
        }
        activityHashMap.clear();
    }

    public void reStart() {
        exit();
        startActivity(new Intent(this, IndexActivity.class));
    }

    public HashMap<String, Activity> getActivityHashMap() {
        return activityHashMap;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
}
