package com.siweisoft.nurse.ui.bed.MyMission.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskOfTodayReqBean;
import com.siweisoft.nurse.ui.bed.MyMission.bean.reqbean.GetPatientTaskReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class GetMyMissionNetOpe extends BaseNetOpe {


    public GetMyMissionNetOpe(Context context) {
        super(context);
    }


    public void getPatientTask(String zyh, OnNetWorkReqInterf reqInterf) {
        GetPatientTaskReqBean reqBean= new GetPatientTaskReqBean();
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK, reqBean, reqInterf);
    }


    public void GetPatientTaskOfToday(GetPatientTaskOfTodayReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_TASK_TODAY, reqBean, reqInterf);
    }


}
