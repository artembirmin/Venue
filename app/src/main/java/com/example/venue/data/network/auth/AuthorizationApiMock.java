package com.example.venue.data.network.auth;

import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public class AuthorizationApiMock implements AuthorizationApi {

    @Override
    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return Single.just(new SendCodeResponse("Ok", (int) (Math.random()*10000)));
    }
}
