package com.summer.lib.lecho.lib.hellocharts.formatter;


import com.summer.lib.lecho.lib.hellocharts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    int formatChartValue(char[] formattedValue, BubbleValue value);
}
