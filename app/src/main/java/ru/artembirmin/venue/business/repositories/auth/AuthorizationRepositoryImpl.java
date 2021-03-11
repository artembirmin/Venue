package ru.artembirmin.venue.business.repositories.auth;

import ru.artembirmin.venue.data.network.auth.AuthorizationApi;
import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static final String TAG = "AuthorizationApiProvider";

    private final AuthorizationApi authorizationApi;

    public AuthorizationRepositoryImpl(AuthorizationApi authorizationApi) {
        this.authorizationApi = authorizationApi;
    }

    @Override
    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return authorizationApi.sendVerificationCode(sendCodeRequest);
    }
}
