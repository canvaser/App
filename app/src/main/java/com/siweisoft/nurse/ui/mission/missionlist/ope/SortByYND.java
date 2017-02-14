package com.siweisoft.nurse.ui.mission.missionlist.ope;

import com.siweisoft.nurse.ui.mission.missionlist.bean.adaapterbean.AreaMissionListAdapterBean;
import com.siweisoft.util.LogUtil;

import java.util.Comparator;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class SortByYND implements Comparator<AreaMissionListAdapterBean>{
    @Override
    public int compare(AreaMissionListAdapterBean o1, AreaMissionListAdapterBean o2) {
        if(o1.getYYYYMMDD_INT()>o2.getYYYYMMDD_INT()){
            return 1;
        }else if(o1.getYYYYMMDD_INT()==o2.getYYYYMMDD_INT()){
            return 0;
        }else{
            return -1;
        }
    }
}
