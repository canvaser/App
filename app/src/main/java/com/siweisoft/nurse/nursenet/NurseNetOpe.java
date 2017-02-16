package com.siweisoft.nurse.nursenet;

import android.content.Context;

import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.lib.network.NetWork;
import com.siweisoft.lib.network.bean.req.BaseReqBean;
import com.siweisoft.lib.network.interf.OnNetWorkReqInterf;
import com.siweisoft.nurse.nursevalue.DataValue;
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
}
