package com.siweisoft.view.charting.interfaces.dataprovider;

import com.siweisoft.view.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
