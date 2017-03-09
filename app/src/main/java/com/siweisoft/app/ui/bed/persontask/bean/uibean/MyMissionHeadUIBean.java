package com.siweisoft.app.ui.bed.persontask.bean.uibean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class MyMissionHeadUIBean extends BaseUIBean {

    @BindView(R.id.tv_title)
    TextView titleTV;

    @BindView(R.id.tv_num)
    TextView numTV;

    @Nullable
    @BindView(R.id.ll_item)
    View itemV;

    public MyMissionHeadUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getNumTV() {
        return numTV;
    }

    public TextView getTitleTV() {
        return titleTV;
    }

    public View getItemV() {
        return itemV;
    }
}
