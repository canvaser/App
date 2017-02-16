package com.siweisoft.nurse.ui.document.document.bean.netbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentListResBean extends ResultResBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 47
         * pid : 0
         * type : 0
         * title : 健康教育记录单
         */

        private String id;
        private String pid;
        private String type;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
