package com.siweisoft.util.hellocharts.formatter;

import com.siweisoft.util.hellocharts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
