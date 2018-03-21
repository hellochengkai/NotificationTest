package com.thunder.ktv.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    NotificationManager notificationManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getApplication().getSystemService(Context.NOTIFICATION_SERVICE);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    int i = 0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:{
                Intent intent = new Intent(this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Notification_id",i);
                intent.putExtra("Bundle",bundle);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
                Notification notification = new NotificationCompat.Builder(getApplicationContext(),"哈哈哈哈哈哈")
                        .setContentTitle("haha" + i)
                        .setContentText("哈哈哈哈" + i)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_foreground))
                        .setContentIntent(pendingIntent)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.RED,1000,1000)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setAutoCancel(true)
                        .build();
                notificationManager.notify(i,notification);
                i++;
                Log.d(TAG, "onClick: ");
                break;
            }
        }
    }
}
