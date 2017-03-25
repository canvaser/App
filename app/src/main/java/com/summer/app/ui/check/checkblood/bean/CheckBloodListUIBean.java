package com.summer.app.ui.check.checkblood.bean;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-03-15.
 */

public class CheckBloodListUIBean extends BaseUIBean {


    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.tv_msg)
    TextView tvMsg;

    public CheckBloodListUIBean(Context context, ViewGroup parent, int convertViewId) {
        super(context, parent, convertViewId);
    }

    public TextView getTvCode() {
        return tvCode;
    }

    public void setTvCode(TextView tvCode) {
        this.tvCode = tvCode;
    }

    public TextView getTvMsg() {
        return tvMsg;
    }

    public void setTvMsg(TextView tvMsg) {
        this.tvMsg = tvMsg;
    }
}
