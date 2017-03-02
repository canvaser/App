package com.siweisoft.util.hellocharts.formatter;


import com.siweisoft.util.hellocharts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
