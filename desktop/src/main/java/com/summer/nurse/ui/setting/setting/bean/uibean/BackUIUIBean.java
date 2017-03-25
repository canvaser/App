package com.summer.nurse.ui.setting.setting.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

import com.summer.app.R;
import com.summer.base.ui.bean.uibean.BaseUIBean;

/**
 * Created by summer on 2016/12/31 14:17.
 */

public class BackUIUIBean extends BaseUIBean {

    @BindView(R.id.tv_fragname)
    TextView fragNameTV;

    public BackUIUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getFragNameTV() {
        return fragNameTV;
    }
}
