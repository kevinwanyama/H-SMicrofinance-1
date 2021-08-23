package com.example.hsmicrofinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.hsmicrofinance.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private int TIMER=5;
    ActivitySplashScreenBinding mActivitySplashScreenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mActivitySplashScreenBinding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(mActivitySplashScreenBinding.getRoot());

        Launcher launcher = new Launcher();
        launcher.start();
    }

    private class Launcher extends Thread {
        public void run() {
            try {
                sleep(1000 * TIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            overridePendingTransition(0, 0);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            SplashScreen.this.finish();
        }
    }
}