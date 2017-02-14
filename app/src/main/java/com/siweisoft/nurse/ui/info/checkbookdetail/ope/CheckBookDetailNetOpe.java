package com.siweisoft.nurse.ui.info.checkbookdetail.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.info.checkbookdetail.bean.reqbean.CheckBookDetailReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class CheckBookDetailNetOpe extends BaseNetOpe{


    public CheckBookDetailNetOpe(Context context) {
        super(context);
    }


    public void getInstrumentCountData(CheckBookDetailReqBean checkBookDetailReqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_GET_BOOK_DETAIL_DATA, checkBookDetailReqBean, reqInterf);
    }


}
