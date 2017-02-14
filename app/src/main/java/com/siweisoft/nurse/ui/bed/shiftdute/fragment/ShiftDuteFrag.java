package com.siweisoft.nurse.ui.bed.shiftdute.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.bed.assay.ope.AssayListNetOpe;
import com.siweisoft.nurse.ui.bed.assay.ope.AssayUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteListResBean;
import com.siweisoft.nurse.ui.bed.shiftdute.ope.ShiftDuteUIOpe;
import com.siweisoft.util.GsonUtil;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteFrag extends BaseNurseFrag{


    ShiftDuteUIOpe shiftDuteUIOpe;

    AssayListNetOpe assayListNetOpe;

    PatientBedResBean resBean;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        shiftDuteUIOpe = new ShiftDuteUIOpe(activity,getView());
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);

        assayListNetOpe=new AssayListNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setPatientid(resBean.get住院号());
        assayListNetOpe.getMyPatientList(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    ShiftDuteListResBean shiftDuteListResBean = GsonUtil.getInstance().fromJson(o.toString(),ShiftDuteListResBean.class);
                    shiftDuteUIOpe.initList(shiftDuteListResBean.getData());
                }
            }
        });

    }

    @Override
    public int getContainView() {
        return R.layout.frag_assay;
    }
}
