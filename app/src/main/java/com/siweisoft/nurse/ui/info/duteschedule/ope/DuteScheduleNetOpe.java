package com.siweisoft.nurse.ui.info.duteschedule.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DuteScheduleNetOpe extends BaseNetOpe {


    public DuteScheduleNetOpe(Context context) {
        super(context);
    }


    public void getWorkShifts(BaseNurseReqBean baseReqBean,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WORK_SHIFTS,baseReqBean, reqInterf);
    }


}
