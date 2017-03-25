package com.summer.nurse.ui.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.id.BaseID;
import com.summer.base.ui.interf.OnNetFinishWithObjInter;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.nurse.ui.app.bean.dbbean.AppDBBean;
import com.summer.nurse.ui.app.ope.daope.AppsDAOpe;
import com.summer.nurse.ui.app.ope.dbope.AppsDBOpe;
import com.summer.nurse.ui.app.ope.netope.AppsNetOpe;
import com.summer.nurse.ui.app.ope.uiope.AppsUIOpe;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsFrag extends BaseNurseFrag<AppsUIOpe, AppsNetOpe, BaseDBOpe, AppsDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    public void getData() {
        getOpe().getBaseDAOpe().getOrQuery(new OnNetFinishWithObjInter() {
            @Override
            public void onNetFinish(Object o) {
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getAppDABean(), fragment);
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_apps;
    }

    @Override
    public BaseNurseOpes<AppsUIOpe, AppsNetOpe, BaseDBOpe, AppsDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AppsUIOpe(activity, getView()), new AppsNetOpe(activity), new AppsDBOpe(activity, new AppDBBean()), new AppsDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new AppGroupFrag());
                break;
        }
    }
}
