package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button guides_btn;
    private Button database_btn;
    private Button tools_btn;
    private Button links_btn;

    private ArrayList<Category> db = new ArrayList<Category>();

    //TAG for log files
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.guides_btn);
        Button fab2 = (Button) findViewById(R.id.database_btn);
        Button fab3 = (Button) findViewById(R.id.tools_btn);
        Button fab4 = (Button) findViewById(R.id.links_btn);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadDB();

    }

    View.OnClickListener a = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToGuides = new Intent(getBaseContext(), Guides.class);
            startActivity(goToGuides);
        }
    };
    View.OnClickListener b = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToDatabase = new Intent(getBaseContext(), Database.class);
            startActivity(goToDatabase);
        }
    };
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToTools = new Intent(getBaseContext(), shhh.class);
            startActivity(goToTools);
        }
    };
    View.OnClickListener d = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToLinks = new Intent(getBaseContext(), Links.class);
            startActivity(goToLinks);
        }
    };


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void loadDB() {
        JSONObject obj = null;
        try{
            AssetManager am = getAssets();
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
                String post_img = arr.getJSONObject(i).getString("img");
                JSONArray arr2 = obj.getJSONArray("subcategory");
                JSONObject obj2 = arr.getJSONObject(i);
                ArrayList<Subcategory> subcatList = new ArrayList<Subcategory>();
                for (int i2 = 0; i2 < arr2.length(); i2++)
                {
                    String post_id2 = arr2.getJSONObject(i2).getString("name");
                    JSONArray arr3 = obj2.getJSONArray("items");
                    JSONObject obj3 = arr2.getJSONObject(i2);
                    ArrayList<Item> itemList = new ArrayList<Item>();
                    for (int i3 = 0; i3 < arr3.length(); i3++)
                    {
                        String post_id3 = arr3.getJSONObject(i3).getString("name");
                        String post_img2 = arr3.getJSONObject(i3).getString("img");
                        String post_desc = arr3.getJSONObject(i3).getString("desc");
                        JSONArray arr4 = obj3.getJSONArray("cost");
                        JSONObject obj4 = arr3.getJSONObject(i3);
                        ArrayList<Cost> costList = new ArrayList<Cost>();
                        for (int i4 = 0; i4 < arr4.length(); i4++)
                        {
                            int post_qty = arr4.getJSONObject(i4).getInt("elementQty");
                            JSONArray arr5 = obj4.getJSONArray("elementID");
                            Cost cost = new Cost(post_qty, arr5.getInt(0), arr5.getInt(1));
                            costList.add(cost);
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
