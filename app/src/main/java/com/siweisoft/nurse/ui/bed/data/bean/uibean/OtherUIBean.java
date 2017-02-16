package com.siweisoft.nurse.ui.bed.data.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-11.
 */
public class OtherUIBean extends BaseUIBean{


    @BindView(R.id.tv_head_other)
    TextView headTV;

    @BindView(R.id.ll_content)
    View contentView;

    public OtherUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getHeadTV() {
        return headTV;
    }

    public View getContentView() {
        return contentView;
    }
}
