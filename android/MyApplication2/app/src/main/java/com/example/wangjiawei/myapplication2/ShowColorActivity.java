package com.example.wangjiawei.myapplication2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.sql.Timestamp;

public class ShowColorActivity extends AppCompatActivity {

    String color;
    TextView colorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " this activity is created!");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_color);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // loginVO = (LoginVO) intent.getExtras().getSerializable(MainActivity.LOGIN_KEY);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // getIntent() should always return the most recent
        Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " onnew intent !" + color);
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = this.getIntent();
        color = (String)intent.getExtras().get("color");
        initComponent();
        Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " resume !" + color);

        //intent.removeExtra("color");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initComponent(){
        colorText = (TextView) findViewById(R.id.color);
        colorText.setText(color);
        if(color.equals("black"))
            colorText.setTextColor(Color.BLACK);
        else if(color.equals("red"))
            colorText.setTextColor(Color.RED);
        else if(color.equals("yellow"))
            colorText.setTextColor(Color.YELLOW);
        else if(color.equals("white"))
            colorText.setTextColor(Color.WHITE);
    }

}
