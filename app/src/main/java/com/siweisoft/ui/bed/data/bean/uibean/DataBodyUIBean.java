package com.siweisoft.ui.bed.data.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataBodyUIBean extends BaseUIBean {

    @BindView(R.id.tv_body_txt)
    TextView textView;

    public DataBodyUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getTextView() {
        return textView;
    }
}
