package com.siweisoft.lib.view.charting.interfaces.dataprovider;

import com.siweisoft.lib.view.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
