package com.siweisoft.nurse.ui.bed.assay.bean.resbean;


import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayResBean extends ResultResBean {

    private String applyno;

    private String HospNo;

    private String itemname;

    private String result;

    private String referencerange;

    private String highlowflag;

    private String reporttitle;

    private String resultdate;

    private String resulttime;

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getHighlowflag() {
        return highlowflag;
    }

    public void setHighlowflag(String highlowflag) {
        this.highlowflag = highlowflag;
    }

    public String getHospNo() {
        return HospNo;
    }

    public void setHospNo(String hospNo) {
        HospNo = hospNo;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getReferencerange() {
        return referencerange;
    }

    public void setReferencerange(String referencerange) {
        this.referencerange = referencerange;
    }

    public String getReporttitle() {
        return reporttitle;
    }

    public void setReporttitle(String reporttitle) {
        this.reporttitle = reporttitle;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultdate() {
        return resultdate;
    }

    public void setResultdate(String resultdate) {
        this.resultdate = resultdate;
    }

    public String getResulttime() {
        return resulttime;
    }

    public void setResulttime(String resulttime) {
        this.resulttime = resulttime;
    }

}
