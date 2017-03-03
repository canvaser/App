package com.siweisoft.nurse.ui.bed.inputhandoverreport.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnLoadingInterf;
import com.siweisoft.lib.util.NullUtil;
import com.siweisoft.lib.util.ToastUtil;
import com.siweisoft.lib.util.system.PermissionUtil;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.file.TestBase64;
import com.siweisoft.lib.util.media.VoiceUtil;
import com.siweisoft.nurse.nursevalue.MethodValue;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.ope.InputHORDAOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.ope.InputHandOverReportUIOpe;
import com.siweisoft.nurse.ui.bed.inputhandoverreport.view.RecordView;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.siweisoft.nurse.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;
import com.siweisoft.lib.util.fragment.FragManager;

import java.io.File;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class InputHandOverReportFrag extends BaseNurseFrag implements RecordView.RecordListener {


    InputHandOverReportUIOpe inputHandOverReportUIOpe;

    NurseNetOpe inputHORNetOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    InputHORDAOpe inputHORDAOpe;

    public static final String TYPE_INPUT = "TYPE_INPUT";

    public static final String TYPE_PLAY = "TYPE_PLAY";


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) {
            return;
        }
        PermissionUtil.getInstance().addPermission(this, "android.permission.RECORD_AUDIO");

        inputHORDAOpe = new InputHORDAOpe(activity);
        inputHORDAOpe.setShiftDuteResBean((ShiftDuteResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2));
        inputHORDAOpe.setType(getArguments().getString(ValueConstant.DATA_TYPE));
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);
        inputHandOverReportUIOpe = new InputHandOverReportUIOpe(activity, getView());
        inputHORDAOpe.setStatus(inputHandOverReportUIOpe.getStr()[0]);
        inputHORNetOpe = new NurseNetOpe(activity);
        inputHandOverReportUIOpe.getRecordingIV().setRecordListener(this);
        inputHandOverReportUIOpe.init(inputHORDAOpe.getType());
        if (inputHORDAOpe.getType().equals(TYPE_PLAY)) {
            File file = MethodValue.getRecordFile("" + System.currentTimeMillis());
            inputHORDAOpe.setFile(file);
            TestBase64.byte2File(inputHORDAOpe.getShiftDuteResBean().getAudio().getBytes(), file);
            inputHandOverReportUIOpe.setContent(inputHORDAOpe.getShiftDuteResBean().get内容());
        }
    }


    @Override
    public int getContainView() {
        return R.layout.frag_inputhandovereport;
    }

    public void writeData(final OnFinishListener onFinishListener) {
        InputHORReqBean reqBean = new InputHORReqBean();
        reqBean.setContent(inputHandOverReportUIOpe.getInputET().getText().toString());
        reqBean.setZyh(patientAdditionDAOpe.getPatientBedResBean().get住院号());
        if (inputHORDAOpe.getFile() != null) {
            reqBean.setContent("audio");
            reqBean.setAudio(TestBase64.getJsonData(inputHORDAOpe.getFile()));
        }
        if (NullUtil.isStrEmpty(reqBean.getContent()) && inputHORDAOpe.getFile() == null) {
            ToastUtil.getInstance().show(activity, "你还没有录入数据");
            return;
        }
        inputHORNetOpe.writePatientReportData(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {

                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @OnClick({BaseID.ID_RIGHT, R.id.iv_record, R.id.iv_cancle})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                writeData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        FragManager.getInstance().finish(getFragmentManager(), index);
                    }
                });
                break;
            case R.id.iv_record:
                VoiceUtil.getInstance().play(inputHORDAOpe.getFile().getPath(), new OnLoadingInterf() {
                    @Override
                    public Void onStarLoading(Object o) {
                        inputHandOverReportUIOpe.getRecordIV().setSelected(true);
                        return null;
                    }

                    @Override
                    public Void onStopLoading(Object o) {
                        inputHandOverReportUIOpe.getRecordIV().setSelected(false);
                        return null;
                    }
                });
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
        inputHORDAOpe.setFile(MethodValue.getRecordFile(System.currentTimeMillis() + ""));
        inputHandOverReportUIOpe.getShowIV().setVisibility(View.VISIBLE);
        ((AnimationDrawable) inputHandOverReportUIOpe.getShowIV().getBackground()).start();
        inputHORDAOpe.setMediaRecorder(VoiceUtil.getInstance().startRecording(activity, inputHORDAOpe.getFile()));
    }

    @Override
    public void stop(RecordView recordView, long time) {
        inputHandOverReportUIOpe.getShowIV().setVisibility(View.GONE);
        ((AnimationDrawable) inputHandOverReportUIOpe.getShowIV().getBackground()).stop();
        inputHandOverReportUIOpe.getRecordingIV().setVisibility(View.GONE);
        inputHandOverReportUIOpe.getRecordIV().setVisibility(View.VISIBLE);
        inputHandOverReportUIOpe.getTimeTV().setVisibility(View.VISIBLE);
        inputHandOverReportUIOpe.getTimeTV().setText(time / 1000 + "s");
        inputHandOverReportUIOpe.getCancleIV().setVisibility(View.VISIBLE);
        VoiceUtil.getInstance().stopRecording(inputHORDAOpe.getMediaRecorder(), inputHORDAOpe.getFile());
    }

    @Override
    public void onDestroy() {
        VoiceUtil.getInstance().pause();
        super.onDestroy();
    }
}
