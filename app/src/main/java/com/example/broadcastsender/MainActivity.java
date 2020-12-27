package com.example.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }

    public void sendBroadcast(View view) {
        Intent intent=new Intent("com.example.EXAMPLE_ACTION");
        intent.putExtra("com.example.EXAMPLE_TEXT","broadcast received");
        sendBroadcast(intent);
    }

    BroadcastReceiver broadcastReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
String textReceived = intent.getStringExtra("com.example.EXAMPLE_TEXT");
textView.setText(textReceived);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter =new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}