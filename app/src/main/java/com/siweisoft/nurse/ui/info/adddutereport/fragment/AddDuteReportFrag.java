package com.siweisoft.nurse.ui.info.adddutereport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.info.adddutereport.ope.AddDuteReportUIOpe;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AddDuteReportFrag extends BaseNurseFrag{

    AddDuteReportUIOpe addDuteReportUIOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDuteReportUIOpe = new AddDuteReportUIOpe(activity,getView());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addshiftdutereport;
    }
}
