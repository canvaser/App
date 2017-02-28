package com.siweisoft.aplication;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.service.main.AppService;
import com.siweisoft.lib.util.AppUtil;
import com.siweisoft.lib.util.LogUtil;
import com.siweisoft.lib.util.ScreenUtil;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.home.activity.IndexActivity;

import org.xutils.x;

import java.util.UUID;


/**
 * 用于一些跟应用程序生命周期一致的处理
 */
public class AppAplication extends com.siweisoft.lib.aplication.LibAplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();
        initXUtil();
        initServer();
        initCrash();
        initUUUId();
        initZxing();

    }

    private void initBase() {
        ScreenUtil.getInstance().getScreenSize(this);
        ValueConstant.DIMEN_1 = (int) getResources().getDimension(R.dimen.dimen_1);
        NetWork.getInstance(this).init(DataValue.URL_NURSE);
        DataValue.init();
    }

    private void initXUtil() {
        x.Ext.init(this);
    }


    private void initServer() {
        Intent intent = new Intent(this, AppService.class);
        startService(intent);

    }

    private void initCrash() {

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

    public void reStart() {
        exit();
        startActivity(new Intent(this, IndexActivity.class));
    }
}
