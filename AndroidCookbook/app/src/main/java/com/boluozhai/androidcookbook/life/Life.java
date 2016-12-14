package com.boluozhai.androidcookbook.life;

import android.os.Bundle;

public interface Life {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();


    interface OnCreate {

        void onCreateBegin(Bundle savedInstanceState);

        void onCreating(Bundle savedInstanceState);

        void onCreateEnd(Bundle savedInstanceState);

    }


}
