package com.example.venue.models.net;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BackendModel {

    @SerializedName("weather")
    private final ArrayList<WeatherItem> weather = new ArrayList<WeatherItem>();
    @SerializedName("name")
    private String name;
    @SerializedName("main")
    private Main main;

    public String getName() {
        return name;
    }

    public ArrayList<WeatherItem> getWeather() {
        return weather;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " " + weather.get(0).main + " " + String.format("%.1f", (main.temp - 273.15));
    }

    static class Main {

        @SerializedName("temp")
        public float temp;

    }

    static class WeatherItem {

        @SerializedName("main")
        private String main;

        public String getMain() {
            return main;
        }
    }
}

