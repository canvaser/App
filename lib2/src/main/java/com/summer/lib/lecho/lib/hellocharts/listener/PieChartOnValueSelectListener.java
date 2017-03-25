package com.summer.lib.lecho.lib.hellocharts.listener;


import com.summer.lib.lecho.lib.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    void onValueSelected(int arcIndex, SliceValue value);

}
