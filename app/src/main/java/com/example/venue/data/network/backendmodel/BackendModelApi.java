package com.example.venue.data.network.backendmodel;

import com.example.venue.models.BackendModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BackendModelApi {
    @GET("data/2.5/weather?")
    Single<BackendModel> getCurrentWeatherData(@Query("lat") String lat,
                                               @Query("lon") String lon,
                                               @Query("APPID") String app_id);
}
