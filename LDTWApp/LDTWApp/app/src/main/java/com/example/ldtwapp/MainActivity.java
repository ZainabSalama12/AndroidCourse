package com.example.ldtwapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity {
    //Splash screen period variable
    private static int splashScreen = 5000;

    //variables for splash page animation
    Annotation topAnim,botAnim;
    ImageView image;
    TextView appName,appLongName;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Context context;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context);

        //Going to next screen after 5sec from animation

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },splashScreen);
    }
}