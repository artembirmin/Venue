package ru.artembirmin.venue.business.repositories.auth;

import ru.artembirmin.venue.models.net.SendCodeRequest;
import ru.artembirmin.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationRepository {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
