package com.summer.nurse.ui.setting.backsetting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.interf.view.OnAppItemClickListener;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.setting.backsetting.adapter.Backsettingadapter;
import com.summer.nurse.ui.setting.backsetting.ope.daope.BackSettingDAOpe;
import com.summer.nurse.ui.setting.backsetting.ope.uiope.BackSettingUIOpe;
import com.summer.nurse.ui.setting.setting.bean.dbbean.BackUIDBBean;
import com.summer.nurse.ui.setting.setting.ope.dbope.BackUIDBOpe;
import com.summer.util.IntentUtil;

/**
 * Created by summer on 2016/12/31 13:58.
 */

public class BackSettingFrag extends BaseNurseFrag<BackSettingUIOpe, BaseNetOpe, BackUIDBOpe, BackSettingDAOpe> implements OnAppItemClickListener {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDBOpe().get());
        ((Backsettingadapter) getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setItemClickListener(this);
    }

    @Override
    public BaseNurseOpes<BackSettingUIOpe, BaseNetOpe, BackUIDBOpe, BackSettingDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new BackSettingUIOpe(activity, getView()), null, new BackUIDBOpe(activity, new BackUIDBBean()), new BackSettingDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_backsetting;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        getOpe().getBaseDAOpe().setBackUIDBBean((BackUIDBBean) view.getTag(R.id.data));
        IntentUtil.getInstance().photoShowFromphone(fragment, ValueConstant.CODE_REQUSET);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ValueConstant.CODE_REQUSET:
                if (data == null || data.getData() == null) {
                    return;
                }
                getOpe().getBaseDAOpe().getBackUIDBBean().setBackUrl(data.getData().toString());
                getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter().notifyDataSetChanged();
                backUIDBOpe.update(getOpe().getBaseDAOpe().getBackUIDBBean().getFragName(), getOpe().getBaseDAOpe().getBackUIDBBean().getBackUrl());
                break;
        }
    }
}
