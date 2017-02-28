package com.siweisoft.lib.view.charting.interfaces.dataprovider;

import com.siweisoft.lib.view.charting.components.YAxis.AxisDependency;
import com.siweisoft.lib.view.charting.data.BarLineScatterCandleBubbleData;
import com.siweisoft.lib.view.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);

    boolean isInverted(AxisDependency axis);

    float getLowestVisibleX();

    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
