package com.siweisoft.nurse.ui.calendar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.ui.calendar.adapter.DayRecordPagerAdapter;
import com.siweisoft.nurse.ui.calendar.ope.uiope.DayRecordUIOpe;

/**
 * Created by ${viwmox} on 2017-01-24.
 */

public class DayRecordFrag extends BaseNurseFragWithoutTitle<DayRecordUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initPager(fragment, index);
    }

    @Override
    public BaseNurseOpes<DayRecordUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new DayRecordUIOpe(activity, getView()), null, null, null);
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_dayrecord;
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        super.onResult(req, bundle);
        ((AddDayRecordFrag) ((DayRecordPagerAdapter) getOpe().getBaseNurseUIOpe().getViewPager().getAdapter()).getItem(0)).onResult(req, bundle);
    }
}
