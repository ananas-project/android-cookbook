package com.boluozhai.androidcookbook.life;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xukun on 16-12-13.
 */

public class LifeManager implements Life, LifeList {


    private final Life.OnCreate mOnCreate;
    private final List<Life> mList;


    public LifeManager(Life.OnCreate on_create) {
        mOnCreate = on_create;
        mList = new ArrayList<Life>();
    }


    @Override
    public void add(Life life) {
        mList.add(life);
    }


    @Override
    public void remove(Life life) {
        mList.remove(life);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            mOnCreate.onCreateBegin(savedInstanceState);
            mOnCreate.onCreating(savedInstanceState);

            for (Life item : mList) {
                item.onCreate(savedInstanceState);
            }

        } finally {
            mOnCreate.onCreateEnd(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        for (Life item : mList) {
            item.onStop();
        }
    }

    @Override
    public void onResume() {
        for (Life item : mList) {
            item.onResume();
        }
    }

    @Override
    public void onPause() {
        for (int i = mList.size() - 1; i >= 0; i--) {
            Life item = mList.get(i);
            item.onPause();
        }
    }

    @Override
    public void onStop() {
        for (int i = mList.size() - 1; i >= 0; i--) {
            Life item = mList.get(i);
            item.onStop();
        }
    }

    @Override
    public void onDestroy() {
        for (int i = mList.size() - 1; i >= 0; i--) {
            Life item = mList.get(i);
            item.onDestroy();
        }
    }

}
