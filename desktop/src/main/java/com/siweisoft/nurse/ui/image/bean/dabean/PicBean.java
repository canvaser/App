package com.siweisoft.nurse.ui.image.bean.dabean;


import com.siweisoft.base.ui.bean.BaseBean;

/**
 * Created by ${viwmox} on 2016-08-01.
 */
public class PicBean extends BaseBean {

    private String name;

    private String path;

    private String folder;

    private boolean select;

    public PicBean() {
    }

    public PicBean(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public PicBean(String folder, String name, String path) {
        this.folder = folder;
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
