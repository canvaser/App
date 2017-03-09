package com.siweisoft.app.ui.bed.addmypatient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.nursenet.NurseNetOpe;
import com.siweisoft.app.nursevalue.BaseID;
import com.siweisoft.app.ui.bed.addmypatient.bean.AddMyPatientListAdapterBean;
import com.siweisoft.app.ui.bed.addmypatient.ope.AddMyPatientDrawUIOpe;
import com.siweisoft.app.ui.home.fragment.DrawerLayoutFrag;
import com.siweisoft.lib.base.ui.fragment.BaseUIFragment;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.lib.util.FragmentUtil;
import com.siweisoft.lib.util.GsonUtil;

import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by ${viwmox} on 2016-11-16.
 */
public class AddMyPatientDrawFrag extends BaseUIFragment implements OnAppItemClickListener {


    AddMyPatientDrawUIOpe addMyPatientUIOpe;
    NurseNetOpe getMyPatientListNetOpe;
    NurseNetOpe addMyPatientNetOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addMyPatientUIOpe = new AddMyPatientDrawUIOpe(activity, getView());
        getMyPatientListNetOpe = new NurseNetOpe(activity);
        addMyPatientNetOpe = new NurseNetOpe(activity);
        getMyPatientListNetOpe.getRegion(new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {
                    AddMyPatientListAdapterBean resBean = GsonUtil.getInstance().fromJson(o.toString(), AddMyPatientListAdapterBean.class);
                    addMyPatientUIOpe.initList(resBean.getData());
                    addMyPatientUIOpe.getAddMyPatientListAdapter().setOnAppItemClickListener(AddMyPatientDrawFrag.this);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addmypatientdraw;
    }

    @Optional
    @OnClick({BaseID.ID_RIGHT, BaseID.ID_BACK})
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case BaseID.ID_RIGHT:

                for (int i = 0; i < addMyPatientUIOpe.getList().size(); i++) {
                    if (addMyPatientUIOpe.getList().get(i).isSelect()) {
                        bundle.putSerializable(ValueConstant.DATA_DATA, addMyPatientUIOpe.getList().get(i));
                        break;
                    }
                }
                FragmentUtil.getInstance().removeFrag(activity, this, DrawerLayoutFrag.class.getSimpleName(), bundle);
                break;
            case BaseID.ID_BACK:
                FragmentUtil.getInstance().removeFrag(activity, this, DrawerLayoutFrag.class.getSimpleName(), bundle);
                break;
        }
    }

    @Override
    public void onAppItemClick(View view, int position) {
        for (int i = 0; i < addMyPatientUIOpe.getList().size(); i++) {
            if (i == position) {
                addMyPatientUIOpe.getList().get(i).setSelect(true);
            } else {
                addMyPatientUIOpe.getList().get(i).setSelect(false);
            }
        }
        addMyPatientUIOpe.getAddMyPatientListAdapter().notifyDataSetChanged();
    }
}
