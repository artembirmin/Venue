package com.example.venue.business.repositories.auth;

import com.example.venue.data.network.auth.AuthorizationApi;
import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static final String TAG = "AuthorizationApiProvider";
    AuthorizationApi authorizationApi;
    private Retrofit retrofit;

    public AuthorizationRepositoryImpl(AuthorizationApi authorizationApi) {
        this.authorizationApi = authorizationApi;
    }

    @Override
    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return authorizationApi.sendVerificationCode(sendCodeRequest);
    }
}
