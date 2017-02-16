package com.siweisoft.lib.lecho.lib.hellocharts.formatter;


import com.siweisoft.lib.lecho.lib.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
