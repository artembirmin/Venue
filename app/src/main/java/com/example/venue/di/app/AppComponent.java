package com.example.venue.di.app;

import android.content.Context;
import android.view.accessibility.AccessibilityRecord;

import com.example.venue.data.network.backendmodel.BackendModelApi;
import com.example.venue.presentation.routers.AuthorizationRouter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DBModule.class, RestModule.class, NavigationModule.class})
@Singleton
public interface AppComponent {

    Context getContext();

    BackendModelApi provideWeatherApi();

    AuthorizationRouter provideCommonCalculatorRouter();
}
