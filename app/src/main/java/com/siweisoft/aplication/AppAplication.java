package com.siweisoft.aplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.siweisoft.network.NetWork;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.home.activity.IndexActivity;
import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.service.main.AppService;
import com.siweisoft.util.AppUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.ScreenUtil;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;


/**
 * 用于一些跟应用程序生命周期一致的处理
 */
public class AppAplication extends Application{


    HashMap<String,Activity> activityHashMap =new HashMap<>();

    ArrayList<Activity> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();
        initServer();
        initCrash();
        initUUUId();
        initZxing();


    }

    private void initBase(){
        ScreenUtil.getInstance().getScreenSize(this);
        ValueConstant.DIMEN_1 = (int) getResources().getDimension(R.dimen.dimen_1);
        NetWork.getInstance(this).init(DataValue.URL_NURSE);

        DataValue.init();
    }


    private void initServer(){
        Intent intent = new Intent(this, AppService.class);
        startService(intent);

    }

    private void initCrash(){

    }



    public void initEM(){

    }

    private String initUUUId(){
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        ValueConstant.UUUID = uniqueId;
        return uniqueId;
    }

    private void initZxing(){
        ZXingLibrary.initDisplayOpinion(this);
    }

    private boolean JustInitOnce(){
        String processAppName = AppUtil.getInstance().getAppName(this,android.os.Process.myPid());
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null ||!processAppName.equalsIgnoreCase(this.getPackageName())) {
            LogUtil.E("enter the service process!");
            // 则此application::onCreate 是被service 调用的，直接返回
            return false;
        }
        return true;
    }

    /**
     * 退出结束所有界面
     */
    public void exit(){
        Iterator  iterator = activityHashMap.keySet().iterator();
        while (iterator.hasNext()){
            activityHashMap.get(iterator.next()).finish();
        }
        activityHashMap.clear();
    }

    public void reStart(){
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
