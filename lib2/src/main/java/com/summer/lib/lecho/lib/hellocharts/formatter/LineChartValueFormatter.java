package com.summer.lib.lecho.lib.hellocharts.formatter;


import com.summer.lib.lecho.lib.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    int formatChartValue(char[] formattedValue, PointValue value);
}
