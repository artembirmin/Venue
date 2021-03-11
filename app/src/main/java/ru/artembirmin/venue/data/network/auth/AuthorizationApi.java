package ru.artembirmin.venue.data.network.auth;

import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationApi {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
