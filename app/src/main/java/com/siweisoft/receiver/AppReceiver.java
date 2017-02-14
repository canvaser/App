package com.siweisoft.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.siweisoft.aplication.AppAplication;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.util.NotificationUtil;

/**
 * Created by ${viwmox} on 2016-10-28.
 */
public class AppReceiver extends BroadcastReceiver{




    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent ==null || intent.getStringExtra(ValueConstant.DATA_DATA)==null){
            return;
        }
        switch (intent.getStringExtra(ValueConstant.DATA_DATA)){
            case NotificationUtil.NOTIFICATION_APP:
                AppAplication appAplication = (AppAplication) context.getApplicationContext();
                Intent intent1 = new Intent(context,appAplication.getActivities().get(appAplication.getActivities().size()-1).getClass());
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//关键的一步，设置启动模式
                context.startActivity(intent1);
                break;
        }
    }
}
