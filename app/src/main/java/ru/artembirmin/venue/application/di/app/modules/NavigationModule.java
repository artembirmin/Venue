package ru.artembirmin.venue.application.di.app.modules;

import ru.artembirmin.venue.presentation.navigation.AppRouter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;

@Module
public class NavigationModule {
    private final Cicerone<AppRouter> cicerone = Cicerone.create(new AppRouter());

    @Provides
    @Singleton
    public AppRouter provideAppRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    public NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
