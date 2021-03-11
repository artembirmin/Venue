package com.example.venue.presentation.userstories.auth.inputemail.interactor;


import com.example.venue.business.repositories.auth.AuthorizationRepository;
import com.example.venue.models.net.SendCodeRequest;
import com.example.venue.models.net.SendCodeResponse;

import io.reactivex.Single;

public class InputEmailInteractorImpl implements InputEmailInteractor {

    private final AuthorizationRepository repository;

    public InputEmailInteractorImpl(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public Single<SendCodeResponse> sendVerificationCode(SendCodeRequest sendCodeRequest) {
        return repository.sendVerificationCode(sendCodeRequest);
    }
}
