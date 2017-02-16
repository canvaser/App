package com.siweisoft.nurse.ui.info.addcheckbook.ope;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.info.addcheckbook.bean.reqbean.AddCheckBookListReqBean;
import com.siweisoft.nurse.ui.info.addcheckbook.bean.reqbean.AddCheckBookReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class AddCheckBookNetOpe extends BaseNetOpe {


    public AddCheckBookNetOpe(Context context) {
        super(context);
    }


    public void writeInventoryCount(AddCheckBookListReqBean reqBean, OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_WRITE_INVENTORY_COUNT,reqBean, reqInterf);
    }


}
