package com.siweisoft.nurse.ui.mission.missionlist.ope;

import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.text.ParseException;
import java.util.Comparator;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class SortByTime implements Comparator<AreaMessionListResBean.DataBean> {
    @Override
    public int compare(AreaMessionListResBean.DataBean o1, AreaMessionListResBean.DataBean o2) {
        try {
            if (DateFormatUtil.convent_yyyyMMddHHmmss(o1.getStart()).getTime() > DateFormatUtil.convent_yyyyMMddHHmmss(o2.getStart()).getTime()) {
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
