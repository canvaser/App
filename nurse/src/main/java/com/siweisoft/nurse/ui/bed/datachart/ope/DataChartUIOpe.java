package com.siweisoft.nurse.ui.bed.datachart.ope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseNurseUIOpe;

import butterknife.BindView;

import com.siweisoft.lib.lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by ${viwmox} on 2016-12-08.
 */
public class DataChartUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.chart)
    LineChartView chart;

    @BindView(R.id.tv_left)
    TextView leftTV;

    @BindView(R.id.tv_mid)
    TextView midTV;

    @BindView(R.id.tv_right)
    TextView rightTV;

    public DataChartUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public LineChartView getChart() {
        return chart;
    }

    public TextView getLeftTV() {
        return leftTV;
    }

    @Nullable
    @Override
    public TextView getMidTV() {
        return midTV;
    }

    @Nullable
    @Override
    public TextView getRightTV() {
        return rightTV;
    }
}
