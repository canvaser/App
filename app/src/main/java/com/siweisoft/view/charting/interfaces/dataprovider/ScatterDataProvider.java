package com.siweisoft.view.charting.interfaces.dataprovider;

import com.siweisoft.view.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
