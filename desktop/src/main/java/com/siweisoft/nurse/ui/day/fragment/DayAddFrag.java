package com.siweisoft.nurse.ui.day.fragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TimePicker;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.day.bean.dbbean.DayDBBean;
import com.siweisoft.nurse.ui.day.ope.dbope.DayAddDBOpe;
import com.siweisoft.nurse.ui.day.ope.uiope.NewPlanUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.IntentUtil;
import com.siweisoft.util.data.DateFormatUtil;
import com.siweisoft.util.data.FormatUtil;
import com.siweisoft.util.file.TimePickUtil;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-01-06.
 */

public class DayAddFrag extends BaseNurseFrag<NewPlanUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_day_add;
    }

    @Override
    public BaseNurseOpes<NewPlanUIOpe, BaseNetOpe, DayAddDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new NewPlanUIOpe(activity, getView()), null, new DayAddDBOpe(activity, new DayDBBean()), null);
        }
        return baseNurseOpes;
    }

    @OnClick({BaseID.ID_RIGHT, R.id.tv_start_lable, R.id.tv_end_lable, R.id.tv_selectmusic})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_start_lable:
                TimePickUtil.getInstance().showTimePickDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        getOpe().getBaseNurseUIOpe().getStartTV().setText(FormatUtil.getInstance().getHHMM(hourOfDay, minute));
                        getOpe().getBaseNurseUIOpe().getStartTV().setTag(R.id.position, FormatUtil.getInstance().getTime(hourOfDay, minute));
                    }
                });
                break;
            case R.id.tv_end_lable:
                TimePickUtil.getInstance().showTimePickDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        getOpe().getBaseNurseUIOpe().getEndTV().setText(FormatUtil.getInstance().getHHMM(hourOfDay, minute));
                        getOpe().getBaseNurseUIOpe().getEndTV().setTag(R.id.position, FormatUtil.getInstance().getTime(hourOfDay, minute));
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                if (getOpe().getBaseNurseUIOpe().meetCondition()) {
                    return;
                }
                getOpe().getBaseDBOpe().add((long) getOpe().getBaseNurseUIOpe().getStartTV().getTag(R.id.position),
                        (long) getOpe().getBaseNurseUIOpe().getEndTV().getTag(R.id.position),
                        getOpe().getBaseNurseUIOpe().getContentET().getText().toString(),
                        getOpe().getBaseNurseUIOpe().getMusicTV().getText().toString(),
                        getOpe().getBaseNurseUIOpe().getSwitchCB().isChecked());
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
            case R.id.tv_selectmusic:
                IntentUtil.getInstance().musicShowFromphone(fragment, ValueConstant.CODE_REQUSET1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null || data.getData() == null) {
            return;
        }
        switch (requestCode) {
            case ValueConstant.CODE_REQUSET1:
                getOpe().getBaseNurseUIOpe().getMusicTV().setText(data.getDataString() + "");
                break;
        }
    }
}
