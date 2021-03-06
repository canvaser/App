package com.summer.app.ui.bed.inputdata.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.app.nursenet.NurseNetOpe;
import com.summer.app.nursevalue.BaseID;
import com.summer.app.ui.bed.data.bean.resbean.DataTemplateListResBean;
import com.summer.app.ui.bed.inputdata.ope.InputDataUIOpe;
import com.summer.lib.base.ui.interf.view.OnAppItemClickListener;
import com.summer.lib.constant.ValueConstant;
import com.summer.lib.util.GsonUtil;
import com.summer.lib.base.ui.fragment.BaseNurseFrag;
import com.summer.lib.base.ui.netadapter.UINetAdapter;
import com.summer.lib.base.ui.ope.BaseNurseOpes;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.lib.util.fragment.FragManager;
import com.summer.app.ui.dialog.dialog.fragment.NurseDialogFrag;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataFrag extends BaseNurseFrag {


    InputDataUIOpe inputDataUIOpe;

    NurseNetOpe dataNetOpe;

    NurseNetOpe inputDataNetOpe;

    PatientBedResBean resBean;

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
        resBean = (PatientBedResBean) getArguments().getSerializable(ValueConstant.DATA_DATA);
        inputDataUIOpe = new InputDataUIOpe(activity, getView());
        dataNetOpe = new NurseNetOpe(activity);
        inputDataNetOpe = new NurseNetOpe(activity);
        getTemplate();
    }

    @Override
    public int getContainView() {
        return R.layout.frag_inputdata;
    }

    public void getTemplate() {
        dataNetOpe.getRecordTemplate(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    DataTemplateListResBean resBean = GsonUtil.getInstance().fromJson(o.toString(), DataTemplateListResBean.class);
                    inputDataUIOpe.initList(resBean.getData(), 0);
                }
            }
        });
    }

    @OnClick({BaseID.ID_MID, BaseID.ID_RIGHT})
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case BaseID.ID_MID:
                ArrayList<String> ss = new ArrayList<>();
                for (int i = 0; i < inputDataUIOpe.getList().size(); i++) {
                    ss.add(inputDataUIOpe.getList().get(i).getGroupname());
                }
                String[] strings = new String[ss.size()];
                strings = ss.toArray(strings);
                NurseDialogFrag.show(getFragmentManager(), BaseID.ID_ROOT, strings, NurseDialogFrag.MID, new OnAppItemClickListener() {

                    @Override
                    public void onAppItemClick(View view, int position) {
                        inputDataUIOpe.refreshList(position);
                    }
                });
                break;
            case BaseID.ID_RIGHT:
                inputDataNetOpe.writeRecordData(inputDataUIOpe.getList().get(inputDataUIOpe.getP()), resBean.get住院号(), resBean.get关联病区号(), new UINetAdapter(activity) {
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
}
