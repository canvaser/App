package com.siweisoft.nurse.ui.bed.addmypatient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.util.dialog.DialogUtil;
import com.siweisoft.lib.util.fragment.FragManager;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.nursevalue.BaseID;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.AddMyPatientListAdapterBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateListReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.bean.MyPaitentUpdateReqBean;
import com.siweisoft.nurse.ui.bed.addmypatient.ope.AddMyPatientSelectOpe;
import com.siweisoft.nurse.ui.bed.addmypatient.ope.AddMyPatientUIOpe;
import com.siweisoft.nurse.ui.bed.bedlist.bean.resbean.PatientBedResBean;

import java.util.ArrayList;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientFrag extends BaseNurseFrag implements OnAppItemClickListener {


    AddMyPatientUIOpe addMyPatientUIOpe;
    NurseNetOpe getMyPatientListNetOpe;
    NurseNetOpe addMyPatientNetOpe;

    ArrayList<PatientBedResBean> res;


    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null && getArguments().getSerializable(ValueConstant.DATA_DATA) != null) {
            res = (ArrayList<PatientBedResBean>) getArguments().getSerializable(ValueConstant.DATA_DATA);
        }
        addMyPatientUIOpe = new AddMyPatientUIOpe(activity, getView());
        getMyPatientListNetOpe = new NurseNetOpe(activity);
        addMyPatientNetOpe = new NurseNetOpe(activity);
        getMyPatientListNetOpe.getRegion(new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    AddMyPatientListAdapterBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AddMyPatientListAdapterBean.class);
                    addMyPatientUIOpe.initList(new AddMyPatientSelectOpe(activity).select(res, resBean.getData()));
                    addMyPatientUIOpe.getAddMyPatientListAdapter().setOnAppItemClickListener(AddMyPatientFrag.this);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addmypatient;
    }

    @Optional
    @OnClick({BaseID.ID_RIGHT, R.id.iv_select, BaseID.ID_BACK})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_BACK:
                if (addMyPatientUIOpe.getListSelect().size() > 0) {
                    View view = LayoutInflater.from(activity).inflate(R.layout.dialog_backinfo, null);
                    DialogUtil.getInstance().showDialog(activity, view, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.ok:
                                    DialogUtil.getInstance().dismiss();
                                    break;
                                case R.id.cancle:
                                    DialogUtil.getInstance().dismiss();
                                    FragManager.getInstance().finish(getFragmentManager(), index);
                                    break;
                            }
                        }
                    }, R.id.ok, R.id.cancle);
                } else {
                    FragManager.getInstance().finish(getFragmentManager(), index);
                }

                break;
            case BaseID.ID_RIGHT:
                if (addMyPatientUIOpe.getList() == null || addMyPatientUIOpe.getList().size() == 0) {
                    return;
                }
                MyPaitentUpdateListReqBean myPaitentUpdateListReqBean = new MyPaitentUpdateListReqBean();
                ArrayList<MyPaitentUpdateReqBean> list = new ArrayList<>();
                for (int i = 0; i < addMyPatientUIOpe.getList().size(); i++) {
                    if (addMyPatientUIOpe.getList().get(i).isSelect()) {
                        list.add(new MyPaitentUpdateReqBean(addMyPatientUIOpe.getList().get(i).get病床号(),
                                addMyPatientUIOpe.getList().get(i).get姓名(),
                                addMyPatientUIOpe.getList().get(i).get关联病区号(),
                                addMyPatientUIOpe.getList().get(i).get住院号()));
                    }
                }
                String str = GsonUtil.getInstance().toJson(list);
                myPaitentUpdateListReqBean.setJson_data(str);
                addMyPatientNetOpe.updateMyPatientList(myPaitentUpdateListReqBean, new UINetAdapter(activity) {
                    @Override
                    public void onNetWorkResult(boolean success, Object o) {
                        if (success) {
                            FragManager.getInstance().finish(getFragmentManager(), index);
                        }
                    }
                });
                break;
            case R.id.iv_select:
                if (addMyPatientUIOpe.getList() == null || addMyPatientUIOpe.getList().size() == 0) {
                    return;
                }
                addMyPatientUIOpe.getSelectIV().setSelected(!addMyPatientUIOpe.getSelectIV().isSelected());
                for (int i = 0; i < addMyPatientUIOpe.getList().size(); i++) {
                    addMyPatientUIOpe.getList().get(i).setSelect(addMyPatientUIOpe.getSelectIV().isSelected());
                }
                addMyPatientUIOpe.refreshMid();
                addMyPatientUIOpe.getAddMyPatientListAdapter().notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        addMyPatientUIOpe.getList().get(position).setSelect(!addMyPatientUIOpe.getList().get(position).isSelect());
        addMyPatientUIOpe.getAddMyPatientListAdapter().notifyDataSetChanged();
        addMyPatientUIOpe.refreshMid();
    }
}
