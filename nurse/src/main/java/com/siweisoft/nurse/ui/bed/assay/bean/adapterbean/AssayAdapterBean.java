package com.siweisoft.nurse.ui.bed.assay.bean.adapterbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayListResBean;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayAdapterBean extends ResultResBean {

    private String applyno;

    ArrayList<AssayListResBean.AssayDataBean> list;

    private String title;

    private String time;

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public ArrayList<AssayListResBean.AssayDataBean> getList() {
        return list;
    }

    public void setList(ArrayList<AssayListResBean.AssayDataBean> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
