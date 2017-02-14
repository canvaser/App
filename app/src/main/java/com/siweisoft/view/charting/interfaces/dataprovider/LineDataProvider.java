package com.siweisoft.view.charting.interfaces.dataprovider;

import com.siweisoft.view.charting.components.YAxis;
import com.siweisoft.view.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
