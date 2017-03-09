package com.siweisoft.app.ui.info.addcheckbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.nursevalue.MethodValue;
import com.siweisoft.app.ui.dialog.dialog.fragment.NurseDialogFrag;
import com.siweisoft.app.ui.info.addcheckbook.bean.reqbean.AddCheckBookListReqBean;
import com.siweisoft.app.ui.info.addcheckbook.ope.AddCheckBookDAOpe;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.nursevalue.BaseID;
import com.siweisoft.app.ui.mission.missionlist.ope.AreaMessionDAOpe;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.menu.popup.PopupUtil;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.lib.base.ui.adapter.PupListAdapter;
import com.siweisoft.app.ui.info.addcheckbook.ope.AddCheckBookUIOpe;
import com.siweisoft.app.ui.info.checkbook.bean.resbean.CheckBookResBean;
import com.siweisoft.lib.util.fragment.FragManager;

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
