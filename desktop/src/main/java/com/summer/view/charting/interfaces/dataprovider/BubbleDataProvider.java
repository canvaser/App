package com.summer.view.charting.interfaces.dataprovider;

import com.summer.view.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
