package com.summer.app.ui.addwater.addwater.bean.uibean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddWaterDetailUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_value)
    TextView valueTV;

    public AddWaterDetailUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public AddWaterDetailUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getValueTV() {
        return valueTV;
    }
}
