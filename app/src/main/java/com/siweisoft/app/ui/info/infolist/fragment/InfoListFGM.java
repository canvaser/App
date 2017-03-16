package com.siweisoft.app.ui.info.infolist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.app.ui.info.infolist.ope.InfoListFGMUIOpe;
import com.siweisoft.lib.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.lib.base.ui.fragment.BaseNurseFrag;
import com.siweisoft.lib.base.ui.ope.BaseNurseOpes;
import com.siweisoft.app.ui.info.announcement.fragment.AnnounceMentFrag;
import com.siweisoft.app.ui.info.bedcheck.fragment.BedCheckFrag;
import com.siweisoft.app.ui.info.bedreport.fragment.BedReprotFrag;
import com.siweisoft.app.ui.info.checkbook.fragment.CheckBookFrag;
import com.siweisoft.app.ui.info.duteschedule.fragment.DuteScheDuleFrag;
import com.siweisoft.app.ui.info.shiftdutereport.fragment.ShiftDuteReportFrag;
import com.siweisoft.app.ui.info.urgencyreport.fragment.UrgencyReportFrag;
import com.siweisoft.app.ui.info.workdetail.fragment.WorkDetailFrag;
import com.siweisoft.lib.util.fragment.FragManager;

/**
 * Created by ${viwmox} on 2016-11-08.
 */
public class InfoListFGM extends BaseNurseFrag implements OnAppItemClickListener {


    InfoListFGMUIOpe infoListFGMUIOpe;

    @Override
    public BaseNurseOpes getOpe() {
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        infoListFGMUIOpe = new InfoListFGMUIOpe(activity, getView());
        infoListFGMUIOpe.getInfoListAdapter().setOnAppItemClickListener(this);
    }

    @Override
    public int getContainView() {
        return R.layout.frag_infolist;
    }

    @Override
    public void onAppItemClick(View view, int position) {
        switch (position) {
            case 0:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new BedCheckFrag());
                break;
            case 2:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new AnnounceMentFrag());
                break;
            case 3:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new BedReprotFrag());
                break;
            case 4:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new UrgencyReportFrag());
                break;
            case 5:
                //FragManager.getInstance().startFragment(getFragmentManager(), index, new UrgencyReportFrag());
                break;
            case 6:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new ShiftDuteReportFrag());
                break;
            case 7:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new CheckBookFrag());
                break;
            case 8:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new WorkDetailFrag());
                break;
            case 9:
                FragManager.getInstance().startFragment(getFragmentManager(), index, new DuteScheDuleFrag());
                break;
        }
    }
}
