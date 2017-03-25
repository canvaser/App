package com.siweisoft.test;

//by summer on 2017-03-25.

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.summer.lib.R;
import com.summer.lib.R2;
import com.summer.lib.bean.UIBean.BaseUIBean;

import butterknife.BindView;

public class MainUIBean extends BaseUIBean {


    @BindView(R2.id.sipLabel)
    TextView sipLabel;
    @BindView(R2.id.pushToTalk)
    ToggleButton pushToTalk;
    @BindView(R2.id.id)
    EditText id;
    @BindView(R2.id.init)
    TextView init;
    @BindView(R2.id.call)
    TextView call;
    @BindView(R2.id.edit)
    TextView edit;
    @BindView(R2.id.end)
    TextView end;

    public MainUIBean(Context context) {
        super(context, R.layout.walkietalkie);
    }

}
