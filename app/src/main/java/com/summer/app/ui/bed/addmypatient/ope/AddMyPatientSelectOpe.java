package com.summer.app.ui.bed.addmypatient.ope;

import android.content.Context;

import com.summer.app.ui.bed.addmypatient.bean.AddMyPatientAdapterBean;
import com.summer.app.ui.bed.bedlist.bean.resbean.PatientBedResBean;
import com.summer.app.ui.bed.bedlist.ope.BedListDAOpe;
import com.summer.lib.base.ui.ope.BaseOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-01.
 */
public class AddMyPatientSelectOpe extends BaseOpe {


    public AddMyPatientSelectOpe(Context context) {
        super(context);
    }

    public ArrayList<AddMyPatientAdapterBean> select(ArrayList<PatientBedResBean> resBeen, ArrayList<AddMyPatientAdapterBean> been) {
        if (resBeen == null || resBeen.size() == 0) {
            return been;
        }
        for (int i = 0; i < been.size(); i++) {

            for (int j = 0; j < resBeen.size(); j++) {
                if (been.get(i).get住院号().equals(resBeen.get(j).get住院号())) {
                    been.get(i).setSelect(true);
                }
            }
        }
        return been;
    }

    public void removeEmpty(Context context, ArrayList<AddMyPatientAdapterBean> data) {
        if (data == null) {
            return;
        }
        BedListDAOpe bedListDAOpe = new BedListDAOpe(context, null);
        for (int i = 0; i < data.size(); i++) {
            if (bedListDAOpe.isEmptyBed(data.get(i).get状态())) {
                data.remove(i);
                i--;
            }
        }
    }
}
