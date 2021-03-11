package ru.artembirmin.venue.data.network.auth;

import com.google.gson.Gson;

import javax.inject.Inject;

public class AuthorizationNetworkService implements AuthorizationApiProvider {

    private final AuthorizationApi authorizationApi;

    @Inject
    public AuthorizationNetworkService(Gson gson) { //TODO В di закинуть

        // authorizationApi = retrofit.create(AuthorizationApi.class);
        authorizationApi = new AuthorizationApiMock();
    }

    @Override
    public AuthorizationApi getAuthorizationApi() {
        return authorizationApi;
    }
}
