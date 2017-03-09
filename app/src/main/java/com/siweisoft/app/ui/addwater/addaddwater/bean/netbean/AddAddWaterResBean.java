package com.siweisoft.app.ui.addwater.addaddwater.bean.netbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterResBean extends ResultResBean {


    private List<DataBeanX> data;

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX implements Serializable {
        /**
         * filename : 补液卡
         * fileid : 71
         * data : [{"nid":"142","fileid":"71","filename":"补液卡","termid":"87","parenttermid":"","type":"date","termname":"时间","initstring":"","upper":"","lower":"","value":"","valuetype":"datetime","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"1"},{"nid":"143","fileid":"71","filename":"补液卡","termid":"88","parenttermid":"","type":"text","termname":"补液内容","initstring":"","upper":"","lower":"","value":"","valuetype":"string","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"1"},{"nid":"144","fileid":"71","filename":"补液卡","termid":"89","parenttermid":"","type":"text","termname":"补液情况","initstring":"","upper":"","lower":"","value":"","valuetype":"string","textalign":"","prefix":"","suffix":"","items":[["通畅","外溢","阻塞"],["通畅","外溢","阻塞"],[]],"itemvalues":"通畅,外溢,阻塞","validrange":"","coeff":"1"},{"nid":"145","fileid":"71","filename":"补液卡","termid":"90","parenttermid":"","type":"text","termname":"滴速","initstring":"","upper":"","lower":"","value":"","valuetype":"int","textalign":"","prefix":"","suffix":"滴/分","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"1"},{"nid":"1452","fileid":"71","filename":"补液卡","termid":"91","parenttermid":"","type":"text","termname":"剩余补液量","initstring":"","upper":"","lower":"","value":"","valuetype":"float","textalign":"","prefix":"","suffix":"ml","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"1"}]
         */

        private String filename;
        private String fileid;
        private List<DataBean> data;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFileid() {
            return fileid;
        }

        public void setFileid(String fileid) {
            this.fileid = fileid;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * nid : 142
             * fileid : 71
             * filename : 补液卡
             * termid : 87
             * parenttermid :
             * type : date
             * termname : 时间
             * initstring :
             * upper :
             * lower :
             * value :
             * valuetype : datetime
             * textalign :
             * prefix :
             * suffix :
             * items : [[],[],[]]
             * itemvalues :
             * validrange :
             * coeff : 1
             */

            private String nid;
            private String fileid;
            private String filename;
            private String termid;
            private String parenttermid;
            private String type;
            private String termname;
            private String initstring;
            private String upper;
            private String lower;
            private String value;
            private String valuetype;
            private String textalign;
            private String prefix;
            private String suffix;
            private String itemvalues;
            private String validrange;
            private String coeff;
            private ArrayList<ArrayList<String>> items;
            private String wardid;
            private String timestamp;
            private String zyh;

            public String getNid() {
                return nid;
            }

            public void setNid(String nid) {
                this.nid = nid;
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

            public String getTermid() {
                return termid;
            }

            public void setTermid(String termid) {
                this.termid = termid;
            }

            public String getParenttermid() {
                return parenttermid;
            }

            public void setParenttermid(String parenttermid) {
                this.parenttermid = parenttermid;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTermname() {
                return termname;
            }

            public void setTermname(String termname) {
                this.termname = termname;
            }

            public String getInitstring() {
                return initstring;
            }

            public void setInitstring(String initstring) {
                this.initstring = initstring;
            }

            public String getUpper() {
                return upper;
            }

            public void setUpper(String upper) {
                this.upper = upper;
            }

            public String getLower() {
                return lower;
            }

            public void setLower(String lower) {
                this.lower = lower;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getValuetype() {
                return valuetype;
            }

            public void setValuetype(String valuetype) {
                this.valuetype = valuetype;
            }

            public String getTextalign() {
                return textalign;
            }

            public void setTextalign(String textalign) {
                this.textalign = textalign;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public String getItemvalues() {
                return itemvalues;
            }

            public void setItemvalues(String itemvalues) {
                this.itemvalues = itemvalues;
            }

            public String getValidrange() {
                return validrange;
            }

            public void setValidrange(String validrange) {
                this.validrange = validrange;
            }

            public String getCoeff() {
                return coeff;
            }

            public void setCoeff(String coeff) {
                this.coeff = coeff;
            }

            public ArrayList<ArrayList<String>> getItems() {
                return items;
            }

            public void setItems(ArrayList<ArrayList<String>> items) {
                this.items = items;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getWardid() {
                return wardid;
            }

            public void setWardid(String wardid) {
                this.wardid = wardid;
            }

            public String getZyh() {
                return zyh;
            }

            public void setZyh(String zyh) {
                this.zyh = zyh;
            }
        }
    }
}
