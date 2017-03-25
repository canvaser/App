package com.summer.nurse.ui.image.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.summer.app.R;
import com.summer.base.ui.id.BaseID;
import com.summer.base.ui.ope.BaseDBOpe;
import com.summer.base.ui.ope.BaseNetOpe;
import com.summer.base.ui.ope.BaseNurseOpes;
import com.summer.constant.ValueConstant;
import com.summer.nurse.ui.base.fragment.BaseNurseFrag;
import com.summer.nurse.ui.image.adapter.ImagesAdapter;
import com.summer.nurse.ui.image.ope.daope.SelectPicDAOpe;
import com.summer.nurse.ui.image.ope.uiope.ImagesUIOpe;
import com.summer.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-02-06.
 */

public class ImagesFrag extends BaseNurseFrag<ImagesUIOpe, BaseNetOpe, BaseDBOpe, SelectPicDAOpe> {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getPics(activity));
    }

    @Override
    public BaseNurseOpes<ImagesUIOpe, BaseNetOpe, BaseDBOpe, SelectPicDAOpe> getOpe() {
        if (baseNurseOpes == null) {
            baseNurseOpes = new BaseNurseOpes(new ImagesUIOpe(activity, getView()), null, null, new SelectPicDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_image_gridimage;
    }

    @OnClick({BaseID.ID_RIGHT})
    public void onClick(View v) {
        switch (v.getId()) {
            case BaseID.ID_RIGHT:
                getArguments().putSerializable(ValueConstant.DATA_DATA, ((ImagesAdapter) (getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter())).getSelect());
                FragManager.getInstance().finish(activity.getSupportFragmentManager(), index);
                break;
        }
    }
}
