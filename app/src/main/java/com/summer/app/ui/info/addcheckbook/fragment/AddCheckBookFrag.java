package com.summer.app.ui.info.addcheckbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.summer.app.ui.info.addcheckbook.bean.reqbean.AddCheckBookListReqBean;
import com.summer.app.ui.info.addcheckbook.ope.AddCheckBookDAOpe;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.info.addcheckbook.ope.AddCheckBookUIOpe;
import com.summer.app.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.summer.lib.util.fragment.FragManager;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookFrag extends BaseNurseFrag {


    AddCheckBookDAOpe addCheckBookDAOpe;

    AddCheckBookUIOpe addCheckBookUIOpe;

    NurseNetOpe addCheckBookNetOpe;

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
        addCheckBookUIOpe = new AddCheckBookUIOpe(activity, getView());
        addCheckBookDAOpe = new AddCheckBookDAOpe(activity);
        addCheckBookNetOpe = new NurseNetOpe(activity);
        addCheckBookDAOpe.setData((ArrayList<CheckBookResBean>) getArguments().getSerializable(ValueConstant.DATA_DATA));
        addCheckBookDAOpe.addHead();
        addCheckBookUIOpe.initMid(addCheckBookDAOpe.getData().get(0).getFilename());
        addCheckBookUIOpe.initList(addCheckBookDAOpe.getCheckBookResBean());
    }

    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT})
    public void onClickEvent(View v) {
        switch (v.getId()) {
            case BaseID.ID_MID:
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, addCheckBookDAOpe.getNames(), NurseDialogFrag.MID, new OnAppItemClickListener() {
                    @Override
                    public void onAppItemClick(View view, int position) {
                        addCheckBookDAOpe.setPosition(position);
                        addCheckBookUIOpe.initMid(addCheckBookDAOpe.getData().get(position).getFilename());
                        addCheckBookUIOpe.initList(addCheckBookDAOpe.getCheckBookResBean());
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                AddCheckBookListReqBean reqBean = new AddCheckBookListReqBean();
                reqBean.setJson_data(addCheckBookDAOpe.getJsonData(addCheckBookDAOpe.getCheckBookResBean()));
                addCheckBookNetOpe.writeInventoryCount(reqBean, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            FragManager.getInstance().finish(getFragmentManager(), index);
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addcheckbook;
    }
}
