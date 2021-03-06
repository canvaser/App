package com.summer.app.ui.info.addcheckbook.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-07.
 */
public class AddCheckBookUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;


    @BindView(R.id.tv_value)
    EditText valueETV;

    public AddCheckBookUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public EditText getValueETV() {
        return valueETV;
    }
}
