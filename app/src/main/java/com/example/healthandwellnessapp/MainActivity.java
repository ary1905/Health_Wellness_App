package com.example.healthandwellnessapp;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.firebase.FirebaseApp;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int POST_NOTIFICATIONS_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String email = preferences.getString("email", null);

        if (email != null) {
            Intent dashboardIntent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(dashboardIntent);
            finish();
        } else {
            startSunAnimation();
            startCloudAnimation();

            Button loginButton = findViewById(R.id.login_button);
            Button signUpButton = findViewById(R.id.signup_button);

            loginButton.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            });

            signUpButton.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            });
        }
        scheduleNotification();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "HealthMate Notifications";
            String description = "Channel for health-related notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("healthmate_channel", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            Log.d("Created", "Channel is Created");
        }
    }

    @SuppressLint("ScheduleExactAlarm")
    private void scheduleNotification() {
        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long triggerTimeMillis = System.currentTimeMillis();

        Log.d("MainActivity", "Alarm scheduled for: " + new Date(triggerTimeMillis));

        if (alarmManager != null) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTimeMillis, pendingIntent);
            Log.d("MainActivity", "Alarm set successfully");
        }
    }


    private void startSunAnimation() {
        ImageView sun = findViewById(R.id.sun);
        Path circularPath = new Path();
        circularPath.addCircle(430f, 500f, 400f, Path.Direction.CW);

        ObjectAnimator circularMovement = ObjectAnimator.ofFloat(sun, View.X, View.Y, circularPath);
        circularMovement.setDuration(5000);
        circularMovement.setRepeatCount(ValueAnimator.INFINITE);
        circularMovement.setInterpolator(new LinearInterpolator());
        circularMovement.start();

        ObjectAnimator continuousRotateSun = ObjectAnimator.ofFloat(sun, "rotation", 0f, 3600f);
        continuousRotateSun.setDuration(50000);
        continuousRotateSun.setRepeatCount(ValueAnimator.INFINITE);
        continuousRotateSun.setInterpolator(new LinearInterpolator());
        continuousRotateSun.start();
    }

    private void startCloudAnimation() {
        ImageView clouds1 = findViewById(R.id.clouds1);
        ImageView clouds2 = findViewById(R.id.clouds2);

        int screenWidth = getResources().getDisplayMetrics().widthPixels;

        clouds1.setTranslationX(-clouds1.getWidth() - 300);
        clouds1.setTranslationY(-50);

        ObjectAnimator moveCloud1 = ObjectAnimator.ofFloat(clouds1, "translationX", -clouds1.getWidth() - 300, screenWidth);
        moveCloud1.setDuration(6000);
        moveCloud1.setRepeatCount(ValueAnimator.INFINITE);
        moveCloud1.setRepeatMode(ValueAnimator.RESTART);
        moveCloud1.start();

        clouds2.setTranslationX(-clouds2.getWidth() - 300);
        clouds2.setTranslationY(50);

        ObjectAnimator moveCloud2 = ObjectAnimator.ofFloat(clouds2, "translationX", -clouds2.getWidth() - 300, screenWidth);
        moveCloud2.setStartDelay(2000);
        moveCloud2.setDuration(6000);
        moveCloud2.setRepeatCount(ValueAnimator.INFINITE);
        moveCloud2.setRepeatMode(ValueAnimator.RESTART);
        moveCloud2.start();
    }
}
