package com.siweisoft.nurse.ui.app.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppHeadUIBean extends BaseUIBean {

    @BindView(R.id.tv_head)
    TextView headTV;

    public AppHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getHeadTV() {
        return headTV;
    }
}
