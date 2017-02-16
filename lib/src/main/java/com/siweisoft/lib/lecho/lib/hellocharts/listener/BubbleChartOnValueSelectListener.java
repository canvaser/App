package com.siweisoft.lib.lecho.lib.hellocharts.listener;


import com.siweisoft.lib.lecho.lib.hellocharts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int bubbleIndex, BubbleValue value);

}
