package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button guides_btn;
    private Button database_btn;
    private Button tools_btn;
    private Button links_btn;

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
            Intent goToDatabase = new Intent(getBaseContext(), database.class);
            startActivity(goToDatabase);
        }
    };
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToTools = new Intent(getBaseContext(), tools.class);
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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //LoadDB tester please ignore
        try{
            Log.i(TAG,loadDB().toString());
        }catch (Exception e){
            Log.i(TAG,"Failed to load");
        }
    }

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

    protected JSONArray loadDB() {
        JSONObject json = null;
        try{
            AssetManager am = getAssets();
            InputStream is = am.open("db");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new JSONObject(new String(buffer, "UTF-8"));
            JSONArray arr = json.getJSONArray("category");
            for (int i = 0; i < arr.length(); i++)
            {
                String post_id = arr.getJSONObject(i).getString("name");
                JSONArray arr2 = json.getJSONArray("subcategory");
                for (int i2 = 0; i2 < arr2.length(); i2++)
                {
                    String post_id2 = arr2.getJSONObject(i2).getString("name");
                    JSONArray arr3 = json.getJSONArray("items");
                    for (int i3 = 0; i3 < arr3.length(); i3++)
                    {
                        String post_id3 = arr3.getJSONObject(i3).getString("name");
                        String post_img = arr3.getJSONObject(i3).getString("img");
                        String post_desc = arr3.getJSONObject(i3).getString("desc");
                        JSONArray arr4 = json.getJSONArray("cost");
                        for (int i4 = 0; i4 < arr4.length(); i4++)
                        {

                        }
                    }
                }
            }
            return json.getJSONArray("category");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
