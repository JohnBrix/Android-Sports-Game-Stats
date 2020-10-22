package com.game_stats.sports_game_stats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.game_stats.sports_game_stats.controller.DashboardController;

public class MainActivity extends AppCompatActivity {
    ImageView footballFront;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splashscreen);
        footballFront = findViewById(R.id.cricketSplash);


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_leftoright);
        footballFront.startAnimation(animation);


        countTimer = new CountDownTimer(2290,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, DashboardController.class);
                startActivity(intent);
                finish(); //cut activity
            }
        }.start();
    }
}