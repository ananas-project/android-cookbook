package com.boluozhai.androidcookbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(this.makeListAdapter());
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Adapter adapter = adapterView.getAdapter();
        Item item = (Item) adapter.getItem(i);
        item.open();
    }

    private ListAdapter makeListAdapter() {
        Class<?>[] classes = this.listActivityClasses();
        Item[] array = new Item[classes.length];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = new Item(classes[i]);
        }
        ArrayAdapter<Item> adapter;
        adapter = new
                ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, array);
        return adapter;
    }

    private class Item {

        private final String mText;
        private final Class<?> mType;

        public Item(Class<?> type) {
            mText = type.getSimpleName();
            mType = type;
        }


        @Override
        public String toString() {
            return mText;
        }

        public void open() {
            Context context = MainActivity.this;
            Intent intent = new Intent(context, mType);
            context.startActivity(intent);
        }


    }

    private Class<?>[] listActivityClasses() {
        Class<?>[] array = {LoginActivity.class, FragmentDemoActivity.class, CameraActivity.class};
        return array;
    }


}

