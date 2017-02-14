package com.siweisoft.nurse.ui.mission.missiondetail.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.mission.missiondetail.bean.reqbean.MissisonDetailReqBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class MissionDetailNetOpe extends BaseNetOpe{



    public MissionDetailNetOpe(Context context) {
        super(context);
    }


    public void updateTask(MissisonDetailReqBean reqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_TASK, reqBean, reqInterf);
    }




}
