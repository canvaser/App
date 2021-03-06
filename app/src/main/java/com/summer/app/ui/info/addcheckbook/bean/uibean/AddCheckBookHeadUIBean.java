package com.summer.app.ui.info.addcheckbook.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookHeadUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;


    @BindView(R.id.tv_value)
    TextView valueETV;

    public AddCheckBookHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public TextView getValueETV() {
        return valueETV;
    }
}
