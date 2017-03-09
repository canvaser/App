package com.siweisoft.ui.addwater.addwater.bean.netbean;

import com.siweisoft.lib.base.ui.bean.ResultResBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterListResBean extends ResultResBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1898559
         * advCon : 氯化钠0.9%(浙江) 1500ml (12月11号8点挂)  (共3袋) 静滴
         * start : 2016-12-09 14:16:14
         * name : 周克俊
         * bedno : 0335
         * wardcode : 0250030
         * wardname : 三病区
         * resultid : ["1487294475658807891","1487302612370850302","148730276154092130","1487305808165261362"]
         * files : [[{"resultid":"1487294475658807891","user_id":"4190","user_name":"李博文","termid":"87","termname":"时间","value":"2017-02-17 09:19","zyh":"929182","coeff":"1","type":"date","suffix":"","exectime":"2017-02-17 09:21:15"},{"resultid":"1487294475658807891","user_id":"4190","user_name":"李博文","termid":"88","termname":"补液内容","value":"我们要学会坚强","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 09:21:15"},{"resultid":"1487294475658807891","user_id":"4190","user_name":"李博文","termid":"89","termname":"补液情况","value":"我们要学会坚强","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 09:21:15"},{"resultid":"1487294475658807891","user_id":"4190","user_name":"李博文","termid":"90","termname":"滴速","value":"50","zyh":"929182","coeff":"1","type":"text","suffix":"滴/分","exectime":"2017-02-17 09:21:15"},{"resultid":"1487294475658807891","user_id":"4190","user_name":"李博文","termid":"91","termname":"剩余补液量","value":"1000","zyh":"929182","coeff":"1","type":"text","suffix":"ml","exectime":"2017-02-17 09:21:15"}],[{"resultid":"1487302612370850302","user_id":"4190","user_name":"李博文","termid":"87","termname":"时间","value":"2017-02-17 11:36","zyh":"929182","coeff":"1","type":"date","suffix":"","exectime":"2017-02-17 11:36:52"},{"resultid":"1487302612370850302","user_id":"4190","user_name":"李博文","termid":"88","termname":"补液内容","value":"red","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 11:36:52"},{"resultid":"1487302612370850302","user_id":"4190","user_name":"李博文","termid":"89","termname":"补液情况","value":"dddd","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 11:36:52"},{"resultid":"1487302612370850302","user_id":"4190","user_name":"李博文","termid":"90","termname":"滴速","value":"55","zyh":"929182","coeff":"1","type":"text","suffix":"滴/分","exectime":"2017-02-17 11:36:52"},{"resultid":"1487302612370850302","user_id":"4190","user_name":"李博文","termid":"91","termname":"剩余补液量","value":"656.44","zyh":"929182","coeff":"1","type":"text","suffix":"ml","exectime":"2017-02-17 11:36:52"}],[{"resultid":"148730276154092130","user_id":"4190","user_name":"李博文","termid":"87","termname":"时间","value":"2017-02-17 11:38","zyh":"929182","coeff":"1","type":"date","suffix":"","exectime":"2017-02-17 11:39:21"},{"resultid":"148730276154092130","user_id":"4190","user_name":"李博文","termid":"88","termname":"补液内容","value":"week","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 11:39:21"},{"resultid":"148730276154092130","user_id":"4190","user_name":"李博文","termid":"89","termname":"补液情况","value":"yogi hi","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 11:39:21"},{"resultid":"148730276154092130","user_id":"4190","user_name":"李博文","termid":"90","termname":"滴速","value":"55","zyh":"929182","coeff":"1","type":"text","suffix":"滴/分","exectime":"2017-02-17 11:39:21"},{"resultid":"148730276154092130","user_id":"4190","user_name":"李博文","termid":"91","termname":"剩余补液量","value":"0.00","zyh":"929182","coeff":"1","type":"text","suffix":"ml","exectime":"2017-02-17 11:39:21"}],[{"resultid":"1487305808165261362","user_id":"4190","user_name":"李博文","termid":"87","termname":"时间","value":"2017-02-17 12:29","zyh":"929182","coeff":"1","type":"date","suffix":"","exectime":"2017-02-17 12:30:08"},{"resultid":"1487305808165261362","user_id":"4190","user_name":"李博文","termid":"88","termname":"补液内容","value":"we","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 12:30:08"},{"resultid":"1487305808165261362","user_id":"4190","user_name":"李博文","termid":"89","termname":"补液情况","value":"外溢","zyh":"929182","coeff":"1","type":"text","suffix":"","exectime":"2017-02-17 12:30:08"},{"resultid":"1487305808165261362","user_id":"4190","user_name":"李博文","termid":"90","termname":"滴速","value":"70","zyh":"929182","coeff":"1","type":"text","suffix":"滴/分","exectime":"2017-02-17 12:30:08"},{"resultid":"1487305808165261362","user_id":"4190","user_name":"李博文","termid":"91","termname":"剩余补液量","value":"25","zyh":"929182","coeff":"1","type":"text","suffix":"ml","exectime":"2017-02-17 12:30:08"}]]
         */

        private String id;
        private String advCon;
        private String start;
        private String name;
        private String bedno;
        private String wardcode;
        private String wardname;
        private List<String> resultid;
        private List<List<FilesBean>> files;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAdvCon() {
            return advCon;
        }

        public void setAdvCon(String advCon) {
            this.advCon = advCon;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

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

        public List<String> getResultid() {
            return resultid;
        }

        public void setResultid(List<String> resultid) {
            this.resultid = resultid;
        }

        public List<List<FilesBean>> getFiles() {
            return files;
        }

        public void setFiles(List<List<FilesBean>> files) {
            this.files = files;
        }

        public static class FilesBean implements Serializable {
            /**
             * resultid : 1487294475658807891
             * user_id : 4190
             * user_name : 李博文
             * termid : 87
             * termname : 时间
             * value : 2017-02-17 09:19
             * zyh : 929182
             * coeff : 1
             * type : date
             * suffix :
             * exectime : 2017-02-17 09:21:15
             */

            private String resultid;
            private String user_id;
            private String user_name;
            private String termid;
            private String termname;
            private String value;
            private String zyh;
            private String coeff;
            private String type;
            private String suffix;
            private String exectime;

            public String getResultid() {
                return resultid;
            }

            public void setResultid(String resultid) {
                this.resultid = resultid;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getTermid() {
                return termid;
            }

            public void setTermid(String termid) {
                this.termid = termid;
            }

            public String getTermname() {
                return termname;
            }

            public void setTermname(String termname) {
                this.termname = termname;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getZyh() {
                return zyh;
            }

            public void setZyh(String zyh) {
                this.zyh = zyh;
            }

            public String getCoeff() {
                return coeff;
            }

            public void setCoeff(String coeff) {
                this.coeff = coeff;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public String getExectime() {
                return exectime;
            }

            public void setExectime(String exectime) {
                this.exectime = exectime;
            }
        }
    }
}
