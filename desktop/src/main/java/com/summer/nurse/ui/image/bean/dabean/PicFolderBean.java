package com.summer.nurse.ui.image.bean.dabean;


import com.summer.base.ui.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-08-01.
 */
public class PicFolderBean extends BaseBean {

    private ArrayList<String> paths = new ArrayList<>();

    private String folderName;

    public PicFolderBean() {

    }


    public PicFolderBean(String folderName) {
        this.folderName = folderName;

    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public ArrayList<String> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<String> paths) {
        this.paths = paths;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PicFolderBean) {
            PicFolderBean picFolderBean = (PicFolderBean) o;
            if (getFolderName().equals(picFolderBean.getFolderName())) {
                return true;
            }
        }
        return false;
    }
}
