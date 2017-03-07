package com.siweisoft.nurse.ui.check.patientcheck.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonOpes;
import com.siweisoft.lib.base.ui.common.CommonUIFrag;
import com.siweisoft.nurse.ui.check.patientcheck.ope.PatientCheckDAOpe;
import com.siweisoft.nurse.ui.check.patientcheck.ope.PatientCheckUIOpe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class PatientCheckFarg extends CommonUIFrag<PatientCheckUIOpe, PatientCheckDAOpe> {

    @Override
    public int onCreateView(boolean create) {
        if (create) {
            opes = new CommonOpes<>(new PatientCheckUIOpe(fragment, getView()), new PatientCheckDAOpe(fragment));
        }
        return R.layout.frag_patientcheck;
    }
}
