package com.siweisoft.ui.bed.data.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class DataBodyUIBean3 extends BaseUIBean {

    @BindView(R.id.list_data_container)
    LinearLayout textLL;

    public DataBodyUIBean3(Context context, View convertView) {
        super(context, convertView);
    }

    public LinearLayout getTextLL() {
        return textLL;
    }
}
