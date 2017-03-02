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
import com.siweisoft.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsGroupDBOpe;
import com.siweisoft.nurse.ui.app.ope.uiope.AppGroupUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppGroupFrag extends BaseNurseFrag<AppGroupUIOpe, BaseNetOpe, AppsGroupDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().get());

    }

    @Override
    public BaseNurseOpes<AppGroupUIOpe, BaseNetOpe, AppsGroupDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AppGroupUIOpe(activity, getView()), null, new AppsGroupDBOpe(activity, new AppGroupDBBean()), null);
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_appgroup;
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AppAddFrag(), new Bundle(), ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onResult(int req, Bundle bundle) {
        if (bundle != null && bundle.getString(ValueConstant.DATA_DATA) != null) {
            getOpe().getBaseDBOpe().add(bundle.getString(ValueConstant.DATA_DATA));
            getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().get());
        }
    }
}
