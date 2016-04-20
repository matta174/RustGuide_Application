package com.memeteamsix.projectbridge;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    DB db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);

        TextView nameValue = (TextView) findViewById(R.id.nameValue);
        TextView resourcesValue = (TextView) findViewById(R.id.resources1Value);
        TextView descriptoinValue = (TextView) findViewById(R.id.descriptionValue);

        Intent in = getIntent();
        db = (DB) in.getSerializableExtra("Database");

        Item item = db.getCurItem();

        nameValue.setText(item.getName());
        descriptoinValue.setText(item.getDesc());
        ArrayList<Cost> cost = item.getCost();
        String res = "";
        for (int i = 0; i < cost.size(); i++){
            res += cost.get(i).qty + "\t" +
                    db.getResourceName(cost.get(i).subcatIndex, cost.get(i).subcatIndex) + "\n";
        }
        resourcesValue.setText(res);
    }

}
