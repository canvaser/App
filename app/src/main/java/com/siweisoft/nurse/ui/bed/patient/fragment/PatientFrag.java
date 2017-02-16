package com.siweisoft.nurse.ui.bed.patient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.AnimUtil;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.DelayUINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.MyMission.fragment.MyMissonFrag;
import com.siweisoft.nurse.ui.bed.addaddition.fragment.AddAdditionFrag;
import com.siweisoft.nurse.ui.bed.advice.fragment.AdviceFrag;
import com.siweisoft.nurse.ui.bed.assay.fragment.AssayFrag;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.siweisoft.nurse.ui.bed.data.fragment.DataFrag;
import com.siweisoft.nurse.ui.bed.handoverreport.fragment.HandOverReportFrag;
import com.siweisoft.nurse.ui.bed.nurserecord.fragment.NurseRecordFrag;
import com.siweisoft.nurse.ui.bed.patient.bean.resbean.PatientAdditionListResBean;
import com.siweisoft.nurse.ui.bed.patient.bean.resbean.PatientAdditionResBean;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientFragUIOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientNetOpe;
import com.siweisoft.nurse.ui.document.document.fragment.DocumentListFrag;
import com.siweisoft.nurse.ui.home.adapter.PupListAdapter;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class PatientFrag extends BaseNurseFrag {


    PatientFragUIOpe patientFragUIOpe;

    PatientNetOpe patientNetOpe;


    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null || getArguments().getSerializable(ValueConstant.DATA_DATA2)==null){
            return;
        }
        patientAdditionDAOpe = new PatientAdditionDAOpe();
        patientAdditionDAOpe.setPatientBedResBeen((ArrayList<PatientBedResBean>) getArguments().getSerializable(ValueConstant.DATA_DATA));
        patientAdditionDAOpe.setPatientBedResBean((PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2));
        patientAdditionDAOpe.setPosition(-1);
        patientFragUIOpe = new PatientFragUIOpe(activity,getView());
        patientNetOpe= new PatientNetOpe(activity);
        patientFragUIOpe.initInfo(patientAdditionDAOpe.getPatientBedResBean());
        patientFragUIOpe.initAddionList(new PatientAdditionOpe().getThispatientAdditionList(null));
        getData(new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                onCmd(getArguments());
            }
        });
    }

    private void getData(final OnFinishListener onFinishListener){
        patientNetOpe.getPatientAdditionData(patientAdditionDAOpe.getPatientBedResBean(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    PatientAdditionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),PatientAdditionListResBean.class);
                    ArrayList<PatientAdditionResBean> list =  new PatientAdditionOpe().getThispatientAdditionList(resBean);
                    patientFragUIOpe.initAddionList(list);
                    patientFragUIOpe.initTitle(patientAdditionDAOpe.getPatientBedResBean().get病床号()+" "+patientAdditionDAOpe.getPatientBedResBean().get姓名());
                }
               if(onFinishListener!=null){
                   onFinishListener.onFinish(o);
               }
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_patient;
    }


    int i=0;
    @Optional
    @OnClick({R.id.rl_nurse_document,R.id.iv_arrow, BaseID.ID_MID,BaseID.ID_RIGHT,R.id.ll_baseinfo,R.id.rl_mymission,R.id.rl_advice,R.id.rl_data,R.id.rl_assay,R.id.rl_nurserecord,R.id.rl_handoverreport})
    public void onClick(final View view){
        switch (view.getId()){
            case R.id.ll_baseinfo:
            case R.id.iv_arrow:
               if( patientFragUIOpe.getArrowIV().isEnabled()){
                   patientFragUIOpe.getArrowIV().setSelected(!patientFragUIOpe.getArrowIV().isSelected());
               }
                if(patientFragUIOpe.getArrowIV().isSelected()){
                    AnimUtil.getInstance().animMarginTop(2000, patientFragUIOpe.getSomeView(), new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            patientFragUIOpe.getArrowIV().setEnabled(true);
                            patientFragUIOpe.getBaseInfoView().setEnabled(true);
                        }
                    }, 0, patientFragUIOpe.getInfoDetailView().getHeight());
                }else{
                    AnimUtil.getInstance().animMarginTop(2000, patientFragUIOpe.getSomeView(), new OnFinishListener() {
                        @Override
                        public void onFinish(Object o) {
                            patientFragUIOpe.getArrowIV().setEnabled(true);
                            patientFragUIOpe.getBaseInfoView().setEnabled(true);
                        }
                    }, patientFragUIOpe.getSomeView().getHeight(), 0);
                }
                patientFragUIOpe.getBaseInfoView().setEnabled(false);
                patientFragUIOpe.getArrowIV().setEnabled(false);
                break;
            case BaseID.ID_MID:
                View view1 = layoutInflater.inflate(R.layout.pup_list,null);
                RecyclerView recyclerView = (RecyclerView) view1.findViewById(R.id.rcv_pop);
                recyclerView.getLayoutParams().height = ValueConstant.DIMEN_1*200;
                recyclerView.requestLayout();
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.addItemDecoration(new MyItemDecoration(activity,2));

                PupListAdapter p = new PupListAdapter(activity,patientAdditionDAOpe.getNames());
                p.setOnAppItemClickListener(new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        patientAdditionDAOpe.setPosition(position);
                        PopupUtil.getInstance().dimess();
                        patientFragUIOpe.initInfo(patientAdditionDAOpe.getPatientBedResBean());
                        getData(null);
                    }
                });
                recyclerView.setAdapter(p);
                PopupUtil.getInstance().show(activity,view1,view);
                break;
            case BaseID.ID_RIGHT:
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable(ValueConstant.DATA_DATA2,patientFragUIOpe.getSelectAddition());
                bundle0.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe.getPatientBedResBean());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index,new AddAdditionFrag(),bundle0,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_mymission:
                Bundle bundle = new Bundle();
                bundle.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new MyMissonFrag(),bundle,ValueConstant.CODE_REQUSET1);
                break;
            case R.id.rl_advice:
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe.getPatientBedResBean());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),this.index, new AdviceFrag(),bundle1,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_data:
                Bundle bundlea = new Bundle();
                bundlea.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new DataFrag(),bundlea,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_assay:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe.getPatientBedResBean());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new AssayFrag(),bundle2,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_nurserecord:
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe.getPatientBedResBean());
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new NurseRecordFrag(),bundle3,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_handoverreport:
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new HandOverReportFrag(),bundle4,ValueConstant.CODE_REQUSET);
                break;
            case R.id.rl_nurse_document:
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable(ValueConstant.DATA_DATA,patientAdditionDAOpe);
                FragManager.getInstance().startFragmentForResult(getFragmentManager(),index, new DocumentListFrag(),bundle5,ValueConstant.CODE_REQUSET1);
                break;
        }

    }

    @Override
    public void onResult(int req, Bundle bundle) {
        switch (req){
            case ValueConstant.CODE_REQUSET1:
                if(bundle!=null &&bundle.getSerializable(ValueConstant.DATA_DATA)!=null){
                    patientAdditionDAOpe = (PatientAdditionDAOpe) bundle.getSerializable(ValueConstant.DATA_DATA);
                }
                break;
        }
        patientNetOpe.getPatientAdditionData(patientAdditionDAOpe.getPatientBedResBean(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    PatientAdditionListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(),PatientAdditionListResBean.class);
                    ArrayList<PatientAdditionResBean> list =  new PatientAdditionOpe().getThispatientAdditionList(resBean);
                    patientFragUIOpe.initTitle(patientAdditionDAOpe.getPatientBedResBean().get姓名());
                    patientFragUIOpe.initInfo(patientAdditionDAOpe.getPatientBedResBean());
                    patientFragUIOpe.initAddionList(list);
                }
            }
        });
    }

    @Override
    public void onCmd(Bundle bundle) {
        if(bundle==null || bundle.getString(ValueConstant.FARG_TYPE)==null|| !bundle.getString(ValueConstant.FARG_TYPE).equals(ValueConstant.FARG_TYPE_CMD)){
            return;
        }
        onClick(getView().findViewById(bundle.getInt(ValueConstant.DATA_POSITION)));
    }
}
