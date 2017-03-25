package com.summer.util.hellocharts.formatter;

import com.summer.util.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
