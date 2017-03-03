package com.siweisoft.nurse.ui.bed.advice.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-11-09.
 */
public class AdviceUIBean extends BaseUIBean {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_type)
    TextView typeTV;

    @BindView(R.id.tv_start)
    TextView startTV;

    @BindView(R.id.tv_end)
    TextView endTV;


    @BindView(R.id.tv_num)
    TextView numTV;

    @BindView(R.id.iv_codename)
    ImageView codeNameIV;

    public AdviceUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public TextView getEndTV() {
        return endTV;
    }

    public TextView getNumTV() {
        return numTV;
    }

    public TextView getStartTV() {
        return startTV;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTypeTV() {
        return typeTV;
    }

    public ImageView getCodeNameIV() {
        return codeNameIV;
    }
}
