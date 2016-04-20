package com.memeteamsix.projectbridge;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Database extends ListActivity {

    ArrayAdapter<String> adapter;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);

        db = new DB(this.getApplicationContext());
        db.loadDB();

        adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1);
        updateList();
    }

    private void updateList() {
        adapter.clear();
        adapter.addAll(db.getCurList());
        getListView().setAdapter(adapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (db.getCurOpenCat() == -1) {
            db.setCurOpenCat(position);
            updateList();
        } else if (db.getCurOpenSub() == -1) {
            db.setCurOpenSub(position);
            updateList();
        } else {
            this.finish();
        }
    }

    public void onBackPressed() {
        if (db.getCurOpenSub() != -1) {
            db.setCurOpenSub(-1);
            updateList();
        } else if (db.getCurOpenCat() != -1) {
            db.setCurOpenCat(-1);
            updateList();
        } else {
            this.finish();
        }
    }
}
