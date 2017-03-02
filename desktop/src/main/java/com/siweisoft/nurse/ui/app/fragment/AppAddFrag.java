package com.siweisoft.nurse.ui.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.app.ope.uiope.AppAddUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppAddFrag extends BaseNurseFrag<AppAddUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public BaseNurseOpes<AppAddUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AppAddUIOpe(activity, getView()), null, null, null);
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addapp;
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                if (!getOpe().getBaseNurseUIOpe().getInputET().getText().toString().equals("")) {
                    getArguments().putString(ValueConstant.DATA_DATA, getOpe().getBaseNurseUIOpe().getInputET().getText().toString());
                }
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
        }
    }
}
