package com.summer.app.ui.addwater.addaddwater.bean.uibean;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-17.
 */

public class DiSuUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView timeTV;


    public DiSuUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getTimeTV() {
        return timeTV;
    }
}
