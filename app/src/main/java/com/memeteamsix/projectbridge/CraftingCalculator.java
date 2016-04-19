package com.memeteamsix.projectbridge;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Matthew on 4/18/2016.
 */
public class CraftingCalculator extends AppCompatActivity {

    private EditText quantityInText;
    private EditText secondsPerItemIn;
    private Button timer_btn;
    private double timeIn = 0;
    private double quantityIn = 0;
    private double timeInMilli = 0;
    private NotificationCompat.Builder nBuilder;


    private TextView text1;

    private static final String FORMAT = "%02d:%02d:%02d";
    private int NumberofItems, SecondsPerItem;

    int seconds, minutes;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craftingcalculator);

        initializeApp();
        buildNotification();

    }

    private void buildNotification() {
        nBuilder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_timer_finished)
                .setContentTitle("Crafting finished.")
                .setContentText("Your resources have finished crafting");

        Intent calculatorIntent = new Intent(this, CraftingCalculator.class);
        PendingIntent calculatorPendingIntent = PendingIntent.getActivity(this, 0, calculatorIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        nBuilder.setContentIntent(calculatorPendingIntent);
    }

    private void initializeApp() {
        quantityInText = (EditText) findViewById(R.id.quantityInText);
        secondsPerItemIn = (EditText) findViewById(R.id.secondsPerItem);
        timer_btn = (Button) findViewById(R.id.timer_btn);
        text1 = (TextView) findViewById(R.id.textView1);
        calculateTime();
    }

    public void calculateTime() {

        timer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeIn = Double.parseDouble(secondsPerItemIn.getText().toString());
                quantityIn = Double.parseDouble(quantityInText.getText().toString());
                timeInMilli = (timeIn*quantityIn)*1000;
                new CountDownTimer((long)timeInMilli, 1000) { // adjust the milli seconds here

                    public void onTick(long millisUntilFinished) {

                        text1.setText("" + String.format(FORMAT,
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        text1.setText("done!");
                        sendNotification();
                    }
                }.start();


            }// end onclick
        }); //end onclick listener

    }//end calculate time

    private void sendNotification() {
        int notificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(notificationId, nBuilder.build());
    }
}//end initialize app
