package com.example.wangjiawei.myapplication1;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button black_button;
    private Button white_button;
    private Button red_button;
    private Button yellow_button;
    private Button testImplicit;
    private Button send_data_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponent();

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void initComponent(){
        black_button = (Button) findViewById(R.id.black_color);
        red_button = (Button) findViewById(R.id.red_button);
        yellow_button = (Button) findViewById(R.id.yellow_button);
        white_button = (Button) findViewById(R.id.white_button);
        testImplicit = (Button) findViewById(R.id.implicit_button);
        send_data_button = (Button) findViewById(R.id.send_data_button);

        black_button.setOnClickListener(this);
        red_button.setOnClickListener(this);
        yellow_button.setOnClickListener(this);
        white_button.setOnClickListener(this);
        testImplicit.setOnClickListener( e -> {
            Intent intent = new Intent();
            intent.setAction("testimplicit");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " this activity is called!");
            startActivity(intent);
        });

        send_data_button.setOnClickListener( e-> {
            Intent intent = new Intent();
            ComponentName comp = new ComponentName("com.example.wangjiawei.myapplication2","com.example.wangjiawei.myapplication2.SendDataActivity");
            intent.setComponent(comp);
            intent.setAction("android.intent.action.SENDDATA");
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 10000; i++){
                sb.append("aaaaaaaaaa");
            }
            String s = sb.toString();
            Log.d("Time", "size : "+s.getBytes().length);
            Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " this activity is called!");

            intent.putExtra("data",s);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String color = "";
        switch (v.getId()) {
            case R.id.black_color:  //登陆
                color = "black";
                break;
            case R.id.yellow_button:
                color = "yellow";
                break;
            case R.id.white_button:
                color = "white";
                break;
            case R.id.red_button:
                color = "red";
                break;
        }
        startNewApp(color);

    }

    private void startNewApp(String color){
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.example.wangjiawei.myapplication2","com.example.wangjiawei.myapplication2.ShowColorActivity");
        intent.setComponent(comp);
        intent.setAction("android.intent.action.SHOWCOLOR");
        intent.putExtra("color",color);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Log.d("Time",new Timestamp(System.currentTimeMillis()).toString() + " this activity is called!");
    }


}
