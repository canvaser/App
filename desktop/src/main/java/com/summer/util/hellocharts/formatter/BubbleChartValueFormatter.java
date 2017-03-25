package com.summer.util.hellocharts.formatter;

import com.summer.util.hellocharts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    public int formatChartValue(char[] formattedValue, BubbleValue value);
}
