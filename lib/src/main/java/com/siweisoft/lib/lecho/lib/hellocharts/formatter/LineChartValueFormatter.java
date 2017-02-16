package com.siweisoft.lib.lecho.lib.hellocharts.formatter;


import com.siweisoft.lib.lecho.lib.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
