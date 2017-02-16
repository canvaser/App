package com.siweisoft.nurse.ui.bed.inputhandoverreport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.file.TestBase64;
import com.siweisoft.lib.util.media.VoiceUtil;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.handoverreport.ope.HandOverReportUIOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.ope.InputHORDAOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.ope.InputHORNetOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.ope.InputHandOverReportUIOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.view.RecordView;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;
import com.siweisoft.nurse.util.fragment.FragManager;

import java.io.File;

import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class InputHandOverReportFrag extends BaseNurseFrag implements RecordView.RecordListener{


    InputHandOverReportUIOpe inputHandOverReportUIOpe;

    InputHORNetOpe inputHORNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    InputHORDAOpe inputHORDAOpe;

    public static final String TYPE_INPUT ="TYPE_INPUT";

    public static final String TYPE_PLAY ="TYPE_PLAY";



    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null ){
            return;
        }

        inputHORDAOpe = new InputHORDAOpe(activity);
        inputHORDAOpe.setShiftDuteResBean((ShiftDuteResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2));
        inputHORDAOpe.setType(getArguments().getString(ValueConstant.DATA_TYPE));
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        inputHandOverReportUIOpe = new InputHandOverReportUIOpe(activity,getView());
        inputHORDAOpe.setStatus(inputHandOverReportUIOpe.getStr()[0]);
        inputHORNetOpe= new InputHORNetOpe(activity);
        inputHandOverReportUIOpe.getRecordingIV().setRecordListener(this);
        inputHandOverReportUIOpe.init(inputHORDAOpe.getType());
        if(inputHORDAOpe.getType().equals(TYPE_PLAY)){
            File file =MethodValue.getRecordFile(""+System.currentTimeMillis());
            inputHORDAOpe.setFile(file);
            TestBase64.byte2File(inputHORDAOpe.getShiftDuteResBean().getAudio().getBytes(),file);

        }
    }



    @Override
    public int getContainView() {
        return R.layout.frag_inputhandovereport;
    }

    public void writeData(final OnFinishListener onFinishListener){
        InputHORReqBean reqBean = new InputHORReqBean();
        reqBean.setContent(inputHandOverReportUIOpe.getInputET().getText().toString());
        reqBean.setZyh(patientAdditionDAOpe.getPatientBedResBean().get住院号());
        if(inputHORDAOpe.getFile()!=null){
            reqBean.setContent("audio");
            reqBean.setAudio(TestBase64.getJsonData(inputHORDAOpe.getFile()));
        }
        inputHORNetOpe.writePatientReportData(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){

                }
                if(onFinishListener!=null){
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @OnClick({BaseID.ID_RIGHT,R.id.iv_record,R.id.iv_cancle})
    public void onClickEvent(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                writeData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        FragManager.getInstance().finish(getFragmentManager(),index);
                    }
                });
                break;
            case R.id.iv_record:
                VoiceUtil.getInstance().play(inputHORDAOpe.getFile().getPath());
                break;
            case R.id.iv_cancle:
                inputHandOverReportUIOpe.getRecordingIV().setVisibility(View.VISIBLE);
                inputHandOverReportUIOpe.getRecordIV().setVisibility(View.GONE);
                inputHandOverReportUIOpe.getTimeTV().setVisibility(View.GONE);
                inputHandOverReportUIOpe.getCancleIV().setVisibility(View.GONE);
                VoiceUtil.getInstance().pause();
                break;
        }
    }

    @Override
    public void start(RecordView recordView) {
        inputHORDAOpe.setFile(MethodValue.getRecordFile(System.currentTimeMillis()+""));
        inputHandOverReportUIOpe.getShowIV().setVisibility(View.VISIBLE);
        inputHORDAOpe.setMediaRecorder(VoiceUtil.getInstance().startRecording(inputHORDAOpe.getFile()));
    }

    @Override
    public void stop(RecordView recordView, long time) {
        inputHandOverReportUIOpe.getShowIV().setVisibility(View.GONE);
        inputHandOverReportUIOpe.getRecordingIV().setVisibility(View.GONE);
        inputHandOverReportUIOpe.getRecordIV().setVisibility(View.VISIBLE);
        inputHandOverReportUIOpe.getTimeTV().setVisibility(View.VISIBLE);
        inputHandOverReportUIOpe.getTimeTV().setText(time/1000+"s");
        inputHandOverReportUIOpe.getCancleIV().setVisibility(View.VISIBLE);
        VoiceUtil.getInstance().stopRecording(inputHORDAOpe.getMediaRecorder(),inputHORDAOpe.getFile());
    }

    @Override
    public void onDestroy() {
        VoiceUtil.getInstance().pause();
        super.onDestroy();
    }
}
