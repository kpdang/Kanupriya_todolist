package com.example.admin.todoapp;

import java.util.ArrayList;

/**
 * Created by admin on 11/5/2016.
 */
public class ItemCollection {
    static ArrayList<Item> items=new ArrayList<>();

    public static ArrayList<Item> getItems()
    {
        return items;
    }
}
