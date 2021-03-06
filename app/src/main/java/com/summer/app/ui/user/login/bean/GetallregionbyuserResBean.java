package com.summer.app.ui.user.login.bean;

import com.summer.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class GetallregionbyuserResBean extends ResultResBean {


    ArrayList<Data> data;

    public GetallregionbyuserResBean() {
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data implements Serializable {

        private String wardcode;

        private String wardname;

        private String suffix;

        public Data() {
        }

        public String getSuffix() {
            return suffix;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getWardcode() {
            return wardcode;
        }

        public void setWardcode(String wardcode) {
            this.wardcode = wardcode;
        }

        public String getWardname() {
            return wardname;
        }

        public void setWardname(String wardname) {
            this.wardname = wardname;
        }
    }


}
