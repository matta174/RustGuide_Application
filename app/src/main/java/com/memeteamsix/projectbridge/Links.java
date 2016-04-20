package com.memeteamsix.projectbridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

public class Links extends AppCompatActivity {

   private Button rustWebBtn;
   private Button rustFbBtn;
   private Button rustTwtBtn;
   private Button rustUpBtn;
   private Button rustFpBtn;
   private Button rustSteamBtn;
   private Button rustSubBtn;
   private Button rustafiedBtn;
   private Button oxiemodBtn;
   private Button playrustBtn;
   private Button rustioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        rustFbBtn = (Button) findViewById(R.id.rust_fb_btn);
        rustFpBtn = (Button) findViewById(R.id.facepunch_btn);
        rustSteamBtn = (Button) findViewById(R.id.steam_btn);
        rustSubBtn = (Button) findViewById(R.id.subreddit_btn);
        rustTwtBtn = (Button) findViewById(R.id.rust_twt_btn);
        rustUpBtn = (Button) findViewById(R.id.rust_up_btn);
        rustWebBtn = (Button) findViewById(R.id.rust_web_btn);
        rustafiedBtn = (Button) findViewById(R.id.rustafied_btn);
        oxiemodBtn = (Button) findViewById(R.id.oxiemod_btn);
        playrustBtn = (Button) findViewById(R.id.playrust_btn);
        rustioBtn = (Button) findViewById(R.id.rustio_btn);

        View.OnClickListener fbLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/facepunchrust"));
                startActivity(intent);
            }
        };

        View.OnClickListener fpLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://facepunch.com/forumdisplay.php?f=415"));
                startActivity(intent);
            }
        };

        View.OnClickListener steamLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://steamcommunity.com/app/252490"));
                startActivity(intent);
            }
        };

        View.OnClickListener subLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.reddit.com/r/playrust"));
                startActivity(intent);
            }
        };

        View.OnClickListener twtLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/playrust"));
                startActivity(intent);
            }
        };

        View.OnClickListener upLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://twitter.com/RustUpdates"));
                startActivity(intent);
            }
        };

        View.OnClickListener webLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://playrust.com/"));
                startActivity(intent);
            }
        };

        View.OnClickListener rustafiedLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://rustafied.com/"));
                startActivity(intent);
            }
        };

        View.OnClickListener oxieLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://oxidemod.org/#rust-experimental.49"));
                startActivity(intent);
            }
        };

        View.OnClickListener playRstLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.playrusthq.com/"));
                startActivity(intent);
            }
        };

        View.OnClickListener rstIoLstnr = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://playrust.io/"));
                startActivity(intent);
            }
        };

        rustFbBtn.setOnClickListener(fbLstnr);
        rustFpBtn.setOnClickListener(fpLstnr);
        rustSteamBtn.setOnClickListener(steamLstnr);
        rustSubBtn.setOnClickListener(subLstnr);
        rustTwtBtn.setOnClickListener(twtLstnr);
        rustUpBtn.setOnClickListener(upLstnr);
        rustWebBtn.setOnClickListener(webLstnr);
        rustafiedBtn.setOnClickListener(rustafiedLstnr);
        oxiemodBtn.setOnClickListener(oxieLstnr);
        playrustBtn.setOnClickListener(playRstLstnr);
        rustioBtn.setOnClickListener(rstIoLstnr);
    }
}
