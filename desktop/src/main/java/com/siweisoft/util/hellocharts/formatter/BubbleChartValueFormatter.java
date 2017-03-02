package com.siweisoft.util.hellocharts.formatter;

import com.siweisoft.util.hellocharts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    public int formatChartValue(char[] formattedValue, BubbleValue value);
}
