package com.siweisoft.base.ui.bean.bean;

import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-07-12.
 */
public class ImageDataBean extends BaseBean{

    String path;

    String fileName;

    String mimeType;

    public ImageDataBean(String fileName, String mimeType, String path) {
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImageDataBean{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
