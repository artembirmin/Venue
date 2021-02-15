package com.example.venue;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;

import com.example.venue.data.network.connection.NetworkChangeReceiver;
import com.example.venue.di.app.AppComponent;
import com.example.venue.di.app.AppModule;
import com.example.venue.di.app.DaggerAppComponent;

import javax.inject.Inject;

import io.reactivex.subjects.BehaviorSubject;

public class App extends Application {

    private static final String TAG = "App";
    public static App instance;
    private AppComponent appComponent;

    @Inject
    IntentFilter intentFilter;
    @Inject
    NetworkChangeReceiver networkChangeReceiver;

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

    public NetworkChangeReceiver getNetworkChangeReciever(){
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
