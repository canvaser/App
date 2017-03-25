package com.summer.app.ui.setting.updatepwd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.setting.updatepwd.bean.reqbean.UpdatePwdReqBean;
import com.summer.app.ui.setting.updatepwd.ope.UpdatePwdUIOpe;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.lib.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class UpdatePwdFrag extends BaseNurseFrag {


    UpdatePwdUIOpe updatePwdUIOpe;

    NurseNetOpe updatePwdNetOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updatePwdUIOpe = new UpdatePwdUIOpe(activity, getView());
        updatePwdNetOpe = new NurseNetOpe(activity);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_updatepwd;
    }


    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                if (updatePwdUIOpe.isReady()) {
                    UpdatePwdReqBean reqBean = new UpdatePwdReqBean();
                    reqBean.setNew_password(updatePwdUIOpe.getNewPwdEt().getText().toString());
                    reqBean.setOld_password(updatePwdUIOpe.getBeforePwdEt().getText().toString());
                    updatePwdNetOpe.changePassword(reqBean, new UINetAdapter(activity) {
                        @Override
                        public void onNetWorkResult(boolean success, Object o) {
                            if (success) {
                                FragManager.getInstance().finish(getFragmentManager(), index);
                            }
                        }
                    });
                }
                break;
        }
    }
}
