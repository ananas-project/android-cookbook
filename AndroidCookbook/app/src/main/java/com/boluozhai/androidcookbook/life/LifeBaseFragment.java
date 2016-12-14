package com.boluozhai.androidcookbook.life;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LifeBaseFragment extends Fragment implements Life.OnCreate {


    private LifeManager mLife;


    protected LifeManager getLifeManager() {
        return mLife;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLife = new LifeManager(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLife.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateBegin(Bundle savedInstanceState) {

    }

    @Override
    public void onCreating(Bundle savedInstanceState) {

    }

    @Override
    public void onCreateEnd(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mLife.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mLife.onResume();
    }


    @Override
    public void onPause() {
        mLife.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mLife.onStop();
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        mLife.onDestroy();
        super.onDestroy();
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
