package com.summer.app.ui.addwater.addaddwater.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.addwater.addaddwater.ope.daope.AddAddWaterDAOpe;
import com.summer.app.ui.addwater.addaddwater.ope.uiope.CountDiShuUIOpe;
import com.summer.lib.base.ui.common.CommonUIFrag2;
import com.summer.lib.base.ui.ope.BaseOpes;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.StringUtil;
import com.summer.lib.util.ToastUtil;
import com.summer.lib.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class CountDishuFrag extends CommonUIFrag2<CountDiShuUIOpe, AddAddWaterDAOpe> {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseOpes.getDaOpe().setAllnum(10);
        baseOpes.getUiOpe().clear();
    }

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            baseOpes = new BaseOpes<>(new CountDiShuUIOpe(activity, getView()), new AddAddWaterDAOpe(activity));
        }
        return R.layout.frag_countdisu;
    }

    @OnClick({BaseID.ID_RIGHT, R.id.tv_start, R.id.ftv_right1})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                if (baseOpes.getDaOpe().finish()) {
                    getArguments().putString(ValueConstant.DATA_DATA, StringUtil.getStr(baseOpes.getDaOpe().getSudu()));
                    FragManager.getInstance().finish(getFragmentManager(), index, getArguments());
                } else {
                    ToastUtil.getInstance().show(activity, "还没有测试完成");
                }
                break;
            case R.id.tv_start:
                int i = baseOpes.getDaOpe().click();
                if (baseOpes.getDaOpe().finish()) {
                    baseOpes.getUiOpe().setTitle(10, i, baseOpes.getDaOpe().getSudu(), baseOpes.getDaOpe().getAllTime());
                } else {
                    baseOpes.getUiOpe().setTitle(i);
                }
                baseOpes.getUiOpe().initList(baseOpes.getDaOpe().getDishuList());
                break;
            case R.id.ftv_right1:
                baseOpes.getUiOpe().clear();
                baseOpes.getDaOpe().clear();
                break;
        }
    }
}
