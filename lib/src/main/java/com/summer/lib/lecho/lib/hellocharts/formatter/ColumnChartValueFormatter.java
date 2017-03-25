package com.summer.lib.lecho.lib.hellocharts.formatter;


import com.summer.lib.lecho.lib.hellocharts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
