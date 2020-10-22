package com.game_stats.sports_game_stats.model;

import com.google.gson.annotations.SerializedName;

public class TeamModel {
    @SerializedName("FullName")
    public String fullName;
    @SerializedName("Active")
    public Boolean active;
    @SerializedName("AreaName")
    public String areaName;
    @SerializedName("VenueName")
    public String venueName;
    @SerializedName("Address")
    public String address;
    @SerializedName("City")
    public String city;
    @SerializedName("Zip")
    public String zip;
    @SerializedName("Phone")
    public String phone;
    @SerializedName("Website")
    public String website;
    @SerializedName("WikipediaLogoUrl")
    public String wikipediaLogoUrl;

    public String getFullName() {
        return fullName;
    }

    public Boolean getActive() {
        return active;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getVenueName() {
        return venueName;
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

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getWikipediaLogoUrl() {
        return wikipediaLogoUrl;
    }
}
