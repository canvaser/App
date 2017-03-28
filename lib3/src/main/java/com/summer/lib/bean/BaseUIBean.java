package com.summer.lib.bean;

//by summer on 2017-03-28.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

public class BaseUIBean extends BaseBean {

    protected Context context;

    private int xml;

    private View view;

    public BaseUIBean(Context context, int xml) {
        this.context = context;
        this.xml = xml;
        this.view = LayoutInflater.from(context).inflate(this.xml, null);
        ButterKnife.bind(this, view);
    }

    public BaseUIBean(Context context, View view) {
        this.context = context;
        this.view = view;
        ButterKnife.bind(this, this.view);
    }

    public View getView() {
        return view;
    }

    public int getXml() {
        return xml;
    }

    private BaseUIBean() {

    }
}
