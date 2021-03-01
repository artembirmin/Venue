package com.example.venue.presentation.userstories.auth.inputemail.interactor;


import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public interface InputEmailInteractor {

    Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest);
}
