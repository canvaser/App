package com.summer.util.hellocharts.listener;


import com.summer.util.hellocharts.model.SubcolumnValue;

public interface ColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

}
