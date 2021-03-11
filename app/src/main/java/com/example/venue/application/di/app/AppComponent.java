package com.example.venue.application.di.app;

import android.content.Context;

import com.example.venue.application.App;
import com.example.venue.application.di.app.modules.AppModule;
import com.example.venue.application.di.app.modules.DBModule;
import com.example.venue.application.di.app.modules.NavigationModule;
import com.example.venue.application.di.app.modules.NetworkModule;
import com.example.venue.data.network.auth.AuthorizationApi;
import com.example.venue.presentation.navigation.AppRouter;

import javax.inject.Singleton;

import dagger.Component;
import ru.terrakok.cicerone.NavigatorHolder;

@Component(modules = {AppModule.class, DBModule.class, NetworkModule.class, NavigationModule.class})
@Singleton
public interface AppComponent {

    void inject(App app);

    Context getContext();

    AuthorizationApi provideAuthorizationApi();

    AppRouter provideAppRouter();

    NavigatorHolder provideNavigationHolder();
}
