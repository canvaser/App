package com.siweisoft.nurse.ui.bed.nurserecord.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.assay.ope.AssayUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.siweisoft.nurse.ui.bed.nurserecord.ope.NurseRecordListNetOpe;
import com.siweisoft.nurse.ui.bed.nurserecord.ope.NurseRecordUIOpe;
import com.siweisoft.nurse.ui.bed.nurserecorddetail.fragment.NurseRecordDetailFrag;
import com.siweisoft.nurse.util.fragment.FragManager;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class NurseRecordFrag extends BaseNurseFrag implements OnAppItemClickListener {


    NurseRecordUIOpe nurseRecordUIOpe;

    NurseRecordListNetOpe nurseRecordListNetOpe;

    PatientBedResBean resBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nurseRecordUIOpe = new NurseRecordUIOpe(activity,getView());
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);

        nurseRecordListNetOpe=new NurseRecordListNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(resBean.get住院号());
        nurseRecordListNetOpe.getTaskSummaryByPatient(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    NurseRecordListResBean nurseRecordListResBean = GsonUtil.getInstance().fromJson(o.toString(),NurseRecordListResBean.class);
                    nurseRecordUIOpe.initList(nurseRecordListResBean.getData());
                    nurseRecordUIOpe.getNurseRecordListAdapter().setOnAppItemClickListener(NurseRecordFrag.this);
                }
            }
        });

    }

    @Override
    public int getContainView() {
        return R.layout.frag_assay;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA2,resBean);
        bundle.putSerializable(ValueConstant.DATA_DATA,nurseRecordUIOpe.getNurseRecordListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(),index,new NurseRecordDetailFrag(),bundle);
    }
}
