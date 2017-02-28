package com.siweisoft.nurse.ui.bed.datachart.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.TitleDataResBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class DataChartDAOpe extends BaseOpe {

    TitleDataResBean titleDataResBean;


    public DataChartDAOpe(Context context) {
        super(context);
    }

    public TitleDataResBean getTitleDataResBean() {
        return titleDataResBean;
    }

    public void setTitleDataResBean(TitleDataResBean titleDataResBean) {
        this.titleDataResBean = titleDataResBean;
    }
}
