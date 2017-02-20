package com.siweisoft.nurse.nursenet;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterReqBean;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentDetailReqBean;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListReqBean;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class NurseNetOpe extends BaseNetOpe{


    public NurseNetOpe(Context context) {
        super(context);
    }

    public void document_documemtList(String id,OnNetWorkReqInterf reqInterf) {
        DocumentListReqBean baseReqBean = new DocumentListReqBean();
        baseReqBean.setPid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_FORM, baseReqBean, reqInterf);
    }

    public void document_documemtdetail(String id,OnNetWorkReqInterf reqInterf) {
        DocumentDetailReqBean baseReqBean = new DocumentDetailReqBean();
        baseReqBean.setFid(id);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_DOCUMENT_DETAIL, baseReqBean, reqInterf);
    }

    //补液卡列表
    public void addwater_list(String zyh,String fileid,String begin,String end,OnNetWorkReqInterf reqInterf){
        AddWaterReqBean baseReqBean = new AddWaterReqBean();
        baseReqBean.setZyh(zyh);
        baseReqBean.setFileid(fileid);
        baseReqBean.setBegin(begin);
        baseReqBean.setEnd(end);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_FILE_DATA_BY_PATIENT, baseReqBean, reqInterf);
    }

    /**获取病区病人*/
    public void updateMyPatientList(MyPaitentUpdateListReqBean myPaitentUpdateListReqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_Y_PATIENT_LIST, myPaitentUpdateListReqBean, reqInterf);
    }

    ///**获取病区病人*/
    public void writePatientAdditionData(UpdateAdditionReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_PATIENT_ADDITION, reqBean, reqInterf);
    }

    /**获取护理记录统计*/
    public void getTaskSummaryByPatient(String zyh,OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_SUMMARY_BY_PAITENT, baseNurseReqBean, reqInterf);
    }

}
