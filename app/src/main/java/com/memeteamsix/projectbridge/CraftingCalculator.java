package com.memeteamsix.projectbridge;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matthew on 4/18/2016.
 */
public class CrafticCalculator extends extends AppCompatActivity {

    private EditText quantityIn;
    private EditText secondsPerItemIn;


    TextView text1;

    private static final String FORMAT = "%02d:%02d:%02d";
    private int NumberofItems,SecondsPerItem;

    int seconds , minutes;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craftingcalculator);


        text1=(TextView)findViewById(R.id.textView1);

        new CountDownTimer(16069000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                text1.setText("done!");
            }
        }.start();

    }

}