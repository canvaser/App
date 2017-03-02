package com.siweisoft.view.charting.interfaces.dataprovider;

import com.siweisoft.view.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
