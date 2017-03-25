package com.summer.util.hellocharts.listener;


import com.summer.util.hellocharts.model.SubcolumnValue;
import com.summer.util.hellocharts.model.PointValue;

public interface ComboLineColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onColumnValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

    public void onPointValueSelected(int lineIndex, int pointIndex, PointValue value);

}
