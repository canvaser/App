package com.siweisoft.test;

//by summer on 2017-03-25.

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.summer.lib.bean.BaseUIBean;

import butterknife.BindView;

public class RecycleUIBean extends BaseUIBean {


    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.text)
    TextView text;

    public RecycleUIBean(Context context) {
        super(context, R.layout.frag_test);
    }
}
