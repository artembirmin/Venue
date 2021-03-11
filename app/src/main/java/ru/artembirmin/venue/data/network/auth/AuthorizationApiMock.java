package ru.artembirmin.venue.data.network.auth;

import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public class AuthorizationApiMock implements AuthorizationApi {

    @Override
    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return Single.just(new SendCodeResponse("Ok", (int) (Math.random() * 10000)));
    }
}
