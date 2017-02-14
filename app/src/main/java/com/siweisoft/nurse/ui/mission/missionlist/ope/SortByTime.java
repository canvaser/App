package com.siweisoft.nurse.ui.mission.missionlist.ope;

import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;
import com.siweisoft.util.data.DateFormatUtil;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class SortByTime implements Comparator<AreaMessionResBean>{
    @Override
    public int compare(AreaMessionResBean o1, AreaMessionResBean o2) {
        try {
            if(DateFormatUtil.convent_yyyyMMddHHmmss(o1.getStart()).getTime()>DateFormatUtil.convent_yyyyMMddHHmmss(o2.getStart()).getTime()){
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
