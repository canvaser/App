package com.summer.app.ui.document.document.bean.netbean;

import com.summer.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
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

    public static class DataBean implements Serializable {
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
        private boolean enter;

        public static final String PID_START = "0";

        public static final String TYPE_NO_CHILD = "1";

        public static final String TYPE_HAVE_CHILD = "0";

        public DataBean(String id) {
            this.id = id;
        }

        public DataBean() {
        }

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

        public boolean isEnter() {
            return enter;
        }

        public void setEnter(boolean enter) {
            this.enter = enter;
        }
    }
}
