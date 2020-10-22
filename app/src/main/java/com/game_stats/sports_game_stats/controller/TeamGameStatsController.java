package com.game_stats.sports_game_stats.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.game_stats.sports_game_stats.R;
import com.game_stats.sports_game_stats.adapters.TeamGameStatsAdapter;
import com.game_stats.sports_game_stats.model.TeamGameStatsModel;
import com.game_stats.sports_game_stats.service.SoccerApiService;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamGameStatsController extends AppCompatActivity {
    RecyclerView datalistGameStats;
    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    RecyclerView.LayoutManager gameStatsLayout;
    ImageView backToDashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_game_stats);
        datalistGameStats = findViewById(R.id.datalist_standing_recycler_view);
        backToDashboard = findViewById(R.id.back_to_dashboard_standing);
        progressBar = (ProgressBar) findViewById(R.id.spin_kit_gamestatts);
        Sprite chasingDots = new ThreeBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        getTeamGameStats();

        countDownTimer = new CountDownTimer(3500, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Please Wait...", Toast.LENGTH_SHORT).show();
            }
        }.start();
        backToDashboard();

    }

    public void getTeamGameStats(){
        gameStatsLayout = new LinearLayoutManager(this);
        datalistGameStats.setLayoutManager(gameStatsLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SoccerApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SoccerApiService soccerApiService = retrofit.create(SoccerApiService.class);

        Call<List<TeamGameStatsModel>> call = soccerApiService.getTeamGameStats();

        call.enqueue(new Callback<List<TeamGameStatsModel>>() {
            @Override
            public void onResponse(Call<List<TeamGameStatsModel>> call, Response<List<TeamGameStatsModel>> response) {
                if(response.isSuccessful()){
                    List<TeamGameStatsModel> teamGameStatsModels = response.body();

                    TeamGameStatsAdapter mAdapter = new TeamGameStatsAdapter(TeamGameStatsController.this, teamGameStatsModels);
                    datalistGameStats.setAdapter(mAdapter);
                }
                else{
                    dialogYesOrNo();
                }

            }

            @Override
            public void onFailure(Call<List<TeamGameStatsModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please fix your internet", Toast.LENGTH_SHORT).show();
                System.out.println("your error " + t);
                dialogYesOrNo();
            }
        });
    }

    public void backToDashboard() {
        backToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), DashboardController.class); //Open new Activity
                v.getContext().startActivity(myIntent);
                finish();
            }
        });
    }

    public void dialogYesOrNo(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Intent myIntent = new Intent(TeamGameStatsController.this, DashboardController.class); //Open new Activity
                        startActivity(myIntent);
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        getTeamGameStats();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Detected No Internet: Do you want to refresh or go back to dashboard?").setPositiveButton("go back", dialogClickListener)
                .setNegativeButton("refresh", dialogClickListener).show();
    }

    public void onBackPressed() {
        Intent myIntent = new Intent(TeamGameStatsController.this, DashboardController.class); //Open new Activity
        startActivity(myIntent);
        finish();
    }
}