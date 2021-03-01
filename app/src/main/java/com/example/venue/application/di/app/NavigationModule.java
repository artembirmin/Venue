package com.example.venue.application.di.app;

import com.example.venue.presentation.routers.AuthorizationRouter;
import com.example.venue.presentation.routers.AuthorizationRouterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigationModule {

    @Singleton
    @Provides
    AuthorizationRouter provideCommonCalculatorRouter() {
        return new AuthorizationRouterImpl();
    }
}
