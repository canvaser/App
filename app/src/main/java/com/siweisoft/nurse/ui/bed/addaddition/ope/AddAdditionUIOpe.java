package com.siweisoft.nurse.ui.bed.addaddition.ope;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-22.
 */
public class AddAdditionUIOpe extends BaseNurseUIOpe{


    @BindView(R.id.tv_daoguan)
    TextView daoguanTV;

    @BindView(R.id.tv_care)
    TextView careTV;


    public AddAdditionUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setSelected(true);
        getBackTV().setText("返回");
    }
}
