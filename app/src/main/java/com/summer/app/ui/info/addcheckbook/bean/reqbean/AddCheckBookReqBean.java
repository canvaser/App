package com.summer.app.ui.info.addcheckbook.bean.reqbean;


import com.summer.lib.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class AddCheckBookReqBean extends BaseReqBean {

    private String fileid;

    private String instrumentname;

    private String username;

    private String value;

    private String filename;

    private String type;

    private String shift;

    private String instrumentid;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getInstrumentid() {
        return instrumentid;
    }

    public void setInstrumentid(String instrumentid) {
        this.instrumentid = instrumentid;
    }

    public String getInstrumentname() {
        return instrumentname;
    }

    public void setInstrumentname(String instrumentname) {
        this.instrumentname = instrumentname;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
