package com.memeteamsix.projectbridge;

import java.util.ArrayList;

/**
 * Created by jwnicholson on 4/18/2016.
 */
public class Subcategory {
    private String name = "";
    private ArrayList<Item> items = new ArrayList<Item>();

    public Subcategory(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
