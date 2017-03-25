package com.summer.app.ui.bed.nurserecorddetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ope.SimpleNetOpe;
import com.summer.app.ui.bed.nurserecord.bean.resbean.NurseRecordListResBean;
import com.summer.app.ui.bed.nurserecorddetail.ope.NurseRecordDetailUIOpe;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.network.netadapter.OnNetWorkReqAdapter;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.view.refreshlayout.MaterialRefreshLayout;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.app.ui.bed.nurserecord.bean.resbean.NurseRecordResBean;
import com.summer.app.ui.bed.nurserecorddetail.bean.reqbean.NurseRecordReqBean;
import com.summer.app.ui.bed.nurserecorddetail.ope.NurseRecordDetailDAOpe;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class NurseRecordDetailFrag2 extends CommonUIFrag2<NurseRecordDetailUIOpe<NurseRecordDetailFrag2>, NurseRecordDetailDAOpe<NurseRecordDetailFrag2>> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null || getArguments().getSerializable(ValueConstant.DATA_DATA2) == null) {
            return;
        }
        getBaseOpes().getDaOpe().setNurseRecordResBean((NurseRecordResBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getBaseOpes().getDaOpe().setPatientBedResBean((PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA2));
        getBaseOpes().getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
        super.onRefresh(materialRefreshLayout);
        NurseRecordReqBean nurseRecordReqBean = new NurseRecordReqBean();
        nurseRecordReqBean.setZyh(baseOpes.getDaOpe().getPatientBedResBean().get住院号());
        nurseRecordReqBean.setType(baseOpes.getDaOpe().getNurseRecordResBean().get医嘱类别代码());
        nurseRecordReqBean.setDate(baseOpes.getDaOpe().getNurseRecordResBean().getExecdate());
        SimpleNetOpe.getTaskDetailByCondition(activity, nurseRecordReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    NurseRecordListResBean listResBean = GsonUtil.getInstance().fromJson(o.toString(), NurseRecordListResBean.class);
                    baseOpes.getUiOpe().initList(listResBean);
                }
                baseOpes.getUiOpe().getRefreshLayout().finishRefreshingDelay();
            }
        });
    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new NurseRecordDetailUIOpe<NurseRecordDetailFrag2>(activity, getView(), this), new NurseRecordDetailDAOpe<NurseRecordDetailFrag2>(activity, this));
        }
        return R.layout.frag_nurserecorddetail;
    }
}
