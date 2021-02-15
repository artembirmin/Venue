package com.example.venue.di.activity;

import com.example.venue.data.network.backendmodel.AuthorizationApi;
import com.example.venue.data.repositories.auth.AuthorizationRepository;
import com.example.venue.data.repositories.auth.AuthorizationRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @PerActivity
    @Provides
    AuthorizationRepository provideWeatherApiRepository(AuthorizationApi weatherApi) {
        return new AuthorizationRepositoryImpl(weatherApi);
    }
}
