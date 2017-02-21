package com.siweisoft.nurse.ui.addwater.addaddwater.bean.netbean;

import com.siweisoft.lib.network.bean.req.BaseReqBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterDataReqBean extends BaseReqBean {

    private String pid;

    private String pname;

    private String fileid;

    private String filename ;

    private String taskid;

    private String advid;

    private String type;

    private String wardid;

    private String json_data;

    public String getAdvid() {
        return advid;
    }

    public void setAdvid(String advid) {
        this.advid = advid;
    }

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

    public String getJson_data() {
        return json_data;
    }

    public void setJson_data(String json_data) {
        this.json_data = json_data;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        this.wardid = wardid;
    }
}
