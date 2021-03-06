package com.summer.app.ui.bed.inputhandoverreport.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.nursevalue.MethodValue;
import com.summer.app.ui.bed.inputhandoverreport.bean.reqbean.InputHORReqBean;
import com.summer.app.ui.bed.inputhandoverreport.ope.InputHORDAOpe;
import com.summer.app.ui.bed.inputhandoverreport.ope.InputHandOverReportUIOpe;
import com.summer.app.ui.bed.inputhandoverreport.view.RecordView;
import com.summer.app.ui.bed.patient.ope.PatientAdditionDAOpe;
import com.summer.app.ui.bed.shiftdute.bean.resbean.ShiftDuteResBean;
import com.summer.lib.base.ui.interf.OnLoadingInterf;
import com.summer.lib.util.NullUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.base.ui.interf.OnFinishListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.file.TestBase64;
import com.summer.lib.util.media.VoiceUtil;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.lib.util.fragment.FragManager;

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
        inputHandOverReportUIOpe = new InputHandOverReportUIOpe(activity, getView());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(PackageManager.PERMISSION_GRANTED == getActivity().checkSelfPermission(Manifest.permission.RECORD_AUDIO))) {
                getActivity().requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 1);
                if (!(PackageManager.PERMISSION_GRANTED == getActivity().checkSelfPermission(Manifest.permission.RECORD_AUDIO))) {
                    ToastUtil.getInstance().show(activity, "请打开手机安全中心开启护士工作站录音权限");
                    inputHandOverReportUIOpe.getRecordingIV().setEnabled(false);
                }
            }
        }

        inputHORDAOpe = new InputHORDAOpe(activity);
        inputHORDAOpe.setShiftDuteResBean((ShiftDuteResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2));
        inputHORDAOpe.setType(getArguments().getString(ValueConstant.DATA_TYPE));
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA);

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
            if (NullUtil.isStrEmpty(reqBean.getContent())) {
                reqBean.setContent("audio");
            }
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
        if (time <= 1000) {
            ToastUtil.getInstance().show(activity, "录入时间太短啦");
            return;
        }
        VoiceUtil.getInstance().stopRecording(inputHORDAOpe.getMediaRecorder(), inputHORDAOpe.getFile());
    }

    @Override
    public void onDestroy() {
        VoiceUtil.getInstance().pause();
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    inputHandOverReportUIOpe.getRecordingIV().setEnabled(true);
                } else {
                    inputHandOverReportUIOpe.getRecordingIV().setEnabled(false);
                }
                break;
        }
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return true;
    }
}
