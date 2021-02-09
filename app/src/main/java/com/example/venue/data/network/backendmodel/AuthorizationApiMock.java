package com.example.venue.data.network.backendmodel;

import com.example.venue.models.SendCodeRequest;
import com.example.venue.models.SendCodeResponse;

import io.reactivex.Single;

public class AuthorizationApiMock implements AuthorizationApi {

    @Override
    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return Single.just(new SendCodeResponse("Ok", (int) (Math.random()*10000)));
    }
}
