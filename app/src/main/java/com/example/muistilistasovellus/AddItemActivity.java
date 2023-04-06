package com.example.muistilistasovellus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.Timestamp;

public class AddItemActivity extends AppCompatActivity {

    private EditText item, note;
    private String sItem, sNote;
    private Timestamp ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void addItem(View view) {
        item = findViewById(R.id.typeIntoItem);
        note = findViewById(R.id.typeIntoNote);

        sItem = String.valueOf(item.getText());
        sNote = String.valueOf(note.getText());
        ts = new Timestamp(System.currentTimeMillis());

        Storage.getInstance().addItem(new Item(sItem, sNote, ts));
    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}