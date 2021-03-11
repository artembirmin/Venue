package com.example.venue.application;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;

import com.example.venue.application.broadcastreceivers.NetworkChangeReceiver;
import com.example.venue.application.di.app.AppComponent;
import com.example.venue.application.di.app.DaggerAppComponent;
import com.example.venue.application.di.app.modules.AppModule;

import javax.inject.Inject;


public class App extends Application {

    private static final String TAG = "App";
    public static App instance;
    @Inject
    IntentFilter intentFilter;
    @Inject
    NetworkChangeReceiver networkChangeReceiver;
    private AppComponent appComponent;

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
