package com.memeteamsix.projectbridge;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DatabaseList extends ListActivity{

    ArrayAdapter<String> adapter;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);

        Intent i = getIntent();
        db = (DB) i.getSerializableExtra("Database");

        adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1);
        updateList();
    }
    private void updateList() {
        adapter.clear();
        adapter.addAll(db.getCurList());
        getListView().setAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (db.getCurOpenCat() == -1) {
            db.setCurOpenCat(position);
            updateList();
        } else if (db.getCurOpenSub() == -1) {
            db.setCurOpenSub(position);
            updateList();
        } else {
            db.setCurOpenItem(position);
            Intent goToDatabase = new Intent (getBaseContext(), Database.class);
            goToDatabase.putExtra("Database", db);
            startActivity(goToDatabase);
        }
    }

    @Override
    public void onBackPressed() {
        if (db.getCurOpenSub() != -1) {
            db.setCurOpenSub(-1);
            updateList();
        } else if (db.getCurOpenCat() != -1) {
            db.setCurOpenCat(-1);
            updateList();
        } else {
            super.onBackPressed();
        }
    }
}
