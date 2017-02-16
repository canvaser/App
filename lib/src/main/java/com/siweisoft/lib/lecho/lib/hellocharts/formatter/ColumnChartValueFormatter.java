package com.siweisoft.lib.lecho.lib.hellocharts.formatter;


import com.siweisoft.lib.lecho.lib.hellocharts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
