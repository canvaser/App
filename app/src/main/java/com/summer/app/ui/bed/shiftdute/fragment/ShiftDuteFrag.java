package com.summer.app.ui.bed.shiftdute.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.app.ui.bed.shiftdute.bean.resbean.ShiftDuteListResBean;
import com.summer.app.ui.bed.shiftdute.ope.ShiftDuteUIOpe;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteFrag extends BaseNurseFrag {


    ShiftDuteUIOpe shiftDuteUIOpe;

    NurseNetOpe assayListNetOpe;

    PatientBedResBean resBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        shiftDuteUIOpe = new ShiftDuteUIOpe(activity, getView());
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);

        assayListNetOpe = new NurseNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setPatientid(resBean.get住院号());
        assayListNetOpe.getlistResultPatient(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    ShiftDuteListResBean shiftDuteListResBean = GsonUtil.getInstance().fromJson(o.toString(), ShiftDuteListResBean.class);
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
