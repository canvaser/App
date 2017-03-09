package com.siweisoft.ui.setting.scanlist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.db.ope.ScanDBOpe;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.db.bean.ScanDBBean;
import com.siweisoft.nursevalue.BaseID;
import com.siweisoft.ui.setting.scanlist.ope.ScanListUIOpe;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-09.
 */
public class ScanListFrag extends BaseNurseFrag {


    ScanListUIOpe scanListUIOpe;

    ScanDBOpe scanDBOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scanListUIOpe = new ScanListUIOpe(activity, getView());
        scanDBOpe = new ScanDBOpe(activity, new ScanDBBean());
        scanListUIOpe.initList((ArrayList<ScanDBBean>) scanDBOpe.getList());
    }

    @Override
    public int getContainView() {
        return R.layout.frag_scanlist;
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                scanDBOpe.clear();
                scanListUIOpe.initList((ArrayList<ScanDBBean>) scanDBOpe.getList());
                break;
        }
    }
}
