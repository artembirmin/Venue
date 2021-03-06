package com.example.venue.di.app;

import com.example.venue.data.network.backendmodel.BackendModelApi;
import com.example.venue.data.network.backendmodel.BackendModelNetworkService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    BackendModelApi provideWeatherApi(BackendModelNetworkService weatherNetworkService) {
        return weatherNetworkService.getBackendModelApi();
    }
}
