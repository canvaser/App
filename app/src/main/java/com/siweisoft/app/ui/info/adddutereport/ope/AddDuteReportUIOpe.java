package com.siweisoft.app.ui.info.adddutereport.ope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-17.
 */
public class AddDuteReportUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.tv_zs)
    EditText zsTV;

    @BindView(R.id.tv_ry)
    EditText ryTV;

    @BindView(R.id.tv_zc)
    EditText zcTV;

    @BindView(R.id.tv_cy)
    EditText cyTV;


    @BindView(R.id.tv_zr)
    EditText zrTV;

    @BindView(R.id.tv_sw)
    EditText swTV;

    @BindView(R.id.tv_gy)
    EditText gyTV;

    @BindView(R.id.tv_js)
    EditText jsTV;

    @BindView(R.id.tv_bw)
    EditText bwTV;

    @BindView(R.id.tv_banci)
    TextView banCiTV;


    public AddDuteReportUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getBackTV().setText("返回");
        getBackTV().setSelected(true);
        getMidTV().setText("交班本");
        getBackTV().setVisibility(View.VISIBLE);
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("提交");
    }

    public EditText getBwTV() {
        return bwTV;
    }

    public EditText getCyTV() {
        return cyTV;
    }

    public EditText getGyTV() {
        return gyTV;
    }

    public EditText getJsTV() {
        return jsTV;
    }


    public EditText getRyTV() {
        return ryTV;
    }

    public EditText getSwTV() {
        return swTV;
    }

    public EditText getZcTV() {
        return zcTV;
    }

    public EditText getZrTV() {
        return zrTV;
    }

    public EditText getZsTV() {
        return zsTV;
    }

    public TextView getBanCiTV() {
        return banCiTV;
    }


}
