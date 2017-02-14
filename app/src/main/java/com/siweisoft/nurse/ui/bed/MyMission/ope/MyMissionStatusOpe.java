package com.siweisoft.nurse.ui.bed.MyMission.ope;

import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionResBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class MyMissionStatusOpe {

    public static String  STATUS_FINISHED ="T";

    public static String  STATUS_FINISHED_NOT ="F";

    public static String  STATUS_DELETE ="S";

    public static String  STATUS_REFUSE ="R";

    public static String  STATUS_ABSENT ="N";

    public static ArrayList<String> STATUS_LIST = new ArrayList<>();

    public static ArrayList<String> STATUS_LIST_STR = new ArrayList<>();

    static {
        STATUS_LIST.add(STATUS_FINISHED);
        STATUS_LIST.add(STATUS_DELETE);
        STATUS_LIST.add(STATUS_REFUSE);
        STATUS_LIST.add(STATUS_ABSENT);
        STATUS_LIST.add(STATUS_FINISHED_NOT);
    }

    static {
        STATUS_LIST_STR.add("已完成");
        STATUS_LIST_STR.add("已删除");
        STATUS_LIST_STR.add("病人拒绝");
        STATUS_LIST_STR.add("病人不在");
        STATUS_LIST_STR.add("未完成");
    }


    private HashMap<String,ArrayList<AreaMessionResBean>> list=new HashMap<>();

    public HashMap<String,ArrayList<AreaMessionResBean>> sortStatus(ArrayList<AreaMessionResBean> data){
            for(int i=0;i<data.size();i++){
                if(list.get(data.get(i).getTitles().get(0).getStatus())==null){
                    list.put(data.get(i).getTitles().get(0).getStatus(),new ArrayList<AreaMessionResBean>());
                }
                list.get(data.get(i).getTitles().get(0).getStatus()).add(data.get(i));
            }
        return list;
    }
}
