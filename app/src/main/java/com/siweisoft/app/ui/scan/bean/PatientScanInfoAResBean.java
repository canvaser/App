package com.siweisoft.app.ui.scan.bean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class PatientScanInfoAResBean extends ResultResBean {


    /**
     * qrtype : pat
     * qrseat : wd
     * pno : 830135
     * zyh : 830591
     */

    private String qrtype;
    private String qrseat;
    private String pno;
    private String zyh;

    public String getQrtype() {
        return qrtype;
    }

    public void setQrtype(String qrtype) {
        this.qrtype = qrtype;
    }

    public String getQrseat() {
        return qrseat;
    }

    public void setQrseat(String qrseat) {
        this.qrseat = qrseat;
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
}
