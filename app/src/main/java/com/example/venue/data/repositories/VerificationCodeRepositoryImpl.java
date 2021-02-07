package com.example.venue.data.repositories;

import com.example.venue.data.network.backendmodel.BackendModelApi;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class VerificationCodeRepositoryImpl implements VerificationCodeRepository {

    private static final String TAG = "BackendModelApiProvider";
    private Retrofit retrofit;
    BackendModelApi BackendApi;

    public VerificationCodeRepositoryImpl(BackendModelApi BackendApi) {
        this.BackendApi = BackendApi;
    }

    @Override
    public Single<Boolean> getWeather(double lat, double lon) {
        return null;
    }
}
