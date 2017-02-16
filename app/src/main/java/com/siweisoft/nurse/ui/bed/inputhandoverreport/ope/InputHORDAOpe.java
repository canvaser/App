package com.siweisoft.nurse.ui.bed.inputhandoverreport.ope;

import android.content.Context;
import android.media.MediaRecorder;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;

import java.io.File;

/**
 * Created by ${viwmox} on 2016-12-06.
 */
public class InputHORDAOpe extends BaseOpe {

    MediaRecorder mediaRecorder;

    private File file;

    private String status;

    private String type ;

    private ShiftDuteResBean shiftDuteResBean;


    public InputHORDAOpe(Context context) {
        super(context);
    }

    public MediaRecorder getMediaRecorder() {
        return mediaRecorder;
    }

    public void setMediaRecorder(MediaRecorder mediaRecorder) {
        this.mediaRecorder = mediaRecorder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ShiftDuteResBean getShiftDuteResBean() {
        return shiftDuteResBean;
    }

    public void setShiftDuteResBean(ShiftDuteResBean shiftDuteResBean) {
        this.shiftDuteResBean = shiftDuteResBean;
    }
}
