package com.summer.util.hellocharts.listener;


import com.summer.util.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
