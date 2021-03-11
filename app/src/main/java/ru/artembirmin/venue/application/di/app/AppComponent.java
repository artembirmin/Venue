package ru.artembirmin.venue.application.di.app;

import android.content.Context;

import ru.artembirmin.venue.application.App;
import ru.artembirmin.venue.application.di.app.modules.AppModule;
import ru.artembirmin.venue.application.di.app.modules.DBModule;
import ru.artembirmin.venue.application.di.app.modules.NavigationModule;
import ru.artembirmin.venue.application.di.app.modules.NetworkModule;
import ru.artembirmin.venue.data.network.auth.AuthorizationApi;
import ru.artembirmin.venue.presentation.navigation.AppRouter;

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
