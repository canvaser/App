package com.summer.app.ui.mission.missionlist.ope;

import com.summer.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.summer.lib.util.data.DateFormatUtil;

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
            } else if (DateFormatUtil.convent_yyyyMMddHHmmss(o1.getStart()).getTime() == DateFormatUtil.convent_yyyyMMddHHmmss(o2.getStart()).getTime()) {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
