package com.summer.view.charting.interfaces.dataprovider;

import com.summer.view.charting.components.YAxis.AxisDependency;
import com.summer.view.charting.data.BarLineScatterCandleBubbleData;
import com.summer.view.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);

    boolean isInverted(AxisDependency axis);

    float getLowestVisibleX();

    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
