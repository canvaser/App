package com.siweisoft.nurse.ui.setting.setting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.setting.backsetting.fragment.BackSettingFrag;
import com.siweisoft.nurse.ui.setting.setting.ope.uiope.SettingUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class SettingFrag extends BaseNurseFrag<SettingUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getContainView() {
        return R.layout.index_setting;
    }

    @Override
    public BaseNurseOpes<SettingUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new SettingUIOpe(activity, getView()), null, null, null);
        }
        return baseNurseOpes;
    }


    @OnClick({R.id.ll_backsetting})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_backsetting:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new BackSettingFrag());
                break;
        }
    }
}
