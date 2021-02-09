package com.example.venue.domain.inputemail;


import com.example.venue.data.repositories.auth.AuthorizationRepository;
import com.example.venue.models.SendCodeRequest;
import com.example.venue.models.SendCodeResponse;

import io.reactivex.Single;

public class InputEmailInteractorImpl implements InputEmailInteractor {

    AuthorizationRepository repository;

    public InputEmailInteractorImpl(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return repository.sendVerificationCode(sendCodeRequest);
    }
}
