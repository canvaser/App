package com.siweisoft.nurse.ui.info.bedcheck.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-30.
 */
public class BedCheckUIBean extends BaseUIBean{

    @BindView(R.id.tv_date)
    TextView dateTV;

    @BindView(R.id.tv_area)
    TextView areaTV;

    @BindView(R.id.tv_room)
    TextView roomTV;

    @BindView(R.id.tv_name)
    TextView nameTV;

    public BedCheckUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getAreaTV() {
        return areaTV;
    }

    public TextView getDateTV() {
        return dateTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getRoomTV() {
        return roomTV;
    }
}
