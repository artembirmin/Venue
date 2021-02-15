package com.example.venue.di.app;

import android.content.Context;

import com.example.venue.App;
import com.example.venue.data.network.backendmodel.AuthorizationApi;
import com.example.venue.presentation.routers.AuthorizationRouter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, DBModule.class, RestModule.class, NavigationModule.class})
@Singleton
public interface AppComponent {

    void inject(App app);

    Context getContext();

    AuthorizationApi provideWeatherApi();

    AuthorizationRouter provideCommonCalculatorRouter();
}
