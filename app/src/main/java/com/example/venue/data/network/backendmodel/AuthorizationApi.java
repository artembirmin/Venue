package com.example.venue.data.network.backendmodel;

import com.example.venue.models.SendCodeRequest;
import com.example.venue.models.SendCodeResponse;

import io.reactivex.Single;

public interface AuthorizationApi {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
