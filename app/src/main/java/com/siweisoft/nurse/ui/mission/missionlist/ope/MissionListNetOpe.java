package com.siweisoft.nurse.ui.mission.missionlist.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.mission.missionlist.bean.req.MyWardTaskTodayReqBean;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class MissionListNetOpe extends BaseNetOpe{



    public MissionListNetOpe(Context context) {
        super(context);
    }


    public void getMyWardTaskOfToday(OnNetWorkReqInterf reqInterf) {

        MyWardTaskTodayReqBean myWardTaskTodayReqBean = new MyWardTaskTodayReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_TODAY, myWardTaskTodayReqBean, reqInterf);
    }

    public void getMyPatientTaskOfToday(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_TODAY, baseReqBean, reqInterf);
    }

    public void getMyWardTaskOfHistory(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_AREA_TASK_HISTORY_NOT_FINISHED, baseReqBean, reqInterf);
    }

    public void getMyPatientTaskOfHistory(OnNetWorkReqInterf reqInterf) {
        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MY_PATIENT_TASK_HISTORY, baseReqBean, reqInterf);
    }



}
