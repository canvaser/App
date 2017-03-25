package com.summer.app.ui.bed.assay.bean.resbean;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayListResBean extends ResultResBean {


    private List<AssayDataBean> data;

    public List<AssayDataBean> getData() {
        return data;
    }

    public void setData(List<AssayDataBean> data) {
        this.data = data;
    }

    public static class AssayDataBean {
        /**
         * applyno : 893492
         * HospNo : 133004002152145
         * itemname : 葡萄糖
         * result : -
         * referencerange : -
         * highlowflag :
         * reporttitle : 检验科尿液
         * resultdate : 2016-12-08 00:00:00
         * resulttime : 2016-12-08 14:30:06
         */

        private String applyno;
        private String HospNo;
        private String itemname;
        private String result;
        private String referencerange;
        private String highlowflag;
        private String reporttitle;
        private String resultdate;
        private String resulttime;

        public String getApplyno() {
            return applyno;
        }

        public void setApplyno(String applyno) {
            this.applyno = applyno;
        }

        public String getHospNo() {
            return HospNo;
        }

        public void setHospNo(String HospNo) {
            this.HospNo = HospNo;
        }

        public String getItemname() {
            return itemname;
        }

        public void setItemname(String itemname) {
            this.itemname = itemname;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getReferencerange() {
            return referencerange;
        }

        public void setReferencerange(String referencerange) {
            this.referencerange = referencerange;
        }

        public String getHighlowflag() {
            return highlowflag;
        }

        public void setHighlowflag(String highlowflag) {
            this.highlowflag = highlowflag;
        }

        public String getReporttitle() {
            return reporttitle;
        }

        public void setReporttitle(String reporttitle) {
            this.reporttitle = reporttitle;
        }

        public String getResultdate() {
            return resultdate;
        }

        public void setResultdate(String resultdate) {
            this.resultdate = resultdate;
        }

        public String getResulttime() {
            return resulttime;
        }

        public void setResulttime(String resulttime) {
            this.resulttime = resulttime;
        }
    }
}
