package com.memeteamsix.projectbridge;

/**
 * Created by jwnicholson on 4/18/2016.
 */
public class Item {
    private String name;
    private String picName;
    private String desc;


    public String getDesc() {
        return desc;
    }

    public Item(String name, String picName, String desc) {
        this.name = name;
        this.picName = picName;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
