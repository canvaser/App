package com.siweisoft.app.ui.addwater.addaddwater.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;
import com.siweisoft.lib.view.textview.AppEditText;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-21.
 */

public class AddAddWaterUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @Nullable
    @BindView(R.id.et_txt)
    AppEditText txtET;

    @BindView(R.id.down)
    View downV;

    @Nullable
    @BindView(R.id.tv_txt)
    TextView txtTV;

    public AddAddWaterUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public AddAddWaterUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public View getDownV() {
        return downV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public AppEditText getTxtET() {
        return txtET;
    }

    @Nullable
    public TextView getTxtTV() {
        return txtTV;
    }
}
