package com.example.muistilistasovellus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Storage s = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), s.getItems()));
    }

    public void switchToAddItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    public void sortByItem(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Storage s = Storage.getInstance();
        items = s.getItems();

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.item.compareToIgnoreCase(i2.item);
            }
        });

        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), items));
    }
    public void sortByTimestamp(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Storage s = Storage.getInstance();
        items = s.getItems();

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.stringTs.compareToIgnoreCase(i2.stringTs);
            }
        });
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), items));
    }
}