package com.summer.app.ui.bed.assaydetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.bed.assaydetail.ope.AssayDetailUIOpe;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.bed.assay.bean.adapterbean.AssayAdapterBean;

/**
 * Created by ${viwmox} on 2016-11-18.
 */
public class AssayDetailFrag extends BaseNurseFrag {


    AssayDetailUIOpe assayDetailUIOpe;

    AssayAdapterBean assayAdapterBean;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null || getArguments().getSerializable(ValueConstant.DATA_DATA) == null) {
            return;
        }
        assayDetailUIOpe = new AssayDetailUIOpe(activity, getView());
        assayAdapterBean = (AssayAdapterBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        assayDetailUIOpe.initTitle(assayAdapterBean.getTitle());
        assayDetailUIOpe.initList(assayAdapterBean.getList());

    }

    @Override
    public int getContainView() {
        return R.layout.frag_assaydetail;
    }
}
