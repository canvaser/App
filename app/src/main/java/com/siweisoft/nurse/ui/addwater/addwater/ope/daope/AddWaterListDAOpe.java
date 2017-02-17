package com.siweisoft.nurse.ui.addwater.addwater.ope.daope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListDAOpe extends BaseDAOpe{

    AddWaterListResBean addWaterListResBean;

    private String startTime;

    private String endtime;

    public AddWaterListDAOpe(Context context) {
        super(context);
    }

    public AddWaterListResBean getAddWaterListResBean() {
        return addWaterListResBean;
    }

    public void setAddWaterListResBean(AddWaterListResBean addWaterListResBean) {
        this.addWaterListResBean = addWaterListResBean;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
