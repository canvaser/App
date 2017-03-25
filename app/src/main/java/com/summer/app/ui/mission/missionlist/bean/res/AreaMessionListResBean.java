package com.summer.app.ui.mission.missionlist.bean.res;


import com.summer.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AreaMessionListResBean extends ResultResBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * zyh : 928999
         * start : 2017-02-28 11:00:00
         * end : 2017-02-28 11:00:00
         * regionId : 0250030
         * roomId :
         * bedId : 0353
         * name : 缪连锁
         * codename : 补液卡
         * titles : [{"医嘱ID":"1949794","id":"1949795","contents":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)[补液卡]","title":"氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)\n西力欣 2.25g (共3瓶) 静滴(配)[补液卡]","taskname":"增加补液卡","key":"ST","status":"N","displayname":"唐杰","nurse_type":"其他","view_type":"","exectime":"2017-02-28 10:42:41","creator":""}]
         */

        private String zyh;
        private String start;
        private String end;
        private String regionId;
        private String roomId;
        private String bedId;
        private String name;
        private String codename;
        private List<TitlesBean> titles;
        private boolean clickable = true;


        public boolean isClickable() {
            return clickable;
        }

        public void setClickable(boolean clickable) {
            this.clickable = clickable;
        }

        public String getZyh() {
            return zyh;
        }

        public void setZyh(String zyh) {
            this.zyh = zyh;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getBedId() {
            return bedId;
        }

        public void setBedId(String bedId) {
            this.bedId = bedId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCodename() {
            return codename;
        }

        public void setCodename(String codename) {
            this.codename = codename;
        }

        public List<TitlesBean> getTitles() {
            return titles;
        }

        public void setTitles(List<TitlesBean> titles) {
            this.titles = titles;
        }

        public static class TitlesBean implements Serializable {
            /**
             * 医嘱ID : 1949794
             * id : 1949795
             * contents : 氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)
             * 西力欣 2.25g (共3瓶) 静滴(配)[补液卡]
             * title : 氯化钠0.9%(浙江) 250 (共1袋) 静滴(配)
             * 西力欣 2.25g (共3瓶) 静滴(配)[补液卡]
             * taskname : 增加补液卡
             * key : ST
             * status : N
             * displayname : 唐杰
             * nurse_type : 其他
             * view_type :
             * exectime : 2017-02-28 10:42:41
             * creator :
             */

            private String 医嘱ID;
            private String id;
            private String contents;
            private String title;
            private String taskname;
            private String key;
            private String status;
            private String displayname;
            private String nurse_type;
            private String view_type;
            private String exectime;
            private String creator;
            private boolean isSelect;

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            public String get医嘱ID() {
                return 医嘱ID;
            }

            public void set医嘱ID(String 医嘱ID) {
                this.医嘱ID = 医嘱ID;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTaskname() {
                return taskname;
            }

            public void setTaskname(String taskname) {
                this.taskname = taskname;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDisplayname() {
                return displayname;
            }

            public void setDisplayname(String displayname) {
                this.displayname = displayname;
            }

            public String getNurse_type() {
                return nurse_type;
            }

            public void setNurse_type(String nurse_type) {
                this.nurse_type = nurse_type;
            }

            public String getView_type() {
                return view_type;
            }

            public void setView_type(String view_type) {
                this.view_type = view_type;
            }

            public String getExectime() {
                return exectime;
            }

            public void setExectime(String exectime) {
                this.exectime = exectime;
            }

            public String getCreator() {
                return creator;
            }

            public void setCreator(String creator) {
                this.creator = creator;
            }
        }
    }
}
