package com.siweisoft.nurse.ui.bed.advice.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class AdviceUIBean extends BaseUIBean {


    @BindView(R.id.tv_title)
    TextView titleView;



    public AdviceUIBean(Context context, View convertView) {
        super(context, convertView);
    }



    public TextView getTitleView() {
        return titleView;
    }
}
