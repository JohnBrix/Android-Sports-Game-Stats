package com.game_stats.sports_game_stats.service;

import com.game_stats.sports_game_stats.model.GamesTodayModel;
import com.game_stats.sports_game_stats.model.TeamGameStatsModel;
import com.game_stats.sports_game_stats.model.TeamModel;
import com.game_stats.sports_game_stats.model.VenuesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerApiService {


    String BASE_URL = "https://api.sportsdata.io/";
    @GET("v3/soccer/scores/json/Teams?key=4e8697adc4984ed4a2324dc29ad4ff5d")
    Call<List<TeamModel> > getTeam();

    @GET("v3/soccer/scores/json/TeamGameStatsByDate/today?key=4e8697adc4984ed4a2324dc29ad4ff5d")
    Call<List<TeamGameStatsModel>> getTeamGameStats();

    @GET("v3/soccer/scores/json/GamesByDate/today?key=4e8697adc4984ed4a2324dc29ad4ff5d")
    Call<List<GamesTodayModel>> getGamesToday();

    @GET("v3/soccer/scores/json/Venues?key=4e8697adc4984ed4a2324dc29ad4ff5d")
    Call<List<VenuesModel>> getVenues();
}
