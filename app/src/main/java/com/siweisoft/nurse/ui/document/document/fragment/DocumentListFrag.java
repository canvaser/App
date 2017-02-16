package com.siweisoft.nurse.ui.document.document.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.document.document.bean.netbean.DocumentListResBean;
import com.siweisoft.nurse.ui.document.document.ope.uiope.DocumentListUIOpe;

/**
 * Created by ${viwmox} on 2017-02-15.
 */

public class DocumentListFrag extends BaseNurseFrag<DocumentListUIOpe,NurseNetOpe,BaseDBOpe,BaseDAOpe> {


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        getOpe().getBaseNetOpe().document_documemtList("0", new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    DocumentListResBean documentListResBean = GsonUtil.getInstance().fromJson(o.toString(),DocumentListResBean.class);
                    getOpe().getBaseNurseUIOpe().initList(documentListResBean);
                }
            }
        });
    }


    @Override
    public BaseNurseOpes<DocumentListUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new DocumentListUIOpe(activity,getView()),new NurseNetOpe(activity),null,null);
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_doment_documentlist;
    }
}
