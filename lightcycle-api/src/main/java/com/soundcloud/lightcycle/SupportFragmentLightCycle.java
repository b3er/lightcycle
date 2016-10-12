package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

public interface SupportFragmentLightCycle<T extends Fragment> {
    void onAttach(T fragment, Activity activity);
    void onCreate(T fragment, Bundle bundle);
    void onViewCreated(T fragment, View view, Bundle savedInstanceState);
    void onActivityCreated(T fragment, Bundle bundle);
    void onStart(T fragment);
    void onResume(T fragment);
    boolean onOptionsItemSelected(T fragment, MenuItem item);
    void onActivityResult(T fragment, int requestCode, int resultCode, Intent data);
    void onPause(T fragment);
    void onStop(T fragment);
    void onSaveInstanceState(T fragment, Bundle bundle);
    void onDestroyView(T fragment);
    void onDestroy(T fragment);
    void onDetach(T fragment);
}
