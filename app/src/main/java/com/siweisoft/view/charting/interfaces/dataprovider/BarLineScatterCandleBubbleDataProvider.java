package com.siweisoft.view.charting.interfaces.dataprovider;

import com.siweisoft.view.charting.components.YAxis.AxisDependency;
import com.siweisoft.view.charting.data.BarLineScatterCandleBubbleData;
import com.siweisoft.view.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
