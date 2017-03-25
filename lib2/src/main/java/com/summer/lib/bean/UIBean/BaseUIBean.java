package com.summer.lib.bean.UIBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.summer.lib.bean.BaseBean;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2017-03-24.
 */

public abstract class BaseUIBean extends BaseBean {

    View view;

    public BaseUIBean(Context context, int xml) {
        view = LayoutInflater.from(context).inflate(xml, null);
        ButterKnife.bind(this, view);
    }

    public View getView() {
        return view;
    }

}
