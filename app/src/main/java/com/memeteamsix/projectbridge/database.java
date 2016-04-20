package com.memeteamsix.projectbridge;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Database extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        DB db = new DB(this.getApplicationContext());
        db.loadDB();

        ArrayList<String> tester = db.getCatList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, tester);
        getListView().setAdapter(adapter);
    }
}
