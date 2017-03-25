package com.summer.app.ui.bed.addmypatient.bean;


import com.summer.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class MyPaitentUpdateReqBean extends ResultResBean {

    private String patientname;

    private String zyh;

    private String bedcode;

    private String regioncode;

    public MyPaitentUpdateReqBean() {
    }

    public MyPaitentUpdateReqBean(String bedcode, String patientname, String regioncode, String zyh) {
        this.bedcode = bedcode;
        this.patientname = patientname;
        this.regioncode = regioncode;
        this.zyh = zyh;
    }

    public String getBedcode() {
        return bedcode;
    }

    public void setBedcode(String bedcode) {
        this.bedcode = bedcode;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
