package com.siweisoft.service.main;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.siweisoft.constant.ValueConstant;
import com.siweisoft.appthread.AppThread;
import com.siweisoft.base.ui.interf.OnNetFinishWithObjInter;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.data.DateFormatUtil;


/**
 * Created by ${viwmox} on 2016-07-12.
 */
public class AppService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppThread.getInstance(new OnNetFinishWithObjInter() {
            @Override
            public void onNetFinish(Object o) {
                int i = (int) o;
                //isThisParentHaveChild(NoteBookID.BASE_PARENT_ID, name);
                Intent intent1 = new Intent(getPackageName() + ValueConstant.ACITON_GLOB_CAST);
                intent1.putExtra(ValueConstant.DATA_DATA, i);
                sendBroadcast(intent1);
            }
        }).init().start();
        return super.onStartCommand(intent, flags, startId);
    }

    int index = -1;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
