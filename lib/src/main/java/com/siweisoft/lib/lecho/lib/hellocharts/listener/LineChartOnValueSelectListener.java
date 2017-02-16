package com.siweisoft.lib.lecho.lib.hellocharts.listener;


import com.siweisoft.lib.lecho.lib.hellocharts.model.PointValue;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int lineIndex, int pointIndex, PointValue value);

}
