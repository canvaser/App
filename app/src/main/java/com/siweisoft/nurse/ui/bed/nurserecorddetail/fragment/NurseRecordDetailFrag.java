package com.siweisoft.nurse.ui.bed.nurserecorddetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.bean.reqbean.NurseRecordReqBean;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.ope.NurseRecordDetailNetOpe;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.ope.NurseRecordDetailUIOpe;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordDetailFrag extends BaseNurseFrag{


    NurseRecordDetailUIOpe nurseRecordDetailUIOpe;

    NurseRecordDetailNetOpe nurseRecordDetailNetOpe;

    NurseRecordResBean nurseRecordResBean;

    PatientBedResBean patientBedResBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null|| getArguments().getSerializable(ValueConstant.DATA_DATA2)==null){
            return;
        }
        nurseRecordResBean = (NurseRecordResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        patientBedResBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2);
        nurseRecordDetailUIOpe= new NurseRecordDetailUIOpe(activity,getView());
        nurseRecordDetailNetOpe = new NurseRecordDetailNetOpe(activity);
        NurseRecordReqBean nurseRecordReqBean = new NurseRecordReqBean();
        nurseRecordReqBean.setZyh(patientBedResBean.get住院号());
        nurseRecordReqBean.setType(nurseRecordResBean.get医嘱类别代码());
        nurseRecordReqBean.setDate(nurseRecordResBean.getExecdate());
        nurseRecordDetailNetOpe.getTaskDetailByCondition(nurseRecordReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    NurseRecordListResBean listResBean = GsonUtil.getInstance().fromJson(o.toString(),NurseRecordListResBean.class);
                    nurseRecordDetailUIOpe.initList(listResBean);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_nurserecorddetail;
    }
}
