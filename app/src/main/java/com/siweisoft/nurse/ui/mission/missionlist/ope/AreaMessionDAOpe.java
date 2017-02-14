package com.siweisoft.nurse.ui.mission.missionlist.ope;

import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.check.checklist.bean.resbean.CheckResBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.nurse.ui.mission.missionlist.bean.res.AreaMessionTitleResBean;
import com.siweisoft.nurse.ui.user.login.bean.GetallregionbyuserResBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-23.
 */
public class AreaMessionDAOpe {


    public String myPatientTodayData ="";

    public String myAreaTodayData="";

    public String myPatientHistoryData ="";

    public String myAreaHistoryData ="";

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
}
