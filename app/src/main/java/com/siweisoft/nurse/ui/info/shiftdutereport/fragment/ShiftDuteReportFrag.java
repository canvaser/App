package com.siweisoft.nurse.ui.info.shiftdutereport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.SPUtil;
import com.siweisoft.nurse.ui.base.bean.reqbean.BaseNurseReqBean;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.info.adddutereport.fragment.AddDuteReportFrag;
import com.siweisoft.nurse.ui.info.shiftdutereport.bean.resbean.ShiftDuteReportDataResBean;
import com.siweisoft.nurse.ui.info.shiftdutereport.bean.resbean.ShiftDuteReportResBean;
import com.siweisoft.nurse.ui.info.shiftdutereport.ope.ShiftDuteReportNetOpe;
import com.siweisoft.nurse.ui.info.shiftdutereport.ope.ShiftDuteReportUIOpe;
import com.siweisoft.nurse.ui.user.login.bean.DoLoginResBean;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteReportFrag extends BaseNurseFrag{


    ShiftDuteReportUIOpe shiftDuteReportUIOpe;

    ShiftDuteReportNetOpe shiftDuteReportNetOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shiftDuteReportUIOpe = new ShiftDuteReportUIOpe(activity,getView());
        shiftDuteReportNetOpe = new ShiftDuteReportNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.LOGIN_INFO),DoLoginResBean.class);
        //baseNurseReqBean.setRegionid(doLoginResBean.getData().getUser().getRegions().get(0));
        shiftDuteReportNetOpe.getReportData(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                    ShiftDuteReportDataResBean reportResBean = GsonUtil.getInstance().fromJson(o.toString(),ShiftDuteReportDataResBean.class);
                    shiftDuteReportUIOpe.initData(reportResBean.getData());
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_shiftdutereportlist;
    }

    @Optional
    @OnClick({BaseID.ID_BACK, BaseID.ID_RIGHT})
    public void onBackClick(View v){
        switch (v.getId()){
            case R.id.ftv_back:
                FragManager.getInstance().finish(getFragmentManager(), index);
                break;
            case BaseID.ID_RIGHT:
                FragManager.getInstance().startFragment(getFragmentManager(),index,new AddDuteReportFrag());
                break;
        }
    }
}
