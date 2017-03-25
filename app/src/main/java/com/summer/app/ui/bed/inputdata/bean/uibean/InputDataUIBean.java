package com.summer.app.ui.bed.inputdata.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-25.
 */
public class InputDataUIBean extends BaseUIBean {

    @BindView(R.id.tv_name)
    TextView nameTV;

    @Nullable
    @BindView(R.id.et_value)
    EditText valueETV;

    @Nullable
    @BindView(R.id.tv_value)
    TextView valueTV;

    public InputDataUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNameTV() {
        return nameTV;
    }

    public EditText getValueETV() {
        return valueETV;
    }

    @Nullable
    public TextView getValueTV() {
        return valueTV;
    }
}
