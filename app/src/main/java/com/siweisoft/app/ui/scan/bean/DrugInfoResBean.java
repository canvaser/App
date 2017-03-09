package com.siweisoft.app.ui.scan.bean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class DrugInfoResBean extends ResultResBean {


    /**
     * qrtype : drug
     * pno : 住院号
     * zyh : 住院流水号
     * advno : 医嘱ID
     * time : 用药时间
     */

    private String qrtype;
    private String pno;
    private String zyh;
    private String advno;
    private String time;

    public String getQrtype() {
        return qrtype;
    }

    public void setQrtype(String qrtype) {
        this.qrtype = qrtype;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getAdvno() {
        return advno;
    }

    public void setAdvno(String advno) {
        this.advno = advno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
