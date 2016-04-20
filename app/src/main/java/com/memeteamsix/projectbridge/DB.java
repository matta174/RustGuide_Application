package com.memeteamsix.projectbridge;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Huff on 4/19/2016.
 */
public class DB {

    private ArrayList<Category> db = new ArrayList<Category>();
    private Context mCtx;
    private static final String TAG = "DB";

    private int curOpenCat = -1;
    private int curOpenSub = -1;
    private int curOpenItem = -1;
    private int resourceCat = -1;


    public DB(Context context){
        mCtx = context;
    }

    public int getCurOpenCat() {
        return curOpenCat;
    }

    public void setCurOpenCat(int curOpenCat) {
        this.curOpenCat = curOpenCat;
    }

    public int getCurOpenSub() {
        return curOpenSub;
    }

    public void setCurOpenSub(int curOpenSub) {
        this.curOpenSub = curOpenSub;
    }

    public int getCurOpenItem() {
        return curOpenItem;
    }

    public void setCurOpenItem(int curOpenItem) {
        this.curOpenItem = curOpenItem;
    }

    public ArrayList<String> getCatList() {
        ArrayList<String> catList = new ArrayList<>();
        for (int i = 0; i < db.size(); i++) {
            catList.add(db.get(i).getName());
        }
        return catList;
    }

    public ArrayList<String> getSubList() {
        ArrayList<String> subList = new ArrayList<>();
        for (int i = 0; i < db.get(curOpenCat).getSubs().size(); i++) {
            subList.add(db.get(curOpenCat).getSubs().get(i).getName());
        }
        return subList;
    }

    public ArrayList<String> getItemList() {
        ArrayList<String> itemList = new ArrayList<>();
        for (int i = 0; i < db.get(curOpenCat).getSubs().get(curOpenSub).getItems().size(); i++) {
            itemList.add(db.get(curOpenCat).getSubs().get(curOpenSub).getItems().get(i).getName());
        }
        return itemList;
    }

    public ArrayList<String> getCurList() {
        ArrayList<String> list = new ArrayList<>();
        if (curOpenCat == -1) {
            return getCatList();
        } else if (curOpenSub == -1) {
            return getSubList();
        } else {
            return getItemList();
        }
    }

    public String getResourceName(int sub, int item) {
        return db.get(resourceCat).getSubs().get(sub).getItems().get(item).getName();
    }

    public String getItemName() {
        return db.get(curOpenCat).getSubs().get(curOpenSub).getItems().get(curOpenItem).getName();
    }

    public String getItemImg() {
        return db.get(curOpenCat).getSubs().get(curOpenSub).getItems().get(curOpenItem).getPicName();
    }

    public String getItemDesc() {
        return db.get(curOpenCat).getSubs().get(curOpenSub).getItems().get(curOpenItem).getDesc();
    }

    protected void loadDB() {
        JSONObject obj = null;
        try{
            AssetManager am = mCtx.getAssets();
            InputStream is = am.open("db");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            obj = new JSONObject(new String(buffer, "UTF-8"));
            JSONArray arr = obj.getJSONArray("category");
            for (int i = 0; i < arr.length(); i++)
            {
                String post_id = arr.getJSONObject(i).getString("name");
                if (post_id.equals("Resources")){
                    resourceCat = i;
                }
                String post_img = arr.getJSONObject(i).getString("img");
                JSONObject obj2 = arr.getJSONObject(i);
                JSONArray arr2 = obj2.getJSONArray("subcategory");
                ArrayList<Subcategory> subcatList = new ArrayList<Subcategory>();
                for (int i2 = 0; i2 < arr2.length(); i2++)
                {
                    String post_id2 = arr2.getJSONObject(i2).getString("name");
                    JSONObject obj3 = arr2.getJSONObject(i2);
                    JSONArray arr3 = obj3.getJSONArray("items");
                    ArrayList<Item> itemList = new ArrayList<Item>();
                    for (int i3 = 0; i3 < arr3.length(); i3++)
                    {
                        String post_id3 = arr3.getJSONObject(i3).getString("name");
                        String post_img2 = arr3.getJSONObject(i3).getString("img");
                        String post_desc = arr3.getJSONObject(i3).getString("desc");
                        JSONObject obj4 = arr3.getJSONObject(i3);
                        ArrayList<Cost> costList = new ArrayList<>();
                        try {
                            JSONArray arr4 = obj4.getJSONArray("cost");
                            for (int i4 = 0; i4 < arr4.length(); i4++)
                            {
                                int post_qty = arr4.getJSONObject(i4).getInt("elementQty");
                                JSONObject obj5 = arr4.getJSONObject(i4);
                                JSONArray arr5 = obj5.getJSONArray("elementID");
                                Cost cost = new Cost(post_qty, arr5.getInt(0), arr5.getInt(1));
                                costList.add(cost);
                            }
                        }catch (JSONException e){

                        }
                        if (costList.isEmpty()){
                            Item item = new Item(post_id3, post_img2, post_desc);
                        }
                        Item item = new Item(post_id3, post_img2, post_desc, costList);
                        itemList.add(item);
                    }
                    Subcategory subcat = new Subcategory(post_id2, itemList);
                    subcatList.add(subcat);
                }
                Category cat = new Category(post_img, post_id, subcatList);
                db.add(cat);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
