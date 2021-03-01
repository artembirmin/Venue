package com.example.venue.application;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;

import com.example.venue.application.broadcastreceivers.NetworkChangeReceiver;
import com.example.venue.application.di.app.AppComponent;
import com.example.venue.application.di.app.AppModule;
import com.example.venue.application.di.app.DaggerAppComponent;
import com.example.venue.presentation.navigation.AppRouter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;

public class App extends Application {

    private static final String TAG = "App";
    public static App instance;
    @Inject
    IntentFilter intentFilter;
    @Inject
    NetworkChangeReceiver networkChangeReceiver;
    @Inject
    AppRouter appRouter;
    private AppComponent appComponent;
    private Cicerone<AppRouter> cicerone;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        inject();
        Log.d(TAG, "onCreate: " + intentFilter);
        this.registerReceiver(networkChangeReceiver, intentFilter);
        cicerone = Cicerone.create(appRouter);
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public AppRouter getRouter() {
        return cicerone.getRouter();
    }

    public NetworkChangeReceiver getNetworkChangeReceiver() {
        return networkChangeReceiver;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void inject() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }
}
