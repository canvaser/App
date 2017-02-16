package com.siweisoft.nurse.ui.info.workdetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.info.workdetail.bean.adpterbean.WorkDetailAdapterBean;
import com.siweisoft.nurse.ui.info.workdetail.ope.WorkDetailsDAOpe;
import com.siweisoft.nurse.ui.info.workdetail.ope.WorkDetailsUIOpe;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class WorkDetailsFrag extends BaseNurseFrag{

    WorkDetailsUIOpe workDetailsUIOpe;

    WorkDetailsDAOpe workDetailsDAOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null ||getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        workDetailsUIOpe= new WorkDetailsUIOpe(activity,getView());
        workDetailsDAOpe = new WorkDetailsDAOpe(activity);
        workDetailsDAOpe.setWorkDetailAdapterBean((WorkDetailAdapterBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        workDetailsUIOpe.initMid(workDetailsDAOpe.getWorkDetailAdapterBean().getDate());
        workDetailsUIOpe.initList(workDetailsDAOpe.getWorkDetailAdapterBean());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_workdetails;
    }


}
