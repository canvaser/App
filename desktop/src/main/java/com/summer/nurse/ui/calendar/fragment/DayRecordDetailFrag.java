package com.summer.nurse.ui.calendar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.calendar.bean.netbean.DayBean;
import com.summer.nurse.ui.calendar.ope.daope.DayRecordDetailDAOpe;
import com.summer.nurse.ui.calendar.ope.uiope.DayRecordDetailUIOpe;

/**
 * Created by ${viwmox} on 2017-01-24.
 */

public class DayRecordDetailFrag extends BaseNurseFrag<DayRecordDetailUIOpe, BaseNetOpe, BaseDBOpe, DayRecordDetailDAOpe> {


    @Override
    public BaseNurseOpes<DayRecordDetailUIOpe, BaseNetOpe, BaseDBOpe, DayRecordDetailDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new DayRecordDetailUIOpe(activity, getView()), null, null, new DayRecordDetailDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        getOpe().getBaseDAOpe().setDayBean((DayBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getOpe().getBaseNurseUIOpe().loadData(getOpe().getBaseDAOpe().getDayBean());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_record_detail;
    }
}
