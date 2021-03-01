package com.example.venue.data.network.auth;

import com.example.venue.business.repositories.auth.AuthorizationRepository;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthorizationNetworkService implements AuthorizationApiProvider {

    private final AuthorizationApi authorizationApi;

    @Inject
    public AuthorizationNetworkService(Gson gson) { //TODO В di закинуть
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AuthorizationRepository.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       // authorizationApi = retrofit.create(AuthorizationApi.class);
        authorizationApi = new AuthorizationApiMock();
    }

    @Override
    public AuthorizationApi getAuthorizationApi() {
        return authorizationApi;
    }
}
