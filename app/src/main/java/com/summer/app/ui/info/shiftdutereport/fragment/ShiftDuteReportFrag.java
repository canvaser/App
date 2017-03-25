package com.summer.app.ui.info.shiftdutereport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.info.adddutereport.fragment.AddDuteReportFrag;
import com.summer.app.ui.info.shiftdutereport.bean.resbean.ShiftDuteReportDataResBean;
import com.summer.app.ui.user.login.bean.DoLoginResBean;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.util.SPUtil;
import com.summer.lib.bean.reqbean.BaseNurseReqBean;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.info.shiftdutereport.ope.ShiftDuteReportUIOpe;
import com.summer.lib.util.fragment.FragManager;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class ShiftDuteReportFrag extends BaseNurseFrag {


    ShiftDuteReportUIOpe shiftDuteReportUIOpe;

    NurseNetOpe shiftDuteReportNetOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shiftDuteReportUIOpe = new ShiftDuteReportUIOpe(activity, getView());
        shiftDuteReportNetOpe = new NurseNetOpe(activity);
        BaseNurseReqBean baseNurseReqBean = new BaseNurseReqBean();
        DoLoginResBean doLoginResBean = GsonUtil.getInstance().fromJson(SPUtil.getInstance().getStr(ValueConstant.LOGIN_INFO), DoLoginResBean.class);
        //baseNurseReqBean.setRegionid(doLoginResBean.getData().getUser().getRegions().get(0));
        shiftDuteReportNetOpe.getReportData(baseNurseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    ShiftDuteReportDataResBean reportResBean = GsonUtil.getInstance().fromJson(o.toString(), ShiftDuteReportDataResBean.class);
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
    @OnClick({BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new AddDuteReportFrag());
                break;
        }
    }
}
