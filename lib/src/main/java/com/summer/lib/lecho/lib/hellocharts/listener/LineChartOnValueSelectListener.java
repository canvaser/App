package com.summer.lib.lecho.lib.hellocharts.listener;


import com.summer.lib.lecho.lib.hellocharts.model.PointValue;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {

    void onValueSelected(int lineIndex, int pointIndex, PointValue value);

}
