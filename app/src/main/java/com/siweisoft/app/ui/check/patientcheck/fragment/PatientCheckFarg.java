package com.siweisoft.app.ui.check.patientcheck.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ope.SimpleNetOpe;
import com.siweisoft.app.ui.addwater.addaddwater.fragment.AddAddWaterFrag;
import com.siweisoft.app.ui.mission.missionlist.bean.res.AreaMessionListResBean;
import com.siweisoft.lib.base.ui.common.CommonOpes;
import com.siweisoft.lib.base.ui.common.CommonUIFrag;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.app.ui.check.patientcheck.adapter.PatientCheckAdapter;
import com.siweisoft.app.ui.check.patientcheck.bean.PatAndTaskInfoResBean;
import com.siweisoft.app.ui.check.patientcheck.ope.PatientCheckDAOpe;
import com.siweisoft.app.ui.check.patientcheck.ope.PatientCheckUIOpe;
import com.siweisoft.app.ui.scan.bean.DrugInfoResBean;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class PatientCheckFarg extends CommonUIFrag<PatientCheckUIOpe, PatientCheckDAOpe> implements OnAppItemClickListener {

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            opes = new CommonOpes<>(new PatientCheckUIOpe(fragment, getView()), new PatientCheckDAOpe(fragment));
        }
        return R.layout.frag_patientcheck;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        opes.getDaOpe().setDrugInfoResBean((DrugInfoResBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        SimpleNetOpe.getPatAndTaskInfoByDocAdvID(activity, opes.getDaOpe().getDrugInfoResBean().getAdvno(), new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    opes.getDaOpe().setPatAndTaskInfoResBean(GsonUtil.getInstance().fromJson(o.toString(), PatAndTaskInfoResBean.class));
                    opes.getUiOpe().initList(opes.getDaOpe().getPatAndTaskInfoResBean());
                }
            }
        });

    }

    public void Checked(String zyh) {
        if (opes.getDaOpe().getPatAndTaskInfoResBean() != null) {
            if (zyh.equals(opes.getDaOpe().getDrugInfoResBean().getPno())) {
                opes.getUiOpe().getHeadLL().setAlpha(1f);
                if (opes.getDaOpe().getPatAndTaskInfoResBean().getData() != null && opes.getDaOpe().getPatAndTaskInfoResBean().getData().getTaskInfo() != null
                        && opes.getDaOpe().getPatAndTaskInfoResBean().getData().getTaskInfo().size() > 0) {
                    ((PatientCheckAdapter) opes.getUiOpe().getRecycle().getAdapter()).setShow(true);
                    ((PatientCheckAdapter) opes.getUiOpe().getRecycle().getAdapter()).setItemClickListener(this);
                    opes.getUiOpe().getRecycle().getAdapter().notifyDataSetChanged();
                }

            }
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        AreaMessionListResBean.DataBean taskInfoBean = (AreaMessionListResBean.DataBean) view.getTag(R.id.data);
        if (taskInfoBean.getCodename().equals("补液卡") ||
                taskInfoBean.getTitles().get(0).getNurse_type().equals("静滴") ||
                taskInfoBean.getTitles().get(0).getNurse_type().equals("术前治疗")) {
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable(ValueConstant.DATA_DATA, taskInfoBean);
            FragManager.getInstance().startFragmentForResult(getFragmentManager(), index, new AddAddWaterFrag(), bundle1, ValueConstant.CODE_REQUSET);
            return;
        }
    }
}
