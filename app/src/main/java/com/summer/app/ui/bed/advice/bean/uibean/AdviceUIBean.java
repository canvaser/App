package com.summer.app.ui.bed.advice.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.app.R;
import com.summer.lib.bean.uibean.BaseUIBean;

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

    @BindView(R.id.ll_before)
    View beforeView;

    @BindView(R.id.tv_after)
    View afterView;

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

    public View getAfterView() {
        return afterView;
    }

    public View getBeforeView() {
        return beforeView;
    }
}
