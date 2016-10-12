package com.soundcloud.lightcycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class LightCycleFragment<FragmentType extends Fragment> extends Fragment implements LightCycleDispatcher<FragmentLightCycle<FragmentType>> {

    private final FragmentLightCycleDispatcher<FragmentType> lightCycleDispatcher;
    private boolean bound;

    public LightCycleFragment() {
        lightCycleDispatcher = new FragmentLightCycleDispatcher<>();
    }

    @Override
    public void bind(FragmentLightCycle<FragmentType> lifeCycleComponent) {
        lightCycleDispatcher.bind(lifeCycleComponent);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        bindIfNecessary();
        lightCycleDispatcher.onAttach(fragment(), activity);
    }

    private void bindIfNecessary() {
        if (!bound) {
            LightCycles.bind(this);
            bound = true;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lightCycleDispatcher.onCreate(fragment(), savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lightCycleDispatcher.onViewCreated(fragment(), view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lightCycleDispatcher.onActivityCreated(fragment(), savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        lightCycleDispatcher.onStart(fragment());
    }

    @Override
    public void onResume() {
        super.onResume();
        lightCycleDispatcher.onResume(fragment());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return lightCycleDispatcher.onOptionsItemSelected(fragment(), item);
    }

    @Override
    public void onPause() {
        lightCycleDispatcher.onPause(fragment());
        super.onPause();
    }

    @Override
    public void onStop() {
        lightCycleDispatcher.onStop(fragment());
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        lightCycleDispatcher.onSaveInstanceState(fragment(), outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        lightCycleDispatcher.onDestroyView(fragment());
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        lightCycleDispatcher.onDestroy(fragment());
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        lightCycleDispatcher.onDetach(fragment());
        super.onDetach();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lightCycleDispatcher.onActivityResult(fragment(),requestCode,resultCode,data);
    }

    @SuppressWarnings("unchecked")
    private FragmentType fragment() {
        return (FragmentType) this;
    }
}
