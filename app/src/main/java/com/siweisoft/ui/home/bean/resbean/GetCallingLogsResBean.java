package com.siweisoft.ui.home.bean.resbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class GetCallingLogsResBean extends ResultResBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 16352
         * bedid : 0451
         * name : 孙友国
         * zyh : 925800
         * roomid : 0
         * regionid : 0250040
         * starttime : 2016-11-10 17:02:41
         * stoptime : 2016-11-10 17:02:41
         * status : 0
         * comment :
         */

        private String id;
        private String bedid;
        private String name;
        private String zyh;
        private String roomid;
        private String regionid;
        private String starttime;
        private String stoptime;
        private String status;
        private String comment;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBedid() {
            return bedid;
        }

        public void setBedid(String bedid) {
            this.bedid = bedid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZyh() {
            return zyh;
        }

        public void setZyh(String zyh) {
            this.zyh = zyh;
        }

        public String getRoomid() {
            return roomid;
        }

        public void setRoomid(String roomid) {
            this.roomid = roomid;
        }

        public String getRegionid() {
            return regionid;
        }

        public void setRegionid(String regionid) {
            this.regionid = regionid;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getStoptime() {
            return stoptime;
        }

        public void setStoptime(String stoptime) {
            this.stoptime = stoptime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
