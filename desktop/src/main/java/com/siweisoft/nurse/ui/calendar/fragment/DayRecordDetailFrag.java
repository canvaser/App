package com.siweisoft.nurse.ui.calendar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;
import com.siweisoft.nurse.ui.calendar.ope.daope.DayRecordDetailDAOpe;
import com.siweisoft.nurse.ui.calendar.ope.uiope.DayRecordDetailUIOpe;

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
