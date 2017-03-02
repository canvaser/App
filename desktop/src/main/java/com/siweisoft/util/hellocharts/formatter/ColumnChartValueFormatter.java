package com.siweisoft.util.hellocharts.formatter;

import com.siweisoft.util.hellocharts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
