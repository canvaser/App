package com.siweisoft.nurse.ui.bed.persontask.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseOpe;
import com.siweisoft.lib.util.data.DateFormatUtil;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class MyMissionDAOpe extends BaseOpe {


    private String date;

    private String wayType = "全部";

    String[] missionSortStr;


    HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list = new HashMap<>();

    HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> tempList = new HashMap<>();

    public static String[] TIME_TYPE = new String[]{"全部", "临时", "长期"};

    public static String[] WAY_TYPE;

    private String timeType = TIME_TYPE[0];


    public MyMissionDAOpe(Context context) {
        super(context);
        setDate(DateFormatUtil.getnowTimeYYYYMMdd());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getWayType() {
        return wayType;
    }

    public void setWayType(String wayType) {
        this.wayType = wayType;
    }

    public HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> getList() {
        return tempList;
    }

    public void setList(HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> list) {
        this.list.clear();
        this.list.putAll(list);
        tempList.clear();
        tempList.putAll(list);
    }

    public HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> sort() {
        HashMap<String, ArrayList<AreaMessionListResBean.DataBean>> map = new HashMap<>();
        String[] strings = new String[list.keySet().size()];
        strings = list.keySet().toArray(strings);
        for (int i = 0; i < strings.length; i++) {
            if (map.get(strings[i]) == null) {
                map.put(strings[i], new ArrayList<AreaMessionListResBean.DataBean>());
            }
            ArrayList<AreaMessionListResBean.DataBean> ll = list.get(strings[i]);
            for (int j = 0; j < ll.size(); j++) {
                if (ll.get(j).getTitles() != null && ll.get(j).getTitles().size() > 0) {
                    if (wayType.contains(ll.get(j).getTitles().get(0).getTaskname()) || wayType.equals(TIME_TYPE[0])) {
                        String s = "";
                        if ("st".equals(ll.get(j).getTitles().get(0).getKey().toLowerCase()) || ll.get(j).getCodename().equals("出院带药")) {
                            s = "临时";
                        } else {
                            s = "长期";
                        }
                        if (s.equals(timeType) || timeType.equals("全部")) {
                            map.get(strings[i]).add(ll.get(j));
                        }
                    } else if (wayType.equals("其他")) {
                        boolean y = true;
                        for (int n = 0; n < missionSortStr.length; n++) {
                            if (!missionSortStr[n].equals("其他")) {
                                if (ll.get(j).getTitles().get(0).getTaskname().equals(missionSortStr[n])) {
                                    y = false;
                                    break;
                                }
                            }
                        }
                        if (y) {
                            map.get(strings[i]).add(ll.get(j));
                        }
                    }
                }
            }
        }
        tempList.clear();
        tempList.putAll(map);
        return tempList;
    }

    public String[] addString(String[] s) {
        String[] ss = new String[s.length + 1];
        ss[0] = "全部";
        for (int i = 0; i < s.length; i++) {
            ss[i + 1] = s[i];
        }
        return ss;
    }

    public void setMissionSortStr(String[] missionSortStr) {
        this.missionSortStr = missionSortStr;
    }
}
