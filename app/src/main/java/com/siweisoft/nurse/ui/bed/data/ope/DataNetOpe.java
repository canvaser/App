package com.siweisoft.nurse.ui.bed.data.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.JsonDataListReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.JsonDataReqBean;
import com.siweisoft.nurse.ui.bed.data.bean.reqbean.RecordDataReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DataNetOpe extends BaseNetOpe{


    public DataNetOpe(Context context) {
        super(context);
    }


    public void getMultipleRecordData(String begin,String end,String zyh,OnNetWorkReqInterf reqInterf) {
        BaseNurseReqBean reqBean = new BaseNurseReqBean();
        reqBean.setBegin(begin);
        reqBean.setEnd(end);
        reqBean.setZyh(zyh);
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_MULTIPLE_RECORD_DATA, reqBean, reqInterf);
    }

    public void getRecordTemplate(OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_TEMPLETE, new BaseReqBean(), reqInterf);
    }

    public void getRecordData(RecordDataReqBean req,OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, req, reqInterf);
    }


    public void updateRecordData(JsonDataListReqBean req, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_UPDATE_RECORD_DATA, req, reqInterf);
    }
}
