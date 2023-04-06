package com.example.muistilistasovellus;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Item> items = new ArrayList<>();

    private static Storage storage = null;

    private Storage() {}

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void removeItem(String item) {
        int x = 0;
        for (Item i : items) {
            if (i.getItem().equals(item)) {
                break;
            }
        x++;
        }
        items.remove(x);
    }

    public ArrayList<Item> getItems() {return items;}

    public Item getItemById(int id) {return items.get(id);}

    public void addItem(Item item) {items.add(item);}

}
