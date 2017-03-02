package com.siweisoft.util.data;

import java.util.Calendar;

/**
 * Created by ${viwmox} on 2016-05-05.
 */
public class FormatUtil {

    private static FormatUtil instance;

    public static FormatUtil getInstance() {
        if (instance == null) {
            instance = new FormatUtil();
        }
        return instance;
    }

    public float getFloat(String str) {

        if (str == null) {
            return 0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0f;
    }

    public int getInt(String str) {

        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getYYMMDD(int y, int m, int d) {
        //SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String yy, mm, dd;
        yy = y + "";
        mm = m < 10 ? "0" + m : m + "";
        dd = d < 10 ? "0" + d : d + "";
        return yy + "-" + mm + "-" + dd;
    }

    public String getHHMM(int h, int m) {
        //SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String hh, mm;
        hh = h + "";
        mm = m + "";
        if (h < 10) {
            hh = "0" + h;
        }
        if (m < 10) {
            mm = "0" + m;
        }
        return hh + ":" + mm;
    }

    public long getTime(int h, int m) {
        return h * 3600 + m * 60;
    }

    public long getNowHHMMTime() {
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int m = Calendar.getInstance().get(Calendar.MINUTE);
        return h * 3600 + m * 60;
    }

    public String toNowHHMMTime(long time) {
        int h = (int) (time / 3600);
        int m = (int) ((time % 3600) / 60);
        return getHHMM(h, m);
    }

}
