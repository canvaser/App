package com.siweisoft.nurse.ui.bed.handoverreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.DelayUINetAdapter;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.bedlist.ope.BedListDAOpe;
import com.siweisoft.nurse.ui.bed.handoverreport.ope.HandOverNetOpe;
import com.siweisoft.nurse.ui.bed.handoverreport.ope.HandOverReportUIOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.fragment.InputHandOverReportFrag;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteListResBean;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.GsonUtil;
import com.siweisoft.util.menu.popup.PopupUtil;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class HandOverReportFrag extends BaseNurseFrag implements OnAppItemClickListener{

    HandOverReportUIOpe handOverReportUIOpe;

    HandOverNetOpe handOverNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null){
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        handOverReportUIOpe = new HandOverReportUIOpe(activity,getView());
        handOverReportUIOpe.initMid(patientAdditionDAOpe.getPatientBedResBean().get姓名());
        handOverNetOpe = new HandOverNetOpe(activity);
        getData();

    }

    public void getData(){
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        baseNurseReqBean.setZyh(patientAdditionDAOpe.getPatientBedResBean().get住院号());
        handOverNetOpe.getPatientReportData(baseNurseReqBean, new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    ShiftDuteListResBean shiftDuteListResBean = GsonUtil.getInstance().fromJson(o.toString(),ShiftDuteListResBean.class);
                    handOverReportUIOpe.initList(shiftDuteListResBean.getData());
                    handOverReportUIOpe.getShiftDuteListAdpter().setOnAppItemClickListener(HandOverReportFrag.this);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_handoverreprot;
    }

    @OnClick({BaseID.ID_MID,BaseID.ID_RIGHT})
    public void onClickEvent(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));
                PupListAdapter p = new PupListAdapter(activity,new BedListDAOpe().getPatientNames(patientAdditionDAOpe.getPatientBedResBeen()));
                p.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        handOverReportUIOpe.getMidTV().setText(patientAdditionDAOpe.getPatientBedResBean().get姓名());
                        getData();
                        PopupUtil.getInstance().dimess();
                    }
                });
                recyclerView.setAdapter(p);
                PopupUtil.getInstance().show(activity,view1,v);
                if(patientAdditionDAOpe.getPatientBedResBeen().size()>10){
                    view1.getLayoutParams().height = ValueConstant.DIMEN_1*300;
                    view1.requestLayout();
                }
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle = new Bundle();
                bundle.putString(ValueConstant.DATA_TYPE,InputHandOverReportFrag.TYPE_INPUT);
                bundle.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new InputHandOverReportFrag(),bundle,ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        getData();
    }

    @Override
    public void onAppItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA2,handOverReportUIOpe.getData().get(position));
        bundle.putString(ValueConstant.DATA_TYPE,InputHandOverReportFrag.TYPE_PLAY);
        FragManager.getInstance().startFragment(getFragmentManager(),index,new InputHandOverReportFrag(),bundle);
    }
}
