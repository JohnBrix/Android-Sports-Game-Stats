package com.game_stats.sports_game_stats.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.game_stats.sports_game_stats.adapters.TeamAdapter;
import com.game_stats.sports_game_stats.model.TeamModel;
import com.game_stats.sports_game_stats.service.SoccerApiService;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamController extends AppCompatActivity {
    ImageView backToDashboard;
    RecyclerView team;
    RecyclerView.LayoutManager homeLayout;
    ProgressBar progressBar;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalist_team);
        backToDashboard = findViewById(R.id.back_to_dashboard);
        team = findViewById(R.id.recycler_data_only_team);

        setBackToDashboard();
        getTeams();

        progressBar = (ProgressBar)findViewById(R.id.spin_kit_teams);
        Sprite chasingDots = new ThreeBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        countTimer = new CountDownTimer(2600,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Please wait...", Toast.LENGTH_SHORT).show();
            }
        }.start();

    }


    public void getTeams(){

        homeLayout = new GridLayoutManager(TeamController.this, 1, GridLayoutManager.VERTICAL, false);
        team.setLayoutManager(homeLayout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SoccerApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create api interface
        SoccerApiService footballApiService = retrofit.create(SoccerApiService.class);

        //object calling
        Call<List<TeamModel>> call = footballApiService.getTeam();

        call.enqueue(new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {
                if(response.isSuccessful()){
                    List<TeamModel> teamModels = (List<TeamModel>) response.body();

                    TeamAdapter mAdapter = new TeamAdapter(TeamController.this, teamModels);
                    team.setAdapter(mAdapter);
                }
                else{
                    dialogYesOrNo();

                }
            }

            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please fix your internet", Toast.LENGTH_SHORT).show();
                System.out.println("your error: "+t );
                dialogYesOrNo();
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
                        Intent myIntent = new Intent(TeamController.this, DashboardController.class); //Open new Activity
                        startActivity(myIntent);
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        getTeams();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Detected No Internet: Do you want to refresh or go back to dashboard?").setPositiveButton("go back", dialogClickListener)
                .setNegativeButton("refresh", dialogClickListener).show();
    }

    public void setBackToDashboard(){
        backToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(TeamController.this, DashboardController.class); //Open new Activity
                startActivity(myIntent);
                finish();
            }
        });
    }
    public void onBackPressed() {
        Intent myIntent = new Intent(TeamController.this, DashboardController.class); //Open new Activity
        startActivity(myIntent);
        finish();
    }

}