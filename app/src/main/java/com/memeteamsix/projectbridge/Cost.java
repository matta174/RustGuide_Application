package com.memeteamsix.projectbridge;


import java.io.Serializable;

/**
 * Created by jwnicholson on 4/18/2016.
 */

public class Cost implements Serializable{
    int qty;
    int subcatIndex;
    int itemIndex;
    public Cost() {
    }

    public Cost(int qty, int subcatIndex, int itemIndex) {

        this.qty = qty;
        this.subcatIndex = subcatIndex;
        this.itemIndex = itemIndex;
        String picName;
        String name;

    }
}
