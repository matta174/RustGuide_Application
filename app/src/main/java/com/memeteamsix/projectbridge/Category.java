package com.memeteamsix.projectbridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwnicholson on 4/18/2016.
 */
public class Category {
    private String name = "";
    private List<Subcategory> subs = new ArrayList<Subcategory>();
    private String picName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubs() {
        return subs;
    }

    public Category(String picName, String name, List<Subcategory> subs) {
        this.picName = picName;
        this.name = name;
        this.subs = subs;
    }

    public void setSubs(List<Subcategory> subs) {
        this.subs = subs;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }


}
