package com.soundcloud.lightcycle;

import android.view.View;

public interface ViewLightCycle<V extends View> {
    void onAttachedToWindow(V view);
    void onDetachedFromWindow(V view);
}
