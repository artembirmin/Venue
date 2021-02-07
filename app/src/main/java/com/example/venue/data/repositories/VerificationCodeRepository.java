package com.example.venue.data.repositories;

import com.example.venue.models.BackendModel;

import io.reactivex.Single;

public interface VerificationCodeRepository {

    String WEATHER_API_KEY = "52890ff4987cf82ef04c79cccc4bd74c";
    String BASE_URL = "https://api.openweathermap.org/";

    Single<Boolean> getWeather(double lat, double lon);
}
