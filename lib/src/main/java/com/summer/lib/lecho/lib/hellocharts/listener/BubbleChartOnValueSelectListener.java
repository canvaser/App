package com.summer.lib.lecho.lib.hellocharts.listener;


import com.summer.lib.lecho.lib.hellocharts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    void onValueSelected(int bubbleIndex, BubbleValue value);

}
