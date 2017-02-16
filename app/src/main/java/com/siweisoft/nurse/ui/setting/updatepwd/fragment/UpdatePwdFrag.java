package com.siweisoft.nurse.ui.setting.updatepwd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.netadapter.UINetAdapter;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.setting.updatepwd.bean.reqbean.UpdatePwdReqBean;
import com.siweisoft.nurse.ui.setting.updatepwd.ope.UpdatePwdNetOpe;
import com.siweisoft.nurse.ui.setting.updatepwd.ope.UpdatePwdUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class UpdatePwdFrag extends BaseNurseFrag{


    UpdatePwdUIOpe updatePwdUIOpe;

    UpdatePwdNetOpe updatePwdNetOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updatePwdUIOpe = new UpdatePwdUIOpe(activity,getView());
        updatePwdNetOpe= new UpdatePwdNetOpe(activity);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_updatepwd;
    }


    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                if(updatePwdUIOpe.isReady()){
                    UpdatePwdReqBean reqBean = new UpdatePwdReqBean();
                    reqBean.setNew_password(updatePwdUIOpe.getNewPwdEt().getText().toString());
                    reqBean.setOld_password(updatePwdUIOpe.getBeforePwdEt().getText().toString());
                    updatePwdNetOpe.changePassword(reqBean, new UINetAdapter(activity) {
                        @Override
                        public void onNetWorkResult(boolean success, Object o) {
                            if(success){
                                FragManager.getInstance().finish(getFragmentManager(),index);
                            }
                        }
                    });
                }
                break;
        }
    }
}
