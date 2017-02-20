package com.siweisoft.nurse.ui.bed.additionlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.base.ui.ope.BaseNetOpe;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.bed.additionlist.bean.reqbean.UpdateAdditionReqBean;
import com.siweisoft.nurse.ui.bed.additionlist.ope.AdditionListDAOpe;
import com.siweisoft.nurse.ui.bed.additionlist.ope.AdditionListNetOpe;
import com.siweisoft.nurse.ui.bed.additionlist.ope.AdditionListUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.patient.bean.resbean.PatientAdditionResBean;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AdditionListFrag extends BaseNurseFrag<AdditionListUIOpe,NurseNetOpe,BaseDBOpe,BaseDAOpe> implements OnAppItemClickListener {

    PatientBedResBean data;

    @Override
    public BaseNurseOpes<AdditionListUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new BaseNurseUIOpe(activity,getView()),new BaseNetOpe(activity),null,null);
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getString(ValueConstant.DATA_POSITION)==null){
            return;
        }
        data = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        ArrayList<PatientAdditionResBean> list = (ArrayList<PatientAdditionResBean>) getArguments().getSerializable(ValueConstant.DATA_DATA2);
        getOpe().getBaseNurseUIOpe().initList(list,getArguments().getString(ValueConstant.DATA_POSITION));
        getOpe().getBaseNurseUIOpe().getAdditionListAdapter().setOnAppItemClickListener(this);

    }



    @Override
    public int getContainView() {
        return R.layout.frag_additionlist;
    }

    @Optional
    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View view){
        switch (view.getId()){
            case BaseID.ID_RIGHT:
                UpdateAdditionReqBean reqBean=null;
                switch (getArguments().getString(ValueConstant.DATA_POSITION)){
                    case "0":
                        reqBean = new UpdateAdditionReqBean(data.get住院号(),"导管",new AdditionListDAOpe(activity).getData(getOpe().getBaseNurseUIOpe().getData()));
                        break;
                    case "1":
                        reqBean = new UpdateAdditionReqBean(data.get住院号(),"关怀",new AdditionListDAOpe(activity).getData(getOpe().getBaseNurseUIOpe().getData()));
                        break;
                }
                getOpe().getBaseNetOpe().writePatientAdditionData(reqBean, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if(success){
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(ValueConstant.DATA_DATA,new AdditionListDAOpe(activity).getData(getOpe().getBaseNurseUIOpe().getData()));
                            FragManager.getInstance().finish(getFragmentManager(),index,bundle);
                        }
                    }
                });
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        getOpe().getBaseNurseUIOpe().getAdditionListAdapter().getData().get(position).setSelect(!getOpe().getBaseNurseUIOpe().getAdditionListAdapter().getData().get(position).isSelect());
        getOpe().getBaseNurseUIOpe().getAdditionListAdapter().notifyDataSetChanged();
    }
}
