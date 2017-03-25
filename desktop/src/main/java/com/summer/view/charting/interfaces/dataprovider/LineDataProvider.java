package com.summer.view.charting.interfaces.dataprovider;

import com.summer.view.charting.components.YAxis;
import com.summer.view.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
