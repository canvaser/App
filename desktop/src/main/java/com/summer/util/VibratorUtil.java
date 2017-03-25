package com.summer.util;

import android.content.Context;
import android.os.Vibrator;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2017-01-06.
 */

public class VibratorUtil implements Serializable {

    private static VibratorUtil instance;

    public static VibratorUtil getInstance() {
        if (instance == null) {
            instance = new VibratorUtil();
        }
        return instance;
    }

    public void call(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{1000, 2000, 1000, 2000}, -1);
    }

}
