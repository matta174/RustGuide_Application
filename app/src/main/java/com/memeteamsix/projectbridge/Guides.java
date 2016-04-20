package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Matthew on 4/18/2016.
 */
public class Guides extends AppCompatActivity
{
    private Button rustWebGuide;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        rustWebGuide = (Button) findViewById(R.id.rustGuide_btn);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guides);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://rust.wikia.com/wiki/Basic_Survival_Guide"));
                startActivity(intent);

            }
        };

        rustWebGuide.setOnClickListener(a);


















    }






}//end main
