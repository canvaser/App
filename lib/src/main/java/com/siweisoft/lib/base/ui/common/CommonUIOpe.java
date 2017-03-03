package com.siweisoft.lib.base.ui.common;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.lib.R;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class CommonUIOpe<A extends CommonUIFrag> extends CommonOpe {


    protected A frag;

    TextView backTV;

    TextView midTV;

    TextView rightTV;

    ImageView infoIV;

    protected View containerView;


    public CommonUIOpe(A frag, View containerView) {
        this.containerView = containerView;
        if (containerView == null) {
            return;
        }
        ButterKnife.bind(this, containerView);
        this.frag = frag;
        backTV = (TextView) containerView.findViewById(R.id.ftv_back);
        midTV = (TextView) containerView.findViewById(R.id.ftv_title);
        rightTV = (TextView) containerView.findViewById(R.id.ftv_right);
        infoIV = (ImageView) containerView.findViewById(R.id.iv_info);
    }


    public A getFrag() {
        return frag;
    }

    @Nullable
    public TextView getBackTV() {
        return backTV;
    }

    @Nullable
    public TextView getMidTV() {
        return midTV;
    }

    @Nullable
    public TextView getRightTV() {
        return rightTV;
    }

    @Nullable
    public ImageView getInfoIV() {
        return infoIV;
    }

}
