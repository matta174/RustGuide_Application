package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Matthew on 4/18/2016.
 *
 */
public class Tools extends AppCompatActivity {

    private Button craftingCalculator_btn;


    @Override

        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button fab = (Button) findViewById(R.id.craftingCalculator_btn);
        fab.setOnClickListener(a);

    }

    View.OnClickListener a = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent goToGuides = new Intent(getBaseContext(), CraftingCalculator.class);
            startActivity(goToGuides);
        }
    };










    }//end class






















