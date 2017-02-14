package com.siweisoft.nurse.ui.bed.inputhandoverreport.bean.reqbean;

import com.siweisoft.base.ui.bean.BaseBean;
import com.siweisoft.network.bean.req.BaseReqBean;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class InputHORReqBean extends BaseReqBean{

    private String zyh;

    private String content;

    private String mode;

    private String logid;

    private String audio;


    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
