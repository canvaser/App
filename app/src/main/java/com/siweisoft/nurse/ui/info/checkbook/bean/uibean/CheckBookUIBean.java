package com.siweisoft.nurse.ui.info.checkbook.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class CheckBookUIBean extends BaseUIBean{

    @BindView(R.id.tv_name)
    TextView nameTV;


    public CheckBookUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public void setNameTV(TextView nameTV) {
        this.nameTV = nameTV;
    }
}
