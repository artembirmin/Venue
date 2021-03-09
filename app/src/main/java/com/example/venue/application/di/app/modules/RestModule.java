package com.example.venue.application.di.app.modules;

import com.example.venue.data.network.auth.AuthorizationApi;
import com.example.venue.data.network.auth.AuthorizationNetworkService;
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
    AuthorizationApi provideAuthorizationApi(AuthorizationNetworkService authorizationNetworkService) {
        return authorizationNetworkService.getAuthorizationApi();
    }
}
