package com.siweisoft.app.ui.check.checklist.bean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class CheckHeadUIBean extends BaseUIBean {


    @BindView(R.id.tv_name)
    TextView nameTV;

    @BindView(R.id.tv_count)
    TextView countTV;

    public CheckHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getCountTV() {
        return countTV;
    }

    public TextView getNameTV() {
        return nameTV;
    }
}
