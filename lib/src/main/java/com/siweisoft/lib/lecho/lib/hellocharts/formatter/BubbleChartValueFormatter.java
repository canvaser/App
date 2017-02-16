package com.siweisoft.lib.lecho.lib.hellocharts.formatter;


import com.siweisoft.lib.lecho.lib.hellocharts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    public int formatChartValue(char[] formattedValue, BubbleValue value);
}
