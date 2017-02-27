package com.siweisoft.nurse.ui.setting.scanlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.setting.scanlist.ope.ScanListUIOpe;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class ScanListFrag extends BaseNurseFrag{


    ScanListUIOpe scanListUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scanListUIOpe = new ScanListUIOpe(activity,getView());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_scanlist;
    }
}
