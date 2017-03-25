package com.summer.lib.lecho.lib.hellocharts.formatter;


import com.summer.lib.lecho.lib.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    int formatChartValue(char[] formattedValue, SliceValue value);
}
