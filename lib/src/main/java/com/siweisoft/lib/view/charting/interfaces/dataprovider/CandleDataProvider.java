package com.siweisoft.lib.view.charting.interfaces.dataprovider;

import com.siweisoft.lib.view.charting.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
