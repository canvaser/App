package com.siweisoft.nurse.ui.bed.assay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.bed.assay.bean.resbean.AssayListResBean;
import com.siweisoft.nurse.ui.bed.assay.ope.AssayListNetOpe;
import com.siweisoft.nurse.ui.bed.assay.ope.AssaySortOpe;
import com.siweisoft.nurse.ui.bed.assay.ope.AssayUIOpe;
import com.siweisoft.nurse.ui.bed.assaydetail.fragment.AssayDetailFrag;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AssayFrag extends BaseNurseFrag implements OnAppItemClickListener{


    AssayUIOpe assayUIOpe;

    AssayListNetOpe assayListNetOpe;

    PatientBedResBean resBean;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assayUIOpe = new AssayUIOpe(activity,getView());
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);

        assayListNetOpe=new AssayListNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setPatientid(resBean.get住院号());
        baseNurseReqBean.setBegin("2016-10-18");
        baseNurseReqBean.setEnd("2016-11-19");
        assayListNetOpe.getMyPatientList(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    AssayListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),AssayListResBean.class);
                    assayUIOpe.initList(new AssaySortOpe().sortAssay(resBean.getData()));
                    assayUIOpe.getAssayListAdapter().setOnAppItemClickListener(AssayFrag.this);
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
        bundle.putSerializable(ValueConstant.DATA_DATA,assayUIOpe.getAssayListAdapter().getData().get(position));
        FragManager.getInstance().startFragment(getFragmentManager(),index,new AssayDetailFrag(),bundle);
    }
}
