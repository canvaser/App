package com.siweisoft.nurse.ui.addwater.addwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListener;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.nurse.ui.addwater.addwater.ope.daope.AddWaterDetailDAOpe;
import com.siweisoft.nurse.ui.addwater.addwater.ope.uiope.AddWaterDetailUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterDetailFrag extends BaseNurseFrag<AddWaterDetailUIOpe,NurseNetOpe,BaseDBOpe,AddWaterDetailDAOpe>{



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getFilesBeans());
                getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
            }
        });
        getOpe().getBaseDAOpe().setFilesBeans((List<AddWaterListResBean.DataBean.FilesBean>) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public BaseNurseOpes<AddWaterDetailUIOpe, NurseNetOpe, BaseDBOpe, AddWaterDetailDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AddWaterDetailUIOpe(activity,getView()),null,null,new AddWaterDetailDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addwater_detail;
    }
}