package com.siweisoft.ui.info.announcement.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.lib.view.refreshlayout.MaterialRefreshListenerAdpter;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.netadapter.DelayUINetAdapter;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nursenet.NurseNetOpe;
import com.siweisoft.ui.info.announcement.ope.AnnounceUIOpe;

/**
 * Created by ${viwmox} on 2016-12-13.
 */
public class AnnounceMentFrag extends BaseNurseFrag {


    AnnounceUIOpe announceUIOpe;


    NurseNetOpe announceNetOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        announceUIOpe = new AnnounceUIOpe(activity, getView());
        announceNetOpe = new NurseNetOpe(activity);
        announceUIOpe.getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListenerAdpter() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                getData(new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        materialRefreshLayout.finishRefresh();
                    }
                });
            }
        });
        announceUIOpe.getRefreshLayout().autoRefresh(500);
    }

    private void getData(final OnFinishListener onFinishListener) {
        announceNetOpe.getHospitalAnnounceMent(new DelayUINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if (success) {

                }
                if (onFinishListener != null) {
                    onFinishListener.onFinish(o);
                }
            }
        });
    }

    @Override
    public int getContainView() {
        return R.layout.frag_annoucement;
    }
}
