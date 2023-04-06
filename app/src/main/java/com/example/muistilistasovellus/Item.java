package com.example.muistilistasovellus;

import static java.lang.System.currentTimeMillis;

import java.sql.Timestamp;


public class Item {

    protected String item, notes, stringTs;
    protected int image;
    protected Timestamp ts;

    public Item () {}

    public Item(String item, String notes, Timestamp ts) {
        this.item = item;
        this.notes = notes;
        this.ts = ts;
        this.stringTs = ts.toString();
    }

    public String getItem() {return item;}

    public String getNotes() {return notes;}

    public int getImage() {return image;}

    public void setItem(String item) {this.item = item;}

    public void setNotes(String notes) {this.notes = notes;}
}
