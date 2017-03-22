package com.siweisoft.app.ui.bed.advice.bean.resbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-03-21.
 */

public class AdviceTaskResBean extends ResultResBean {


    private ArrayList<DataBean> data;

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * name : 静脉输液
         * bedno : 0308
         * id : 1892701
         * groupid : 1001
         * groupname : 用药
         * taskname : 102265
         * 医嘱ID : cq_2754766
         * 住院号 : 929462
         * 组号 : cq_2754766
         * 医嘱类别代码 : 0
         * 医嘱类别名称 : 药品
         * 医嘱详情 : 氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)
         * 西力欣 2.25g (共3瓶) 静滴(配)
         * 审核状态 : 执行
         * review_status2 :
         * 开始时间 : 2017-03-21 08:00:00
         * 结束时间 : 2017-03-22 08:00:00
         * 发放途径 :
         * 姓名 :
         * key : qd
         * convertattime : 1481166482
         * time_from : 2017-03-21 08:00:00
         * user_change_time_from :
         * time_to : 2017-03-22 08:00:00
         * uuid : 35047d5316c979ea3c493c1288f78bf5
         * status : T
         * user_id : 4395
         * coeff : 1
         * exectime : 2017-03-21 10:59:37
         * nurse_type : -1
         * update_nurse_type : 0
         * view_id :
         * view_type : 0
         * view_creator :
         * update_view_type : 0
         * wardid :
         * time_from2 :
         * CompleteWay :
         * check_status : T
         * check_uid : 4395
         * checktime : 2017-03-21 10:00:00
         * CheckWay :
         * from_date : 2017-03-21 08:00:00
         * to_date : 2017-03-22 08:00:00
         * dicttype : time
         */

        private String name;
        private String bedno;
        private String id;
        private String groupid;
        private String groupname;
        private String taskname;
        private String 医嘱ID;
        private String 住院号;
        private String 组号;
        private String 医嘱类别代码;
        private String 医嘱类别名称;
        private String 医嘱详情;
        private String 审核状态;
        private String review_status2;
        private String 开始时间;
        private String 结束时间;
        private String 发放途径;
        private String 姓名;
        private String key;
        private String convertattime;
        private String time_from;
        private String user_change_time_from;
        private String time_to;
        private String uuid;
        private String status;
        private String user_id;
        private String coeff;
        private String exectime;
        private String nurse_type;
        private String update_nurse_type;
        private String view_id;
        private String view_type;
        private String view_creator;
        private String update_view_type;
        private String wardid;
        private String time_from2;
        private String CompleteWay;
        private String check_status;
        private String check_uid;
        private String checktime;
        private String CheckWay;
        private String from_date;
        private String to_date;
        private String dicttype;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBedno() {
            return bedno;
        }

        public void setBedno(String bedno) {
            this.bedno = bedno;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getTaskname() {
            return taskname;
        }

        public void setTaskname(String taskname) {
            this.taskname = taskname;
        }

        public String get医嘱ID() {
            return 医嘱ID;
        }

        public void set医嘱ID(String 医嘱ID) {
            this.医嘱ID = 医嘱ID;
        }

        public String get住院号() {
            return 住院号;
        }

        public void set住院号(String 住院号) {
            this.住院号 = 住院号;
        }

        public String get组号() {
            return 组号;
        }

        public void set组号(String 组号) {
            this.组号 = 组号;
        }

        public String get医嘱类别代码() {
            return 医嘱类别代码;
        }

        public void set医嘱类别代码(String 医嘱类别代码) {
            this.医嘱类别代码 = 医嘱类别代码;
        }

        public String get医嘱类别名称() {
            return 医嘱类别名称;
        }

        public void set医嘱类别名称(String 医嘱类别名称) {
            this.医嘱类别名称 = 医嘱类别名称;
        }

        public String get医嘱详情() {
            return 医嘱详情;
        }

        public void set医嘱详情(String 医嘱详情) {
            this.医嘱详情 = 医嘱详情;
        }

        public String get审核状态() {
            return 审核状态;
        }

        public void set审核状态(String 审核状态) {
            this.审核状态 = 审核状态;
        }

        public String getReview_status2() {
            return review_status2;
        }

        public void setReview_status2(String review_status2) {
            this.review_status2 = review_status2;
        }

        public String get开始时间() {
            return 开始时间;
        }

        public void set开始时间(String 开始时间) {
            this.开始时间 = 开始时间;
        }

        public String get结束时间() {
            return 结束时间;
        }

        public void set结束时间(String 结束时间) {
            this.结束时间 = 结束时间;
        }

        public String get发放途径() {
            return 发放途径;
        }

        public void set发放途径(String 发放途径) {
            this.发放途径 = 发放途径;
        }

        public String get姓名() {
            return 姓名;
        }

        public void set姓名(String 姓名) {
            this.姓名 = 姓名;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getConvertattime() {
            return convertattime;
        }

        public void setConvertattime(String convertattime) {
            this.convertattime = convertattime;
        }

        public String getTime_from() {
            return time_from;
        }

        public void setTime_from(String time_from) {
            this.time_from = time_from;
        }

        public String getUser_change_time_from() {
            return user_change_time_from;
        }

        public void setUser_change_time_from(String user_change_time_from) {
            this.user_change_time_from = user_change_time_from;
        }

        public String getTime_to() {
            return time_to;
        }

        public void setTime_to(String time_to) {
            this.time_to = time_to;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getCoeff() {
            return coeff;
        }

        public void setCoeff(String coeff) {
            this.coeff = coeff;
        }

        public String getExectime() {
            return exectime;
        }

        public void setExectime(String exectime) {
            this.exectime = exectime;
        }

        public String getNurse_type() {
            return nurse_type;
        }

        public void setNurse_type(String nurse_type) {
            this.nurse_type = nurse_type;
        }

        public String getUpdate_nurse_type() {
            return update_nurse_type;
        }

        public void setUpdate_nurse_type(String update_nurse_type) {
            this.update_nurse_type = update_nurse_type;
        }

        public String getView_id() {
            return view_id;
        }

        public void setView_id(String view_id) {
            this.view_id = view_id;
        }

        public String getView_type() {
            return view_type;
        }

        public void setView_type(String view_type) {
            this.view_type = view_type;
        }

        public String getView_creator() {
            return view_creator;
        }

        public void setView_creator(String view_creator) {
            this.view_creator = view_creator;
        }

        public String getUpdate_view_type() {
            return update_view_type;
        }

        public void setUpdate_view_type(String update_view_type) {
            this.update_view_type = update_view_type;
        }

        public String getWardid() {
            return wardid;
        }

        public void setWardid(String wardid) {
            this.wardid = wardid;
        }

        public String getTime_from2() {
            return time_from2;
        }

        public void setTime_from2(String time_from2) {
            this.time_from2 = time_from2;
        }

        public String getCompleteWay() {
            return CompleteWay;
        }

        public void setCompleteWay(String CompleteWay) {
            this.CompleteWay = CompleteWay;
        }

        public String getCheck_status() {
            return check_status;
        }

        public void setCheck_status(String check_status) {
            this.check_status = check_status;
        }

        public String getCheck_uid() {
            return check_uid;
        }

        public void setCheck_uid(String check_uid) {
            this.check_uid = check_uid;
        }

        public String getChecktime() {
            return checktime;
        }

        public void setChecktime(String checktime) {
            this.checktime = checktime;
        }

        public String getCheckWay() {
            return CheckWay;
        }

        public void setCheckWay(String CheckWay) {
            this.CheckWay = CheckWay;
        }

        public String getFrom_date() {
            return from_date;
        }

        public void setFrom_date(String from_date) {
            this.from_date = from_date;
        }

        public String getTo_date() {
            return to_date;
        }

        public void setTo_date(String to_date) {
            this.to_date = to_date;
        }

        public String getDicttype() {
            return dicttype;
        }

        public void setDicttype(String dicttype) {
            this.dicttype = dicttype;
        }
    }
}
