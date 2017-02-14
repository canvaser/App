package com.siweisoft.nurse.ui.info.checkbook.ope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.network.NetWork;
import com.siweisoft.network.bean.req.BaseReqBean;
import com.siweisoft.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;

/**
 * Created by ${viwmox} on 2016-11-15.
 */
public class CheckBookNetOpe extends BaseNetOpe{


    public CheckBookNetOpe(Context context) {
        super(context);
    }


    public void getInstrumentFileItem(OnNetWorkReqInterf reqInterf) {

        NetWork.getInstance(context).doHttpRequsetWithSession(context, DataValue.URL_CHECK_BOOK_DATA, new BaseReqBean(), reqInterf);
    }


}
