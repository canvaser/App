package com.summer.view.charting.interfaces.dataprovider;

import com.summer.view.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
