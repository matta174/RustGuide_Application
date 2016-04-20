package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity{
    private Button guides_btn;
    private Button database_btn;
    private Button tools_btn;
    private Button links_btn;

    private DB db = null;

    //TAG for log files
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fab = (Button) findViewById(R.id.guides_btn);
        Button fab2 = (Button) findViewById(R.id.database_btn);
        Button fab3 = (Button) findViewById(R.id.tools_btn);
        Button fab4 = (Button) findViewById(R.id.links_btn);
        fab.setOnClickListener(a);
        fab2.setOnClickListener(b);
        fab3.setOnClickListener(c);
        fab4.setOnClickListener(d);

        db = new DB(this.getApplicationContext());
        db.loadDB();
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
            Intent goToDatabase = new Intent(getBaseContext(), DatabaseList.class);
            goToDatabase.putExtra("Database", db);
            startActivity(goToDatabase);
        }
    };
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToTools = new Intent(getBaseContext(), Tools.class);
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
}
