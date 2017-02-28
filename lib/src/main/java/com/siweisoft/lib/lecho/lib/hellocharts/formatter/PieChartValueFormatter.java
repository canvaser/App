package com.siweisoft.lib.lecho.lib.hellocharts.formatter;


import com.siweisoft.lib.lecho.lib.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    int formatChartValue(char[] formattedValue, SliceValue value);
}
