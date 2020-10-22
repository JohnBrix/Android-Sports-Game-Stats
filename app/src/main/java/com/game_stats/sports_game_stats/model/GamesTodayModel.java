package com.game_stats.sports_game_stats.model;

import com.google.gson.annotations.SerializedName;

public class GamesTodayModel {
    @SerializedName("Status")
    public String status;
    @SerializedName("AwayTeamName")
    public String awayTeamName;
    @SerializedName("AwayTeamScore")
    public Integer awayTeamScore;
    @SerializedName("HomeTeamName")
    public String homeTeamName;
    @SerializedName("HomeTeamScore")
    public Integer homeTeamScore;

    public String getStatus() {
        return status;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }
}
