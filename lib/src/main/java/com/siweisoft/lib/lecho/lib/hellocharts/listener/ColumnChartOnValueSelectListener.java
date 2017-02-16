package com.siweisoft.lib.lecho.lib.hellocharts.listener;


import com.siweisoft.lib.lecho.lib.hellocharts.model.SubcolumnValue;

public interface ColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

}
