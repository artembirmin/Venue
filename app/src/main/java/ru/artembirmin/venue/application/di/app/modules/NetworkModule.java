package ru.artembirmin.venue.application.di.app.modules;

import ru.artembirmin.venue.data.network.auth.AuthorizationApi;
import ru.artembirmin.venue.data.network.auth.AuthorizationApiMock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private final String WEATHER_API_KEY = "52890ff4987cf82ef04c79cccc4bd74c";
    private final String BASE_URL = "https://api.openweathermap.org/";

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @Singleton
    @Provides
    AuthorizationApi provideAuthorizationApi(Retrofit.Builder builder) {
        //return builder.build().create(AuthorizationApi.class);
        return new AuthorizationApiMock();
    }
}
