package com.boluozhai.androidcookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class FragmentDemoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //       this.requestWindowFeature(Window.FEATURE_RIGHT_ICON | Window.FEATURE_CONTEXT_MENU);

        //   getWindow().requestFeature(Window.FEATURE_ACTION_BAR);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);


        //  this.getActionBar().show();

    }


}

