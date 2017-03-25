package com.summer.util.hellocharts.listener;


import com.summer.util.hellocharts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int bubbleIndex, BubbleValue value);

}
