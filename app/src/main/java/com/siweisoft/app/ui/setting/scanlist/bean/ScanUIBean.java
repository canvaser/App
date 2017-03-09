package com.siweisoft.app.ui.setting.scanlist.bean;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import java.io.Serializable;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-06.
 */

public class ScanUIBean extends BaseUIBean {


    @BindView(R.id.tv_msg)
    TextView msgTV;

    @BindView(R.id.tv_time)
    TextView timeTV;

    public ScanUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getMsgTV() {
        return msgTV;
    }

    public TextView getTimeTV() {
        return timeTV;
    }
}
