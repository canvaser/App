package com.siweisoft.nurse.ui.check.checkblood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag2;
import com.siweisoft.lib.base.ui.ope.BaseOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.uuzuche.lib_zxing.activity.CodeUtils;
import com.siweisoft.nurse.ui.check.checkblood.ope.CheckBloodDAOpe;
import com.siweisoft.nurse.ui.check.checkblood.ope.CheckBloodUIOpe;

/**
 * Created by ${viwmox} on 2017-03-01.
 */

public class CheckBloodFrag2 extends CommonUIFrag2<CheckBloodUIOpe<CheckBloodFrag>, CheckBloodDAOpe<CheckBloodFrag>> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getDaOpe().setResult(getArguments().getString(ValueConstant.DATA_DATA));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data == null ? "" : data.getExtras() == null ? "" : data.getExtras().getString(CodeUtils.RESULT_STRING);

    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new CheckBloodUIOpe<CheckBloodFrag2>(activity, getView()), new CheckBloodDAOpe<CheckBloodFrag2>(activity));
        }
        return R.layout.frag_checkblood;
    }
}
