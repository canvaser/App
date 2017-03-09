package com.siweisoft.app.ui.addwater.addaddwater.bean.netbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class GetBylResBean extends ResultResBean {


    /**
     * data : {"nid":"1452","result":"100.00"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * nid : 1452
         * result : 100.00
         */

        private String nid;
        private String result;

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
