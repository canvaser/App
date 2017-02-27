package com.siweisoft.nurse.ui.setting.setting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;

import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.setting.scanlist.fragment.ScanListFrag;
import com.siweisoft.nurse.ui.setting.setting.ope.SettingFGMUIOpe;
import com.siweisoft.nurse.ui.setting.updatepwd.fragment.UpdatePwdFrag;
import com.siweisoft.nurse.ui.user.login.activity.LoginActivity;
import com.siweisoft.lib.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class SettingFGM extends BaseNurseFrag {


    SettingFGMUIOpe settingFGMUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settingFGMUIOpe = new SettingFGMUIOpe(activity,getView());

    }


    @Override
    public int getContainView() {
        return R.layout.frag_setting;
    }

    @OnClick({BaseID.ID_RIGHT,R.id.rl_updatepwd, BaseID.ID_BACK})
    public void onClickEvent(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                View view = LayoutInflater.from(activity).inflate(R.layout.dialog_info,null);
                DialogUtil.getInstance().showDialog(activity, view, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()){
                            case R.id.ok:
                                DialogUtil.getInstance().dismiss();
                                new NurseNetOpe(activity).onDologout(new OnNetWorkReqAdapter(activity) {
                                    @Override
                                    public void onNetWorkResult(boolean success, Object o) {
                                        FragManager.getInstance().clear();
                                        activity.finish();
                                        startActivity(new Intent(activity, LoginActivity.class));
                                    }
                                });
                                break;
                            case R.id.cancle:
                                DialogUtil.getInstance().dismiss();
                                break;
                        }
                    }
                }, R.id.ok, R.id.cancle);
                break;
            case R.id.rl_updatepwd:
                FragManager.getInstance().startFragment(getFragmentManager(),index,new UpdatePwdFrag());
                break;
            case BaseID.ID_BACK:
                FragManager.getInstance().startFragment(getFragmentManager(),index,new ScanListFrag());
                break;
        }
    }

}
