package com.game_stats.sports_game_stats.model;

import com.google.gson.annotations.SerializedName;

public class TeamGameStatsModel {

    @SerializedName("Season")
    public Integer season;
    @SerializedName("Team")
    public String team;
    @SerializedName("Opponent")
    public String opponent;
    @SerializedName("DateTime")
    public String dateTime;
    @SerializedName("HomeOrAway")
    public String homeOrAway;
    @SerializedName("UpdatedUtc")
    public String updatedUtc;


    public Integer getSeason() {
        return season;
    }

    public String getTeam() {
        return team;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getHomeOrAway() {
        return homeOrAway;
    }

    public String getUpdatedUtc() {
        return updatedUtc;
    }
}
