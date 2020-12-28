package com.example.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.serviceinandroid.EXAMPLE_ACTION");
//        intent.setClass(this,ExampleBroadCastReceiverSender.class);

//        ComponentName componentName = new ComponentName("com.example.serviceinandroid"
//                ,"com.example.serviceinandroid.broadcast_receiver.ExampleBroadcastReceiver");
//        intent.setComponent(componentName);
//
//        intent.setClassName("com.example.serviceinandroid"
//                ,"com.example.serviceinandroid.broadcast_receiver.ExampleBroadcastReceiver");

//        intent.setPackage("com.example.serviceinandroid");

        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> infoList = packageManager.queryBroadcastReceivers(intent, 0);
        for (ResolveInfo info : infoList) {
            ComponentName componentName = new ComponentName(info.activityInfo.packageName
                    , info.activityInfo.name);
            intent.setComponent(componentName);
            sendBroadcast(intent);
        }
//         sendBroadcast(intent);
    }


}