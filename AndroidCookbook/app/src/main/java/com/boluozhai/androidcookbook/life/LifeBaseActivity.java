package com.boluozhai.androidcookbook.life;

import android.app.Activity;
import android.os.Bundle;

public class LifeBaseActivity extends Activity implements Life.OnCreate {


    private LifeManager mLife;


    protected LifeManager getLifeManager() {
        return mLife;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLife = new LifeManager(this);
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
    protected void onStart() {
        super.onStart();
        mLife.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mLife.onResume();
    }


    @Override
    protected void onPause() {
        mLife.onPause();
        super.onPause();
    }


    @Override
    protected void onStop() {
        mLife.onStop();
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        mLife.onDestroy();
        super.onDestroy();
    }


}
