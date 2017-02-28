package com.siweisoft.lib.lecho.lib.hellocharts.animation;

import java.util.EventListener;

/**
 * Listener used to listen for chart animation start and stop events. Implementations of this interface can be used for
 * all types of chart animations(data, viewport, PieChart rotation).
 */
public interface ChartAnimationListener extends EventListener {

    void onAnimationStarted();

    void onAnimationFinished();

}
