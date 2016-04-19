package com.memeteamsix.projectbridge;

import java.util.ArrayList;

/**
 * Created by jwnicholson on 4/18/2016.
 */
public class Category {
    private String name = "";
    private ArrayList<Subcategory> subs = new ArrayList<Subcategory>();
    private String picName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subcategory> getSubs() {
        return subs;
    }

    public Category(String picName, String name, ArrayList<Subcategory> subs) {
        this.picName = picName;
        this.name = name;
        this.subs = subs;
    }

    public void setSubs(ArrayList<Subcategory> subs) {
        this.subs = subs;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String toString() {
        String cat = new String();
        cat = "Name: " + this.getName()
                + "\nSubcategories: ";
        for (int i = 0; i < this.getSubs().size(); i++) {
            cat += this.getSubs().get(i).getName() + "\n";
        }
        return cat;
    }

}
