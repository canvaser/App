package com.summer.view.charting.interfaces.dataprovider;

import com.summer.view.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
