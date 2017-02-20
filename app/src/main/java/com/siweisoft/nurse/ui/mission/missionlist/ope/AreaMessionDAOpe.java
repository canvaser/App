package com.siweisoft.nurse.ui.mission.missionlist.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.check.checklist.bean.resbean.CheckResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionTitleResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class AreaMessionDAOpe extends BaseDAOpe{


    public String myPatientTodayData =null;

    public String myAreaTodayData=null;

    public String myPatientHistoryData =null;

    public String myAreaHistoryData =null;

    public String leftType =ALL;

    public String rightSort =ALL;


    public String areaType = AREA_TYPE_AREA;

    public String timeArea = TIME_TODAY;

    public String count = COUNT_ALL;

    public static final String COUNT_ALL ="全部";

    public static final String COUNT_LONG ="长期";

    public static final String COUNT_LIN ="临时";

    public static final String   ALL ="全部";

    public static final String  TIME_TODAY ="今日";

    public static final String  TIME_HISTORY ="历史";

    public static final String  AREA_TYPE_AREA ="病区";

    public static final String  AREA_TYPE_MY_PATIENT ="我的病人";

    public static HashMap<String,String> hashMap = new HashMap<>();

    private ArrayList<AreaMissionListAdapterBean> missionData;

    public AreaMessionDAOpe(Context context) {
        super(context);
    }

    public ArrayList<AreaMissionListAdapterBean> initData(ArrayList<AreaMissionListAdapterBean> res){
        if(res==null){
            return res;
        }
        GetallregionbyuserResBean.Data data = MethodValue.getArea();
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).getData().size();j++){
                String bedid = res.get(i).getData().get(j).getBedId();
                res.get(i).getData().get(j).setBedId(data.getWardname()+bedid.substring(2,bedid.length())+"床");
            }
        }
        return res;
    }

    public String getIDs(ArrayList<AreaMessionTitleResBean> data){
        String s = "";
        for(int i=0;i<data.size();i++){
            s+=data.get(i).getId();
            s+=",";
        }
        if(s.endsWith(",")){
            s.substring(0,s.length()-1);
        }
        return s;
    }

    public void setCacheData(String type,String data){
        switch (type){
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_AREA:
                myAreaTodayData= data;
                break;
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                myPatientTodayData= data;
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_AREA:
                myAreaHistoryData= data;
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                myPatientHistoryData= data;
                break;
        }
    }

    public String getCahceData(String type){
        String s = null;
        switch (type){
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_AREA:
                s= myAreaTodayData;
                break;
            case AreaMessionDAOpe.TIME_TODAY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                s=myPatientTodayData;
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_AREA:
                s=myAreaHistoryData;
                break;
            case AreaMessionDAOpe.TIME_HISTORY+AreaMessionDAOpe.AREA_TYPE_MY_PATIENT:
                s=myPatientHistoryData;
                break;
        }
        return s;
    }

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }

    static {
        hashMap.put("全部",AreaMessionDAOpe.ALL);
        hashMap.put("完成", DataValue.STATUS_YI_WAN_CHENG);
        hashMap.put("未完",AreaMessionDAOpe.ALL);
        hashMap.put("删除",DataValue.SSTATUS_SHAN_CHU);
        hashMap.put("拒绝",DataValue.STATUS_BING_REN_JU_JUE);
        hashMap.put("不在",DataValue.STATUS_BING_REN_BU_ZAI);
        hashMap.put("历史",AreaMessionDAOpe.ALL);

    }

    public ArrayList<AreaMissionListAdapterBean> getMissionData() {
        return missionData;
    }

    public void setMissionData(ArrayList<AreaMissionListAdapterBean> missionData) {
        this.missionData = missionData;
    }
}
