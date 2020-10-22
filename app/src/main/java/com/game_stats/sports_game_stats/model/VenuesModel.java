package com.game_stats.sports_game_stats.model;

import com.google.gson.annotations.SerializedName;

public class VenuesModel {

    @SerializedName("Name")
    public String name;
    @SerializedName("Address")
    public String address;
    @SerializedName("City")
    public String city;
    @SerializedName("Zip")
    public String zip;
    @SerializedName("Country")
    public String country;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
}
