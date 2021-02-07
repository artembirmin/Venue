package com.example.venue.di.activity;

import com.example.venue.data.network.backendmodel.BackendModelApi;
import com.example.venue.data.repositories.VerificationCodeRepository;
import com.example.venue.data.repositories.VerificationCodeRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @PerActivity
    @Provides
    VerificationCodeRepository provideWeatherApiRepository(BackendModelApi weatherApi){
        return new VerificationCodeRepositoryImpl(weatherApi);
    }
}
