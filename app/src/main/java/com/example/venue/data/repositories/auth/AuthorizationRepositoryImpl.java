package com.example.venue.data.repositories.auth;

import com.example.venue.data.network.backendmodel.AuthorizationApi;
import com.example.venue.models.SendCodeRequest;
import com.example.venue.models.SendCodeResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static final String TAG = "BackendModelApiProvider";
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
