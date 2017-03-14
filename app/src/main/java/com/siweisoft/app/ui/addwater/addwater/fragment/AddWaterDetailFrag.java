package com.siweisoft.app.ui.addwater.addwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.ui.addwater.addwater.bean.netbean.AddWaterListResBean;
import com.siweisoft.app.ui.addwater.addwater.ope.daope.AddWaterDetailDAOpe;
import com.siweisoft.app.ui.addwater.addwater.ope.uiope.AddWaterDetailUIOpe;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;

import java.util.List;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterDetailFrag extends BaseNurseFrag<AddWaterDetailUIOpe, NurseNetOpe, BaseDBOpe, AddWaterDetailDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        getOpe().getUiOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getUiOpe().initList(getOpe().getDaOpe().getFilesBeans());
                getOpe().getUiOpe().getRefreshLayout().finishRefresh();
            }
        });
        getOpe().getDaOpe().setFilesBeans((List<AddWaterListResBean.DataBean.FilesBean>) getArguments().getSerializable(ValueConstant.DATA_DATA));
        getOpe().getUiOpe().getRefreshLayout().autoRefreshWithUI(getResources().getInteger(R.integer.integer_time_short));
    }

    @Override
    public BaseNurseOpes<AddWaterDetailUIOpe, NurseNetOpe, BaseDBOpe, AddWaterDetailDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new AddWaterDetailUIOpe(activity, getView()), null, null, new AddWaterDetailDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addwater_detail;
    }
}
