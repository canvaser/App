package com.siweisoft.nurse.ui.check.patientcheck.ope;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.common.CommonUIFrag;
import com.siweisoft.lib.base.ui.common.CommonUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-07.
 */

public class PatientCheckUIOpe extends CommonUIOpe {

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_bedid)
    TextView tvBedid;
    @BindView(R.id.tv_zyh)
    TextView tvZyh;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_guoming)
    TextView tvGuoming;
    @BindView(R.id.tv_taskname)
    TextView tvTaskname;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_key)
    TextView tvKey;
    @BindView(R.id.tv_advid)
    TextView tvAdvid;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.recycle)
    RecyclerView recycle;


    public PatientCheckUIOpe(CommonUIFrag frag, View containerView) {
        super(frag, containerView);
        getBackTV().setText("返回");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getMidTV().setText("病人用药核对");
    }
}
