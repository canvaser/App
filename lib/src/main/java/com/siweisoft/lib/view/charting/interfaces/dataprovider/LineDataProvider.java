package com.siweisoft.lib.view.charting.interfaces.dataprovider;

import com.siweisoft.lib.view.charting.components.YAxis;
import com.siweisoft.lib.view.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
