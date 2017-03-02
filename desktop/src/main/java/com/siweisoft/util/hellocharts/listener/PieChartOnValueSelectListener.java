package com.siweisoft.util.hellocharts.listener;


import com.siweisoft.util.hellocharts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
