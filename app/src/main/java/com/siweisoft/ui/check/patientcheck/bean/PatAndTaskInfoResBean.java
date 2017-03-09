package com.siweisoft.ui.check.patientcheck.bean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;
import com.siweisoft.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-03-08.
 */

public class PatAndTaskInfoResBean extends ResultResBean {


    /**
     * data : {"PatInfo":{"病床号":"0308","病床名":"08","关联病区号":"0250030","关联病房号":"","病人住院号":"929462","CPOEZYH":"864253","状态":"占床","流水号":"929462","病历号":"133004002039546","姓名":"马和平","性别":"男","护理代码":"","护理级别名称":"三级护理","出生日期":"1961-05-12 00:00:00","patAge":56,"住院号":"929462","就诊类型代码":"","就诊类型名称":"自费","入院时间":"2016-12-08 09:14:24","出院时间":"","就诊卡号":"133004002039546","病区代码":"0250030","病房号":"","入院诊断代码":"","诊断名称":"鼻息肉","diag_text":"","医保分类代码":"0","sensitiveCodes":null,"additionCodes":[],"联系电话":"","危重级别":"一般","LA54":["2016-12-09 08:00:00"],"LS31":"三小时后半流质"},"TaskInfo":[{"zyh":"929462","start":"2017-03-07 08:00:00","end":"2017-03-07 08:00:00","regionId":"0250030","roomId":"0","bedId":"0","name":"马和平","codename":"药品","titles":[{"医嘱ID":"cq_2754766","id":"1892701","contents":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","title":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","taskname":"静脉输液","key":"QD","status":"T","displayname":"李博文","nurse_type":"静滴","view_type":"","exectime":"2017-03-07 17:37:07","creator":""}]},{"zyh":"929462","start":"2017-03-08 08:00:00","end":"2017-03-08 08:00:00","regionId":"0250030","roomId":"0","bedId":"0","name":"马和平","codename":"药品","titles":[{"医嘱ID":"cq_2754766","id":"1899035","contents":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","title":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","taskname":"静脉输液","key":"QD","status":"F","displayname":"","nurse_type":"静滴","view_type":"","exectime":"","creator":""}]}]}
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
         * PatInfo : {"病床号":"0308","病床名":"08","关联病区号":"0250030","关联病房号":"","病人住院号":"929462","CPOEZYH":"864253","状态":"占床","流水号":"929462","病历号":"133004002039546","姓名":"马和平","性别":"男","护理代码":"","护理级别名称":"三级护理","出生日期":"1961-05-12 00:00:00","patAge":56,"住院号":"929462","就诊类型代码":"","就诊类型名称":"自费","入院时间":"2016-12-08 09:14:24","出院时间":"","就诊卡号":"133004002039546","病区代码":"0250030","病房号":"","入院诊断代码":"","诊断名称":"鼻息肉","diag_text":"","医保分类代码":"0","sensitiveCodes":null,"additionCodes":[],"联系电话":"","危重级别":"一般","LA54":["2016-12-09 08:00:00"],"LS31":"三小时后半流质"}
         * TaskInfo : [{"zyh":"929462","start":"2017-03-07 08:00:00","end":"2017-03-07 08:00:00","regionId":"0250030","roomId":"0","bedId":"0","name":"马和平","codename":"药品","titles":[{"医嘱ID":"cq_2754766","id":"1892701","contents":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","title":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","taskname":"静脉输液","key":"QD","status":"T","displayname":"李博文","nurse_type":"静滴","view_type":"","exectime":"2017-03-07 17:37:07","creator":""}]},{"zyh":"929462","start":"2017-03-08 08:00:00","end":"2017-03-08 08:00:00","regionId":"0250030","roomId":"0","bedId":"0","name":"马和平","codename":"药品","titles":[{"医嘱ID":"cq_2754766","id":"1899035","contents":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","title":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)","taskname":"静脉输液","key":"QD","status":"F","displayname":"","nurse_type":"静滴","view_type":"","exectime":"","creator":""}]}]
         */

        private PatInfoBean PatInfo;
        private List<AreaMessionListResBean.DataBean> TaskInfo;

        public PatInfoBean getPatInfo() {
            return PatInfo;
        }

        public void setPatInfo(PatInfoBean PatInfo) {
            this.PatInfo = PatInfo;
        }

        public List<AreaMessionListResBean.DataBean> getTaskInfo() {
            return TaskInfo;
        }

        public void setTaskInfo(List<AreaMessionListResBean.DataBean> taskInfo) {
            TaskInfo = taskInfo;
        }

        public static class PatInfoBean implements Serializable {
            /**
             * 病床号 : 0308
             * 病床名 : 08
             * 关联病区号 : 0250030
             * 关联病房号 :
             * 病人住院号 : 929462
             * CPOEZYH : 864253
             * 状态 : 占床
             * 流水号 : 929462
             * 病历号 : 133004002039546
             * 姓名 : 马和平
             * 性别 : 男
             * 护理代码 :
             * 护理级别名称 : 三级护理
             * 出生日期 : 1961-05-12 00:00:00
             * patAge : 56
             * 住院号 : 929462
             * 就诊类型代码 :
             * 就诊类型名称 : 自费
             * 入院时间 : 2016-12-08 09:14:24
             * 出院时间 :
             * 就诊卡号 : 133004002039546
             * 病区代码 : 0250030
             * 病房号 :
             * 入院诊断代码 :
             * 诊断名称 : 鼻息肉
             * diag_text :
             * 医保分类代码 : 0
             * sensitiveCodes : null
             * additionCodes : []
             * 联系电话 :
             * 危重级别 : 一般
             * LA54 : ["2016-12-09 08:00:00"]
             * LS31 : 三小时后半流质
             */

            private String 病床号;
            private String 病床名;
            private String 关联病区号;
            private String 关联病房号;
            private String 病人住院号;
            private String CPOEZYH;
            private String 状态;
            private String 流水号;
            private String 病历号;
            private String 姓名;
            private String 性别;
            private String 护理代码;
            private String 护理级别名称;
            private String 出生日期;
            private int patAge;
            private String 住院号;
            private String 就诊类型代码;
            private String 就诊类型名称;
            private String 入院时间;
            private String 出院时间;
            private String 就诊卡号;
            private String 病区代码;
            private String 病房号;
            private String 入院诊断代码;
            private String 诊断名称;
            private String diag_text;
            private String 医保分类代码;
            private String sensitiveCodes;
            private String 联系电话;
            private String 危重级别;
            private String LS31;
            private List<String> additionCodes;
            private List<String> LA54;
            private int resId;

            public List<String> getAdditionCodes() {
                return additionCodes;
            }

            public void setAdditionCodes(List<String> additionCodes) {
                this.additionCodes = additionCodes;
            }

            public String getCPOEZYH() {
                return CPOEZYH;
            }

            public void setCPOEZYH(String CPOEZYH) {
                this.CPOEZYH = CPOEZYH;
            }

            public String getDiag_text() {
                return diag_text;
            }

            public void setDiag_text(String diag_text) {
                this.diag_text = diag_text;
            }

            public List<String> getLA54() {
                return LA54;
            }

            public void setLA54(List<String> LA54) {
                this.LA54 = LA54;
            }

            public String getLS31() {
                return LS31;
            }

            public void setLS31(String LS31) {
                this.LS31 = LS31;
            }

            public int getPatAge() {
                return patAge;
            }

            public void setPatAge(int patAge) {
                this.patAge = patAge;
            }

            public String getSensitiveCodes() {
                return sensitiveCodes;
            }

            public void setSensitiveCodes(String sensitiveCodes) {
                this.sensitiveCodes = sensitiveCodes;
            }

            public String get住院号() {
                return 住院号;
            }

            public void set住院号(String 住院号) {
                this.住院号 = 住院号;
            }

            public String get入院时间() {
                return 入院时间;
            }

            public void set入院时间(String 入院时间) {
                this.入院时间 = 入院时间;
            }

            public String get入院诊断代码() {
                return 入院诊断代码;
            }

            public void set入院诊断代码(String 入院诊断代码) {
                this.入院诊断代码 = 入院诊断代码;
            }

            public String get关联病区号() {
                return 关联病区号;
            }

            public void set关联病区号(String 关联病区号) {
                this.关联病区号 = 关联病区号;
            }

            public String get关联病房号() {
                return 关联病房号;
            }

            public void set关联病房号(String 关联病房号) {
                this.关联病房号 = 关联病房号;
            }

            public String get出生日期() {
                return 出生日期;
            }

            public void set出生日期(String 出生日期) {
                this.出生日期 = 出生日期;
            }

            public String get出院时间() {
                return 出院时间;
            }

            public void set出院时间(String 出院时间) {
                this.出院时间 = 出院时间;
            }

            public String get医保分类代码() {
                return 医保分类代码;
            }

            public void set医保分类代码(String 医保分类代码) {
                this.医保分类代码 = 医保分类代码;
            }

            public String get危重级别() {
                return 危重级别;
            }

            public void set危重级别(String 危重级别) {
                this.危重级别 = 危重级别;
            }

            public String get姓名() {
                return 姓名;
            }

            public void set姓名(String 姓名) {
                this.姓名 = 姓名;
            }

            public String get就诊卡号() {
                return 就诊卡号;
            }

            public void set就诊卡号(String 就诊卡号) {
                this.就诊卡号 = 就诊卡号;
            }

            public String get就诊类型代码() {
                return 就诊类型代码;
            }

            public void set就诊类型代码(String 就诊类型代码) {
                this.就诊类型代码 = 就诊类型代码;
            }

            public String get就诊类型名称() {
                return 就诊类型名称;
            }

            public void set就诊类型名称(String 就诊类型名称) {
                this.就诊类型名称 = 就诊类型名称;
            }

            public String get性别() {
                return 性别;
            }

            public void set性别(String 性别) {
                this.性别 = 性别;
            }

            public String get护理代码() {
                return 护理代码;
            }

            public void set护理代码(String 护理代码) {
                this.护理代码 = 护理代码;
            }

            public String get护理级别名称() {
                return 护理级别名称;
            }

            public void set护理级别名称(String 护理级别名称) {
                this.护理级别名称 = 护理级别名称;
            }

            public String get流水号() {
                return 流水号;
            }

            public void set流水号(String 流水号) {
                this.流水号 = 流水号;
            }

            public String get状态() {
                return 状态;
            }

            public void set状态(String 状态) {
                this.状态 = 状态;
            }

            public String get病人住院号() {
                return 病人住院号;
            }

            public void set病人住院号(String 病人住院号) {
                this.病人住院号 = 病人住院号;
            }

            public String get病区代码() {
                return 病区代码;
            }

            public void set病区代码(String 病区代码) {
                this.病区代码 = 病区代码;
            }

            public String get病历号() {
                return 病历号;
            }

            public void set病历号(String 病历号) {
                this.病历号 = 病历号;
            }

            public String get病床号() {
                return 病床号;
            }

            public void set病床号(String 病床号) {
                this.病床号 = 病床号;
            }

            public String get病床名() {
                return 病床名;
            }

            public void set病床名(String 病床名) {
                this.病床名 = 病床名;
            }

            public String get病房号() {
                return 病房号;
            }

            public void set病房号(String 病房号) {
                this.病房号 = 病房号;
            }

            public String get联系电话() {
                return 联系电话;
            }

            public void set联系电话(String 联系电话) {
                this.联系电话 = 联系电话;
            }

            public String get诊断名称() {
                return 诊断名称;
            }

            public void set诊断名称(String 诊断名称) {
                this.诊断名称 = 诊断名称;
            }

            public int getResId() {
                return resId;
            }

            public void setResId(int resId) {
                this.resId = resId;
            }
        }

    }
}
