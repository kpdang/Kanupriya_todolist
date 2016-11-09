package com.example.admin.todoapp;

import java.util.ArrayList;

/**
 * Created by admin on 11/5/2016.
 */
public class Operation {
    ArrayList<Item> items;

    public Operation(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean addItem(Item item) {
        try {
            items.add(item);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean update(int position, Item newitem) {
        try {
            items.remove(position);
            items.add(position, newitem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
