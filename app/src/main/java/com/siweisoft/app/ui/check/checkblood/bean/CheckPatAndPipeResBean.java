package com.siweisoft.app.ui.check.checkblood.bean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

/**
 * Created by ${viwmox} on 2017-03-15.
 */

public class CheckPatAndPipeResBean extends ResultResBean {


    /**
     * isException : false
     * data : {"zyh":"123456","isFind":"true","name":"胡银祥","gender":"男","bedno":"0839","age":"35","resCode":"0","resMsg":"匹配结果：试管与当前病人匹配失败！"}
     */

    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * zyh : 123456
         * isFind : true
         * name : 胡银祥
         * gender : 男
         * bedno : 0839
         * age : 35
         * resCode : 0
         * resMsg : 匹配结果：试管与当前病人匹配失败！
         */

        private String zyh;
        private String isFind;
        private String name;
        private String gender;
        private String bedno;
        private String age;
        private String resCode;
        private String resMsg;
        private String code;

        public String getZyh() {
            return zyh;
        }

        public void setZyh(String zyh) {
            this.zyh = zyh;
        }

        public String getIsFind() {
            return isFind;
        }

        public void setIsFind(String isFind) {
            this.isFind = isFind;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBedno() {
            return bedno;
        }

        public void setBedno(String bedno) {
            this.bedno = bedno;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getResCode() {
            return resCode;
        }

        public void setResCode(String resCode) {
            this.resCode = resCode;
        }

        public String getResMsg() {
            return resMsg;
        }

        public void setResMsg(String resMsg) {
            this.resMsg = resMsg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
