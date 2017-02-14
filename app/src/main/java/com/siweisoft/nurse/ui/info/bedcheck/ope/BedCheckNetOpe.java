package com.siweisoft.nurse.ui.info.bedcheck.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.info.bedcheck.bean.reqbean.WriteBedCheckReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class BedCheckNetOpe extends BaseNetOpe{


    public BedCheckNetOpe(Context context) {
        super(context);
    }


    public void getWardInspectionList(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_WARD_INSPECTION_LIST, new BaseReqBean(), reqInterf);
    }



    public void writeWardInspectionInfo(WriteBedCheckReqBean req,OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_WARD_INSPECTION_INFO,req, reqInterf);
    }
}
