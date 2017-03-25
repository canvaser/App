package com.summer.lib.lecho.lib.hellocharts.listener;


import com.summer.lib.lecho.lib.hellocharts.model.SubcolumnValue;

public interface ColumnChartOnValueSelectListener extends OnValueDeselectListener {

    void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

}
