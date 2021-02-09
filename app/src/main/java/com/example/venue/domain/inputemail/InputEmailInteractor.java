package com.example.venue.domain.inputemail;


import com.example.venue.models.SendCodeRequest;
import com.example.venue.models.SendCodeResponse;

import io.reactivex.Single;

public interface InputEmailInteractor {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
