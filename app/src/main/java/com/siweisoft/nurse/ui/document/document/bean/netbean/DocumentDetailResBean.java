package com.siweisoft.nurse.ui.document.document.bean.netbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-16.
 */

public class DocumentDetailResBean extends ResultResBean{


    private List<DataBeanX> data;

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX implements Serializable{
        /**
         * filename : 入院介绍
         * fileid : 48
         * data : [{"nid":"40","fileid":"48","filename":"入院介绍","termid":"3","parenttermid":"","type":"boolean","termname":"介绍病区环境,医院规章制度,陪护管理制度,病人的权利,呼叫器的使用方法,安全管理制度和注意事项,禁止吸烟和院内专门吸烟点等","initstring":"","upper":"","lower":"","value":"","valuetype":"int","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"6"},{"nid":"41","fileid":"48","filename":"入院介绍","termid":"4","parenttermid":"","type":"boolean","termname":"介绍\"一日清\"住院费用查询方法,投诉渠道等","initstring":"","upper":"","lower":"","value":"","valuetype":"int","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"6"},{"nid":"42","fileid":"48","filename":"入院介绍","termid":"5","parenttermid":"","type":"boolean","termname":"介绍跌倒/坠床标准预防各项措施，有跌倒高危因素者向患者和家属强化介绍","initstring":"","upper":"","lower":"","value":"","valuetype":"int","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"6"},{"nid":"43","fileid":"48","filename":"入院介绍","termid":"6","parenttermid":"","type":"boolean","termname":"介绍床位医生、护士长及责任护士姓名","initstring":"","upper":"","lower":"","value":"","valuetype":"int","textalign":"","prefix":"","suffix":"","items":[[],[],[]],"itemvalues":"","validrange":"","coeff":"6"}]
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

        public static class DataBean implements Serializable{
            /**
             * nid : 40
             * fileid : 48
             * filename : 入院介绍
             * termid : 3
             * parenttermid :
             * type : boolean
             * termname : 介绍病区环境,医院规章制度,陪护管理制度,病人的权利,呼叫器的使用方法,安全管理制度和注意事项,禁止吸烟和院内专门吸烟点等
             * initstring :
             * upper :
             * lower :
             * value :
             * valuetype : int
             * textalign :
             * prefix :
             * suffix :
             * items : [[],[],[]]
             * itemvalues :
             * validrange :
             * coeff : 6
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
            private List<List<?>> items;

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

            public List<List<?>> getItems() {
                return items;
            }

            public void setItems(List<List<?>> items) {
                this.items = items;
            }
        }
    }
}
