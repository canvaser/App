package com.summer.util.hellocharts.formatter;


import com.summer.util.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
