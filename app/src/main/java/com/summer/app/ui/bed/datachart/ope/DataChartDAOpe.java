package com.summer.app.ui.bed.datachart.ope;

import android.content.Context;

import com.summer.app.ui.bed.data.bean.resbean.TitleDataResBean;
import com.summer.lib.base.ui.ope.BaseOpe;

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
