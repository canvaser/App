package com.siweisoft.nurse.ui.bed.bedlist.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class GetMyPatientListNetOpe extends BaseNetOpe {


    public GetMyPatientListNetOpe(Context context) {
        super(context);
    }


    public void getMyPatientList(OnNetWorkReqInterf reqInterf) {

       BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MYPATIENT_LIST2, baseReqBean, reqInterf);
    }


    public void getAdditionList(OnNetWorkReqInterf reqInterf) {

        BaseReqBean baseReqBean = new BaseReqBean();
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GETADDITION_LIST, baseReqBean, reqInterf);
    }


    public void getRegion(OnNetWorkReqInterf reqInterf) {

        BaseNurseReqBean baseReqBean = new BaseNurseReqBean();
        baseReqBean.setRid("0250040");
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_PATIENT_LIST_IN_AREA, baseReqBean, reqInterf);
    }
}
