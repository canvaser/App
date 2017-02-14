package com.siweisoft.nurse.ui.bed.datachart.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.bed.datachart.bean.reqbean.DataChartReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class DataChartNetOpe extends BaseNetOpe{


    public DataChartNetOpe(Context context) {
        super(context);
    }


    public void getRecordDetailData(DataChartReqBean reqBean, OnNetWorkReqInterf reqInterf) {
        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_RECORD_DATA, reqBean, reqInterf);
    }
}
