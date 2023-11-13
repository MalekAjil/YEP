package com.undp.aep.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.undp.aep.Model.Form;
import com.undp.aep.R;

public class SplashActivity extends AppCompatActivity {
    public  int TIME=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();



    }
    Handler handler;
    @Override
    protected void onResume() {
        super.onResume();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(TIME);
                    handler.post(new Runnable() {
                        public void run() {
                            goToNextScreen();
                        }
                    });
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();
    }
    protected void goToNextScreen() {

        int first=getSharedPreferences("myapp",MODE_PRIVATE).getInt("first",0);


            startActivity(new Intent(SplashActivity.this, MainActivity.class));


         SplashActivity.this.finish();
    }
    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }


}