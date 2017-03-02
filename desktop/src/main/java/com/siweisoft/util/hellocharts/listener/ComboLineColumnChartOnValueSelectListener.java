package com.siweisoft.util.hellocharts.listener;


import com.siweisoft.util.hellocharts.model.SubcolumnValue;
import com.siweisoft.util.hellocharts.model.PointValue;

public interface ComboLineColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onColumnValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

    public void onPointValueSelected(int lineIndex, int pointIndex, PointValue value);

}
