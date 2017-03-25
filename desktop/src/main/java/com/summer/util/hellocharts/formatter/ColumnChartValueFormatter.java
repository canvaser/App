package com.summer.util.hellocharts.formatter;

import com.summer.util.hellocharts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
