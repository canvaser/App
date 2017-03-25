package com.summer.lib.ui.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.summer.lib.R;
import com.summer.lib.bean.UIBean.BaseUIBean;
import com.summer.lib.view.base.BottomFinishView;

import butterknife.ButterKnife;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseUIOpe extends BaseOpe {


    TextView backTV;

    TextView midTV;

    TextView rightTV;

    ImageView infoIV;

    protected BaseUIBean uiBean;

    BottomFinishView bottomFinishView;

    Context context;

    public BaseUIOpe(Context context, BaseUIBean uiBean) {
        this.uiBean = uiBean;
        if (uiBean == null) {
            return;
        }
        ButterKnife.bind(this, uiBean.getView());
        this.context = context;
        backTV = (TextView) uiBean.getView().findViewById(R.id.ftv_back);
        midTV = (TextView) uiBean.getView().findViewById(R.id.ftv_title);
        rightTV = (TextView) uiBean.getView().findViewById(R.id.ftv_right);
        infoIV = (ImageView) uiBean.getView().findViewById(R.id.iv_info);
        bottomFinishView = (BottomFinishView) uiBean.getView().findViewById(R.id.finishview);
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

    public BottomFinishView getBottomFinishView() {
        return bottomFinishView;
    }
}
