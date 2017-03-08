package com.siweisoft.nurse.ui.info.workdetail.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.nurse.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailsDAOpe extends BaseOpe {

    WorkDetailAdapterBean workDetailAdapterBean;


    public WorkDetailsDAOpe(Context context) {
        super(context);
    }

    public WorkDetailAdapterBean getWorkDetailAdapterBean() {
        return workDetailAdapterBean;
    }

    public void setWorkDetailAdapterBean(WorkDetailAdapterBean workDetailAdapterBean) {
        this.workDetailAdapterBean = workDetailAdapterBean;
    }
}
