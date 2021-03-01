package com.example.venue.data.network.auth;

import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationApi {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
