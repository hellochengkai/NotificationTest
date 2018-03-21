package com.thunder.ktv.notificationtest;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        Log.d(TAG, "onCreate: " + bundle);
        int id = intent.getIntExtra("Notification_id",-1);
        setContentView(R.layout.activity_main2);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Log.d(TAG, "onCreate: cancel" + id);
        if(id >= 0){
            manager.cancel(id);
        }
    }
}
