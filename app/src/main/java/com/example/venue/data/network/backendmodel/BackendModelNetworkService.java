package com.example.venue.data.network.backendmodel;

import com.example.venue.data.repositories.VerificationCodeRepository;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendModelNetworkService implements BackendModelApiProvider {

    private BackendModelApi backendModelApi;

    @Inject
    public BackendModelNetworkService(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(VerificationCodeRepository.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        backendModelApi = retrofit.create(BackendModelApi.class);
    }

    @Override
    public BackendModelApi getBackendModelApi() {
        return backendModelApi;
    }
}
