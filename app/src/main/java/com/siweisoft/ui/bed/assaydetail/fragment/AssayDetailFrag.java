package com.siweisoft.ui.bed.assaydetail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.ui.bed.assay.bean.adapterbean.AssayAdapterBean;
import com.siweisoft.ui.bed.assaydetail.ope.AssayDetailUIOpe;

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
        assayDetailUIOpe.initList(assayAdapterBean.getList());

    }

    @Override
    public int getContainView() {
        return R.layout.frag_assaydetail;
    }
}
