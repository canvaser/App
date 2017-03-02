package com.siweisoft.nurse.ui.index.bean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-14.
 */
public class PupListUIBean extends BaseUIBean {


    @BindView(R.id.txt)
    TextView textView;


    public PupListUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTextView() {
        return textView;
    }
}
