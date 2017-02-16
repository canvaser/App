package com.siweisoft.lib.lecho.lib.hellocharts.listener;


import com.siweisoft.lib.lecho.lib.hellocharts.model.PointValue;
import com.siweisoft.lib.lecho.lib.hellocharts.model.SubcolumnValue;

public interface ComboLineColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onColumnValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

    public void onPointValueSelected(int lineIndex, int pointIndex, PointValue value);

}
