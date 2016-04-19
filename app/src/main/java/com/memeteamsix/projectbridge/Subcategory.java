package com.memeteamsix.projectbridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwnicholson on 4/18/2016.
 */
public class Subcategory {
    private String name = "";
    private List<Item> items = new ArrayList<Item>();

    public Subcategory(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
