package com.siweisoft.lib.lecho.lib.hellocharts.listener;


import com.siweisoft.lib.lecho.lib.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
