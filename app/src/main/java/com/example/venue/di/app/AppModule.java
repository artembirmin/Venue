package com.example.venue.di.app;

import android.content.Context;
import android.content.IntentFilter;

import androidx.annotation.NonNull;

import com.example.venue.data.network.connection.NetworkChangeReceiver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.BehaviorSubject;

@Module
public class AppModule {
    private final Context appContext;

    public AppModule(@NonNull Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }

    @Provides
    @Singleton
    IntentFilter provideIntentFilter() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Provides
    @Singleton
    NetworkChangeReceiver provideNetworkChangeReceiver() {
        return new NetworkChangeReceiver(BehaviorSubject.create());
    }


}
