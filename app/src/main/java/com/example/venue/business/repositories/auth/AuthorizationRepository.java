package com.example.venue.business.repositories.auth;

import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationRepository {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
