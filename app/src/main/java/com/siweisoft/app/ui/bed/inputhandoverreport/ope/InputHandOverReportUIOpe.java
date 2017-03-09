package com.siweisoft.app.ui.bed.inputhandoverreport.ope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.bed.inputhandoverreport.view.RecordView;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;
import com.siweisoft.lib.util.StringUtil;
import com.siweisoft.app.ui.bed.inputhandoverreport.fragment.InputHandOverReportFrag;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-05.
 */
public class InputHandOverReportUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.et_input)
    EditText inputET;


    @BindView(R.id.iv_record)
    ImageView recordIV;


    @BindView(R.id.tv_time)
    TextView timeTV;

    @BindView(R.id.iv_cancle)
    ImageView cancleIV;

    @BindView(R.id.iv_show)
    ImageView showIV;


    @BindView(R.id.iv_recording)
    RecordView recordingIV;


    private int[] res = new int[]{R.drawable.icon_record, R.drawable.icon_record_started, R.drawable.icon_record_pause, R.drawable.icon_record_stop};
    public static final String[] str = new String[]{"录音", "开始录音", "暂停录音", "停止录音"};


    public InputHandOverReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
        getRightTV().setSelected(true);
        getRightTV().setText("提交");
        getBackTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
    }

    public void setContent(String str) {
        inputET.setText(StringUtil.getStr(str));
    }


    public void init(String type) {
        switch (type) {
            case InputHandOverReportFrag.TYPE_INPUT:
                inputET.setEnabled(true);
                recordingIV.setVisibility(View.VISIBLE);
                recordIV.setVisibility(View.GONE);
                break;
            case InputHandOverReportFrag.TYPE_PLAY:
                getRightTV().setVisibility(View.GONE);
                inputET.setEnabled(false);
                recordingIV.setVisibility(View.GONE);
                recordIV.setVisibility(View.VISIBLE);
                timeTV.setVisibility(View.GONE);
                cancleIV.setVisibility(View.GONE);
                break;
        }
    }

    public EditText getInputET() {
        return inputET;
    }

    public ImageView getCancleIV() {
        return cancleIV;
    }

    public ImageView getRecordIV() {
        return recordIV;
    }

    public ImageView getShowIV() {
        return showIV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }

    public int[] getRes() {
        return res;
    }

    public String[] getStr() {
        return str;
    }

    public RecordView getRecordingIV() {
        return recordingIV;
    }


}
